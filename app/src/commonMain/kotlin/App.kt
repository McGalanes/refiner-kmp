import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.github.mcgalanes.refiner.core.design.theme.RefinerTheme
import com.github.mcgalanes.refiner.presentation.feature.userstory.create.CreateUserStoryScreen
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {
    RefinerTheme(darkTheme = false) {
        CreateUserStoryScreen(
            modifier = Modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.safeDrawing),
            viewModel = koinViewModel()
        )
    }
}
