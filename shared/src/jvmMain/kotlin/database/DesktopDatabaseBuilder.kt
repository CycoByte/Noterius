package database

import androidx.room.Room
import androidx.room.RoomDatabase
import java.io.File


class DesktopDatabaseBuilder: PlatformDatabaseBuilder {
    override fun get(databaseName: String): RoomDatabase.Builder<NotesDatabase> {
        val dbFile = File(System.getProperty("java.io.tmpdir"), databaseName)
        return Room.databaseBuilder<NotesDatabase>(
            name = dbFile.absolutePath,
        )
    }
}