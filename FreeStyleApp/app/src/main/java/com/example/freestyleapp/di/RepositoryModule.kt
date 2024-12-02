package com.example.freestyleapp.di

import com.example.freestyleapp.data.repository.NewsRepositoryImpl
import com.example.freestyleapp.domain.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindNewsRepository(newsRepositoryImpl: NewsRepositoryImpl): NewsRepository

}