package database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface TestDao {

    @Upsert
    suspend fun upsert(test: TestRecord)

    @Delete
    suspend fun delete(test: TestRecord)

    @Query("SELECT * FROM test_table")
    fun getAllTest(): Flow<List<TestRecord>>
}