package com.example.freestyleapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.freestyleapp.data.remote.NewsAPI
import com.example.freestyleapp.data.remote.NewsPagingSource
import com.example.freestyleapp.data.remote.SearchNewsPagingSource
import com.example.freestyleapp.domain.model.News
import com.example.freestyleapp.domain.model.SearchNews
import com.example.freestyleapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(private val newsApi: NewsAPI): NewsRepository {

    override fun getNews(): Flow<PagingData<News>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(newsApi = newsApi)
            }
        ).flow
    }

    override fun searchNews(searchQuery: String): Flow<PagingData<SearchNews>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchNewsPagingSource(
                    api = newsApi,
                    searchQuery = searchQuery
                )
            }
        ).flow
    }


}