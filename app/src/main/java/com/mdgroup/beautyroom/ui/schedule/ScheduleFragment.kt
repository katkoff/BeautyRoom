package com.mdgroup.beautyroom.ui.schedule

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.mdgroup.beautyroom.R
import com.mdgroup.beautyroom.ui.base.bind
import com.mdgroup.beautyroom.ui.base.snackbar
import com.mdgroup.beautyroom.ui.schedule.adapter.ScheduleAdapter
import kotlinx.android.synthetic.main.fragment_schedule.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ScheduleFragment : Fragment(R.layout.fragment_schedule) {

    private val scheduleViewModel: ScheduleViewModel by viewModel()
    private lateinit var scheduleAdapter: ScheduleAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViewModel()
        initRecycler()
        initToolbar()
    }

    private fun bindViewModel() {
        bind(scheduleViewModel.errorMessage) {
            snackbar(it)
        }
        bind(scheduleViewModel.isProgress) {
            //            progressBar.isVisible = it
            progressbar.isVisible = false
        }
        bind(scheduleViewModel.timeBlockList) {
            scheduleAdapter.setData(it)
        }
    }

    private fun initToolbar() {
        toolbar.title = arguments?.getString(ARG_SERVICE_NAME)
        toolbar.setNavigationOnClickListener { scheduleViewModel.onBackPressed() }
    }

    private fun initRecycler() {
        scheduleAdapter = ScheduleAdapter {
            Toast.makeText(context, "AAA CLICKED !!! YOU'RE BREATHTAKING :) !!!", Toast.LENGTH_LONG).show()
        }
        recyclerView_schedule.adapter = scheduleAdapter
    }

    override fun onResume() {
        super.onResume()

        scheduleViewModel.loadSchedule(arguments?.getInt(ARG_MASTER_ID, -1) ?: -1)
    }

    companion object {

        private const val ARG_MASTER_ID = "ARG_MASTER_ID"
        private const val ARG_SERVICE_NAME = "ARG_SERVICE_NAME"

        fun newInstance(
            masterId: Int,
            serviceName: String
        ) = ScheduleFragment().apply {
            arguments = bundleOf(ARG_MASTER_ID to masterId)
            arguments = bundleOf(ARG_SERVICE_NAME to serviceName)
        }
    }
}