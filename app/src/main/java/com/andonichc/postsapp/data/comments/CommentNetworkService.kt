package com.andonichc.postsapp.data.comments


data class CommentNetworkService(val id: Int,
                                 val postId: Int,
                                 val name: String,
                                 val email: String,
                                 val body: String)