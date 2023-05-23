package com.example.challange6.model

import com.google.gson.annotations.SerializedName
import kotlin.Result

@Suppress("unused", "unused", "unused")
data class ResponseMovie(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<com.example.challange6.model.Result>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)