package manonp.com.health.app.dashboard

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import kotlinx.android.synthetic.main.activity_dashbord.*
import manonp.com.health.R
import manonp.com.health.app.HealthApplication
import manonp.com.health.app.edit.EditActivity
import manonp.com.health.core.IConstant
import manonp.com.health.core.manager.MeasureManager
import manonp.com.health.core.model.Measure
import java.util.*
import javax.inject.Inject

class DashboardActivity : FragmentActivity() {

    @Inject lateinit var measureManager:MeasureManager

    override fun onCreate(savedInstanceState: Bundle?) {
        HealthApplication.appComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashbord)


        add_fab.setOnClickListener {
            onAddMeasure()
        }

        setupPager()
        measureManager.deleteAll()
        val calendar = Calendar.getInstance()
        val now = calendar.time.time
        calendar.add(Calendar.DAY_OF_YEAR, -1)
        val now2 = calendar.time.time
        calendar.add(Calendar.DAY_OF_YEAR, -1)
        val now3 = calendar.time.time
        calendar.add(Calendar.DAY_OF_YEAR, -1)
        val now4 = calendar.time.time
        calendar.add(Calendar.DAY_OF_YEAR, -1)
        val now5 = calendar.time.time
        calendar.add(Calendar.DAY_OF_YEAR, -1)
        val now6 = calendar.time.time
        measureManager.createOrUpdate(Measure(now, 60f, 1f, 1f, 1f, 1f))
        measureManager.createOrUpdate(Measure(now2, 65f, 1f, 1f, 1f, 1f))
        measureManager.createOrUpdate(Measure(now3, 61f, 1f, 1f, 1f, 1f))
        measureManager.createOrUpdate(Measure(now4, 59f, 1f, 1f, 1f, 1f))
        measureManager.createOrUpdate(Measure(now5, 62f, 1f, 1f, 1f, 1f))
        measureManager.createOrUpdate(Measure(now6, 70f, 1f, 1f, 1f, 1f))
    }

    /*
    Initialize adapters for pager with different graph fragments
     */
    private fun setupPager() {
        graph_vp.adapter = GraphPagerAdapter(supportFragmentManager)
    }

    /*
    Redirect to formular to create / edit a measure
     */
    private fun onAddMeasure() {
        val editMeasure = Intent(applicationContext, EditActivity::class.java)
        this.startActivityForResult(editMeasure, IConstant.MEASURE_EDITION)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode) {
            IConstant.MEASURE_EDITION -> true
            else -> true
        }
    }
}
