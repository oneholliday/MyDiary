package activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import com.google.android.material.navigation.NavigationView
import com.jamesholliday.mydiary02.R
import activities.MainActivity
import adapters.MyAdapter
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import db.DbManager
import helpfull.CategoryNameClass

class ThoughtsActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    val category = CategoryNameClass.THOUGHTS
    //Подключаем менеджер БД
    val myDbManager = DbManager(this)
    //Объявляем уже сделанный адаптер
    var adapter: MyAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thoughts)
        Log.d("ЧЕКЕР", "Открыта ThoughtsActivity")
        //Получаем ресурс Navigation View
        val navigateView = findViewById<NavigationView>(R.id.navigate_view)
        //Вызываем листенер, считывающий нажатия с меню навигации
        navigateView.setNavigationItemSelectedListener(this)
        //Получаем ресурс ресайклер вью(список итемов)
        val rcView = findViewById<RecyclerView>(R.id.rcView)
        //Ресайклер вью имеет фиксированный размер и является вертикальным списком (каждый новый итем под предыдущим
        rcView.hasFixedSize()
        rcView.layoutManager = LinearLayoutManager(this)
        //Открываем БД
        myDbManager.openDb()
        //Вызываем адаптер который заполняет ресайклер вью
        adapter = MyAdapter(myDbManager.readDbData(category), this)
        rcView.adapter = adapter
        //Добавляем swap helper
        val swapHelper = getSwapMg()
        //Соединяем ресайклер вью и свап хелпер
        swapHelper.attachToRecyclerView(rcView)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.id_main -> {
                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
            }
            R.id.id_diary -> {
                val i = Intent(this, DiaryActivity::class.java)
                startActivity(i)
            }
            R.id.id_thoughts -> {
                Toast.makeText(this, "Ты уже на странице мыслей", Toast.LENGTH_SHORT).show()
            }
            R.id.id_letter -> {
                val i = Intent(this, LettersActivity::class.java)
                startActivity(i)
            }
            R.id.id_books -> {
                val i = Intent(this,BooksActivity::class.java)
                startActivity(i)
            }
        }
        return true
    }

    private fun getSwapMg(): ItemTouchHelper {
        return ItemTouchHelper(object : ItemTouchHelper.
        SimpleCallback(0, ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                adapter?.removeItem(category, viewHolder.adapterPosition, myDbManager)
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDb()
    }
}