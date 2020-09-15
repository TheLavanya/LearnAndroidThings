package com.lav.learnandroidthings.dagger.di

import com.lav.learnandroidthings.dagger.car.Engine
import com.lav.learnandroidthings.dagger.car.PatrolEngine
import dagger.Binds
import dagger.Module

@Module
abstract class PatrolEngineModule {

    @Binds
    abstract fun bindPatrolEngine(patrolEngine: PatrolEngine) : Engine
}