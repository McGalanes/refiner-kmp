import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.LocalContentColor
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
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Button(
                            onClick = {
                                viewModel.onClearButtonClicked()
                            }
                        ) { Text("Clear") }

                        Spacer(Modifier.width(16.dp))

                        Button(
                            onClick = {
                                viewModel.onAddButtonClicked()
                            },
                        ) { Text("Add") }
                    }

                    Text(text = "${LocalContentColor.current.value}")

                    Spacer(Modifier.height(24.dp))
                }

                items(userStories) { userStory ->
                    Text(text = userStory.title)
                }
            }
        }
    }
}
