package com.example.youtubeapionline.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.youtubeapionline.model.YoutubeApiData
import com.example.youtubeapionline.network.ApiClient
import com.example.youtubeapionline.repository.YouTubeRepository
import com.example.youtubeapionline.utils.NetworkHelper
import com.example.youtubeapionline.utils.Resource
import kotlinx.coroutines.launch

class YouTubeViewModel : ViewModel() {

    private val youTubeRepository = YouTubeRepository(ApiClient.apiService)
    private val liveData = MutableLiveData<Resource<YoutubeApiData>>()

    fun getYouTubeData(context: Context) : LiveData<Resource<YoutubeApiData>>{
        val networkHelper = NetworkHelper(context)

        if(networkHelper.isNetworkConnected()){
            viewModelScope.launch {
                liveData.postValue(Resource.loading(null))
                val response = youTubeRepository.getData()
                if(response.isSuccessful){
                    liveData.postValue(Resource.success(response.body()))
                }else{
                    liveData.postValue(Resource.error(response.errorBody()?.string().toString(), null))
                }
            }
        }else{
            liveData.postValue(Resource.error("Internet not connected", null))
        }
        return liveData
    }

}