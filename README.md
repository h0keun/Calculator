```💡 FastCampus 강의 수강 및 정리```

### Calculator

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

<img src="https://user-images.githubusercontent.com/63087903/119833170-d86d1280-bf39-11eb-8b39-9355821f49da.jpg" width="200" height="430"> <img src="https://user-images.githubusercontent.com/63087903/119833184-da36d600-bf39-11eb-9ef5-a446b3eeaccc.jpg" width="200" height="430">

### [2021-04-26 Review]
### [2021-07-09 ]

### xml
+ activity_main.xml - constraintlayout 중첩으로 history_raw.xml 을 inflate 함
  ```KOTLIN
  * 계산기 키패드 영역(TableLayout)과 현재입력중인 계산 및 결과가 보이는 영역(View)
    두 영역이 화면을 세로기준 1:1.5 크기로 나누어 가진다.
    
    app:layout_constraintVertical_weight="1" >> View 영역
    app:layout_constraintVertical_weight="1.5" >> TableLayout 영역
    
    이때, TableLayout 영역은 그동안의 계산기록을 보여주는 history_row가 보여질 자리이기도 하다.
    때문에 TableLayout 영역크기만큼 historyLayout 크기를 지정해주고, visibility를 통해 초기에는 안보였다가 계산기록확인을 위한 버튼클릭시 키패드 영역을 가리고 visible 되게 하였다.
    app:layout_constraintTop_toTopOf="@id/keypadTableLayout" // 키패드와 동일사이즈
    android:visibility="gone" // 초기에는 화면에 보이지 않음
    
  * 위에서 언급한 historyLayout은 ConstraintLayout으로 내부에 ScrollView와 LinearLayout을 포함하고 있는데,
    이 LinearLayout이 바로 그동안의 계산기록(history_row.xml) 이 보여지는 자리이다.
    ConstraintLayout 중첩과 Visibility + LayoutInflate 이용해 하나의 xml에서 여러 레이아웃을 그리는 것이 가능하다. 
  ```
+ TableLayout 에서 행과열  
  ```KOTLIN
  <TableLayout
    ... >
    <TableRow android:layout_weight="1" >
      <Button/>
      <Button/>
      ...
      <Button/>
    </TableRow>
    
    <TableRow android:layout_weight="1" >
      <Button/>
      <Button/>
      ...
      <Button/>
    </TableRow>
    ...
  </TableLayout>  
  ```
  TableLayout은 위의 형태를 가지며, 행 = TableRow / 열 = TableRow 안에 들어가는 객체들(Button 등) 이다.  
  달리 말하자면 TableRow의 수는 행의 갯수이고 그안에 들어가있는 Button의 수는 열의 갯수 라고 보면 될거같다.
  
+ TableLayout 내부에 적용한 속성들
  ```KOTLIN
  * TableLayout 속성 중 android:shrinkColumns="*"  
    : 모든 열을 TableLayout 너비에 맞게 자동으로 줄여줌
    
  * <androidx.appcompat.widget.AppCompatButton/>
    : 계산기 버튼의 백그라운드 색상, 눌림효과 등 res/drawable 폴더에서 받아오기위해 (ripple effect)
    
  * 버튼의 width = "wrap_content", height = "match_parent" 
    : 이렇게 두어야 TableLayout 안에 버튼들이 자동으로 크기조절되어 들어가게된다.
    
  * why? AppCompatButton??
    : 일반적으로 style에 테마를 MaterialComponents로 사용하는 경우가 많다. 
      하지만 이 상태에선 일반 Button의 레이아웃이 먹지 않거나 의도와 다르게 백그라운드 및 다크테마가 적용되는 경우가 많다.
      이를 해결하기위해 Button을 androidx.appcompat.widget.AppCompatButton 라고 명시해주면
      Material Button과 헷갈리지 않아 의도한 버튼의 모양으로 레이아웃에 제대로 잘 적용된다.
  ``` 

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
2. data class를 만든다 (테이블 생성)  
  - 보통 데이터 클래스 자체를 DB의 테이블(room의 데이터클래스)로 사용한다.  
    이를위해 @Entitiy 어노테이션을 추가해주며, 또한 데이터 클래스 내의 변수들도 어떤 이름으로 DB에 저장할지를 명시해준다. (@PrivaryKey / @ColumnInfo)
  ```KOTLIN
  @Entity
  data class History(
     @PrimaryKey val uid: Int?,
     @ColumnInfo(name = "expression") val expression: String?,
     @ColumnInfo(name = "result") val result: String?
  )
  ```
