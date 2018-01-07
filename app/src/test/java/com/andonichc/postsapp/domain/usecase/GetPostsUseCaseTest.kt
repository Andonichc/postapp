package com.andonichc.postsapp.domain.usecase

import com.andonichc.postsapp.data.posts.PostsRepository
import com.andonichc.postsapp.data.users.UsersRepository
import com.andonichc.postsapp.domain.AppSchedulers
import com.andonichc.postsapp.domain.model.PostModel
import com.andonichc.postsapp.domain.model.UserModel
import io.reactivex.Single
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import io.reactivex.schedulers.Schedulers


@Suppress("IllegalIdentifier")
class GetPostsUseCaseTest {

    private val postsRepository = mock(PostsRepository::class.java)
    private val usersRepository = mock(UsersRepository::class.java)

    private val useCase = GetPostsUseCase(AppSchedulers(main = Schedulers.trampoline()),
            postsRepository, usersRepository)

    @Test
    fun `execute calls Users and Posts Repositories and they get paired up as expected`() {
        //Given
        val posts = listOf(
                PostModel(1, 1, "title", "body"),
                PostModel(2, 3, "title2", "body2")
        )

        val users = listOf(
                UserModel(id = 1, userName = "username", name = "name", email = "email@example.com"),
                UserModel(id = 2, userName = "username2", name = "name2", email = "email2@example.com")
        )

        `when`(postsRepository.getPosts()).thenReturn(Single.just(posts))
        `when`(usersRepository.getUsers()).thenReturn(Single.just(users))

        //When
        val testObserver = useCase.execute()
                .test()

        testObserver.awaitTerminalEvent()

        //Then
        testObserver.assertNoErrors()

        val pairedValues = testObserver.values()[0]

        //Post 1 has been paired up with Post 1
        assertEquals(pairedValues[0].first.userId, pairedValues[0].second.id)

        //Post 2 hasn't been paired up so it has a default User
        assertEquals(-1, pairedValues[1].second.id)
        assertEquals("", pairedValues[1].second.name)
        assertEquals("", pairedValues[1].second.userName)
        assertEquals("", pairedValues[1].second.email)


    }
}