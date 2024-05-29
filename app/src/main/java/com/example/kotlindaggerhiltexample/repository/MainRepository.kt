package com.example.kotlindaggerhiltexample.repository

interface MainRepository {
    suspend fun doNetworkCall()
}