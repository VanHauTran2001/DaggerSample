package com.example.dagger.Dagger

import com.example.dagger.ImageLoader
import com.example.dagger.NetWork.GithubService
import dagger.Module
import dagger.Provides

@Module
class AppModule {
    @Provides
    fun provideGithubApi() = GithubService.create()

    @Provides
    fun provideImageLoader() = ImageLoader()
}