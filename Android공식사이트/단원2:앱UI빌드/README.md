

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

















    
