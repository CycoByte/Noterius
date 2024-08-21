package database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import database.DatabaseConstants


@Entity(tableName = DatabaseConstants.NOTES_TABLE)
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val description: String,
    val content: String
)