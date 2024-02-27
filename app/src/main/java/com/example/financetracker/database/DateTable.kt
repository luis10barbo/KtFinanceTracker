package com.example.financetracker.database

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import com.example.financetracker.model.Data
import com.example.financetracker.model.ItemFinanca

class DateTable(dbHelper: SQLiteOpenHelper): Table<Int, Data>(dbHelper) {
    object Columns {
        const val id = BaseColumns._ID
        const val date = "date"
        const val table = "dates"
        fun tableCreationSQL(): String {
            return "CREATE TABLE ${table} (" +
                    "${id} INTEGER PRIMARY KEY," +
                    "${date} TEXT UNIQUE" +
                    ");"
        }
    }

    override fun getAll(): List<Data> {
        TODO("Not yet implemented")
    }

    override fun remove(element: Data) {
        TODO("Not yet implemented")
    }

    override fun save(element: Data) {
        val db = dbHelper.writableDatabase
        val dataFormatada = String.format("%04d-%02d-1", element.ano, element.mes)
        val values = ContentValues().apply {
            put(Columns.date, dataFormatada)
        }
        element.id = db.insert(Columns.table, null, values)

        val financeItemTable = FinanceItemTable(dbHelper)
        for (tipoItem in arrayOf(element.itensGanhos, element.itensPerdas)) {
            for (item in tipoItem) {
                financeItemTable.save(item)
            }
        }
    }

    override fun getById(id: Int): Data {
        TODO("Not yet implemented")
    }
}