package com.example.dagger.Dagger

import com.example.dagger.C4FApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    ActivityBindingModule::class

])
interface AppCompont : AndroidInjector<C4FApp>{
    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(app:C4FApp) : Builder

        fun build():AppCompont
    }
}