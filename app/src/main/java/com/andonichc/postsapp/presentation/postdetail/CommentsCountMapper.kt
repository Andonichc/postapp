package com.andonichc.postsapp.presentation.postdetail

import com.andonichc.postsapp.domain.Mapper
import com.andonichc.postsapp.domain.model.CommentModel
import javax.inject.Inject


class CommentsCountMapper
@Inject constructor() : Mapper<List<CommentModel>, Int> {
    override fun map(from: List<CommentModel>): Int = from.size
}