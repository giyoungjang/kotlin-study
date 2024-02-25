## 1. 문자열 출력하기

### 1.1문제

<img width="342" alt="스크린샷 2024-02-25 오후 3 57 38" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/90b60b45-72a6-4fea-86e7-9da05f37e918">

### 1.2 답
---

    fun main(args: Array<String>) {
        val s1 = readLine()!!
        
        println(s1)
    }

---

## 2. a 와 b 출력하기

### 2.1 문제

<img width="321" alt="스크린샷 2024-02-25 오후 3 59 07" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/00730568-7665-4921-b953-e14b92c08d84">

### 2.2 답
---

    fun main(args: Array<String>) {
        val (a, b) = readLine()!!.split(' ').map(String::toInt)
        println("a = $a\nb = $b")
    }

---

\n 은 엔터

## 3. 문자열 반복 출력하기

### 3.1 문제

<img width="328" alt="스크린샷 2024-02-25 오후 4 00 32" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/0216a7db-f745-4e45-b868-3a8c98616f69">

### 3.2 답
---
    
    fun main(args: Array<String>) {
    		val input = readLine()!!.split(' ')
        val s1 = input[0]
        val a = input[1]!!.toInt()
        print(s1.repeat(a))
    }

---

if 문으로도 가능하지만 repeat 로 반복도 가능합니다.

## 4. 대소문자 바꿔서 출력하기

### 4.1 문제

<img width="321" alt="스크린샷 2024-02-25 오후 4 02 07" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/59f0ecf8-a3f4-4c52-92b6-859e04d26f43">

### 4.2 답
---

    fun main(args: Array<String>) {
        val s1 = readLine()!!
        val result = s1.map {
            if (it.isUpperCase()) {
                it.lowercase()
            } else {
                it.uppercase()
            }
        }.joinToString("")
        println(result)
    }

---

if 문으로 UpperCase 는 lowercase 해주고 아닐경우는 uppercase 해준다.

## 5. 특수문자 출력하기

### 5.1 문제

<img width="330" alt="스크린샷 2024-02-25 오후 4 07 02" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/38bc11f9-6b79-42df-a7b4-26d1bacc8e65">

### 5.2 답
---

    fun main(args: Array<String>) {
        println("!@#$%^&*(\\'\"<>?:;")
    }

--

\와 "만 앞에 \를 넣어줘야한다.

## 6. 덧셈식 출력하기

### 6.1 문제

<img width="316" alt="스크린샷 2024-02-25 오후 4 08 40" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/395f3ecf-930d-4672-b4ca-8e84e31a913a">


### 6.2 답
---

    fun main(args: Array<String>) {
        val (a, b) = readLine()!!.split(' ').map(String::toInt)
        println("$a + $b = ${a + b}")
    }

---

## 7. 문자열 붙여서 출력하기

### 7.1 문제

<img width="305" alt="스크린샷 2024-02-25 오후 4 10 33" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/3b2ef8ab-df48-4ee2-8b7e-4ed658bda7e7">

### 7.2 답

---

    fun main(args: Array<String>) {
    		val input = readLine()!!.split(' ')
        val s1 = input[0]
        val s2 = input[1]
        println("$s1$s2")
    }

---

## 8. 문자열 돌리기

### 8.1 문제

<img width="324" alt="스크린샷 2024-02-25 오후 4 11 46" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/5eb46dc9-bbbc-464b-93be-52da979a3ef2">

### 8.2 답
---

    fun main(args: Array<String>) {
        val s1 = readLine()!!
        s1.map {
            print("$it\n")
        }
    }

---

이것도 map 으로 하나씩 출력하여 \n 으로 한다.

## 9. 홀짝 구분하기

### 9.1 문제

<img width="315" alt="스크린샷 2024-02-25 오후 4 21 36" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/c27e3c60-20b9-4eeb-ba4d-7543b5912646">

### 9.2 답
---
    
    fun main(args: Array<String>) {
        val a = readLine()!!.toInt()
        if (a % 2 == 0) {
            println("$a is even")
        } else {
            println("$a is odd")
        }
        
    }

---

if 문을 활용하여 2로 나눈 나머지값이 0 일때와 아닐때로 나누어 출력한다.

## 10. 문자열 겹쳐쓰기

### 10.1 문제

<img width="1149" alt="스크린샷 2024-02-25 오후 4 29 47" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/35278d69-f7d7-4f09-bed4-543affb74b52">

### 10.1 답 
---

    class Solution {
        fun solution(my_string: String, overwrite_string: String, s: Int): String = my_string.replaceRange(s, s + overwrite_string.length, overwrite_string)
    }

---

갑자기 문제가 겁나 어려워졌다. 구글링 결과 
<https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/replace-range.html>
문서에 따라 replaceRange 라는 함수를 사용하면 쉽고 빠르게 변환할 수 있다.
---

    fun CharSequence.replaceRange(
        startIndex: Int,
        endIndex: Int,
        replacement: CharSequence
    ): CharSequence
    (source)

---
- startIndex : 교체할 첫 번째 문자의 인덱스
- endIndex : 문자열에서 유지할 교체 후 첫 번째 문자의 인덱스

그러나

걸리는 시간과 뒤에 나오는 문제들도 풀기 위해서는 stringBuilder 가 필요합니다.

---

    class Solution {
        fun solution(my_string: String, overwrite_string: String, s: Int): String {
        val answer = StringBuilder ()
        val owLen = overwrite_string.length
        val msLen = my_string.length
        answer.append(my_string.substring(0, s))  //He
            .append(overwrite_string)  // lloWorl
            .append(my_string.substring(s + owLen, msLen)) //d
            
        return answer.toString()
        }
    }
    
