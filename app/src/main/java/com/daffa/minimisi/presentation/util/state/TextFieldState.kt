package com.daffa.minimisi.presentation.util.state

import com.daffa.minimisi.presentation.util.Empty

data class TextFieldState(
    val text: String = String.Empty,
    val error: String = String.Empty
)