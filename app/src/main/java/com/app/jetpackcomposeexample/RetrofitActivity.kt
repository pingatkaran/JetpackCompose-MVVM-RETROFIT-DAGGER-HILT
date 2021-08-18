package com.app.jetpackcomposeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.app.jetpackcomposeexample.model.Post
import com.app.jetpackcomposeexample.ui.theme.JetpackComposeExampleTheme
import com.app.jetpackcomposeexample.utils.APIState
import com.app.jetpackcomposeexample.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RetrofitActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeExampleTheme {
                Surface {
                    GetData(mainViewModel = mainViewModel)
                }
            }
        }
    }

    @Composable
    fun EachRow(post: Post) {
        Card(
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 10.dp)
                .fillMaxWidth(),
            elevation = 2.dp,
            shape = RoundedCornerShape(4.dp)
        ) {
            Text(text = "" + post.title)
        }
    }

    @Composable
    fun GetData(mainViewModel: MainViewModel) {
        when (val res = mainViewModel.res.value) {
            is APIState.Success -> {
                LazyColumn {
                    items(res.data){
                        EachRow(post = it)
                    }
                }
            }
            is APIState.Failure -> {
                Text(text = ""+res.msg)
            }
            is APIState.Loading -> {
                CircularProgressIndicator()
            }
        }
    }
}