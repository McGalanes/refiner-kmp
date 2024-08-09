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
import refiner.app.generated.resources.userstory_create_step_need_persona_input_label
import refiner.app.generated.resources.userstory_create_step_need_persona_input_placeholder
import refiner.app.generated.resources.userstory_create_step_need_purpose_input_label
import refiner.app.generated.resources.userstory_create_step_need_purpose_input_placeholder
import refiner.app.generated.resources.userstory_create_step_need_tips_1_description
import refiner.app.generated.resources.userstory_create_step_need_tips_1_title
import refiner.app.generated.resources.userstory_create_step_need_tips_2_description
import refiner.app.generated.resources.userstory_create_step_need_tips_2_title
import refiner.app.generated.resources.userstory_create_step_need_tips_3_description
import refiner.app.generated.resources.userstory_create_step_need_tips_3_title
import refiner.app.generated.resources.userstory_create_step_need_title
import refiner.app.generated.resources.userstory_create_step_need_wish_input_label
import refiner.app.generated.resources.userstory_create_step_need_wish_input_placeholder


@Composable
internal fun NeedForm(
    persona: String,
    wish: String,
    purpose: String,
    modifier: Modifier = Modifier,
    onPersonaChange: (String) -> Unit,
    onWishChange: (String) -> Unit,
    onPurposeChange: (String) -> Unit,
) {
    StepForm(
        modifier = modifier,
        title = stringResource(Res.string.userstory_create_step_need_title),
        tips = listOf(
            Tips(
                title = Res.string.userstory_create_step_need_tips_1_title,
                description = Res.string.userstory_create_step_need_tips_1_description
            ),
            Tips(
                title = Res.string.userstory_create_step_need_tips_2_title,
                description = Res.string.userstory_create_step_need_tips_2_description
            ),
            Tips(
                title = Res.string.userstory_create_step_need_tips_3_title,
                description = Res.string.userstory_create_step_need_tips_3_description
            ),
        ),
    ) {
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Input(
                modifier = Modifier.fillMaxWidth(),
                value = persona,
                onValueChange = onPersonaChange,
                singleLine = false,
                placeholder = stringResource(Res.string.userstory_create_step_need_persona_input_placeholder),
                label = stringResource(Res.string.userstory_create_step_need_persona_input_label),
            )

            Input(
                modifier = Modifier.fillMaxWidth(),
                value = wish,
                onValueChange = onWishChange,
                singleLine = false,
                placeholder = stringResource(Res.string.userstory_create_step_need_wish_input_placeholder),
                label = stringResource(Res.string.userstory_create_step_need_wish_input_label),
            )

            Input(
                modifier = Modifier.fillMaxWidth(),
                value = purpose,
                onValueChange = onPurposeChange,
                singleLine = false,
                placeholder = stringResource(Res.string.userstory_create_step_need_purpose_input_placeholder),
                label = stringResource(Res.string.userstory_create_step_need_purpose_input_label),
            )
        }
    }
}
