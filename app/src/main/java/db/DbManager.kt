package db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns
import helpfull.CategoryNameClass
import helpfull.MainListItem
import java.lang.Exception

class DbManager(context: Context) {
    val myDBHelper = DbHelper(context)
    var db: SQLiteDatabase? = null

    //Открытие базы данных
    fun openDb() {
        db = myDBHelper.writableDatabase
    }

    //Добавление в базу данных
    fun insertToDb(category: String, data: String, title: String, content: String): Boolean {
        var retFun: Boolean = false

        try {
            when (category) {
                CategoryNameClass.DIARY -> {
                    val values = ContentValues().apply {
                        put(DbNameClass.DIARY_COLUMN_NAME_DATA, data)
                        put(DbNameClass.DIARY_COLUMN_NAME_TITLE, title)
                        put(DbNameClass.DIARY_COLUMN_NAME_CONTENT, content)
                        put(DbNameClass.DIARY_COLUMN_NAME_CATEGORY, category)
                    }
                    db?.insert(DbNameClass.DIARY_TABLE_NAME, null, values)
                }
                CategoryNameClass.THOUGHTS -> {
                    val values = ContentValues().apply {
                        put(DbNameClass.THOUGHTS_COLUMN_NAME_DATA, data)
                        put(DbNameClass.THOUGHTS_COLUMN_NAME_TITLE, title)
                        put(DbNameClass.THOUGHTS_COLUMN_NAME_CONTENT, content)
                        put(DbNameClass.THOUGHTS_COLUMN_NAME_CATEGORY, category)
                    }
                    db?.insert(DbNameClass.THOUGHTS_TABLE_NAME, null, values)
                }
                CategoryNameClass.LETTERS -> {
                    val values = ContentValues().apply {
                        put(DbNameClass.LETTERS_COLUMN_NAME_DATA, data)
                        put(DbNameClass.LETTERS_COLUMN_NAME_TITLE, title)
                        put(DbNameClass.LETTERS_COLUMN_NAME_CONTENT, content)
                        put(DbNameClass.LETTERS_COLUMN_NAME_CATEGORY, category)
                    }
                    db?.insert(DbNameClass.LETTERS_TABLE_NAME, null, values)
                }
                CategoryNameClass.BOOKS -> {
                    val values = ContentValues().apply {
                        put(DbNameClass.BOOKS_COLUMN_NAME_DATA, data)
                        put(DbNameClass.BOOKS_COLUMN_NAME_TITLE, title)
                        put(DbNameClass.BOOKS_COLUMN_NAME_CONTENT, content)
                        put(DbNameClass.BOOKS_COLUMN_NAME_CATEGORY, category)
                    }
                    db?.insert(DbNameClass.BOOKS_TABLE_NAME, null, values)
                }

            }
            retFun = true
        } catch (e: Exception) {
            retFun = false
        }
        return retFun
    }

    //Удаление из базы данных 1го элемента
    fun removeItemFromDb(category: String, id:String) {
        try {
            when (category) {
                CategoryNameClass.DIARY -> {
                    val selection = BaseColumns._ID + "=$id"
                    db?.delete(DbNameClass.DIARY_TABLE_NAME, selection, null)
                }
                CategoryNameClass.THOUGHTS -> {
                    val selection = BaseColumns._ID + "=$id"
                    db?.delete(DbNameClass.THOUGHTS_TABLE_NAME, selection, null)
                }
                CategoryNameClass.LETTERS -> {
                    val selection = BaseColumns._ID + "=$id"
                    db?.delete(DbNameClass.LETTERS_TABLE_NAME, selection, null)
                }
                CategoryNameClass.BOOKS -> {
                    val selection = BaseColumns._ID + "=$id"
                    db?.delete(DbNameClass.BOOKS_TABLE_NAME, selection, null)
                }

            }
        } catch (e: Exception) {}
    }

