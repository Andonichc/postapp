package com.andonichc.postsapp.domain.usecase

import com.andonichc.postsapp.data.comments.CommentsRepository
import com.andonichc.postsapp.domain.AppSchedulers
import com.andonichc.postsapp.domain.model.CommentModel
import io.reactivex.Single
import javax.inject.Inject


class GetCommentsForPostUseCase
@Inject constructor(private val schedulers: AppSchedulers,
                    private val commentsRepository: CommentsRepository) {

    fun execute(postId: Int): Single<List<CommentModel>> =
            commentsRepository.getComments()
                    .observeOn(schedulers.main)
                    .subscribeOn(schedulers.io)
                    .map { it.filter { it.postId == postId } }

}