package com.prado.myrimender.ui.reminder

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.prado.myrimender.R
import com.prado.myrimender.databinding.FragmentReminderBinding

class ReminderFragment : Fragment(R.layout.fragment_reminder) {

    private lateinit var binding: FragmentReminderBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentReminderBinding.bind(view)
    }



}