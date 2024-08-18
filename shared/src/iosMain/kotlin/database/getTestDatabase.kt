package database
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import platform.Foundation.NSHomeDirectory

fun getTestDatabase(): TestDatabase {

    val dbFile = NSHomeDirectory() + "/testData.db"
    return Room.databaseBuilder<TestDatabase>(
        name = dbFile,
        factory = {
            TestDatabase::class.instantiateImpl()
        }
    )
    .setDriver(BundledSQLiteDriver())
    .build()
}