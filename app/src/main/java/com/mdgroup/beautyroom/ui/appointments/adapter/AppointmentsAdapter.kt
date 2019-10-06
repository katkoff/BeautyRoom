package com.mdgroup.beautyroom.ui.appointments.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.mdgroup.beautyroom.R
import com.mdgroup.beautyroom.domain.model.Appointment


class AppointmentsAdapter constructor(
    private val onRemoveButtonClicked: (Int) -> Unit
) : ListAdapter<Appointment, AppointmentsViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppointmentsViewHolder {
        return AppointmentsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_appointment_list,
                parent,
                false))
    }


    override fun onBindViewHolder(holder: AppointmentsViewHolder, position: Int) {
        holder.bind(getItem(position), onRemoveButtonClicked)
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Appointment>() {
            override fun areItemsTheSame(oldItem: Appointment, newItem: Appointment): Boolean {
                return oldItem.appointmentId == newItem.appointmentId
            }

            override fun areContentsTheSame(oldItem: Appointment, newItem: Appointment): Boolean {
                return oldItem == newItem
            }
        }
    }
}