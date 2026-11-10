package com.kenochou.mateporking.ui.preview

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

private val ExperiencePreviewColors = lightColorScheme(
    primary = Color(0xFFE58EA5),
    secondary = Color(0xFFB9D9CF),
    background = Color(0xFFFFF9F4),
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color(0xFF384052),
    onBackground = Color(0xFF384052),
    onSurface = Color(0xFF384052)
)

@Composable
private fun ExperiencePreview(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = ExperiencePreviewColors, content = content)
}

@Preview(name = "圈子首页 · Community", showBackground = true, showSystemUi = true, widthDp = 393, heightDp = 852)
@Composable
fun PrimaryCommunityFeedPreview() {
    ExperiencePreview { CommunityFeedScreen() }
}

@Preview(name = "商城首页 · Market", showBackground = true, showSystemUi = true, widthDp = 393, heightDp = 852)
@Composable
fun PrimaryMarketHomePreview() {
    ExperiencePreview { MarketHomeScreen() }
}

@Preview(name = "消息首页 · Messages", showBackground = true, showSystemUi = true, widthDp = 393, heightDp = 852)
@Composable
fun PrimaryConversationListPreview() {
    ExperiencePreview { ConversationListScreen() }
}
