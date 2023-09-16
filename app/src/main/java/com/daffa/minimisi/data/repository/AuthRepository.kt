package com.daffa.minimisi.data.repository

import android.util.Log
import com.daffa.minimisi.data.Resource
import com.daffa.minimisi.data.model.AuthUser
import com.daffa.minimisi.domain.repository.IAuthRepository
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import timber.log.Timber

class AuthRepository(
    private val authDb: FirebaseAuth,
) : IAuthRepository {
    override fun register(user: AuthUser): Flow<Resource<String>> = callbackFlow {
        trySend(Resource.Loading())

        authDb.createUserWithEmailAndPassword(
            user.email!!,
            user.password!!
        )
            .addOnCompleteListener { result ->
                if (result.isSuccessful) {
                    trySend(Resource.Success("Akun berhasil dibuat"))
                    Timber.log(1, "current user id: ${authDb.currentUser?.uid}")
                    Log.e("AuthRepository", "current user id: ${authDb.currentUser?.uid}")
                }
            }
            .addOnFailureListener {
                trySend(Resource.Error("Gagal membuat akun"))
                Timber.log(1, it.toString())
            }

        awaitClose {
            close()
        }
    }

    override fun loginUser(user: AuthUser): Flow<Resource<String>> = callbackFlow {
        trySend(Resource.Loading())

        authDb.signInWithEmailAndPassword(
            user.email!!,
            user.password!!
        )
            .addOnSuccessListener {
                trySend(Resource.Success("Login berhasil"))
                Timber.log(1, "current user id: ${authDb.currentUser?.uid}")
            }
            .addOnFailureListener {
                trySend(Resource.Error("Gagal login"))
                Timber.log(1, it.toString())
            }

        awaitClose {
            close()
        }
    }
}