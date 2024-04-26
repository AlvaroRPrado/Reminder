package com.prado.myrimender.repository

import com.prado.myrimender.data.db.entity.ReminderEntity

interface ReminderRepository {

    suspend fun insertReminder(name:String, hour: Int, minute: Int, isActive: Boolean): Long

    suspend fun updateReminder(id:Long, name: String, hour: Int, minute: Int, isActive: Boolean)

    suspend fun deleteReminder(id: Long)

    suspend fun deleteAllReminder()

    suspend fun getAllReminders(): List<ReminderEntity>
}