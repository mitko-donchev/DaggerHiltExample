package com.example.kotlindaggerhiltexample.data.repository

import android.app.Application
import com.example.kotlindaggerhiltexample.R
import com.example.kotlindaggerhiltexample.data.api.ApiService
import com.example.kotlindaggerhiltexample.repository.MainRepository
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val api: ApiService,
    appContext: Application
) : MainRepository {

    init {
        //An example of app context could be passed
        val appName = appContext.getString(R.string.app_name)
    }

    override suspend fun doNetworkCall() {
        api.doNetworkCall()
    }
}