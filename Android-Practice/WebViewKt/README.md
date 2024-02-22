html 을 허용해줘서 앱 내에서 키는 기능을 구현했습니다.

이후에 앱이랑 웹이랑 통신 할 수 있는 브릿지통신 이외에 다른 세팅 방법도 다양한 방법을 공부해야합니다.

일단,

AndroidManifest.xml 에서 

---
    <manifest xmlns:android="http://schemas.android.com/apk/res/android"

        ...

        <!-- 인터넷 퍼미션 (권한) -->
        <uses-permission android:name="android.permission.INTERNET"/>

        <application

        ...

            android:usesCleartextTraffic="true"

        ... >
---

를 추가하여 허용을 해줘야합니다. 안드로이드가 보안이 강화되면서 추가 되었습니다.

MainActivity.kt 에서는 

---
class MainActivity : AppCompatActivity() {

    private lateinit var webView : WebView

    override fun onCreate(savedInstanceState: Bundle?) {

    ...

        webView = findViewById(R.id.webView)
        webView.settings.javaScriptEnabled = true // 자바 스크립트 허용
        /* 웹뷰에서 새 창이 뜨지 않도록 방지하는 구문 */
        webView.webViewClient = WebViewClient()
        webView.webChromeClient = WebChromeClient()
        /* 웹뷰에서 새창이 뜨지 않도록 방지하는 구문 */
        webView.loadUrl("https://www.naver.com")  // 링크 주소를 Load 함

    }

    override fun onBackPressed() {
        if(webView.canGoBack())
        { // 웹사이트에서 뒤로 갈 페이지가 존재 한다면..
            webView.goBack() // 웹사이트 뒤로가기
        }
        else
        {
            super.onBackPressed()  // 본래의 백버튼 기능 수행 ( 안드로이드 )

        }
    }
}

---

를 추가하면 됩니다.

만약 onBackPressed 를 하지 않는다면 앱이 꺼지는 기본 구조가 발생하게 됩니다.

이만!








    
