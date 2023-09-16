package com.daffa.minimisi.domain.model

import com.daffa.minimisi.presentation.util.Empty

data class Gig(
    val gigName: String,
    val employer: String,
    val wage: Double,
    val location: String,
    val date: String,
    val tag: String,
    val description: String = String.Empty,
    val distance: String? = null
)