package com.doanda.melodify.core.koin

import androidx.room.Room
import com.doanda.melodify.core.data.TrackRepository
import com.doanda.melodify.core.data.source.local.LocalDataSource
import com.doanda.melodify.core.data.source.local.room.TrackDatabase
import com.doanda.melodify.core.data.source.remote.RemoteDataSource
import com.doanda.melodify.core.data.source.remote.network.ApiService
import com.doanda.melodify.core.domain.repository.ITrackRepository
import com.doanda.melodify.core.utils.AppExecutors
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<TrackDatabase>().trackDao() }
    single {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("melodifyapp".toCharArray())
        val factory = SupportFactory(passphrase)
        Room.databaseBuilder(
            androidContext(),
            TrackDatabase::class.java, "track.db"
        ).fallbackToDestructiveMigration().openHelperFactory(factory).build()
    }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.deezer.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<ITrackRepository> { TrackRepository(get(), get(), get()) }
}