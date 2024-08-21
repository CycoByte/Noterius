package database

import androidx.room.Room
import androidx.room.RoomDatabase
import platform.Foundation.NSHomeDirectory
import platform.Foundation.NSFileManager


class IOSDatabaseBuilder: PlatformDatabaseBuilder {

    override fun get(databaseName: String): RoomDatabase.Builder<NotesDatabase> {
        val dbFilePath = documentDirectory() + "/$databaseName"
        return Room.databaseBuilder<NotesDatabase>(
            name = dbFilePath,
        )
    }

    private fun documentDirectory(): String {
        val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
            directory = NSDocumentDirectory,
            inDomain = NSUserDomainMask,
            appropriateForURL = null,
            create = false,
            error = null,
        )
        return requireNotNull(documentDirectory?.path)
    }

}