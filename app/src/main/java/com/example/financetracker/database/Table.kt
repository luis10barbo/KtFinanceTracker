package com.example.financetracker.database

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

abstract class Table<IdType, Type>(val dbHelper: SQLiteOpenHelper) {
    abstract fun getById(id:IdType): Type
    abstract fun getAll(): List<Type>
    abstract fun save(element: Type)
    abstract fun remove(element: Type)
}