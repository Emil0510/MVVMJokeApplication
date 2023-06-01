package com.emilabdurahmanli.mvvmjokeapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.SpinnerAdapter
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.emilabdurahmanli.mvvmjokeapplication.R
import com.emilabdurahmanli.mvvmjokeapplication.databinding.ActivityMainBinding
import com.emilabdurahmanli.mvvmjokeapplication.model.Result
import com.emilabdurahmanli.mvvmjokeapplication.network.RetrofitClient
import com.emilabdurahmanli.mvvmjokeapplication.view_model.MainActivityViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(){

    private lateinit var viewModel : MainActivityViewModel
    private lateinit var binding : ActivityMainBinding
    private var categories = arrayListOf<String>("Any","Misc", "Programming", "Dark", "Pun", "Spooky", "Christmas")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        //Spinner
        val spinnerAdapter = ArrayAdapter<String>(this, R.layout.spinner_row,R.id.spinnerCategoryText, categories)
        binding.spinner.adapter = spinnerAdapter

        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        viewModel.observeJoke().observe(this, Observer { joke ->
            binding.progressBarCyclic.visibility = View.GONE
            binding.categoryText.text = "Category: ${joke.category}"
            binding.deliveryText.text = "Delivery: ${joke.delivery}"
            binding.setupText.text = "Setup: ${joke.setup}"
            binding.typeText.text = "Type: ${joke.type}"
        })

        binding.searchButton.setOnClickListener {
            binding.progressBarCyclic.visibility = View.VISIBLE
            viewModel.getJoke(binding.spinner.selectedItem.toString())

        }

    }



}