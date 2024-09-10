import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.layout.onGloballyPositioned


@Composable
fun AutoResizingText(
    text: String,
    modifier: Modifier = Modifier,
    maxFontSize: TextUnit = 80.sp,
    minFontSize: TextUnit = 30.sp // Minimum font size for very long text
) {
    // Adjust font size based on the text length
    val textSize = when {
        text.length > 12 -> minFontSize
        text.length > 8 -> (maxFontSize.value * 0.75).sp
        else -> maxFontSize
    }

    Text(
        text = text,
        fontSize = textSize,
        textAlign = TextAlign.End,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 32.dp),
        color = Color.White,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}


@Composable
fun ScrollableText(
    text: String,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 80.sp
) {
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .horizontalScroll(scrollState)
            .fillMaxWidth()
    ) {
        Text(
            text = text,
            fontSize = fontSize,
            textAlign = TextAlign.End,
            modifier = modifier
                .padding(vertical = 32.dp),
            color = Color.White,
            maxLines = 1,
            overflow = TextOverflow.Clip
        )
    }
}

