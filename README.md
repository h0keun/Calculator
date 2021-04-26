## Calculator

#### UI
+ TableLayout
+ ConstraintLayout
+ LayoutInflater

#### 문법
+ Thread(runOnUiThread)
+ Room DB
+ 확장함수
+ data class

#### 기능
+ 일반적인 계산기 기능
+ 계산기록 저장 및 삭제
+ 단일연산만 가능(사칙연산, 연산순서 등 복합적으로 가기엔 쏟아야할 내용이 너무 많다. 코틀린을 익히는 단계이니 어느정도만..)

### [2021-04-26 Review]

### xml
+ TableLayout 에서 행과열  
  : 행 = TableRow / 열 = TableRow안에 들어가는 객체들(Button 등)  
+ TableLayout 속성 중 android:shrinkColumns="*"  
  : 모든 열을 TableLayout 너비에 맞게 자동으로 줄여줌
+ <androidx.appcompat.widget.AppCompatButton/>
  : 계산기 버튼의 백그라운드 색상, 눌림효과 등 res/drawable 폴더에서 받아오기위해 (ripple effect)  
  그냥 Button으로하면 색상적용안됨 why?? style에 테마를 MaterialComponents로 사용하는 경우가 많은데  
  이경우 일반 Button의 레이아웃이 먹지 않거나 의도와 다르게 백그라운드 및 다크테마가 적용되는 경우가 많다.  
  이 때 위처럼 Button을 androidx.appcompat.widget.AppCompatButton 라고 명시해주면  
  Material Button과 헷갈리지 않아 레이아웃에 제대로 잘 적용된다.  
+ ConstraintLayout 중첩과 Visibility + LayoutInflate 이용해 하나의 xml에서 여러 레이아웃을 그림  
  LayoutInflate 시킬 다른 xml은 위의 TableLayout에 보여지게됨 

### Kotlin Class
+ xml에서 0~9까지 버튼역할은 동일하기 때문에 xml파일에서 android:onClick="buttonClicked" 부여하고  
  MainActiviry.kt 에서 아래처럼 가능
  ```KOTLIN
  fun buttonClicked(v: View) {
      when(v.id) {
          R.id.button0 -> numberButtonClicked("0")
          R.id.button1 -> numberButtonClicked("1")
          ...
          R.id.buttonPlus -> operatorButtonClicked("+")
          R.id.buttonMinus -> operatorButtonClicked("-")
          ...
      }
  }
  
  ...
  
  private fun numberButtonClicked(number: String) {...}
  private fun operatorButtonClicked(operator: String) {...}
  ``` 
+ Thread - RoomDB 쪽 한번더 보기📌📌📌

+ [.droplast](https://iosroid.tistory.com/92)
+ SpannableStringBuilder = 텍스트에 부분적으로 디자인 효과를 주기 위함 
💡💡 collection 함수들 따로 정리하기
 
