
<img width="625" alt="스크린샷 2024-04-12 오후 4 01 58" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/793b761c-15da-4cb5-9933-a5959c68b952">

<img width="638" alt="스크린샷 2024-04-14 오후 4 26 41" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/4949b23a-d4c7-45d1-88c4-2f65e7f5362e">

## WorkManager가 적합한 작업

<img width="341" alt="스크린샷 2024-04-14 오후 4 33 27" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/49bbf2cc-5dd2-439f-ac9d-9181f12e8d9b">

## WorkManager 기본사항

- Worker/CoroutineWorker: worker는 백그라운드 스레드에서 동기식으로 작업을 실행하는 클래스입니다. 우리는 비동기 작업에 관심이 있으므로 Kotlin 코루틴과 상호 운용되는 CoroutineWorker를 사용할 수 있습니다. 이 앱에서는 CoroutineWorker 클래스에서 확장하고 doWork() 메서드를 재정의합니다. 백그라운드에서 실행하고자 하는 실제 작업의 코드를 이 메서드에 입력합니다.
- WorkRequest: 이 클래스는 작업 실행 요청을 나타냅니다. WorkRequest에서는 worker를 한 번 또는 주기적으로 실행해야 하는지 정의합니다. 제약 조건은 작업 실행 전에 특정 조건 충족을 요구하는 WorkRequest에 배치될 수도 있습니다. 한 가지 예는 요청된 작업을 시작하기 전에 기기를 충전하는 것입니다. WorkRequest를 만드는 과정에서 CoroutineWorker를 전달합니다.
- WorkManager: 이 클래스는 실제로 WorkRequest를 예약하고 실행합니다. 지정된 제약 조건을 준수하면서 시스템 리소스에 부하를 분산하는 방식으로 WorkRequest를 예약합니다.







