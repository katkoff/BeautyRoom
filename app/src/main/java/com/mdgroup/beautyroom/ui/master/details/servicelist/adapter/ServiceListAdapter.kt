package com.mdgroup.beautyroom.ui.master.details.servicelist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mdgroup.beautyroom.R
import com.mdgroup.beautyroom.domain.model.Service

class ServiceListAdapter(
    private val onItemClicked: (Int) -> Unit
) : RecyclerView.Adapter<ServiceListItemViewHolder>() {

    private var itemList = mutableListOf<Service>()

    fun setData(newItemList: List<Service>) {
        itemList.clear()
        itemList.addAll(newItemList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceListItemViewHolder {
        return ServiceListItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_service_list,
                parent,
                false))
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: ServiceListItemViewHolder, position: Int) {
        holder.bind(this.itemList[position], onItemClicked)
    }
}