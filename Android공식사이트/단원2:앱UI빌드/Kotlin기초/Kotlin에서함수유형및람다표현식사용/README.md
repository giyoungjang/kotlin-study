## 1. 소개

## 2. 영상

## 3. 변수에 함수 저장

- main() 함수 다음에 매개변수와 반환 값이 없으며 "No treats!"를 출력하는 trick() 함수를 정의합니다. 이 문법은 이전 Codelab에서 본 다른 함수의 문법과 동일합니다.

---

    fun main() {
    
    }
    
    fun trick() {
        println("No treats!")
    }

---

- main() 함수의 본문에서 trickFunction이라는 변수를 만들고 trick과 같게 설정합니다. 함수를 호출하지 않고 함수를 변수에 저장하려 하기 때문에 trick 다음에 괄호를 사용하지 않습니다.

---

    fun main() {
        val trickFunction = trick
    }
    
    fun trick() {
        println("No treats!")
    }

---

- 하지만 오류가 발생합니다
- 함수 값을 참조하려면 함수 참조 연산자(::)를 사용해야 합니다.
<img width="536" alt="스크린샷 2024-03-05 오후 6 18 58" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/07cbd09b-1235-4dc1-9036-d0615b1cdd02">

---

    fun main() {
        val trickFunction = ::trick
    }
    
    fun trick() {
        println("No treats!")
    }

---

- 이렇게 할 경우에는 trickFunction이 사용되지 않았다고 경고가 발생합니다.
- 할당 연산자 (=) 앞에 val 또는 var 키워드를 추가하고 그 뒤에 함수를 호출할 때 사용하는 변수 이름을 추가합니다.

<img width="522" alt="스크린샷 2024-03-05 오후 6 26 33" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/0df1c688-4f55-4ab7-b92e-c75c2c617b3a">

그리고 함수 이름이 아닌 변수를 참조하므로 :: 를 삭제합니다.
그런다음 trick()를 호출해줍니다.

trickFunction도 함수인 것처럼 호출합니다
---

    fun main() {
        val trickFunction = trick
        trick()
        trickFunction()

    }
    
    val trick = {
        println("No treats!")
    }

---

## 4. 함수를 데이터 유형으로 사용

<img width="542" alt="스크린샷 2024-03-05 오후 6 34 58" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/3dcacbfc-d706-41eb-8981-bd42a31f4081">

- 함수 매개변수의 유형이나 반환 유형을 지정하려면 함수 유형을 표현하기 위한 문법을 알아야 합니다.
- 함수 유형은 선택적 매개변수 목록, -> 기호, 반환 유형이 포함된 괄호 쌍으로 구성됩니다.

- trick 변수의 데이터 유형은 () -> Unit 입니다. 매개변수가 없으므로 괄호가 비어 있습니다. 그리고 아무것도 반환하지 않으므로 반환 유형은 Unit입니다.


---

    fun main() {
        val trickFunction = trick
        trick()
        trickFunction()
        treat()
    }
    
    val trick = {
        println("No treats!")
    }
    
    val treat: () -> Unit = {
        println("Have a treat!")
    }

---
    
    No treats!
    No treats!
    Have a treat!

---

### 함수를 반환 유형으로 사용

- 함수가 데이터 유형이므로 다른 데이터 유형처럼 함수를 사용할 수 있습니다. 다른 함수에서 반환도 할 수 있습니다.

<img width="556" alt="스크린샷 2024-03-05 오후 6 41 35" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/ceb67fe6-eb6a-427e-945e-30ace65351fe">

- main() 함수에서 코드를 삭제합니다.
- main() 함수 다음에 Boolean 유형의 isTrick 매개변수를 허용하는 trickOrTreat() 함수를 정의합니다.
- trickOrTreat() 함수의 본문에서 isTrick이 true이면 trick() 함수를 반환하고 isTrick이 false이면 treat() 함수를 반환하는 if 문을 추가합니다.
- main() 함수에서 treatFunction이라는 변수를 만들어 trickOrTreat() 호출 결과에 할당한 다음 isTrick 매개변수에 관한 false를 전달합니다. 그런 다음 trickFunction이라는 두 번째 변수를 만들어 trickOrTreat() 호출 결과에 할당한 다음 이번에는 isTrick 매개변수에 관한 true를 전달합니다.
- 그다음 줄에서 treatFunction()을 호출한 후 trickFunction()을 호출합니다.
- 코드를 실행합니다. 다음과 같이 각 함수의 출력이 표시됩니다. trick() 또는 treat() 함수를 직접 호출하지는 않았지만 아직 그러한 변수를 호출할 수 있습니다. trickOrTreat() 함수를 호출할 때마다 반환 값을 저장했으며 trickFunction 및 treatFunction 변수를 사용하여 함수를 호출했기 때문입니다.

