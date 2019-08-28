package com.mdgroup.beautyroom.di

import android.content.Context
import com.mdgroup.beautyroom.data.pref.PrefSessionGateway
import com.mdgroup.beautyroom.data.stub.StubSignInGateway
import com.mdgroup.beautyroom.domain.gateway.SessionGateway
import com.mdgroup.beautyroom.domain.gateway.SignInGateway
import com.mdgroup.beautyroom.domain.interactor.SignInInteractor
import com.mdgroup.beautyroom.ui.signin.SignInViewModel
import com.mdgroup.beautyroom.ui.signup.SignUpViewModel
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
            single { StubSignInGateway() as SignInGateway }
            single { PrefSessionGateway() as SessionGateway }
        }

        val domainModule = module {
            factory { SignInInteractor(get(), get()) }
        }

        val signInModule = module {
            viewModel { SignInViewModel(get(), get()) }
        }

        val signUpModule = module {
            viewModel { SignUpViewModel() }
        }

        startKoin {
            androidContext(applicationContext)
            modules(
                listOf(
                    navigationModule,
                    dataModule,
                    domainModule,
                    signInModule,
                    signUpModule
                )
            )
        }
    }
}
