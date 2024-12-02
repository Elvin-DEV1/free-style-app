package com.example.freestyleapp.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.freestyleapp.domain.model.News
import com.example.freestyleapp.domain.model.SearchNews
import com.example.freestyleapp.presentation.Dimens.ExtraSmallPadding2
import com.example.freestyleapp.presentation.Dimens.MediumPadding1
import com.example.freestyleapp.presentation.home.components.ArticleCard
import com.example.freestyleapp.presentation.home.components.ArticleSearchCard

@Composable
fun ArticlesSearchList(
    modifier: Modifier = Modifier,
    articles: LazyPagingItems<SearchNews>,
    onClick:(SearchNews) -> Unit
) {

    val handlePagingResult = handlePagingSearchResult(articles)


    if (handlePagingResult) {
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(MediumPadding1),
            contentPadding = PaddingValues(all = ExtraSmallPadding2)
        ) {
            items(
                count = articles.itemCount,
            ) {
                articles[it]?.let { article ->
                    ArticleSearchCard(article = article, onClick = {onClick(article)})
                }
            }
        }
    }
}

@Composable
fun handlePagingSearchResult(articles: LazyPagingItems<SearchNews>): Boolean {
    val loadState = articles.loadState
    val error = when {
        loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
        loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
        loadState.append is LoadState.Error -> loadState.append as LoadState.Error
        else -> null
    }

    return when {
        loadState.refresh is LoadState.Loading -> {
            ShimmerEffect()
            false
        }

        error != null -> {
            EmptyScreen(error = error)
            false
        }

        else -> {
            true
        }
    }
}

@Composable
fun ShimmerSearchEffect() {
    Column(verticalArrangement = Arrangement.spacedBy(MediumPadding1)){
        repeat(10){
            ArticleCardShimmerEffect(
                modifier = Modifier.padding(horizontal = MediumPadding1)
            )
        }
    }
}