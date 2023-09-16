package com.daffa.minimisi.domain.repository

import com.daffa.minimisi.data.Resource
import com.daffa.minimisi.data.model.GigModelResponse
import com.daffa.minimisi.domain.model.Gig
import com.daffa.minimisi.domain.model.User
import kotlinx.coroutines.flow.Flow

interface IRealtimeDbRepository {

    fun addUser(
        user: User
    ): Flow<Resource<String>>

    fun readUser(
        email: String
    ): Flow<Resource<User>>

    fun addGig(
        gig: Gig
    ): Flow<Resource<String>>

    fun getNearbyGigs(): Flow<Resource<List<GigModelResponse>>>

    fun getNearbyGigsById(id: String): Flow<Resource<GigModelResponse>>
}