package adapters

import activities.ShowActivity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.jamesholliday.mydiary02.R
import db.DbManager
import helpfull.MainListItem

class MyAdapter(listArray: ArrayList<MainListItem>, context: Context) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    private val listArrayR = listArray
    private val contextR = context

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvData = view.findViewById<TextView>(R.id.tvData)
        private val tvTittle = view.findViewById<TextView>(R.id.tvTittle)
        private val tvContent = view.findViewById<TextView>(R.id.tvContent)
        private val tvCategory = view.findViewById<TextView>(R.id.tvCategory)

        fun bind(listItem: MainListItem, context: Context) {
            Log.d("ЧЕКЕР", "Начал наполнять rcView")
            tvData.text = listItem.dataText
            Log.d("ЧЕКЕР", "Заполнил tvData: ${tvData.text}")
            tvCategory.text = listItem.categoryText
            Log.d("ЧЕКЕР", "Заполнил tvData: ${tvData.text}")
            tvTittle.text = listItem.tittleText
            Log.d("ЧЕКЕР", "Заполнил tvTitle: ${tvTittle.text}")
            tvContent.text = listItem.contentText
            Log.d("ЧЕКЕР", "Заполнил tvContent: ${tvContent.text}")
            if (listItem.contentText.length >= 50) {
                Log.d("ЧЕКЕР", "Зашел в IF: ${tvTittle.text}")
                tvContent.text = listItem.contentText.substring(0, 50) + "..."
                Log.d("ЧЕКЕР", "Заполнил tvContent: ${tvContent.text}")
                itemView.setOnClickListener() {
                    Toast.makeText(context, "Нажата: ${tvTittle.text}", Toast.LENGTH_SHORT).show()
                    val i = Intent(context, ShowActivity::class.java).apply {
                        putExtra("data", listItem.dataText)
                        putExtra("title", listItem.tittleText)
                        putExtra("content", listItem.contentText)
                        putExtra("category", listItem.categoryText)
                    }
                    context.startActivity(i)
                }
            } else {
                itemView.setOnClickListener() {
                    Toast.makeText(context, "${tvTittle.text} не кликабельно", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }

    //Надувает view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
        val inflater = LayoutInflater.from(contextR)
        return ViewHolder(inflater.inflate(R.layout.item_layout, parent, false))
    }

    //Получение длины массива
    override fun getItemCount(): Int {
        return listArrayR.size
    }

    //Связывает контекст и массив
    override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {
        var listItem = listArrayR[position]
        holder.bind(listItem, contextR)
    }

    //Функция обновления адаптера
    fun updateAdapter(listArray: List<MainListItem>) {
        listArrayR.clear()
        listArrayR.addAll(listArray)
        notifyDataSetChanged()
    }

    //Функция удаления адаптера
    fun removeItem(category: String, position: Int, dbManager: DbManager) {
        dbManager.removeItemFromDb(category, listArrayR[position].id.toString())
        listArrayR.removeAt(position)
        notifyItemRangeChanged(0, listArrayR.size)
        notifyItemRemoved(position)
    }
}