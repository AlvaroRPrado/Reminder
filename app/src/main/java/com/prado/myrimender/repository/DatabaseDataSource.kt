package com.prado.myrimender.repository

import com.prado.myrimender.data.db.dao.ReminderDao
import com.prado.myrimender.data.db.entity.ReminderEntity

class DatabaseDataSource(private val reminderDAO : ReminderDao) : ReminderRepository {

    override suspend fun insertReminder(
        name: String,
        hour: Int,
        minute: Int,
        isActive: Boolean): Long {

        val reminder = ReminderEntity(
            name = name,
            hour = hour,
            minute = minute,
            isActive = false
        )
        return reminderDAO.insert(reminder)
    }

    override suspend fun updateReminder(
        id: Long,
        name: String,
        hour: Int,
        minute: Int,
        isActive: Boolean
    ) {
       val reminder = ReminderEntity(
           id = id,
           name = name,
           hour = hour,
           minute = minute,
           isActive = false
       )
        return reminderDAO.update(reminder)
    }

    override suspend fun deleteReminder(id: Long) {
        reminderDAO.delete(id)
    }

    override suspend fun deleteAllReminder() {
        reminderDAO.deleteAll()
    }

    override suspend fun getAllReminders(): List<ReminderEntity> {

        return reminderDAO.getAll()
    }
}