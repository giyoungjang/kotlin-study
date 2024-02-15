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
## 반복문과 증감연산자
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

## 흐름제어와 논리연산자
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

## 클래스의 기본 구조
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
## 클래스의 생성자
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

## 클래스의 상속

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
## 오버라이딩과 추상화
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
## 기본 프로젝트 구조
1. 프로젝트 project - 어플레이케이션을 짤 때 관련된 모든 내용을 담는 '큰 틀'이라고 생각하면 된다.
2. 모듈 module - 프로젝트안에 여러개의 모듈, 직접 만들거나 필요한 기능을 이미 구현해 둔 '라이브러리 모듈'을 가져와 붙이기가 가능
3. 모듈은 여러개의 파일과 폴더(코드 파일 and 모듈과 관련된 설정 및 리소스 파일)
4. 패키지 - 개발시에 소스 코드의 '소속'을 지정하기 위한 논리적 단위
   - 클래스 이름이 같다면 ex) com.youtube.dimo.base.A
---
    package com.youtube.dimo
    
    import com.youtube.dimo.base
---

## 변수, 함수, 클래스의 접근범위와 접근제한자
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

## 고차함수와 람다함수
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

## 스코프 함수
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

## 오브젝트
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


## 익명객체와 옵저버 패턴
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

## 클래스의 다형성

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

## 제너릭
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

## 리스트
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















