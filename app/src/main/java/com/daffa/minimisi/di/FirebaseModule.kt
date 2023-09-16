package com.daffa.minimisi.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import org.koin.dsl.module

val firebaseModule = module {
    single { FirebaseAuth.getInstance() }
    single { FirebaseDatabase.getInstance("https://minimisi-d3218-default-rtdb.asia-southeast1.firebasedatabase.app") }
}