package com.mdgroup.beautyroom.navigation

import androidx.fragment.app.Fragment
import com.mdgroup.beautyroom.ui.auth.AuthFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class AuthScreen : SupportAppScreen() {
    override fun getFragment(): Fragment {
        return AuthFragment.newInstance()
    }
}