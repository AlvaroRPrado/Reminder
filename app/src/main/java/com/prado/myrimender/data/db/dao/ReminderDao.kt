package com.prado.myrimender.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.prado.myrimender.data.db.entity.ReminderEntity

@Dao
interface ReminderDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(reminder: ReminderEntity): Long

    @Update
    fun update(reminder: ReminderEntity)

    @Query("DELETE FROM reminder WHERE reminder_id = :id")
    fun delete(id: Long)

    @Query("DELETE FROM reminder")
    fun deleteAll()

    @Query("SELECT * FROM reminder")
    fun getAll(): List<ReminderEntity>
}