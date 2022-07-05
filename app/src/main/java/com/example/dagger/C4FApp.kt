package com.example.dagger


import com.example.dagger.Dagger.DaggerAppCompont
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication


class C4FApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication>
    = DaggerAppCompont.builder()
        .application(this).build()
    }
