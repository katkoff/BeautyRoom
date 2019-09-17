package com.mdgroup.beautyroom.ui.master.list.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mdgroup.beautyroom.R
import com.mdgroup.beautyroom.domain.model.Master
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_master_list.*

class MasterListItemViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    fun bind(master: Master, onItemClicked: (Int) -> Unit) {
        Glide.with(itemView)
            .load(master.avatarUrl)
            .placeholder(R.drawable.avatar_placeholder)
            .into(circleImageView_avatar)

        val fullName = "${master.firstName} ${master.lastName}"
        textView_masterName.text = fullName.ifEmpty {
            itemView.resources.getString(R.string.unknown_placeholder)
        }

        textView_phone.text = master.mobilePhone.ifEmpty {
            itemView.resources.getString(R.string.unknown_placeholder)
        }

        textView_info.text = master.information.ifEmpty {
            itemView.resources.getString(R.string.unknown_placeholder)
        }

        val servicesString = getMasterServicesString(master)
        textView_services.text = servicesString.ifEmpty {
            itemView.resources.getString(R.string.unknown_placeholder)
        }

        itemView.setOnClickListener { onItemClicked.invoke(master.id) }
    }

    private fun getMasterServicesString(master: Master): String {
        var servicesString = ""
        master.services.forEachIndexed { index, serviceItem ->
            servicesString = when (index) {
                0 -> if (master.services.size == 1) {
                    serviceItem.name
                } else {
                    "${serviceItem.name}, "
                }
                master.services.lastIndex -> servicesString.plus(serviceItem.name)
                else -> servicesString.plus("${serviceItem.name}, ")
            }
        }
        return servicesString
    }
}