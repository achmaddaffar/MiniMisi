package com.daffa.minimisi.presentation.search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.daffa.minimisi.presentation.util.Empty

class SearchViewModel() : ViewModel() {

    private val _searchQuery = mutableStateOf(String.Empty)
    val searchQuery: State<String> = _searchQuery

    fun setSearchQuery(query: String) {
        _searchQuery.value = query
    }
}