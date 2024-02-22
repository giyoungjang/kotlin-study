package com.jang.camerakt

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Button
import android.widget.Toast
import androidx.core.content.FileProvider
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import java.io.File
import java.security.Permission
import java.text.SimpleDateFormat
import java.util.Date

class MainActivity : AppCompatActivity() {

    val REQUEST_IMAGE_CAPTURE = 1 // 카메라 사진 촬영 요청코드
    lateinit var curPhotoPath: String // 문자열 형태의 사진 경로 값 ( 초기 값을 null로 시작하고 싶을 때 )

    private lateinit var btn_camera : Button
    private lateinit var iv_profile : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setPermission() //권한을 체크하는 메소드 수행.

        btn_camera = findViewById(R.id.btn_camera)
        btn_camera.setOnClickListener {
            takeCapture() // 기본 카메라 앱을 실행하여 사진 촬영.
        }


    }
    /*
    * 이미지 파일 생성
    */
    private fun createImageFile(): File {
        val timestamp: String = SimpleDateFormat("yyyyMMdd_HH").format(Date())
        val storageDir: File? = getExternalFilesDir((Environment.DIRECTORY_PICTURES))
        return File.createTempFile("JPEG_${timestamp}_", ".jpg",storageDir)
            .apply { curPhotoPath = absolutePath }

    }

    /*
         * 카메라 실행
         */
    private fun takeCapture() {
        // 기본 카메라 앱 실행
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                val photoFile: File? = try {
                    createImageFile()
                } catch (ex. IOExeption) {
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

    /*
    * 테드 퍼미션 설정
     */
    private fun setPermission() {
        val permission = object : PermissionListener {
            override fun onPermissionGranted() {   // 설정해놓은 위험권한들이 허용 되었을 경우 이 곳을 수행함.
                Toast.makeText(this@MainActivity, "권한이 허용 되었습니다.", Toast.LENGTH_SHORT).show()
            }

            override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {  // 설정해놓은 위험권한 들 중 거부를 한 경우 이곳을 수행한다.
                Toast.makeText(this@MainActivity, "권한이 거부 되었습니다.", Toast.LENGTH_SHORT).show()
            }
        }

        TedPermission.with(this)
            .setPermissionListener(permission)
            .setRationaleMessage("카메라 앱을 사용하시려면 권한을 허용해주세요.")
            .setDeniedMessa("권한을 거부하셨습니다. [앱 설정] -> [권한] 항목에서 허용해주세요.")
            .setPermissions(android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.CAMERA)
            .check()

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {  //startActivityForResult 를 통해서 기본 카메라 앱으로 가져온 결과 값
        super.onActivityResult(requestCode, resultCode, data)

        val iv_profile = findViewById(R.id.iv_profile)

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK){
            val bitmap: Bitmap
            val file = File(curPhotoPath)
            if (Build.VERSION.SDK_INT < 28) { //안드로이드 9.0 (Pie) 버젼보다 낮을 경우
                bitmap = MediaStore.Images.Media.getContentUri(contentResolver, Uri.fromFile(file))
                iv_profile.setImageBitmap(bitmap)

            } else { // 안드로이드 9.0 버전보다 높을 경우
                val decode = ImageDecoder.createSource(
                    this.contentResolver,
                    Uri.fromFile(file)
                )
                bitmap = ImageDecoder.decodeBitmap(bitmap)
                iv_profile.setImageBitmap(bitmap)
            }

            savePhoto(bitmap)


        }


    }

    /*
     * 갤러리에 저장
     */
    private fun savePhoto(bitmap: Bitmap) {
        val folderPath = Environment.getExternalStorageDirectory().absolutePath + "/Pictures/"  //사진폴더로 저장하기 위한 경로 선언
        val timestamp: String = SimpleDateFormat("yyyyMMdd_HH").format(Date())
        val fileName = "${timestamp},jpeg"
        val folder = File(folderPath)
        if(!folder.isDirectory) { // 현재 해당 경로에서 폴더가 존재하는지 않는다면
            folder.mkdir()  // make directory 줄임말로 해당 경로에 폴더 자동으로 새로 만들기

        }
        // 실제적인 저장처리
        val out = FileOutputStream(folderPath + fileName)
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out)
        Toast.makeText(this, "사진이 저장되었습니다", Toast.LENGTH_SHORT).show()

    }
}