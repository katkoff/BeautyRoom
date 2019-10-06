package com.mdgroup.beautyroom.ui.master.details

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.android.material.appbar.AppBarLayout
import com.mdgroup.beautyroom.R
import com.mdgroup.beautyroom.domain.model.Service
import com.mdgroup.beautyroom.ui.base.bind
import com.mdgroup.beautyroom.ui.base.snackbar
import com.mdgroup.beautyroom.ui.master.details.servicelist.adapter.ServiceListAdapter
import kotlinx.android.synthetic.main.fragment_master_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MasterDetailsFragment : Fragment(R.layout.fragment_master_details) {

    private val masterId: Int by lazy {
        arguments?.getInt(ARG_MASTER_ID, -1) ?: -1
    }

    private val masterDetailsViewModel: MasterDetailsViewModel by viewModel {
        parametersOf(masterId)
    }

    private var colorCode: Int = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViewModel()
        initToolbar()
    }

    private fun bindViewModel() {
        bind(masterDetailsViewModel.master) { master ->
            Glide.with(this@MasterDetailsFragment)
                .load(master.avatarUrl)
                .placeholder(R.drawable.avatar_placeholder)
                .into(imageView_avatar)
            textView_name.text = "${master.firstName} ${master.lastName} ${master.id}"
            textView_information.text = master.information.ifEmpty { getString(R.string.unknown_placeholder) }

            textView_phone.text = master.mobilePhone.ifEmpty { getString(R.string.unknown_placeholder) }
            textView_email.text = master.email.ifEmpty { getString(R.string.unknown_placeholder) }
            textView_address.text = master.address.ifEmpty { getString(R.string.unknown_placeholder) }

            initServicesRecycler(master.services, masterId)
        }
        bind(masterDetailsViewModel.errorMessage) {
            snackbar(it)
        }
        bind(masterDetailsViewModel.isProgress) {
            progressbar.isVisible = it
        }
    }

    private fun initServicesRecycler(services: List<Service>, masterId: Int) {
        val serviceListAdapter = ServiceListAdapter { service ->
            masterDetailsViewModel.onServiceClicked(masterId, service)
        }
        recyclerView_cervices.adapter = serviceListAdapter

        serviceListAdapter.setData(services)
    }

    private fun initToolbar() {
        bind(masterDetailsViewModel.master) { master ->
            toolbar.title = "${master.firstName} ${master.lastName}"
        }
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            masterDetailsViewModel.onBackPressed()
        }

        appbarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            colorCode = -verticalOffset
            if (colorCode > 255) colorCode = 255

            // Hide toolbar when scroll
            toolbar.background.alpha = colorCode
            toolbar.alpha = colorCode / 256f
        })
    }

    companion object {

        private const val ARG_MASTER_ID = "ARG_MASTER_ID"

        fun newInstance(masterId: Int) = MasterDetailsFragment().apply {
            arguments = bundleOf(ARG_MASTER_ID to masterId)
        }
    }
}