# kotlin-study

## 1. 변수와 자료형
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

## 2.형변환과 배열
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

## 3. 타입추론과 함수
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
## 4. 조건문과 비교연산자
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
## 5. 반복문과 증감연산자
1. 반복문
 - 조건형 반복문 -> 조건이 참인 경우 반복을 유지
 - 범위형 반복문 -> 반복 범위를 정해 반복을 수행

1.1 조건형 반복문
---
    fun main() {
        
        var a = 0
        
        while(a < 5){
            println(a++) //증감연산자 ++a , a++
        }
    }
    
    fun main() {
        var a = 0
        
        do  //조건과 관계없이 반드시 '한 번은 실행'해야함
        {
            println(a++)
        } while(a < 5)
    }
---
1.2 범위형 반복문
---
    //증가
    fun main() {
        
        for(i in 0..9 step 3) {   // 0..9 는 0에서 9까지
            print(i)
        }
    }
---
    // 감소
    fun main() {
        for(i in 9 downTo 0 step 3) {
            print(i)
        }
    }
---
    // char
    fun main() {
        
        for(i in 'a'..'e') {
            print(i)
        }
    }

## 6. 흐름제어와 논리연산자
1. 키워드
   - return 반환
   - break 반복문 중간에 정지
   - continue 즉시 넘어가기
---
    // break , continue
    fun main() {
        
        for(i in 1..10) {
            if(i == 3) continue //break ->1,2  , continue 1245678910
            println(i)
        }
    }

    // 다중 조건반복문 중지
    fun main() {
        
        loop@for(i in 1..10) {   //loop은 label 이름
            for (j in 1..10){
                if (i == 1 && j == 2) break@loop  // && 연산자 : (and)두 조건을 모두 만족해야하는 논리연산자
                println("i : $i, j :$j")
            }
        }
    }
---
2. 논리연산자
   - && : and -> true && true
   - || : or -> true || false
   - ! : not -> 반전시키는 역할 !true => false
  
---
    fun main() {
        println(true && false)
        println(true || false)
        println(!true)
        println(!false)
    }
---
    fun main() {
        var a = 6
        var b = 4
        
        println(a>5 && b>5)
    }
---

## 7. 클래스의 기본 구조
---
    fun main() {
        
        var a = Person("박보영", 1990)
        var b = Person("전정국", 1997)
        var c = Person("장원영", 2004)
        
        a.introduce()
        b.introduce()
        c.introduce()
    }
    
    class Person (var name:String, val birthYear:Int) {
        fun introduce() {
            println("안녕하세요, ${birthYear}년생 ${name}입니다")
        }
    }
---
## 8. 클래스의 생성자
1. init

2. 생성자
   - 기본 생성자 : 클래스를 만들 때 기본으로 선언
   - 보조 생성자 : 필요에 따라 추가적으로 선언
---
    fun main() {
        
        var a = Person("박보영", 1990)
        var b = Person("전정국", 1997)
        var c = Person("장원영", 2004)
        
        var d = Person("이루다")
        var e = Person("차은우")
        var f = Person("류수정")
    }
    
    class Person (var name:String, val birthYear:Int) {
        init{
            println("${this.birthYear}년생 ${this.name}님이 생성되었습니다.")   //this 인스턴스 자신의 속성이나 함수를 호출
        }
        constructor(name:String) : this(name, 1997){
            println("보조 생성자가 사용되었습니다.")
        }
    }
---

## 9. 클래스의 상속

1. 상속
---
    fun main() {
        
        var a = Animal("별이",5,"개")
        var b = Dog("별이",5)
        
        a.introduce()
        b.introduce()
        
        b.bark()
        
        var c = Cat("루이",1)
        
        c.introduce()
        c.meow()
    }
    
    open class Animal (var name:String, var age:Int, var type:String){
        fun introduce(){
            println("저는 ${type} ${name}이고,${age}살 입니다")
        }
    }
    
    class Dog (name:String, age:Int) : Animal (name, age, "개"){
        fun bark(){
            println("멍멍")
        }
    }
    
    class Cat(name:String, age:Int) : Animal (name, age, "고양이"){
        fun meow(){
            println("야용")
        }
    }
---
## 10. 오버라이딩과 추상화
1. 오버라이딩
---
    //오버라이딩
    fun main() {
        
        var t = Tiger()
        t.eat()
    }
    
    open class Animal {
        open fun eat() {
            println("음식을 먹습니다")
        }
    }
    
    class Tiger : Animal() {
        override fun eat() {
            println("고기를 먹습니다.")
        }
    }
---
2. 추상화
---

    //추상화
    fun main() {
        
        var r = Rabbit()
        r.eat()
        r.sniff()
    }
    
    abstract class Animal {
        abstract fun eat()
        fun sniff() {
            println("킁킁")
        }
    }
    
    class Rabbit : Animal() {
        override fun eat() {
            println("당근을 먹습니다.")
        }
    }
---
3. 인터페이스
   - 구현부가 있는 함수 -> open 함수로 간주
   - 구현부가 없는 함수 -> abstract 함수로 간주
---
    fun main() {
        var d = Dog()
        d.run()
        d.eat()
    }
    
    interface Runner {
        fun run()
    }
    
    interface Eater {
        fun eat() {
            println("음식을 먹습니다")
        }
    }
    
    class Dog : Runner, Eater {
        override fun run() {
            println("우다다다 뜁니다.")
        }
        
        override fun eat() {
            println("허겁지겁 먹습니다.")
        }
    }
---
## 11. 기본 프로젝트 구조
1. 프로젝트 project - 어플레이케이션을 짤 때 관련된 모든 내용을 담는 '큰 틀'이라고 생각하면 된다.
2. 모듈 module - 프로젝트안에 여러개의 모듈, 직접 만들거나 필요한 기능을 이미 구현해 둔 '라이브러리 모듈'을 가져와 붙이기가 가능
3. 모듈은 여러개의 파일과 폴더(코드 파일 and 모듈과 관련된 설정 및 리소스 파일)
4. 패키지 - 개발시에 소스 코드의 '소속'을 지정하기 위한 논리적 단위
   - 클래스 이름이 같다면 ex) com.youtube.dimo.base.A
