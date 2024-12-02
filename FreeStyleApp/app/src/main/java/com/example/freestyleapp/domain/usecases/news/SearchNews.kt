package com.example.freestyleapp.domain.usecases.news

import androidx.paging.PagingData
import com.example.freestyleapp.domain.model.SearchNews
import com.example.freestyleapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchNews @Inject constructor(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(searchQuery: String): Flow<PagingData<SearchNews>> {
        return newsRepository.searchNews(
            searchQuery = searchQuery
        )
    }
}