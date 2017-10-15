package manonp.com.health.core.dagger

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import manonp.com.health.core.database.HealthDatabase
import javax.inject.Singleton


/**
 * Created by linux on 10/11/17.
 */

@Module
class AppModule(private val context: Context) {
    @Provides @Singleton
    fun providesAppContext() = context

    @Provides
    fun providesAppDatabase(context: Context) : HealthDatabase =
        Room.databaseBuilder(context, HealthDatabase::class.java, "health-db")
                .build()

    @Provides
    fun providesMeasureDao(database:HealthDatabase) = database.measureDao()
}