---
    package com.youtube.dimo
    
    import com.youtube.dimo.base
---

## 12. 변수, 함수, 클래스의 접근범위와 접근제한자
1. 스코프 scope
---
    val a = "패키지 스코프"
    
    class B {
        val a = "클래스 스코프"
        fun print() {
            println(a)
        }
    }
    
    fun main(){
        val a = "함수 스코프"
        println(a)
        B().print()
    }
---
2. 접근제한자
   
<img width="241" alt="스크린샷 2024-02-14 오후 7 05 02" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/24715eff-a90f-4deb-ba52-fd1495fe2650"> <img width="440" alt="스크린샷 2024-02-14 오후 7 05 27" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/80a16502-1765-4341-be95-080520a2261a">

2.1 패키지 스코프
  - public - 어떤 패키지에서도 접근 가능
  - internal - 같은 모듈 내에서만 접근 가능
  - private - 같은 파일 내에서만 접근 가능
  * protected 는 사용하지 않음

2.2 클래스 스코프
  - public - 클래스 외부에서 늘 접근 가능
  - private - 클래스 내부에서만 접근 가능
  - protected - 클래스 자신과 상속받은 클래스에서 접근 가능
  * internal 은 사용하지 않음
  * 

## 13. 고차함수와 람다함수
1. 고차함수
2. 람다함수

---
    fun main() {
        
        b(::a)
        
        val c: (String)->Unit = { str -> println("$str 람다함수")}
        b(c)
        
    }
    
    fun a (str: String) {
        println("$str 함수 a")
    }
    
    fun b(function: (String)->Unit){
        function("b가 호출한")
    }
---

## 14. 스코프 함수
- 람다함수도 여러 구문의 사용이 가능

<img width="173" alt="스크린샷 2024-02-14 오후 7 57 15" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/02382cbf-aa77-43b2-8d00-b468c1e3c2e0">

1. apply - 인스턴스를 생성한 후 변수에 담기 전에 '초기화 과정'을 수행할 때 많이 쓰입니다
---
    fun main() {
       
        var a = Book("장의 코틀린", 10000).apply {
            name = "[초특가]" + name
            discount()
        }
        
    }
    
    class Book(var name:String, var price: Int){
        fun discount() {
            price -= 2000
        }
    }
---
2. run
---
    fun main() {
       
        var a = Book("장의 코틀린", 10000).apply {
            name = "[초특가]" + name
            discount()
        }
        
        a.run {
            println("상품명: ${name}, 가격: ${price}원")
        }
        
    }
    
    class Book(var name:String, var price: Int){
        fun discount() {
            price -= 2000
        }
    }
---
    상품명: [초특가]장의 코틀린, 가격: 8000원
---
3. with

<img width="521" alt="스크린샷 2024-02-14 오후 9 11 13" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/58f0d31c-c61c-4729-9693-55644a5ff790">


4. also / let
---
    fun main() {
       
        var price = 5000
        
        var a = Book("장의 코틀린", 10000).apply {
            name = "[초특가]" + name
            discount()
        }
        
        a.run {
            println("상품명: ${name}, 가격: ${price}원")
        }
        
        a.let{
            println("상품명: ${it.name}, 가격: ${it.price}원")
        }
    }
    
    class Book(var name:String, var price: Int){
        fun discount() {
            price -= 2000
        }
    }
---
    상품명: [초특가]장의 코틀린, 가격: 5000원
    상품명: [초특가]장의 코틀린, 가격: 8000원
---
- let -> run이 main()에서 할당되는걸 대체
- also -> apply 역시 같은 경우 대체

## 15. 오브젝트
1. 생성자 없이 객체를 직접 만들어 내는 object
  - Singleton Pattern - 클래스의 인스턴스를 단 하나만 만들어 사용하도록 하는 코딩 아키텍쳐 패턴
---
    fun main() {
        
        println(Counter.count)
        
        Counter.countUp()
        Counter.countUp()
        
        println(Counter.count)
        
        Counter.clear()
        println(Counter.count)
    }
    
    object Counter {
        var count = 0
        
        fun countUp() {
            count++
        }
        fun clear() {
            count = 0
        }
    }
---
2. Companion Object
   - Static 멤버 - 클래스 내부에서 별도의 영역에 고정적으로 존재하여 인스턴스를 생성하지 않아도 공용으로 사용가능한 속성이나 함수

---
    fun main() {
        var a = FoodPoll("짜장")
        var b = FoodPoll("짬뽕")
        
        a.vote()
        a.vote()
        
        b.vote()
        b.vote()
        b.vote()
        
        println("${a.name}:${a.count}")
        println("${b.name}:${b.count}")
        println("총계:${FoodPoll.total}")
        
    }
    
    class FoodPoll(val name: String){
        companion object {
            var total = 0
        }
        
        var count = 0
        
        fun vote(){
            total++
            count++
        }
    }
---
    짜장:2
    짬뽕:3
    총계:5
---
- 인스턴스를 공유하기때문에 누적해서 결과를 볼 수 있다.


## 16. 익명객체와 옵저버 패턴
1. 옵저버 패턴
---
    fun main() {
        
        EventPrinter().start()
        
    }
    
    interface EventListener {
        fun onEvent(count: Int)
    }
    
    class Counter(var listener: EventListener){
        fun count(){
            for(i in 1..100){
                if(i % 5 == 0) listener.onEvent(i)
            }
        }
    }
    
    class EventPrinter: EventListener {
        override fun onEvent(count: Int){
            print("${count}-")
        }
        fun start(){
            val counter = Counter(this)
            counter.count()
        }
    }
---
2. 익명객체
---
    fun main() {
        
        EventPrinter().start()
        
    }
    
    interface EventListener {
        fun onEvent(count: Int)
    }
    
    class Counter(var listener: EventListener){
        fun count(){
            for(i in 1..100){
                if(i % 5 == 0) listener.onEvent(i)
            }
        }
    }
    
    class EventPrinter {
        fun start() {
            val counter = Counter(object: EventListener{
                override fun onEvent(count: Int){
                    print("${count}-")
                }
            })
            counter.count()
        }
    }
