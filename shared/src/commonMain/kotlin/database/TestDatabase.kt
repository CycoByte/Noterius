package database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [TestRecord::class],
    version = 1
)
//@ConstructedBy
abstract class TestDatabase: RoomDatabase() {
    abstract fun testDao(): TestDao
}