package manonp.com.health.core.manager

import io.realm.Realm
import io.realm.RealmObject

/**
 * Created by linux on 10/9/17.
 */
open class DataManager {
    /**
     * Save data into database with Realm
     * @param data
     */
    fun createOrUpdate(data: RealmObject) {
        val realm = Realm.getDefaultInstance()
        realm.executeTransaction { realm -> realm.copyToRealmOrUpdate(data) }
    }

    /**
     * Remove data from database with Realm
     * @param data
     */
    fun delete(data: RealmObject) {
        val realm = Realm.getDefaultInstance()
        realm.executeTransaction { data.deleteFromRealm() }
    }
}