package com.example.understanding.network

data class ItemResponse(
    val Search: List<Items>
)

data class Items(
    val Title: String,
    val imdbID: String,
    val Poster: String,
    val Type: String
)
