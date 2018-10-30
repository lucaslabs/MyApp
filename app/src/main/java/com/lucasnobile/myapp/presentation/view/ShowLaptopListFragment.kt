package com.lucasnobile.myapp.presentation.view

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin4android.ext.hide
import com.kotlin4android.ext.show
import com.kotlin4android.ext.showToast
import com.lucasnobile.myapp.R
import com.lucasnobile.myapp.data.model.Laptop
import com.lucasnobile.myapp.domain.interactor.LoadLaptopListInteractor
import com.lucasnobile.myapp.presentation.view.adapter.LaptopAdapter
import kotlinx.android.synthetic.main.fragment_show_laptop_list.*


/**
 * Fragment to show a list of laptop items.
 *
 * @author lucas.nobile
 */
class ShowLaptopListFragment : Fragment(), LoadLaptopListInteractor.ResponseListener {

    companion object {
        /**
         * Factory method to create a new instance of this fragment.
         *
         * @return A new instance of fragment ShowLaptopListFragment.
         */
        @JvmStatic
        fun newInstance() = ShowLaptopListFragment()
    }

    private lateinit var laptopAdapter: LaptopAdapter
    private var listener: OnLaptopSelectedListener? = null

    interface OnLaptopSelectedListener {
        fun onLaptopSelected(laptop: Laptop)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnLaptopSelectedListener) {
            listener = context
        } else {
            throw ClassCastException("${context.toString()} must implement OnLaptopSelectedListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_show_laptop_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvLaptop.layoutManager = LinearLayoutManager(activity)

        val laptopList = emptyList<Laptop>().toMutableList()
        laptopAdapter = LaptopAdapter(laptopList, listener)

        rvLaptop.adapter = laptopAdapter

        loadLaptopList()
    }

    private fun loadLaptopList() {
        progressBar.show()
        LoadLaptopListInteractor(this).execute()
    }

    override fun onResponse(laptopList: List<Laptop>) {
        progressBar.hide()
        if (laptopList.isEmpty()) {
            activity?.showToast(getString(R.string.alertNoLaptopListFound))
        } else {
            laptopAdapter.addLaptopList(laptopList)
        }
    }

    override fun onError(t: Throwable?) {
        progressBar.hide()
        activity?.showToast(getString(R.string.alertErrorLoadingLaptopList))
    }
}