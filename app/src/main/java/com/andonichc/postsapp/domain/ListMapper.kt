package com.andonichc.postsapp.domain


abstract class ListMapper<in FROM, out TO>: Mapper<FROM, TO> {
    fun map(fromList: List<FROM>): List<TO> =
            fromList.map (this::map)
}