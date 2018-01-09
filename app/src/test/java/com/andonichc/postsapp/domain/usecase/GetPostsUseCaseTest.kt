package com.andonichc.postsapp.domain.usecase

import com.andonichc.postsapp.data.posts.PostsRepository
import com.andonichc.postsapp.data.users.UsersRepository
import com.andonichc.postsapp.domain.AppSchedulers
import com.andonichc.postsapp.domain.model.PostModel
import com.andonichc.postsapp.domain.model.UserModel
import com.andonichc.postsapp.domain.zipper.PostsUsersZipper
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.junit.Test
import org.mockito.Mockito.*


@Suppress("IllegalIdentifier")
class GetPostsUseCaseTest {

    private val postsRepository = mock(PostsRepository::class.java)
    private val usersRepository = mock(UsersRepository::class.java)
    private val zipper = mock(PostsUsersZipper::class.java)

    private val useCase = GetPostsUseCase(AppSchedulers(main = Schedulers.trampoline()),
            postsRepository, usersRepository, zipper)

    @Test
    fun `execute calls Users and Posts Repositories and they get paired up as expected`() {
        //Given
        val posts = listOf(mock(PostModel::class.java))

        val users = listOf(mock(UserModel::class.java))

        `when`(postsRepository.getPosts()).thenReturn(Single.just(posts))
        `when`(usersRepository.getUsers()).thenReturn(Single.just(users))

        //When
        val testObserver = useCase.execute()
                .test()

        testObserver.awaitTerminalEvent()

        //Then
        testObserver.assertNoErrors()

        verify(postsRepository).getPosts()
        verify(usersRepository).getUsers()
        verify(zipper).zip(posts, users)
    }
}