---

## 17. 클래스의 다형성

---
    fun main() {
        
        var a = Drink()
        a.drink()
        
        var b: Drink = Cola()
        b.drink()
        
        if(b is Cola){       // is 는 변수가 자료형에 호환되는지를 먼저 '체크한 후 변환' 해주는 캐스팅 연산자로 {} 안에서만 b가 Cola 가 됨
            b.washDishes()
        }
        
        var c = b as Cola     //as 로 Cola로 변환한 결과를 반환받아야 변수에 넣을 수 있다.
        c.washDishes()
        b.washDishes()
    }
    
    open class Drink {
        var name = "음료"
        
        open fun drink() {
            println("${name}를 마십니다")
        }
    }
    
    class Cola: Drink() {     // Cola 에 Drink를 인스턴스로 담았으므로 override한 함수가 실행이 됨
        var type = "콜라"
        
        override fun drink() {
            println("${name}중에 ${type}를 마십니다")
        }
        
        fun washDishes() {
            println("${type}로 설거지를 합니다")
        }
    }
---
- is, as down-casting

## 18. 제너릭
- 클래스나 함수에서 사용하는 자료형을 외부에서 지정할 수 있는 기능인 Generic


---
    fun main() {
        
        UsingGeneric(A()).doShouting()
        UsingGeneric(B()).doShouting()
        UsingGeneric(C()).doShouting()
        
        doShouting(B())
    }
    
    fun <T: A> doShouting(t:T){    // 캐스팅 없이 B의 객체 그대로 함수에서 사용
        t.shout()
    }
    
    open class A{
        open fun shout() {
            println("A가 소리칩니다")
        }
    }
    
    class B : A(){
        override fun shout() {
            println("B가 소리칩니다")
        }
    }
    
    class C : A() {
        override fun shout() {
            println("C가 소리칩니다")
        }
    }
    
    class UsingGeneric<T: A> (val t: T) {
        fun doShouting() {
            t.shout()
        }
    }
---

## 19. 리스트
- 데이터를 코드에서 지정한 순서대로 저장해두는 List
- List<out T> - 생성시에 넣은 객체를 대체, 추가, 삭제 할 수 없음
- MutableList<T> - 생성시에 넣은 객체를 대체, 추가, 삭제가 가능함

---
    //형태
    
    listOf(1,2,3)
    mutableListOf("A","B","C")
    
    // 요소의 추가
    
    add(데이터)
    add(인덱스, 데이터)
    
    //삭제
    
    remove(데이터)
    removeAt(인덱스)

    // 무작위 섞기
    
    shuffle()
    
    //정렬
    
    sort()
---
    list[인덱스] = 데이터   //특정위치의 요소를 다른 요소로 대체도 가능
---

    fun main() {
    
        var a = listOf("사과", "딸기", "배")
        println(a[1])
        
        for(fruit in a){
            print("${fruit}:")
        }
        
        println()
        
        val b = mutableListOf(6,3,1)
        println(b)
        
        b.add(4)
        println(b)
        
        b.add(2,8)
        println(b)
        
        b.removeAt(1)
        println(b)
        
        b.shuffle()
        println(b)
        
        b.sort()
        println(b)
        
    }
    
---

## 20, 문자열 다루는 법

- 'String' 이라는 클래스로 문자열을 다루며
---
    val text = "문자열"
---
- ""안에 문자열을 넣어 리터럴을 만들면 새 String 객체가 생성되는 것을 보았다.
---
    fun main() {
     
        val test1 = "Test.Kotlin.String"
        
        println(test1.length)
        
        println(test1.toLowerCase())  //소문자로 변환
        println(test1.toUpperCase())  //대문자로 변환
    
        val test2 = test1.split(".")  //점을 기준으로 나눈 문자열 배열
    	println(test2)
        
        println(test2.joinToString())  // 문자열을 합침
        println(test2.joinToString("-"))
        
        println(test1.substring(5..10))
        
    }
---
    // 문자열이 비어있는지 판단하여 boolean 값으로 반환받는 함수들
    
    fun main() {
     
        val nullString:String? = null
        val emptyString = ""
        val blankString = " "
        val normalString = "A"
        
        println(nullString.isNullOrEmpty())
        println(emptyString.isNullOrEmpty())
        println(blankString.isNullOrEmpty())
        println(normalString.isNullOrEmpty())
        
        println()
        
        println(nullString.isNullOrBlank())
        println(emptyString.isNullOrBlank())
        println(blankString.isNullOrBlank())
        println(normalString.isNullOrBlank())
            
    }
---
    true
    true
    false
    false
    
    true
    true
    true
    false
---
    fun main() {
        
    	var test3 = "kotlin.kt"
        var test4 = "java.java"
        
        println(test3.startsWith("java"))
        println(test4.startsWith("java"))
        
        println(test3.endsWith(".kt"))
        println(test4.endsWith(".kt"))
        
        println(test3.contains("lin"))
        println(test4.contains("lin"))
        
    }
---
    false
    true
    true
    false
    true
    false
---

## 21. null 값을 처리하는 방법? 동일한지를 확인하는 방법?

