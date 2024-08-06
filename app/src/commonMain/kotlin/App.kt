import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.github.mcgalanes.refiner.core.design.token.RefinerTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App(
    viewModel: AppViewModel = koinViewModel(),
) {
    RefinerTheme(darkTheme = false) {
        val userStories by viewModel.userStories.collectAsStateWithLifecycle()

        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Surface(
                        modifier = Modifier.padding(16.dp),
                        shadowElevation = 4.dp,
                        shape = MaterialTheme.shapes.medium,
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.Center,
                            ) {
                                Button(
                                    onClick = viewModel::onClearButtonClicked
                                ) { Text("Clear") }

                                Spacer(Modifier.width(16.dp))

                                Button(
                                    onClick = viewModel::onAddButtonClicked,
                                ) { Text("Add") }
                            }

                            Spacer(Modifier.width(16.dp))

                            Text(text = "${getPlatform()}")
                        }
                    }

                    Spacer(Modifier.height(24.dp))
                }

                itemsIndexed(userStories) { index, userStory ->
                    Surface(
                        shadowElevation = 4.dp,
                        shape = MaterialTheme.shapes.large,
                    ) {
                        Box(
                            modifier = Modifier.size(200.dp, 48.dp)
                        ) {
                            Text(
                                modifier = Modifier.align(Alignment.Center),
                                text = userStory.title
                            )
                        }
                    }

                    Spacer(Modifier.height(8.dp))
                }
            }
        }
    }
}
