package com.mdgroup.beautyroom.ui.masters.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mdgroup.beautyroom.R
import com.mdgroup.beautyroom.domain.model.MasterModel

class MastersRecyclerAdapter : RecyclerView.Adapter<MastersViewHolder>() {

    private var masters = listOf<MasterModel>()

    fun setData(masters: List<MasterModel>) {
        this.masters = masters
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MastersViewHolder {
        return MastersViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_master_list,
                parent,
                false))
    }

    override fun getItemCount() = masters.size

    override fun onBindViewHolder(holder: MastersViewHolder, position: Int) =
        holder.bind(this.masters[position])
}