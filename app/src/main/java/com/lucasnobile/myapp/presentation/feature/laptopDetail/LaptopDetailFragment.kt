package com.lucasnobile.myapp.presentation.feature.laptopDetail

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lucasnobile.myapp.R
import com.lucasnobile.myapp.presentation.ext.loadFromUrl
import com.lucasnobile.myapp.presentation.model.LaptopUI
import kotlinx.android.synthetic.main.fragment_laptop_detail.*

/**
 * Fragment to show the detail of the selected laptop.
 *
 * @author lucas.nobile
 */
class LaptopDetailFragment : Fragment() {

    companion object {
        const val ARG_LAPTOP = "laptop"
        /**
         * Factory method to create a new instance of this fragment.
         *
         * @return A new instance of fragment ShowLaptopListFragment.
         */
        @JvmStatic
        fun newInstance(laptopUI: LaptopUI): LaptopDetailFragment {
            val fragment = LaptopDetailFragment()
            val args = Bundle()
            args.putParcelable(ARG_LAPTOP, laptopUI)
            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var laptopUI: LaptopUI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        laptopUI = arguments!!.getParcelable(ARG_LAPTOP)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_laptop_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imgLaptop.loadFromUrl(laptopUI.imageUrl)
        txtTitle.text = laptopUI.title
        txtDescription.text = laptopUI.description
    }
}