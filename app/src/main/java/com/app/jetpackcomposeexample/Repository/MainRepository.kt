package com.app.jetpackcomposeexample.Repository

import com.app.jetpackcomposeexample.model.Post
import com.app.jetpackcomposeexample.retrofit.APIService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


import javax.inject.Inject

class MainRepository @Inject constructor(private val apiService: APIService) {


    fun getPost(): kotlinx.coroutines.flow.Flow<List<Post>> = flow {
        emit(apiService.getPost())
    }.flowOn(Dispatchers.IO)


}