package com.example.youtubeapionline.model

data class Snippet(
	val publishTime: String,
	val publishedAt: String,
	val description: String,
	val title: String,
	val thumbnails: Thumbnails,
	val channelId: String,
	val channelTitle: String,
	val liveBroadcastContent: String
)
