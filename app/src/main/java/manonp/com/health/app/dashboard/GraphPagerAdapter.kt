package manonp.com.health.app.dashboard

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import manonp.com.health.app.graph.WeightGraphFragment

/**
 * Created by linux on 10/11/17.
 */


class GraphPagerAdapter(fragmentManager:FragmentManager):FragmentPagerAdapter(fragmentManager) {
    private val NUM_PAGES = 1

    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0
            -> WeightGraphFragment.newInstance()
            else -> null
        }
    }

    override fun getCount(): Int {
        return NUM_PAGES
    }

}