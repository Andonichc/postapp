package com.andonichc.postsapp.data.comments.network

import com.andonichc.postsapp.domain.model.CommentModel
import junit.framework.Assert.assertEquals
import org.junit.Test


@Suppress("IllegalIdentifier")
class CommentNetworkMapperTest {
    private val mapper = CommentNetworkModelMapper()

    @Test
    fun `map an element`() {
        //Given
        val netModel = CommentNetworkModel(
                id = 1,
                postId = 1,
                name = "name",
                body = "body",
                email = "email@example.com"
        )

        //When
        val model = mapper.map(netModel)

        //Then
        assertEquals(model::class, CommentModel::class)
        assertEquals(netModel.id, model.id)
        assertEquals(netModel.postId, model.postId)
        assertEquals(netModel.name, model.name)
        assertEquals(netModel.body, model.body)
        assertEquals(netModel.email, model.email)
    }

    @Test
    fun `map a list of elements`() {
        //Given
        val netComments = listOf(
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

        //When
        val comments = mapper.map(netComments)

        //Then
        for (i in 0 until netComments.size) {
            assertEquals(comments[i]::class, CommentModel::class)
            assertEquals(netComments[i].id, comments[i].id)
            assertEquals(netComments[i].postId, comments[i].postId)
            assertEquals(netComments[i].name, comments[i].name)
            assertEquals(netComments[i].body, comments[i].body)
            assertEquals(netComments[i].email, comments[i].email)
        }
    }
}