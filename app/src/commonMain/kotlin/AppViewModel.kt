import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.mcgalanes.refiner.data.local.UserStoryDao
import com.github.mcgalanes.refiner.data.local.model.UserStory
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class AppViewModel(
    private val dao: UserStoryDao,
) : ViewModel() {

    val userStories =
        dao.getUserStoriesWithCriterias()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = emptyList(),
            )

    fun onAddButtonClicked() {
        viewModelScope.launch {
            dao.createUserStory(
                UserStory(
                    id = userStories.value.size + 1L,
                    title = "US n° ${userStories.value.size + 1}",
                    persona = "Persona 1",
                    wish = "Wish 1",
                    purpose = "Purpose 1",
                    kpi = "KPI 1",
                    businessValue = 1,
                    solution = "Solution 1",
                    enablers = "Enablers 1",
                    assets = "Assets 1",
                    estimable = true,
                    estimation = 1,
                    independent = true,
                    smallEnough = true,
                    testable = true,
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