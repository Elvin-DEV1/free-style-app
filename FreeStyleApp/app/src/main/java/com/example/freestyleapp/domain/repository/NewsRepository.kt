package com.example.freestyleapp.domain.repository

import androidx.paging.PagingData
import com.example.freestyleapp.domain.model.News
import com.example.freestyleapp.domain.model.SearchNews
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getNews(): Flow<PagingData<News>>

    fun searchNews(searchQuery: String): Flow<PagingData<SearchNews>>
}