package com.example.kotlindaggerhiltexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.kotlindaggerhiltexample.presentation.MainViewModelWithInjection
import com.example.kotlindaggerhiltexample.presentation.MainViewModelWithLazyInjection
import com.example.kotlindaggerhiltexample.ui.theme.KotlinDaggerHiltExampleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinDaggerHiltExampleTheme {

                // Use hiltViewModel to get the ViewModels and inject the dependencies
                val viewModel = hiltViewModel<MainViewModelWithInjection>()
                val lazyViewModel = hiltViewModel<MainViewModelWithLazyInjection>()

                viewModel.retrieveDataFromRepository()
                lazyViewModel.retrieveDataFromLazyRepository()
            }
        }
    }
}

