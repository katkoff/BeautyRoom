package com.mdgroup.beautyroom.di.modules

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.mdgroup.beautyroom.data.api.BeautyRoomApiService
import com.mdgroup.beautyroom.data.api.gateway.ApiMastersGateway
import com.mdgroup.beautyroom.data.api.gateway.ApiSignInGateway
import com.mdgroup.beautyroom.data.api.gateway.ApiSignUpGateway
import com.mdgroup.beautyroom.data.pref.PrefSessionGateway
import com.mdgroup.beautyroom.domain.gateway.MastersGateway
import com.mdgroup.beautyroom.domain.gateway.SessionGateway
import com.mdgroup.beautyroom.domain.gateway.SignInGateway
import com.mdgroup.beautyroom.domain.gateway.SignUpGateway
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val dataModule = module {

    single {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl("http://194.87.145.166:3001/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    single { get<Retrofit>().create(BeautyRoomApiService::class.java) }

    single<SessionGateway> { PrefSessionGateway() }
    single<SignInGateway> { ApiSignInGateway(get()) }
    single<SignUpGateway> { ApiSignUpGateway(get()) }
    single<MastersGateway> { ApiMastersGateway(get()) }
}