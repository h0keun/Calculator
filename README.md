```๐ก FastCampus ๊ฐ์ ์๊ฐ ๋ฐ ์ ๋ฆฌ```

### Calculator

#### UI
+ TableLayout
+ ConstraintLayout
+ LayoutInflater

#### ๋ฌธ๋ฒ
+ Thread(runOnUiThread)
+ Room DB
+ ํ์ฅํจ์
+ data class

#### ๊ธฐ๋ฅ
+ ์ผ๋ฐ์ ์ธ ๊ณ์ฐ๊ธฐ ๊ธฐ๋ฅ
+ ๊ณ์ฐ๊ธฐ๋ก ์ ์ฅ ๋ฐ ์ญ์ 
+ ๋จ์ผ์ฐ์ฐ๋ง ๊ฐ๋ฅ(์ฌ์น์ฐ์ฐ, ์ฐ์ฐ์์ ๋ฑ ๋ณตํฉ์ ์ผ๋ก ๊ฐ๊ธฐ์ ์์์ผํ  ๋ด์ฉ์ด ๋๋ฌด ๋ง๋ค. ์ฝํ๋ฆฐ์ ์ตํ๋ ๋จ๊ณ์ด๋ ์ด๋์ ๋๋ง..)

<img src="https://user-images.githubusercontent.com/63087903/119833170-d86d1280-bf39-11eb-8b39-9355821f49da.jpg" width="200" height="430"> <img src="https://user-images.githubusercontent.com/63087903/119833184-da36d600-bf39-11eb-9ef5-a446b3eeaccc.jpg" width="200" height="430">

### [2021-04-26 Review]
### [2021-07-09 ]

### xml
+ activity_main.xml - constraintlayout ์ค์ฒฉ์ผ๋ก history_raw.xml ์ inflate ํจ
  ```KOTLIN
  * ๊ณ์ฐ๊ธฐ ํคํจ๋ ์์ญ(TableLayout)๊ณผ ํ์ฌ์๋ ฅ์ค์ธ ๊ณ์ฐ ๋ฐ ๊ฒฐ๊ณผ๊ฐ ๋ณด์ด๋ ์์ญ(View)
    ๋ ์์ญ์ด ํ๋ฉด์ ์ธ๋ก๊ธฐ์ค 1:1.5 ํฌ๊ธฐ๋ก ๋๋์ด ๊ฐ์ง๋ค.
    
    app:layout_constraintVertical_weight="1" >> View ์์ญ
    app:layout_constraintVertical_weight="1.5" >> TableLayout ์์ญ
    
    ์ด๋, TableLayout ์์ญ์ ๊ทธ๋์์ ๊ณ์ฐ๊ธฐ๋ก์ ๋ณด์ฌ์ฃผ๋ history_row๊ฐ ๋ณด์ฌ์ง ์๋ฆฌ์ด๊ธฐ๋ ํ๋ค.
    ๋๋ฌธ์ TableLayout ์์ญํฌ๊ธฐ๋งํผ historyLayout ํฌ๊ธฐ๋ฅผ ์ง์ ํด์ฃผ๊ณ , 
    visibility๋ฅผ ํตํด ์ด๊ธฐ์๋ ์๋ณด์๋ค๊ฐ ๊ณ์ฐ๊ธฐ๋กํ์ธ์ ์ํ ๋ฒํผํด๋ฆญ์ ํคํจ๋ ์์ญ์ ๊ฐ๋ฆฌ๊ณ  visible ๋๊ฒ ํ์๋ค.
    
    app:layout_constraintTop_toTopOf="@id/keypadTableLayout" // ํคํจ๋์ ๋์ผ์ฌ์ด์ฆ
    android:visibility="gone" // ์ด๊ธฐ์๋ ํ๋ฉด์ ๋ณด์ด์ง ์์
    
  * ์์์ ์ธ๊ธํ historyLayout์ ConstraintLayout์ผ๋ก ๋ด๋ถ์ ScrollView์ LinearLayout์ ํฌํจํ๊ณ  ์๋๋ฐ,
    ์ด LinearLayout์ด ๋ฐ๋ก ๊ทธ๋์์ ๊ณ์ฐ๊ธฐ๋ก(history_row.xml) ์ด ๋ณด์ฌ์ง๋ ์๋ฆฌ์ด๋ค.
    ConstraintLayout ์ค์ฒฉ๊ณผ Visibility + LayoutInflate ์ด์ฉํด ํ๋์ xml์์ ์ฌ๋ฌ ๋ ์ด์์์ ๊ทธ๋ฆฌ๋ ๊ฒ์ด ๊ฐ๋ฅํ๋ค. 
  ```
