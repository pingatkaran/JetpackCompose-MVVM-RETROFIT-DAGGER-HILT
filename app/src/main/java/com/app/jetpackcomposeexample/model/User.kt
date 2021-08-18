package com.app.jetpackcomposeexample.model

data class User (val description : String)

fun dummyData() : List<User>{
    return listOf(
        User("First"),
        User("Second"),
        User("Third"),
        User("Forth"),
        User("Fifth"),
        User("Sixth"),
        User("Seventh"),
        User("Eighth"),
    )
}