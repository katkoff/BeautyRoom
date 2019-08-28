package com.mdgroup.beautyroom.data.pref

import com.mdgroup.beautyroom.data.pref.model.ServerSessionPrefModel
import com.mdgroup.beautyroom.domain.gateway.SessionGateway
import com.mdgroup.beautyroom.domain.model.ServerSession

class PrefSessionGateway : SessionGateway {

    override var serverSession: ServerSession
        get() = ServerSession(ServerSessionPrefModel.token)
        set(value) {
            ServerSessionPrefModel.token = value.token
        }
}
