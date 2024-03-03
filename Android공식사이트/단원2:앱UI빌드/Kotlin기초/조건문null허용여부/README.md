

 ## 조건문 작성
  
if / else
when


    if (
    ) else if (
    ) else (
    )



    fun main() {
        val x = 3
    
        when (x) {
            2, 3, 5, 7 -> println("x is a prime number between 1 and 10.")
            in 1..10 -> println("x is a number between 1 and 10, but not a prime number.")
            else -> println("x isn't a prime number between 1 and 10.")
        }
    }



    fun main() {
        val x: Any = 20
    
        when (x) {
            2, 3, 5, 7 -> println("x is a prime number between 1 and 10.")
            in 1..10 -> println("x is a number between 1 and 10, but not a prime number.")
            is Int -> println("x is an integer number, but not between 1 and 10.")
            else -> println("x isn't an integer number.")
        }
    }



    fun main() {
        val trafficLightColor = "Black"
    
        val message =
          if (trafficLightColor == "Red") "Stop"
          else if (trafficLightColor == "Yellow") "Slow"
          else if (trafficLightColor == "Green") "Go"
          else "Invalid traffic-light color"
    
        println(message)
    }


    fun main() {
        val trafficLightColor = "Amber"
    
        val message = when(trafficLightColor) {
            "Red" -> "Stop"
            "Yellow", "Amber" -> "Proceed with caution."
            "Green" -> "Go"
            else -> "Invalid traffic-light color"
        }
        println(message)
    }


## null 허용 여부 사용


    fun main() {
        var number: Int? = 10
        println(number)
    
        number = null
        println(number)
    }


그러나 

    fun main() {
        var favoriteActor: String? = "Sandra Oh"
        println(favoriteActor.length)
    }

이렇게 하면 호출되지않고 오류가 발생한다.

    fun main() {
        var favoriteActor: String? = "Sandra Oh"
        println(favoriteActor?.length)
    }

이렇게 ?.을 하게되면 오류가 발생하지 않는다. null을 임시허용해준다.

    fun main() {
        var favoriteActor: String? = "Sandra Oh"
        println(favoriteActor!!.length)
    }

이렇게 하면 오류가 없다.

    fun main() {
        var favoriteActor: String? = null
        println(favoriteActor!!.length)
    }

이러면 오류 발생!!
null이 아님이 확실하지 않다면 null이 아닌 !! 어설션 연산자를 사용하지 않는 것이 좋습니다.
















    
