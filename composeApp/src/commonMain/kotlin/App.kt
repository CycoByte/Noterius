import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import database.TestDao
import database.TestRecord
import kotlinx.coroutines.launch
import models.NoteModel
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import noterius.composeapp.generated.resources.Res
import noterius.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {


//        val testData by testDao.getAllTest().collectAsState(initial = emptyList())
        val scope = rememberCoroutineScope()
        val test = remember {
            Persistence.get()
        }

        var testPersistenceData by remember {
            mutableStateOf<List<NoteModel>>(listOf())
        }



        LaunchedEffect(Unit) {
            scope.launch {
                val testList = listOf(
                    TestRecord(name = "FirstTest"),
                    TestRecord(name = "SecondTest"),
                    TestRecord(name = "ThirdTest"),
                    TestRecord(name = "FoudrthTest")
                )
//                testList.forEach {
//                    testDao.upsert(it)
//                }
            }

            scope.launch {
                testPersistenceData = test.getAllNotes()
            }
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp)
        ) {
//            items(testData) {
//                Text(
//                    text = it.name,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .clickable {
//                            scope.launch {
//                                testDao.delete(it)
//                            }
//                        }
//                        .padding(16.dp)
//                )
//            }

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