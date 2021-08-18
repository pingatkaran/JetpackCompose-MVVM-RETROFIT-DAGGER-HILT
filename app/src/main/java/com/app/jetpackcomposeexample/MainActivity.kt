package com.app.jetpackcomposeexample

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.jetpackcomposeexample.ui.theme.JetpackComposeExampleTheme
import java.lang.reflect.Modifier
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import java.nio.file.Files.size


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeExampleTheme {

                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "Demo App")
                            },
                            navigationIcon = {
                                IconButton(onClick = {  }) {
                                    Icon(Icons.Filled.Menu, contentDescription = "menu")
                                }
                            },
                            actions = {
                                IconButton(onClick = {  }) {
                                    Icon(Icons.Filled.Notifications, contentDescription = "notification")
                                }
                                IconButton(onClick = {  }) {
                                    Icon(Icons.Filled.Search, contentDescription = "search")
                                }
                            }
                        )
                    },
                    floatingActionButton = {
                        FloatingActionButton(onClick = {
                            startActivity(Intent(this, LoginActivity::class.java))
                        }) {
                            IconButton(onClick = { startActivity(Intent(this, LoginActivity::class.java))
                            }) {
                                Icon(Icons.Filled.Add, contentDescription = "floating")
                            }
                            
                        }
                    },
                    floatingActionButtonPosition = FabPosition.End
                ) {
                    ShowSwitch()
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Helloo $name!", color = MaterialTheme.colors.secondary)
}
@Preview(showBackground = true, name ="light mode")
@Preview(showBackground = true, name ="dark mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DefaultPreview() {
    JetpackComposeExampleTheme {
        Greeting("Android")
    }
}
@Composable
fun ShowSwitch(){

    var isChecked = remember {
        mutableStateOf(true)
    }
    Switch(checked = isChecked.value, onCheckedChange = {
        isChecked.value = it
    },
    modifier = androidx.compose.ui.Modifier.run {
        size(30.dp)
        padding(100.dp)
    })
}