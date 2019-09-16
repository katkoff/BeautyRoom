package com.mdgroup.beautyroom.ui.master.details.servicelist.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mdgroup.beautyroom.R
import com.mdgroup.beautyroom.domain.model.Service
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_service_list.*

class ServiceListItemViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    fun bind(service: Service, onItemClicked: (Int) -> Unit) {
        textView_serviceName.text = service.name.ifEmpty {
            itemView.resources.getString(R.string.unknown_placeholder)
        }
        textView_serviceDescription.text = service.description.ifEmpty {
            itemView.resources.getString(R.string.unknown_placeholder)
        }
        textView_servicePrice.text = service.price.toString()
        textView_serviceDuration.text = service.duration.toString()

        itemView.setOnClickListener { onItemClicked.invoke(service.id) }
    }
}