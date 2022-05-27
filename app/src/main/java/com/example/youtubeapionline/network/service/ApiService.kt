package com.example.youtubeapionline.network.service

import com.example.youtubeapionline.model.YoutubeApiData
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @Headers(
        "Content-type:application/json"
    )
    @GET("search")
    suspend fun getData(
        @Query("key") key: String = "AIzaSyCXy-LEqHIYJ_eN3kJYTPTeGQQQ4jRFdPo",
        @Query("channelId") channelId: String = "UCLRXXDGv3L_gGxUHFY8D45g",
        @Query("part") part: String = "snippet,id",
        @Query("order") order: String = "date",
        @Query("maxResults") maxResults: Int = 20
    ): Response<YoutubeApiData>

}