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
  
### Room [📌](https://developer.android.com/training/data-storage/room/defining-data?hl=ko)
1. build.gradle에 room 라이브러리 추가
2. data class를 만든다  
  - 보통 데이터 클래스 자체를 DB의 테이블(room의 데이터클래스)로 사용함 이를위해 @Entitiy 어노테이션을 추가한다. 또한 각각의 변수들도 어떤 이름으로 DB에 저장할지를 명시해준다. (@PrivaryKey / @ColumnInfo)
  ```KOTLIN
  @Entity
  data class History(
     @PrimaryKey val uid: Int?,
     @ColumnInfo(name = "expression") val expression: String?,
     @ColumnInfo(name = "result") val result: String?
  )
  ```
3. DAO 인터페이스를 만든다
  - 데이터를 오고가게 해주는 역할을 하는 인터페이스이다. @Dao 어노테이션을 추가해주며, 2.에 있는 data class의 Entitiy를 조회, 저장, 삭제등을 어떻게 할지 정의해준다.
  ```KOTLIN
  @Dao
  interface HistoryDao {

    @Query("SELECT * FROM history")
    fun getAll(): List<History>

    @Insert
    fun insertHistory(history: History)

    @Query("DELETE FROM history")
    fun deleteAll()

  }
  ```
  - Entity 전부 가져오기(조회) : history 테이블에서 모든 엔티티들을 가져온다(조회한다)
  ```KOTLIN
  @Query("SELECT * FROM history")
  fun getAll(): List<History>
  ```
  - 저장
  ```KOTLIN
  @Insert
  fun insertHistory(history: History)
  ```
  - 전부 삭제
  ```KOTLIN
  @Query("DELETE FROM hisory")
  fun deleteAll()
  ```

+ Thread - RoomDB 쪽 한번더 보기📌📌📌

+ [.droplast](https://iosroid.tistory.com/92)
+ SpannableStringBuilder = 텍스트에 부분적으로 디자인 효과를 주기 위함 
💡💡 collection 함수들 따로 정리하기
 
