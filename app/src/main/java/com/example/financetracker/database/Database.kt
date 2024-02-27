package com.example.financetracker.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.lang.Exception

class Database(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        val DATABASE_NAME = "FinanceTracker.db"
        val DATABASE_VERSION = 2
    }

    override fun onCreate(db: SQLiteDatabase?) {
        if (db == null) {
            throw Exception("DB NAO INICIALIZADA")
        }

        db.execSQL(DateTable.Columns.tableCreationSQL())
        db.execSQL(FinanceItemTable.Columns.tableCreationSQL())
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}