package com.lucasnobile.myapp.presentation.feature.showLaptopList.view

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lucasnobile.myapp.R
import com.lucasnobile.myapp.domain.interactor.LoadLaptopListInteractor
import com.lucasnobile.myapp.presentation.ext.hide
import com.lucasnobile.myapp.presentation.ext.show
import com.lucasnobile.myapp.presentation.ext.showToast
import com.lucasnobile.myapp.presentation.feature.showLaptopList.presenter.ShowLaptopListPresenter
import com.lucasnobile.myapp.presentation.feature.showLaptopList.view.adapter.LaptopAdapter
import com.lucasnobile.myapp.presentation.model.LaptopUI
import kotlinx.android.synthetic.main.fragment_show_laptop_list.*


/**
 * Fragment to show a list of laptop items.
 *
 * @author lucas.nobile
 */
class ShowLaptopListFragment : Fragment(), ShowLaptopListView {

    companion object {
        /**
         * Factory method to create a new instance of this fragment.
         *
         * @return A new instance of fragment ShowLaptopListFragment.
         */
        @JvmStatic
        fun newInstance() = ShowLaptopListFragment()
    }

    private lateinit var presenter: ShowLaptopListPresenter
    private var listener: OnLaptopUISelectedListener? = null
    private lateinit var laptopAdapter: LaptopAdapter

    interface OnLaptopUISelectedListener {
        fun onLaptopUISelected(laptopUI: LaptopUI)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnLaptopUISelectedListener) {
            listener = context
        } else {
            throw ClassCastException("${context.toString()} must implement OnLaptopUISelectedListener")
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

        val laptopList = emptyList<LaptopUI>().toMutableList()
        laptopAdapter = LaptopAdapter(laptopList, listener)

        rvLaptop.adapter = laptopAdapter

        val interactor = LoadLaptopListInteractor()
        presenter = ShowLaptopListPresenter(this, interactor)
    }

    override fun onResume() {
        super.onResume()
        presenter.loadLaptopList()
    }

    override fun showLaptopUIList(laptopUIList: List<LaptopUI>) {
        laptopAdapter.addLaptopUIList(laptopUIList)
    }

    override fun showLoadingIndicator() {
        progressBar.show()
    }

    override fun hideLoadingIndicator() {
        progressBar.hide()
    }

    override fun showErrorMessageForEmptyList() {
        activity?.showToast(getString(R.string.alertNoLaptopListFound))
    }

    override fun showErrorMessageForLoadingLaptopList() {
        activity?.showToast(getString(R.string.alertErrorLoadingLaptopList))
    }
}