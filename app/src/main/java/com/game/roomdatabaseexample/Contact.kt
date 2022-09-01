package com.game.roomdatabaseexample

import androidx.room.Entity

@Entity(tableName = "contact")
data class Contact(
    val id : Long,
    val name : String,
    val mobile : String
)
