import database.entities.NoteEntity
import models.NoteModel


object NoteMapper {

    fun fromEntity(entity: NoteEntity): NoteModel {
        return NoteModel(
            id = entity.id,
            name = entity.name,
            description = entity.description,
            content = entity.content
        )
    }

    fun toEntity(model: NoteModel): NoteEntity {
        return NoteEntity(
            id = model.id,
            name = model.name,
            description = model.description,
            content = model.content
        )
    }

}