- nullable 변수에서 nul을 처리하는 법과 변수 간의 동일성을 확인하는 방법
- ?.  : null safe operator
- ?:  : elvis operator
- !!. : non-null assertion operator
---
    /* 참조연산자를 실행하기 전에 먼저 객체가 null 인지 확인부터하고 객체가 null 이라면
     * 뒤 따라오던 toUppercase()를 실행하지 않는다
    
    samle?.toUpperCase()

    // 객체가 null 이 아니라면 그대로 사용하지만 null 이라면 연산자 우측의 객체로 대체되는 연산자이다.

    sample?:"default"

    /* 참조연산자를 사용할 때 null 여부를 컴파일시 확인하지 않도록 하여 
     * 런타임시 null pointer exception 이 나도록 의도적으로 방치하는 연산자입니다.

    sample!!.toUpperCase()
---
### 21.1 실습
---
    fun main() {
        
    	var a: String? = null
        
        println(a?.toUpperCase())
        
        println(a?:"default".toUpperCase())
        
        println(a!!.toUpperCase())
        
    }
---
    null
    DEFAULT
    Exception in thread "main" java.lang.NullPointerException
     at FileKt.main (File.kt:9) 
     at FileKt.main (File.kt:-1) 
     at jdk.internal.reflect.NativeMethodAccessorImpl.invoke0 (:-2)
---
- null safe 연산자는 스코프 함수와 사용하면 더욱 편리합니다.
---
    // null 을 체크하기 위해 if 문을 사용하는 것보다 상당한 편리한 기능
    fun main() {
        
    	var a: String? = "Kotlin Exam"
        
    	a?.run{
            println(toUpperCase())
            println(toLowerCase())
        }
        
    }
---
- 동일성
    - 내용의 동일성 : a == b
    - 자동으로 판단되는 것이 아닌 코틀린의 모든 클래스가 내부적으로 상속받는 'any'라는 최상위 클래스의
    - equals() 함수가 반환하는 Boolean 값으로 판단하게 됩니다.
      
  <img width="738" alt="스크린샷 2024-02-15 오후 4 37 04" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/9ad09c5c-1ee4-403a-bce8-5fbc65e8e977">

    - 객체의 동일성 : a === b

<img width="741" alt="스크린샷 2024-02-15 오후 4 37 28" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/f2aab73e-9dec-4525-80c8-94a7b83f4b8e">

  - 기본 자료형에는 자료형의 특징에 따라 equals() 함수가 이미 구현되어 있지만 커스텀 class 를 만들때는
---
    open fun equals(other:Any?):Boolean
---
   - 동일성을 확인해주는 구문을 별도로 구현해야 됩니다
---
    fun main() {
        
        var a = Product("콜라", 1000)
        var b = Product("콜라", 1000)
        var c = a
        var d = Product("사이다", 1000)
        
        println(a == b)
        println(a === b)
        
        println(a == c)
        println(a === c)
        
        println(a == d)
        println(a === d)
        
    }
    
    class Product(val name: String, val price: Int) {
        override fun equals(other: Any?):Boolean {
            if(other is Product){
                return other.name == name && other.price == price
            } else {
                return false
            }
        }
    }
---
    true
    false
    true
    true
    false
    false
---

## 22. 함수의 argument 를 다루는 방법과 infix 함수

- 함수를 더 다양한 방법으로 사용할 수 있는 여러 기능들
- overloading - 이것은 '같은 scope 안'에서
---
    fun same (x: Int)
    fun same (x: Int, text: String)
    fun same (x: Int, y: Int)
---
- 'same'으로 이름이 같더라도 파라미터의 자료형이 다르거나 파라미터의 갯수가 다르다면 서로 다른 함수로 동작할 수 있다.
---
    fun same(x: Int, y:Int)
    fun same(a: Int, b:Int)
---
- 다만, 파라미터에 이름만 다르게 묶고 자료형과 갯수가 같다면 오버로딩을 할 수 없습니다.
---
    fun main() {
        
        read(7)
        read("감사합니다")
        
    }
    
    fun read(x: Int) {
        println("숫자 $x 입니다")
    }
    
    fun read(x: String) {
        println(x)
    }
---
- 파라미터를 받아야 하는 함수이지만 별다른 패러미터가 없더라도 기본값으로 동작해야 한다면
- default arguments 를 사용합니다.
---
    fun main() {
        
        deliveryItem("짬뽕")
        deliveryItem("책", 3)
        deliveryItem("노트북", 30, "학교")
        
    }
    
    fun deliveryItem(name: String,
                     count: Int = 1, 
                     destination: String = "집"){
        println("${name}, ${count}개를 ${destination}에 배달하였습니다.")
    }
---
    짬뽕, 1개를 집에 배달하였습니다.
    책, 3개를 집에 배달하였습니다.
    노트북, 30개를 학교에 배달하였습니다.
---
- 실행해보면 패러미터가 채워진 경우에는 입력받은 패러미터를 사용하여 출력되지만 패러미터가 없다면 지정된 값으로 출력되는 것을 볼 수 있다.
- 그런데, 이름과 목적지만 넣고 개수는 기본값을 이용하고 싶다면
- named arguments 를 사용하고 이는 패러미터의 순서와 관계없이 패러미터의 이름을 사용하여 직접 패러미터의 값을 할당하는 기능입니다.
---
    deliveryItem("선물", destination = "친구집")
---
    선물, 1개를 친구집에 배달하였습니다.
---
- 이번엔 같은 자료형을 개수에 상관없이 패러미터로 받고 싶을 때 사용하는
- variable number of arguments (vararg)
---
    fun main() {
        
        sum(1, 2, 3, 4)
        
    }
    
    fun sum(vararg numbers: Int){
        var sum = 0
        
        for(n in numbers){
            sum += n
        }
        print(sum)
    }
---
- vararg는 개수가 지정되지 않은 패러미터라는 특징이 있으므로
---
    fun sample(text: String, vararg x: Int)
---
- 맨 마지막에 사용한다는 것을 잊으면 안된다.
- 마지막으로 마치 연산자처럼 쓸 수 있는 infix funciton
---
    fun main() {
        
        println(6 multiply 4)
        
        println(6.multiply(4))
        
    }
    
    infix fun Int.multiply(x: Int): Int = this * x
---
- 참고로 class 안에서 infix 함수를 선언할 때에는 적용할 클래스가 자기 자신이므로
---
    infix fun multiply(x: Int): Int = this * x
---
- class 이름은 쓰지 않습니다.

## 23. 중첩클래스와 내부 클래스

- 중첩 클래스 - 하나의 클래스가 다른 클래스의 기능과 강하게 연관되어 있다는 의미를 전달하긱 위해 만들어진 형식
           - 외부 클래스의 내용을 공유할 수 없음
- 내부 클래스 - 혼자서 객체를 만들 수는 없고 외부 클래스의 객체가 있어야만 생성과 사용이 가능한 클래스입니다.
           - 외부 클래스의 속성과 함수의 사용이 가능
---
    fun main() {
        
        Outer.Nested().introduce()
        
        val outer = Outer()
        val inner = outer.Inner()
        
        inner.introduceInner()
        inner.introduceOuter()
        
        outer.text = "Changed Outer Class"
        inner.introduceOuter()
        
    }
    
    class Outer {
        var text = "Outer Class"
        
        class Nested {
            fun introduce() {
                println("Nested Class")
            }
        }
        
        inner class Inner {
            var text = "Inner Class"
            
            fun introduceInner() {
                println(text)
            }
            
            fun introduceOuter() {
                println(this@Outer.text)
            }
        } 
    }
---
- 중첩 클래스와 내부 클래스는 클래스간의 연계성을 표현하여 코드의 가독성 및 작성 편의성이 올라갈 수 있으므로 적절한 상황에서 사용해야 한다.


## 24. Data Class 와 Enum Class

- 특별한 기능이나 형태를 가진 클래스들
- Data class - 데이터를 다루는 데에 최적화된 class 로 '5가지 기능'을 내부적으로 자동으로 생성해준다.
        * 내용의 동일성을 판단하는 equals() 의 자동구현
        * 객체의 내용에서 고유한 코드를 생성하는 hashcode()의 자동구현
        * 포함된 속성을 보기쉽게 나타내는 toString()의 자동구현
        * 객체를 복사하여 똑같은 내용의 새 객체를 만드는 copy()의 자동구현
              ! 객체를 똑같이 복사도 가능하지만 파라미터가 있다면 해당 파라미터로 교체하여 생성함
        * 속성을 순서대로 반환하는 componentX()의 자동구현

1. Data Class
---

    fun main() {
        
        val a = General("보영", 212)
        
        println(a == General("보영", 212))
        println(a.hashCode())
        println(a)
        
        val b = Data("루다", 306)
        
        println(b == Data("루다", 306))
        println(b.hashCode())
        println(b)
        
        println(b.copy())
        println(b.copy("아린"))
        println(b.copy(id = 618))
        
    }
    
    class General(val name: String, val id: Int)
    
    data class Data(val name: String, val id: Int)

---
    false
    885284298
    General@34c45dca
    true
    46909878
    Data(name=루다, id=306)
    Data(name=루다, id=306)
    Data(name=아린, id=306)
    Data(name=루다, id=618)
---
    //component 함수
    fun main() {
        
        val list = listOf(Data("보영", 212),
                         Data("루다", 306),
                         Data("아린", 618))
        
        for((a,b)in list) {
            println("${a}, ${b}")
        }
        
    }
    
    class General(val name: String, val id: Int)
    
    data class Data(val name: String, val id: Int)
---
    보영, 212
    루다, 306
    아린, 618
---

2. Enum Class
   - enumerated type - 열거형

---
    fun main() {
        
        var state = State.SING
        println(state)
        
        state = State.SLEEP
        println(state.isSleeping())
        
        state = State.EAT
        println(state.message)
        
    }
    
    enum class State(val message: String) {
        SING("노래를 부릅니다"),
        EAT("밥을 먹습니다"),
        SLEEP("잠을 잡니다");
        
        // enum 은 선언시에 만든 객체를 이름으로 참조하여 그대로 사용하게 됩니다.
        fun isSleeping() = this == State.SLEEP 
        
    }
---
    SING
    true
    밥을 먹습니다
---

## 25. 컬렉션 2탄, Set과 Map

- set - list 와 달리 순서가 정렬되지 않으며 중복이 허용되지 않는 컬렉션입니다.
      - 따라서, 인덱스 위치를 지정하여 객체를 참조할 수는 없으며
---
    // sampleSet 에 디모가 있는지 알려줘
    sampleSet.contains("디모")
---
- 샘플셋에 존재하는 지를 확인하는 식으로만 사용합니다.
- set<outT>
- MutableSet<T>

1. set
---
    fun main() {
    	
        val a = mutableSetOf("귤","바나나","키위")
        
        for(item in a)
        {
            println("${item}")
        }
        
        a.add("자몽")  //추가
        println(a)
        
        a.remove("바나나")  //삭제
        println(a)
        
        println(a.contains("귤"))
        
    }
---
    귤
    바나나
    키위
    [귤, 바나나, 키위, 자몽]
    [귤, 키위, 자몽]
    true
---
2. map
    - 객체를 넣을ㄷ 때 그 객체를 찾아낼 수 있는 key를 쌍으로 넣어주는 컬렉션 입니다.
    - key - 객체를 찾기위한 값
    - value - key와 연결된 객체
    - 이러한 구조로 객체의 위치가 아닌
---
    // 디모라는 key에 연결된 객체를 알려줘
    sampleMap["디모]
---
   - 또한 같은 key에 다른 객체를 넣으면 기존의 객체가 대체되니 주의해서 사용하세요.
   - Map<K, out v>
   - MutableMap<K, V>
---
    fun main() {
    	
        val a = mutableMapOf("레드벨벳" to "음파음파",
                            "트와이스" to "FANCY",
                            "ITZY" to "ICY")
        for (entry in a)
        {
            println("${entry.key}:${entry.value}")
        }
        
        a.put("오마이걸", "변지")
        println(a)
        
        a.remove("ITZY")
        println(a)
        
        println(a["레드벨벳"])
        
    }
---
    레드벨벳:음파음파
    트와이스:FANCY
    ITZY:ICY
    {레드벨벳=음파음파, 트와이스=FANCY, ITZY=ICY, 오마이걸=변지}
    {레드벨벳=음파음파, 트와이스=FANCY, 오마이걸=변지}
    음파음파
---

## 26. 컬렉션 함수, 첫번째

- 컬렉션 함수 - list나 set, map 과 같은 컬렉션 또는 배열에 일반 함수 또는 람다 함수 형태를 사용하여
           - for 문 없이도 아이템을 순회하며 참조하거나 조건을 걸고, 구조의 변경까지 가능한 여러가지 함수.
--- 
    // it을 순서대로 참조가 가능
    collection.forEach {
        println(it)
    }
---
    // filter 는 조건을 걸어면 조건에 맞는 객체만 뽑아준다.
    collection.filter {
        it < 4
    }
---
    // map 은 객체안에 수식을 계산하여 출력
    collection.map {
        it * 2
    }
---
    collection.any { it == 0 }      // 하나라도 저건에 맞으면 true
    collection.all { it == 0 }      // 모두 조건에 맞으면 true
    collection.none { it == 0 }     // 하나도 조건에 맞지 않으면 true
---
    collection.first()       // 컬렉션의 첫번째 아이템 반환  find 로 대체가능
    collection.first{ it > 3 } // 조건에 맞는 첫번째 아이템을 반환
    collection.last()        // 조건에 맞는 마지막 아이템을 반환  findLast

    //객체가 없는 경우
    firstOrNull
    lastOrNull
---
    collection.count()    // 컬렉션의 모든 아이템의 개수 반환
    collection.count{ it > 7 }

---
    fun main() {
    	
    	val nameList = listOf("박수영","김지수", "김다현", "신유나", "김지우")
        
        nameList.forEach{ print(it + " ")}
        println()
        
        println(nameList.filter{it.startsWith("김")})
        
        println(nameList.map{"이름:"+it})
        
        println(nameList.any{ it == "김지연" })
        println(nameList.all{it.length == 3})
        println(nameList.none{it.startsWith("이")})
        
        println(nameList.first{it.startsWith("김")})
        println(nameList.last{it.startsWith("김")})
        println(nameList.count{it.contains("지")})
    }
---
    박수영 김지수 김다현 신유나 김지우 
    [김지수, 김다현, 김지우]
    [이름:박수영, 이름:김지수, 이름:김다현, 이름:신유나, 이름:김지우]
    false
    true
    true
    김지수
    김지우
    2
---

## 27. 컬렉션 함수, 두번째

---
    // 아이템에서 key를 추출하여 map 으로 변환하는 함수
    collection.associateBy { it.name }
---

<img width="565" alt="스크린샷 2024-02-16 오후 12 28 21" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/75f75ff4-cf87-4751-8f7a-74a0b66eb1f0">

<img width="477" alt="스크린샷 2024-02-16 오후 12 28 42" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/1b887669-e962-4cf6-8118-f1f6d1507a09">


---
    // key가 같은 아이템끼리 배열로 묶어 map으로 만드는 함수
    collection.groupBy { it.birthYear }
---
    
<img width="477" alt="스크린샷 2024-02-16 오후 12 29 39" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/ca073bcc-1e31-40f4-a3db-91da7149d9ff">

---
    // 아이템에 조건을 걸어 두개의 컬렉션으로 나누어 줌
    collection.partition { it.birthYear > 2002 }
---

<img width="686" alt="스크린샷 2024-02-16 오후 12 33 05" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/9122aad4-d685-4037-9dd4-0294d34dab77">

---
    
    fun main() {
    	
    	data class Person(val name: String, val birthYear: Int)
        
        val personList = listOf(Person("유나",1992),
                               Person("조이",1996),
                               Person("츄",1999),
                               Person("유나",2003))
        
        println(personList.associateBy{ it.birthYear })
        println(personList.groupBy{ it.name })
        
        val (over98, under98) = personList.partition { it.birthYear > 1998}
        
        println(over98)
        println(under98)
        
    }

---

    {1992=Person(name=유나, birthYear=1992), 1996=Person(name=조이, birthYear=1996), 1999=Person(name=츄, birthYear=1999), 2003=Person(name=유나, birthYear=2003)}
    {유나=[Person(name=유나, birthYear=1992), Person(name=유나, birthYear=2003)], 조이=[Person(name=조이, birthYear=1996)], 츄=[Person(name=츄, birthYear=1999)]}
    [Person(name=츄, birthYear=1999), Person(name=유나, birthYear=2003)]
    [Person(name=유나, birthYear=1992), Person(name=조이, birthYear=1996)]

---

    // 아이템마다 만들어진 컬렉션을 합쳐서 반환하는 함수
    collection.flatMap{}
    collection.flatMap{ listOf(it*3, it+3) }

    // 인덱스 위치에 아이템이 있으면 아이템을 반환하고 아닌 경우 지정한 기본값을 반환하는 함수
    collection.getOrElse(){}
    collection.getOrElse(1){50}

    // 컬렉션 두 개의 아이템을 1:1로 매칭하여 새 컬렉션을 만들어 줌
    collectionA zip collectionb

---

    fun main() {
    	
    	val numbers = listOf(-3, 7, 2, -10, 1)
        
        println(numbers.flatMap{listOf(it*10, it+10)})
        
        println(numbers.getOrElse(1){50})
        println(numbers.getOrElse(10){50})
        
        val names = listOf("A", "B", "C", "D")
        
        println(names zip numbers)
        
    }

---

    [-30, 7, 70, 17, 20, 12, -100, 0, 10, 11]
    7
    50
    [(A, -3), (B, 7), (C, 2), (D, -10)]

---

## 28. 변수의 고급 기술. 상수, lateinit, lazy

1. 상수
---
    fun main() {
    	
    	val foodCourt = FoodCourt()
        
        foodCourt.searchPrice(FoodCourt.FOOD_CREAM_PASTA)
        foodCourt.searchPrice(FoodCourt.FOOD_STEAK)
        foodCourt.searchPrice(FoodCourt.FOOD_PIZZA)
    }
    
    class FoodCourt {
        fun searchPrice(foodName: String){
            val price = when(foodName)
            {
                FOOD_CREAM_PASTA -> 13000
                FOOD_STEAK ->25000
                FOOD_PIZZA -> 15000
                else -> 0
            }
            
            println("${foodName}의 가격은 ${price}원 입니다")
        }
        
        companion object {
            const val FOOD_CREAM_PASTA = "크림파스타"
            const val FOOD_STEAK = "스테이크"
            const val FOOD_PIZZA = "피자"
        }
        
    }
---
    크림파스타의 가격은 13000원 입니다
    스테이크의 가격은 25000원 입니다
    피자의 가격은 15000원 입니다
---
- 기능적으로는 굳이 왜 변수를 사용하지 않고 상수를 별도로 사용하는지
- 이는 변수의 경우 런타임시 객체를 생성하는데 시간이 더 소요되어 성능의 하락이 있기 때문입니다.
- 따라서 늘 고정적으로 사용할 값은 상수를 통해 객체의 생성없이 메모리에 값을 고정하여 사용함으로서
- 성능을 향상시킬 수 있다는 장점이 있습니다.

2. 늦은 초기화
- 코틀린에서는 변수를 선언할 때
---
    // 자료형만 지정해두고 객체는 나중에 할당하면 안될까?
    var a: Int
---
- 이렇게 안됩니다.
- 경우의 따라서는 변수에 객체를 할당하는 것을 선언과 동시에 할 수 없을 때도 있습니다.
---
    lateinit var a: Int
---
- 일단 변수만 선언하고 초기값의 할당은 나중에 할 수 있도록 하는 키워드입니다.

<img width="513" alt="스크린샷 2024-02-16 오후 1 58 59" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/278bf8f6-b8fd-4529-89d7-c82fa1d9feef">

- 또한 lateinit 변수의 '초기화'를 하였는지 여부를 확인할 떄는
---
    ::aisInitialized
---
- 초기화가 되었는지 확인하여 사용할 수 있으므로 오류를 막을 수 있습니다.
---

    fun main() {
        
        val a = LateInitSample()
        
        println(a.getLateInitText())
        a.text = "새로 할당한 값"
        println(a.getLateInitText())
        
    }
    
    class LateInitSample {
        lateinit var text: String
        
        fun getLateInitText():String{
            if(::text.isInitialized) {
                return text
            } else {
                return "기본값"
            }
        }
    }
    
---
    기본값
    새로 할당한 값
---

- 마지막으로 변수를 사용하는 시점까지 초기화를 자동으로 늦춰주는
- 지연 대리자 속성 ( lazy delegate properties)
- 이는 lateinit과 달리
---
    val a: Int by lazy{7}
---
- 코드에서는 선언시 즉시 객체를 생성 및 할당하여 변수를 초기화하는 형태를 갖고 있지만 실제 실행시에는
---
    val a: Int by lazy {7}
    ...
    println(a)  // 이 시점에 7로 초기화 됨
---
- 코드의 실행시간을 최적화 할 수 있는 코드입니다.
- 참고로 람다함수로 초기화가 진행되므로
---
    val a: Int by lazy {
        println("initializing")
        7
    }   // 이렇게 해도 어차피 값은 7이 됨
---
    fun main() {
    	
        val number: Int by lazy {
            println("초기화를 합니다")
            7
        }
        
        println("코드를 시작합니다")
        println(number)
        println(number)
    }
---
- 상수, 늦은 초기화, 초기화의 지연은 상황에 따라 변수를 사용하는 방법을 조금 더 세세하게 조절할 수 있다는 장점이 있습니다.


## 29. 비트연산

- 비트연산은 정수형 변수를 사람이 연산하는 10진법 대신 2진법인 비트단위로 연산할 수 있는 기능입니다.
- 정수형의 값을 비트단위로 나누어 데이터를 좀 더 작은 단위로 담아 경제성을 높이기 위한 용도로 사용됩니다.
- 00001001001010000100 을 00001 0101010001010100 이렇게 변수하나에 여러개의 값을 담아 사용할 수 있는 것이죠.
- 다만 비트연산을 사용하는 부하도 무시할 수 없으므로
- 주로 플래그 값을 처리하거나 네트워크 등에서 프로토콜의 데이터 양을 줄이기 위해 자주 사용됩니다.
- 참고로 코틀린은 모든 정수형이 부호를 포함하므로 최상위 비트는 양수인지 음수인 부호비트로 사용되기때문에
- 이 부분에는 데이터를 담지 않는 것이 좋습니다.

- 비트를 밀어주는 ! bitwise shift operators
- shl ( shift left) 부호비트를 제외한 모든 비트를 좌측으로 밀어주는 기능
- shr ( shift right) 부호비트를 제외한 모든 비트를 우측으로 밀어주는 기능
- ushr ( unsigned shift right ) 부호비트를 포함하여 모든 비트를 우측으로 밀어주는 기능

- 비트를 조작하는 ! bitwise operators
- 1010 and 0110 양쪽을 비교하여 비트가 둘다 1인 자리만 1로 반환함 -> 0010
- 1010 or 0110 -> 1110
- 1010 xor 0110 -> 1100

- and 연산자는 그 특성을 이용하여 두 가지 기능으로 사용합니다.

<img width="268" alt="스크린샷 2024-02-16 오후 2 36 00" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/879b6779-26dd-417e-b8a4-45327e39eee4">  <img width="345" alt="스크린샷 2024-02-16 오후 2 36 32" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/66d1096a-553c-467a-875d-ab5e77e7be64">

- or 연산자는 반대로 비트의 set 연산, 즉 비트 값을 1로 설정하고 싶을 때 사용합니다.

<img width="261" alt="스크린샷 2024-02-16 오후 2 38 00" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/fe7d60de-f236-468b-8a23-7d100a95fed9">

- xor 연산자는 

<img width="379" alt="스크린샷 2024-02-16 오후 2 38 46" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/ef657b75-6ab6-475d-b2ab-0b048ecc5202">

- 비트를 반전하는 ! inv()
- 이것은 비트를 모두 반전시키는 역할을 합니다.

---
    fun main() {
        
        var bitData: Int = 0b10000
        
        bitData = bitData or(1 shl 2)
        println(bitData.toString(2))
        
        var result = bitData and(1 shl 4)
        println(result.toString(2))
        
        println(result shr 4)
        
        bitData = bitData and ((1 shl 4).inv())
        println(bitData.toString(2))
        
        println((bitData xor(0b10100)).toString(2))
    
    }
---
    10100
    10000
    1
    100
    10000
---
- 비트 연산은 앞서 말했듯이 아주 제한적인 경우에 사용되지만 반드시 알아야 할 중요한 연산이므로 기억해야합니다.

## 30. 코루틴을 통한 비동기 처리

- '비동기'로 여러개의 루틴을 동시에 처리할 수 있는 법
- 코루틴은 제어범위 및 실행범위를 지정할 수 있습니다.
- 이를 코루틴의 Scope
- GlobalScope - 프로그램 어디서나 제어, 동작이 가능한 기본 범위
- CoroutineScope - 특정한 목적의 Dispatcher 를 지정하여 제어 및 동작이 가능한 범위

- Coroutine의 dispatcher는
- CoroutineScope 를 만들 때 적용가능한 Dispatcher
- Dispatchers.Default - 기본적인 백그라운드동작
- Dispatchers.IO - I/O에 최적화 된 동작
- Dispatchers.Main - 메인(UI) 스레드에서 동작
- 이러한 Dispatcher들은 모든 플랫폼에서 지원되지는 않으니 지원되는 플랫폼에 따라서 사용하셔야 합니다.

- 코루틴은 이러한 Scope 에서 제어되도록 생성될 수 있는데요.
---
    val scope = CoroutineScope(Dispatcher.Defaunt)
    val coroutineA = scope.launch{}
    val coroutineB = scope.async{}
---
- launch 와 async 의 차이는 반환값이 있는지의 여부
- launch - 반환값이 없는 Job 객체
- async - 반환값이 있는 Deffered 객체


---
    import kotlinx.coroutines.*
    
    fun main() {
        
        val scope = GlobalScope
        
        scope.launch {
            for(i in 1..5)
            {
                println(i)
            }
        }
    
    }
---
- 결과값이 나오지 않습니다.
- 코루틴은 제어되는 스코프 또는 프로그램 전체가 종료되면 함께 종료되기 때문에
- 코루틴이 끝까지 실행되는 것을 보장하려면 일정한 범위에서 코루틴이 모두 실행될 때까지 잠시 기다려주어야 합니다.

- 우리가 테스트하는 루틴의 경우 main()함수 단 하나이기 때문에 프로세스가 거의 '실행 즉시 종료'되므로
- 코루틴도 동작되지 못하는 것입니다.

- 이럴 때는
---
    runBlocking {
        launch{}
        async{}
    }
---
- 이렇게 생성하면 코루틴이 종료될 때까지 메인 루틴을 잠시 대기시켜 줍니다.
- 주의할 점은
- 안드로이드에서는 메인 스레드에서 runBlocking 을 걸어주면 일정 시간 이상 응답이 없는 경우
- ANR ( Applicatin Not Responding : 응답 없음 오류 ) 이 발생하며 앱이 강제 종료된다는 점을 유의하세요.
---
    import kotlinx.coroutines.*
    
    fun main() {
        
        runBlocking {
            launch {
                for (i in 1..5)
                {
                    print(i)
                }
            }
        }
    }
---
- 루틴의 대기를 위한 추가적인 함수들도 있는데요.
- 바로 delay(), join(), await()
---
    // milisecond 단위로 루틴을 잠시 대기시키는 함수
    delay(milisecond: Long)

    // Job의 실행이 끝날때까지 대기하는 함수 
    Job.join()

    // Defferred 의 실행이 끝날때까지 대기하는 함수
    Deferred.await()

    // Deferred 의 결과도 반환함
    await()
---
- 세 함수는 코루틴 내부 또는 runBlocking {}과 같은 루틴의 대기가 가능한 구문 안에서만 동작이 가능합니다.

---

    import kotlinx.coroutines.*
    
    fun main() {
        
        runBlocking {
            val a = launch {
                for (i in 1..5)
                {
                    println(i)
                    delay(10)
                }
            }
            
            val b = async {
                "async 종료"
            }
            
            println("async 대기")
            println(b.await())
            
            println("launch 대기")
            a.join()
            println("launch 종료")
        }
    }

---
    async 대기
    1
    2
    async 종료
    launch 대기
    3
    4
    5
    launch 종료
---

- 코루틴 실행 도중에 중단하는 방법도 알려드리겠습니다.
- cancel()
- 코루틴에 cancel()을 걸어주면 다음 두 가지 조건이 발생하며 코룬틴을 중단시킬 수 있습니다.
- - 1. 코루틴 내부의 delay() 함수 또는 yield() 함수가 사용된 위치까지 수행된 뒤 종료됨
    2. cancel() 로 인해 속성인 isActive가 false가 되므로 이를 확인하여 수동으로 종료함
---
    import kotlinx.coroutines.*
    
    fun main() {
        
        runBlocking {
            val a = launch {
                for (i in 1..5)
                {
                    println(i)
                    delay(10)
                }
            }
            
            val b = async {
                "async 종료"
            }
            
            println("async 대기")
            println(b.await())
            
            println("launch 취소")
            a.cancel()
            println("launch 종료")
        }
    }
---
    async 대기
    1
    async 종료
    launch 취소
    launch 종료
---

- 마지막으로 제한시간 내에 수행되면 결과값을 아닌 경우 null 을 반환하는
- withTimeoutOrNull()
---
    withTimeoutOrNull(50){
      for(i in 1..1000) {
        println(i)
        delay(10)
      }
      "Finish"
    }
---
- 이 함수도 join() 이나 await() 처럼 blocking 함수라는 점도 기억하세요
---
    import kotlinx.coroutines.*
    
    fun main() {
        
        runBlocking {
            var result = withTimeoutOrNull(50) {
                for(i in 1..10) {
                    println(i)
                    delay(10)
                }
                "Finish"
            }
            
            println(result)
        }
        
        
    }
---
    1
    2
    3
    null
---














