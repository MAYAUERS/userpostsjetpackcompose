package com.example.userpostsjetpackcompose.view

import android.os.Bundle
import android.support.v4.os.IResultReceiver2.Default
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.userpostsjetpackcompose.CustomPostItems
import com.example.userpostsjetpackcompose.network.utils.ApiState
import com.example.userpostsjetpackcompose.utils.Post
import com.example.userpostsjetpackcompose.view.ui.theme.UserPostsJetpackComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RetrofitActivity : ComponentActivity() {

    private val postViewModel:PostViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserPostsJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GetDataForPost(postViewModel =postViewModel)
                }
            }
        }
    }
}

@Composable
fun EachRow(post: Post) {

    Card (modifier =
    Modifier
        .padding(horizontal = 8.dp, vertical = 8.dp)
        .fillMaxWidth(),
        elevation =CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(4.dp)
    ){

        Text(text = "${post.id}",
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold)

        Text(text = "${post.title}",
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium)

    }
}

@Composable
fun GetDataForPost(postViewModel: PostViewModel){
    when(val result = postViewModel.response.value){
        is ApiState.Success ->{
            LazyColumn{
                items(result.data){
                   // EachRow(post = it)
                    CustomPostItems(post = it)
                }
            }
        }
        is ApiState.Failure->{
            Text(text = "${result.msg}")
        }
        ApiState.Loading->{
            CircularProgressIndicator()
        }
        ApiState.Empty->{

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    UserPostsJetpackComposeTheme {

    }
}