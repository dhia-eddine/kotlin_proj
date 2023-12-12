package com.example.tplogin

import com.example.tplogin.data.UserEntity
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("posts")
    fun getData(): Call<List<UserEntity>>
}
