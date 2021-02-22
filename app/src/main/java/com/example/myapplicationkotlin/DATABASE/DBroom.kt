package com.example.myapplicationkotlin.DATABASE

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [apptable::class],version = 1,exportSchema = false)
abstract class DBroom: RoomDatabase() {

    companion object {

        @Volatile
        private var INSTANCE: DBroom? = null

        fun getInstance(context: Context): DBroom {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DBroom::class.java,
                        "DatabaseRoom"
                    )

                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
    abstract fun tabledao(): Dao_table
}