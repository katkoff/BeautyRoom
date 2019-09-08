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
        }
    }

    private fun initBottomNavigation() {
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            bottomNavigationViewModel.onNavigationItemSelected(menuItem.itemId)
            true
        }
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
    }

    private fun getCurrentFragment(): Fragment? {
        return childFragmentManager.fragments.firstOrNull { !it.isHidden }
    }

    private fun getTabScreenByTag(tag: String): SupportAppScreen {
        return when (tag) {
            masterListScreen.screenKey -> masterListScreen
            appointmentListScreen.screenKey -> appointmentListScreen
            else -> masterListScreen
        }
    }

    companion object {

        fun newInstance() = BottomNavigationFragment().apply { arguments = bundleOf() }
    }
}