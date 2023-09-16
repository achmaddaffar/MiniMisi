package com.daffa.minimisi.data.repository

import android.util.Log
import com.daffa.minimisi.data.Resource
import com.daffa.minimisi.data.model.GigModelResponse
import com.daffa.minimisi.data.model.UserModelResponse
import com.daffa.minimisi.domain.model.Gig
import com.daffa.minimisi.domain.model.User
import com.daffa.minimisi.domain.repository.IRealtimeDbRepository
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.getValue
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class RealtimeDbRepository(
    private val db: FirebaseDatabase,
) : IRealtimeDbRepository {

    private val userDb = db.reference.child("users")
    private val gigDb = db.reference.child("gigs")

    override fun addUser(user: User): Flow<Resource<String>> = callbackFlow {
        trySend(Resource.Loading())

        userDb.push().setValue(
            user
        )
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    trySend(Resource.Success("User berhasil ditambahkan ke RDB"))
                }
            }
            .addOnFailureListener {
                trySend(Resource.Error(it.toString()))
            }

        awaitClose {
            close()
        }
    }

    override fun readUser(email: String): Flow<Resource<User>> = callbackFlow {
        trySend(Resource.Loading())

        val valueEvent = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val items = snapshot.children.map {
                    UserModelResponse(
                        it.getValue(User::class.java),
                        key = it.key
                    )
                }

                val data = items.filter { it.item?.email == email }
                trySend(Resource.Success(data[0].item as User))
            }

            override fun onCancelled(error: DatabaseError) {
                trySend(Resource.Error(error.toString()))
            }
        }

        userDb.addValueEventListener(valueEvent)
        awaitClose {
            userDb.removeEventListener(valueEvent)
            close()
        }
    }

    override fun addGig(gig: Gig): Flow<Resource<String>> = callbackFlow {
        trySend(Resource.Loading())

        gigDb.push().setValue(
            gig
        )
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    trySend(Resource.Success("Sukses menambahkan pekerjaan"))
                } else {
                    trySend(Resource.Error(it.toString()))
                }
            }
            .addOnFailureListener {
                trySend(Resource.Error(it.toString()))
            }

        awaitClose {
            close()
        }
    }

    override fun getNearbyGigs(): Flow<Resource<List<Gig>>> = callbackFlow {
        trySend(Resource.Loading())

        val valueEvent = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val items = snapshot.children.map {
                    GigModelResponse(
                        it.getValue(Gig::class.java),
                        key = it.key
                    )
                }
                    .map {
                        it.item!!
                    }

                trySend(Resource.Success(items))
            }

            override fun onCancelled(error: DatabaseError) {
                trySend(Resource.Error(error.toString()))
            }
        }

        gigDb.addValueEventListener(valueEvent)
        awaitClose {
            gigDb.removeEventListener(valueEvent)
            close()
        }
    }
}