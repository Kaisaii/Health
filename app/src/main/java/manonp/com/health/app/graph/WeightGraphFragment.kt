package manonp.com.health.app.graph

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.components.XAxis.XAxisPosition
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IFillFormatter
import kotlinx.android.synthetic.main.graph.*
import manonp.com.health.R
import manonp.com.health.app.HealthApplication
import manonp.com.health.core.manager.MeasureManager
import manonp.com.health.core.model.Measure
import javax.inject.Inject


/**
 * Created by linux on 10/11/17.
 */


class WeightGraphFragment : Fragment() {
    private var measures: ArrayList<Measure> = ArrayList()
    private var entries: ArrayList<Entry> = ArrayList()

    @Inject lateinit var measureManager:MeasureManager

    companion object {
        fun newInstance(): WeightGraphFragment {
            val fragment = WeightGraphFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        HealthApplication.appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.graph, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        chart.setScaleEnabled(false)
        chart.legend.isEnabled = false
        chart.setDrawGridBackground(true)
        chart.setBackgroundColor(Color.WHITE)
        chart.description.isEnabled = false

        val xAxis = chart.xAxis
        xAxis.position = XAxisPosition.BOTTOM
        xAxis.textSize = 12f
        xAxis.setDrawAxisLine(true)
        xAxis.setDrawGridLines(false)
        xAxis.setLabelCount(2, true)


        xAxis.valueFormatter = TimeAxisFormatter()

        // Left Axis for weight
        val yAxis = chart.axisLeft
        yAxis.textSize = 12f
        yAxis.axisMinimum = 0f
        yAxis.axisMaximum = 100f
        yAxis.setDrawAxisLine(true)
        yAxis.setDrawGridLines(true)
        yAxis.setLabelCount(6, true) // force 6 labels

        // No right Axis
        chart.axisRight.isEnabled = false

        chart.invalidate()
    }

    override fun onResume() {
        super.onResume()
        reloadMeasures()
    }

    private fun reloadMeasures() {
        measures = measureManager.getAll()
        entries.clear()
        for (measure in measures) {
            entries.add(Entry(measure.getTime().toFloat(), measure.getWeight()))
        }
        if (entries.isNotEmpty()) {

            val dataSet = LineDataSet(entries, "Weight dataset")
            dataSet.axisDependency = YAxis.AxisDependency.LEFT
            dataSet.color = context.resources.getColor(R.color.orange)
            dataSet.setCircleColor(context.resources.getColor(R.color.brown))
            dataSet.setDrawCircleHole(false)
            dataSet.circleRadius = 3f
            dataSet.lineWidth = 2f
            dataSet.highLightColor = resources.getColor(R.color.brown)
            dataSet.setDrawFilled(true)
            dataSet.fillAlpha = 255
            dataSet.fillColor = resources.getColor(R.color.orange)
            dataSet.fillFormatter = IFillFormatter { _, _ -> 0f }

            val lineData = LineData(dataSet)
            lineData.setDrawValues(false)
            chart.data = lineData
            chart.data.notifyDataChanged()
            chart.notifyDataSetChanged()
        }
    }
}