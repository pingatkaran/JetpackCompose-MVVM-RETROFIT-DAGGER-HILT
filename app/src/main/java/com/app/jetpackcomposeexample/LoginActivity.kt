package com.app.jetpackcomposeexample

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.jetpackcomposeexample.ui.theme.JetpackComposeExampleTheme

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeExampleTheme {
                Surface() {
                    LoginScreen()
                }
            }
        }
    }

    private fun logged(username : String, password : String){
        Toast.makeText(this, "logged in "+username, Toast.LENGTH_SHORT).show()
        startActivity(Intent(this, ListActivity::class.java))
    }

    @Composable
    fun LoginScreen(){
        val username = remember {
            mutableStateOf("")
        }
        val password = remember {
            mutableStateOf("")
        }
        Column{
            Text(text = "Login",  fontSize = 25.sp, color = Color.Blue,
            fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold)
            OutlinedTextField(value = username.value,
                onValueChange = {
                    username.value = it
                },
                leadingIcon = {
                    Icon(Icons.Default.Person, contentDescription = "username")
                },
                label = {
                   Text(text = "Username")
                },
                placeholder = {
                    Text(text = "Username")
                }
            )
            OutlinedTextField(value = password.value,
                onValueChange = {
                    password.value = it
                },
                leadingIcon = {
                    Icon(Icons.Default.Person, contentDescription = "password")
                },
                label = {
                    Text(text = "Password")
                },
                placeholder = {
                    Text(text = "Password")
                }
            )
            OutlinedButton(onClick = {
                logged(username = username.value,password = password.value)
            }) {
                Text(text = "Login")
            }
        }
    }

}