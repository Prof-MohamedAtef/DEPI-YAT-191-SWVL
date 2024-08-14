package mo.ed.ismailia.yat.kotlin.compose.base.theme

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mo.ed.ismailia.yat.kotlin.R
import mo.ed.ismailia.yat.kotlin.compose.base.AppText
import mo.ed.ismailia.yat.kotlin.compose.base.FontStyle
import mo.ed.ismailia.yat.kotlin.compose.base.getTextStyle
import mo.ed.nozha.apps.compose.base.AppTextField
import mo.ed.nozha.apps.compose.base.TextFieldStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseSearchView(
    hint: String,
    modifier: Modifier,
    onSearch: (String) -> Unit
) {

    Box(
        modifier = modifier
            .padding(start = 16.dp, end = 16.dp)
            .wrapContentHeight()
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(
                    topStart = 4.dp, topEnd = 4.dp, bottomStart = 4.dp, bottomEnd = 4.dp
                )
            )
            .background(color = base_solid_color_3),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_search_white),
                null,
                tint = Color.Unspecified,
                modifier = Modifier
                    .padding(top = 11.dp, bottom = 11.dp, start = 16.dp)
            )
            CustomSearchBar(hint = hint, onSearch = {
                onSearch.invoke(it)
            })
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(hint: String, modifier: Modifier) {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(

        value = text,
        onValueChange = { text = it },
        modifier = modifier,
        placeholder = {
            AppText(fontStyle = FontStyle.BaseTextRegularBody3, text = hint)
        },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = { /* Handle search */ }
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(  // Customize the TextField colors
            focusedTextColor = white_color,
            unfocusedTextColor = white_color,
            cursorColor = MaterialTheme.colorScheme.onSurface,
            focusedBorderColor = Color.Transparent,  // Set the focused border color to transparent
            unfocusedBorderColor = Color.Transparent,  // Set the unfocused border color to transparent
            disabledBorderColor = Color.Transparent  // Set the disabled border color to transparent
        )
    )
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun SearchBarPreview() {
    SearchBar(
        hint = "Search me",
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .border(0.dp, color = base_solid_color_3)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSearchBar(hint: String = "test", onSearch: (String) -> Unit) {
    var text by remember { mutableStateOf("") }
    val interactionSource = remember { MutableInteractionSource() }
    AppTextField(
        textFieldStyle = TextFieldStyle.TextTextField,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 0.dp),
        value = text,
        textStyle = getTextStyle(FontStyle.BaseTextRegularBody3, TextAlign.Start),
        onValueChange = { newText ->
            text = newText
            onSearch.invoke(newText)
        },
        placeholder = {
            if (text.isEmpty()) {
                AppText(
                    fontStyle = FontStyle.BaseTextRegularBody3,
                    text = hint,
                    color = Color.White,
                    modifier = Modifier
                        .padding(start=0.dp)
                        .wrapContentWidth()
                )
            }
        }
    )
}

@Preview
@Composable
fun CustomPreview() {
    CustomSearchBar(
        hint = "Search for service number",
        onSearch = {}
    )
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun CarsScreenLayoutDark() {
    BaseSearchView(
        "Search for service number",
        modifier = Modifier,
        onSearch = {}
    )
}

interface OnSearchCompletedListener {
    fun <T> onSearchCompleted(query: List<T>)
}