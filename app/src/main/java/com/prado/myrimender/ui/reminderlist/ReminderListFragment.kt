package com.prado.myrimender.ui.reminderlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.prado.myrimender.R
import com.prado.myrimender.databinding.FragmentReminderListBinding

class ReminderListFragment : Fragment(R.layout.fragment_reminder_list) {

    private lateinit var binding: FragmentReminderListBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentReminderListBinding.bind(view)
        configureViewListeners()
    }


    private fun configureViewListeners() {
        binding.fabAddReminder.setOnClickListener {
            findNavController().navigate(R.id.action_reminderListFragment_to_reminderFragment)
        }
    }


}