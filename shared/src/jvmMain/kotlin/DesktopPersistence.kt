import models.NoteModel



class DesktopPersistence: AppPersistence {

    //init room db for desktop, implement functionality

    override suspend fun getAllNotes(): List<NoteModel> {
        TODO("Not yet implemented")
    }
}



actual fun getAppPersistence(): AppPersistence {
    return DesktopPersistence()
}

