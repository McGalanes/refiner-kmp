import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.mcgalanes.refiner.presentation.feature.userstory.create.component.Input
import com.github.mcgalanes.refiner.presentation.feature.userstory.create.component.step.StepForm
import com.github.mcgalanes.refiner.presentation.feature.userstory.create.model.Tips
import org.jetbrains.compose.resources.stringResource
import refiner.app.generated.resources.Res
import refiner.app.generated.resources.userstory_create_step_solution_input_label
import refiner.app.generated.resources.userstory_create_step_solution_tips_1_description
import refiner.app.generated.resources.userstory_create_step_solution_tips_1_title
import refiner.app.generated.resources.userstory_create_step_solution_tips_2_description
import refiner.app.generated.resources.userstory_create_step_solution_tips_2_title
import refiner.app.generated.resources.userstory_create_step_solution_title


@Composable
internal fun SolutionForm(
    solution: String,
    modifier: Modifier = Modifier,
    onSolutionChange: (String) -> Unit,
) {
    StepForm(
        modifier = modifier,
        title = stringResource(Res.string.userstory_create_step_solution_title),
        tips = listOf(
            Tips(
                title = Res.string.userstory_create_step_solution_tips_1_title,
                description = Res.string.userstory_create_step_solution_tips_1_description
            ),
            Tips(
                title = Res.string.userstory_create_step_solution_tips_2_title,
                description = Res.string.userstory_create_step_solution_tips_2_description
            ),
        ),
    ) {
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Input(
                modifier = Modifier.fillMaxWidth(),
                value = solution,
                onValueChange = onSolutionChange,
                singleLine = false,
                label = stringResource(Res.string.userstory_create_step_solution_input_label),
            )
        }
    }
}