+ TableLayout ์์ ํ๊ณผ์ด  
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
  
  * TableLayout์ ์์ ํํ๋ฅผ ๊ฐ์ง๋ฉฐ, ํ = TableRow / ์ด = TableRow ์์ ๋ค์ด๊ฐ๋ ๊ฐ์ฒด๋ค(Button ๋ฑ) ์ด๋ค.  
    ๋ฌ๋ฆฌ ๋งํ์๋ฉด TableRow์ ์๋ ํ์ ๊ฐฏ์์ด๊ณ  ๊ทธ์์ ๋ค์ด๊ฐ์๋ Button์ ์๋ ์ด์ ๊ฐฏ์ ๋ผ๊ณ  ๋ณด๋ฉด ๋ ๊ฑฐ๊ฐ๋ค.
  ```
+ TableLayout ๋ด๋ถ์ ์ ์ฉํ ์์ฑ๋ค
  ```KOTLIN
  * TableLayout ์์ฑ ์ค android:shrinkColumns="*"  
    : ๋ชจ๋  ์ด์ TableLayout ๋๋น์ ๋ง๊ฒ ์๋์ผ๋ก ์ค์ฌ์ค
    
  * <androidx.appcompat.widget.AppCompatButton/>
    : ๊ณ์ฐ๊ธฐ ๋ฒํผ์ ๋ฐฑ๊ทธ๋ผ์ด๋ ์์, ๋๋ฆผํจ๊ณผ ๋ฑ res/drawable ํด๋์์ ๋ฐ์์ค๊ธฐ์ํด (ripple effect)
    
  * ๋ฒํผ์ width = "wrap_content", height = "match_parent" 
    : ์ด๋ ๊ฒ ๋์ด์ผ TableLayout ์์ ๋ฒํผ๋ค์ด ์๋์ผ๋ก ํฌ๊ธฐ์กฐ์ ๋์ด ๋ค์ด๊ฐ๊ฒ๋๋ค.
    
  * why? AppCompatButton??
    : ์ผ๋ฐ์ ์ผ๋ก style์ ํ๋ง๋ฅผ MaterialComponents๋ก ์ฌ์ฉํ๋ ๊ฒฝ์ฐ๊ฐ ๋ง๋ค. 
      ํ์ง๋ง ์ด ์ํ์์  ์ผ๋ฐ Button์ ๋ ์ด์์์ด ๋จน์ง ์๊ฑฐ๋ ์๋์ ๋ค๋ฅด๊ฒ ๋ฐฑ๊ทธ๋ผ์ด๋ ๋ฐ ๋คํฌํ๋ง๊ฐ ์ ์ฉ๋๋ ๊ฒฝ์ฐ๊ฐ ๋ง๋ค.
      ์ด๋ฅผ ํด๊ฒฐํ๊ธฐ์ํด Button์ androidx.appcompat.widget.AppCompatButton ๋ผ๊ณ  ๋ช์ํด์ฃผ๋ฉด
      Material Button๊ณผ ํท๊ฐ๋ฆฌ์ง ์์ ์๋ํ ๋ฒํผ์ ๋ชจ์์ผ๋ก ๋ ์ด์์์ ์ ๋๋ก ์ ์ ์ฉ๋๋ค.
  ```
+ Button ๋ชจ์์ ์ปค์คํํ๊ณ  ripple ํจ๊ณผ ๋ถ์ฌํ๊ธฐ
  ```KOTLIN
  <?xml version="1.0" encoding="utf-8"?>
  <ripple xmlns:android="http://schemas.android.com/apk/res/android"
      android:color="@color/buttonPressGray">             // ๋ฒํผ ํด๋ฆญ์ ๋ฒํผ์ ์์ 

      <item android:id="@android:id/background">
          <shape android:shape="rectangle">               // ๋ฒํผ์ ํํ : ์ฌ๊ฐํ
              <solid android:color="@color/buttonGray"/>  // ๊ธฐ์กด ๋ฒํผ์ ์์
              <corners android:radius="100dp"/>           // ์ฌ๊ฐํ๋ฒํผ์ ์ฝ๋๋ฅผ ๊น์
              <stroke
                  android:width="1dp"                     // ๋ฒํผ ํ๋๋ฆฌ ์์
                  android:color="@color/buttonPressGray"/>
          </shape>
      </item>
  </ripple>
  
  * ripple ํจ๊ณผ๋ ๋๋ฆผํจ๊ณผ๋ฅผ ๋งํ๋ค. ์์๋ณด๋ฉด item id๋ฅผ background ๋ก ์ง์ ํด ์ฃผ์๋๋ฐ, Ctrl + ์ขํด๋ฆญ ์ผ๋ก ids.xml์ ํ๊ณ  ๋ค์ด๊ฐ๋ฉด
    background ์ธ์๋ checkbox, hint, icon, input, copy ๋ฑ ๋ฌด์ํ ๋ง์ <resources> ๋ค์ด ๋ช์๋์ด์๋ค. 
  ```

### Kotlin Class
+ MainActivity.kt  
  : xml์์ 0~9๊น์ง ์ซ์๋ฒํผ๊ณผ +,- ๋ฑ์ ์ฐ์ฐ๋ฒํผ์ ๊ทธ ์ญํ ์ด ๊ณ์ฐ์ ์ํ ์์์ผ๋ก ์ฌ์ฉ๋๋ค๋ ์ ์ด ๋์ผํ๊ธฐ ๋๋ฌธ์  
  xmlํ์ผ์์ onClick ์์ฑ์ผ๋ก android:onClick="buttonClicked" ๋ถ์ฌํ๊ณ ,  
  when ๋ฌธ๊ณผ ๋๋ค์์ ํตํด ๊ฐ ๋ฒํผ์๋ํ ํจ์ ํธ์ถ์ ํ๋ ๋ฐฉ์์ผ๋ก ๋ค์๊ณผ ๊ฐ์ ํํ์ด ๊ฐ๋ฅํ๋ค.  
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
  
  * ํ๋ฆ์์ฒด๋ ์ด๋ ต์ง ์์ผ๋ ๊ณ์ฐํ๋ ๊ณผ์  ์์ฒด๋ ์๊ฐ๋ณด๋ค ๊ณ ๋ คํด์ผํ  ์ ์ด ๋ง๊ณ  ๊น๋ค๋กญ๋ค.
    ์ด ๋ถ๋ถ์ ๋ํด์ ์ ๋ฆฌํ์๋ฉด ๋์ดํด์ผํ  ์ฝ๋๋ค์ด ๋๋ฌด ๋ฐฉ๋ํ๊ธฐ ๋๋ฌธ์ 
    ํ๋ก์ ํธ ์์ค์ฝ๋๋ฅผ ๋ฐ๋ก ์ฐธ์กฐํ๋ ๊ฒ์ด ์ข์๊ฒ ๊ฐ๋ค. 
  ```
