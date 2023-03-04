package com.example.pagingv3simple.Data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pagingv3simple.Data.Api.ApiService
import com.example.pagingv3simple.Data.Model.Data

class PostDataSource(private val apiService: ApiService) : PagingSource<Int, Data>() {

//    In the PostDataSource , we take two parameters one of integer type and other of the
//    data type we have to load on the list item. The integer parameter represents the page number here.

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        try {


            val currentLoadingPageKey = params.key ?: 1
            val response = apiService.getListData(currentLoadingPageKey)
            println("!!!!!!!!!!!!!!!!!!1" + response.body()?.data.toString())
            val data = response.body()?.data ?: emptyList()
            val responseData = mutableListOf<Data>()
            responseData.addAll(data)
//We are also passing null as the next key if there is no corresponding data in that direction.
            val prevKey = if (currentLoadingPageKey == 1) null else currentLoadingPageKey - 1
return LoadResult.Page(
    data = responseData,
    prevKey = prevKey,
    nextKey = currentLoadingPageKey.plus(1)
)
        }catch (e:Exception){
            println("!!!!!!!!!!!!!!"+e)
            return LoadResult.Error(e)

        }

    }

    override fun getRefreshKey(state: PagingState<Int, Data>): Int? {
        TODO("Not yet implemented")
    }

}