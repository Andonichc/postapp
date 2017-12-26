package com.andonichc.postsapp.data.posts

import com.andonichc.postsapp.data.posts.network.PostsNetworkDataSource
import com.andonichc.postsapp.domain.model.PostModel
import io.reactivex.Single
import org.junit.Test
import org.mockito.Mockito.*

@Suppress("IllegalIdentifier")
class PostsRepositoryImplTest {

    private val netDataSource = mock(PostsNetworkDataSource::class.java)

    private val postsRepository = PostsRepositoryImpl(netDataSource)

    @Test
    fun `when getPosts dataSource getPosts gets called`() {
        //Given
        val posts = listOf(
                PostModel(1, 1, "title", "body"),
                PostModel(2, 1, "title2", "body2")
        )

        `when`(netDataSource.getPosts()).thenReturn(Single.just(posts))

        //When
        val testObserver = postsRepository
                .getPosts()
                .test()

        testObserver.awaitTerminalEvent()

        //Then
        testObserver.assertNoErrors()
        verify(netDataSource).getPosts()
    }
}