+ LayoutInflate / runOnUiThread  
  : ๊ณ์ฐ๊ธฐ๋ก์ LayoutInflate๋ฅผ ํตํด ํ๋ฉด์ ๋ณด์ฌ์ง๊ฒ๋๋ค.  
    ์๊ณ๋ชจ์์ ๋ฒํผ์ ๋๋ ค๋ฉด history_row.xml์ ์ ์ํ๋ฐ๋ก TextView 2๊ฐ์ ๊ฐ๊ฐ ์ฐ์ฐ๊ณผ์ ๊ณผ ์ฐ์ฐ๊ฒฐ๊ณผ๋ฅผ ๋ด์  
    ScrollView ๋ด๋ถ์ LinearLayout์ ๋ณด์ฌ์ง๊ฒ ๋๋ค. ์ด ๋ ๊ณ์ฐ๊ธฐ๋ก๋ค์ ๊ฐ์ฅ ์ต๊ทผ๊ธฐ๋ก์ด ๊ฐ์ฅ ์์ ๋์ค๊ฒ๋ reversed() ๋ ํํ๋ก ๋ณด์ฌ์ง๊ฒ ๋๋ฉฐ,  
    ์ด ๊ณผ์ ์์ ๋ ์ด์์์ด roomDB์ ๋ด์ฉ์ ๊ฐ์ง๊ณ ์ ์ฆ๊ฐ์ ์ผ๋ก ํ๋ฉด์ ๋ณด์ฌ์ง๋ ๊ฒ ์ด๊ธฐ ๋๋ฌธ์ runOnUiThread๋ฅผ ํจ๊ป ์ฌ์ฉํ๊ฒ ๋๋ค.
  ```KOTLIN
  fun historyButtonClicked(v: View) {
      historyLayout.isVisible = true
      historyLinearLayout.removeAllViews() 

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
  }
  
  * DB์์ ๋ชจ๋  ๊ธฐ๋ก์ ๊ฐ์ ธ์์ ๋ทฐ์ ๋ชจ๋  ๊ธฐ๋ก์ ํ ๋นํ๋ ๊ณผ์ ์ด๋ค.
  * inflate ๋ถ๋ถ์์ null ๊ณผ false์ ์๋ฆฌ๋ ๊ฐ๊ฐ root์ attachedRoot ์๋ฆฌ์ธ๋ฐ,
  * ๋์ค์ addView๋ฅผ ํตํด ๋ถ์ฌ์ค๊ฒ์ด๊ธฐ ๋๋ฌธ์ ์์๊ฐ์ด ์์ฑํ์๋ค.
  * it.expression ๊ณผ it.result ๋ db.historyDao().getAll().reversed().forEach 
    ๊ฐ ๋ฐ๋ it = data class ์ธ history.kt ์ด๋ค.
    (history.kt ๋ roomDB ๋ฅผ ์ฌ์ฉํ๊ธฐ์ํ ํ์ด๋ธ๋ก @Entity ๋ฅผ ๋ฌ์์ฃผ์์ผ๋ฉฐ expression๊ณผ result ๋ @ColumnInfo)
  ```

