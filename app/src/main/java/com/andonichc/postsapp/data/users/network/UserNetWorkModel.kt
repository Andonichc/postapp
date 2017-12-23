package com.andonichc.postsapp.data.users.network


data class UserNetWorkModel(val id: Int,
                            val name: String,
                            val userName: String,
                            val email: String)


//Other values of the User like the address or the company have been ignored
//due to be irrelevant to business and presentation layers.