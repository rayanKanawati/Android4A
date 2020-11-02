package com.example.android4a.injection

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import com.example.android4a.data.local.AppDatabase
import com.example.android4a.data.local.DataBaseDao
import com.example.android4a.data.repository.UserRepository
import com.example.android4a.domain.usecase.CreateUserUseCase
import com.example.android4a.presentation.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module
import java.security.AccessControlContext

val presentationModule = module {
    factory { MainViewModel(get()) }

}
val domainModule : Module = module {
    factory { CreateUserUseCase(get()) }
}
val dataModule : Module = module {
    single {UserRepository() }
    single {createDataBase(androidContext())}
}

fun createDataBase(context: Context): DataBaseDao {
    val appDatabase : AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name"
    ).build()
    return appDatabase.databaseDao()
}
