package com.example.pagingv3simple

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.pagingv3simple.Data.Api.ApiService
import com.example.pagingv3simple.Data.PostDataSource

class MainViewModel(private val apiService: ApiService) : ViewModel() {

    val listData = Pager(PagingConfig(pageSize = 6)) {
        PostDataSource(apiService)
    }.flow.cachedIn(viewModelScope)

//    And at last, we cache the data in viewModelScope , and the data will be alive until the scope
//    is active. Here, we are using viewModelScope and since we are caching the data in the ViewModel it would not be impacted on any configuration changes.
}