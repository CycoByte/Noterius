package database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase


class AndroidDatabaseBuilder(private val context: Context): PlatformDatabaseBuilder {
    override fun get(databaseName: String): RoomDatabase.Builder<NotesDatabase> {
        val dbFile = context.applicationContext.getDatabasePath(databaseName)
        return Room.databaseBuilder<NotesDatabase>(
            context = context.applicationContext,
            name = dbFile.absolutePath
        )
    }
}