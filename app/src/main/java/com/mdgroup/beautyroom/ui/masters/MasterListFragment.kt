package com.mdgroup.beautyroom.ui.masters

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.mdgroup.beautyroom.R
import com.mdgroup.beautyroom.ui.base.bind
import com.mdgroup.beautyroom.ui.base.snackbar
import com.mdgroup.beautyroom.ui.masters.list.MasterListAdapter
import kotlinx.android.synthetic.main.fragment_master_list.*
import org.koin.android.viewmodel.ext.android.viewModel

class MasterListFragment : Fragment(R.layout.fragment_master_list) {

    private val masterListViewModel: MasterListViewModel by viewModel()
    private lateinit var masterListAdapter: MasterListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecycler()
        bindViewModel()
    }

    private fun bindViewModel() {
        bind(masterListViewModel.masterList) {
            masterListAdapter.setData(it)
        }
        bind(masterListViewModel.errorMessage) {
            snackbar(it)
        }
        bind(masterListViewModel.isProgress) {
            progressBar.isVisible = it
        }
    }

    private fun initRecycler() {
        masterListAdapter = MasterListAdapter()
        recyclerView.adapter = masterListAdapter
    }

    override fun onResume() {
        super.onResume()
        masterListViewModel.loadMasterList()
    }

    companion object {
        fun newInstance() = MasterListFragment().apply { arguments = bundleOf() }
    }
}