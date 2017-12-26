package com.andonichc.postsapp.domain.model


data class PostModel(val id: Int,
                     val userId: Int,
                     val title: String,
                     val body: String)