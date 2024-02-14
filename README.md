# kotlin-study

## 변수와 자료형
1. 주석
---
    // 자료형 변수
    /* 주석을
     * 여러줄로
    * 하는 경우 */
---
2. 클래스 이름은 파스칼 표기법
   - 모든 단어를 대준자로 시작
   - ClassName 
3. 함수나 변수 이름은 카멜 표기법
   - 첫 단어만 소문자로 시작
   - funcitonName
4. 변수 선언법
   - var
     - 일반적으로 통용되는 변수.
     - 언제든지 읽기쓰기가 가능함.
  
   - val
     - 선언시에만 초기화 가능.
     - 중간에 값을 변경할 수 없음
---
    fun main() {
        var a: Int = 123  //var a: Int? = null -> nullable
        println(a)
    }
---
5. 기본 자료형
   - 정수형 
<img width="298" alt="스크린샷 2024-02-13 오후 8 15 32" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/3a8e15f3-355a-4bae-9dcc-93efbf9b6a24">

   - 실수형
  <img width="316" alt="스크린샷 2024-02-13 오후 8 17 30" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/8d568cc8-d226-4c21-985f-b93bec856f14">
  
---
    fun main() {
        var intValue:Int = 1234
        var longValue:Long = 1234L
        var intValueByHex:Int = 0x1af
        var intValueByBin:Int = 0b10110110

        var doubleValue:Double = 123.5
        var doubleValueWithExp:Double = 123.5e10
        var floatValue:Float = 123.5f
    }
---
6. 문자형
---
    fun main() {
        var charValue:Char = 'a'
        var koreanCharValue:Char = '가'
    }
---
7. 논리형
   - Boolean 참 또는 거짓
---
    fun main() {
        var booleanValue:Boolean = ture
    }
---
8. 문자열
---
    fun main() {
        val stringValue = "one line string test"

        val multilinesStringValue = """multline
        string
        test"""
    }
---

## 형변환과 배열
1. 형변환
   - 하나의 변수에 지정된 자료형을 호환되는 다른 자료형으로 변경하는 기능
     
<img width="210" alt="스크린샷 2024-02-13 오후 8 29 17" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/62c70d28-3a3b-440b-b808-000f770d1a8c">

---
    fun main() {
        var a: Int = 154234
        var b: Long = a.tolong()
    }
---
2. 배열
---
    fun main() {
        var intArr = arrayOf(1, 2, 3, 4, 5)
        
        var nullArr = arrayOfNulls<Int>(5)  // null 로 채워진 배열

        intArr[2] = 8
        println(intArr[4])
    }

## 타입추론과 함수
1. 타입추론
   - 변수나 함수들을 선얼할 때나 연산이 이루어 질 때 자료형을 코드에 명시하지 않아도 코틀린이 자동으로 자료형을 추론해주는 기능
---
    fun main() {
        var a = 1234
        var b = 1234L

        var c = 12.45
        var d = 12.45f

        var e = 0xABCD
        var f = 0b01010101

        var g = true
        var h = 'c'
    }
---
2. 함수
---
    fun main() {
        println(add(5, 6, 7))
    }
    
    fun add(a: Int, b: Int, c: Int): Int {
        return a + b + c
    }
    fun add(a: Int, b: Int, c: Int) = a + b + c
---
## 조건문과 비교연산자
1. 조건문
---
    fun main() {
        var a = 11
        if(a > 10) {
            println("a는 10보다 크다")
        } else {
            println("a는 10보다 작거나 같다")
        }
    }
---
2. 비교연산자
   -   <   <=   >   >=   !=   ==
   -   is !is
3. 다중조건문
   - when
---
    fun main(){
    	doWhen(1)
        doWhen("Jang")
        doWhen(12L)
        doWhen(3.14159)
        doWhen("Kotlin")
    }
    
    fun doWhen (a: Any) {
        when(a){
            1 -> println("정수 1입니다")
            "Jang" -> println("장의 코틀린 공부")
            is Long -> println("Long 타입 입니다")
            !is String -> println("String 타입이 아닙니다")
            else -> println("어떤 조건도 만족하지 않습니다")
        }
    }
    
---
   - 표현식
---

    fun doWhen (a: Any) {
        var result = when(a){
            1 -> "정수 1입니다"
            "Jang" -> "장의 코틀린 공부"
            is Long -> "Long 타입 입니다"
            !is String -> "String 타입이 아닙니다"
            else -> "어떤 조건도 만족하지 않습니다"
        }
        println(result)
    }
---

















