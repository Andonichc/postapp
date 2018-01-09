package com.andonichc.postsapp.domain.zipper

import com.andonichc.postsapp.domain.Zipper
import com.andonichc.postsapp.domain.model.PostModel
import com.andonichc.postsapp.domain.model.UserModel
import javax.inject.Inject


class PostsUsersZipper @Inject constructor()
    : Zipper<List<PostModel>, List<UserModel>, List<Pair<PostModel, UserModel>>> {
    override fun zip(posts: List<PostModel>, users: List<UserModel>): List<Pair<PostModel, UserModel>> {
        val outList: MutableList<Pair<PostModel, UserModel>> = mutableListOf()

        //Although it already comes sorted, we cannot guarantee that this will be a constant.
        // Therefore, just in case, we sort the list of users first to do searches afterwards
        val usersSorted = users.sortedBy { it.id }

        posts.forEach { post ->
            val index = usersSorted.binarySearch { it.id - post.userId }

            val user = if (index > -1)
                usersSorted[index]
            else
                UserModel(id = -1, name = "", userName = "", email = "")

            outList.add(Pair(post, user))
        }
        return outList
    }
}