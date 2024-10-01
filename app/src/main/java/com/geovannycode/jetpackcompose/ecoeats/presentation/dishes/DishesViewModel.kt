package com.geovannycode.jetpackcompose.ecoeats.presentation.dishes

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geovannycode.jetpackcompose.ecoeats.data.repository.DishesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

import com.geovannycode.jetpackcompose.ecoeats.core.Result

@HiltViewModel
class DishesViewModel @Inject constructor(
    val repository: DishesRepository
) : ViewModel() {
    var state by mutableStateOf(DishState())
        private set
    fun getDishes(){
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            val response = withContext(Dispatchers.IO){
                repository.getDishes()
            }
            when(response){
                is Result.Error -> {
                    state = state.copy(isLoading = false, error = response.message, success = null)
                }
                is Result.Success -> {
                    state = state.copy(isLoading = false, success = response.data, error = null)
                }
            }
        }
    }
}