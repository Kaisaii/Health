package manonp.com.health.core.dagger

import dagger.Module
import manonp.com.health.core.manager.MeasureManager

/**
 * Created by linux on 10/14/17.
 */


@Module class DaoModule {
    fun provideMeasureManager() = MeasureManager()
}