---


## 11. 문자열 섞기

### 11.1 문제

<img width="323" alt="스크린샷 2024-02-25 오후 5 15 47" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/b425f87c-bdc4-46e3-9721-83aed1f6e7d6">

### 11.2 답
---

    class Solution {
        fun solution(str1: String, str2: String): String {
            val sb = StringBuilder()
            val str1Len = str1.length
            val str2Len = str2.length
            
            var a = 0
            var b = 0
            
            while (a < str1Len && b < str2Len) {
                sb.append(str1[a])
                a ++
                sb.append(str2[b])
                b++
            }
            
            
            return sb.toString()
        }
    }

---

## 12. 문자 리스트를 문자열로 변환하기

### 12.1 문제

<img width="332" alt="스크린샷 2024-02-25 오후 7 05 41" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/249b1984-32d3-4b9d-8e1c-26c07c3c1068">


## 12.2 답
---

    class Solution {
        fun solution(arr: Array<String>): String = arr.joinToString("")
        
    }

---

## 13. 문자열 곱하기



### 13.1 문제

<img width="425" alt="스크린샷 2024-02-25 오후 7 15 34" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/49872b25-2967-4cd4-9526-1e6cd5985909">

### 13.2 답
---
    
    class Solution {
        fun solution(my_string: String, k: Int): String {
            val sb = StringBuilder()
            repeat(k){
                sb.append(my_string)
            }
            return sb.toString()
        }
    }

---

## 14. 더 크게 합치기

### 14.1 문제

<img width="423" alt="스크린샷 2024-02-25 오후 7 19 53" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/e8455847-f670-4242-8449-92cc3034d12d">

### 14.2 답
---

    class Solution {
        fun solution(a: Int, b: Int): Int {
            val first = "$a$b"
            val second = "$b$a"
            
            return if (first.toInt() > second.toInt() || first.toInt() == second.toInt()) {
                first.toInt()
            } else {
                second.toInt()
            }
        }
    }

--

## 15. 두 수의 연산값 비교하기

### 15.1 문제

<img width="317" alt="스크린샷 2024-02-25 오후 7 42 34" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/980013cf-a785-479d-8eaf-2ba3a065cbcc">

### 15.2 답
---

    class Solution {
        fun solution(a: Int, b: Int): Int {
            val first = "$a$b"
            val second = "${2 * a * b}"
            return if (first.toInt() > second.toInt() || first.toInt() == second.toInt()) {
                first.toInt()
            } else {
                second.toInt()
            }
        }
    }

---

## 16. n의 배수

### 16.1 문제

<img width="441" alt="스크린샷 2024-02-25 오후 8 04 02" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/5ab2101d-62ab-4242-90ee-f6b60b150150">

### 16.2 답
---

    class Solution {
        fun solution(num: Int, n: Int): Int = if (num % n == 0) 1 else 0
    }

---

## 17. 공배수

### 17.1 문제

<img width="387" alt="스크린샷 2024-02-25 오후 8 20 44" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/1b4b1fc8-42ce-414f-a171-391c4b6a41da">

### 17.2 답
---

class Solution {
    fun solution(number: Int, n: Int, m: Int): Int = if (number % n == 0 && number % m == 0) 1 else 0
}

---

## 18. 홀짝에 따라 다른 값 반환하기

### 18.1 문제

<img width="530" alt="스크린샷 2024-02-25 오후 8 27 28" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/cfecd97a-4257-49a0-8bc1-3049e6d6a143">

### 18.2 답
---

    class Solution {
        fun solution(n: Int): Int {
            var a = 0
            for (i in n downTo 1 step 2) {
                a += if (n % 2 == 1) {
                    i
                } else {
                    (i * i)
                }
            }
            return a
        }
    }

---

## 19. 조건 문자열

### 19.1 문제

<img width="408" alt="스크린샷 2024-02-25 오후 8 55 56" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/5c08bff4-dccf-44d7-9530-7bcbc908d0e5">

### 19.2 답
---
    
    class Solution {
        fun solution(ineq: String, eq: String, n: Int, m: Int): Int = when {
            ineq == "<" && eq == "=" -> if (n <= m) 1 else 0
            ineq == ">" && eq == "=" -> if (n >= m) 1 else 0
            ineq == "<" && eq == "!" -> if (n < m) 1 else 0
            ineq == ">" && eq == "!" -> if (n > m) 1 else 0
            else -> {0}
        }
    }

---

## 20. flag에 따라 다른 값 반환하기

### 20.1 문제

<img width="502" alt="스크린샷 2024-02-25 오후 9 24 13" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/35c6b937-81bf-4baa-9b37-48878b76eec3">

### 20.2 답
---

    class Solution {
        fun solution(a: Int, b: Int, flag: Boolean): Int = if (flag) {
            a + b
        } else {
            a - b
        }
    }

---

## 21. 

### 21.1 문제



### 21.2 답
---



---

## 22. 

### 22.1 문제



### 22.2 답
---



---

## 23. 

### 23.1 문제



### 23.2 답
---



---

## 24. 

### 24.1 문제



### 24.2 답
---



---

## 25. 

### 25.1 문제



### 25.2 답
---



---

## 26. 

### 26.1 문제



### 26.2 답
---



---

## 27. 

### 27.1 문제



### 27.2 답
---



---

## 28. 

### 28.1 문제



### 28.2 답
---



---

## 39. 

### 39.1 문제



### 39.2 답
---



---

## 40. 

### 40.1 문제



### 40.2 답
---



---

## . 

### .1 문제



### .2 답
---



---

