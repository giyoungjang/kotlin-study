## 1. 권한

모든 내용은 구글링을 통해 참조하며, 따라하였습니다.

처음에 카메라 권한부분에서
<https://developer.android.com/reference/kotlin/android/Manifest.permission_group>

<img width="873" alt="스크린샷 2024-02-22 오후 5 34 02" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/8085dc90-fead-4407-a080-ec449aba0161">
- 권한 체크하기
<https://hanyeop.tistory.com/139>
를 참조하였습니다.

그러나 TedPermission 을 이용하면 위에 블로그 과정을 쉽게 처리할 수 있습니다.

<https://github.com/ParkSangGwon/TedPermission>
의 라이브러리를 사람들이 많이 사용하기도하고 편하게 정말 잘만들었다고 합니다. 여기서 최신 버전인 3.3.0을 사용할 예정입니다.

## 2. build.gradle
---
    dependencies {
    ...
        implementation("io.github.ParkSangGwon:tedpermission-normal:3.3.0")
    ...
    }
---
에 추가해줍니다. 

## 3. manifest 에서 
---
    <?xml version="1.0" encoding="utf-8"?>
    <manifest xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools">
    
        <!--  파일 쓰기 권한  -->
        <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
        <!--  파일 읽기 권한  -->
        <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
        <!--  카메라 권한  -->
        <uses-permission android:name="android.permission.CAMERA"/>
        <!--  카메라 기능 사용  -->
        <uses-feature android:name="android.hardware.camera" android:required="true"/>
    
        ...
---
- 카메라 권한과 읽기 쓰기를 저장소에서 사용할 수 있도록 해줍니다.

## 4. 화면 구성

<img width="311" alt="스크린샷 2024-02-22 오후 5 53 46" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/bf13aabc-c251-4748-8f47-1dfc9399f2d6">
---

    <?xml version="1.0" encoding="utf-8"?>
    <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".MainActivity">
    
        <Button
            android:id="@+id/btn_camera"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:text="카메라 촬영"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent" />
    
        <ImageView
            android:id="@+id/iv_profile"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            app:layout_constraintBottom_toTopOf="@+id/btn_camera"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            android:src="@drawable/ic_launcher_background" />
    </androidx.constraintlayout.widget.ConstraintLayout>
    
---


## 5. 파일 공유 설정

<https://developer.android.com/training/secure-file-sharing/setup-sharing?hl=ko>
공식문서에 따르면 보안핸들을 url 형식으로 제공해야하고 
개발자가 xml 에서 제공하는 사양에 맞춰 url 을 생성하는 구성요소가 FileProvider 입니다.


manifest에 추가해 줍니다
---

    <?xml version="1.0" encoding="utf-8"?>
    <manifest xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools">
    
        ...
    
            <application
        ...
                </activity>
    
                <provider
                    android:authorities="com.jang.camerakt.fileprovider"
                    android:name="androidx.core.content.FileProvider"
                    android:exported="false"
                    android:grantUriPermissions="true">
                    <meta-data android:name="android.support.FILE_PROVIDER_PATHS"
                        android:resource="@xml/file_paths"/>
    
            </provider>
    
        </application>
    
    </manifest>
    
---

- 여기서 <meta-data>란 공유하려는 directory를 지정하는 xml 파일입니다.
- 이제 공유 디렉토리를 생성합니다.
- res 폴더에서 xml 디렉토리 생성 후 파일 이름은 file_path

---
    
    <?xml version="1.0" encoding="utf-8"?>
    <paths xmlns:android="http://schemas.android.com/apk/res/android">
        <external-path
            name="my_images"
            path="Android/data/com.jang.camerakt/files/Pictures"/>
    </paths>

---

파일에 이렇게 생성하면 됩니다.

## 6. 권한 체크


 - 권한 체크 함수를 넣어줍니다.
