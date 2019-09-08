package com.mdgroup.beautyroom.ui.master.details

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.mdgroup.beautyroom.R
import com.mdgroup.beautyroom.ui.base.bind
import kotlinx.android.synthetic.main.fragment_master_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MasterDetailsFragment : Fragment(R.layout.fragment_master_details) {

    private val masterId: String by lazy {
        arguments?.getString(ARG_MASTER_ID, "").orEmpty()
    }

    private val masterDetailsViewModel: MasterDetailsViewModel by viewModel {
        parametersOf(masterId)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViewModel()
        initToolbar()
    }

    private fun bindViewModel() {
        bind(masterDetailsViewModel.master) { master ->
            Glide.with(this@MasterDetailsFragment)
                .load(master.photo)
                .into(image_view_avatar)
            text_view_name.text = "${master.firstName} ${master.lastName} ${master.id}"
            text_view_description.text = master.information
        }
    }

    private fun initToolbar() {
        toolbar.setNavigationOnClickListener {
            masterDetailsViewModel.onBackPressed()
        }
    }

    companion object {

        private const val ARG_MASTER_ID = "ARG_MASTER_ID"

        fun newInstance(masterId: String): Fragment {
            return MasterDetailsFragment().apply {
                arguments = bundleOf(
                    ARG_MASTER_ID to masterId
                )
            }
        }
    }
}