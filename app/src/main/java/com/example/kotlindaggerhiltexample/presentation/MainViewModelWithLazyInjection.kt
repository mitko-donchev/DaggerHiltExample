package com.example.kotlindaggerhiltexample.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlindaggerhiltexample.repository.MainRepository
import dagger.Lazy
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModelWithLazyInjection @Inject constructor(
    // Lazy will allow creating the repository on a later stage
    private val repository: Lazy<MainRepository>
) : ViewModel() {

    fun retrieveDataFromLazyRepository() {
        viewModelScope.launch(Dispatchers.IO) {
            //When .get() is called the repository will be created
            repository.get().doNetworkCall()
        }
    }
}