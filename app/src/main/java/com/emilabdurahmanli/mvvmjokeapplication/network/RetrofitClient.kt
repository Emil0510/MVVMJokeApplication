package com.emilabdurahmanli.mvvmjokeapplication.network

import com.emilabdurahmanli.mvvmjokeapplication.Constants
import com.emilabdurahmanli.mvvmjokeapplication.api.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClient {

    companion object{
        var instance : RetrofitClient? = null
        lateinit var api : Api
        fun getRetrofitInstance(): RetrofitClient? {
            if(instance==null){
                instance = RetrofitClient()
                val retrofit: Retrofit = Retrofit.Builder().baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                api = retrofit.create(Api::class.java)
            }
            return instance
        }
    }

    fun getApi(): Api {
        return api
    }

}