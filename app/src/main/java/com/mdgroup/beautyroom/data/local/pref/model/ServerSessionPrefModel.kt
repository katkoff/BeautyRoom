package com.mdgroup.beautyroom.data.local.pref.model

import com.chibatching.kotpref.KotprefModel

object ServerSessionPrefModel : KotprefModel() {
    var token by stringPref(key = "token")
}