๐ฅ why?? DB๊ฐ์ ๋ถ๋ฌ๋ค์ด๋๋ฐ ์ฐ๋ ๋๋ฅผ ์ฌ์ฉํ๋ ๊ฒ์ผ๊น?  
๋ช๋ช ๋งํฌ์ ์ข๊ฒ ์ค๋ช์ ํด์ฃผ๊ณ  ์์ด์ ๊ทธ ๋งํฌ๋ค์ ์ฒจ๋ถํ๋ค.  
+ [์๋๋ก์ด๋์์ ์ฐ๋ ๋๋](https://salix97.tistory.com/79)
+ [ํธ๋ค๋ฌ, ์ค๋ ๋, ๋ณ๋ ฌ์ฒ๋ฆฌ, ๋๊ธฐํ๊ฐ ์ ํ์ํ ๊น](https://ebbnflow.tistory.com/189)
+ [์๋๋ก์ด๋ Handler ์๊ณ  ์ฐ์](https://brunch.co.kr/@mystoryg/84)
+ [runOnUiThread](https://itmining.tistory.com/6)
+ [์์ฃผ ์ ์ฉํ๋ ์ฌ์ดํธ!!](https://recipes4dev.tistory.com/143)




### ๐ก Room [๐](https://developer.android.com/training/data-storage/room/defining-data?hl=ko)
#### ๐ฅ Room ์ด๋??
```KOTLIN
๊ณต์๋ฌธ์์ ๋ฐ๋ฅด๋ฉด, Room์ SQLite๋ฅผ ์ถ์ํํ์ฌ ์ ๊ณตํ๊ธฐ ๋๋ฌธ์ 
SQLite์์ ์ง์ํ๋ ๊ธฐ๋ฅ๋ค์ ์ ๋ถ ํ์ฉํ๋ฉด์ ๋ณด๋ค ์ฌ์ด ๋ฐ์ดํฐ ๋ฒ ์ด์ค ์ฌ์ฉ์ด ๊ฐ๋ฅํ๋ค๊ณ  ํ๋ค.

* ์๋นํ ์์ ๊ตฌ์กฐํ๋ ๋ฐ์ดํฐ๋ฅผ ์ฒ๋ฆฌํ๋ ์ฑ์ ๋ฐ์ดํฐ๋ฅผ ๋ก์ปฌ๋ก ์ ์งํ์ฌ ๋๋จํ ์ด์ ์ ์ป์ ์ ์์ต๋๋ค. 
๊ฐ์ฅ ์ผ๋ฐ์ ์ธ ์ฌ์ฉ ์ฌ๋ก๋ ๊ด๋ จ ๋ฐ์ดํฐ๋ฅผ ์บ์ฑํ๋ ๊ฒ์๋๋ค. 
์ด๋ฐ ๋ฐฉ์์ผ๋ก ๊ธฐ๊ธฐ๊ฐ ๋คํธ์ํฌ์ ์ก์ธ์คํ  ์ ์์ ๋ ์คํ๋ผ์ธ ์ํ์ธ ๋์์๋ ์ฌ์ฉ์๊ฐ ์ฌ์ ํ ์ฝํ์ธ ๋ฅผ ํ์ํ  ์ ์์ต๋๋ค. 
๋์ค์ ๊ธฐ๊ธฐ๊ฐ ๋ค์ ์จ๋ผ์ธ ์ํ๊ฐ ๋๋ฉด ์ฌ์ฉ์๊ฐ ์์ํ ์ฝํ์ธ  ๋ณ๊ฒฝ์ฌํญ์ด ์๋ฒ์ ๋๊ธฐํ๋ฉ๋๋ค. 
Room์ ์ด๋ฌํ ๋ฌธ์ ๋ฅผ ์๋์ผ๋ก ์ฒ๋ฆฌํ๋ฏ๋ก SQLite ๋์  Room์ ์ฌ์ฉํ  ๊ฒ์ ์ ๊ทน์ ์ผ๋ก ๊ถ์ฅํฉ๋๋ค.
```
#### ๐ฅ Room์๋ ์ธ ๊ฐ์ง ์ฃผ์ ๊ตฌ์ฑ์์๊ฐ ์๋ค. (๋ฐ์ดํฐ๋ฒ ์ด์ค / ํญ๋ชฉ / DAO)  
```KOTLIN
* ๋ฐ์ดํฐ๋ฒ ์ด์ค : ๋ฐ์ดํฐ๋ฒ ์ด์ค ํ๋๋ฅผ ํฌํจํ๋ฉฐ ์ฑ์ ์ง์์ ์ธ ๊ด๊ณํ ๋ฐ์ดํฐ์ ๊ธฐ๋ณธ ์ฐ๊ฒฐ์ ์ํ ๊ธฐ๋ณธ ์์ธ์ค ํฌ์ธํธ ์ญํ ์ ํ๋ค.
  
  @Database ๋ก ์ฃผ์์ด ์ง์ ๋ ํด๋์ค๋ ๋ค์ ์กฐ๊ฑด์ ์ถฉ์กฑํด์ผ ํ๋ค.
    1. RoomDatabase๋ฅผ ํ์ฅํ๋ '์ถ์ ํด๋์ค' ์ฌ์ผ ํ๋ค.
    2. ์ฃผ์ ๋ด์ ๋ฐ์ดํฐ๋ฒ ์ด์ค์ ์ฐ๊ฒฐ๋ ํญ๋ชฉ์ ๋ชฉ๋ก์ ํฌํจํด์ผ ํ๋ค.
    3. ์ธ์๊ฐ 0๊ฐ์ด๋ฉฐ @Dao ๋ก ์ฃผ์์ด ์ง์ ๋ ํด๋์ค๋ฅผ ๋ฐํํ๋ ์ถ์ ๋ฉ์๋๋ฅผ ํฌํจํด์ผ ํ๋ค.
  ๋ฐํ์ ์ Room.databaseBuilder() ๋๋ Room.inMemoryDatabaseBuilder()๋ฅผ ํธ์ถํ์ฌ Database ์ธ์คํด์ค๋ฅผ ๊ฐ์ ธ์ฌ ์ ์๋ค.
  
* ํญ๋ชฉ : ๋ฐ์ดํฐ๋ฒ ์ด์ค ๋ด์ ํ์ด๋ธ์ ๋ํ๋ธ๋ค.

* DAO : ๋ฐ์ดํฐ๋ฒ ์ด์ค์ ์ก์ธ์คํ๋ ๋ฐ ์ฌ์ฉ๋๋ ๋ฉ์๋๊ฐ ํฌํจ๋์ด ์๋ค.
  
์ฑ์ Room ๋ฐ์ดํฐ๋ฒ ์ด์ค๋ฅผ ์ฌ์ฉํ์ฌ ๋ฐ์ดํฐ๋ฒ ์ด์ค์ ์ฐ๊ฒฐ๋ ๋ฐ์ดํฐ ์ก์ธ์ค ๊ฐ์ฒด ๋๋ DAO๋ฅผ ๊ฐ์ ธ์จ๋ค. 
๊ทธ๋ฐ ๋ค์ ์ฑ์ ๊ฐ DAO๋ฅผ ์ฌ์ฉํ์ฌ ๋ฐ์ดํฐ๋ฒ ์ด์ค์์ ํญ๋ชฉ์ ๊ฐ์ ธ์ค๊ณ  ํญ๋ชฉ์ ๋ณ๊ฒฝ์ฌํญ์ ๋ค์ ๋ฐ์ดํฐ๋ฒ ์ด์ค์ ์ ์ฅํ๋ค. 
๋ง์ง๋ง์ผ๋ก ์ฑ์ ํญ๋ชฉ์ ์ฌ์ฉํ์ฌ ๋ฐ์ดํฐ๋ฒ ์ด์ค ๋ด์ ํ์ด๋ธ ์ด์ ํด๋นํ๋ ๊ฐ์ ๊ฐ์ ธ์ค๊ณ  ์ค์ ํ๋ค.
```
#### ๐ฅ ์ด๋ป๊ฒ ์ฌ์ฉํ๋์ง ๋ณธ ํ๋ก์ ํธ๋ฅผ ํตํด ์๋ผ๋ณด์
1. build.gradle์ room ๋ผ์ด๋ธ๋ฌ๋ฆฌ ์ถ๊ฐ 
2. data class๋ฅผ ๋ง๋ ๋ค (ํ์ด๋ธ ์์ฑ)  
  - ๋ณดํต ๋ฐ์ดํฐ ํด๋์ค ์์ฒด๋ฅผ DB์ ํ์ด๋ธ(room์ ๋ฐ์ดํฐํด๋์ค)๋ก ์ฌ์ฉํ๋ค.  
    ์ด๋ฅผ์ํด @Entitiy ์ด๋ธํ์ด์์ ์ถ๊ฐํด์ฃผ๋ฉฐ, ๋ํ ๋ฐ์ดํฐ ํด๋์ค ๋ด์ ๋ณ์๋ค๋ ์ด๋ค ์ด๋ฆ์ผ๋ก DB์ ์ ์ฅํ ์ง๋ฅผ ๋ช์ํด์ค๋ค. (@PrivaryKey / @ColumnInfo)
  ```KOTLIN
  @Entity
  data class History(
     @PrimaryKey val uid: Int?,
     @ColumnInfo(name = "expression") val expression: String?,
     @ColumnInfo(name = "result") val result: String?
  )
  ```
3. DAO ์ธํฐํ์ด์ค๋ฅผ ๋ง๋ ๋ค
  - ๋ฐ์ดํฐ๋ฅผ ์ค๊ณ ๊ฐ๊ฒ ํด์ฃผ๋ ์ญํ ์ ํ๋ ์ธํฐํ์ด์ค์ด๋ค. @Dao ์ด๋ธํ์ด์์ ์ถ๊ฐํด์ฃผ๋ฉฐ,  
    2.์ ์๋ data class์ Entitiy๋ฅผ ์กฐํ, ์ ์ฅ, ์ญ์ ๋ฑ์ ์ด๋ป๊ฒ ํ ์ง ์ ์ํด์ค๋ค.
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
  - Entity ์ ๋ถ ์กฐํํ๊ธฐ : history ํ์ด๋ธ์์ ๋ชจ๋  ์ํฐํฐ๋ค์ ๊ฐ์ ธ์จ๋ค(์กฐํํ๋ค)
  ```KOTLIN
  @Query("SELECT * FROM history")
  fun getAll(): List<History>
  ```
  - ์ ์ฅ
  ```KOTLIN
  @Insert
  fun insertHistory(history: History)
  ```
  - ์ ๋ถ ์ญ์ 
  ```KOTLIN
  @Query("DELETE FROM hisory")
  fun deleteAll()
  ```
  - ์ด ์ธ์๋ WHERE๋ฅผ ํตํด ์กฐ๊ฑด์ ๋ถํฉํ๋ ๊ฒฝ์ฐ๋ง SELECT ํ๋ ๋ฑ ์ฌ๋ฌ๊ฐ์ง ์ฟผ๋ฆฌ๋ฌธ์ ๋ํด์  ์ถ๊ฐ์ ์ธ ํ์ต์ด ํ์ํ๋ค.

4. ๋ฐ์ดํฐ๋ฒ ์ด์ค ์์ฑ
  - ์ถ์ํด๋์ค๋ก ๋ฐ์ดํฐ๋ฒ ์ด์ค๋ฅผ ์์ฑํ๊ณ  RoomDatabase()๋ฅผ ์์ํ๋ค.  
    @Database์ ์ฌ์ฉํ  ํ์ด๋ธ์ ๋ฑ๋กํด์ฃผ์ด์ผ ํ๋ฉฐ, ๋ฒ์ ์ ์์ฑํด์ฃผ์ผํ๋ค  
    (์ฑ ์๋ฐ์ดํธ์ ํ์ด๋ธ ๊ตฌ์กฐ๊ฐ ๋ฐ๋ ์ ์๊ธฐ ๋๋ฌธ์ ๋ง์ด๊ทธ๋ ์ด์์ ํด์ฃผ๋ ๋๋)
  ```KOTLIN
  @Database(entities = [History::class], version = 1)
  abstract class AppDatabase : RoomDatabase(){ 
      abstract fun historyDao(): HistoryDao
  }
  ```
5. MainActivity์์ ์์ฑํ ๋ฐ์ดํฐ๋ฒ ์ด์ค ์ธ์คํด์ค ๊ฐ์ ธ์ค๊ธฐ(์ฌ์ฉํ๊ธฐ)
  ```KOTLIN
  * lateinit var db: AppDatabase  // db๋ฅผ ๋ฆ์ ์ด๊ธฐํ๋ก ์ ์ญ๋ณ์๋ก์ ๋จผ์  ์ ์ธํ๋ฉด ์๋ val ์ ๊ฑฐ!
  
  val db = Room.databaseBuilder(    // onCreate ์์ ์ db์ ๊ฐ ํ ๋น   
      applicationContext,
      AppDatabase::class.java, "historyDB"
  ).build()
  
  * ์ฐธ๊ณ  
  ์ฑ์ด ๋จ์ผ ํ๋ก์ธ์ค์์ ์คํ๋๋ฉด AppDatabase ๊ฐ์ฒด๋ฅผ ์ธ์คํด์คํํ  ๋ ์ฑ๊ธํค ๋์์ธ ํจํด์ ๋ฐ๋ผ์ผ ํ๋ค. 
  ๊ฐ RoomDatabase ์ธ์คํด์ค๋ ๋ฆฌ์์ค๋ฅผ ์๋นํ ๋ง์ด ์๋นํ๋ค. 
  ๊ทธ๋ฆฌ๊ณ  ๋จ์ผ ํ๋ก์ธ์ค ๋ด์์ ์ฌ๋ฌ ์ธ์คํด์ค์ ์ก์ธ์คํ  ํ์๊ฐ ๊ฑฐ์ ์๋ค.
  ์ฑ์ด ์ฌ๋ฌ ํ๋ก์ธ์ค์์ ์คํ๋๋ฉด ๋ฐ์ดํฐ๋ฒ ์ด์ค ๋น๋ ํธ์ถ์ enableMultiInstanceInvalidation()์ ํฌํจํ๋ค. 
  ์ด๋ ๊ฒ ํ๋ฉด ๊ฐ ํ๋ก์ธ์ค์ AppDatabase ์ธ์คํด์ค๊ฐ ์์ ๋ ํ ํ๋ก์ธ์ค์์ ๊ณต์  ๋ฐ์ดํฐ๋ฒ ์ด์ค ํ์ผ์ ๋ฌดํจํํ  ์ ์์ผ๋ฉฐ 
  ์ด ๋ฌดํจํ๋ ๋ค๋ฅธ ํ๋ก์ธ์ค ๋ด์ AppDatabase ์ธ์คํด์ค๋ก ์๋ ์ ํ๋๋ค.
  ```
6. ์ํฐ๋นํฐ์์ DB์ INSERTํ๊ฑฐ๋ SELECT ํ๋๋ฑ DB์ ๊ด๋ จ๋ ๊ณผ์ ์ ๋ฉ์ธ์ฐ๋ ๋๊ฐ์๋๋ผ ์๋ก์ด์ฐ๋ ๋์์ ์งํํด์ผํจ
  - DB์ ๊ณ์ฐ๊ธฐ๋ก ๋ฃ์ด์ฃผ๋ ๋ถ๋ถ(insert)
  ```KOTLIN
  * resultButtonClicked ์ ์คํ
  
  Thread(Runnable {
     db.historyDao().insertHistory(History(null, expressionText, resultText))
  }).start()
  
  // DB ์์ถ๋ ฅ ๊ณผ์ ์ ๋ฉ์ธ์ฐ๋ ๋ ์ธ ์ถ๊ฐ ์ฐ๋ ๋์์ ํด์ผํ๋ค. 
  // ์ ์ฝ๋์์ null ์ uid ์ ํด๋นํ๋๋ฐ null๋ก ์ฃผ์ด๋ ๊ธฐ๋ณธํค๋ผ์ ์๋์ผ๋ก +1 ๋์ ๋ค์ด๊ฐ๋ค.
  ```
  - DB์ ์ ์ฅ๋ ๊ณ์ฐ๊ธฐ๋ก ์กฐํ(getAll())ํ์ฌ ๋ทฐ์ ๋ชจ๋  ๊ธฐ๋ก ํ ๋นํ๊ธฐ(LayoutInflater)
  ```KOTLIN
  * historyButtonClicked ์ ์คํ
  
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
  
  // ๋ทฐ๋ฅผ ์์ฑํ์ฌ ๋ฃ์ด์ฃผ๋๋ฐ, ๋ ์ด์์ ์ธํ๋ ์ดํฐ๋ฅผ ์ฌ์ฉํ๋ค.
  // UI ์ฐ๋ ๋๋ฅผ ์ด์ด ํธ๋ค๋ฌ์ ํฌ์คํ๋  ๋ด์ฉ์ ์์ฑํ๊ฒ๋๋ค.
  ```
  - DB์์ ๋ชจ๋  ๊ธฐ๋ก ์ญ์ ํ๊ธฐ
  ```KOTLIN
  Thread(Runnable {
     db.historyDao().deleteAll()
  }).start()
  ```
๐ก ํ์ด๋ธ๊ณผ ๋ฐ์ดํฐ๋ฒ ์ด์ค์ ์ฐจ์ด
  : ๊ฐ๋ตํ๊ฒ ๋งํ์๋ฉด ๋ฐ์ดํฐ๋ฒ ์ด์ค๋ ๋ฐ์ดํฐ๋ฅผ ์ ์ฅํ๋ ์ ์ฅ์๋ฅผ ๋งํ๋ ๊ฒ์ด๊ณ , ํ์ด๋ธ์ ๋ฐ์ดํฐ๋ฒ ์ด์ค์์ ์ค์  ๋ฐ์ดํฐ๊ฐ ์ ์ฅ๋๋ ํํ๋ฅผ ๋งํ๋ค. ์ฆ ํ์ด๋ธ์ ํ์ผ์ ๋ฐ์ดํฐ๋ฅผ ์ ์ฅํ  ๋ ์ด๋ค ๊ตฌ์กฐ๋ก ์ ์ฅํ ์ง ๊ฒฐ์ ํ๋ ๊ฒ์ด๋ผ ๋ณผ ์ ์๋ค.
  
๐ก ํ์ฅํจ์(Extension Function)  
  : ํ์ฅํจ์๋ ํด๋์ค์ ๋ฉค๋ฒ ๋ฉ์๋์ฒ๋ผ ํธ์ถ๋์ง๋ง ํด๋์ค ๋ฐ์์ ํธ์ถ๋๋ ํจ์์ด๋ค.  
    ๋ง์น ๊ธฐ๋ณธ ํด๋์ค์ ์ถ๊ฐ์ ์ผ๋ก ํจ์๋ฅผ ๋ฃ๋ ๊ธฐ๋ฅ์ ํ๋ค.  
    ๋จ, receiver object์ private ๋ protected ํจ์์๋ ์ ๊ทผ์ด ๋ถ๊ฐ๋ฅ!
    ํด๋น ๋ด์ฉ์ ๋ํด์ ๋ค๋ฅธ๊ฐ๋ฐ์ ๋ถ๊ป์ ์ ์ค๋ชํด์ฃผ์  ๋ด์ฉ[๐](https://choheeis.github.io/newblog//articles/2020-12/kotlin-extension-function)
```KOTLIN
* ํ์ฅํจ์๋ฅผ ์ฌ์ฉํ์ฌ String isNumber ๊ตฌํ 

class MainActivity : AppCompatActivity() {
...
}

...

fun String.isNumber(): Boolean {
    return try {
        this.toBigInteger()  // this๋ ์๋ต ๊ฐ๋ฅํ๋ฉฐ, toBigInteger()๋ ๋ฌดํ์ ๊ฐ๊น์ด ์๋ฃํ์ด๋ค.
        true
    } catch (e: NumberFormatException) {
        false
    }

}

๋ณธ ํ๋ก์ ํธ์์ ํ์ฅํจ์์ ์ฌ์ฉ๋ชจ์ต์ ์์ ๊ฐ๋ค. 
๋ง ๊ทธ๋๋ก ์ด๋ฏธ ์ ์๋ ํด๋์ค์์ ํ์ฅํ์ฌ ์ฐ๋ฆฌ๊ฐ ํ์๋ก ํ๋ ๊ธฐ๋ฅ์ ๋ฃ์ด์ค ๋ ์ฌ์ฉํ๋ ๊ธฐ๋ฅ์ผ๋ก
์ฌ๊ธฐ์๋ ์๋ ฅ๋ฐ์ ์ซ์ ๋ฌธ์์ด์ด ์ซ์๋ก ๋ณํ์ด ๊ฐ๋ฅํ์ง ์์ ๋ ์์ธ์ฒ๋ฆฌํ์ฌ false๋ฅผ ๋ฐํํ๋ฉด์
์ซ์๊ฐ ์๋ ๊ฒ์ ํ์ธํ  ์ ์๋๋ก ํ ๋ชจ์ต์ด๋ค.
```

๐ก ์ฐ๋ ๋๋ณด๋จ ์ฝ๋ฃจํด!  
๐ก SpannableStringBuilder = ํ์คํธ์ ๋ถ๋ถ์ ์ผ๋ก ๋์์ธ ํจ๊ณผ๋ฅผ ์ฃผ๊ธฐ ์ํจ 
```KOTLIN
๋ณธ ํ๋ก์ ํธ์์๋ + - ๋ฑ์ ์ฐ์ฐ์๋ฅผ ์๋ ฅํ  ๋์ ์ซ์์ ๊ตฌ๋ถ์ง๊ธฐ ์ํด Green color ๋ฅผ ์ฐ์ฐ์์ ์ ์ฉํ์๋ค.

...

val ssb = SpannableStringBuilder(expressionTextView.text)
ssb.setSpan(
    ForegroundColorSpan(getColor(R.color.green)),
    expressionTextView.text.length - 1,
    expressionTextView.text.length,
    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
)

expressionTextView.text = ssb

...
```
