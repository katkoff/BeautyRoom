package com.mdgroup.beautyroom.ui.bottomnavigation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mdgroup.beautyroom.R
import ru.terrakok.cicerone.android.support.SupportAppScreen

class BottomNavigationViewModel : ViewModel() {

    val currentScreen = MutableLiveData<SupportAppScreen>()

    fun onNavigationItemSelected(itemId: Int) {
        currentScreen.value = when (itemId) {
            R.id.masters_menu_item -> BottomNavigationScreens.masterListScreen
            R.id.appointments_menu_item -> BottomNavigationScreens.appointmentListScreen
            else -> BottomNavigationScreens.masterListScreen
        }
    }
}