3. DAO 인터페이스를 만든다
  - 데이터를 오고가게 해주는 역할을 하는 인터페이스이다. @Dao 어노테이션을 추가해주며,  
    2.에 있는 data class의 Entitiy를 조회, 저장, 삭제등을 어떻게 할지 정의해준다.
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
  - Entity 전부 조회하기 : history 테이블에서 모든 엔티티들을 가져온다(조회한다)
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
  - 이 외에도 WHERE를 통해 조건에 부합하는 경우만 SELECT 하는 등 여러가지 쿼리문에 대해선 추가적인 학습이 필요하다.

3. 데이터베이스 생성
  - 추상클래스로 데이터베이스를 생성하고 RoomDatabase()를 상속한다.  
    @Database에 사용할 테이블을 등록해주어야 하며, 버전을 작성해주야한다  
    (앱 업데이트시 테이블 구조가 바뀔 수 있기 때문에 마이그레이션을 해주는 느낌)
  ```KOTLIN
  @Database(entities = [History::class], version = 1)
  abstract class AppDatabase : RoomDatabase(){ 
      abstract fun historyDao(): HistoryDao
  }
  ```
4. MainActivity에서 데이터베이스 사용하기
  ```KOTLIN
  lateinit var db: AppDatabase  // db 선언
  
  db = Room.databaseBuilder(    // onCreate 시점에 db에 값 할당   
      applicationContext,
      AppDatabase::class.java,
      name: "historyDB"
  ).build()
  ```
5. 엑티비티에서 DB에 INSERT하거나 SELECT 하는등 DB에 관련된 과정은 메인쓰레드가아니라 새로운쓰레드에서 진행해야함
  - DB에 계산기록 넣어주는 부분(insert)
  ```KOTLIN
  Thread(Runnable {
     db.historyDao().insertHistory(History(null, expressionText, resultText))
  }).start()
  ```
  - DB에 저장된 계산기록 조회(getAll())하여 뷰에 모든 기록 할당하기(LayoutInflater)
  ```KOTLIN
  Thread(Runnable {
     db.historyDao().getAll().reversed().forEach {
        runOnUiThread {
           val historyView = LayoutInflater.from(this).inflate(R.layout.history_row, null, false)
           historyView.findViewById<TextView>(R.id.expressionTextView).text = it.expression
           historyView.findViewById<TextView>(R.id.resultTextView).text = "= ${it.result}"
           historyLinearLayout.addView(historyView)
        }
     }

  }).start()
  ```
  - DB에서 모든 기록 삭제하기
  ```KOTLIN
  Thread(Runnable {
     db.historyDao().deleteAll()
  }).start()
  ```
💡 테이블과 데이터베이스의 차이
  : 간략하게 말하자면 데이터베이스는 데이터를 저장하는 저장소를 말하는 것이고, 테이블은 데이터베이스안에 실제 데이터가 저장되는 형태를 말한다. 즉 테이블은 파일에 데이터를 저장할 때 어떤 구조로 저장할지 결정하는 것이라 볼 수 있다.
  
+ Thread - RoomDB 쪽 한번더 보기📌📌📌

+ [.droplast](https://iosroid.tistory.com/92)
+ SpannableStringBuilder = 텍스트에 부분적으로 디자인 효과를 주기 위함 
