
<img width="609" alt="스크린샷 2024-03-25 오후 7 25 53" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/c8390512-292d-4c80-9189-a1e96c781777">

- LunchTrayScreen.kt 에서 enum 클래스를 생성합니다.

---

    enum class LunchTrayScreen(@StringRes val title: Int) {
        Start(title = R.string.app_name),
        Entree(title = R.string.choose_entree),
        SideDish(title = R.string.choose_side_dish),
        Accompaniment(title = R.string.choose_accompaniment),
        Checkout(title = R.string.order_checkout)
    }

---

<img width="639" alt="스크린샷 2024-03-25 오후 7 27 43" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/380f33cd-a933-4c2c-8455-41f52963054e">












