package com.example.freestyleapp.presentation.search

import androidx.paging.PagingData
import com.example.freestyleapp.domain.model.SearchNews
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchQuery: String = "",
    val articles: Flow<PagingData<SearchNews>>? = null
)