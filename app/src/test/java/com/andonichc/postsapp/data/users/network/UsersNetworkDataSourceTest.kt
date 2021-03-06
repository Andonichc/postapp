package com.andonichc.postsapp.data.users.network

import io.reactivex.Single
import org.junit.Test
import org.mockito.Mockito


@Suppress("IllegalIdentifier")
class UsersNetworkDataSourceTest {

    private val networkService = Mockito.mock(UsersNetworkService::class.java)
    private val mapper = Mockito.mock(UserNetworkMapper::class.java)

    private val postsNetworkDataSource = UsersNetworkDataSource(networkService, mapper)

    @Test
    fun `when getUsers mapper and service get called`() {
        //Given
        val users = listOf(
                UserNetWorkModel(id = 1, userName = "username", name = "name", email = "email@example.com"),
                UserNetWorkModel(id = 2, userName = "username2", name = "name2", email = "email2@example.com")
        )

        Mockito.`when`(networkService.getUsers()).thenReturn(Single.just(users))

        //When
        val testObserver = postsNetworkDataSource
                .getUsers()
                .test()

        testObserver.awaitTerminalEvent()

        //Then
        testObserver.assertNoErrors()
        Mockito.verify(networkService).getUsers()
        Mockito.verify(mapper).map(users)
    }
}