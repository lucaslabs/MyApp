package com.lucasnobile.myapp.presentation.feature.showLaptopList.presenter

import com.lucasnobile.myapp.domain.interactor.LoadLaptopListInteractor
import com.lucasnobile.myapp.presentation.feature.showLaptopList.view.ShowLaptopListView
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

/**
 * Unit tests for ShowLaptopListPresenter.
 *
 * @author lucas.nobile
 */
class ShowLaptopListPresenterTest {

    private val view = mock(ShowLaptopListView::class.java)
    private val interactor = mock(LoadLaptopListInteractor::class.java)
    private var presenter = ShowLaptopListPresenter(view, interactor)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun loadLaptopList() {
        // Given no-precondition

        // When
        presenter.loadLaptopList()

        // Then
        verify(interactor, times(1)).execute()
    }

    @Test
    fun onResponse() {
        // TODO
    }

    @Test
    fun onError() {
        // TODO
    }
}