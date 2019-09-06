package com.mdgroup.beautyroom.domain.interactor

import com.mdgroup.beautyroom.data.pref.model.ServerSessionPrefModel
import com.mdgroup.beautyroom.domain.model.ServerSession
import com.mdgroup.beautyroom.domain.model.ServerSessionCredentials


class SessionInteractor {

    var serverSession: ServerSession
        get() = ServerSession(ServerSessionCredentials(ServerSessionPrefModel.token))
        set(value) {
            ServerSessionPrefModel.token = value.credentials.token
        }

    fun isSignedIn(): Boolean {
        return serverSession.credentials.token.isNotEmpty()
    }
}