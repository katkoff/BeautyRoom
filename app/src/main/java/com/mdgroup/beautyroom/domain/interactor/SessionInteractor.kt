package com.mdgroup.beautyroom.domain.interactor

import com.mdgroup.beautyroom.data.local.pref.model.ServerSessionPrefModel
import com.mdgroup.beautyroom.domain.model.ServerSession


class SessionInteractor {

    var serverSession: ServerSession
        get() = ServerSession(ServerSessionPrefModel.token)
        set(value) {
            ServerSessionPrefModel.token = value.token
        }

    fun isSignedIn(): Boolean {
        return serverSession.token.isNotEmpty()
    }
}