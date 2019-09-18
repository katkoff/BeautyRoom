package com.mdgroup.beautyroom.ui.schedule.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mdgroup.beautyroom.R
import com.mdgroup.beautyroom.domain.model.TimeBlock

class ScheduleAdapter(
    private val onItemClicked: (Int) -> Unit
) : RecyclerView.Adapter<ScheduleViewHolder>() {

    private var itemList = mutableListOf<TimeBlock>()

    fun setData(newItemList: List<TimeBlock>) {
        itemList.clear()
        itemList.addAll(newItemList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        return ScheduleViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_time_block_list,
                parent,
                false))
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        holder.bind(this.itemList[position], onItemClicked)
    }
}