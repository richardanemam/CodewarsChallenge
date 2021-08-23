package com.example.codewarschallenge.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.codewarschallenge.common.BaseTest
import com.example.codewarschallenge.domain.usecase.SearchScreenUseCase
import com.example.codewarschallenge.presentation.activity.searchscreen.SearchScreenViewModel
import com.example.codewarschallenge.presentation.states.UserInfoState
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.*

class SearchScreenViewModelTest: BaseTest() {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    val dispatcher = TestCoroutineDispatcher()

    private lateinit var viewModel: SearchScreenViewModel
    private val useCase = mockk<SearchScreenUseCase>()

    @ExperimentalCoroutinesApi
    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
        viewModel = SearchScreenViewModel(useCase)
    }

    @ExperimentalCoroutinesApi
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when fetching user by name it should set users avilable state`() {
        coEvery { useCase.getNewUser(any()) } returns getUser()
        viewModel.fetchUserByName("richardanemam")

        Assert.assertEquals(
            UserInfoState.OnUserInfoAvailable(getUsers()),
            viewModel.onUserInfoState.value
        )
    }

    @Test
    fun `when fetching user by name it should set users unavailable state`() {
        coEvery { useCase.getNewUser(any()) } returns null
        viewModel.fetchUserByName("richardanemam")

        Assert.assertEquals(
            UserInfoState.OnUserInfoUnavailable,
            viewModel.onUserInfoState.value
        )
    }
}