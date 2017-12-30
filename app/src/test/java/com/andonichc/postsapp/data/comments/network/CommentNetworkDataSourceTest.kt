package com.andonichc.postsapp.data.comments.network

import io.reactivex.Single
import org.junit.Test
import org.mockito.Mockito

@Suppress("IllegalIdentifier")
class CommentNetworkDataSourceTest {
    private val networkService = Mockito.mock(CommentsNetworkService::class.java)
    private val mapper = Mockito.mock(CommentNetworkModelMapper::class.java)

    private val commentsNetworkDataSource = CommentsNetworkDataSource(networkService, mapper)

    @Test
    fun `when getComments mapper and service get called`() {
        //Given
        val comments = listOf(
                CommentNetworkModel(id = 1,
                        postId = 1,
                        name = "name",
                        body = "body",
                        email = "email@example.com"),
                CommentNetworkModel(id = 2,
                        postId = 2,
                        name = "name2",
                        body = "body2",
                        email = "email2@example.com")
        )

        Mockito.`when`(networkService.getComments()).thenReturn(Single.just(comments))

        //When
        val testObserver = commentsNetworkDataSource
                .getComments()
                .test()

        testObserver.awaitTerminalEvent()

        //Then
        testObserver.assertNoErrors()
        Mockito.verify(networkService).getComments()
        Mockito.verify(mapper).map(comments)
    }
}