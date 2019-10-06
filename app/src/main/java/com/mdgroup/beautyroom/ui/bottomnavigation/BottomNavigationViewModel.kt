package com.mdgroup.beautyroom.ui.bottomnavigation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mdgroup.beautyroom.R
import com.mdgroup.beautyroom.domain.interactor.SessionInteractor
import com.mdgroup.beautyroom.navigation.BottomNavigationScreen
import com.mdgroup.beautyroom.navigation.ScreenFactory
import com.mdgroup.beautyroom.navigation.SignInScreen
import com.mdgroup.beautyroom.ui.bottomnavigation.BottomNavigationScreens.appointmentListScreen
import com.mdgroup.beautyroom.ui.bottomnavigation.BottomNavigationScreens.masterListScreen
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppScreen

class BottomNavigationViewModel(
    private val sessionInteractor: SessionInteractor,
    private val router: Router
) : ViewModel() {

    val currentScreen = MutableLiveData<SupportAppScreen>()

    fun onNavigationItemSelected(itemId: Int) {
        when (itemId) {
            R.id.masters_menu_item -> currentScreen.value = masterListScreen
            R.id.appointments_menu_item -> {
                if (sessionInteractor.isSignedIn()) {
                    currentScreen.value = appointmentListScreen
                } else {
                    currentScreen.value = masterListScreen
                    router.navigateTo(
                        SignInScreen(
                            BottomNavigationScreen(BottomNavigationTab.APPOINTMENT_LIST),
                            ScreenFactory.BOTTOM_NAVIGATION
                        )
                    )
                }
            }
            else -> currentScreen.value = masterListScreen
        }
    }

    fun onScreenShown(screen: SupportAppScreen) {
        if (currentScreen.value != screen) {
            currentScreen.value = screen
        }
    }
}