package com.example.userpostsjetpackcompose.view

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userpostsjetpackcompose.network.utils.ApiState
import com.example.userpostsjetpackcompose.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel
@Inject
constructor(private val repository: PostRepository):ViewModel() {


    val response:MutableState<ApiState> = mutableStateOf(ApiState.Empty)

    init {
        getPost()
    }
    fun getPost() = viewModelScope.launch {
        repository.getPosts().onStart {
            response.value =ApiState.Loading
        }.catch {
            response.value = ApiState.Failure(it)
        }.collect{
            response.value =ApiState.Success(it)
        }
    }
}