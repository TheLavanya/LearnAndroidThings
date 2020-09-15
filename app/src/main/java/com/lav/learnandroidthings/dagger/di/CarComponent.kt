package com.lav.learnandroidthings.dagger.di

import com.lav.learnandroidthings.dagger.MainActivity
import dagger.Component

@Component(modules = [WheelsModule::class,  DieselEngineModule::class])
interface CarComponent {

    fun injectMainActivity(mainActivity: MainActivity)
}