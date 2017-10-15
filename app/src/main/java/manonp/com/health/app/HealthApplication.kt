package manonp.com.health.app

import android.app.Application
import com.facebook.stetho.Stetho
import manonp.com.health.core.dagger.AppComponent
import manonp.com.health.core.dagger.AppModule
import manonp.com.health.core.dagger.DaggerAppComponent


/**
 * Created by linux on 10/9/17.
 */

class HealthApplication : Application() {
    companion object {
        lateinit var appComponent:AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        setupDatabase()
        setupStetho()

        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(applicationContext))
                .build()
    }

    /**
     * Initialize database with Realm
     */
    private fun setupDatabase() {

    }

    private fun setupStetho() {
        Stetho.initializeWithDefaults(this)
    }
}