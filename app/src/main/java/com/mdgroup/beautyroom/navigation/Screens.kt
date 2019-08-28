package com.mdgroup.beautyroom.navigation

import androidx.fragment.app.Fragment
import com.mdgroup.beautyroom.ui.signin.SignInFragment
import com.mdgroup.beautyroom.ui.signup.SignUpFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class SignInScreen : SupportAppScreen() {
    override fun getFragment(): Fragment {
        return SignInFragment.newInstance()
    }
}

class SignUpScreen : SupportAppScreen() {
    override fun getFragment(): Fragment {
        return SignUpFragment.newInstance()
    }
}