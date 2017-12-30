package com.andonichc.postsapp.domain.usecase

import com.andonichc.postsapp.data.posts.PostsRepository
import com.andonichc.postsapp.data.users.UsersRepository
import com.andonichc.postsapp.domain.Schedulers
import com.andonichc.postsapp.domain.model.PostModel
import com.andonichc.postsapp.domain.model.UserModel
import io.reactivex.Single
import io.reactivex.rxkotlin.zipWith
import javax.inject.Inject


class GetPostsUseCase
@Inject constructor(private val schedulers: Schedulers,
                    private val postsRepository: PostsRepository,
                    private val usersRepository: UsersRepository) {

    fun execute(): Single<List<Pair<PostModel, UserModel>>> =
            postsRepository.getPosts()
                    .zipWith(usersRepository.getUsers(), this::pairPostsWithUsers)
                    .observeOn(schedulers.main)
                    .subscribeOn(schedulers.io)


    /**
     * Pairs each PostModel whith its Usermodel doing a binarySearch for each post
     *
     * @param posts list of posts to be paired
     * @param users list of users to be paired
     *
     * @return a list of Pairs with each PostModel and the UserModel to which it belongs to
     */
    private fun pairPostsWithUsers(posts: List<PostModel>, users: List<UserModel>)
            : List<Pair<PostModel, UserModel>> {
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