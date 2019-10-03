package com.mdgroup.beautyroom.ui.appointments.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mdgroup.beautyroom.R
import com.mdgroup.beautyroom.domain.model.Appointment
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_appointment_list.*

class AppointmentsViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    fun bind(appointment: Appointment) {

        textView_serviceName.text = appointment.serviceName.ifEmpty {
            itemView.resources.getString(R.string.unknown_placeholder)
        }

        textView_appointmentDateTime.text = appointment.appointmentDateTime.toString().ifEmpty {
            itemView.resources.getString(R.string.unknown_placeholder)
        }

        textView_serviceDuration.text = appointment.serviceDuration.toString()
    }
}