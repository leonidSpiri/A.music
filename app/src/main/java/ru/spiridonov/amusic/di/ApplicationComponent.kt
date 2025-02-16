package ru.spiridonov.amusic.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ru.spiridonov.amusic.AMusicApp
import ru.spiridonov.amusic.presentation.MainActivity
import ru.spiridonov.amusic.presentation.ui.home.HomeFragment
import ru.spiridonov.amusic.presentation.ui.library.LibraryFragment
import ru.spiridonov.amusic.presentation.ui.search.SearchFragment

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

    fun inject(fragment: HomeFragment)

    fun inject(fragment: LibraryFragment)

    fun inject(fragment: SearchFragment)


    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): ApplicationComponent
    }
}