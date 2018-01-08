package com.andonichc.postsapp.presentation.postdetail

import com.andonichc.postsapp.domain.model.CommentModel
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.mock

@Suppress("IllegalIdentifier")
class CommentsCountMapperTest {
    private val mapper = CommentsCountMapper()

    @Test
    fun `map an element with size 0`() {
        //Given
        val comments = listOf<CommentModel>()

        //When
        val count = mapper.map(comments)

        //Then
        assertEquals(comments.size, count)
    }

    @Test
    fun `map an element with size 1`() {
        //Given
        val comments = listOf(mock(CommentModel::class.java))

        //When
        val count = mapper.map(comments)

        //Then
        assertEquals(comments.size, count)
    }

    @Test
    fun `map an element with size 2`() {
        //Given
        val comments = listOf(
                mock(CommentModel::class.java),
                mock(CommentModel::class.java)
        )

        //When
        val count = mapper.map(comments)

        //Then
        assertEquals(comments.size, count)
    }
}