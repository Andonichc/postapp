package com.andonichc.postsapp.domain.usecase

import com.andonichc.postsapp.data.posts.PostsRepository
import com.andonichc.postsapp.data.users.UsersRepository
import com.andonichc.postsapp.domain.Schedulers
import com.andonichc.postsapp.domain.model.PostModel
import com.andonichc.postsapp.domain.model.UserModel
import io.reactivex.Single
import io.reactivex.rxkotlin.zipWith
import java.util.*
import javax.inject.Inject


class PostsUseCase
@Inject constructor(private val schedulers: Schedulers,
                    private val postsRepository: PostsRepository,
                    private val usersRepository: UsersRepository) {

    fun execute(): Single<List<Pair<PostModel, UserModel>>> =
            postsRepository.getPosts()
                    .zipWith(usersRepository.getUsers(), this::pairPostsWithUsers)
                    .observeOn(schedulers.main)
                    .subscribeOn(schedulers.io)


    private fun pairPostsWithUsers(posts: List<PostModel>, users: List<UserModel>)
            : List<Pair<PostModel, UserModel>> {
        val outList: MutableList<Pair<PostModel, UserModel>> = mutableListOf()

        //Although it already comes sorted, we cannot guarantee that this will be a constant.
        // Therefore, just in case, we sort the list of users first to do searches afterwards
        users.sortedBy { it.id }

        posts.forEach { post ->
            val index = users.binarySearch { it.id - post.userId }

            val user = if (index > -1)
                users[index]
            else
                UserModel(id = -1, name = "", userName = "", email = "")

            outList.add(Pair(post, user))
        }
        return outList
    }
}