package com.mdgroup.beautyroom.ui.master.schedule.adapter

import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.mdgroup.beautyroom.R
import com.mdgroup.beautyroom.domain.model.TimeBlock
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_time_block_list.*
import java.text.DecimalFormat

class ScheduleViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    fun bind(timeBlock: TimeBlock, onItemClicked: (TimeBlock) -> Unit) {
        val hour = timeBlock.startTime.hour
        val minute = timeBlock.startTime.minute
        val doubleDigitHour = DecimalFormat(DOUBLE_DIGIT_MASK).format(hour)
        val doubleDigitMinute = DecimalFormat(DOUBLE_DIGIT_MASK).format(minute)

        textView_time.text = "$doubleDigitHour : $doubleDigitMinute"

        itemView.isEnabled = timeBlock.isEnable
        if (!timeBlock.isEnable) {
            cardView_itemTime.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.grayDisabled))
        } else {
            cardView_itemTime.setCardBackgroundColor(ContextCompat.getColor(itemView.context, R.color.white))
        }
        imageView_arrowRight.isVisible = timeBlock.isEnable

        itemView.setOnClickListener { onItemClicked.invoke(timeBlock) }
    }

    companion object {
        private const val DOUBLE_DIGIT_MASK: String = "00"
    }
}