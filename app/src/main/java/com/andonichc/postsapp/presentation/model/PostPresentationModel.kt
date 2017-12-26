package com.andonichc.postsapp.presentation.model


data class PostPresentationModel(val id: Int,
                                 val title: String,
                                 val body: String,
                                 val userName: String,
                                 val avatarUrl: String)