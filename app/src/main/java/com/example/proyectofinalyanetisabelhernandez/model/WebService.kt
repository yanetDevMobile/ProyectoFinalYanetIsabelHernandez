package com.example.capitulo8.model

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST

//Declarar url base del servicio web
val URL_BASE: String="http://www.patitonet.com"

//interface donde se declara los metodos que se van a usar

@JsonClass(generateAdapter = true)
interface DogService{

    @GET("perros")
    suspend fun getDogs():List<Dog>
}
//Clase usada para la creacion Singleton de Retrofit
object RetrofitInstance{
    //declarar el conversor JSON(MOSHI)
    private val moshi = Moshi.Builder()
                              .add(KotlinJsonAdapterFactory())
                              .build()
    //Union de retrofit con moshi
    //By LAzy sirve para indicar que Retrofit se tardara en cargar
    private val  retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }
    //Declarando el servicio con Retrofit
    val service:DogService by lazy {
        retrofit.create(DogService::class.java)
    }


}