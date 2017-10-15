package manonp.com.health.app.dashboard

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import kotlinx.android.synthetic.main.activity_dashbord.*
import manonp.com.health.R
import manonp.com.health.app.edit.EditActivity
import manonp.com.health.core.IConstant

class DashboardActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashbord)


        add_fab.setOnClickListener {
            onAddMeasure()
        }

        setupPager()
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
