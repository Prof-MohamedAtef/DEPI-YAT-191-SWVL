package mo.ed.ismailia.yat.kotlin.compose.base.appbar.overflowmenu

// 1
data class MenuItems(
    val alwaysShownItems: List<ActionMenuItem.IconMenuItem>,
    val overflowItems: List<ActionMenuItem>,
)

// 2
fun splitMenuItems(
    items: List<ActionMenuItem>?,
    maxVisibleItems: Int,
): MenuItems? {
    // 3
    items?.let {
        val alwaysShownItems: MutableList<ActionMenuItem.IconMenuItem> =
            items.filterIsInstance<ActionMenuItem.IconMenuItem.AlwaysShown>().toMutableList()
        val ifRoomItems: MutableList<ActionMenuItem.IconMenuItem> =
            items.filterIsInstance<ActionMenuItem.IconMenuItem.ShownIfRoom>().toMutableList()
        val overflowItems = items.filterIsInstance<ActionMenuItem.NeverShown>()

        // 4
        val hasOverflow = overflowItems.isNotEmpty() ||
                (alwaysShownItems.size + ifRoomItems.size - 1) > maxVisibleItems
        // 5
        val usedSlots = maxVisibleItems + (if (hasOverflow) 1 else 0)
        // 6
        val availableSlots = maxVisibleItems - usedSlots
        // 7
        if (availableSlots > 0 && ifRoomItems.isNotEmpty()) {
            // 8
            val visible = ifRoomItems.subList(0, availableSlots.coerceAtMost(ifRoomItems.size))
            alwaysShownItems.addAll(visible)
            ifRoomItems.removeAll(visible)
        }

        // 9
        return MenuItems(
            alwaysShownItems = alwaysShownItems,
            overflowItems = ifRoomItems + overflowItems,
        )
    }?: run{ return null}
}