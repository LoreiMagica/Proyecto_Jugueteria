package com.iesvirgendelcarmen.proyecto_jugueteria

import retrofit2.Call
import retrofit2.http.GET

interface APICategoria{
    @GET("categories")
    fun getCategorias() : Call<List<Categoria>>
}