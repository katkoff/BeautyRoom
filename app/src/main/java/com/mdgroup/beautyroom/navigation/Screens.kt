package com.mdgroup.beautyroom.navigation

import androidx.fragment.app.Fragment
import com.mdgroup.beautyroom.ui.login.LoginFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class LoginScreen : SupportAppScreen() {
    override fun getFragment(): Fragment {
        return LoginFragment.newInstance()
    }
}