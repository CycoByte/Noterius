package database

import androidx.room.Database
import androidx.room.RoomDatabase
import database.dao.NoteDao
import database.entities.NoteEntity


@Database(
    entities = [
        NoteEntity::class,
   ],
    version = 1
)

abstract class NotesDatabase: RoomDatabase() {
    abstract fun getNotesDao(): NoteDao
}