package com.example.capitulo8.model

class DogRepository{
    //obtengo la instancia de mi servicio web
    private val dogService = RetrofitInstance.service

    //Creamos la función que le permitirá al viewmodel obtener los datos
    suspend fun getDogs():List<Dog>{
        return dogService.getDogs()
    }

}