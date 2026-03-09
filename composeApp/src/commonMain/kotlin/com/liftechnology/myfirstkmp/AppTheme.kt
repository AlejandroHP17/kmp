package com.liftechnology.myfirstkmp

import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AppTheme(
    content : @Composable () -> Unit
){
    MaterialTheme(
        colorScheme = MaterialTheme.colorScheme.copy(primary = Color.Black),
        shapes = MaterialTheme.shapes.copy(
            small = AbsoluteCutCornerShape(0.dp),
            medium = AbsoluteCutCornerShape(0.dp),
            large = AbsoluteCutCornerShape(0.dp)
        ),
        content = {
            content()
        }
    )
}

@Composable
fun getColorsTheme(): DarkModeColor{
    val isDarkMode = false

    val Purple = Color (0xFF5A66FF)
    val ColorExpenseItem = if(isDarkMode) Color (0xFFF1F1F1) else Color(0xFF090808)
    val BackgroundCOlor = if(isDarkMode) Color (0xFF1E1C1C) else Color.White
    val TextColor = if(isDarkMode)  Color.White else Color.Black
    val AddIconColor = if(isDarkMode) Purple else Color.Black
    val ColorArrowRound = if(isDarkMode) Purple else Color.Gray.copy(alpha = .2f)

    return DarkModeColor(
        purple = Purple,
        colorExpenseItem = ColorExpenseItem,
        backgroundColor = BackgroundCOlor,
        textColor = TextColor,
        addIconColor = AddIconColor,
        colorArrowRound = ColorArrowRound
    )
}

data class DarkModeColor(
    val purple : Color,
    val colorExpenseItem: Color,
    val backgroundColor: Color,
    val textColor: Color,
    val addIconColor: Color,
    val colorArrowRound: Color
)