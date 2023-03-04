package com.example.pagingv3simple

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pagingv3simple.Data.Api.ApiService


class MainViewModelFactory(private val apiService: ApiService) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(apiService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }


}