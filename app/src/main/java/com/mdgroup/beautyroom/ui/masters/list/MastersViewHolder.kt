package com.mdgroup.beautyroom.ui.masters.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mdgroup.beautyroom.domain.model.MasterModel
import kotlinx.android.synthetic.main.item_master_list.view.*

class MastersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(masterModel: MasterModel) {
        itemView.textView_firstName.text = masterModel.firstName
        itemView.textView_lastName.text = masterModel.lastName
        itemView.textView_phone.text = masterModel.mobilePhone
        itemView.textView_info.text = masterModel.information
    }
}