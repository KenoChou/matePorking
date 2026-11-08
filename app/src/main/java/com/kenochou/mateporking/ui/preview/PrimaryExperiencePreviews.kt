package com.kenochou.mateporking.ui.preview

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview(name = "圈子首页 · Community", showBackground = true, showSystemUi = true)
@Composable
fun PrimaryCommunityFeedPreview() {
    CommunityFeedScreen()
}

@Preview(name = "商城首页 · Market", showBackground = true, showSystemUi = true)
@Composable
fun PrimaryMarketHomePreview() {
    MarketHomeScreen()
}

@Preview(name = "消息首页 · Messages", showBackground = true, showSystemUi = true)
@Composable
fun PrimaryConversationListPreview() {
    ConversationListScreen()
}
