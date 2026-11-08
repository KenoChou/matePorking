package com.kenochou.mateporking.ui.preview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val PInk = Color(0xFF252238)
private val PMuted = Color(0xFF8B8998)
private val PBg = Color(0xFFF7F6FA)
private val PAccent = Color(0xFF7967D8)
private val PPale = Color(0xFFEDE9FF)
private val PCoral = Color(0xFFFF8C85)

@Composable
fun CommunityFeedScreen() {
    Column(Modifier.fillMaxSize().background(PBg)) {
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(start = 18.dp, top = 18.dp, end = 18.dp, bottom = 18.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            item {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Column(Modifier.weight(1f)) {
                        Text("COMMUNITY", color = PAccent, fontSize = 9.sp, fontWeight = FontWeight.Bold, letterSpacing = 1.5.sp)
                        Text("同好聚集地", color = PInk, fontSize = 25.sp, fontWeight = FontWeight.ExtraBold)
                    }
                    IconButton(onClick = {}) { Icon(Icons.Rounded.Search, "搜索", tint = PInk) }
                    IconButton(onClick = {}) { Icon(Icons.Rounded.Edit, "发布", tint = PAccent) }
                }
            }
            item {
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    listOf("推荐", "关注", "最新", "圈子动态").forEachIndexed { index, label ->
                        Surface(color = if (index == 0) PAccent else Color.White, shape = CircleShape) {
                            Text(label, color = if (index == 0) Color.White else PMuted, fontSize = 11.sp,
                                fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(horizontal = 15.dp, vertical = 9.dp))
                        }
                    }
                }
            }
            item {
                Surface(color = Color.White, shape = RoundedCornerShape(20.dp)) {
                    Column(Modifier.padding(15.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            AvatarMark("绘", PPale)
                            Spacer(Modifier.width(9.dp))
                            Column(Modifier.weight(1f)) {
                                Text("原创插画交流社", color = PInk, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                                Text("圈子精选 · 2 小时前", color = PMuted, fontSize = 10.sp)
                            }
                            Surface(color = PPale, shape = CircleShape) { Text("精华", color = PAccent, fontSize = 9.sp, modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)) }
                        }
                        Text("最近完成了一组关于「夏日与星光」的练习，想听听大家对色彩和构图的建议。", color = PInk, fontSize = 13.sp, lineHeight = 20.sp)
                        ArtTile("✧", 164)
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("♡  128", color = PMuted, fontSize = 10.sp, modifier = Modifier.weight(1f))
                            Text("◯  26 条讨论", color = PMuted, fontSize = 10.sp)
                            Spacer(Modifier.width(12.dp))
                            Icon(Icons.Rounded.Share, null, tint = PMuted, modifier = Modifier.size(15.dp))
                        }
                    }
                }
            }
            items(listOf("今天的手办柜终于整理完成！", "分享一组角色设计灵感", "周末有没有同好一起逛展？")) { title ->
                Surface(color = Color.White, shape = RoundedCornerShape(18.dp)) {
                    Column(Modifier.padding(15.dp), verticalArrangement = Arrangement.spacedBy(9.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            AvatarMark("A", Color(0xFFFFE9E5))
                            Spacer(Modifier.width(9.dp))
                            Column {
                                Text("兴趣同好", color = PInk, fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
                                Text("刚刚 · 兴趣分享", color = PMuted, fontSize = 9.sp)
                            }
                        }
                        Text(title, color = PInk, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            ArtTile("✦", 82, Modifier.weight(1f))
                            ArtTile("❀", 82, Modifier.weight(1f))
                        }
                        Text("♡  36        ◯  8", color = PMuted, fontSize = 10.sp)
                    }
                }
            }
        }
        PrimaryBottomBar("Community")
    }
}

