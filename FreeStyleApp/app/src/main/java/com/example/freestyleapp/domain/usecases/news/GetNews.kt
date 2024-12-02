package com.example.freestyleapp.domain.usecases.news

import androidx.paging.PagingData
import com.example.freestyleapp.domain.model.News
import com.example.freestyleapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNews @Inject constructor(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(): Flow<PagingData<News>> {
        return newsRepository.getNews()
    }
}