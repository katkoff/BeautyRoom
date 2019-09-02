package com.mdgroup.beautyroom.ui.masters

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.mdgroup.beautyroom.R
import com.mdgroup.beautyroom.ui.base.bind
import com.mdgroup.beautyroom.ui.masters.list.MastersRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_master_list.*
import org.koin.android.viewmodel.ext.android.viewModel

class MastersFragment : Fragment(R.layout.fragment_master_list) {

    private val mastersViewModel: MastersViewModel by viewModel()
    private val mastersRecyclerAdapter = MastersRecyclerAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecycler()
        bindViewModel()
    }

    private fun bindViewModel() {
        bind(mastersViewModel.mastersLiveData) {
            mastersRecyclerAdapter.setData(it)
        }
        bind(mastersViewModel.errorMessageLiveData) {
            Snackbar.make(view!!, it, Snackbar.LENGTH_SHORT).show()
        }
        bind(mastersViewModel.progressVisibleLiveData) {
            progressBar_masters.isVisible = it
        }
    }

    private fun initRecycler() {
        recyclerView_masters.adapter = mastersRecyclerAdapter
        recyclerView_masters.layoutManager = LinearLayoutManager(this.context)
    }

    override fun onResume() {
        super.onResume()

        mastersViewModel.getMasters()
    }


    companion object {
        fun newInstance() = MastersFragment().apply { arguments = bundleOf() }
    }
}