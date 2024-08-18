package database

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver

public fun getTestDatabase(context: Context): TestDatabase {
    val dbFile = context.getDatabasePath("myTest.db")
    return Room.databaseBuilder<TestDatabase>(
        context = context.applicationContext,
        name = dbFile.absoluteFile.absolutePath
    )
    .setDriver(BundledSQLiteDriver())
    .build()
}