package com.example.userpostsjetpackcompose.network

import com.example.userpostsjetpackcompose.utils.Post
import retrofit2.http.GET

interface ApiService {

    companion object{
        const val BASE_URL ="https://jsonplaceholder.typicode.com/"
    }

    @GET("posts")
    suspend fun getPost():List<Post>
   // suspend fun getPost():Response<List<Post>>


}