package com.andonichc.postsapp.data.users.network

import com.andonichc.postsapp.domain.model.UserModel
import junit.framework.Assert.assertEquals
import org.junit.Test


@Suppress("IllegalIdentifier")
class UserNetworkMapperTest {

    private val mapper = UserNetworkMapper()

    @Test
    fun `map an element`() {
        //Given
        val netModel = UserNetWorkModel(
                id = 1,
                userName = "username",
                name = "name",
                email = "email@example.com"
        )

        //When
        val model = mapper.map(netModel)

        //Then
        assertEquals(model::class, UserModel::class)
        assertEquals(netModel.id, model.id)
        assertEquals(netModel.userName, model.userName)
        assertEquals(netModel.name, model.name)
        assertEquals(netModel.email, model.email)
    }

    @Test
    fun `map a list of elements`() {
        //Given
        val netUsers = listOf(
                UserNetWorkModel(id = 1, userName = "username", name = "name", email = "email@example.com"),
                UserNetWorkModel(id = 2, userName = "username2", name = "name2", email = "email2@example.com")
        )

        //When
        val users = mapper.map(netUsers)

        //Then
        for (i in 0 until netUsers.size) {
            assertEquals(users[i]::class, UserModel::class)
            assertEquals(netUsers[i].id, users[i].id)
            assertEquals(netUsers[i].userName, users[i].userName)
            assertEquals(netUsers[i].name, users[i].name)
            assertEquals(netUsers[i].email, users[i].email)
        }
    }
}