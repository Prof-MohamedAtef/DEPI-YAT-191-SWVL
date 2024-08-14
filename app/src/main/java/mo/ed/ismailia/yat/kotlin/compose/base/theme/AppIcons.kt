package mo.ed.nozha.apps.compose.base.theme

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.rounded.Add
import androidx.compose.ui.graphics.vector.ImageVector
import mo.ed.nozha.apps.R

object AppIcons {
    val AccountCircle = Icons.Outlined.AccountCircle
    val Add = Icons.Rounded.Add
    val ArrowBackToolbar = R.drawable.ic_arrow_start
    val ArrowForwardToolbar = R.drawable.ic_arrow_right
    val OldBackArrowIcon = R.drawable.ic_old_back_icon
    val PDFViewerIcon = R.drawable.ic_pdf_launcher_bill_info
}

/**
 * A sealed class to make dealing with [ImageVector] and [DrawableRes] icons easier.
 */
sealed class Icon {
    data class ImageVectorIcon(val imageVector: ImageVector) : Icon()
    data class DrawableResourceIcon(@DrawableRes val id: Int) : Icon()
}