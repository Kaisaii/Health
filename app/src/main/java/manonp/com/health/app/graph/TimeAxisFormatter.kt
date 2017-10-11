package manonp.com.health.app.graph

import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.formatter.IAxisValueFormatter
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by linux on 10/11/17.
 */


class TimeAxisFormatter : IAxisValueFormatter {
    override fun getFormattedValue(value: Float, axis: AxisBase?): String {
        val date = Date(value.toLong())
        val format = SimpleDateFormat("d MMM")
        return format.format(date)
    }


    init {
        // use one decimal
    }


}