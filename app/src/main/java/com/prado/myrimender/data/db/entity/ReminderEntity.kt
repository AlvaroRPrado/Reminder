package com.prado.myrimender.data.db.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "reminder")
data class ReminderEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "reminder_id") val id: Long = 0,
    @ColumnInfo(name = "reminder_name") val name: String,
    @ColumnInfo(name = "reminder_hour") val hour: Int,
    @ColumnInfo(name = "reminder_minute") val minute: Int,
    @ColumnInfo(name = "reminder_isActive") val isActive: Boolean
    //@ColumnInfo(name = "reminder_messages") val messages: List<String>,
    //@ColumnInfo(name = "reminder_repeatOnDays") val repeatOnDays: List<DayOfWeek>,
   // @ColumnInfo(name = "reminder_randomMessage") val randomMessage: Boolean,

) :  Parcelable
