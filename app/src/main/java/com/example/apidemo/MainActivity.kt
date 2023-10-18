package com.example.apidemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apidemo.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    var BASE_URL = "https://simplifiedcoding.net/demos/"
   // var BASE_URL = "https://reqres.in/api/"

    private lateinit var binding: ActivityMainBinding

    private lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvList.setHasFixedSize(true)
        binding.rvList.layoutManager = LinearLayoutManager(this)
        showData()

    }

    private fun showData() {

        var retrofitBuilder =
            Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory
                    .create())
                .baseUrl(BASE_URL)
                .build()
                .create(MyInterface::class.java)

        var retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<MyDataItems>?> {
            override fun onResponse(
                call: Call<List<MyDataItems>?>,
                response: Response<List<MyDataItems>?>
            ) {

                Log.d("response>>>>>>>>>>>>>>>",response.body().toString())

                var data = response.body()!!
                myAdapter = MyAdapter(baseContext, data)
                binding.rvList.adapter = myAdapter
            }

            override fun onFailure(call: Call<List<MyDataItems>?>, t: Throwable) {
                Toast.makeText(baseContext, "Failed..", Toast.LENGTH_LONG).show()
                Log.d("Errer.........", t.toString())
            }

        })

    }
}