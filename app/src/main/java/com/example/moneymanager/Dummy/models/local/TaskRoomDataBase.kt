package com.example.moneymanager.Dummy.models.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Money:: class], version = 1)
abstract  class TaskRoomDataBase: RoomDatabase() {
    abstract fun MoneyDao(): MoneyDao

    companion object {
        private var INSTANCE: TaskRoomDataBase? = null

        fun getDatabaseObject(context: Context): TaskRoomDataBase {
            if (INSTANCE == null) {
                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    TaskRoomDataBase::class.java,
                    "moneydb_db"
                )

                builder.fallbackToDestructiveMigration()

                INSTANCE = builder.build()
                return INSTANCE!!
            } else {
                return INSTANCE!!
            }
        }
    }
}