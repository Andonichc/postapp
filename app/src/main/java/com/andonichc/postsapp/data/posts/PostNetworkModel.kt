package com.andonichc.postsapp.data.posts


data class PostNetworkModel(val id: Int,
                            val userId: Int,
                            val title: String,
                            val body: String)