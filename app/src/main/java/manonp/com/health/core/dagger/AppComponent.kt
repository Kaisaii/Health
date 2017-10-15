package manonp.com.health.core.dagger

import dagger.Component
import manonp.com.health.app.dashboard.DashboardActivity
import manonp.com.health.app.edit.EditActivity
import manonp.com.health.app.graph.WeightGraphFragment
import manonp.com.health.core.manager.MeasureDao
import javax.inject.Singleton

/**
 * Created by linux on 10/14/17.
 */

@Singleton
@Component(
        modules = arrayOf(
                AppModule::class)
)
interface AppComponent {
    fun inject(weightGraphFragment: WeightGraphFragment)
    fun inject(editActivity: EditActivity)
}