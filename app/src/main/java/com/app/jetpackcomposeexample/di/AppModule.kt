package com.app.jetpackcomposeexample.di

import com.app.jetpackcomposeexample.retrofit.APIService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesMoshi() :Moshi = Moshi
        .Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @Provides
    @Singleton
    fun providesAPIService(moshi: Moshi) :APIService =
        Retrofit
        .Builder()
            .run {
                baseUrl(APIService.BASE_URL)
                addConverterFactory(MoshiConverterFactory.create(moshi))
                build()
            }.create(APIService::class.java)
}