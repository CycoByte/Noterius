import models.NoteModel

class AndroidPersistence: AppPersistence {

    //init room db, implement functionality

    override suspend fun getAllNotes(): List<NoteModel> {
        return listOf(
            NoteModel(
                name = "One",
                id = 1,
                description = "Android test"
            ),
            NoteModel(
                name = "Two",
                id = 2,
                description = "Android test"
            ),
            NoteModel(
                name = "Three",
                id = 3,
                description = "Android test"
            ),
        )
    }
}


actual fun getAppPersistence(): AppPersistence {
    return AndroidPersistence()
}