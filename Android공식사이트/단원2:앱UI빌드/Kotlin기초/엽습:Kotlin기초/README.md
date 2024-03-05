## 1. 시작하기 전에

## 2. 모바일 알림

<img width="800" alt="스크린샷 2024-03-05 오후 8 14 11" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/db5a82ce-611a-4489-ac26-aada92a8c41d">

---

    fun main() {
        val morningNotification = 51
        val eveningNotification = 135
    
        printNotificationSummary(morningNotification)
        printNotificationSummary(eveningNotification)
    }
    
    fun printNotificationSummary(numberOfMessages: Int) {
        if (numberOfMessages >= 100){
            println("Your phone is blowing up! You have 99+ notifications.")
        } else {
            println("You have $numberOfMessages notifications.")
        }
    }

---

## 3. 영화 티켓 가격

<img width="799" alt="스크린샷 2024-03-05 오후 8 20 44" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/23972247-0e66-4596-846d-db7d8a6d0d0b">

---

    fun main() {
        val child = 5
        val adult = 28
        val senior = 87
    
        val isMonday = true
    
        println("The movie ticket price for a person aged $child is \$${ticketPrice(child, isMonday)}.")
        println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
        println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}.")
    }
    
    fun ticketPrice(age: Int, isMonday: Boolean): Int {
        return when (age) {
            in 0..12 -> 15
            in 13..60 -> if (isMonday) 25 else 30
            in 61..100 -> 20
            else -> -1
        }
    }

---

## 4. 온도 변환기

<img width="800" alt="스크린샷 2024-03-05 오후 8 29 10" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/b5004295-ac95-4807-8578-a9e612f0ca8a">

---

    fun main() {
    	printFinalTemperature(27.0, "Celsius", "Fahrenheit") { 9.0 / 5.0 * it + 32 }
        printFinalTemperature(350.0, "Kelvin", "Celsius") { it - 273.15 }
        printFinalTemperature(10.0, "Fahrenheit", "Kelvin") { 5.0 / 9.0 * ( it - 32) + 273.15 }
    }
    
    fun printFinalTemperature(
        initialMeasurement: Double,
        initialUnit: String,
        finalUnit: String,
        conversionFormula: (Double) -> Double
    ) {
        val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
        println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
    }

---

## 5. 노래 카탈로그

<img width="796" alt="스크린샷 2024-03-05 오후 9 01 15" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/c6f53c07-c5f2-481f-a376-320e3742715e">

---

    fun main() {
        val SongSong = Song("asdf", "jang", 2024, 10000)
        SongSong.printDescription()
        println(SongSong.isPopular)
    }
    
    class Song(
    	val title: String,
        val artist: String,
        val yearPulished: Int,
        val playCount: Int
    ) {
        val isPopular: Boolean
        	get() = playCount >= 1000
        
        fun printDescription() {
            println("$title, 연주한 $artist, 출시한 $yearPulished")
        }
    }

---

## 6. 인터넷 프로필

<img width="797" alt="스크린샷 2024-03-05 오후 9 40 50" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/b5c6a874-a0c1-4a9d-8f61-60973b5f4608">

---

    fun main() {
        val amanda = Person("Amanda", 33, "play tennis", null)
        val atiqah = Person("Atiqah", 28, "climb", amanda)
    
        amanda.showProfile()
        atiqah.showProfile()
    }
    
    class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
        fun showProfile() {
           println("Name: $name")
           println("Age: $age")
           if (hobby != null) {
               print("Likes to $hobby.")
           }
           if (referrer != null) {
               print("Has a referrer named ${referrer.name}")
               if (referrer.hobby != null) {
                   print(", who likes to ${referrer.hobby}.")
               } else {
                   print(".")
               }
           } else {
               print(" Doesn't have a referrer.")
           }
           println()
           println()
        }
    }

---

## 7. 폴더블 스마트폰

이건 매우매우 어려웠다... 혼자 스스로 못했습니다.

<img width="798" alt="스크린샷 2024-03-05 오후 10 16 01" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/f0b4bd98-45a2-4906-a124-8b2134734c76">

--

    open class Phone(var isScreenLightOn: Boolean = false){
        open fun switchOn() {
            isScreenLightOn = true
        }
    
        fun switchOff() {
            isScreenLightOn = false
        }
    
        fun checkPhoneScreenLight() {
            val phoneScreenLight = if (isScreenLightOn) "on" else "off"
            println("The phone screen's light is $phoneScreenLight.")
        }
    }
    
    class FoldablePhone(var isFolded: Boolean = true): Phone() {
        override fun switchOn() {
            if (!isFolded) {
                isScreenLightOn = true
            }
        }
    
        fun fold() {
            isFolded = true
        }
    
        fun unfold() {
            isFolded = false
        }
    }
    
    fun main() {
        val newFoldablePhone = FoldablePhone()
    
        newFoldablePhone.switchOn()
        newFoldablePhone.checkPhoneScreenLight()
        newFoldablePhone.unfold()
        newFoldablePhone.switchOn()
        newFoldablePhone.checkPhoneScreenLight()
    }

---


## 8. 특별 경매

이것도 혼자 풀지 못했습니다.

<img width="788" alt="스크린샷 2024-03-05 오후 10 29 25" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/051673a7-3adf-45e4-8cd8-4d89da90bb12">

---

    fun main() {
        val winningBid = Bid(5000, "Private Collector")
    
        println("Item A is sold at ${auctionPrice(winningBid, 2000)}.")
        println("Item B is sold at ${auctionPrice(null, 3000)}.")
    }
    
    class Bid(val amount: Int, val bidder: String)
    
    fun auctionPrice(bid: Bid?, minimumPrice: Int): Int {
       return bid?.amount ?: minimumPrice
    }

---












