package com.app.jetpackcomposeexample.utils

import com.app.jetpackcomposeexample.model.Post

sealed class APIState{
    class Success(val data: List<Post>) : APIState()
    class Failure(val msg : Throwable) : APIState()
    object Loading : APIState()
    object Empty : APIState()
}
