package com.mdgroup.beautyroom.ui.appointments.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mdgroup.beautyroom.R
import com.mdgroup.beautyroom.domain.model.Appointment
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_appointment_list.*
import org.threeten.bp.format.DateTimeFormatter

class AppointmentsViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    fun bind(appointment: Appointment, onRemoveButtonClicked: (Int) -> Unit) {

        textView_serviceName.text = appointment.serviceName.ifEmpty {
            itemView.resources.getString(R.string.unknown_placeholder)
        }

        textView_masterName.text = appointment.masterName.ifEmpty {
            itemView.resources.getString(R.string.unknown_placeholder)
        }

        textView_masterPhone.text = appointment.masterPhoneNumber.ifEmpty {
            itemView.resources.getString(R.string.unknown_placeholder)
        }

        textView_masterAddress.text = appointment.masterAddress.ifEmpty {
            itemView.resources.getString(R.string.unknown_placeholder)
        }

        textView_servicePrice.text = appointment.servicePrice.toString().ifEmpty {
            itemView.resources.getString(R.string.unknown_placeholder)
        }

        val dateTimePattern = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")
        textView_appointmentDateTime.text = appointment.appointmentDateTime.format(dateTimePattern)

        textView_serviceDuration.text = appointment.serviceDuration.toString()

        button_remove.setOnClickListener { onRemoveButtonClicked.invoke(appointment.appointmentId) }
    }
}