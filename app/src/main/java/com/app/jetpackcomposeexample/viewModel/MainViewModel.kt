package com.app.jetpackcomposeexample.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.jetpackcomposeexample.Repository.MainRepository
import com.app.jetpackcomposeexample.utils.APIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {

    val res : MutableState<APIState> = mutableStateOf(APIState.Empty)

    init {
        getPost()
    }

    fun getPost() = viewModelScope.launch {
        repository.getPost()
            .onStart {
                res.value = APIState.Loading
            }
            .catch {
                res.value = APIState.Failure(it)
            }
            .collect {
                res.value = APIState.Success(it)
            }

    }
}