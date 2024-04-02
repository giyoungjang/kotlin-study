
<img width="635" alt="스크린샷 2024-03-31 오후 2 57 41" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/107ca3e6-4c9f-4ec9-8793-5bed6e01eb55">


<img width="441" alt="스크린샷 2024-03-31 오후 5 40 41" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/b39e4fa6-d26f-4d02-b17f-85161b1227ae">

MarsViewModel은 네트워크를 호출하여 화성 사진 데이터를 가져옵니다. 
ViewModel에서는 MutableState를 사용하여 데이터가 변경될 때 앱 UI를 업데이트합니다.

<img width="632" alt="스크린샷 2024-03-31 오후 6 05 30" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/5bf730f0-317a-4474-9abf-60e3af1a813e">

오늘날 대부분의 웹 서버는 REST(REpresentational State Transfer의 약자)라는 일반적인 스테이트리스(Stateless) 웹 아키텍처를 사용해 웹 서비스를 실행합니다. 
이 아키텍처를 제공하는 웹 서비스를 RESTful 서비스라고 합니다.

### 웹 서비스 요청

일반적인 HTTP 작업에는 다음이 포함됩니다.

- GET: 서버 데이터를 가져옵니다.
- POST: 서버에 새 데이터를 만듭니다.
- PUT: 서버에 있는 기존 데이터를 업데이트합니다.
- DELETE: 서버에서 데이터를 삭제합니다.

### Retrofit 라이브러리

Retrofit 라이브러리는 REST 백엔드와 통신합니다. 
Retrofit에서 코드를 생성하지만, Retrofit에 전달하는 매개변수에 따라 웹 서비스의 URI를 제공해야 합니다.

<img width="620" alt="스크린샷 2024-03-31 오후 6 21 00" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/04cf9d13-1fc7-45d9-a24d-0b4120b98d71">

## 요약

### REST 웹 서비스

- 웹 서비스는 인터넷을 통해 제공되는 소프트웨어 기반 기능으로, 앱은 이 기능을 사용하여 요청을 실행하고 데이터를 다시 가져올 수 있습니다.

- 일반적인 웹 서비스는 REST 아키텍처를 사용합니다. REST 아키텍처를 제공하는 웹 서비스를 RESTful 서비스라고 합니다. RESTful 웹 서비스는 표준 웹 구성요소 및 프로토콜을 사용하여 빌드됩니다.
- URI를 통해 표준화된 방법으로 REST 웹 서비스에 요청을 전송합니다.
- 웹 서비스를 사용하려면 앱은 네트워크 연결을 설정하고 서비스와 통신해야 합니다. 그런 다음 앱은 사용할 수 있는 형식으로 응답 데이터를 수신하고 파싱해야 합니다.
- Retrofit 라이브러리는 앱의 REST 웹 서비스 요청을 지원하는 클라이언트 라이브러리입니다.
- 변환기를 사용하여 웹 서비스에 전송하는 데이터와 웹 서비스에서 가져오는 데이터로 해야 할 일을 Retrofit에 알립니다. 예를 들어, ScalarsConverter는 웹 서비스 데이터를 String 또는 기타 프리미티브로 취급합니다.
- 앱이 인터넷에 연결할 수 있게 하려면 Android 매니페스트에 "android.permission.INTERNET" 권한을 추가합니다.
지연 초기화는 객체가 처음 사용되는 시점으로 객체 생성을 위임합니다. 객체가 아닌 참조를 생성합니다. 처음 객체를 액세스할 때 참조가 생성되고 그 후 액세스할 때마다 사용됩니다.




























