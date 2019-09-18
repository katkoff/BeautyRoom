package com.mdgroup.beautyroom.navigation

import androidx.fragment.app.Fragment
import com.mdgroup.beautyroom.ui.bottomnavigation.BottomNavigationFragment
import com.mdgroup.beautyroom.ui.master.details.MasterDetailsFragment
import com.mdgroup.beautyroom.ui.master.list.MasterListFragment
import com.mdgroup.beautyroom.ui.schedule.ScheduleFragment
import com.mdgroup.beautyroom.ui.signin.SignInFragment
import com.mdgroup.beautyroom.ui.signup.SignUpFragment
import com.mdgroup.beautyroom.ui.stub.StubFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class SignInScreen : SupportAppScreen() {
    override fun getFragment() = SignInFragment.newInstance()
}

class SignUpScreen : SupportAppScreen() {
    override fun getFragment() = SignUpFragment.newInstance()
}

class BottomNavigationScreen : SupportAppScreen() {
    override fun getFragment() = BottomNavigationFragment.newInstance()
}

class MasterListScreen : SupportAppScreen() {
    override fun getFragment() = MasterListFragment.newInstance()
}

class MasterDetailsScreen(
    private val masterId: Int
) : SupportAppScreen() {
    override fun getFragment(): Fragment = MasterDetailsFragment.newInstance(masterId)
}

class StubScreen : SupportAppScreen() {
    override fun getFragment(): Fragment = StubFragment.newInstance()
}

class ScheduleScreen(
    private val masterId: Int,
    private val serviceName: String
) : SupportAppScreen() {
    override fun getFragment(): Fragment = ScheduleFragment.newInstance(masterId, serviceName)
}