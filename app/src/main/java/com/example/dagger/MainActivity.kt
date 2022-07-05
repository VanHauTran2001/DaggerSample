package com.example.dagger

import android.annotation.SuppressLint
import android.os.Bundle
import com.example.dagger.Model.Profile
import com.example.dagger.NetWork.GitHubApi
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {
    @Inject //anotation
    lateinit var gitHubApi: GitHubApi

    @Inject
    lateinit var imageLoader: ImageLoader
    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //call api
//        gitHubApi.getProfile().enqueue(object : retrofit2.Callback<Profile>{
//            override fun onResponse(call: Call<Profile>, response: Response<Profile>) {
//                txtShow.text = response.body()?.login
//            }
//
//            override fun onFailure(call: Call<Profile>, t: Throwable) {
//                txtShow.text = t.message
//            }
//
//        })
//            gitHubApi.rxgetProfile()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeBy(
//                    onSuccess = {txtShow.text = "${it.login}"},
//                    onError = {it.printStackTrace()}
//                )
        gitHubApi.rxgetProfile()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onSuccess = {imageLoader.load(it.avatar_url,imgShow)},
                    onError = {it.printStackTrace()}
                )

    }

}

