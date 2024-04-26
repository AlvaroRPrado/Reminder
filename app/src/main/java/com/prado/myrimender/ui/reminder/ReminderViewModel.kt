package com.prado.myrimender.ui.reminder

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prado.myrimender.R
import com.prado.myrimender.repository.ReminderRepository
import kotlinx.coroutines.launch

class ReminderViewModel(private val repository: ReminderRepository) : ViewModel() {

    private val _reminderStateEventData = MutableLiveData<ReminderState>()
    val reminderStateEventData: LiveData<ReminderState>
        get() = _reminderStateEventData

    private val _messageEventData = MutableLiveData<Int>()
    val messageEventData: LiveData<Int>
        get() = _messageEventData

    fun addOrUpdateReminder(name: String, hour: Int, minute: Int, isAtive: Boolean, id: Long = 0){
        if (id > 0){
            updateReminder(id, name, hour, minute, isAtive)
        }else{
            insertReminder(name, hour, minute, isAtive)
        }
    }
    fun deleteReminder(id: Long) = viewModelScope.launch {
        try {
            if (id > 0){
                repository.deleteReminder(id)
                _reminderStateEventData.value = ReminderState.Delete
                _messageEventData.value = R.string.reminder_deleted_successfully
            }
        }catch (ex: Exception){
            _messageEventData.value = R.string.reminder_error_to_delete
            Log.e(TAG, ex.toString())
        }

    }
    private fun updateReminder(id: Long, name: String, hour: Int, minute: Int, isAtive: Boolean) = viewModelScope.launch{
        try {
            repository.updateReminder(id, name, hour, minute, isAtive)

            _reminderStateEventData.value = ReminderState.Update
            _messageEventData.value = R.string.reminder_updated_successfully
        }catch (ex: Exception){
            _messageEventData.value = R.string.reminder_updated_insuccessfully
            Log.e(TAG, ex.toString())
        }
    }

    private fun insertReminder( name: String, hour: Int, minute: Int, isAtive: Boolean) = viewModelScope.launch{
        try {
            val id = repository.insertReminder(name, hour, minute, isAtive)
            if (id > 0){
                _reminderStateEventData.value =ReminderState.Inserted
                _messageEventData.value = R.string.reminder_inserted_successfully
            }
        }catch (ex: Exception) {
            _messageEventData.value = R.string.reminder_error_to_insert
            Log.e(TAG, ex.toString())
        }

    }



    sealed class ReminderState{
        object Inserted: ReminderState()
        object Update: ReminderState()
        object Delete: ReminderState()
    }

    companion object {
        private val TAG = ReminderViewModel::class.java.simpleName
    }
}