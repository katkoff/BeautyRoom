package com.mdgroup.beautyroom.navigation

import android.os.Bundle
import ru.terrakok.cicerone.android.support.SupportAppScreen

enum class ScreenFactory(
    val screenFactory: (bundle: Bundle, key: String) -> SupportAppScreen?
) {
    BOTTOM_NAVIGATION(screenFactory = { bundle, key ->
        bundle.getParcelable<BottomNavigationScreen>(key)
    });

    fun getScreen(bundle: Bundle, key: String) = screenFactory.invoke(bundle, key)
}
