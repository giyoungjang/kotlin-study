
## 소개

<img width="323" alt="스크린샷 2024-03-12 오후 9 50 41" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/f5a12782-1795-43ab-8fbc-766963eb1de6">

## Kotlin의 배열

Array 란
값이 두개 이상인 것

<img width="519" alt="스크린샷 2024-03-12 오후 9 52 13" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/e2f05a3a-b572-42e3-ac00-84d4edd04880">

색인은 8 부터 0으로 시작하여 두번째 6은 색인 1에 있습니다.

---

    fun main() {
        val rockPlanets = arrayOf<String>("Mercury", "Venus", "Earth", "Mars")
    	val gasPlanets = arrayOf("Jupiter", "Saturn", "Uranus", "Neptune")
    
    	val solarSystem = rockPlanets + gasPlanets
    
    	println(solarSystem[0])
    	println(solarSystem[1])
    	println(solarSystem[2])
    	println(solarSystem[3])
    	println(solarSystem[4])
    	println(solarSystem[5])
    	println(solarSystem[6])
    	println(solarSystem[7])
    }

---

    Mercury
    Venus
    Earth
    Mars
    Jupiter
    Saturn
    Uranus
    Neptune

---

### listOf() 함수

항목을 매개변수로 사용하지만 배열이 아닌 List 를 반환합니다.

---

    fun main() {
        val solarSystem = listOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    }
    
    println(solarSystem.size)

---

    8

---

### 목록의 요소에 액세스

---

    println(solarSystem[2])
    println(solarSystem.get(3))

---

    Earth
    Mars

---

이렇게도 출력이 가능한데 get() 는 Int를 매개변수로 사용하고 이 색인에 있는 요소를 반환합니다.

---

    println(solarSystem.indexOf("Earth"))
    println(solarSystem.indexOf("Pluto"))

---
    
    2
    -1

---

Pluto 와 일치하는 요소가 없으므로 -1이 출력됩니다.

### for 루프를 사용하여 목록 요소 반복

<img width="558" alt="스크린샷 2024-03-12 오후 10 20 55" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/ee08b0f8-9232-4099-8c13-9ef91ae60360">

---

    for (planet in solarSystem) {
        println(planet)
    }

---

    Mercury
    Venus
    Earth
    Mars
    Jupiter
    Saturn
    Uranus
    Neptune

---

### 목록에 요소 추가


1. listOf() 대신 mutableListOf()를 호출하도록 solarSystem의 초기화를 변경합니다. 이제 MutableList에 정의된 메서드를 호출할 수 있습니다.
---

    val solarSystem = mutableListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")

--
2. 명왕성을 행성으로 분류할 수도 있습니다. solarSystem에서 add() 메서드를 호출하여 "Pluto"를 단일 인수로 전달합니다.
---

    solarSystem.add("Pluto")

---
3. 일부 과학자들은 지구와 충돌하여 달을 형성하기 전에 테이아라는 행성이 존재했다고 설명합니다. "Earth"와 "Mars" 사이의 색인 3에 "Theia"를 삽입합니다.
---

    solarSystem.add(3, "Theia")

---

### 특정 색인의 요소 업데이트


1. 색인 3의 값을 "Future Moon"으로 업데이트합니다.
---

    solarSystem[3] = "Future Moon"

---
2. 아래 첨자 문법을 사용하여 색인 3과 9의 값을 출력합니다.
---
    
    println(solarSystem[3])
    println(solarSystem[9])

---
3. 코드를 실행하여 출력을 확인합니다.
---

    Future Moon
    Pluto

---

### 목록에서 요소 삭제

remove() 또는 removeAt() 메서드를 사용하여 삭제됩니다. 
remove() 메서드에 요소를 전달하거나 removeAt()을 사용하여 색인으로 요소를 삭제할 수 있습니다.

1. solarSystem에서 removeAt()을 호출하여 색인에 9를 전달합니다. 이렇게 하면 목록에서 "Pluto"가 삭제됩니다.
---

    solarSystem.removeAt(9)

---
2. solarSystem에서 remove()를 호출하여 "Future Moon"을 삭제할 요소로 전달합니다. 그러면 목록이 검색되고 일치하는 요소가 발견되면 삭제됩니다.
---

    solarSystem.remove("Future Moon")

---
3. List는 요소가 목록에 있는 경우 Boolean을 반환하는 contains() 메서드를 제공합니다. "Pluto"에 관해 contains()를 호출한 결과를 출력합니다.
---

    println(solarSystem.contains("Pluto"))

---
4. 좀 더 간결한 문법은 in 연산자를 사용하는 것입니다. 요소, in 연산자, 컬렉션을 사용하여 요소가 목록에 있는지 확인할 수 있습니다. in 연산자를 사용하여 solarSystem에 "Future Moon"이 포함되어 있는지 확인합니다.
---

    println("Future Moon" in solarSystem)

---
5. 코드를 실행합니다. 두 문 모두 false를 출력해야 합니다.
---

    false
    false

---

## 세트

세트는 특정 순서가 없고 중복 값을 허용하지 않는 컬렉션입니다.

### Kotlin에서 MutableSet 사용

1. MutableSet를 사용하여 요소를 추가하고 삭제하는 방법
---

    fun main() {
    	val solarSystem = mutableSetOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    	println(solarSystem.size)
      solarSystem.add("Pluto")
    	println(solarSystem.size)
    	println(solarSystem.contains("Pluto"))
    	solarSystem.add("Pluto")
    	println(solarSystem.size)
    	solarSystem.remove("Pluto")
    	println(solarSystem.size)
    	println(solarSystem.contains("Pluto"))
    }

---

set를 만들고 사이즈를 확인하였을때 8개입니다.
그리고 pluto를 추가하고서는 9개이며 다시 추가하더라도 같은 해쉬값이기에 추가가 되지않고 9개를 가지며 삭제했을때도 삭제가 되어 8개로 나타납니다.

## 맵 컬렉션

<img width="543" alt="스크린샷 2024-03-13 오후 3 04 47" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/9f345f6b-7ac6-42b4-a7c5-8dfbdd0a3e43">

<img width="521" alt="스크린샷 2024-03-13 오후 3 05 00" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/9eb62777-60ac-4590-8c04-a17b3829efaf">

---

    fun main() {
        val solarSystem = mutableMapOf(
     	   "Mercury" to 0,
        	"Venus" to 0,
    	    "Earth" to 1,
    	    "Mars" to 2,
    	    "Jupiter" to 79,
    	    "Saturn" to 82,
    	    "Uranus" to 27,
    	    "Neptune" to 14
    	)
        println(solarSystem.size)
        solarSystem["Pluto"] = 5
        println(solarSystem.size)
        println(solarSystem["Pluto"])
        println(solarSystem.get("Theia"))
        solarSystem.remove("Pluto")
        println(solarSystem.size)
        solarSystem["Jupiter"] = 78
      	println(solarSystem["Jupiter"])
    }

---

    8
    9
    5
    null
    8
    78

---

Pluto의 요소를 5를 추가하면 출력시 5가 나타나도 Theia 는 없으므로 null 이 출력된다.
remove로 제거하면 사이즈가 8로 줄어든 모습을 볼 수 있고, 맵핑을 78로 설정할 수 도있다














