package database

import androidx.room.RoomDatabase

interface PlatformDatabaseBuilder {
    fun get(databaseName: String): RoomDatabase.Builder<NotesDatabase>
}