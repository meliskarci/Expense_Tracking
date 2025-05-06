package com.meliskarci.expensetracking.presentation.tracking


import androidx.compose.animation.core.EaseInOutCubic
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ir.ehsannarmani.compose_charts.LineChart
import ir.ehsannarmani.compose_charts.PieChart
import ir.ehsannarmani.compose_charts.models.AnimationMode
import ir.ehsannarmani.compose_charts.models.DrawStyle
import ir.ehsannarmani.compose_charts.models.Line
import ir.ehsannarmani.compose_charts.models.Pie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun TrackingScreen(
) {

    Box (Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        LineChart(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(0.5f).padding(horizontal = 22.dp),
            data = remember {
                listOf(
                    Line(
                        label = "Windows",
                        values = listOf(28.0, 41.0, 5.0, 10.0, 35.0, 45.0),
                        color = SolidColor(Color(0xFF23af92)),
                        firstGradientFillColor = Color(0xFF2BC0A1).copy(alpha = .5f),
                        secondGradientFillColor = Color.Transparent,
                        strokeAnimationSpec = tween(2000, easing = EaseInOutCubic),
                        gradientAnimationDelay = 1000,
                        drawStyle = DrawStyle.Stroke(width = 2.dp),
                    ),
                    Line(
                        label = "SGSSDSDG",
                        values = listOf(28.0, 41.0, 5.0, 10.0, 35.0, 45.0).reversed(),
                        color = SolidColor(Color(0xFFAF23A8)),
                        firstGradientFillColor = Color(0xFF8C2BC0).copy(alpha = .5f),
                        secondGradientFillColor = Color.Transparent,
                        strokeAnimationSpec = tween(2000, easing = EaseInOutCubic),
                        gradientAnimationDelay = 1000,
                        drawStyle = DrawStyle.Stroke(width = 2.dp),
                    )
                )
            },
            animationMode = AnimationMode.Together(delayBuilder = {
                it * 500L
            }),
        )
    }


}

@Preview
@Composable
fun TrackingScreenPreview() {
    TrackingScreen()
}