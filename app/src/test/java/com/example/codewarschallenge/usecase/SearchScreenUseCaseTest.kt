package com.example.codewarschallenge.usecase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.codewarschallenge.common.BaseTest
import com.example.codewarschallenge.data.api.CodeWarsApi
import com.example.codewarschallenge.data.repository.CacheUserPolicyRepository
import com.example.codewarschallenge.data.repository.CodeWarsRepository
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
    private val repository = mockk<CodeWarsRepository>()
    private val service = mockk<CodeWarsApi>()
    private val cache = mockk<CacheUserPolicyRepository>()

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
    fun `when getting all users it should return all users data`() {
        coEvery { repository.getAllUsers() } returns getUsersInfo()
        coEvery { cache.put(getUser()) } returns Unit
        coEvery { service.getUser(any()) } returns getUserResponse()

        runBlocking {
            Assert.assertEquals(
                    useCase.getUsers(),
                    getUsersInfo()
            )
        }
    }
}