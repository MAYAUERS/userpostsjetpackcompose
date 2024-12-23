package com.example.userpostsjetpackcompose.repository

import com.example.userpostsjetpackcompose.network.ApiService
import com.example.userpostsjetpackcompose.utils.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class PostRepository
@Inject
constructor(private val apiService: ApiService) {

    fun getPosts(): Flow<List<Post>> = flow {
        emit(apiService.getPost())
    }.flowOn(Dispatchers.IO)
}