---

    fun main() {
    	val treatFunction = trickOrTreat(false)
    	val trickFunction = trickOrTreat(true)
        treatFunction()
        trickFunction()
    }
    
    fun trickOrTreat(isTrick: Boolean): () -> Unit {
        if (isTrick) {
            return trick
        } else {
            return treat
        }
    }
    
    val trick = {
        println("No treats!")
    }
    
    val treat = {
        println("Have a treat!")
    }

---

    Have a treat!
    No treats!

---

### 함수를 다른 함수에 인수로 전달

- trickOrTreat()가 매개변수로 사용하는 함수에도 자체 매개변수가 있어야 합니다.
- 각 매개변수의 데이터 유형을 쉼표로 구분하여 지정하기만 하면 됩니다.

<img width="543" alt="스크린샷 2024-03-05 오후 6 57 17" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/4598b099-749c-49dc-8944-d3beee5c231e">

- 매개변수를 취하는 함수를 람다 표현식으로 작성할 때는 발생 순서대로 이름을 지정하면 됩니다.

<img width="560" alt="스크린샷 2024-03-05 오후 7 19 03" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/886f9e99-d75b-4b2b-80ab-f9bbe1284725">

- 함수를 매개변수로 사용하도록 trickOrTreat() 함수를 업데이트합니다.
- isTrick 매개변수 다음에 (Int) -> String 유형의 extraTreat 매개변수를 추가합니다.
- else 블록의 return 문 앞에서 println()을 호출하고 extraTreat() 함수 호출을 전달합니다. 5를 extraTreat() 호출에 전달합니다.
- 이제 trickOrTreat() 함수를 호출할 때 람다 표현식으로 함수를 정의하고 extraTreat 매개변수에 전달해야 합니다. trickOrTreat() 함수를 호출하기 전에 main() 함수에서 coins() 함수를 추가합니다. coins() 함수는 Int 매개변수의 이름을 quantity로 지정하고 String을 반환합니다. 람다 표현식에 사용할 수 없는 return 키워드가 없음을 알 수 있습니다. 대신 함수의 마지막 표현식 결과가 반환 값이 됩니다.
- 다음과 같이 coins() 함수 다음에 cupcake() 함수를 추가합니다. Int 매개변수의 이름을 quantity로 지정하고 -> 연산자를 사용하여 함수 본문과 구분합니다. 이제 coins() 함수나 cupcake() 함수를 trickOrTreat() 함수에 전달할 수 있습니다.
- cupcake() 함수에서 quantity 매개변수와 -> 기호를 삭제합니다. 이러한 항목은 사용되지 않으므로 생략해도 됩니다.
- trickOrTreat() 함수 호출을 업데이트합니다. 첫 번째 호출의 경우 isTrick이 false이면 coins() 함수를 전달합니다. 두 번째 호출의 경우 isTrick이 true이면 cupcake() 함수를 전달합니다.
- 코드를 실행합니다. extraTreat() 함수는 isTrick 매개변수가 false 인수로 설정된 경우에만 호출되므로 출력에는 5 quarters가 포함되지만 cupcake는 포함되지 않습니다.

---

    fun main() {
        
        val coins: (Int) -> String = { quantity -> 
        	"$quantity quarters"
        }
        
        val cupcake: (Int) -> String = { 
        	"Have a cupcake!"
        }
        
    	val treatFunction = trickOrTreat(false, coins)
    	val trickFunction = trickOrTreat(true, cupcake)
        treatFunction()
        trickFunction()
    }
    
    fun trickOrTreat(isTrick: Boolean, extraTreat: (Int) -> String): () -> Unit {
        if (isTrick) {
            return trick
        } else {
            println(extraTreat(5))
            return treat
        }
    }
    
    val trick = {
        println("No treats!")
    }
    
    val treat = {
        println("Have a treat!")
    }

---

    5 quarters
    Have a treat!
    No treats!

---

### null을 허용하는 함수 유형

- null을 허용하려면 함수 유형을 괄호로 묶은 다음 닫는 괄호 밖에 ? 기호를 추가합니다.

<img width="573" alt="스크린샷 2024-03-05 오후 7 34 30" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/5fa6cedd-963f-4117-ac95-02960f7dcd19">

