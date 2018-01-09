package com.andonichc.postsapp.presentation.main

import com.andonichc.postsapp.domain.model.PostModel
import com.andonichc.postsapp.domain.model.UserModel
import com.andonichc.postsapp.presentation.model.PostPresentationModel
import junit.framework.Assert.assertEquals
import org.junit.Test


@Suppress("IllegalIdentifier")
class PostPresentationMapperTest {
    private val mapper = PostPresentationMapper()

    @Test
    fun `map an element`() {
        //Given
        val model = Pair(
                PostModel(id = 1, userId = 1, title = "title", body = "body"),
                UserModel(id = 1, userName = "username", name = "name", email = "email@example.com")
        )

        //When
        val presentationModel = mapper.map(model)

        //Then
        assertEquals(PostPresentationModel::class, presentationModel::class)
        assertEquals(model.first.title, presentationModel.title)
        assertEquals(model.first.body, presentationModel.body)
        assertEquals(model.first.id, presentationModel.id)
        assertEquals(model.second.userName, presentationModel.userName)
        assertEquals("$AVATAR_BASE_URL${model.second.email}", presentationModel.avatarUrl)

    }

    @Test
    fun `map a list of elements`() {
        //Given
        val pairs = listOf(
                Pair(
                        PostModel(id = 1, userId = 1, title = "title", body = "body"),
                        UserModel(id = 1, userName = "username", name = "name", email = "email@example.com")
                ),
                Pair(
                        PostModel(id = 2, userId = 2, title = "title", body = "body"),
                        UserModel(id = 2, userName = "username", name = "name", email = "email@example.com")
                )
        )

        //When
        val posts = mapper.map(pairs)

        //Then
        for (i in 0 until pairs.size) {
            assertEquals(posts[i]::class, PostPresentationModel::class)
            assertEquals(pairs[i].first.id, posts[i].id)
            assertEquals(pairs[i].first.title, posts[i].title)
            assertEquals(pairs[i].first.body, posts[i].body)
            assertEquals(pairs[i].second.userName, posts[i].userName)
            assertEquals("$AVATAR_BASE_URL${pairs[i].second.email}", posts[i].avatarUrl)
        }
    }
}