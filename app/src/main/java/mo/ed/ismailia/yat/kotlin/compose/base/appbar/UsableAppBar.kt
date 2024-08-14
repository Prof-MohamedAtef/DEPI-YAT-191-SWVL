package mo.ed.ismailia.yat.kotlin.compose.base.appbar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import mo.ed.ismailia.yat.kotlin.compose.base.AppText
import mo.ed.ismailia.yat.kotlin.compose.base.FontStyle
import mo.ed.ismailia.yat.kotlin.compose.base.appbar.overflowmenu.ActionMenuItem
import mo.ed.ismailia.yat.kotlin.compose.base.appbar.overflowmenu.ActionsMenu
import mo.ed.ismailia.yat.kotlin.compose.base.theme.AppIcons.ArrowBackToolbar
import mo.ed.ismailia.yat.kotlin.compose.base.theme.AppIcons.OldBackArrowIcon
import mo.ed.ismailia.yat.kotlin.compose.base.theme.Icon
import mo.ed.ismailia.yat.kotlin.compose.base.theme.base_solid_color1
import mo.ed.ismailia.yat.kotlin.compose.base.theme.white_color
import mo.ed.ismailia.yat.kotlin.utils.Constants.Companion.SHOW_LIST_ITEMS_RANGE

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppToolBar(
    modifier: Modifier = Modifier,
    title: String,
    titleIcon: Icon? = null,
    titleIconUrl:String = "",
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = base_solid_color1),
    scrollBehavior: TopAppBarScrollBehavior? = null,
    isShowBackArrow: Boolean = true,
    onBackPressed: (() -> Unit?)? = null,
    isShowOldBackArrow: Boolean = false,
    actionsMenuList : List<ActionMenuItem>? = null,
    actions: @Composable RowScope.() -> Unit = {}
) {

    var menuOpen by remember {
        mutableStateOf(false)
    }


    TopAppBar(
        modifier = modifier,
        colors = colors,
        title = { TitleWithIcon(title = title, titleIcon,titleIconUrl) },
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            if (isShowBackArrow) {
                BackButton(onBackPressed, isShowOldBackArrow)
            }
        },
        actions = {
            ActionsMenu(
                items = actionsMenuList,
                isOpen = menuOpen,
                onToggleOverflow = { menuOpen = !menuOpen },
                maxVisibleItems = SHOW_LIST_ITEMS_RANGE
            )
        },
    )
}


@Composable
private fun TitleWithIcon(title: String, titleIcon: Icon?, titleIconUrl: String, modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        titleIcon?.let {
            when (it) {
                is Icon.ImageVectorIcon -> {
                    androidx.compose.material3.Icon(
                        imageVector = it.imageVector,
                        null,
                        modifier = modifier.size(20.dp)
                    )
                }
                is Icon.DrawableResourceIcon -> {
                    androidx.compose.material3.Icon(
                        painter = painterResource(id = it.id),
                        null,
                        modifier = modifier.size(20.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.padding(4.dp))
        }
        if (titleIconUrl.isNotEmpty()){
            AsyncImage(model = titleIconUrl, contentDescription = null, modifier = modifier.size(20.dp))
            Spacer(modifier = Modifier.padding(4.dp))
        }
        Title(title)
    }
}

@Composable
private fun Title(title: String) {
    AppText(
        fontStyle = FontStyle.BaseTextRegularBody1,
        text = title,
        color = white_color
    )
}

@Composable
private fun BackButton(onBackPressed: (() -> Unit?)?, isShowOldBackArrow: Boolean) {
    androidx.compose.material3.IconButton(onClick = { onBackPressed?.invoke() }) {
        if (isShowOldBackArrow.not()) {
            Box {
                androidx.compose.material3.Icon(
                    painter = painterResource(id = ArrowBackToolbar),
                    contentDescription = null,
                    modifier = Modifier.padding(4.dp)
                )
            }
        } else {
            androidx.compose.material3.Icon(
                painter = painterResource(id = OldBackArrowIcon),
                contentDescription = null,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}
