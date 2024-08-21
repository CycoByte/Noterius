import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import database.DatabaseConstants
import database.NotesDatabase
import database.PlatformDatabaseBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import models.NoteModel


interface IPersistence {
    suspend fun getAllNotesObservable(): Flow<List<NoteModel>>
    suspend fun addNewNote(note: NoteModel)
    suspend fun updateNote(note: NoteModel)
    suspend fun deleteNote(note: NoteModel)
    suspend fun getAllNotes(): List<NoteModel>
}


class AppPersistence(builder: PlatformDatabaseBuilder): IPersistence {

    private val roomDb: NotesDatabase = builder
        .get(DatabaseConstants.NOTES_DATABASE)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()

    override suspend fun getAllNotesObservable(): Flow<List<NoteModel>> {
        return roomDb.getNotesDao()
            .getAllNotesObservable()
            .map { inputList ->
                inputList.map { NoteMapper.fromEntity(it) }
            }
    }

    override suspend fun addNewNote(note: NoteModel) {
        roomDb.getNotesDao().upsert(NoteMapper.toEntity(note))
    }

    override suspend fun updateNote(note: NoteModel) {
        roomDb.getNotesDao().upsert(NoteMapper.toEntity(note))
    }

    override suspend fun deleteNote(note: NoteModel) {
        roomDb.getNotesDao().delete(NoteMapper.toEntity(note))
    }

    override suspend fun getAllNotes(): List<NoteModel> {
        return roomDb.getNotesDao().getAllNotes().map { NoteMapper.fromEntity(it) }
    }
}