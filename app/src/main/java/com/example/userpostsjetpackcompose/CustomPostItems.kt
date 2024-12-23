package com.example.userpostsjetpackcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.userpostsjetpackcompose.utils.Post

@Composable
fun CustomPostItems(post: Post){
    Row (modifier = Modifier
        .fillMaxWidth()
        .background(Color.LightGray)
        .padding(24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)){

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