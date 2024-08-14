package mo.ed.ismailia.yat.kotlin.compose.base.appbar.overflowmenu

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import mo.ed.ismailia.yat.kotlin.compose.base.AppText
import mo.ed.ismailia.yat.kotlin.compose.base.FontStyle
import mo.ed.ismailia.yat.kotlin.compose.base.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopAppBar(
    modifier: Modifier = Modifier,
) {
    // 1
    var menuExpanded by remember {
        mutableStateOf(false)
    }
    TopAppBar(
        title = {
            Text(
                text = "My App"
            )
        },
        actions = {
            // 2
            ActionsMenu(
                // 3
                items = listOf(
                    ActionMenuItem.IconMenuItem.AlwaysShown(
                        title = "Search",
                        contentDescription = "Search",
                        onClick = {},
                        icon = Icons.Filled.Search,
                    ),
                    ActionMenuItem.IconMenuItem.AlwaysShown(
                        title = "Favorite",
                        contentDescription = "Favorite",
                        onClick = {},
                        icon = Icons.Filled.FavoriteBorder,
                    ),
                    ActionMenuItem.IconMenuItem.ShownIfRoom(
                        title = "Refresh",
                        contentDescription = "Refresh",
                        onClick = {},
                        icon = Icons.Filled.Refresh
                    ),
                    ActionMenuItem.NeverShown(
                        title = "Settings",
                        onClick = {},
                        null
                    ),
                    ActionMenuItem.NeverShown(
                        title = "About",
                        onClick = {},
                        null
                    ),
                ),
                // 4
                isOpen = menuExpanded,
                // 5
                onToggleOverflow = { menuExpanded = !menuExpanded },
                maxVisibleItems = 3,
            )
        },
        modifier = modifier
    )
}

