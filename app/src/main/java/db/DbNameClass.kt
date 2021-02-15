package db

import android.provider.BaseColumns

object DbNameClass {
    //Название БД
    const val DATABASE_VERSION = 9
    const val DATABASE_NAME = "MyDiaryDB"

    //Diary
    //Переменные для работы с таблицей Diary
    const val DIARY_TABLE_NAME = "my_diary" //Название таблицы
    const val DIARY_COLUMN_NAME_CATEGORY = "my_diary_category" //Столбец с категорией
    const val DIARY_COLUMN_NAME_DATA = "my_diary_data" //Столбец с датой
    const val DIARY_COLUMN_NAME_TITLE = "my_diary_title" //Столбец с заголовком
    const val DIARY_COLUMN_NAME_CONTENT = "my_diary_content" //Столбец с описанием

    //Создание и удаление таблицы
    const val CREATE_TABLE_MY_DIARY = "CREATE TABLE IF NOT EXISTS $DIARY_TABLE_NAME (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY," +
            "$DIARY_COLUMN_NAME_DATA TEXT," +
            "$DIARY_COLUMN_NAME_TITLE TEXT," +
            "$DIARY_COLUMN_NAME_CONTENT TEXT," +
            "$DIARY_COLUMN_NAME_CATEGORY TEXT)"
    const val SQL_DELETE_TABLE_DIARY = "DROP TABLE IF EXISTS $DIARY_TABLE_NAME"

    //Thoughts
    //Переменные для работы с таблицей Thoughts
    const val THOUGHTS_TABLE_NAME = "my_thoughts" //Название таблицы
    const val THOUGHTS_COLUMN_NAME_CATEGORY = "my_thoughts_category" //Столбец с категорией
    const val THOUGHTS_COLUMN_NAME_DATA = "my_thoughts_data" //Столбец с датой
    const val THOUGHTS_COLUMN_NAME_TITLE = "my_thoughts_title" //Столбец с заголовком
    const val THOUGHTS_COLUMN_NAME_CONTENT = "my_thoughts_content" //Столбец с описанием

    //Создание и удаление таблицы
    const val CREATE_TABLE_MY_THOUGHTS = "CREATE TABLE IF NOT EXISTS $THOUGHTS_TABLE_NAME (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY," +
            "$THOUGHTS_COLUMN_NAME_DATA TEXT," +
            "$THOUGHTS_COLUMN_NAME_TITLE TEXT," +
            "$THOUGHTS_COLUMN_NAME_CONTENT TEXT," +
            "$THOUGHTS_COLUMN_NAME_CATEGORY TEXT)"
    const val SQL_DELETE_TABLE_THOUGHTS = "DROP TABLE IF EXISTS $THOUGHTS_TABLE_NAME"

    //Letters
    //Переменные для работы с таблицей Letters
    const val LETTERS_TABLE_NAME = "my_letters" //Название таблицы
    const val LETTERS_COLUMN_NAME_CATEGORY = "my_letters_category" //Столбец с категорией
    const val LETTERS_COLUMN_NAME_DATA = "my_letters_data" //Столбец с датой
    const val LETTERS_COLUMN_NAME_TITLE = "my_letters_title" //Столбец с заголовком
    const val LETTERS_COLUMN_NAME_CONTENT = "my_letters_content" //Столбец с описанием

    //Создание и удаление таблицы
    const val CREATE_TABLE_MY_LETTERS = "CREATE TABLE IF NOT EXISTS $LETTERS_TABLE_NAME (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY," +
            "$LETTERS_COLUMN_NAME_DATA TEXT," +
            "$LETTERS_COLUMN_NAME_TITLE TEXT," +
            "$LETTERS_COLUMN_NAME_CONTENT TEXT," +
            "$LETTERS_COLUMN_NAME_CATEGORY TEXT)"
    const val SQL_DELETE_TABLE_LETTERS = "DROP TABLE IF EXISTS $LETTERS_TABLE_NAME"

    //Books
    //Переменные для работы с таблицей Books
    const val BOOKS_TABLE_NAME = "my_books" //Название таблицы
    const val BOOKS_COLUMN_NAME_CATEGORY = "my_books_category" //Столбец с категорией
    const val BOOKS_COLUMN_NAME_DATA = "my_books_data" //Столбец с датой
    const val BOOKS_COLUMN_NAME_TITLE = "my_books_title" //Столбец с заголовком
    const val BOOKS_COLUMN_NAME_CONTENT = "my_books_content" //Столбец с описанием

    //Создание и удаление таблицы
    const val CREATE_TABLE_MY_BOOKS = "CREATE TABLE IF NOT EXISTS $BOOKS_TABLE_NAME (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY," +
            "$BOOKS_COLUMN_NAME_DATA TEXT," +
            "$BOOKS_COLUMN_NAME_TITLE TEXT," +
            "$BOOKS_COLUMN_NAME_CONTENT TEXT," +
            "$BOOKS_COLUMN_NAME_CATEGORY TEXT)"
    const val SQL_DELETE_TABLE_BOOKS = "DROP TABLE IF EXISTS $BOOKS_TABLE_NAME"

}