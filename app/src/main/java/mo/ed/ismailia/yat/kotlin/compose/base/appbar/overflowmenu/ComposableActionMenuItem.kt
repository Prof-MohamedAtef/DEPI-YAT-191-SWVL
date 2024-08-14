package mo.ed.ismailia.yat.kotlin.compose.base.appbar.overflowmenu

import androidx.compose.ui.graphics.vector.ImageVector

sealed interface ActionMenuItem {
    val title: String
    val onClick: () -> Unit
    val icon: ImageVector?

    // 1
    sealed interface IconMenuItem : ActionMenuItem {
        override val icon: ImageVector
        val contentDescription: String?

        // 2
        data class AlwaysShown(
            override val title: String,
            override val contentDescription: String?,
            override val onClick: () -> Unit,
            override val icon: ImageVector,
        ) : IconMenuItem

        data class ShownIfRoom(
            override val title: String,
            override val contentDescription: String?,
            override val onClick: () -> Unit,
            override val icon: ImageVector,
        ) : IconMenuItem
    }

    data class NeverShown(
        override val title: String,
        override val onClick: () -> Unit,
        override val icon: ImageVector?
    ) : ActionMenuItem
}