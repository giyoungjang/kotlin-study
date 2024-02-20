
<img width="358" alt="스크린샷 2024-02-19 오후 9 00 47" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/3fcfc671-0741-4fb4-acd6-dd7513c5c5c7">


xml 에서 textview 의 아이디를 tv_tile 로 지정을 하고
---
    <?xml version="1.0" encoding="utf-8"?>
    <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".MainActivity">
    
        <TextView
            android:id="@+id/tv_title"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="열공다방"
            android:textSize="34sp"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent" />
    </androidx.constraintlayout.widget.ConstraintLayout>
---

mainactivity 에서 

---
    tv_title.setText("Hello World..!")  //텍스트의 값을 변경한다.
---
를 이용하여 호출하려고 하였지만 tv_title 가 호출 되지 않았다.

구글링의 결과

---
    var tv_title = findViewById(R.id.tv_title) as TextView
    tv_title.setText("Hello World..!")  //텍스트의 값을 변경한다.
---

findViewById를 사용하니 호출이 되어 정상 작동하였다.
코틀린에서는 findViewById를 하지 않아도 된다고 공부를 하였는데 왜 저 구문을 넣어야 작동하는지는 좀 더 공부를 해봐야할 꺼 같다.






