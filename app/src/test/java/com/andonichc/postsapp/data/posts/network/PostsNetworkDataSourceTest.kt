package com.andonichc.postsapp.data.posts.network

import io.reactivex.Single
import org.junit.Test
import org.mockito.Mockito.*

@Suppress("IllegalIdentifier")
class PostsNetworkDataSourceTest {

    private val networkService = mock(PostsNetworkService::class.java)
    private val mapper = mock(PostNetworkMapper::class.java)

    private val postsNetworkDataSource = PostsNetworkDataSource(networkService, mapper)

    @Test
    fun `when getPosts mapper and service get called`() {
        //Given
        val posts = listOf(
                PostNetworkModel(1, 1, "title", "body"),
                PostNetworkModel(2, 1, "title2", "body2")
        )

        `when`(networkService.getPosts()).thenReturn(Single.just(posts))

        //When
        val testObserver = postsNetworkDataSource
                .getPosts()
                .test()

        testObserver.awaitTerminalEvent()

        //Then
        testObserver.assertNoErrors()
        verify(networkService).getPosts()
        verify(mapper).map(posts)
    }
}