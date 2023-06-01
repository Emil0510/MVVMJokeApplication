package com.emilabdurahmanli.mvvmjokeapplication.api

import com.emilabdurahmanli.mvvmjokeapplication.model.Result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("{category}")
    fun getJoke(@Path ("category") category : String) : Call<Result>

}