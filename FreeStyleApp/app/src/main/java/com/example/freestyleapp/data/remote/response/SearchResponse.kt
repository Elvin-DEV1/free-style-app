package com.example.freestyleapp.data.remote.response

import com.example.freestyleapp.domain.model.SearchNews
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("LastUpdated")
    @Expose
    val lastUpdated: LastUpdated,

    @SerializedName("News")
    @Expose
    val news: MutableList<SearchNews>
) {
    data class LastUpdated(
        @SerializedName("Data")
        @Expose
        val data: String
    )
}