package manonp.com.health.core.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import manonp.com.health.core.manager.MeasureManager

/**
 * Created by linux on 10/9/17.
 */

open class Measure() : RealmObject() {
    @PrimaryKey
    private var id:Int = 0

    private var time:Long = 0

    private var weight:Float = 0.0f

    private var water:Float = 0.0f

    private var muscle:Float = 0.0f

    private var fat:Float = 0.0f

    private var bones:Float = 0.0f


    constructor(time: Long, weight: Float, water: Float, muscle: Float, fat: Float, bones: Float) : this() {
        this.id = MeasureManager().nextId()
        this.time = time
        this.weight = weight
        this.water = water
        this.muscle = muscle
        this.fat = fat
        this.bones = bones
    }

    interface Attributes {
        companion object {
            val ID = "id"
            val TIME = "time"
            val WEIGHT = "weight"
            val WATER = "water"
            val MUSCLE = "muscle"
            val FAT = "fat"
            val BONES = "bones"
        }
    }

    fun getId():Int { return this.id }

    fun getTime():Long { return time }

    fun getWeight():Float { return weight }
}