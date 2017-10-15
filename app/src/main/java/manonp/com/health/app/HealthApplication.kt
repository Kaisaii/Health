package manonp.com.health.app

import android.app.Application
import com.facebook.stetho.Stetho
import com.uphyca.stetho_realm.RealmInspectorModulesProvider
import io.realm.Realm
import io.realm.RealmConfiguration
import manonp.com.health.core.migration.DatabaseMigration
import manonp.com.health.core.dagger.AppComponent
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
                .build()
    }

    /**
     * Initialize database with Realm
     */
    private fun setupDatabase() {
        Realm.init(applicationContext)
        val config = RealmConfiguration.Builder()
                .schemaVersion(1) // Must be bumped when the schema changes
                .migration(DatabaseMigration()) // Migrations to run
                .build()
        Realm.setDefaultConfiguration(config)
    }

    private fun setupStetho() {
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                        .build())
    }
}