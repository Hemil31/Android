package com.example.apidemo

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface MyInterface {
  //  @GET("users/")
    @GET("marvel/")
    fun getData() : Call<List<MyDataItems>>

}