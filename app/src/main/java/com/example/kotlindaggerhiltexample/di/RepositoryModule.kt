package com.example.kotlindaggerhiltexample.di

import com.example.kotlindaggerhiltexample.data.repository.MainRepositoryImpl
import com.example.kotlindaggerhiltexample.repository.MainRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//This module is suitable for interfaces such as the API
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    //Binding the repository allows hilt to generate less code so it's more optimised
    @Binds
    @Singleton
    abstract fun bindMyRepository(
        mainRepositoryImpl: MainRepositoryImpl
    ): MainRepository
}