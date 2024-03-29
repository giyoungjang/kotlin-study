
<img width="510" alt="스크린샷 2024-03-27 오후 5 45 05" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/715183cc-315b-402d-90f8-131b850784bd">

## 동기 코드

---

    fun main() {
        println("Weather forecast")
        println("Sunny")
    }

---

### 지연 추가

--- 

    import kotlinx.coroutines.*
    
    fun main() {
        println("Weather forecast")
        delay(1000)
        println("Sunny")
    }

---

이렇게 할 시에는 컴파일러 오류가 발생합니다.

runBlocking()은 다시 시작할 준비가 되면 각 태스크를 중단된 지점에서 계속 진행하여 여러 태스크를 한 번에 처리할 수 있는 이벤트 루프를 실행합니다.

---

    import kotlinx.coroutines.*
    
    fun main() {
        runBlocking {
            println("Weather forecast")
            delay(1000)
            println("Sunny")
        }
    }

---

코루틴은 delay() 호출에 도달하면 정지됩니다. 
코루틴이 정지되면 1초 동안 다른 작업(이 프로그램에서는 다른 작업이 없지만)을 실행할 수 있습니다. 
지연 시간이 경과하면 코루틴이 실행을 다시 시작하고 계속해서 Sunny를 출력할 수 있습니다.

### 정지 함수

--- 

    import kotlinx.coroutines.*
    
    fun main() {
        runBlocking {
            println("Weather forecast")
            printForecast()
        }
    }
    
    suspend fun printForecast() {
        delay(1000)
        println("Sunny")
    }

---

## 비동기 코드

### launch()

이전에는 printForecast() 정지 함수가 완전히 완료될 때까지 기다려야 printTemperature() 함수로 이동할 수 있었습니다. 이제 printForecast()와 printTemperature()가 별개의 코루틴에 있으므로 동시에 실행할 수 있습니다.

<img width="508" alt="스크린샷 2024-03-28 오후 3 23 00" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/cdbcf713-75bf-4cb1-874f-618f94b95323">

---
    
    ...
    
    fun main() {
        runBlocking {
            println("Weather forecast")
            launch {
                printForecast()
            }
            launch {
                printTemperature()
            }
            println("Have a good day!")
        }
    }
    
    ...

---

    Weather forecast
    Have a good day!
    Sunny
    30°C

---

이 출력에서 printForecast() 및 printTemperature()의 새 코루틴 두 개가 실행된 후 Have a good day!를 출력하는 다음 명령을 진행할 수 있음을 볼 수 있습니다. 
이는 launch()의 'fire-and-forget' 특성을 보여줍니다. 
다시 말해 launch()로 새 코루틴을 실행한 후 작업이 언제 완료될지 걱정할 필요가 없습니다.

### async()

---
    
    import kotlinx.coroutines.*
    
    fun main() {
        runBlocking {
            println("Weather forecast")
            val forecast: Deferred<String> = async {
                getForecast()
            }
            val temperature: Deferred<String> = async {
                getTemperature()
            }
            println("${forecast.await()} ${temperature.await()}")
            println("Have a good day!")
        }
    }
    
    suspend fun getForecast(): String {
        delay(1000)
        return "Sunny"
    }
    
    suspend fun getTemperature(): String {
        delay(1000)
        return "30\u00b0C"
    }

---

### 병렬 분해

---

    import kotlinx.coroutines.*
    
    fun main() {
        runBlocking {
            println("Weather forecast")
            println(getWeatherReport())
            println("Have a good day!")
        }
    }
    
    suspend fun getWeatherReport() = coroutineScope {
        val forecast = async { getForecast() }
        val temperature = async { getTemperature() }
        "${forecast.await()} ${temperature.await()}"
    }
    
    suspend fun getForecast(): String {
        delay(1000)
        return "Sunny"
    }
    
    suspend fun getTemperature(): String {
        delay(1000)
        return "30\u00b0C"
    }

---

## 예외 및 취소




















