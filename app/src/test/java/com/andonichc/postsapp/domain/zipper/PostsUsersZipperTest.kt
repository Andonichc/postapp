package com.andonichc.postsapp.domain.zipper

import com.andonichc.postsapp.domain.model.PostModel
import com.andonichc.postsapp.domain.model.UserModel
import junit.framework.Assert
import org.junit.Test

@Suppress("IllegalIdentifier")
class PostsUsersZipperTest {

    private val zipper = PostsUsersZipper()

    @Test
    fun `zip elements correctly`() {
        val posts = listOf(
                PostModel(1, 1, "title", "body"),
                PostModel(2, 3, "title2", "body2")
        )

        val users = listOf(
                UserModel(id = 1, userName = "username", name = "name", email = "email@example.com"),
                UserModel(id = 2, userName = "username2", name = "name2", email = "email2@example.com")
        )

        val pairedValues = zipper.zip(posts, users)

        //Post 1 has been paired up with Post 1
        Assert.assertEquals(pairedValues[0].first.userId, pairedValues[0].second.id)

        //Post 2 hasn't been paired up so it has a default User
        Assert.assertEquals(-1, pairedValues[1].second.id)
        Assert.assertEquals("", pairedValues[1].second.name)
        Assert.assertEquals("", pairedValues[1].second.userName)
        Assert.assertEquals("", pairedValues[1].second.email)
    }
}