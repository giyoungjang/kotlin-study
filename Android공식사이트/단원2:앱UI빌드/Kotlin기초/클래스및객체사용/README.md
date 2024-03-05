## 1. 시작하기 전에
- 클래스란 집을 짓는다.
- 객체란 데이터로 구성된 클래스 인스턴스
- oop 객체 지향 프로그래밍 ( 프레임 워크 )
- oop - 캡슐화, 추상화, 상속, 다형성
- 캡슐화 - 휴대전화는 카메라, 디스플레이, 메모리 카드, 기타 하드웨어 구성요소와 소프트웨어 구성요소를 캡슐화. 내부에 어떻게 연결되어 있는지 염려할 필요가 없다.
- 추상화 - 휴대전화로 사진을 찍으려면 앱을 열고 촬영할 장면을 가르킨 다음 버튼을 눌러 사진을 찍기만 하면 됩니다. 하드웨어가 어떻게 작동되는지 몰라도 됩니다. 사용자는 사진 촬영이라는 주된 목표에 집중할 수 있습니다.
- 상속 - 상위 하위 관계를 설정하여 다른 클래스의 특성과 동작을 빌드 할 수 있습니다.
- 다향성 - 휴대전화에 블루투스 스피커를 연결한다면 휴대전화는 블루투스를 통해 오디오를 재생할 수 있는 기기가 있다는 사실만 알면 됩니다. 선택할 수 있는 블루투스 스피커가 여러 개 있더라도 각각의 스피커를 사용하는 구체적인 방법을 휴대전화가 알 필요는 없습니다.

## 2. 클래스 정의

<img width="445" alt="스크린샷 2024-03-05 오후 4 28 51" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/4f7f061e-1d0b-4768-be2a-a6da25f273ef">

- [플레이그라운드](https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjoiMS45LjIyIiwicGxhdGZvcm0iOiJqYXZhIiwiYXJncyI6IiIsIm5vbmVNYXJrZXJzIjp0cnVlLCJ0aGVtZSI6ImlkZWEiLCJjb2RlIjoiZnVuIG1haW4oKSB7XG4gICAgdmFsIGtvdGxpbiA9IFwi8J+ZglwiXG4gICAgcHJpbnRsbihrb3RsaW4pXG59In0=) 에서 smartDevice 클래스 정의

---

    class SmartDevice {
        // empty body
    }
    
    fun main() {
    }

--- 

## 3. 클래스 인스턴스 만들기

---

    class SmartDevice {
        // empty body
    }
        
    fun main() {
        val smartTvDevice = SmartDevice()
    }
    
---

## 4. 클래스 메서드 정의

- 휴대전화로 켜고 끌 수 있는 스마트 기기, 스마트 TV 또는 스마트 조명이 있다고 가정하겠습니다.
- turnOn, turnOff 메소드 정의

---

    class SmartDevice {
        fun turnOn() {
            println("Smart device is turned on.")
        }
    
        fun turnOff() {
            println("Smart device is turned off.")
        }
    }

---

<img width="561" alt="스크린샷 2024-03-05 오후 4 38 34" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/02e8a936-d736-42f7-ac84-d347175f2229">

---

    fun main() {
        val smartTvDevice = SmartDevice()
        smartTvDevice.turnOn()
        smartTvDevice.turnOff()
    }

---

    Smart device is turned on.
    Smart device is turned off.

---

## 5. 클래스 속정 정의

- turnOn() 메서드 앞에 있는 줄에서 name 속성을 정의하고 "Android TV" 문자열에 할당합니다.
- name 속성 다음 줄에서 category 속성을 정의하고 "Entertainment" 문자열에 할당한 다음 deviceStatus 속성을 정의하고 "online" 문자열에 할당합니다.
- smartTvDevice 변수 다음 줄에서 println() 함수를 호출한 다음 이 함수에 "Device name is: ${smartTvDevice.name}" 문자열을 전달합니다.

