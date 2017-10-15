package manonp.com.health.core.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey

/**
 * Created by linux on 10/9/17.
 */

@Entity(tableName = "measure" ,
        indices= arrayOf(Index(value="time", unique=true)))
data class Measure(
        @ColumnInfo(name = "time") private var time: Long = 0,
        @ColumnInfo(name = "weight") private var weight: Float = -1f,
        @ColumnInfo(name = "water") private var water: Float = -1f,
        @ColumnInfo(name = "muscle") private var  muscle: Float = -1f,
        @ColumnInfo(name = "fat") private var fat: Float = -1f,
        @ColumnInfo(name = "bones") private var bones: Float = -1f
){

    @PrimaryKey(autoGenerate = true)
    private var id:Long = 0

    fun getId():Long { return id }
    fun getTime():Long { return time }
    fun getWeight():Float { return weight }
    fun getWater():Float { return water }
    fun getMuscle():Float { return muscle }
    fun getFat():Float { return fat }
    fun getBones():Float { return bones }

    fun setId(id:Long) { this.id = id}
    fun setTime(time:Long) { this.time = time}
    fun setWeight(weight:Float) { this.weight = weight}
    fun setWater(water:Float) { this.water = water}
    fun setMuscle(muscle:Float) { this.muscle = muscle}
    fun setFat(fat:Float) { this.fat = fat}
    fun setBones(bones:Float) { this.bones = bones}
}