package com.example.freestyleapp.presentation.home

data class HomeState(
    val newsTicker: String = "",
    val isLoading: Boolean = false,
)