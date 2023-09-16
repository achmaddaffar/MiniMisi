package com.daffa.minimisi.domain.model

import com.daffa.minimisi.presentation.util.Empty

data class Gig(
    val gigName: String = String.Empty,
    val employer: String = String.Empty,
    val wage: Double = 0.0,
    val location: String = String.Empty,
    val date: String = String.Empty,
    val deadline: String? = null,
    val tag: String = String.Empty,
    val description: String = String.Empty,
    val distance: String? = null,
    val quota: Int = 0,
)