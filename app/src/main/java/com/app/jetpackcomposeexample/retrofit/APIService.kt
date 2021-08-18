package com.app.jetpackcomposeexample.retrofit

import com.app.jetpackcomposeexample.model.Post
import retrofit2.http.GET

interface APIService {

    companion object{
        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }

    @GET("posts")
    suspend fun getPost():List<Post>
}