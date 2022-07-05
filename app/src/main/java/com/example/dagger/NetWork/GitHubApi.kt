package com.example.dagger.NetWork

import com.example.dagger.Model.Profile
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET

    interface GitHubApi {
        @GET("users/thanhniencung")
        fun getProfile(): Call<Profile>

        @GET("users/thanhniencung")
        fun rxgetProfile(): Single<Profile>
    }
