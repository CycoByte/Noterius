import models.NoteModel


class IOSPersistence: AppPersistence {

    //init room db for ios, implement functionality

    override suspend fun getAllNotes(): List<NoteModel> {
        TODO("Not yet implemented")
    }
}


actual fun getAppPersistence(): AppPersistence {
    return IOSPersistence()
}