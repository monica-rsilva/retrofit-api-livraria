package br.senai.sp.jandira.retrofit_api_livraria2

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("data")
    var data: T? = null
)
