package com.andonichc.postsapp.data.users

import com.andonichc.postsapp.data.users.network.UsersNetworkDataSource
import com.andonichc.postsapp.domain.model.UserModel
import io.reactivex.Single
import org.junit.Test
import org.mockito.Mockito


@Suppress("IllegalIdentifier")
class UsersRepositoryImplTest {

    private val netDataSource = Mockito.mock(UsersNetworkDataSource::class.java)

    private val usersRepository = UsersRepositoryImpl(netDataSource)

    @Test
    fun `when getUsers dataSource getUsers gets called`() {
        //Given
        val users = listOf(
                UserModel(id = 1, userName = "username", name = "name", email = "email@example.com"),
                UserModel(id = 2, userName = "username2", name = "name2", email = "email2@example.com")
        )

        Mockito.`when`(netDataSource.getUsers()).thenReturn(Single.just(users))

        //When
        val testObserver = usersRepository
                .getUsers()
                .test()

        testObserver.awaitTerminalEvent()

        //Then
        Mockito.verify(netDataSource).getUsers()
    }
}