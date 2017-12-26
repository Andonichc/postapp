package com.andonichc.postsapp.presentation.main

import com.andonichc.postsapp.domain.ListMapper
import com.andonichc.postsapp.domain.model.PostModel
import com.andonichc.postsapp.domain.model.UserModel
import com.andonichc.postsapp.presentation.model.PostPresentationModel
import javax.inject.Inject


class PostPresentationMapper
@Inject constructor()
    : ListMapper<Pair<PostModel, UserModel>, PostPresentationModel>() {

    override fun map(from: Pair<PostModel, UserModel>): PostPresentationModel =
            PostPresentationModel(
                    id = from.first.id,
                    title = from.first.title,
                    body = from.first.body,
                    userName = from.second.userName,
                    avatarUrl = "https://api.adorable.io/avatars/285/${from.second.email}"
            )
}