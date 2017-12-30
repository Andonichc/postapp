package com.andonichc.postsapp.domain.model


data class CommentModel(val id: Int,
                        val postId: Int,
                        val name: String,
                        val email: String,
                        val body: String)