package com.example.android4a.domain.usercase

import com.example.android4a.data.repository.UserRepository
import com.example.android4a.domain.entity.User

import com.example.android4a.domain.usecase.GetUserUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertEquals


import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetUserUseCaseTest{
    private val userRepository: UserRepository = mockk()
    private val classUnderTest = GetUserUseCase(userRepository)

    @Test
    fun `invoke with invalid email`(){
        runBlocking {
            val email =  "a@a.c"
            val expectedUser = User("a@a.c","a")
            val password =  "a"

            coEvery { userRepository.getUser(email,password) } returns expectedUser

            val result = classUnderTest.invoke(email,password)

            coVerify ( exactly = 1){ userRepository.getUser(email,password)}
            assertEquals(result, expectedUser)

        }
    }

}
