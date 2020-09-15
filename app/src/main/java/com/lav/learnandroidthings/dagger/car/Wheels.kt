package com.lav.learnandroidthings.dagger.car

//Suppose we don't own this class so we can't annotate it with @Inject
class Wheels(rims: Rims, tires: Tires) {  //@Inject constructor(){  //Constructor injection

    val rims = rims
    val tires = tires
}