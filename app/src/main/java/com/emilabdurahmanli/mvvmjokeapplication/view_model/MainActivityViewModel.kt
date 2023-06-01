package com.emilabdurahmanli.mvvmjokeapplication.view_model


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.emilabdurahmanli.mvvmjokeapplication.model.Result
import com.emilabdurahmanli.mvvmjokeapplication.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel : ViewModel() {

    var joke = MutableLiveData<Result>()

    fun getJoke (category: String) {

        val call: Call<Result>? = RetrofitClient.getRetrofitInstance()?.getApi()?.getJoke(category)
        call?.enqueue(object : Callback<Result?> {
            override fun onResponse(call: Call<Result?>?, response: Response<Result?>) {
                val joke: Result? = response.body()
                this@MainActivityViewModel.joke.postValue(joke)
            }
            override fun onFailure(call: Call<Result?>?, t: Throwable?) {

            }
        })
    }


    fun observeJoke() : LiveData<Result>{
        return joke
    }


}