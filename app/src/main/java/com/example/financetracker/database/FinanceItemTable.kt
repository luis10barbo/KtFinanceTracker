package com.example.financetracker.database

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import com.example.financetracker.model.ItemFinanca

class FinanceItemTable(dbHelper: SQLiteOpenHelper): Table<Int, ItemFinanca>(dbHelper) {
    object Columns {
        const val id = BaseColumns._ID
        const val dateId = "dateId"
        const val type = "type"
        const val value = "value"
        const val table = "financeItem"
        fun tableCreationSQL(): String {
            return "CREATE TABLE ${table}(" +
                    "${id} INTEGER PRIMARY KEY," +
                    "${dateId} INTEGER," +
                    "${type} TEXT," +
                    "${value} FLOAT" +
                    ")"
        }
    }

    override fun getAll(): List<ItemFinanca> {
        TODO("Not yet implemented")
    }

    override fun remove(element: ItemFinanca) {
        TODO("Not yet implemented")
    }

    override fun save(element: ItemFinanca) {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(Columns.dateId, element.dateId)
            put(Columns.type, element.tipo.toString())
            put(Columns.value, element.valor)
        }
        element.id = db.insert(Columns.table, null, values)
    }

    override fun getById(id: Int): ItemFinanca {
        TODO("Not yet implemented")
    }
}