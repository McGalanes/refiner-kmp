import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.mcgalanes.refiner.presentation.features.userstory.create.component.Input
import com.github.mcgalanes.refiner.presentation.features.userstory.create.component.TipsDescription
import com.github.mcgalanes.refiner.presentation.features.userstory.create.component.TipsTitle
import com.github.mcgalanes.refiner.presentation.features.userstory.create.component.step.StepForm
import org.jetbrains.compose.resources.stringResource
import refiner.app.generated.resources.Res
import refiner.app.generated.resources.userstory_create_step_need_persona_input_label
import refiner.app.generated.resources.userstory_create_step_need_persona_input_placeholder
import refiner.app.generated.resources.userstory_create_step_need_purpose_input_label
import refiner.app.generated.resources.userstory_create_step_need_purpose_input_placeholder
import refiner.app.generated.resources.userstory_create_step_need_wish_input_label
import refiner.app.generated.resources.userstory_create_step_need_wish_input_placeholder


@Composable
internal fun NeedForm(
    persona: String,
    wish: String,
    purpose: String,
    modifier: Modifier = Modifier,
    tips: Map<TipsTitle, TipsDescription> = emptyMap(),
    onPersonaChange: (String) -> Unit,
    onWishChange: (String) -> Unit,
    onPurposeChange: (String) -> Unit,
) {
    StepForm(
        modifier = modifier,
        tips = tips,
    ) {
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Input(
                modifier = Modifier.fillMaxWidth(),
                value = persona,
                onValueChange = onPersonaChange,
                placeholder = stringResource(Res.string.userstory_create_step_need_persona_input_placeholder),
                label = stringResource(Res.string.userstory_create_step_need_persona_input_label),
            )

            Input(
                modifier = Modifier.fillMaxWidth(),
                value = wish,
                onValueChange = onWishChange,
                placeholder = stringResource(Res.string.userstory_create_step_need_wish_input_placeholder),
                label = stringResource(Res.string.userstory_create_step_need_wish_input_label),
            )

            Input(
                modifier = Modifier.fillMaxWidth(),
                value = purpose,
                onValueChange = onPurposeChange,
                placeholder = stringResource(Res.string.userstory_create_step_need_purpose_input_placeholder),
                label = stringResource(Res.string.userstory_create_step_need_purpose_input_label),
            )
        }
    }
}
