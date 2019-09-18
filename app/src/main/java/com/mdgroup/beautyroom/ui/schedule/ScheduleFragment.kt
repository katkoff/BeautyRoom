package com.mdgroup.beautyroom.ui.schedule

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.mdgroup.beautyroom.R

class ScheduleFragment : Fragment(R.layout.fragment_schedule) {

    companion object {

        private const val ARG_SERVICE_ID = "ARG_SERVICE_ID"

        fun newInstance(serviceId: Int) = ScheduleFragment().apply {
            arguments = bundleOf(ARG_SERVICE_ID to serviceId)
        }
    }
}