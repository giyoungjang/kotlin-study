
## 제네릭을 사용하여 재사용 가능한 클래스 만들기

---

    class FillInTheBlankQuestion(
        val questionText: String,
        val answer: String,
        val difficulty: String
    )
    
    class TrueOrFalseQuestion(
        val questionText: String,
        val answer: Boolean,
        val difficulty: String
    )
    class NumericQuestion(
        val questionText: String,
        val answer: Int,
        val difficulty: String
    )

---

이런게 반복되지만 여러 클래스를 생성할 필요가 없이.

---

    class Question<T>(
        val questionText: String,
        val answer: T,
        val difficulty: String
    )
    
    fun main() {
        val question1 = Question<String>("Quoth the raven ___", "nevermore", "medium")
        val question2 = Question<Boolean>("The sky is green. True or false", false, "easy")
        val question3 = Question<Int>("How many days are there between full moons?", 28, "hard")
    }

---

를 이용하여 answer 를 반환하는 값을 받아 간단히 생성할 수가 있습니다.

## enum클래스 사용

--

    enum class Difficulty {
        EASY, MEDIUM, HARD
    }
    
    class Question<T>(
        val questionText: String,
        val answer: T,
        val difficulty: Difficulty
    )
    
    fun main() {
        val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
        val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
        val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
    }

---

이렇게 전달하여 난이도를 나타냅니다.

## 데이터 클래스 사용

---
    
    enum class Difficulty {
    	EASY, MEDIUM, HARD
    }
        
    class Question<T>(
    	val questionText: String,
    	val answer: T,
    	val difficulty: Difficulty
    )
        
    
    fun main() {
        val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
        val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
        val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
        println(question1.toString())
    }

---

    Question@37f8bb67

---

이렇게 출력이 됍니다

이제 data 키워드를 이용하여 출력해 봅시다

---

    enum class Difficulty {
    	EASY, MEDIUM, HARD
    }
        
    data class Question<T>(
    	val questionText: String,
    	val answer: T,
    	val difficulty: Difficulty
    )
        
    
    fun main() {
        val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
        val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
        val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
        println(question1.toString())
    }

---

    Question(questionText=Quoth the raven ___, answer=nevermore, difficulty=MEDIUM)

---

## 싱글톤 객체 사용

개발자가 클래스에 인스턴스가 하나만 포함되기를 바라는 시나리오가 많이 있습니다.

<img width="419" alt="스크린샷 2024-03-12 오후 4 25 38" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/41aeabb8-d25c-45ee-8a3f-35ac097eee26">

<img width="547" alt="스크린샷 2024-03-12 오후 4 27 28" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/b454963f-345f-4928-bc4a-7ab705fec59e">

---

    enum class Difficulty {
    	EASY, MEDIUM, HARD
    }
        
    data class Question<T>(
    	val questionText: String,
    	val answer: T,
    	val difficulty: Difficulty
    )
    
    object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }
    
    fun main() {
        val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
        val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
        val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
        println(question1.toString())
        println("${StudentProgress.answered} of ${StudentProgress.total} answered.")
    
    }

---

    3 of 10 answered.

---

### 객체를 컴패니언 객채로 선언

---

    enum class Difficulty {
    	EASY, MEDIUM, HARD
    }
        
    data class Question<T>(
    	val questionText: String,
    	val answer: T,
    	val difficulty: Difficulty
    )
    
    
    class Quiz {
        val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
        val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
        val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
    	
        companion object StudentProgress {
    	    var total: Int = 10
        	var answered: Int = 3
    	}
    }
    
    fun main() {
        println("${Quiz.answered} of ${Quiz.total} answered.")
    
    }

---

    3 of 10 answered.

---

## 새 속성 및 메서드로 클래스 확장

### 확장 속성 추가

<img width="558" alt="스크린샷 2024-03-12 오후 4 44 18" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/6f9c366f-087e-4ad8-908e-ddb0d8f73269">

---

    enum class Difficulty {
    	EASY, MEDIUM, HARD
    }
        
    data class Question<T>(
    	val questionText: String,
    	val answer: T,
    	val difficulty: Difficulty
    )
    
    
    class Quiz {
        val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
        val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
        val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
    	
        companion object StudentProgress {
    	    var total: Int = 10
        	var answered: Int = 3
    	}
    }
    
    val Quiz.StudentProgress.progressText: String
        get() = "${answered} of ${total} answered"
    
    fun main() {
        println(Quiz.progressText)
    
    }

