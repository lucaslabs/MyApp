package com.lucasnobile.myapp.presentation.feature.showLaptopList.view

import com.lucasnobile.myapp.presentation.model.LaptopUI

interface ShowLaptopListView {

    fun showLaptopUIList(laptopUIList: List<LaptopUI>)

    fun showLoadingIndicator()

    fun hideLoadingIndicator()

    fun showErrorMessageForEmptyList()

    fun showErrorMessageForLoadingLaptopList()
}