package ru.netology.nmedia.netologyapp

data class Post(
    val id: Long,
    val author: String,
    val content: String,
    val published: String,
    var likedByMe: Boolean = false,
    var likeCount: Long,
    var shareCount: Long
)
