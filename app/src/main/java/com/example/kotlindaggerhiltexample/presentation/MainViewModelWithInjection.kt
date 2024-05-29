package com.example.kotlindaggerhiltexample.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlindaggerhiltexample.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModelWithInjection @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    fun retrieveDataFromRepository() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.doNetworkCall()
        }
    }
}