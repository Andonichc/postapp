package com.andonichc.postsapp.data.comments


data class CommentNetworkModel(val id: Int,
                               val postId: Int,
                               val name: String,
                               val email: String,
                               val body: String)