package database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "test_table")
data class TestRecord(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String
)
