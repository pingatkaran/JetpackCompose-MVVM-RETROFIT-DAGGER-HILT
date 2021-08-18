package com.app.jetpackcomposeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.app.jetpackcomposeexample.model.User
import com.app.jetpackcomposeexample.model.dummyData
import com.app.jetpackcomposeexample.ui.theme.JetpackComposeExampleTheme

class ListActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeExampleTheme {
                Surface() {
                    RecyclerView(users = dummyData())
                }
            }
        }
    }

    @Composable
    fun RowCard(user: User) {
        Card(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp),
            shape = RoundedCornerShape(CornerSize(10.dp)),
            elevation = 3.dp
        ) {
            Row(modifier = Modifier.padding(5.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "image",
                    modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.CenterVertically)
                )

                Text(text = "Hello " + user.description, modifier = Modifier.padding(8.dp))
            }
        }
    }

    @Composable
    fun RecyclerView(users: List<User>) {
        LazyColumn {
            items(users) { user ->
                RowCard(user = user)
            }
        }
    }
}