import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import models.NoteModel
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App(persistence: AppPersistence) {

    MaterialTheme {

        val scope = rememberCoroutineScope()

        var testPersistenceData by remember {
            mutableStateOf<List<NoteModel>>(listOf())
        }

        LaunchedEffect(Unit) {
            val testList = listOf(
                NoteModel(id = 0, content = "Test1 Content", name = "Test1 Name", description = "description1"),
                NoteModel(id = 0, content = "Test2 Content", name = "Test2 Name", description = "description2"),
                NoteModel(id = 0, content = "Test3 Content", name = "Test3 Name", description = "description3")
            )
            scope.launch(Dispatchers.IO) {
                testList.forEach {
                    persistence.addNewNote(note = it)
                }

                testPersistenceData = persistence.getAllNotes()
            }
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(testPersistenceData) {
                Text(
                    text = it.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    color = Color.Green
                )
            }
        }
    }
}