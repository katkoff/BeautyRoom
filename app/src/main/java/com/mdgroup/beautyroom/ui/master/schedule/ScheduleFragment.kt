package com.mdgroup.beautyroom.ui.master.schedule

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.mdgroup.beautyroom.R
import com.mdgroup.beautyroom.data.local.AppointmentState
import com.mdgroup.beautyroom.ui.base.bind
import com.mdgroup.beautyroom.ui.base.snackbar
import com.mdgroup.beautyroom.ui.master.schedule.adapter.ScheduleAdapter
import kotlinx.android.synthetic.main.fragment_schedule.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter

class ScheduleFragment : Fragment(R.layout.fragment_schedule) {

    private val masterId: Int by lazy {
        arguments?.getInt(ARG_MASTER_ID, -1) ?: -1
    }

    private val scheduleViewModel: ScheduleViewModel by viewModel {
        parametersOf(masterId)
    }

    private lateinit var scheduleAdapter: ScheduleAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViewModel()
        initRecycler()
        initToolbar()
        initCalendar()
    }

    private fun bindViewModel() {
        bind(scheduleViewModel.errorMessage) {
            snackbar(it)
        }
        bind(scheduleViewModel.isProgress) {
            progressbar.isVisible = it
        }
        bind(scheduleViewModel.timeBlockList) {
            scheduleAdapter.setData(it)
        }
        bind(scheduleViewModel.appointmentAlert) {
            initBottomSheet(it)
        }
    }

    private fun initBottomSheet(appointmentState: AppointmentState) {
        val dialog = BottomSheetDialog(activity!!)
        val sheetView = activity!!.layoutInflater.inflate(R.layout.bottom_sheet_create_appointment, null)

        val masterNameTextView = sheetView.findViewById<TextView>(R.id.textView_masterName)
        val firstName = appointmentState.master?.firstName?.ifEmpty {
            getString(R.string.unknown_placeholder)
        }
        val lastName = appointmentState.master?.lastName?.ifEmpty {
            getString(R.string.unknown_placeholder)
        }
        masterNameTextView.text = "$firstName $lastName"

        val masterPhoneTextView = sheetView.findViewById<TextView>(R.id.textView_masterPhone)
        masterPhoneTextView.text = appointmentState.master?.mobilePhone?.ifEmpty {
            getString(R.string.unknown_placeholder)
        }

        val masterAddressTextView = sheetView.findViewById<TextView>(R.id.textView_masterAddress)
        masterAddressTextView.text = appointmentState.master?.address?.ifEmpty {
            getString(R.string.unknown_placeholder)
        }

        val serviceNameTextView = sheetView.findViewById<TextView>(R.id.textView_serviceName)
        serviceNameTextView.text = appointmentState.service?.name?.ifEmpty {
            getString(R.string.unknown_placeholder)
        }

        val servicePriceTextView = sheetView.findViewById<TextView>(R.id.textView_servicePrice)
        servicePriceTextView.text =
            appointmentState.service?.price?.toString() ?: getString(R.string.unknown_placeholder)

        val serviceDurationTextView = sheetView.findViewById<TextView>(R.id.textView_serviceDuration)
        serviceDurationTextView.text =
            appointmentState.service?.duration?.toString() ?: getString(R.string.unknown_placeholder)

        val appointmentDateTimeTextView = sheetView.findViewById<TextView>(R.id.textView_appointmentDateTime)
        val datePattern = DateTimeFormatter.ofPattern("dd:MM:yyyy")
        val dateString = appointmentState.appointmentDate?.format(datePattern)?.toString().orEmpty()
        val timeString = appointmentState.appointmentTime?.toString().orEmpty()
        appointmentDateTimeTextView.text = "$dateString  $timeString"

        dialog.setContentView(sheetView)
        dialog.show()

        val acceptButton = sheetView.findViewById<Button>(R.id.button_sendAppointment)
        acceptButton.setOnClickListener { Toast.makeText(context, "DONE!", Toast.LENGTH_SHORT).show() }
    }

    private fun initCalendar() {
        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            scheduleViewModel.onDateChangeClicked(LocalDate.of(year, month + 1, dayOfMonth))
        }
    }

    private fun initToolbar() {
        toolbar.title = arguments?.getString(ARG_SERVICE_NAME)
        toolbar.setNavigationOnClickListener { scheduleViewModel.onBackPressed() }
    }

    private fun initRecycler() {
        scheduleAdapter = ScheduleAdapter {
            scheduleViewModel.onTimeBlockClicked(it)
        }
        recyclerView_schedule.adapter = scheduleAdapter
    }

    override fun onResume() {
        super.onResume()

        scheduleViewModel.loadSchedule()
    }

    companion object {

        private const val ARG_MASTER_ID = "ARG_MASTER_ID"
        private const val ARG_SERVICE_NAME = "ARG_SERVICE_NAME"

        fun newInstance(
            masterId: Int,
            serviceName: String
        ) = ScheduleFragment().apply {
            arguments = bundleOf(
                ARG_MASTER_ID to masterId,
                ARG_SERVICE_NAME to serviceName
            )
        }
    }
}