package br.senai.sp.jandira.retrofit_api_livraria2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

//    pesquisar ip base depois
    private const val baseurl = "http://10.107.144.25:3000"

    fun getInstance(): Retrofit {
        return Retrofit.Builder ()
            .baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}
