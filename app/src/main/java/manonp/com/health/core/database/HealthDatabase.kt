package manonp.com.health.core.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import manonp.com.health.core.manager.MeasureDao
import manonp.com.health.core.model.Measure

/**
 * Created by linux on 10/15/17.
 */

@Database(entities = arrayOf(Measure::class), version = 1, exportSchema = false)
abstract class HealthDatabase : RoomDatabase() {
    abstract fun measureDao():MeasureDao
}