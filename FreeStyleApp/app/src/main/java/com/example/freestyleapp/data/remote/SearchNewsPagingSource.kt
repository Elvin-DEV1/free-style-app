package com.example.freestyleapp.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.freestyleapp.domain.model.SearchNews
import java.lang.Exception

class SearchNewsPagingSource(
    private val api: NewsAPI,
    private val searchQuery: String
) : PagingSource<Int, SearchNews>() {

    override fun getRefreshKey(state: PagingState<Int, SearchNews>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val page = state.closestPageToPosition(anchorPosition)
            page?.prevKey?.plus(1) ?: page?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SearchNews> {
        return try {
            val page = params.key ?: 1
            val searchRequest = NewsAPI.SearchRequest(
                keywords = searchQuery,
                pageIndex = page.toString()
            )

            val newsResponse = api.search(searchRequest)
            val articles = newsResponse.news.distinctBy { it.title }

            LoadResult.Page(
                data = articles,
                nextKey = if (articles.size < searchRequest.pageSize.toInt()) null else page + 1,
                prevKey = if (page == 1) null else page - 1
            )
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(throwable = e)
        }
    }
}