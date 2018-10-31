package com.lucasnobile.myapp.presentation.feature

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.lucasnobile.myapp.R
import com.lucasnobile.myapp.presentation.feature.laptopDetail.LaptopDetailFragment
import com.lucasnobile.myapp.presentation.feature.showLaptopList.view.ShowLaptopListFragment
import com.lucasnobile.myapp.presentation.model.LaptopUI

/**
 * Main activity.
 *
 * @author lucas.nobile
 */
class MainActivity : AppCompatActivity(), ShowLaptopListFragment.OnLaptopUISelectedListener {

    // TODO Add Swipe-to-refresh feature
    // TODO Add Caching Strategy using Repository pattern
    // TODO Add Dependency Injection pattern
    // TODO Add unit tests

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            goToShowLaptopListScreen()
        }
    }

    private fun goToShowLaptopListScreen() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, ShowLaptopListFragment.newInstance())
                .commit()
    }

    override fun onLaptopUISelected(laptopUI: LaptopUI) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, LaptopDetailFragment.newInstance(laptopUI))
                .addToBackStack("detail_view")
                .commit()
    }
}