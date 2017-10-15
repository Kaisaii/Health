package manonp.com.health.app.edit

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_edit.*
import manonp.com.health.R
import manonp.com.health.app.HealthApplication
import manonp.com.health.core.IConstant
import manonp.com.health.core.manager.MeasureDao
import manonp.com.health.core.model.Measure
import java.text.NumberFormat
import java.util.*
import javax.inject.Inject

/**
 * Created by linux on 10/9/17.
 */


class EditActivity : AppCompatActivity() {
    @Inject lateinit var measureDao: MeasureDao
    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        HealthApplication.appComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        validate_btn.setOnClickListener {
            validateValues()
        }
    }

    private fun validateValues() {
        val weight: Float = if (weight_et.text.isNotEmpty())
            NumberFormat.getInstance().parse(weight_et.text.toString()).toFloat()
        else
            -1f

        val water: Float = if (water_et.text.isNotEmpty())
            NumberFormat.getInstance().parse(water_et.text.toString()).toFloat()
        else
            -1f

        val muscle: Float = if (muscle_et.text.isNotEmpty())
            NumberFormat.getInstance().parse(muscle_et.text.toString()).toFloat()
        else
            -1f

        val fat: Float = if (fat_et.text.isNotEmpty())
            NumberFormat.getInstance().parse(fat_et.text.toString()).toFloat()
        else
            -1f

        val bones: Float = if (bones_et.text.isNotEmpty())
            NumberFormat.getInstance().parse(bones_et.text.toString()).toFloat()
        else
            -1f

        var values = listOf(weight, water, muscle, fat, bones)
        values = values.filter { it > 0 }
        if (values.isEmpty())
            Toast.makeText(applicationContext, "Au moins une donnée doit être remplie", Toast.LENGTH_LONG).show()
        else {
            addMeasure(weight, water, bones, fat, muscle)
        }
    }

    /**
     * Create new instance of measure with datas from view
     */
    private fun addMeasure(weight: Float, water: Float, bones: Float, fat: Float, muscle: Float) {
        compositeDisposable.add(Observable.fromCallable {
            measureDao.create(Measure(Date().time, weight, water, bones, fat, muscle))
        }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                    val intent = Intent()
                    setResult(IConstant.MEASURE_INSERTED, intent)
                    this.finish()
                }))
    }
}
