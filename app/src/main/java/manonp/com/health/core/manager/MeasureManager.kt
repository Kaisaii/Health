package manonp.com.health.core.manager

import android.databinding.ObservableArrayList
import io.realm.Realm
import manonp.com.health.core.model.Measure

/**
 * Created by linux on 10/9/17.
 */

object MeasureManager:DataManager() {
    fun nextId():Int {
        val realm = Realm.getDefaultInstance()
        val measures = realm.where(Measure::class.java)
                            .findAllSorted(Measure.Attributes.ID)
                            .orEmpty()

        return  if (measures.isNotEmpty()) measures.last().getId() + 1 else 0
    }

    /*
    Fetch all measures from database
     */
    fun getAll():ArrayList<Measure> {
        val realm = Realm.getDefaultInstance()
        return ArrayList(realm.where(Measure::class.java)
                .findAllSorted(Measure.Attributes.TIME)
                .orEmpty())
    }

    fun deleteAll() {
        val realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        realm.deleteAll()
        realm.commitTransaction()
    }
}