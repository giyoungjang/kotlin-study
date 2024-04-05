
- Room은 Android Jetpack의 일부인 지속성 라이브러리입니다. Room은 SQLite 데이터베이스 위에 있는 추상화 레이어입니다.
  
<img width="398" alt="스크린샷 2024-04-04 오후 3 02 05" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/780872a3-fe9e-443a-8963-27f042a65bf7">

<img width="623" alt="스크린샷 2024-04-04 오후 3 03 18" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/dad5c711-6332-4b5b-85f2-e45a22801eac">

- Room 항목은 앱 데이터베이스의 테이블을 나타냅니다. 이를 사용하여 테이블의 행에 저장된 데이터를 업데이트하고 삽입할 새 행을 만듭니다.
- Room DAO는 앱이 데이터베이스에서 데이터를 검색, 업데이트, 삽입, 삭제하는 데 사용하는 메서드를 제공합니다.
- Room Database 클래스는 앱에 해당 데이터베이스와 연결된 DAO 인스턴스를 제공하는 데이터베이스 클래스입니다.

<img width="571" alt="스크린샷 2024-04-04 오후 4 28 54" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/506c6b58-d157-474b-bbb9-1b4df01eb0e3">

Room 라이브러리는 SQL 문을 작성하지 않고도 간단한 삽입, 삭제, 업데이트를 실행하는 메서드를 정의할 수 있도록 @Insert, @Delete, @Update와 같은 편의성 주석을 제공합니다.
좀 더 복잡한 삽입, 삭제, 업데이트 작업을 정의해야 하거나 데이터베이스의 데이터를 쿼리해야 하는 경우에는 @Query 주석을 사용하세요.


요약
---

테이블을 @Entity 주석이 달린 데이터 클래스로 정의합니다. @ColumnInfo 주석이 달린 속성을 테이블의 열로 정의합니다.
데이터 액세스 객체(DAO)를 @Dao 주석이 달린 인터페이스로 정의합니다. DAO는 Kotlin 함수를 데이터베이스 쿼리에 매핑합니다.
주석을 사용하여 @Insert, @Delete, @Update 함수를 정의합니다.
SQLite 쿼리 문자열과 함께 @Query 주석을 다른 쿼리의 매개변수로 사용합니다.
Database Inspector를 사용하여 Android SQLite 데이터베이스에 저장된 데이터를 확인합니다.

---









