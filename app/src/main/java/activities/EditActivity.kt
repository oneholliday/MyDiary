package activities

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.jamesholliday.mydiary02.R
import db.DbManager
import helpfull.CategoryNameClass
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*

class EditActivity : AppCompatActivity() {
    //Подключаем менеджер БД
    private val myDbManager = DbManager(this)

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        Log.d("ЧЕКЕР", "Открыта EditActivity")
        //Открываем БД
        myDbManager.openDb()
        val dataView = findViewById<TextView>(R.id.dataText)
        dataView.text = getDate()

    }

    fun exitButtOnClick(view:View){
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }

    fun saveButtOnClick(view: View) {
        Log.d("ЧЕКЕР","Pressed saveButt")
        //Тут написать функцию для кнопки SAVE
        val titleView = findViewById<EditText>(R.id.titleTextEdit)
        val categoryView = findViewById<EditText>(R.id.categoryTextEdit)
        val dataView = findViewById<TextView>(R.id.dataText)
        val contentView = findViewById<TextView>(R.id.contentTextEdit)

        var title = titleView.text.toString()
        var category = categoryView.text.toString()
        var data = dataView.text.toString()
        var content = contentView.text.toString()

        when(category){
            CategoryNameClass.DIARY -> {
                myDbManager.insertToDb(category,data,title,content)
                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
            }
            CategoryNameClass.THOUGHTS -> {
                myDbManager.insertToDb(category,data,title,content)
                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
            }
            CategoryNameClass.LETTERS -> {
                myDbManager.insertToDb(category,data,title,content)
                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
            }
            CategoryNameClass.BOOKS -> {
                myDbManager.insertToDb(category,data,title,content)
                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
            }
            else -> Toast.makeText(this, "Ты неверно ввел категорию, попробуй снова (Дневник, Мысли, Письма, Книги)", Toast.LENGTH_LONG).show()
        }

    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun getDate():String{
        val sdf = SimpleDateFormat("dd/MM/yyyy")
        return sdf.format(Date())
    }
}