package com.example.kotlindaggerhiltexample

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.example.kotlindaggerhiltexample.repository.MainRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainService: Service() {

    //Field injection, because the service can't take a constructor
    @Inject
    lateinit var repository: MainRepository

    // Coroutine
    private val job = SupervisorJob()
    private val serviceScope = CoroutineScope(Dispatchers.IO + job)

    override fun onCreate() {
        super.onCreate()

        //Execute some logic
        serviceScope.launch {
            repository.doNetworkCall()
        }
    }

    override fun onBind(intent: Intent?): IBinder? = null
}