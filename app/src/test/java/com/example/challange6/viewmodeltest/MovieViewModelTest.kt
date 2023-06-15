package com.example.challange6.viewmodeltest

import com.example.challange6.model.ResponseMovie
import com.example.challange6.network.ResultApi
import com.example.challange6.viewmodel.MovieViewModel
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import retrofit2.Call

class MovieViewModelTest { @Mock

private lateinit var viewModel: MovieViewModel
lateinit var resultApi : ResultApi



    @Before
    fun setUp() {
        resultApi = mockk()
        viewModel = MovieViewModel(resultApi)
    }

    @Test
    fun testDataRetrive(): Unit = runBlocking {
        val responseRetrive = mockk<Call<ResponseMovie>>()

        every {
            runBlocking {
                resultApi.getTrendingMovie("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyaWQiOiI1IiwiZXhwIjoxNjk5MDg5NTI4LCJpYXQiOjE2Njc1NTM1MjgsImlzcyI6ImFtaW5pdmFuIn0.A1srn810rwLwLeoaUl1zJaoTcy5noFB8Gs10hY_cGDc")
            }
        } returns responseRetrive
        val result = resultApi.getTrendingMovie("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyaWQiOiI1IiwiZXhwIjoxNjk5MDg5NTI4LCJpYXQiOjE2Njc1NTM1MjgsImlzcyI6ImFtaW5pdmFuIn0.A1srn810rwLwLeoaUl1zJaoTcy5noFB8Gs10hY_cGDc")

        verify {
            runBlocking {
                resultApi.getTrendingMovie("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyaWQiOiI1IiwiZXhwIjoxNjk5MDg5NTI4LCJpYXQiOjE2Njc1NTM1MjgsImlzcyI6ImFtaW5pdmFuIn0.A1srn810rwLwLeoaUl1zJaoTcy5noFB8Gs10hY_cGDc")
            }
        }

        Assert.assertEquals(result,responseRetrive)

    }

}