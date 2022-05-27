package com.example.youtubeapionline.model

data class YoutubeApiData(
	val regionCode: String,
	val kind: String,
	val nextPageToken: String,
	val pageInfo: PageInfo,
	val etag: String,
	val items: List<Item>
)
