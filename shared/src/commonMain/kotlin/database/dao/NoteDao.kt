package database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import database.DatabaseConstants
import database.entities.NoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Upsert
    suspend fun upsert(note: NoteEntity)

    @Delete
    suspend fun delete(note: NoteEntity)

    @Query("SELECT * FROM ${DatabaseConstants.NOTES_TABLE}")
    fun getAllNotesObservable(): Flow<List<NoteEntity>>

    @Query("SELECT * FROM ${DatabaseConstants.NOTES_TABLE}")
    suspend fun getAllNotes(): List<NoteEntity>

}