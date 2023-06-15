package com.example.challange6

import com.example.challange6.model.ResponseMovie
import com.example.challange6.network.ResultApi
import com.example.challange6.viewmodel.MovieViewModel
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import retrofit2.Call

class MovieViewModelTest {
    @Mock
    lateinit var resultApi : ResultApi
    private lateinit var viewModel: MovieViewModel

//    lateinit var viewModel: MovieViewModel

    @Before
    fun setup() {
        resultApi = mockk()
        viewModel = MovieViewModel(resultApi)
    }

    @Test
    fun tesRetrive(): Unit = runBlocking {
        //membuat objek palsu (mock) responseRetrive dari kelas Call<List<Source>>
        //Objek palsu ini akan digunakan sebagai respons palsu dari pemanggilan service.getAllSources().
        val responseRetriveData = mockk<Call<ResponseMovie>>()

        every {
            runBlocking {
                resultApi.getTrendingMovie("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyaWQiOiI1IiwiZXhwIjoxNjk5MDg5NTI4LCJpYXQiOjE2Njc1NTM1MjgsImlzcyI6ImFtaW5pdmFuIn0.A1srn810rwLwLeoaUl1zJaoTcy5noFB8Gs10hY_cGDc")
            }
        } returns responseRetriveData
        val result = resultApi.getTrendingMovie("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyaWQiOiI1IiwiZXhwIjoxNjk5MDg5NTI4LCJpYXQiOjE2Njc1NTM1MjgsImlzcyI6ImFtaW5pdmFuIn0.A1srn810rwLwLeoaUl1zJaoTcy5noFB8Gs10hY_cGDc")

        //verify, kita memastikan bahwa metode service.getAllSources() benar-benar dipanggil dengan argumen yang sesuai.

        verify {
            runBlocking {
                resultApi.getTrendingMovie("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyaWQiOiI1IiwiZXhwIjoxNjk5MDg5NTI4LCJpYXQiOjE2Njc1NTM1MjgsImlzcyI6ImFtaW5pdmFuIn0.A1srn810rwLwLeoaUl1zJaoTcy5noFB8Gs10hY_cGDc")
            }
        }

        //assertEquals, kita membandingkan nilai result yang diperoleh dari pemanggilan service.getAllSources()
        // dengan objek palsu responseRetrive, untuk memastikan bahwa hasilnya sesuai dengan yang diharapkan.
        assertEquals(result,responseRetriveData)

    }

}