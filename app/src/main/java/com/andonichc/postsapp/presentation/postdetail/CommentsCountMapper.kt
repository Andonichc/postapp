package com.andonichc.postsapp.presentation.postdetail

import com.andonichc.postsapp.domain.Mapper
import com.andonichc.postsapp.domain.model.CommentModel


class CommentsCountMapper : Mapper<List<CommentModel>, Int> {
    override fun map(from: List<CommentModel>): Int = from.size
}