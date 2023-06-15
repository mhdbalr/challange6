package com.example.challange6.viewmodeltest

import com.example.challange6.room.FavoritDao
import io.mockk.mockk
import org.junit.Before
import org.mockito.Mock

class FavoritViewModelTest {
    @Mock
    lateinit var resultApi : FavoritDao

    @Before
    fun setup() {
        resultApi = mockk()
    }

}