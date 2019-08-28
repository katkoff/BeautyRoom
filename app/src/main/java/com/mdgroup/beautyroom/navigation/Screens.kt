package com.mdgroup.beautyroom.navigation

import androidx.fragment.app.Fragment
import com.mdgroup.beautyroom.ui.signin.SignInFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class SignInScreen : SupportAppScreen() {
    override fun getFragment(): Fragment {
        return SignInFragment.newInstance()
    }
}