    //Чтение из базы данных
    fun readDbData(category: String): ArrayList<MainListItem> {
        val dataList = ArrayList<MainListItem>()
        when (category) {
            CategoryNameClass.DIARY -> {
                val cursor = db?.query(DbNameClass.DIARY_TABLE_NAME, null, null, null, null, null, null)

                while (cursor?.moveToNext()!!) {
                    val dataId = cursor?.getInt(cursor.getColumnIndex((BaseColumns._ID)))
                    val dataData = cursor?.getString(cursor.getColumnIndex((DbNameClass.DIARY_COLUMN_NAME_DATA)))
                    val dataTitle = cursor?.getString(cursor.getColumnIndex((DbNameClass.DIARY_COLUMN_NAME_TITLE)))
                    val dataContent = cursor?.getString(cursor.getColumnIndex((DbNameClass.DIARY_COLUMN_NAME_CONTENT)))
                    val dataCategory = cursor?.getString(cursor.getColumnIndex((DbNameClass.DIARY_COLUMN_NAME_CATEGORY)))
                    dataList.add(MainListItem(dataCategory, dataData, dataTitle, dataContent, dataId))
                }
            }
            CategoryNameClass.THOUGHTS -> {
                val cursor = db?.query(DbNameClass.THOUGHTS_TABLE_NAME, null, null, null, null, null, null)

                while (cursor?.moveToNext()!!) {
                    val dataId = cursor?.getInt(cursor.getColumnIndex((BaseColumns._ID)))
                    val dataData = cursor?.getString(cursor.getColumnIndex((DbNameClass.THOUGHTS_COLUMN_NAME_DATA)))
                    val dataTitle = cursor?.getString(cursor.getColumnIndex((DbNameClass.THOUGHTS_COLUMN_NAME_TITLE)))
                    val dataContent = cursor?.getString(cursor.getColumnIndex((DbNameClass.THOUGHTS_COLUMN_NAME_CONTENT)))
                    val dataCategory = cursor?.getString(cursor.getColumnIndex((DbNameClass.THOUGHTS_COLUMN_NAME_CATEGORY)))
                    dataList.add(MainListItem(dataCategory, dataData, dataTitle, dataContent, dataId))
                }
            }
            CategoryNameClass.LETTERS -> {
                val cursor = db?.query(DbNameClass.LETTERS_TABLE_NAME, null, null, null, null, null, null)

                while (cursor?.moveToNext()!!) {
                    val dataId = cursor?.getInt(cursor.getColumnIndex((BaseColumns._ID)))
                    val dataData = cursor?.getString(cursor.getColumnIndex((DbNameClass.LETTERS_COLUMN_NAME_DATA)))
                    val dataTitle = cursor?.getString(cursor.getColumnIndex((DbNameClass.LETTERS_COLUMN_NAME_TITLE)))
                    val dataContent = cursor?.getString(cursor.getColumnIndex((DbNameClass.LETTERS_COLUMN_NAME_CONTENT)))
                    val dataCategory = cursor?.getString(cursor.getColumnIndex((DbNameClass.LETTERS_COLUMN_NAME_CATEGORY)))
                    dataList.add(MainListItem(dataCategory, dataData, dataTitle, dataContent, dataId))
                }
            }
            CategoryNameClass.BOOKS -> {
                val cursor = db?.query(DbNameClass.BOOKS_TABLE_NAME, null, null, null, null, null, null)

                while (cursor?.moveToNext()!!) {
                    val dataId = cursor?.getInt(cursor.getColumnIndex((BaseColumns._ID)))
                    val dataData = cursor?.getString(cursor.getColumnIndex((DbNameClass.BOOKS_COLUMN_NAME_DATA)))
                    val dataTitle = cursor?.getString(cursor.getColumnIndex((DbNameClass.BOOKS_COLUMN_NAME_TITLE)))
                    val dataContent = cursor?.getString(cursor.getColumnIndex((DbNameClass.BOOKS_COLUMN_NAME_CONTENT)))
                    val dataCategory = cursor?.getString(cursor.getColumnIndex((DbNameClass.BOOKS_COLUMN_NAME_CATEGORY)))
                    dataList.add(MainListItem(dataCategory, dataData, dataTitle, dataContent, dataId))
                }
            }
        }
        return dataList
    }


    fun closeDb() {
        myDBHelper.close()
    }
}