package com.liftechnology.myfirstkmp

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import moe.tlaster.precompose.PreComposeApp

@Composable
@Preview
fun App() {
    PreComposeApp {
        val colors = getColorsTheme()
        AppTheme {
            Column {
                Text(
                    text = "Este es texto plano",
                    color = colors.textColor
                )
                Text(
                    text = "Este es texto plano",
                    color = colors.textColor
                )
            }
        }
    }
}