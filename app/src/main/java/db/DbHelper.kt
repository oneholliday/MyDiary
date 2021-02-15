package db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DbHelper(context: Context): SQLiteOpenHelper(context, DbNameClass.DATABASE_NAME, null, DbNameClass.DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(DbNameClass.CREATE_TABLE_MY_DIARY)
        db?.execSQL(DbNameClass.CREATE_TABLE_MY_THOUGHTS)
        db?.execSQL(DbNameClass.CREATE_TABLE_MY_LETTERS)
        db?.execSQL(DbNameClass.CREATE_TABLE_MY_BOOKS)
        Log.d("ЧЕКЕР", "Создались таблицы в БД для Дневник - Книги")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DbNameClass.SQL_DELETE_TABLE_DIARY)
        db?.execSQL(DbNameClass.SQL_DELETE_TABLE_THOUGHTS)
        db?.execSQL(DbNameClass.SQL_DELETE_TABLE_LETTERS)
        db?.execSQL(DbNameClass.SQL_DELETE_TABLE_BOOKS)
        Log.d("ЧЕКЕР", "Удалены таблицы в БД для Дневник - Книги")
        onCreate(db)
    }


}