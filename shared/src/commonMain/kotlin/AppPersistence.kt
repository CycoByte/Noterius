import models.NoteModel

interface AppPersistence {

    suspend fun getAllNotes(): List<NoteModel>
}


expect fun getAppPersistence(): AppPersistence



object Persistence {
    private val persistence = getAppPersistence()

    fun get(): AppPersistence = persistence

}