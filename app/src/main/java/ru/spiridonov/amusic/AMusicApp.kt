package ru.spiridonov.amusic

import android.app.Application
import ru.spiridonov.amusic.di.DaggerApplicationComponent

class AMusicApp : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }
}