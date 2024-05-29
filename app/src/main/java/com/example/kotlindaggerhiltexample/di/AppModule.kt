package com.example.kotlindaggerhiltexample.di

import com.example.kotlindaggerhiltexample.data.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiService(@Named("releaseURL") baseUrl: String): ApiService = Retrofit.Builder()
        .baseUrl(baseUrl)
        .build()
        .create(ApiService::class.java)

    //Example of using Named() annotation do distinguish between Strings
    @Provides
    @Singleton
    @Named("releaseURL")
    fun provideReleaseBaseURL() = "releaseURL"

    @Provides
    @Singleton
    @Named("debugURL")
    fun provideDebugBaseURL() = "debugURL"
}