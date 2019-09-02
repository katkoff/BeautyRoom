package com.mdgroup.beautyroom.ui.masters.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mdgroup.beautyroom.domain.model.MasterModel
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_master_list.*

class MasterListItemViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    fun bind(masterModel: MasterModel) {
        textView_firstName.text = masterModel.firstName
        textView_lastName.text = masterModel.lastName
        textView_phone.text = masterModel.mobilePhone
        textView_info.text = masterModel.information
    }
}