package com.lucasnobile.myapp.presentation.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.lucasnobile.myapp.R
import com.lucasnobile.myapp.data.model.Laptop

/**
 * Main activity.
 *
 * @author lucas.nobile
 */
class MainActivity : AppCompatActivity(), ShowLaptopListFragment.OnLaptopSelectedListener {

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

    override fun onLaptopSelected(laptop: Laptop) {
        TODO("not implemented")
        // TODO Go to detail view on laptop selected
    }
}