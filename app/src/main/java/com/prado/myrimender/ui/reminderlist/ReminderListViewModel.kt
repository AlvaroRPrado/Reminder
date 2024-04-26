package com.prado.myrimender.ui.reminderlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prado.myrimender.data.db.entity.ReminderEntity
import com.prado.myrimender.repository.ReminderRepository
import kotlinx.coroutines.launch

class ReminderListViewModel(
    private val repository: ReminderRepository
) : ViewModel() {
    private val _allRemindersEvent = MutableLiveData<List<ReminderEntity>>()
    val allRemindersEvent: LiveData<List<ReminderEntity>>
        get() = _allRemindersEvent

    fun getReminders() = viewModelScope.launch {
        _allRemindersEvent.postValue(repository.getAllReminders())
    }

}