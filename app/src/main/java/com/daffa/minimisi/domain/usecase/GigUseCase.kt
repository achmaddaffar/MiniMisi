package com.daffa.minimisi.domain.usecase

import com.daffa.minimisi.data.Resource
import com.daffa.minimisi.data.model.GigModelResponse
import com.daffa.minimisi.domain.model.Gig
import com.daffa.minimisi.domain.repository.IRealtimeDbRepository
import kotlinx.coroutines.flow.Flow

class GigUseCase(
    private val dbRepository: IRealtimeDbRepository
): IGigUseCase {
    override fun addGig(gig: Gig): Flow<Resource<String>> = dbRepository.addGig(gig)

    override fun getNearbyGigs(): Flow<Resource<List<GigModelResponse>>> = dbRepository.getNearbyGigs()

    override fun getNearbyGigsById(id: String): Flow<Resource<GigModelResponse>> = dbRepository.getNearbyGigsById(id)
}