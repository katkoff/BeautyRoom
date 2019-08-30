package com.mdgroup.beautyroom.di.moduls

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.mdgroup.beautyroom.data.api.BeautyRoomApiService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {

    single { OkHttpClient.Builder().build()  }

    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl("http://194.87.145.166:3001/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    factory { get<Retrofit>().create(BeautyRoomApiService::class.java) }
}