package com.example.codewarschallenge.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.codewarschallenge.common.BaseTest
import com.example.codewarschallenge.domain.usecase.ChallengeUseCase
import com.example.codewarschallenge.presentation.activity.challengesscreen.ChallengeViewModel
import com.example.codewarschallenge.presentation.states.UsersAuthoredChallengeState
import com.example.codewarschallenge.presentation.states.UsersCompleteChallengeState
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.*

class ChallengeViewModelTest : BaseTest() {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    val dispatcher = TestCoroutineDispatcher()

    private lateinit var viewModel: ChallengeViewModel
    private val useCase = mockk<ChallengeUseCase>()

    @ExperimentalCoroutinesApi
    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
        viewModel = ChallengeViewModel(useCase)
    }

    @ExperimentalCoroutinesApi
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when fetching complete challenge data it should set complete challenge available state`() {
        coEvery { useCase.getCompleteChallengeData(any()) } returns getCompleteChallengesData()
        viewModel.fetchCompleteChallenges("richardanemam")
        Assert.assertEquals(
            getCompleteChallengesData()?.let { data ->
                UsersCompleteChallengeState.OnUsersCompleteChallengeAvailable(
                    data
                )
            },
            viewModel.onCompleteChallengeState.value
        )
    }

    @Test
    fun `when fetching complete challenge data it should set complete challenge unavailable state`() {
        coEvery { useCase.getCompleteChallengeData(any()) } returns null
        viewModel.fetchCompleteChallenges("richardanemam")
        Assert.assertEquals(
            UsersCompleteChallengeState.OnUsersCompleteChallengeUnavailable,
            viewModel.onCompleteChallengeState.value
        )
    }

    @Test
    fun `when fetching authored challenge data it should set complete challenge available state`() {
        coEvery { useCase.getAuthoredChallengeData(any()) } returns getAuthoredChallengesData()
        viewModel.fetchAuthoredChallenges("richardanemam")
        Assert.assertEquals(
            getAuthoredChallengesData()?.let { data ->
                UsersAuthoredChallengeState.UsersAuthoredChallengeAvailable(
                    data
                )
            },
            viewModel.onAuthoredChallengeState.value
        )
    }

    @Test
    fun `when fetching authored challenge data it should set complete challenge unavailable state`() {
        coEvery { useCase.getAuthoredChallengeData(any()) } returns null
        viewModel.fetchAuthoredChallenges("richardanemam")
        Assert.assertEquals(
            UsersAuthoredChallengeState.UsersAuthoredChallengeUnavailable,
            viewModel.onAuthoredChallengeState.value
        )
    }
}