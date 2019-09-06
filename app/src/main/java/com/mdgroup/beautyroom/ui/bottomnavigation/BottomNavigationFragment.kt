package com.mdgroup.beautyroom.ui.bottomnavigation

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.mdgroup.beautyroom.R
import com.mdgroup.beautyroom.ui.master.list.MasterListFragment
import kotlinx.android.synthetic.main.fragment_bottom_navigation.*

class BottomNavigationFragment : Fragment(R.layout.fragment_bottom_navigation) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViewModel()
        initBottomNavigationItemListeners()

        goToMasterListFragment()
    }

    private fun goToMasterListFragment() {
        childFragmentManager.beginTransaction().replace(
            R.id.frameLayout_commonContainer,
            MasterListFragment.newInstance())
            .commitNow()
    }

    private fun bindViewModel() {

    }

    private fun initBottomNavigationItemListeners() {
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.masters_menu_item -> {
//                    presenter.onAchievementMenuItemClick()
                    true
                }
                R.id.appointments_menu_item -> {
//                    presenter.onProfileMenuItemClick()
                    true
                }
                else -> false
            }
        }
    }

    companion object {
        fun newInstance() = BottomNavigationFragment().apply { arguments = bundleOf() }
    }
}