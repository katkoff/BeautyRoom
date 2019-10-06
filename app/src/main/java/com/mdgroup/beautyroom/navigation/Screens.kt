package com.mdgroup.beautyroom.navigation

import android.os.Parcelable
import androidx.fragment.app.Fragment
import com.mdgroup.beautyroom.ui.appointments.AppointmentsFragment
import com.mdgroup.beautyroom.ui.bottomnavigation.BottomNavigationFragment
import com.mdgroup.beautyroom.ui.bottomnavigation.BottomNavigationTab
import com.mdgroup.beautyroom.ui.master.details.MasterDetailsFragment
import com.mdgroup.beautyroom.ui.master.list.MasterListFragment
import com.mdgroup.beautyroom.ui.master.schedule.ScheduleFragment
import com.mdgroup.beautyroom.ui.signin.SignInFragment
import com.mdgroup.beautyroom.ui.signup.SignUpFragment
import kotlinx.android.parcel.Parcelize
import ru.terrakok.cicerone.android.support.SupportAppScreen

class SignInScreen(
    private val nextScreen: SupportAppScreen,
    private val screenFactory: ScreenFactory
) : SupportAppScreen() {
    override fun getFragment() = SignInFragment.newInstance(nextScreen, screenFactory)
}

class SignUpScreen : SupportAppScreen() {
    override fun getFragment() = SignUpFragment.newInstance()
}

@Parcelize
class BottomNavigationScreen(
    private val bottomNavigationTab: BottomNavigationTab = BottomNavigationTab.MASTER_LIST
) : SupportAppScreen(), Parcelable {
    override fun getFragment() = BottomNavigationFragment.newInstance(bottomNavigationTab)
}

class MasterListScreen : SupportAppScreen() {
    override fun getFragment() = MasterListFragment.newInstance()
}

class MasterDetailsScreen(
    private val masterId: Int
) : SupportAppScreen() {
    override fun getFragment(): Fragment = MasterDetailsFragment.newInstance(masterId)
}

@Parcelize
class AppointmentsScreen : SupportAppScreen(), Parcelable {
    override fun getFragment(): Fragment = AppointmentsFragment.newInstance()
}

class ScheduleScreen(
    private val masterId: Int,
    private val serviceName: String
) : SupportAppScreen() {
    override fun getFragment(): Fragment = ScheduleFragment.newInstance(masterId, serviceName)
}