@Composable
fun MarketHomeScreen() {
    Column(Modifier.fillMaxSize().background(PBg)) {
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(start = 18.dp, top = 18.dp, end = 18.dp, bottom = 18.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            item {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Column(Modifier.weight(1f)) {
                        Text("ANIMATE MARKET", color = PAccent, fontSize = 9.sp, fontWeight = FontWeight.Bold, letterSpacing = 1.4.sp)
                        Text("兴趣好物", color = PInk, fontSize = 25.sp, fontWeight = FontWeight.ExtraBold)
                    }
                    IconButton(onClick = {}) { Icon(Icons.Rounded.Search, "搜索", tint = PInk) }
                    IconButton(onClick = {}) { Icon(Icons.Rounded.ShoppingCart, "购物车", tint = PInk) }
                }
            }
            item {
                Surface(shape = RoundedCornerShape(23.dp), color = PAccent, modifier = Modifier.fillMaxWidth()) {
                    Box(Modifier.background(Brush.linearGradient(listOf(Color(0xFF8272E2), Color(0xFFB7A7F2), Color(0xFFFFC7BC)))).padding(20.dp)) {
                        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            Text("MADE BY CREATORS", color = Color.White.copy(alpha = .82f), fontSize = 9.sp, fontWeight = FontWeight.Bold, letterSpacing = 1.5.sp)
                            Text("把热爱，
变成触手可及的收藏。", color = Color.White, fontSize = 22.sp, lineHeight = 29.sp, fontWeight = FontWeight.Bold)
                            Text("原创设计 · 限量周边 · 兴趣好物", color = Color.White.copy(alpha = .9f), fontSize = 10.sp)
                            Surface(color = Color.White, shape = CircleShape) {
                                Text("探索精选  →", color = PAccent, fontSize = 10.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp))
                            }
                        }
                    }
                }
            }
            item {
                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                    listOf("手办模型", "原创插画", "服饰配件", "文创周边").forEachIndexed { i, label ->
                        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            Surface(color = listOf(PPale, Color(0xFFFFE9E5), Color(0xFFE5F1EF), Color(0xFFFFF0D9))[i], shape = RoundedCornerShape(16.dp)) {
                                Box(Modifier.size(55.dp), contentAlignment = Alignment.Center) {
                                    Icon(listOf(Icons.Rounded.Toys, Icons.Rounded.Brush, Icons.Rounded.Checkroom, Icons.Rounded.CardGiftcard)[i], null, tint = PAccent, modifier = Modifier.size(25.dp))
                                }
                            }
                            Text(label, color = PInk, fontSize = 9.sp)
                        }
                    }
                }
            }
            item { SectionHeading("创作者精选", "更多好物") }
            item {
                Row(horizontalArrangement = Arrangement.spacedBy(11.dp)) {
                    ProductTile("星月系列收藏摆件", "¥128", "✧", Modifier.weight(1f))
                    ProductTile("原创插画收藏卡", "¥36", "❀", Modifier.weight(1f))
                }
            }
            item { SectionHeading("本周人气", "查看全部") }
            item {
                Row(horizontalArrangement = Arrangement.spacedBy(11.dp)) {
                    ProductTile("艺术周边礼盒", "¥88", "✦", Modifier.weight(1f))
                    ProductTile("限定主题徽章", "¥25", "♡", Modifier.weight(1f))
                }
            }
        }
        PrimaryBottomBar("Market")
    }
}

@Composable
fun ConversationListScreen() {
    Column(Modifier.fillMaxSize().background(PBg)) {
        Column(Modifier.padding(start = 18.dp, top = 18.dp, end = 18.dp, bottom = 8.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(Modifier.weight(1f)) {
                    Text("MESSAGES", color = PAccent, fontSize = 9.sp, fontWeight = FontWeight.Bold, letterSpacing = 1.5.sp)
                    Text("消息", color = PInk, fontSize = 25.sp, fontWeight = FontWeight.ExtraBold)
                }
                IconButton(onClick = {}) { Icon(Icons.Rounded.EditNote, "新消息", tint = PInk) }
            }
            Spacer(Modifier.height(12.dp))
            Surface(color = Color.White, shape = RoundedCornerShape(14.dp), modifier = Modifier.fillMaxWidth()) {
                Row(Modifier.padding(horizontal = 13.dp, vertical = 12.dp), verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Rounded.Search, null, tint = PMuted, modifier = Modifier.size(18.dp))
                    Spacer(Modifier.width(9.dp))
                    Text("搜索会话", color = PMuted, fontSize = 11.sp)
                }
            }
            Spacer(Modifier.height(14.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                listOf("互动通知", "评论与回复", "圈子消息").forEachIndexed { i, label ->
                    Surface(color = if (i == 0) PPale else Color.White, shape = RoundedCornerShape(13.dp)) {
                        Column(Modifier.padding(horizontal = 13.dp, vertical = 10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(listOf(Icons.Rounded.FavoriteBorder, Icons.Rounded.ChatBubbleOutline, Icons.Rounded.Groups)[i], null, tint = PAccent, modifier = Modifier.size(19.dp))
                            Spacer(Modifier.height(5.dp))
                            Text(label, color = PInk, fontSize = 9.sp)
                        }
                    }
                }
            }
        }
        LazyColumn(Modifier.weight(1f), contentPadding = PaddingValues(horizontal = 18.dp, vertical = 8.dp)) {
            items(listOf(
                Triple("纸上星河", "这组作品的色彩搭配太棒了！", "14:32"),
                Triple("原创插画交流社", "小满：周末准备组织一次线上分享", "13:08"),
                Triple("模型收藏研究所", "发布了新的圈子公告", "昨天"),
                Triple("AniMate 官方", "欢迎来到 AniMate 兴趣社区", "周一")
            )) { item ->
                Row(Modifier.fillMaxWidth().padding(vertical = 12.dp), verticalAlignment = Alignment.CenterVertically) {
                    AvatarMark(item.first.take(1), PPale, 52)
                    Spacer(Modifier.width(12.dp))
                    Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(5.dp)) {
                        Text(item.first, color = PInk, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                        Text(item.second, color = PMuted, fontSize = 10.sp, maxLines = 1)
                    }
                    Column(horizontalAlignment = Alignment.End, verticalArrangement = Arrangement.spacedBy(7.dp)) {
                        Text(item.third, color = PMuted, fontSize = 9.sp)
                        if (item.first == "纸上星河") Surface(color = PCoral, shape = CircleShape) {
                            Text("2", color = Color.White, fontSize = 8.sp, modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp))
                        }
                    }
                }
                HorizontalDivider(color = Color(0xFFEDEBF2), thickness = .7.dp)
            }
        }
        PrimaryBottomBar("Message")
    }
}

