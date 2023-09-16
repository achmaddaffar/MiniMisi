package com.daffa.minimisi.data.model

import com.daffa.minimisi.domain.model.Gig
import com.daffa.minimisi.presentation.util.Empty

data class GigModelResponse(
    val item: Gig?,
    val key: String? = String.Empty
)
