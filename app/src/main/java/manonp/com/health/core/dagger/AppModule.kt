package manonp.com.health.core.dagger

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * Created by linux on 10/11/17.
 */

@Module
class AppModule(private val context: Context) {
    @Provides @Singleton
    fun provideAppContext() = context
}