---

    3 of 10 answered.

---

### 확장 함수 추가

<img width="554" alt="스크린샷 2024-03-12 오후 4 52 42" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/3b0d5af1-792e-4b7f-bb17-1f59a03c4435">

---

    enum class Difficulty {
    	EASY, MEDIUM, HARD
    }
        
    data class Question<T>(
    	val questionText: String,
    	val answer: T,
    	val difficulty: Difficulty
    )
    
    
    class Quiz {
        val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
        val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
        val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
    	
        companion object StudentProgress {
    	    var total: Int = 10
        	var answered: Int = 3
    	}
    }
    
    val Quiz.StudentProgress.progressText: String
        get() = "${answered} of ${total} answered"
    
    fun Quiz.StudentProgress.printProgressBar() {
        repeat(Quiz.answered) { print("▓") }
        repeat(Quiz.total - Quiz.answered) { print("▒") }
        println()
        println(Quiz.progressText)
    }
    
    
    fun main() {
        Quiz.printProgressBar()
    }

---

    ▓▓▓▒▒▒▒▒▒▒
    3 of 10 answered.

---

## 인터페이스를 사용하여 확장 함수 다시 작성

<img width="563" alt="스크린샷 2024-03-12 오후 7 11 43" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/55b1ce3a-220b-434f-90fe-ddfe0fe5ccbb">

<img width="565" alt="스크린샷 2024-03-12 오후 7 12 11" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/c474b14c-1eb8-4098-822a-90c1cd727771">

---

    enum class Difficulty {
    	EASY, MEDIUM, HARD
    }
        
    data class Question<T>(
    	val questionText: String,
    	val answer: T,
    	val difficulty: Difficulty
    )
    
    interface ProgressPrintable {
    	val progressText: String
        fun printProgressBar()
    }
    
    
    class Quiz : ProgressPrintable {
        val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
        val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
        val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
    	
        companion object StudentProgress {
    	    var total: Int = 10
        	var answered: Int = 3
    	}
    	override val progressText: String
            get() = "${answered} of ${total} answered"
        override fun printProgressBar() {
    		repeat(Quiz.answered) { print("▓") }
    		repeat(Quiz.total - Quiz.answered) { print("▒") }
    		println()
    		println(progressText)
    	}
    }
    
    
    fun main() {
        Quiz().printProgressBar()
    }

---

    ▓▓▓▒▒▒▒▒▒▒
    3 of 10 answered.

---

## 범위 함수를 사용하여 클래스 속성 및 메서드에 액세스


let() 을 이용하면 it을 사용하여 람다 표현식의 객체를 참조할 수 있습니다.

---

    fun printQuiz() {
        println(question1.questionText)
        println(question1.answer)
        println(question1.difficulty)
        println()
        println(question2.questionText)
        println(question2.answer)
        println(question2.difficulty)
        println()
        println(question3.questionText)
        println(question3.answer)
        println(question3.difficulty)
        println()
    }

---

    fun printQuiz() {
        question1.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question2.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question3.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
    }

---

### apply() 를 사용하여 변수 없이 객체의 메서드 호출

---

    enum class Difficulty {
    	EASY, MEDIUM, HARD
    }
        
    data class Question<T>(
    	val questionText: String,
    	val answer: T,
    	val difficulty: Difficulty
    )
    
    interface ProgressPrintable {
    	val progressText: String
        fun printProgressBar()
    }
    
    
    class Quiz : ProgressPrintable {
        val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
        val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
        val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
    	
        companion object StudentProgress {
    	    var total: Int = 10
        	var answered: Int = 3
    	}
    	override val progressText: String
            get() = "${answered} of ${total} answered"
        override fun printProgressBar() {
    		repeat(Quiz.answered) { print("▓") }
    		repeat(Quiz.total - Quiz.answered) { print("▒") }
    		println()
    		println(progressText)
    	}
        fun printQuiz() {
        question1.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question2.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question3.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
    }
    }
    
    
    
    fun main() {
        Quiz().apply {
    	    printQuiz()
    
        }
    }

---









