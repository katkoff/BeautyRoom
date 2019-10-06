package com.mdgroup.beautyroom.navigation

import android.os.Bundle
import ru.terrakok.cicerone.android.support.SupportAppScreen

enum class ScreenFactory(
    val screenFactory: (bundle: Bundle, key: String) -> SupportAppScreen?
) {
    BOTTOM_NAVIGATION(
        { bundle, key ->
            bundle.getParcelable<BottomNavigationScreen>(key)
        }),
    SCHEDULE(
        { bundle, key ->
            bundle.getParcelable<ScheduleScreen>(key)
        });

    fun getScreen(bundle: Bundle, key: String) = screenFactory.invoke(bundle, key)
}
