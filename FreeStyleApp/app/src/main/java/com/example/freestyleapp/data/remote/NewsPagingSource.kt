package com.example.freestyleapp.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.freestyleapp.domain.model.News

class NewsPagingSource(
    private val newsApi: NewsAPI
) : PagingSource<Int, News>() {


    override fun getRefreshKey(state: PagingState<Int, News>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    private var totalNewsCount = 0

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, News> {
        val page = params.key ?: 1
        return try {
            val newsResponse = newsApi.getNews()
            totalNewsCount += newsResponse.homeNewsPosition.data.size
            val articles = newsResponse.homeNewsPosition.data.distinctBy { it.title }

            LoadResult.Page(
                data = articles,
                nextKey = if (totalNewsCount == newsResponse.homeNewsPosition.data.size) null else page + 1,
                prevKey = null
            )
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(
                throwable = e
            )
        }
    }
}