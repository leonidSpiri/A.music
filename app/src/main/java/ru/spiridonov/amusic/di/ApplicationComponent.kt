package ru.spiridonov.amusic.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ru.spiridonov.amusic.AMusicApp
import ru.spiridonov.amusic.presentation.MainActivity

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class,
        //WorkerModule::class
    ]
)
interface ApplicationComponent {

    fun inject(application: AMusicApp)

    fun inject(activity: MainActivity)


    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): ApplicationComponent
    }
}