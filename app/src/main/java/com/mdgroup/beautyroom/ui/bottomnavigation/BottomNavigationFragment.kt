package com.mdgroup.beautyroom.ui.bottomnavigation

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.commitNow
import androidx.lifecycle.Lifecycle
import com.mdgroup.beautyroom.R
import com.mdgroup.beautyroom.ui.base.bind
import com.mdgroup.beautyroom.ui.bottomnavigation.BottomNavigationScreens.appointmentListScreen
import com.mdgroup.beautyroom.ui.bottomnavigation.BottomNavigationScreens.masterListScreen
import kotlinx.android.synthetic.main.fragment_bottom_navigation.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.terrakok.cicerone.android.support.SupportAppScreen

class BottomNavigationFragment : Fragment(R.layout.fragment_bottom_navigation) {

    private val bottomNavigationViewModel by viewModel<BottomNavigationViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViewModel()
        initBottomNavigation()
        selectCurrentTab()
    }

    private fun bindViewModel() {
        bind(bottomNavigationViewModel.currentScreen) {
            selectTab(it)
            showSelectedTab(it)
        }
    }

    private fun showSelectedTab(selectedScreen: SupportAppScreen) {
        bottomNavigationView.selectedItemId = when (selectedScreen) {
            masterListScreen -> R.id.masters_menu_item
            appointmentListScreen -> R.id.appointments_menu_item
            else -> R.id.masters_menu_item
        }
    }

    private fun initBottomNavigation() {
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            bottomNavigationViewModel.onNavigationItemSelected(menuItem.itemId)
            true
        }
        bottomNavigationView.setOnNavigationItemReselectedListener { }
    }

    private fun selectCurrentTab() {
        selectTab(getTabScreenByTag(getCurrentFragment()?.tag.orEmpty()))
    }

    private fun selectTab(screen: SupportAppScreen) {
        val currentFragment: Fragment? = getCurrentFragment()
        val nextFragment: Fragment? = childFragmentManager.findFragmentByTag(screen.screenKey)

        if (currentFragment != null && currentFragment == nextFragment) {
            // screen is already shown
            return
        }

        childFragmentManager.commitNow {
            if (nextFragment == null) {
                add(R.id.frameLayout_commonContainer, screen.fragment, screen.screenKey)
            }

            currentFragment?.let {
                hide(it)
                setMaxLifecycle(it, Lifecycle.State.CREATED)
            }
            nextFragment?.let {
                show(it)
                setMaxLifecycle(it, Lifecycle.State.RESUMED)
            }
        }
        bottomNavigationViewModel.onScreenShown(screen)
    }

    private fun getCurrentFragment(): Fragment? {
        return childFragmentManager.fragments.firstOrNull { !it.isHidden }
    }

    private fun getTabScreenByTag(tag: String): SupportAppScreen {
        return when (tag) {
            masterListScreen.screenKey -> masterListScreen
            appointmentListScreen.screenKey -> appointmentListScreen
            else -> getStartScreen()
        }
    }

    private fun getStartScreen(): SupportAppScreen =
        when (arguments?.getSerializable(ARG_TAB) as BottomNavigationTab?) {
            BottomNavigationTab.MASTER_LIST -> masterListScreen
            BottomNavigationTab.APPOINTMENT_LIST -> appointmentListScreen
            null -> masterListScreen
        }

    companion object {
        private const val ARG_TAB = "ARG_TAB"

        fun newInstance(bottomNavigationTab: BottomNavigationTab) = BottomNavigationFragment().apply {
            arguments = bundleOf(ARG_TAB to bottomNavigationTab)
        }
    }
}