- trickOrTreat() 함수를 호출할 때마다 extraTreat() 함수를 제공할 필요가 없도록 extraTreat 매개변수에서 null을 허용하도록 설정합니다.
- extraTreat 매개변수의 유형을 (() -> String)?로 변경합니다.
- null이 아닌 경우에만 if 문을 사용하여 함수를 호출하도록 extraTreat() 함수 호출을 수정합니다. 이제 trickOrTreat() 함수는 다음 코드 스니펫과 같습니다.
- cupcake() 함수를 삭제하고, trickOrTreat() 함수의 두 번째 호출에서 cupcake 인수를 null로 바꿉니다.
- 코드를 실행합니다. 출력은 달라지지 않습니다. 이제 함수 유형을 null을 허용하는 것으로 선언할 수 있으므로 더 이상 extraTreat 매개변수를 위해 함수를 전달할 필요가 없습니다.

---

    fun main() {
        
        val coins: (Int) -> String = { quantity -> 
        	"$quantity quarters"
        }
        
    	val treatFunction = trickOrTreat(false, coins)
    	val trickFunction = trickOrTreat(true, null)
        treatFunction()
        trickFunction()
    }
    
    fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
        if (isTrick) {
            return trick
        } else {
            if (extraTreat != null) {
                println(extraTreat(5))
            }
            return treat
        }
    }
    
    val trick = {
        println("No treats!")
    }
    
    val treat = {
        println("Have a treat!")
    }

---

    5 quarters
    Have a treat!
    No treats!

---

## 5. 약식 문법으로 람다 표현식 작성

### 매개변수 이름 생략

<img width="557" alt="스크린샷 2024-03-05 오후 7 40 42" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/3c57bb62-9da7-4fca-9dcd-4a13dee45d41">

- coins() 함수에서 quantity 매개변수 이름과 -> 기호를 삭제합니다.
- $it를 사용하는 단일 매개변수를 참조하도록 "$quantity quarters" 문자열 템플릿을 변경합니다.
- 코드를 실행합니다. Kotlin은 Int 매개변수의 it 매개변수 이름을 인식하고 계속해서 동전(quarter) 수를 출력합니다.


---

    val coins: (Int) -> String = {
        "$it quarters"
    }

---

### 람다 표현식을 함수에 직접 전달

<img width="542" alt="스크린샷 2024-03-05 오후 7 45 34" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/ba835595-9dc2-4259-870b-dc1cd074ad91">

- coins 변수를 삭제할 수 있도록 코드를 수정합니다.
- 람다 표현식이 trickOrTreat() 함수 호출에 직접 전달되도록 람다 표현식을 이동합니다. 람다 표현식을 한 줄로 압축할 수도 있습니다.
- coins 변수는 더 이상 사용되지 않으므로 삭제합니다.

---

    fun main() {
    
    	val treatFunction = trickOrTreat(false, {"$it quarters"})
    	val trickFunction = trickOrTreat(true, null)
        treatFunction()
        trickFunction()
    }

---

### 후행 람다 문법 사용

<img width="540" alt="스크린샷 2024-03-05 오후 7 48 42" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/ffabb433-18c9-40f5-87c6-c7c5a603b2af">

- treatFunction 변수에서 람다 표현식 {"$it quarters"}를 trickOrTreat() 호출의 닫는 괄호 다음으로 이동합니다.

---

    val treatFunction = trickOrTreat(false) {"$it quarters"}

---

## 6. repeat() 함수 사용

- repeat() 함수는 고차 함수 중 하나입니다. for 루프를 표현할 수 있는 간결한 방법입니다.

---
    repeat(times: Int, action: (Int) -> Unit)
---

- times 는 동작을 발생해야하는 횟수입니다.
- action 는 Int를 사용하고 Unit유형을 반환하는 함수입니다.
- action 함수의 Int 매개변수는 동작이 지금까지 실행된 횟수입니다.

<img width="545" alt="스크린샷 2024-03-05 오후 8 07 19" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/40629409-44c4-4acc-914f-953f5444e383">

- main() 함수에서 treatFunction() 호출과 trickFunction() 호출 중간에 repeat() 함수를 호출합니다. times 매개변수에 4를 전달하고 action 함수에 후행 람다 문법을 사용합니다. 람다 표현식의 Int 매개변수에 이름을 지정할 필요는 없습니다.
- treatFunction() 함수 호출을 repeat() 함수의 람다 표현식으로 이동합니다.

---

    fun main() {
    
    	val treatFunction = trickOrTreat(false) {"$it quarters"}
    	val trickFunction = trickOrTreat(true, null)
        repeat(4) {
    	    treatFunction()        
        }
        trickFunction()
    }

---

    5 quarters
    Have a treat!
    Have a treat!
    Have a treat!
    Have a treat!
    No treats!

---
























