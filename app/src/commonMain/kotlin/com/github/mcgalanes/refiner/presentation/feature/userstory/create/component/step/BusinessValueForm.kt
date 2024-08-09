import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.github.mcgalanes.refiner.presentation.feature.userstory.create.component.Input
import com.github.mcgalanes.refiner.presentation.feature.userstory.create.component.step.StepForm
import com.github.mcgalanes.refiner.presentation.feature.userstory.create.model.Tips
import org.jetbrains.compose.resources.stringResource
import refiner.app.generated.resources.Res
import refiner.app.generated.resources.userstory_create_step_business_value_input_label
import refiner.app.generated.resources.userstory_create_step_business_value_tips_1_description
import refiner.app.generated.resources.userstory_create_step_business_value_tips_1_title
import refiner.app.generated.resources.userstory_create_step_business_value_title


@Composable
internal fun BusinessValueForm(
    businessValue: Int?,
    modifier: Modifier = Modifier,
    onBusinessValueChange: (String) -> Unit,
) {
    StepForm(
        modifier = modifier,
        title = stringResource(Res.string.userstory_create_step_business_value_title),
        tips = listOf(
            Tips(
                title = Res.string.userstory_create_step_business_value_tips_1_title,
                description = Res.string.userstory_create_step_business_value_tips_1_description
            ),
        ),
    ) {
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Input(
                modifier = Modifier.fillMaxWidth(),
                value = businessValue?.toString() ?: "",
                onValueChange = onBusinessValueChange,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                label = stringResource(Res.string.userstory_create_step_business_value_input_label),
            )
        }
    }
}
