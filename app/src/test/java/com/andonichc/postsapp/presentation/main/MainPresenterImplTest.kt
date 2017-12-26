package com.andonichc.postsapp.presentation.main

import com.andonichc.postsapp.domain.model.PostModel
import com.andonichc.postsapp.domain.model.UserModel
import com.andonichc.postsapp.domain.usecase.PostsUseCase
import com.andonichc.postsapp.presentation.main.model.PostPresentationModel
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.junit.Test
import org.mockito.Mockito.*

@Suppress("IllegalIdentifier")
class MainPresenterImplTest {

    private val view = mock(MainView::class.java)
    private val useCase = mock(PostsUseCase::class.java)
    private val mapper = mock(PostPresentationMapper::class.java)

    private val presenter = MainPresenterImpl(view, useCase, mapper)

    @Test
    fun `onCreate loads posts`() {
        testLoadPosts(presenter::onCreate)
    }

    @Test
    fun `onCreate loads posts empty`() {
        testLoadPostsEmpty(presenter::onCreate)
    }

    @Test
    fun `onCreate loads posts error`() {
        testLoadPostsError(presenter::onCreate)
    }

    @Test
    fun `onRefresh loads posts`() {
        testLoadPosts(presenter::onRefresh)
    }

    @Test
    fun `onRefresh loads posts Empty`() {
        testLoadPostsEmpty(presenter::onRefresh)
    }

    @Test
    fun `onRefresh loads posts error`() {
        testLoadPostsError(presenter::onRefresh)
    }


    private fun testLoadPosts(method: () -> Unit) {
        //Given
        val pairedPostsUsers = listOf(mock(Pair::class.java)) as List<Pair<PostModel, UserModel>>
        val presentationPosts = listOf(
                PostPresentationModel(id = 1, title = "title", avatarUrl = "http://url.com/1"),
                PostPresentationModel(id = 2, title = "title2", avatarUrl = "http://url.com/2")
        )

        val single = Single.just(pairedPostsUsers)
                .observeOn(Schedulers.trampoline())
                .subscribeOn(Schedulers.trampoline())

        `when`(useCase.execute()).thenReturn(single)
        `when`(mapper.map(pairedPostsUsers)).thenReturn(presentationPosts)

        //When
        method.invoke()

        //Then
        verify(useCase).execute()
        verify(mapper).map(pairedPostsUsers)
        verify(view).showLoadingState()
        verify(view).hideLoadingState()
        verify(view).showPosts(presentationPosts)
    }

    private fun testLoadPostsEmpty(method: () -> Unit) {
        //Given
        val pairedPostsUsers = listOf(mock(Pair::class.java)) as List<Pair<PostModel, UserModel>>
        val presentationPosts = emptyList<PostPresentationModel>()

        val single = Single.just(pairedPostsUsers)
                .observeOn(Schedulers.trampoline())
                .subscribeOn(Schedulers.trampoline())

        `when`(useCase.execute()).thenReturn(single)
        `when`(mapper.map(pairedPostsUsers)).thenReturn(presentationPosts)

        //When
        method.invoke()

        //Then
        verify(useCase).execute()
        verify(mapper).map(pairedPostsUsers)
        verify(view).showLoadingState()
        verify(view).hideLoadingState()
        verify(view).showEmptyState()
    }

    private fun testLoadPostsError(method: () -> Unit) {
        //Given

        val single = Single.error<List<Pair<PostModel, UserModel>>>(Exception())
                .observeOn(Schedulers.trampoline())
                .subscribeOn(Schedulers.trampoline())

        `when`(useCase.execute()).thenReturn(single)

        //When
        method.invoke()

        //Then
        verify(useCase).execute()
        verify(view).showLoadingState()
        verify(view).hideLoadingState()
        verify(view).showErrorState()
    }

}