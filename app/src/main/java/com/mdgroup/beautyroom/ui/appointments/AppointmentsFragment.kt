package com.mdgroup.beautyroom.ui.appointments

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
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
            initRemoveDialog(it)
        }
    }

    private fun initRemoveDialog(appointmentId: Int) {
        AlertDialog.Builder(context!!)
            .setTitle(R.string.appointments_remove_dialog_title)
            .setMessage(R.string.appointments_remove_dialog_message)
            .setPositiveButton(R.string.appointments_remove_dialog_positive) { dialog, _ ->
                viewModel.onPositiveRemoveButtonClicked(appointmentId)
                dialog.dismiss()
            }
            .setNegativeButton(R.string.appointments_remove_dialog_negative) { dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()
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
