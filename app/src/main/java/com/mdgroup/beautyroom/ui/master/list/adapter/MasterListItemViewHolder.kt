package com.mdgroup.beautyroom.ui.master.list.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mdgroup.beautyroom.R
import com.mdgroup.beautyroom.domain.model.Master
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_master_list.*

class MasterListItemViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    fun bind(master: Master, onItemClicked: (Int) -> Unit) {
        textView_firstName.text = master.firstName.ifEmpty {
            itemView.resources.getString(R.string.unknown_placeholder)
        }
        textView_lastName.text = master.lastName.ifEmpty {
            itemView.resources.getString(R.string.unknown_placeholder)
        }
        textView_phone.text = master.mobilePhone.ifEmpty {
            itemView.resources.getString(R.string.unknown_placeholder)
        }
        textView_info.text = master.information.ifEmpty {
            itemView.resources.getString(R.string.unknown_placeholder)
        }

        itemView.setOnClickListener { onItemClicked.invoke(master.id) }
    }
}