@Composable
fun ActionsMenu(
    items: List<ActionMenuItem>?,
    isOpen: Boolean,
    onToggleOverflow: () -> Unit,
    maxVisibleItems: Int,
) {
    // 2
    val menuItems = remember(
        key1 = items,
        key2 = maxVisibleItems,
    ) {
        splitMenuItems(items, maxVisibleItems)
    }

    // 3
    menuItems?.let {
        it.alwaysShownItems.forEach { item ->
            IconButton(onClick = item.onClick) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = item.contentDescription,
                )
            }
        }
    }

    // 4
    menuItems?.let {
        if (it.overflowItems.isNotEmpty()) {
            // 5
            IconButton(onClick = onToggleOverflow) {
                Icon(
                    imageVector = it.overflowItems.get(0).icon ?: Icons.Filled.MoreVert,
                    contentDescription = null,
                )
            }
            // 6
            DropdownMenu(
                expanded = isOpen,
                onDismissRequest = onToggleOverflow,
            ) {
                // 7
                it.overflowItems.forEach { item ->
                    DropdownMenuItem(
                        text = {
                            AppText(
                                fontStyle =  FontStyle.BaseTextRegularBody3,
                                item.title,
                                color = Color.White,
                            )
                        },
                        onClick = item.onClick
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(widthDp = 440, showBackground = true)
@Preview(widthDp = 440, uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
private fun ActionMenuPreview(
    @PreviewParameter(ActionMenuParameterProvider::class) items: List<ActionMenuItem>
) {
    AppTheme {
        var menuOpen by remember {
            mutableStateOf(false)
        }
        val numAlwaysShown = items.count { item -> item is ActionMenuItem.IconMenuItem.AlwaysShown }
        val numIfRoom = items.count { item -> item is ActionMenuItem.IconMenuItem.ShownIfRoom }
        val numOverflow = items.count { item -> item is ActionMenuItem.NeverShown }
        val label = "Always: $numAlwaysShown Room: $numIfRoom Over: $numOverflow"
        TopAppBar(
            title = { Text(label) },
            modifier = Modifier.fillMaxWidth(),
            actions = {
                ActionsMenu(
                    items = items,
                    isOpen = menuOpen,
                    onToggleOverflow = { menuOpen = !menuOpen },
                    maxVisibleItems = 3
                )
            }
        )
    }
}

private class ActionMenuParameterProvider : PreviewParameterProvider<List<ActionMenuItem>> {
    override val values: Sequence<List<ActionMenuItem>>
        get() = getListOfMenuItems()
}


fun getListOfMenuItems(): Sequence<List<ActionMenuItem>> {
    return sequenceOf(
        listOf(
            ActionMenuItem.IconMenuItem.AlwaysShown(
                title = "Search",
                onClick = {},
                icon = Icons.Filled.Search,
                contentDescription = null,
            ),
            ActionMenuItem.IconMenuItem.AlwaysShown(
                title = "Favorite",
                onClick = {},
                icon = Icons.Filled.FavoriteBorder,
                contentDescription = null,
            ),
            ActionMenuItem.IconMenuItem.AlwaysShown(
                title = "Star",
                onClick = {},
                icon = Icons.Filled.Star,
                contentDescription = null,
            ),
            ActionMenuItem.IconMenuItem.ShownIfRoom(
                title = "Refresh",
                onClick = {},
                icon = Icons.Filled.Refresh,
                contentDescription = null,
            ),
            ActionMenuItem.NeverShown(
                title = "Settings",
                onClick = {},
                null
            ),
            ActionMenuItem.NeverShown(
                title = "About",
                onClick = {},
                null
            ),
        ),
        listOf(
            ActionMenuItem.IconMenuItem.AlwaysShown(
                title = "Search",
                onClick = {},
                icon = Icons.Filled.Search,
                contentDescription = null,
            ),
            ActionMenuItem.IconMenuItem.AlwaysShown(
                title = "Favorite",
                onClick = {},
                icon = Icons.Filled.FavoriteBorder,
                contentDescription = null,
            ),
            ActionMenuItem.IconMenuItem.ShownIfRoom(
                title = "Star",
                onClick = {},
                icon = Icons.Filled.Star,
                contentDescription = null,
            ),
            ActionMenuItem.IconMenuItem.ShownIfRoom(
                title = "Refresh",
                onClick = {},
                icon = Icons.Filled.Refresh,
                contentDescription = null,
            ),
            ActionMenuItem.NeverShown(
                title = "Settings",
                onClick = {},
                null
            ),
            ActionMenuItem.NeverShown(
                title = "About",
                onClick = {},
                null
            ),
        ),
        listOf(
            ActionMenuItem.IconMenuItem.AlwaysShown(
                title = "Search",
                onClick = {},
                icon = Icons.Filled.Search,
                contentDescription = null,
            ),
            ActionMenuItem.IconMenuItem.ShownIfRoom(
                title = "Favorite",
                onClick = {},
                icon = Icons.Filled.FavoriteBorder,
                contentDescription = null,
            ),
            ActionMenuItem.IconMenuItem.ShownIfRoom(
                title = "Star",
                onClick = {},
                icon = Icons.Filled.Star,
                contentDescription = null,
            ),
            ActionMenuItem.IconMenuItem.ShownIfRoom(
                title = "Refresh",
                onClick = {},
                icon = Icons.Filled.Refresh,
                contentDescription = null,
            ),
            ActionMenuItem.NeverShown(
                title = "Settings",
                onClick = {},
                null
            ),
            ActionMenuItem.NeverShown(
                title = "About",
                onClick = {},
                null
            ),
        ),
        listOf(
            ActionMenuItem.IconMenuItem.ShownIfRoom(
                title = "Search",
                onClick = {},
                icon = Icons.Filled.Search,
                contentDescription = null,
            ),
            ActionMenuItem.IconMenuItem.ShownIfRoom(
                title = "Favorite",
                onClick = {},
                icon = Icons.Filled.FavoriteBorder,
                contentDescription = null,
            ),
            ActionMenuItem.IconMenuItem.ShownIfRoom(
                title = "Star",
                onClick = {},
                icon = Icons.Filled.Star,
                contentDescription = null,
            ),
            ActionMenuItem.IconMenuItem.ShownIfRoom(
                title = "Refresh",
                onClick = {},
                icon = Icons.Filled.Refresh,
                contentDescription = null,
            ),
            ActionMenuItem.NeverShown(
                title = "Settings",
                onClick = {},
                null
            ),
            ActionMenuItem.NeverShown(
                title = "About",
                onClick = {},
                null
            ),
        ),
        listOf(
            ActionMenuItem.IconMenuItem.ShownIfRoom(
                title = "Search",
                onClick = {},
                icon = Icons.Filled.Search,
                contentDescription = null,
            ),
            ActionMenuItem.IconMenuItem.ShownIfRoom(
                title = "Favorite",
                onClick = {},
                icon = Icons.Filled.FavoriteBorder,
                contentDescription = null,
            ),
        ),
        listOf(
            ActionMenuItem.NeverShown(
                title = "Search",
                onClick = {},
                null
            ),
            ActionMenuItem.NeverShown(
                title = "Favorite",
                onClick = {},
                null
            ),
        ),
    )
}