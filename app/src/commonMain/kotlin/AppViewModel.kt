import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.mcgalanes.refiner.data.local.UserStoryDao
import com.github.mcgalanes.refiner.database.UserStory
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class AppViewModel(
    private val dao: UserStoryDao,
) : ViewModel() {

    val userStories =
        dao.getAllUserStories()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = emptyList(),
            )

    fun onAddButtonClicked() {
        viewModelScope.launch {
            val id = userStories.value.size + 1L
            dao.createUserStory(
                UserStory(
                    id = id,
                    title = "US n° $id",
                    persona = "Persona",
                    wish = "Wish",
                    purpose = "Purpose",
                    kpi = "KPI",
                    businessValue = 10,
                    solution = "Solution",
                    enablers = "Enablers",
                    assets = "Assets",
                    estimation = 5,
                    smallEnough = 1,
                    independent = 1,
                    estimable = 1,
                    testable = 1,
                )
            )
        }
    }

    fun onClearButtonClicked() {
        viewModelScope.launch {
            dao.deleteAllUserStories()
        }
    }
}