---

    class SmartDevice {
    
        val name = "Android TV"
        val category = "Entertainment"
        var deviceStatus = "online"
    
        fun turnOn() {
            println("Smart device is turned on.")
        }
    
        fun turnOff() {
            println("Smart device is turned off.")
        }
    }
    
    fun main() {
        val smartTvDevice = SmartDevice()
        println("Device name is: ${smartTvDevice.name}")
        smartTvDevice.turnOn()
        smartTvDevice.turnOff()
    }

---

    Device name is: Android TV
    Smart device is turned on.
    Smart device is turned off.

---

### 속성의 getter 함수와 setter 함수

- 예를 들어 TV에 소리 볼륨의 속성을 넣는다고 하였을때 볼륨은 100을 초과하거나 0미만으로 떨어지지 않도록 하려면 setter함수를 작성하면 됩니다.
- name 속성을 대문자로 변환하는 getter 함수를 구현할 수 있씁니다.
  
<img width="564" alt="스크린샷 2024-03-05 오후 4 45 54" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/67702d3a-8019-45a9-b4c5-e2d68b299010">

 - 속성에 getter 및 setter 함수를 정의하지 않으면 Kotlin 컴파일러가 내부적으로 함수를 생성합니다. 예를 들어 var 키워드를 사용하여 speakerVolume 속성을 정의하고 2 값을 할당하는 경우 컴파일러는 다음 코드 스니펫에서 볼 수 있듯이 getter 함수와 setter 함수를 자동으로 생성합니다.

---

    var speakerVolume = 2
        get() = field
        set(value) {
            field = value
        }

---

<img width="568" alt="스크린샷 2024-03-05 오후 4 50 58" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/3cb01eb8-90b2-40a1-aa4c-5c9748750d18">

~~이부분이 이해가 잘 되지 않습니다...~~

- 그래서 범위를 0~100 속하게 하려면

---

    var speakerVolume = 2
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }

---

## 6. 생정자 정의

- 기본생성자로 class SmartDevice constructor()에서 공개 상태 수정자가 없는 경우 constructor를 생략할 수 있습니다.

---

    class SmartDevice {
        ...
    }

---

### 매개변수화된 생성자 정의

- 현재는 name 속성과 category 속성은 변경할 수 없습니다. 그러므로 모든 인스턴스가 속성을 초기화하도록 해야합니다.

---

    class SmartDevice(val name: String, val category: String) {
    
        var deviceStatus = "online"
    
        fun turnOn() {
            println("Smart device is turned on.")
        }
    
        fun turnOff() {
            println("Smart device is turned off.")
        }
    }

---

<img width="577" alt="스크린샷 2024-03-05 오후 5 59 37" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/e57f4874-bd80-438a-a04d-d387a74bfb03">

---

    class SmartDevice(val name: String, val category: String) {
        var deviceStatus = "online"
    
        constructor(name: String, category: String, statusCode: Int) : this(name, category) {
            deviceStatus = when (statusCode) {
                0 -> "offline"
                1 -> "online"
                else -> "unknown"
            }
        }
        ...
    }

---

- 보조생성자를 생성하고 초기화 할 수 있습니다.

## 7. 클래스 간의 관계 구현



## 8. 공개 상태 수정자

- public - 기본 공개 상태 수정자입니다. 모든 위치에서 선언에 액세스할 수 있도록 합니다. 클래스 외부에서 사용하려는 속성과 메서드가 공개로 표시됩니다.
  
- private - 동일한 클래스 또는 소스 파일에서 선언에 액세스할 수 있도록 합니다.

- protected - 서브클래스에서 선언에 액세스할 수 있도록 합니다. 이러한 클래스와 서브클래스를 정의하는 클래스에 사용하려는 속성과 메서드를 protected 공개 상태 수정자로 표시합니다.

- internal - 동일한 모듈에서 선언에 액세스할 수 있도록 합니다. internal 수정자는 private 수정자와 유사하지만 동일한 모듈에서 액세스된다면 클래스 외부에서 내부 속성과 메서드에 액세스할 수 있습니다.

