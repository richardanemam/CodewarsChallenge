package com.example.codewarschallenge.usecase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.codewarschallenge.common.BaseTest
import com.example.codewarschallenge.data.repository.CodewarsRepository
import com.example.codewarschallenge.domain.usecase.ChallengeUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.*

class ChallengeUseCaseTest : BaseTest() {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    val dispatcher = TestCoroutineDispatcher()

    private lateinit var useCase: ChallengeUseCase
    private val repository = mockk<CodewarsRepository>()

    @ExperimentalCoroutinesApi
    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
        useCase = ChallengeUseCase(repository)
    }

    @ExperimentalCoroutinesApi
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when getting complete challenge data it should complete challenge datas list`(){
        coEvery { repository.getCompleteChallenge(any()) } returns getCompleteChallengeResponse()

        runBlocking {
            val usersCompleteChallenges = useCase.getCompleteChallengeData("richardanemam")
            Assert.assertEquals(
                getCompleteChallengesData(),
                usersCompleteChallenges
            )
        }
    }

    @Test
    fun `when getting complete challenge data it should complete authored datas list`(){
        coEvery { repository.getAuthoredChallenge(any()) } returns getAuthoredResponse()

        runBlocking {
            val usersAuthoredChallenges = useCase.getAuthoredChallengeData("richardanemam")
            Assert.assertEquals(
                getAuthoredChallengesData(),
                usersAuthoredChallenges
            )
        }
    }
}