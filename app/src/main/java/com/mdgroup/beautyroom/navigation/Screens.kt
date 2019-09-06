package com.mdgroup.beautyroom.navigation

import com.mdgroup.beautyroom.ui.bottomnavigation.BottomNavigationFragment
import com.mdgroup.beautyroom.ui.master.list.MasterListFragment
import com.mdgroup.beautyroom.ui.signin.SignInFragment
import com.mdgroup.beautyroom.ui.signup.SignUpFragment
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