package com.example.freestyleapp.data.remote

import com.example.freestyleapp.data.remote.response.NewsResponse
import com.example.freestyleapp.data.remote.response.SearchResponse
import com.example.freestyleapp.util.Constant.API_KEY
import com.google.gson.annotations.SerializedName
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface NewsAPI {
    @POST("app/home")
    @FormUrlEncoded
    suspend fun getNews(
        @Header("os") os: String = "android",
        @Header("version") version: String = "133",
        @Field("secret_key") secretKey: String = API_KEY
    ): NewsResponse

    @POST("app/search")
    suspend fun search(
        @Body searchRequest: SearchRequest
    ): SearchResponse

    data class SearchRequest(
        @SerializedName("keywords") val keywords: String,
        @SerializedName("secret_key") val secretKey: String = API_KEY,
        @SerializedName("page_index") val pageIndex: String = "1",
        @SerializedName("page_size") val pageSize: String = "200"
    )
}