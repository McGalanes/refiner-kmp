import androidx.compose.ui.window.ComposeUIViewController
import com.github.mcgalanes.refiner.core.injection.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    App()
}