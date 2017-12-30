package com.andonichc.postsapp.data.comments

import com.andonichc.postsapp.data.comments.network.CommentsNetworkDataSource
import com.andonichc.postsapp.domain.model.CommentModel
import io.reactivex.Single
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify

@Suppress("IllegalIdentifier")
class CommentsRepositoryTest {
    private val netDataSource = Mockito.mock(CommentsNetworkDataSource::class.java)

    private val commentsRepository = CommentsRepositoryImpl(netDataSource)

    @Test
    fun `when getComments dataSource getComments gets called`() {
        //Given
        val comments = listOf(
                CommentModel(id = 1,
                        postId = 1,
                        name = "name",
                        body = "body",
                        email = "email@example.com"),
                CommentModel(id = 2,
                        postId = 2,
                        name = "name2",
                        body = "body2",
                        email = "email2@example.com")
        )

        `when`(netDataSource.getComments()).thenReturn(Single.just(comments))

        //When
        val testObserver = commentsRepository
                .getComments()
                .test()

        testObserver.awaitTerminalEvent()

        //Then
        testObserver.assertNoErrors()
        verify(netDataSource).getComments()
    }
}