@Composable
private fun PrimaryBottomBar(selected: String) {
    Surface(color = Color.White, shadowElevation = 8.dp) {
        Row(Modifier.fillMaxWidth().navigationBarsPadding().padding(horizontal = 8.dp, vertical = 8.dp), horizontalArrangement = Arrangement.SpaceAround) {
            val tabs = listOf(
                Triple("Discover", "发现", Icons.Rounded.Explore),
                Triple("Community", "圈子", Icons.Rounded.Groups),
                Triple("Market", "商城", Icons.Rounded.Storefront),
                Triple("Message", "消息", Icons.Rounded.ChatBubbleOutline),
                Triple("Profile", "我的", Icons.Rounded.PersonOutline)
            )
            tabs.forEach { tab ->
                val active = tab.first == selected
                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(3.dp), modifier = Modifier.width(58.dp)) {
                    Icon(tab.third, contentDescription = tab.second, tint = if (active) PAccent else PMuted, modifier = Modifier.size(21.dp))
                    Text(tab.second, color = if (active) PAccent else PMuted, fontSize = 9.sp, fontWeight = if (active) FontWeight.Bold else FontWeight.Normal)
                }
            }
        }
    }
}

@Composable
private fun AvatarMark(label: String, tint: Color, size: Int = 38) {
    Box(Modifier.size(size.dp).clip(CircleShape).background(tint), contentAlignment = Alignment.Center) {
        Text(label, color = PAccent, fontSize = 13.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun ArtTile(symbol: String, height: Int, modifier: Modifier = Modifier) {
    Box(modifier.fillMaxWidth().height(height.dp).clip(RoundedCornerShape(15.dp)).background(
        Brush.linearGradient(listOf(Color(0xFFE8E1FF), Color(0xFFFFE5E1), Color(0xFFE8F0F0)))
    ), contentAlignment = Alignment.Center) {
        Text(symbol, color = Color(0xFF9A88D8), fontSize = 35.sp)
    }
}

@Composable
private fun ProductTile(title: String, price: String, symbol: String, modifier: Modifier = Modifier) {
    Surface(color = Color.White, shape = RoundedCornerShape(17.dp), modifier = modifier) {
        Column(Modifier.padding(10.dp), verticalArrangement = Arrangement.spacedBy(7.dp)) {
            ArtTile(symbol, 112)
            Text(title, color = PInk, fontSize = 11.sp, fontWeight = FontWeight.SemiBold, maxLines = 1)
            Text(price, color = PCoral, fontSize = 14.sp, fontWeight = FontWeight.ExtraBold)
        }
    }
}

@Composable
private fun SectionHeading(title: String, more: String) {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(title, color = PInk, fontSize = 16.sp, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
        Text(more, color = PAccent, fontSize = 10.sp)
    }
}
