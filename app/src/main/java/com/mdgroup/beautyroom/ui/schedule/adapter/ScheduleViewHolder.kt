package com.mdgroup.beautyroom.ui.schedule.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mdgroup.beautyroom.domain.model.TimeBlock
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_time_block_list.*

class ScheduleViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    fun bind(timeBlock: TimeBlock, onItemClicked: (Int) -> Unit) {
        val hour = timeBlock.startTime.toLocalTime().hour
        val minute = timeBlock.startTime.toLocalTime().minute
        textView_time.text = "$hour : $minute"

        itemView.isEnabled = timeBlock.isEnable

        itemView.setOnClickListener { onItemClicked.invoke(5) }
    }
}