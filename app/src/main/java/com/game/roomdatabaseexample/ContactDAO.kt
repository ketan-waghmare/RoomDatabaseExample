package com.game.roomdatabaseexample

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface ContactDAO {

    @Insert
    suspend fun insertContact(contact: Contact)

    @Update
    suspend fun updateContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("SELECT * FROM CONTACT")
    fun getContacts() : LiveData<List<Contact>>


}