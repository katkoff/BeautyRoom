package com.mdgroup.beautyroom.ui.master.list.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mdgroup.beautyroom.domain.model.Master
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_master_list.*

class MasterListItemViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    fun bind(master: Master, onItemClicked: (String) -> Unit) {
        textView_firstName.text = master.firstName
        textView_lastName.text = master.lastName
        textView_phone.text = master.mobilePhone
        textView_info.text = master.information

        itemView.setOnClickListener { onItemClicked.invoke(master.id) }
    }
}