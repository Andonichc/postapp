package com.andonichc.postsapp.domain.usecase

import com.andonichc.postsapp.data.posts.PostsRepository
import com.andonichc.postsapp.data.users.UsersRepository
import com.andonichc.postsapp.domain.Schedulers
import com.andonichc.postsapp.domain.model.PostModel
import com.andonichc.postsapp.domain.model.UserModel
import com.andonichc.postsapp.domain.zipper.PostsUsersZipper
import io.reactivex.Single
import io.reactivex.rxkotlin.zipWith
import javax.inject.Inject


class GetPostsUseCase
@Inject constructor(private val schedulers: Schedulers,
                    private val postsRepository: PostsRepository,
                    private val usersRepository: UsersRepository,
                    private val postsUsersZipper: PostsUsersZipper) {

    fun execute(): Single<List<Pair<PostModel, UserModel>>> =
            postsRepository.getPosts()
                    .zipWith(usersRepository.getUsers(), postsUsersZipper::zip)
                    .observeOn(schedulers.main)
                    .subscribeOn(schedulers.io)
}