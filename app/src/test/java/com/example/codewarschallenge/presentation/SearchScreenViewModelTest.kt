package com.example.codewarschallenge.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.codewarschallenge.common.BaseTest
import com.example.codewarschallenge.data.api.CodeWarsApi
import com.example.codewarschallenge.data.repository.CodeWarsRepository
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
    private val repository = mockk<CodeWarsRepository>()
    private val service = mockk<CodeWarsApi>()

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
    fun `when fetching user by name it should set users unavailable state`() {
        coEvery { useCase.getNewUser(any()) } returns Unit
        coEvery { repository.getUser(any()) } returns Unit
        coEvery { service.getUser(any()) } returns getUserResponse()
        coEvery { useCase.getUsers() } returns geUsersAlreadyOnList()

        viewModel.fetchUserByName("richardanemam")

        Assert.assertEquals(
            UserInfoState.OnUserInfoUnavailable,
            viewModel.onUserInfoState.value
        )
    }

    @Test
    fun `when fetching user by name it should set users already on list state`() {
        coEvery { useCase.getNewUser(any()) } returns Unit
        coEvery { repository.getUser(any()) } returns Unit
        coEvery { service.getUser(any()) } returns getUserResponse()
        coEvery { useCase.getUsers() } returns geUsersAlreadyOnList()

        viewModel.fetchUserByName("richardcosta")

        Assert.assertEquals(
                UserInfoState.OnUserIsAlreadyOnList,
                viewModel.onUserInfoState.value
        )
    }

    @Test
    fun `when fetching cached users it should set available users on cached list state`() {
        coEvery { useCase.getUsers() } returns geUsersAlreadyOnList()

        viewModel.fetchCachedUsers()

        Assert.assertEquals(
                UserInfoState.OnUserInfoAvailable(geUsersAlreadyOnList()),
                viewModel.onUserInfoState.value
        )
    }

    @Test
    fun `when fetching cached users it should set unavailable users on cached list state`() {
        coEvery { useCase.getUsers() } returns emptyList()

        viewModel.fetchCachedUsers()

        Assert.assertEquals(
                UserInfoState.OnEmptyCachedList,
                viewModel.onUserInfoState.value
        )
    }
}