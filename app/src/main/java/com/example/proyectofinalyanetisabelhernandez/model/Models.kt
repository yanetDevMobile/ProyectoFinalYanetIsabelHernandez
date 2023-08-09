package com.example.capitulo8.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//ViewModel de Dogs

//Clase que nos permite manejar estados
data class DogState(
    var dogs: List<Dog> = listOf(Dog("prueba","desc",10,"https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/Degaen.jpg/320px-Degaen.jpg"))
)
class DogsViewModel:ViewModel(){
    var state by mutableStateOf(DogState()) /*Estado inicial*/
    private val repository: DogRepository= DogRepository() /*repository*/
    private val courutimeScope: CoroutineScope = viewModelScope /*alcance la coroutina*/

    /*Funcion que cambia el estado inicial de la Lista de perros*/
    fun changeStateDogs(){
        courutimeScope.launch(Dispatchers.IO) {
            var perros = repository.getDogs()
            state = state.copy(
                dogs = perros
            )
        }
    }
}