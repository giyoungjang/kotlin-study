
<img width="409" alt="스크린샷 2024-03-30 오후 3 55 34" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/514948e9-8fda-4942-a384-7b441b2b6580">

<img width="627" alt="스크린샷 2024-03-30 오후 7 54 00" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/2224e568-e8df-42a9-b56b-365e1fa3f15c">

---

    if (raceInProgress) {
        LaunchedEffect(playerOne, playerTwo) {
            coroutineScope {
                launch { playerOne.run() }
                launch { playerTwo.run() }
            }
            raceInProgress = false
        }
    }

---

<https://developer.android.com/codelabs/basic-android-kotlin-compose-coroutines-android-studio?authuser=1&hl=ko&continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-5-pathway-1%3Fauthuser%3D1%26hl%3Dko%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-coroutines-android-studio#8>
























