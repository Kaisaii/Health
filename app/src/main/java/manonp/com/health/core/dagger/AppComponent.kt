package manonp.com.health.core.dagger

import dagger.Component
import manonp.com.health.app.dashboard.DashboardActivity
import manonp.com.health.app.edit.EditActivity
import manonp.com.health.app.graph.WeightGraphFragment
import javax.inject.Singleton

/**
 * Created by linux on 10/14/17.
 */

@Singleton
@Component(
        modules = arrayOf(
                AppModule::class,
                DaoModule::class)
)
interface AppComponent {
    fun inject(dashboardActivity: DashboardActivity)
    fun inject(weightGraphFragment: WeightGraphFragment)
    fun inject(editActivity: EditActivity)
}