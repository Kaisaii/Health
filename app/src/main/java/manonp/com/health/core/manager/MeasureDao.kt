package manonp.com.health.core.manager

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import io.reactivex.Flowable
import io.reactivex.Observable
import manonp.com.health.core.model.Measure

/**
 * Created by linux on 10/9/17.
 */

@Dao
interface MeasureDao {
    /*
    Fetch all measures from database
     */
    @Query("select * from measure")
    fun getAll():Flowable<List<Measure>>

    @Insert(onConflict = REPLACE)
    fun create(measure:Measure)

    @Insert(onConflict = REPLACE)
    fun update(measure:Measure)

    @Query("delete from measure")
    fun deleteAll()
}