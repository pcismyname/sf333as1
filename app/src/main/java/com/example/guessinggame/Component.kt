package com.example.guessinggame

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BoardBase() {
    Canvas(modifier = Modifier
        .size(width = 400.dp, height = 100.dp)
        .padding(10.dp)
    ) {
            drawLine(
                color = Color.Gray,
                strokeWidth = 5f,
                cap = StrokeCap.Round,
                start = Offset(0f, size.height * 4 / 5),
                end = Offset(size.width, size.height * 4 / 5)
            )
    }
}

@Preview(showBackground = true)
@Composable
fun ComponentPreview(){
    BoardBase()

}