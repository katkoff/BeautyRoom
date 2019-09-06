package com.mdgroup.beautyroom.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mdgroup.beautyroom.R
import com.mdgroup.beautyroom.navigation.BottomNavigationScreen
import org.koin.android.ext.android.inject
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator


class MainActivity : AppCompatActivity() {

    private val navigatorHolder: NavigatorHolder by inject()
    private val router: Router by inject()
    private val navigator = SupportAppNavigator(this, R.id.frameLayout_fragmentContainer)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            // TODO: implement checking token in prefs using "checkAlreadyLogged()" method
//            router.newRootScreen(SignInScreen())
            router.newRootScreen(BottomNavigationScreen())
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }
}
