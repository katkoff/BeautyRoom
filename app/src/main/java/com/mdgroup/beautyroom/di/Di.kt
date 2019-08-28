package com.mdgroup.beautyroom.di

import android.content.Context
import com.mdgroup.beautyroom.data.pref.PrefSessionGateway
import com.mdgroup.beautyroom.data.stub.StubLoginGateway
import com.mdgroup.beautyroom.domain.gateway.LoginGateway
import com.mdgroup.beautyroom.domain.gateway.SessionGateway
import com.mdgroup.beautyroom.domain.interactor.LoginInteractor
import com.mdgroup.beautyroom.ui.login.LoginViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import ru.terrakok.cicerone.Cicerone

object Di {

    fun init(applicationContext: Context) {
        val cicerone = Cicerone.create()
        val navigationModule = module {
            single { cicerone }
            single { cicerone.navigatorHolder }
            single { cicerone.router }
        }

        val dataModule = module {
            single { StubLoginGateway() as LoginGateway }
            single { PrefSessionGateway() as SessionGateway }
        }

        val domainModule = module {
            factory { LoginInteractor(get(), get()) }
        }

        val loginModule = module {
            viewModel { LoginViewModel(get(), get()) }
        }

        startKoin {
            androidContext(applicationContext)
            modules(
                listOf(
                    navigationModule,
                    dataModule,
                    domainModule,
                    loginModule
                )
            )
        }
    }
}
