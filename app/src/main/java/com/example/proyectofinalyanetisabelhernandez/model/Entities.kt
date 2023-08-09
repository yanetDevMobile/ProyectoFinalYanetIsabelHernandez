package com.example.capitulo8.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import retrofit2.http.Field

@JsonClass(generateAdapter = true)
data class Dog(
    @field:Json(name = "name") val name: String,
    @field:Json(name = "description") val description: String,
    @field:Json(name = "maxLife") val maxLife: Int,
    @field:Json(name = "urlImage") val urlImage: String
)