package com.example.youtubeapionline.repository

import com.example.youtubeapionline.network.service.ApiService

class YouTubeRepository(val apiService: ApiService) {

    suspend fun getData() = apiService.getData()
}