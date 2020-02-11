package com.iesvirgendelcarmen.proyecto_jugueteria

import com.google.gson.Gson
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

object CategoriaRepository {
    val api : APICategoria


    init {
        val retrofit = Retrofit
            .Builder()
            .baseUrl(APIConfig.url_base)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(APICategoria::class.java)
    }

    fun getCategorias(callback: CategoriaListCallback){
        callback.onCategoriaLoading()
        val call = api.getCategorias()
        call.enqueue(object: Callback<List<Categoria>> {
            override fun onFailure(call: Call<List<Categoria>>
                                   , t: Throwable) {
                callback.onCategoriaError(t.message.toString())
            }

            override fun onResponse(call: Call<List<Categoria>>
                                    , response: Response<List<Categoria>>
            ) {
                val bookList: List<Categoria> = response.body().orEmpty()
                callback.onCategoriaResponse(bookList)
            }
        })
    }

    interface CategoriaListCallback{
        fun onCategoriaResponse(listaCategorias : List<Categoria>)
        fun onCategoriaError(msg : String)
        fun onCategoriaLoading()
    }
}