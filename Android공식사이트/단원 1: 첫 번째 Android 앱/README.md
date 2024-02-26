# Kotlin 소개

---
메시지 출력

![Uploading 스크린샷 2024-02-26 오후 8.18.57.png…]()

---
    
    fun main() {
        println("Use the val keyword when the value doesn't change.")
        println("Use the var keyword when the value can change.")
        println("When you define a function, you define the parameters that can be passed to it.")
        println("When you call a function, you pass arguments for the parameters.")
    }

---
컴파일 오류 수정

<img width="792" alt="스크린샷 2024-02-26 오후 8 22 48" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/08889d81-5c39-47ec-98c1-7b62431a9651">

---
    
    fun main() {
        println("New chat message from a friend")
    }
    
---
문자열 템플릿

<img width="793" alt="스크린샷 2024-02-26 오후 8 24 26" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/220ed178-cc45-4a1b-b08f-43acf1e5fb75">

---

    fun main() {
        var discountPercentage: Int = 0
        var offer: String = ""
        val item = "Google Chromecast"
        discountPercentage = 20
        offer = "Sale - Up to $discountPercentage% discount on $item! Hurry up!"
    
        println(offer)
    }

---
문자열 연결

<img width="799" alt="스크린샷 2024-02-26 오후 8 26 55" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/535d7e48-a632-47b8-83ec-ba42729f2716">

---

    fun main() {
        val numberOfAdults: Int = 20
        val numberOfKids: Int = 30
        var total = numberOfAdults + numberOfKids
        println("The total party size is: $total")
    }

---
메시지 서식

<img width="784" alt="스크린샷 2024-02-26 오후 8 30 23" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/4ccbf7d0-79fb-4e84-9ba5-c34ca64029a0">

---

    fun main() {
        val baseSalary: Int= 5000
        var bonusAmount: Int = 1000
        var totalSalary = baseSalary + bonusAmount
        println("Congratulations for your bonus! You will receive a total of $totalSalary (additional bonus).")
    }

---
기본적인 수학 연산 구현

<img width="800" alt="스크린샷 2024-02-26 오후 8 33 51" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/6c80c138-5b33-4ecb-8c8b-1f1b26b42cfa">
<img width="803" alt="스크린샷 2024-02-26 오후 8 34 04" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/66d42315-092d-49e6-959f-d0cef0e87c6b">

---

    fun main() {
        val firstNumber = 10
        val secondNumber = 5
        val result = firstNumber + secondNumber
    
        println("$firstNumber + $secondNumber = $result")
    }

---

    fun main() {
        val firstNumber = 10
        val secondNumber = 5
        val thirdNumber = 8
    
        val result = add(firstNumber, secondNumber)
        val anotherResult = add(firstNumber, thirdNumber)
    
        println("$firstNumber + $secondNumber = $result")
        println("$firstNumber + $thirdNumber = $anotherResult")
    }
    
    fun add(a: Int, b: Int): Int {
        return a + b
    }

---

    fun main() {
        val firstNumber = 10
        val secondNumber = 5
        val thirdNumber = 8
    
        val result1 = add(firstNumber, secondNumber)
        val anotherResult1 = add(firstNumber, thirdNumber)
    	val result2 = subtract(firstNumber, secondNumber)
    	val anotherResult2 = subtract(firstNumber, thirdNumber)
    
        
        println("$firstNumber + $secondNumber = $result1")
        println("$firstNumber + $thirdNumber = $anotherResult1")
    	println("$firstNumber - $secondNumber = $result2")
        println("$firstNumber - $thirdNumber = $anotherResult2")
    
    }
    
    fun add(a: Int, b: Int): Int {
        return a + b
    }
    
    fun subtract(a: Int, b: Int): Int {
        return a - b
    }

---
기본 매개변수

<img width="801" alt="스크린샷 2024-02-26 오후 8 43 08" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/d3f3775a-5a77-4115-acf3-dd5fef8da652">
<img width="803" alt="스크린샷 2024-02-26 오후 8 43 24" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/d42249ea-74fd-47e4-9809-581121efd3b7">

---

    fun main() {
        val operatingSystem = "Chrome OS"
        val emailId = "sample@gmail.com"
    
        println(displayAlertMessage(operatingSystem, emailId))
    }
    
    fun displayAlertMessage(a: String, b: String): String {
        return "There\'s a new sign-in request on $a for your Google Account $b."
    
    }

---

    fun main() {
        val firstUserEmailId = "user_one@gmail.com"
    
        // The following line of code assumes that you named your parameter as emailId.
        // If you named it differently, feel free to update the name.
        println(displayAlertMessage(emailId = firstUserEmailId))
        println()
    
        val secondUserOperatingSystem = "Windows"
        val secondUserEmailId = "user_two@gmail.com"
    
        println(displayAlertMessage(secondUserOperatingSystem, secondUserEmailId))
        println()
    
        val thirdUserOperatingSystem = "Mac OS"
        val thirdUserEmailId = "user_three@gmail.com"
    
        println(displayAlertMessage(thirdUserOperatingSystem, thirdUserEmailId))
        println()
    }
    
    fun displayAlertMessage(operatingSystem: String = "Unknown OS", emailId: String): String {
        return "There\'s a new sign-in request on $operatingSystem for your Google Account $emailId."
    
    }

---

<img width="791" alt="스크린샷 2024-02-26 오후 9 00 49" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/4c952ebf-fe94-491d-b634-4e3418bfc21c">

---
만보계

    fun main() {
        val stepsWalked = 4000
        val caloriesBurned = cal(stepsWalked)
        println("Walking $stepsWalked steps burns $caloriesBurned calories")
    }
    
    fun cal(steps: Int): Double {
        val a = 0.04
        val total = steps * a
        return total
    }

---
두 숫자 비교

<img width="796" alt="스크린샷 2024-02-26 오후 9 16 22" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/30bccaef-1e86-4632-8f03-e255a782b460">

---

    fun main() {
    	val timeSpentToday = 300
        val timeSpentYesterday = 250
        
        println (spent(timeSpentToday, timeSpentYesterday))
        
       	val timeSpentToday2 = 300
        val timeSpentYesterday2 = 300
        
        println (spent(timeSpentToday2, timeSpentYesterday2))
        
        val timeSpentToday3 = 200
        val timeSpentYesterday3 = 220
        
        println (spent(timeSpentToday3, timeSpentYesterday3))
    }
    
    fun spent(timeSpentToday: Int, timeSpentYesterday: Int): Boolean {
        return timeSpentToday > timeSpentYesterday
    }

---
함수로 중복 코드 이동

<img width="799" alt="스크린샷 2024-02-26 오후 9 25 49" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/1790e83e-5bb6-4564-94db-796cb3b9780f">

---

    fun main() {
    	a("Ankara", 27, 31, 82)
        a("Tokyo", 32, 36, 10)
        a("Cape Town", 59, 64, 2)
        a("Guatemala City", 50, 55, 7)
    }
    
    fun a(Cty: String, LTt: Int, HTt: Int, Cor: Int) {
        println("City: $Cty")
        println("Low temperature: $LTt, High temperature: $HTt")
        println("Chance of rain: $Cor%")
        println()
    }

---























