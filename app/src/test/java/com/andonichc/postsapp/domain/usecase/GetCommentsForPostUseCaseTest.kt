package com.andonichc.postsapp.domain.usecase

import com.andonichc.postsapp.data.comments.CommentsRepository
import com.andonichc.postsapp.domain.AppSchedulers
import com.andonichc.postsapp.domain.model.CommentModel
import io.reactivex.Single
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.*
import io.reactivex.schedulers.Schedulers

@Suppress("IllegalIdentifier")
class GetCommentsForPostUseCaseTest {

    private val commentsRepository = mock(CommentsRepository::class.java)

    private val useCase = GetCommentsForPostUseCase(AppSchedulers(main= Schedulers.trampoline()),
            commentsRepository)

    @Test
    fun `executing with an id that has comments calls commentsRepository and returns data properly`() {
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
        `when`(commentsRepository.getComments()).thenReturn(Single.just(comments))

        //When
        val testObserver = useCase.execute(1)
                .test()

        testObserver.awaitTerminalEvent()

        //Then
        testObserver.assertNoErrors()
        verify(commentsRepository).getComments()

        val commentsResult = testObserver.values()[0]

        assertEquals(1, commentsResult.size)
        assertEquals(comments[0], commentsResult[0])
    }

    @Test
    fun `executing with an id that has no comments calls commentsRepository and returns data properly`() {
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
        `when`(commentsRepository.getComments()).thenReturn(Single.just(comments))

        //When
        val testObserver = useCase.execute(3)
                .test()

        testObserver.awaitTerminalEvent()

        //Then
        testObserver.assertNoErrors()
        verify(commentsRepository).getComments()

        val commentsResult = testObserver.values()[0]

        assertEquals(true, commentsResult.isEmpty())
    }
}