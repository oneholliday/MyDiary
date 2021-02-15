package activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.google.android.material.navigation.NavigationView
import com.jamesholliday.mydiary02.R
import db.DbManager
import kotlinx.android.synthetic.main.activity_show.*

class ShowActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    //Подключаем менеджер БД
    val myDbManager = DbManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)
        tvTittleShow.text = intent.getStringExtra("title")
        tvDataShow.text = intent.getStringExtra("data")
        tvContentShow.text = intent.getStringExtra("content")
        tvCategoryShow.text = intent.getStringExtra("category")
        //Получаем ресурс Navigation View
        val navigateView = findViewById<NavigationView>(R.id.navigate_view)
        //Вызываем листенер, считывающий нажатия с меню навигации
        navigateView.setNavigationItemSelectedListener(this)
    }

    //Функция навигации
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.id_main -> {
                val i = Intent(this,MainActivity::class.java)
                startActivity(i)
            }
            R.id.id_diary -> {
                val i = Intent(this,DiaryActivity::class.java)
                startActivity(i)
            }
            R.id.id_thoughts -> {
                val i = Intent(this,ThoughtsActivity::class.java)
                startActivity(i)
            }
            R.id.id_letter -> {
                val i = Intent(this,LettersActivity::class.java)
                startActivity(i)
            }
            R.id.id_books -> {
                val i = Intent(this, BooksActivity::class.java)
                startActivity(i)
            }
        }
        return true
    }

    //Функции кнопок
    fun addButtOnClick(view: View) {
        Log.d("ЧЕКЕР","Pressed addButt")
        val i = Intent(this, EditActivity::class.java)
        startActivity(i)
    }

    fun MainOnClick(view: View) {
        Log.d("ЧЕКЕР","Pressed mainOnClick")
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDb()
    }
}