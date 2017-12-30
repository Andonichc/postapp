package com.andonichc.postsapp.data.comments.network


data class CommentNetworkModel(val id: Int,
                               val postId: Int,
                               val name: String,
                               val email: String,
                               val body: String)