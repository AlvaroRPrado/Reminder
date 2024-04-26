package com.prado.myrimender.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.prado.myrimender.data.db.dao.ReminderDao
import com.prado.myrimender.data.db.entity.ReminderEntity

@Database(entities = [ReminderEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract val reminderDao: ReminderDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(context){
                var instance: AppDatabase? = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        "app_database"
                    ).allowMainThreadQueries().build()
                }
                return instance
            }
        }
    }
}