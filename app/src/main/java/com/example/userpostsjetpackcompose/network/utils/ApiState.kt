package com.example.userpostsjetpackcompose.network.utils

import com.example.userpostsjetpackcompose.utils.Post

sealed class ApiState {

    class Success(val data:List<Post>):ApiState()
    class Failure(val msg:Throwable):ApiState()
    object Loading:ApiState()
    object Empty:ApiState()

}