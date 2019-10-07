package com.mdgroup.beautyroom.ui.appointments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.mdgroup.beautyroom.R
import com.mdgroup.beautyroom.ui.appointments.adapter.AppointmentsAdapter
import com.mdgroup.beautyroom.ui.base.bind
import com.mdgroup.beautyroom.ui.base.snackbar
import kotlinx.android.synthetic.main.fragment_master_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class AppointmentsFragment : Fragment(R.layout.fragment_appointment_list) {

    private val viewModel: AppointmentsViewModel by viewModel()
    private lateinit var adapter: AppointmentsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecycler()
        bindViewModel()
    }

    private fun bindViewModel() {
        bind(viewModel.appointmentList) {
            adapter.submitList(it.toMutableList())
        }
        bind(viewModel.errorMessage) {
            snackbar(it)
        }
        bind(viewModel.isProgress) {
            swipeRefreshLayout.isRefreshing = it
        }
        bind(viewModel.removeAppointmentAlert) {
            initRemoveBottomSheet(it)
        }
    }

    private fun initRemoveBottomSheet(appointmentId: Int) {
        val dialog = BottomSheetDialog(activity!!)
        val sheetView = activity!!.layoutInflater.inflate(R.layout.bottom_sheet_remove_appointment, null)

        val positiveButton = sheetView.findViewById<Button>(R.id.button_positive)
        positiveButton.setOnClickListener {
            viewModel.onPositiveRemoveButtonClicked(appointmentId)
            dialog.dismiss()
        }

        val negativeButton = sheetView.findViewById<Button>(R.id.button_negative)
        negativeButton.setOnClickListener { dialog.dismiss() }

        dialog.setContentView(sheetView)
        dialog.show()
    }

    private fun initRecycler() {
        adapter = AppointmentsAdapter { appointmentId ->
            viewModel.onAppointmentRemoveButtonClicked(appointmentId)
        }
        recyclerView.adapter = adapter

        swipeRefreshLayout.setOnRefreshListener { viewModel.onRefresh() }
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadAppointments()
    }

    companion object {

        fun newInstance(): Fragment {
            return AppointmentsFragment()
        }
    }
}