---

    class MainActivity : AppCompatActivity() {
    
    ...
        override fun onCreate(savedInstanceState: Bundle?) {
            ...
    
            TedPermission.create()
                .setPermissionListener(permissionlistener)
                .setRationaleMessage("앱을 사용하려면, 접근 권한이 필요합니다.")
                .setDeniedMessage("카메라 권한이 거부되었습니다. 이를 다시 얻으려면, [설정] > [권한]으로 이동하세요.")
                .setPermissions(
                    Manifest.permission.CAMERA
                )
                .check()
    
             ...
    }         

---

permissionlistener를 정의해줍니다. (아래참조)

---

    private val permissionlistener: PermissionListener = object : PermissionListener {
        override fun onPermissionGranted() {
            Toast.makeText(
                this@MainActivity,
                "카메라 권한이 승인되었습니다.",
                Toast.LENGTH_SHORT
            ).show()
        }

        override fun onPermissionDenied(deniedPermissions: List<String>) {
            Toast.makeText(
                this@MainActivity,
                "카메라 권한이 거부되었습니다.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

---


---------------------------권한체크에서 가독성을 위해 합쳤습니다. ------
------기존 홍드로이드님이 하셨던 코드처럼
---


    private fun setPermission() {
        val permissionlistener: PermissionListener = object : PermissionListener {
            override fun onPermissionGranted() {
                Toast.makeText(this@MainActivity, "카메라 권한이 승인되었습니다.", Toast.LENGTH_SHORT).show()
            }

            override fun onPermissionDenied(deniedPermissions: List<String>) {
                Toast.makeText(this@MainActivity, "카메라 권한이 거부되었습니다.", Toast.LENGTH_SHORT).show()
            }
        }

        TedPermission.create()
            .setPermissionListener(permissionlistener)
            .setRationaleMessage("앱을 사용하려면, 접근 권한이 필요합니다.")
            .setDeniedMessage("카메라 권한이 거부되었습니다. 이를 다시 얻으려면, [설정] > [권한]으로 이동하세요.")
            .setPermissions(
                Manifest.permission.CAMERA
            )
            .check()
    }
    
---



## 7. 이미지 파일 생성


---

    private fun createImageFile(): File {
        val timestamp: String = SimpleDateFormat("yyyyMMdd_HH").format(Date())
        val storageDir: File? = getExternalFilesDir((Environment.DIRECTORY_PICTURES))
        return File.createTempFile("JPEG_${timestamp}_", ".jpg",storageDir)
            .apply { curPhotoPath = absolutePath }

    }
    
---


## 8. 카메라 실행


---
    private fun takeCapture() {
        // 기본 카메라 앱 실행
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                val photoFile: File? = try {
                    createImageFile()
                } catch (ex: IOException) {
                    null
                }

                photoFile?.also {
                    val photoURI: Uri = FileProvider.getUriForFile(
                        this,
                        "com.jang.camerakt.fileprovider",
                        it
                    )
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                }
            }
        }
    }
---

## 9. 이미지를 앱으로 가져오도록 정의

---

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            val bitmap: Bitmap
            val file = File(curPhotoPath)
            if (Build.VERSION.SDK_INT < 28) { // 안드로이드 9.0 (Pie) 버전보다 낮을 경우
                bitmap = MediaStore.Images.Media.getBitmap(contentResolver, Uri.fromFile(file))
                iv_profile.setImageBitmap(bitmap)
            } else { // 안드로이드 9.0 버전보다 높을 경우
                bitmap = ImageDecoder.decodeBitmap(
                    ImageDecoder.createSource(
                        contentResolver,
                        Uri.fromFile(file)
                    )
                )
                iv_profile.setImageBitmap(bitmap)
            }

            savePhoto(bitmap)
        }
    }

---

처음에 아래 처럼 하였을때는 오류가 발생하였으나 

---

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            val bitmap: Bitmap
            val file = File(curPhotoPath)
            if (Build.VERSION.SDK_INT < 28) { // 안드로이드 9.0 (Pie) 버전보다 낮을 경우
                bitmap = MediaStore.Images.Media.getBitmap(contentResolver, Uri.fromFile(file))
                iv_profile.setImageBitmap(bitmap)
            } else { // 안드로이드 9.0 버전보다 높을 경우
                bitmap = ImageDecoder.decodeBitmap(
                    ImageDecoder.createSource(
                        contentResolver,
                        Uri.fromFile(file)
                    )
                )
                iv_profile.setImageBitmap(bitmap)
            }

            savePhoto(bitmap)
        }
    }
----
몇 가지 수정으로 해결이 되었다.

## 10. 갤러리 저장


---

    private fun savePhoto(bitmap: Bitmap) {
        val folderPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).absolutePath
        val timestamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val fileName = "${timestamp}.jpeg"
        val folder = File(folderPath)

        if (!folder.exists()) { // 폴더가 없으면 생성
            folder.mkdirs()
        }

        val file = File(folder, fileName)
        try {
            val outputStream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
            outputStream.flush()
            outputStream.close()
            Toast.makeText(this, "사진이 저장되었습니다", Toast.LENGTH_SHORT).show()
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(this, "사진 저장에 실패했습니다", Toast.LENGTH_SHORT).show()
        }
    }

---



이로써 홍드로이드님의
' 안드로이드 코틀린 앱 만들기 #9 Camera ' 부분에서 실행되지 않았던 오류들을 해결할 수 있었습니다.
크게 되짚어보자면 Tedpermission 의 사용함수가 .with 에서 .create로 변하였고 앱으로 가져오는 부분에서도 코드가 일부 변경되었습니다.








