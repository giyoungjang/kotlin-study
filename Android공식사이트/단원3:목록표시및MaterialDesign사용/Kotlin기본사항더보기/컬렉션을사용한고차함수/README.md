
## 소개

<img width="555" alt="스크린샷 2024-03-13 오후 4 29 51" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/e3186e24-0abf-4185-bade-c5d099fb3831">

## forEach() 및 람다를 사용한 문자열 템플릿

---

    class Cookie(
        val name: String,
        val softBaked: Boolean,
        val hasFilling: Boolean,
        val price: Double
    )
    
    val cookies = listOf(
        Cookie(
            name = "Chocolate Chip",
            softBaked = false,
            hasFilling = false,
            price = 1.69
        ),
        Cookie(
            name = "Banana Walnut",
            softBaked = true,
            hasFilling = false,
            price = 1.49
        ),
        Cookie(
            name = "Vanilla Creme",
            softBaked = false,
            hasFilling = true,
            price = 1.59
        ),
        Cookie(
            name = "Chocolate Peanut Butter",
            softBaked = false,
            hasFilling = true,
            price = 1.49
        ),
        Cookie(
            name = "Snickerdoodle",
            softBaked = true,
            hasFilling = false,
            price = 1.39
        ),
        Cookie(
            name = "Blueberry Tart",
            softBaked = true,
            hasFilling = true,
            price = 1.79
        ),
        Cookie(
            name = "Sugar and Sprinkles",
            softBaked = false,
            hasFilling = false,
            price = 1.39
        )
    )
    
    fun main() {
    
    }

---

### forEach() 로 목록 반복

---

    class Cookie(
        val name: String,
        val softBaked: Boolean,
        val hasFilling: Boolean,
        val price: Double
    )
    
    val cookies = listOf(
        Cookie(
            name = "Chocolate Chip",
            softBaked = false,
            hasFilling = false,
            price = 1.69
        ),
        Cookie(
            name = "Banana Walnut",
            softBaked = true,
            hasFilling = false,
            price = 1.49
        ),
        Cookie(
            name = "Vanilla Creme",
            softBaked = false,
            hasFilling = true,
            price = 1.59
        ),
        Cookie(
            name = "Chocolate Peanut Butter",
            softBaked = false,
            hasFilling = true,
            price = 1.49
        ),
        Cookie(
            name = "Snickerdoodle",
            softBaked = true,
            hasFilling = false,
            price = 1.39
        ),
        Cookie(
            name = "Blueberry Tart",
            softBaked = true,
            hasFilling = true,
            price = 1.79
        ),
        Cookie(
            name = "Sugar and Sprinkles",
            softBaked = false,
            hasFilling = false,
            price = 1.39
        )
    )
    
    fun main() {
        cookies.forEach {
            println("Menu item: ${it.name}")
        }
    }

---

    Menu item: Chocolate Chip
    Menu item: Banana Walnut
    Menu item: Vanilla Creme
    Menu item: Chocolate Peanut Butter
    Menu item: Snickerdoodle
    Menu item: Blueberry Tart
    Menu item: Sugar and Sprinkles

---
            
println("Menu item: ${it.name}") 이부분에서 $it.name 만하게 된다면 name의 속성값이 출력되지 않습니다.

## map()

---

    class Cookie(
        val name: String,
        val softBaked: Boolean,
        val hasFilling: Boolean,
        val price: Double
    )
    
    val cookies = listOf(
        Cookie(
            name = "Chocolate Chip",
            softBaked = false,
            hasFilling = false,
            price = 1.69
        ),
        Cookie(
            name = "Banana Walnut",
            softBaked = true,
            hasFilling = false,
            price = 1.49
        ),
        Cookie(
            name = "Vanilla Creme",
            softBaked = false,
            hasFilling = true,
            price = 1.59
        ),
        Cookie(
            name = "Chocolate Peanut Butter",
            softBaked = false,
            hasFilling = true,
            price = 1.49
        ),
        Cookie(
            name = "Snickerdoodle",
            softBaked = true,
            hasFilling = false,
            price = 1.39
        ),
        Cookie(
            name = "Blueberry Tart",
            softBaked = true,
            hasFilling = true,
            price = 1.79
        ),
        Cookie(
            name = "Sugar and Sprinkles",
            softBaked = false,
            hasFilling = false,
            price = 1.39
        )
    )
    
    fun main() {
        val fullMenu = cookies.map {
            "${it.name} - $${it.price}"
        }
        println("Full menu:")
        fullMenu.forEach {
            println(it)
        }
    }

---

    Full menu:
    Chocolate Chip - $1.69
    Banana Walnut - $1.49
    Vanilla Creme - $1.59
    Chocolate Peanut Butter - $1.49
    Snickerdoodle - $1.39
    Blueberry Tart - $1.79
    Sugar and Sprinkles - $1.39

---

## filter()

---

    fun main() {
        val softBakedMenu = cookies.filter {
            it.softBaked
        }
        println("Soft cookies:")
    	softBakedMenu.forEach {
    	    println("${it.name} - $${it.price}")
    	}
    }

---

    Soft cookies:
    Banana Walnut - $1.49
    Snickerdoodle - $1.39
    Blueberry Tart - $1.79

---

filter 는 속성에서 true 인지를 확인하고 출력하게 됩니다.

## groupBy()

---

    fun main() {
        val groupedMenu = cookies.groupBy { it.softBaked }
    	val softBakedMenu = groupedMenu[true] ?: listOf()
    	val crunchyMenu = groupedMenu[false] ?: listOf()
        
        
        println("Soft cookies:")
    	softBakedMenu.forEach {
    	    println("${it.name} - $${it.price}")
    	}
    	println("Crunchy cookies:")
    	crunchyMenu.forEach {
    	    println("${it.name} - $${it.price}")
    	}
    }

---

변수를 groupedMenu 의 true와 false 에 따라서 그룹을 묶어주고 따로 출력이 가능합니다.

## fold()

<img width="555" alt="스크린샷 2024-03-13 오후 8 38 42" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/4edbeec3-35a3-42bf-aa34-8f21ac958e2b">

주로 총가격을 계산하거나 목록의 모든 요소를 합산하여 평균을 구하는 등의 작어베 가장 많이 사용됩니다.

---

    fun main() {
        val totalPrice = cookies.fold(0.0) { total, cookie ->
            total + cookie.price
        }
        println("Total price: $${totalPrice}")
    }

---

    Total price: $10.83

---

## sortedBy()

<img width="536" alt="스크린샷 2024-03-13 오후 9 50 43" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/6295a52c-8505-4bca-b23c-8c94b276253f">

---

    fun main() {
        val alphabeticalMenu = cookies.sortedBy {
            it.name
        }
        println("Alphabletical Menu:")
        alphabeticalMenu.forEach {
            println(it.name)
        }
    }

---

    Alphabletical Menu:
    Banana Walnut
    Blueberry Tart
    Chocolate Chip
    Chocolate Peanut Butter
    Snickerdoodle
    Sugar and Sprinkles
    Vanilla Creme

---

알파벳도 정렬이 가능합니다.


























