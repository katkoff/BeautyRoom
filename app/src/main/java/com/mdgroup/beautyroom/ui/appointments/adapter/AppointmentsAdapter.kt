package com.mdgroup.beautyroom.ui.appointments.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mdgroup.beautyroom.R
import com.mdgroup.beautyroom.domain.model.Appointment


class AppointmentsAdapter : RecyclerView.Adapter<AppointmentsViewHolder>() {

    private var itemList = mutableListOf<Appointment>()

    fun setData(newItemList: List<Appointment>) {
        itemList.clear()
        itemList.addAll(newItemList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppointmentsViewHolder {
        return AppointmentsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_appointment_list,
                parent,
                false))
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: AppointmentsViewHolder, position: Int) {
        holder.bind(this.itemList[position])
    }
}