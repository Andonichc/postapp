package com.andonichc.postsapp.presentation.postdetail

import com.andonichc.postsapp.domain.model.CommentModel
import com.andonichc.postsapp.domain.usecase.GetCommentsForPostUseCase
import com.andonichc.postsapp.presentation.model.PostPresentationModel
import com.google.gson.JsonParseException
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.junit.Test
import org.mockito.Mockito.*

@Suppress("IllegalIdentifier")
class PostDetailPresenterImplTest {

    private val view = mock(PostDetailView::class.java)
    private val useCase = mock(GetCommentsForPostUseCase::class.java)
    private val mapper = mock(CommentsCountMapper::class.java)

    private val postDetailPresenter = PostDetailPresenterImpl(view, useCase, mapper)

    @Test
    fun `onPostParsed with comments successful`() {
        //Given
        val post = PostPresentationModel(
                id = 1,
                title = "title",
                avatarUrl = "http://url.com/1",
                body = "body",
                userName = "userName")

        val commentsModel = listOf(mock(CommentModel::class.java))
        val commentsCount = 2

        val single = Single.just(commentsModel)
                .observeOn(Schedulers.trampoline())
                .subscribeOn(Schedulers.trampoline())

        `when`(useCase.execute(1)).thenReturn(single)
        `when`(mapper.map(commentsModel)).thenReturn(commentsCount)

        //When
        postDetailPresenter.onPostParsed(post)

        //Then
        verify(view).showPost(post)

        verify(useCase).execute(1)
        verify(mapper).map(commentsModel)
        verify(view).showCommentsCount(commentsCount)
    }

    @Test
    fun `onPostParsed without comments successful`() {
        val post = PostPresentationModel(
                id = 1,
                title = "title",
                avatarUrl = "http://url.com/1",
                body = "body",
                userName = "userName")

        val commentsModel = listOf(mock(CommentModel::class.java))
        val commentsCount = 0

        val single = Single.just(commentsModel)
                .observeOn(Schedulers.trampoline())
                .subscribeOn(Schedulers.trampoline())

        `when`(useCase.execute(1)).thenReturn(single)
        `when`(mapper.map(commentsModel)).thenReturn(commentsCount)

        //When
        postDetailPresenter.onPostParsed(post)

        //Then
        verify(view).showPost(post)

        verify(useCase).execute(1)
        verify(mapper).map(commentsModel)
        verify(view).showCommentsCount(commentsCount)
    }

    @Test
    fun `onPostParsed loadCommentsCount returns error`() {
        //Given
        val post = PostPresentationModel(
                id = 1,
                title = "title",
                avatarUrl = "http://url.com/1",
                body = "body",
                userName = "userName")

        `when`(useCase.execute(1)).thenReturn(Single.error(JsonParseException("")))

        //When
        postDetailPresenter.onPostParsed(post)

        //Then
        verify(view).showPost(post)

        verify(useCase).execute(1)
        verify(view, times(0)).showCommentsCount(-1)
    }

    @Test
    fun `onPostParsed with post null`() {
        //When
        postDetailPresenter.onPostParsed(null)

        //Then
        verify(useCase, times(0)).execute(1)
        verify(view, times(0)).showCommentsCount(-1)

        verify(view).showErrorState()
    }
}