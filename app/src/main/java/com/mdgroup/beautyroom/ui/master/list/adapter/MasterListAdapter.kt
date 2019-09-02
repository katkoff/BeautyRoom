package com.mdgroup.beautyroom.ui.master.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mdgroup.beautyroom.R
import com.mdgroup.beautyroom.domain.model.MasterModel

class MasterListAdapter : RecyclerView.Adapter<MasterListItemViewHolder>() {

    private var itemList = mutableListOf<MasterModel>()

    fun setData(newItemList: List<MasterModel>) {
        itemList.clear()
        itemList.addAll(newItemList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MasterListItemViewHolder {
        return MasterListItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_master_list,
                parent,
                false))
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: MasterListItemViewHolder, position: Int) {
        holder.bind(this.itemList[position])
    }
}