속성과 메서드의 공개 상태를 엄격하게 유지하는 것이 이상적이므로 최대한 자주 private 수정자를 사용하여 이를 선언합니다. 비공개로 유지할 수 없는 경우 protected 수정자를 사용합니다. 보호 상태로 유지할 수 없는 경우 internal 수정자를 사용합니다. 내부에 유지할 수 없는 경우 public 수정자를 사용합니다.

<img width="566" alt="스크린샷 2024-03-05 오후 1 41 07" src="https://github.com/giyoungjang/kotlin-study/assets/126555597/87a0dd21-fb88-431b-a27a-45eaef2effe0">


---
아래는 완성된 코드 입니다.
---


        import kotlin.properties.ReadWriteProperty
        import kotlin.reflect.KProperty
        
        
        open class SmartDevice protected constructor (val name: String, val category: String) {
        
            var deviceStatus = "online"
            	protected set
            
            open val deviceType = "unknown"
        
            open fun turnOn() {
                deviceStatus = "on"
            }
        
            open fun turnOff() {
                deviceStatus = "off"
            }
        }
        
        class SmartTvDevice(deviceName: String, deviceCategory: String) :
            SmartDevice(name = deviceName, category = deviceCategory) {
        
        
            override val deviceType = "Smart TV"
        
            private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)
        
            private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200) 
        
            fun increaseSpeakerVolume() {
                speakerVolume++
                println("Speaker volume increased to $speakerVolume.")
            }
        
            fun nextChannel() {
                channelNumber++
                println("Channel number increased to $channelNumber.")
            }
        
            override fun turnOn() {
                super.turnOn()
                println(
                    "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
                        "set to $channelNumber."
                )
            }
        
            override fun turnOff() {
                super.turnOff()
                println("$name turned off")
            }
        }
            
        class SmartLightDevice(deviceName: String, deviceCategory: String) :
            SmartDevice(name = deviceName, category = deviceCategory) {
        
            override val deviceType = "Smart Light"
                
            private var brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)
        
            fun increaseBrightness() {
                brightnessLevel++
                println("Brightness increased to $brightnessLevel.")
            }
        
            override fun turnOn() {
                super.turnOn()
                brightnessLevel = 2
                println("$name turned on. The brightness level is $brightnessLevel.")
            }
        
            override fun turnOff() {
                super.turnOff()
                brightnessLevel = 0
                println("Smart Light turned off")
            }
        }
            
            
        class SmartHome(
            val smartTvDevice: SmartTvDevice,
            val smartLightDevice: SmartLightDevice
        ) {
            
            var deviceTurnOnCount = 0
            	private set
            
            fun turnOnTv() {
                deviceTurnOnCount++
                smartTvDevice.turnOn()
            }
            
            fun turnOffTv() {
                deviceTurnOnCount--
                smartTvDevice.turnOff()
            }
            
            fun increaseTvVolume() {
                smartTvDevice.increaseSpeakerVolume()
            }
            
            fun changeTvChannelToNext() {
                smartTvDevice.nextChannel()
            }
            
            fun turnOnLight() {
                deviceTurnOnCount++
                smartLightDevice.turnOn()
            }
        
            fun turnOffLight() {
                deviceTurnOnCount--
                smartLightDevice.turnOff()
            }
            
            fun increaseLightBrightness() {
                smartLightDevice.increaseBrightness()
            }
            
            fun turnOffAllDevices() {
                turnOffTv()
                turnOffLight()
            }
        }
        
        class RangeRegulator(
        	initialValue: Int,
            private val minValue: Int,
            private val maxValue: Int,
        ) : ReadWriteProperty<Any?, Int> {
            
            var fieldData = initialValue
            
            override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
                return fieldData
            }
            override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
                if (value in minValue..maxValue) {
                    fieldData = value
                }
            }
        }
        
        fun main() {
            val smartTvDevice = SmartTvDevice("Android TV", "Entertainment")
            smartTvDevice.turnOn()
            
            val smartLightDevice = SmartLightDevice("Google Light", "Utility")
            smartLightDevice.turnOn()
        }
