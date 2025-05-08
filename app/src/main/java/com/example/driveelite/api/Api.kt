package com.example.driveelite.api

import com.example.driveelite.model.Car
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("cars")
   fun getCars(
        @Query("make") make: String? = null,
        @Query("limit") limit: Int = 10
    ): Call<List<Car>>
}
