package com.lucasnobile.myapp.presentation.feature.showLaptopList.presenter

import com.lucasnobile.myapp.data.model.Laptop
import com.lucasnobile.myapp.domain.interactor.LoadLaptopListInteractor
import com.lucasnobile.myapp.presentation.feature.showLaptopList.view.ShowLaptopListView
import com.lucasnobile.myapp.presentation.model.LaptopUI

class ShowLaptopListPresenter(private val view: ShowLaptopListView) : LoadLaptopListInteractor.ResponseListener {

    private var interactor: LoadLaptopListInteractor

    init {
        interactor = LoadLaptopListInteractor(this)
    }

    fun loadLaptopList() {
        interactor.execute()
    }

    override fun onResponse(laptopList: List<Laptop>) {
        view.showLoadingIndicator()
        if (laptopList.isEmpty()) {
            view.showErrorMessageForEmptyList()
        } else {
            val laptopUIList = transformLaptopDataModelToLaptopUIModel(laptopList)
            view.showLaptopUIList(laptopUIList)
        }
    }

    override fun onError(t: Throwable?) {
        view.hideLoadingIndicator()
        view.showErrorMessageForLoadingLaptopList()
    }

    private fun transformLaptopDataModelToLaptopUIModel(laptopList: List<Laptop>): List<LaptopUI> {
        val laptopUIList = emptyList<LaptopUI>().toMutableList()

        laptopList.forEach {
            val laptopUI = LaptopUI(it.title, it.description, it.imageUrl)
            laptopUIList.add(laptopUI)
        }
        return laptopUIList
    }
}