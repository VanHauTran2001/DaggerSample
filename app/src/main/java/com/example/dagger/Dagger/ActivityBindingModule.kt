package com.example.dagger.Dagger

import com.example.dagger.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
 abstract class ActivityBindingModule {
  @ContributesAndroidInjector
  abstract fun bindMainActivity() : MainActivity
}