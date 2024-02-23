# 완성 화면

<img width="452" alt="스크린샷 2024-02-23 오후 12 33 30" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/04863291-aefe-4149-bf7b-07d1da2af185">

<https://developer.android.com/reference/android/support/v7/widget/RecyclerView.Adapter#onBindViewHolder(VH,%20int)>

리스트뷰보다 많이 사용하는 리사이클뷰를 실습해보았습니다.
1. 리스트 형식만들기
2. 프로필 함수 만들기 ( builder pattern )
3. 문서를 보면 리사이클뷰는 어댑터를 만들어줘야 한다고 써있다. 어댑터 만들기
4. 메인 레이아웃에 리스트형식 입혀주기.


## 1. list_item 만들기

<img width="478" alt="스크린샷 2024-02-23 오후 1 22 52" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/5201a4b5-0db8-436b-9f6a-dd3f722aacf3">

---

    <?xml version="1.0" encoding="utf-8"?>
    <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
    
        <androidx.constraintlayout.widget.ConstraintLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginStart="8dp"
            android:layout_marginTop="8dp"
            android:layout_marginEnd="8dp"
            android:layout_marginBottom="8dp"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent">
    
            <ImageView
                android:id="@+id/iv_profile"
                android:layout_width="60dp"
                android:layout_height="60dp"
                android:layout_marginStart="8dp"
                android:layout_marginTop="8dp"
                android:layout_marginBottom="8dp"
                app:layout_constraintBottom_toBottomOf="parent"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toTopOf="parent"
                app:srcCompat="@drawable/man" />
    
            <TextView
                android:id="@+id/tv_name"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginStart="24dp"
                android:layout_marginTop="8dp"
                android:layout_marginBottom="8dp"
                android:text="홍드로이드"
                android:textColor="#000000"
                android:textStyle="bold"
                app:layout_constraintBottom_toTopOf="@+id/tv_job"
                app:layout_constraintStart_toEndOf="@+id/iv_profile"
                app:layout_constraintTop_toTopOf="@+id/iv_profile" />
    
            <TextView
                android:id="@+id/tv_job"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginStart="24dp"
                android:layout_marginTop="8dp"
                android:layout_marginBottom="8dp"
                android:text="안드로이드 앱 개발자"
                android:textColor="#000000"
                android:textStyle="bold"
                app:layout_constraintBottom_toBottomOf="@+id/iv_profile"
                app:layout_constraintStart_toEndOf="@+id/iv_profile"
                app:layout_constraintTop_toBottomOf="@+id/tv_name" />
    
            <TextView
                android:id="@+id/tv_age"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginStart="24dp"
                android:text="27"
                android:textColor="#F44336"
                android:textStyle="bold"
                app:layout_constraintBottom_toBottomOf="@+id/tv_name"
                app:layout_constraintStart_toEndOf="@+id/tv_name"
                app:layout_constraintTop_toTopOf="@+id/tv_name" />
        </androidx.constraintlayout.widget.ConstraintLayout>
    </androidx.constraintlayout.widget.ConstraintLayout>

---

## 2. profiles 프로필 함수 만들기

---
    
    package com.jang.recyclerviewkt
    
    class Profiles (val gender : Int, val name: String, val age: Int, val job: String)

---


## 3. 어댑터 만들기


---

    class ProfileAdapter (val profileList: ArrayList<Profiles>) : RecyclerView.Adapter<ProfileAdapter.CustomViewHodler>()
    {
    
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileAdapter.CustomViewHodler {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
            return CustomViewHodler(view).apply {
                itemView.setOnClickListener {
                    val curPos : Int = adapterPosition
                    val profile: Profiles = profileList.get(curPos)
                    Toast.makeText(parent.context, "이름 : ${profile.name}\n나이 : ${profile.age}\n직업 : ${profile.job}", Toast.LENGTH_SHORT).show()
    
                }
            }
        }
    
        override fun onBindViewHolder(holder: ProfileAdapter.CustomViewHodler, position: Int) {
            holder.gender.setImageResource(profileList.get(position).gender)
            holder.name.text = profileList.get(position).name
            holder.age.text = profileList.get(position).age.toString()
            holder.job.text = profileList.get(position).job
        }
    
        override fun getItemCount(): Int {
            return profileList.size
        }
    
        class CustomViewHodler(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val gender = itemView.findViewById<ImageView>(R.id.iv_profile) //성별
            val name = itemView.findViewById<TextView>(R.id.tv_name)  //이름
            val age = itemView.findViewById<TextView>(R.id.tv_age)  //나이
            val job = itemView.findViewById<TextView>(R.id.tv_job)  //성별
        }
    
    
    
    }

---

## 4. 메인함수에서 메인레이아웃에 입히기

---

    class MainActivity : AppCompatActivity() {
    
        private lateinit var rv_profile : RecyclerView
    
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
    
            val rv_profile = findViewById<RecyclerView>(R.id.rv_profile)
    
            val profileList = arrayListOf(
                Profiles(R.drawable.man, "홍드로이드", 27, "안드로이드 앱 개발자"),
                Profiles(R.drawable.woman, "안드로이드", 27, "아이폰 앱 개발자"),
                Profiles(R.drawable.woman, "김드로이드", 27, "리액트드 앱 개발자"),
                Profiles(R.drawable.man, "신드로이드", 27, "유니티 앱 개발자"),
                Profiles(R.drawable.man, "이드로이드", 27, "알고리즘 앱 개발자"),
                Profiles(R.drawable.woman, "공드로이드", 27, "웹 앱 개발자"),
                Profiles(R.drawable.man, "찰드로이드", 27, "그냥 앱 개발자"),
                Profiles(R.drawable.woman, "고드로이드", 27, "배고픈 앱 개발자"),
                Profiles(R.drawable.man, "신드로이드", 27, "유니티 앱 개발자"),
                Profiles(R.drawable.man, "이드로이드", 27, "알고리즘 앱 개발자"),
                Profiles(R.drawable.woman, "공드로이드", 27, "웹 앱 개발자"),
                Profiles(R.drawable.man, "찰드로이드", 27, "그냥 앱 개발자"),
                Profiles(R.drawable.woman, "고드로이드", 27, "배고픈 앱 개발자")
            )
    
            rv_profile.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)
            rv_profile.setHasFixedSize(true)
    
            rv_profile.adapter = ProfileAdapter(profileList)
    
        }
    }

---



문서를 보았지만... 아직 혼자 문서만 보고 따라하기에는 벅찹니다... 더 많이 보고 따라하고 코드 리뷰하겠습니다.
이제 뭘 따라가고하는 정도만 이해했을뿐 혼자 작성을 힘겹게 느껴집니다. gpt의 도움으로는 가능하지만...
















