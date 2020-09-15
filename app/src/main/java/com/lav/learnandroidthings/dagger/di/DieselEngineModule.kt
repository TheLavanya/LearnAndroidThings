package com.lav.learnandroidthings.dagger.di

import com.lav.learnandroidthings.dagger.car.DieselEngine
import com.lav.learnandroidthings.dagger.car.Engine
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class DieselEngineModule {

    //val horsePower: Int = horsePower

     @Binds
     abstract fun bindDieselEngine(dieselEngine: DieselEngine): Engine

   /* @Provides
    fun providesDieselEngine(): Engine {
        DieselEngine(horsePower)
    }*/
}