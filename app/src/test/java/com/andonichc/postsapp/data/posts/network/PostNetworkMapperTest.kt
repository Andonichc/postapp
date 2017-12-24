package com.andonichc.postsapp.data.posts.network

import com.andonichc.postsapp.domain.model.PostModel
import junit.framework.Assert.assertEquals
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

@Suppress("IllegalIdentifier")
class PostNetworkMapperTest {

    private val mapper = PostNetworkMapper()

    @Test
    fun `map an element`() {
        //Given
        val netModel = PostNetworkModel(
                id = 1,
                userId = 1,
                title = "title",
                body = "body"
        )

        //When
        val model = mapper.map(netModel)

        //Then
        assertEquals(model::class, PostModel::class)
        assertEquals(netModel.id, model.id)
        assertEquals(netModel.userId, model.userId)
        assertEquals(netModel.title, model.title)
        assertEquals(netModel.body, model.body)
    }

    @Test
    fun `map a list of elements`() {
        //Given
        val netPosts = listOf(
                PostNetworkModel(id = 1, userId = 1, title = "title", body = "body"),
                PostNetworkModel(id = 2, userId = 2, title = "title2", body = "body2")
        )

        //When
        val posts = mapper.map(netPosts)

        //Then
        for (i in 0 until netPosts.size) {
            assertEquals(posts[i]::class, PostModel::class)
            assertEquals(netPosts[i].id, posts[i].id)
            assertEquals(netPosts[i].userId, posts[i].userId)
            assertEquals(netPosts[i].title, posts[i].title)
            assertEquals(netPosts[i].body, posts[i].body)
        }
    }
}