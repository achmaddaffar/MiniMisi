package com.daffa.minimisi.domain.usecase

import com.daffa.minimisi.data.Resource
import com.daffa.minimisi.data.model.GigModelResponse
import com.daffa.minimisi.domain.model.Gig
import kotlinx.coroutines.flow.Flow

interface IGigUseCase {

    fun addGig(
        gig: Gig
    ): Flow<Resource<String>>

    fun getNearbyGigs(): Flow<Resource<List<GigModelResponse>>>

    fun getNearbyGigsById(id: String): Flow<Resource<GigModelResponse>>
}