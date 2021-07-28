package com.example.codewarschallenge.usecase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.codewarschallenge.common.BaseTest
import com.example.codewarschallenge.data.repository.CodewarsRepository
import com.example.codewarschallenge.domain.usecase.SearchScreenUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.*

class SearchScreenUseCaseTest : BaseTest() {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    val dispatcher = TestCoroutineDispatcher()

    private lateinit var useCase: SearchScreenUseCase
    private val repository = mockk<CodewarsRepository>()

    @ExperimentalCoroutinesApi
    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
        useCase = SearchScreenUseCase(repository)
    }

    @ExperimentalCoroutinesApi
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when getting user data it should return user data`() {
        coEvery { repository.getUser(any()) } returns getUserResponse()
        runBlocking {
            val user = useCase.getUser("richardanemam")
            Assert.assertEquals(getUser(), user)
        }
    }
}