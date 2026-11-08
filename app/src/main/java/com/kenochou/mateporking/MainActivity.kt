package com.kenochou.mateporking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Ink = Color(0xFF242332)
private val Muted = Color(0xFF888696)
private val Canvas = Color(0xFFF8F7FB)
private val Violet = Color(0xFF7866D8)
private val SoftViolet = Color(0xFFEDE9FF)
private val Coral = Color(0xFFFF8A83)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { AniMateApp() }
    }
}

private enum class Destination(val label: String) {
    Discover("发现"), Community("圈子"), Market("商城"), Messages("消息"), Profile("我的")
}

@Composable
private fun AniMateApp() {
    var selected by remember { mutableStateOf(Destination.Discover) }
    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = Violet,
            secondary = Coral,
            background = Canvas,
            surface = Color.White,
            onSurface = Ink
        )
    ) {
        Scaffold(
            containerColor = Canvas,
            bottomBar = {
                NavigationBar(containerColor = Color.White, tonalElevation = 4.dp) {
                    Destination.entries.forEach { destination ->
                        val icon = when (destination) {
                            Destination.Discover -> Icons.Rounded.Explore
                            Destination.Community -> Icons.Rounded.Groups
                            Destination.Market -> Icons.Rounded.ShoppingBag
                            Destination.Messages -> Icons.Rounded.ChatBubbleOutline
                            Destination.Profile -> Icons.Rounded.PersonOutline
                        }
                        NavigationBarItem(
                            selected = selected == destination,
                            onClick = { selected = destination },
                            icon = { Icon(icon, contentDescription = destination.label) },
                            label = { Text(destination.label, fontSize = 10.sp) },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = Violet,
                                selectedTextColor = Violet,
                                indicatorColor = SoftViolet,
                                unselectedIconColor = Muted
                            )
                        )
                    }
                }
            }
        ) { padding ->
            Box(Modifier.fillMaxSize().padding(padding)) {
                when (selected) {
                    Destination.Discover -> DiscoverScreen()
                    Destination.Community -> PlaceholderScreen("兴趣圈子", "找到同好，一起讨论喜欢的作品。", Icons.Rounded.Groups)
                    Destination.Market -> PlaceholderScreen("兴趣好物", "发现创作者周边、同人作品与精选商品。", Icons.Rounded.ShoppingBag)
                    Destination.Messages -> PlaceholderScreen("消息", "私聊、群聊与互动通知将在这里汇集。", Icons.Rounded.ChatBubbleOutline)
                    Destination.Profile -> ProfileScreen()
                }
            }
        }
    }
}

@Composable
private fun DiscoverScreen() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(start = 20.dp, end = 20.dp, top = 18.dp, bottom = 24.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        item {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(Modifier.weight(1f)) {
                    Text("AniMate", fontSize = 27.sp, fontWeight = FontWeight.ExtraBold, color = Ink)
                    Text("让热爱连接彼此", fontSize = 12.sp, color = Muted)
                }
                IconButton(onClick = {}) { Icon(Icons.Rounded.Search, "搜索", tint = Ink) }
                IconButton(onClick = {}) { Icon(Icons.Rounded.NotificationsNone, "通知", tint = Ink) }
            }
        }
        item {
            Surface(
                shape = RoundedCornerShape(24.dp),
                color = Color(0xFFEAE5FF),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text("YOUR INTEREST, YOUR WORLD", color = Violet, fontSize = 10.sp, fontWeight = FontWeight.Bold, letterSpacing = 1.2.sp)
                    Text("每一种热爱\n都值得被看见。", color = Ink, fontSize = 25.sp, lineHeight = 32.sp, fontWeight = FontWeight.Bold)
                    Text("探索作品、认识同好，发现属于你的兴趣宇宙。", color = Color(0xFF68627E), fontSize = 12.sp)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(color = Violet, shape = RoundedCornerShape(50)) {
                            Text("开始探索", color = Color.White, modifier = Modifier.padding(horizontal = 16.dp, vertical = 9.dp), fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                        }
                        Spacer(Modifier.width(10.dp))
                        Text("发现你的兴趣圈", color = Muted, fontSize = 11.sp)
                    }
                }
            }
        }
        item {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("为你发现", fontSize = 19.sp, fontWeight = FontWeight.Bold, color = Ink, modifier = Modifier.weight(1f))
                Text("推荐内容", fontSize = 11.sp, color = Violet)
            }
        }
        items(
            listOf(
                FeedItem("同人创作", "把喜欢的角色，画成自己的故事。", "插画 · 创作灵感", "✦ 作品灵感"),
                FeedItem("兴趣日常", "今天也在为热爱的世界收集快乐。", "生活 · 兴趣分享", "♡ 兴趣生活"),
                FeedItem("社群话题", "如果可以进入一部作品的世界，你会选择哪里？", "讨论 · 找到同好", "◎ 热门讨论")
            )
        ) { item -> FeedCard(item) }
        item {
            Text(
                "内容流将在 Discover Feed API 接入后展示实时推荐。",
                color = Muted, fontSize = 11.sp, modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}

private data class FeedItem(val category: String, val title: String, val subtitle: String, val tag: String)

@Composable
private fun FeedCard(item: FeedItem) {
    Surface(color = Color.White, shape = RoundedCornerShape(20.dp), shadowElevation = 1.dp) {
        Column(Modifier.fillMaxWidth().padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(Modifier.size(34.dp).clip(CircleShape).background(SoftViolet), contentAlignment = Alignment.Center) {
                    Icon(Icons.Rounded.AutoAwesome, null, tint = Violet, modifier = Modifier.size(18.dp))
                }
                Spacer(Modifier.width(9.dp))
                Column {
                    Text(item.category, color = Ink, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                    Text(item.subtitle, color = Muted, fontSize = 10.sp)
                }
                Spacer(Modifier.weight(1f))
                Text("关注", color = Violet, fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
            }
            Box(
                Modifier.fillMaxWidth().height(112.dp).clip(RoundedCornerShape(14.dp))
                    .background(Color(0xFFF0EDFA)),
                contentAlignment = Alignment.Center
            ) {
                Icon(Icons.Rounded.Palette, null, tint = Color(0xFFB6A9E8), modifier = Modifier.size(38.dp))
            }
            Text(item.title, color = Ink, fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(item.tag, color = Muted, fontSize = 10.sp, modifier = Modifier.weight(1f))
                Icon(Icons.Rounded.FavoriteBorder, null, tint = Muted, modifier = Modifier.size(17.dp))
                Spacer(Modifier.width(12.dp))
                Icon(Icons.Rounded.ChatBubbleOutline, null, tint = Muted, modifier = Modifier.size(17.dp))
                Spacer(Modifier.width(12.dp))
                Icon(Icons.Rounded.BookmarkBorder, null, tint = Muted, modifier = Modifier.size(17.dp))
            }
        }
    }
}

@Composable
private fun PlaceholderScreen(title: String, description: String, icon: androidx.compose.ui.graphics.vector.ImageVector) {
    Column(
        Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(Modifier.size(84.dp).clip(RoundedCornerShape(28.dp)).background(SoftViolet), contentAlignment = Alignment.Center) {
            Icon(icon, null, tint = Violet, modifier = Modifier.size(38.dp))
        }
        Spacer(Modifier.height(20.dp))
        Text(title, color = Ink, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(8.dp))
        Text(description, color = Muted, fontSize = 13.sp)
        Spacer(Modifier.height(18.dp))
        Surface(color = SoftViolet, shape = RoundedCornerShape(30.dp)) {
            Text("接口接入阶段", color = Violet, fontSize = 11.sp, modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp))
        }
    }
}

@Composable
private fun ProfileScreen() {
    Column(Modifier.fillMaxSize().padding(20.dp), verticalArrangement = Arrangement.spacedBy(18.dp)) {
        Text("个人中心", fontSize = 25.sp, color = Ink, fontWeight = FontWeight.Bold)
        Surface(color = Color.White, shape = RoundedCornerShape(22.dp)) {
            Row(Modifier.fillMaxWidth().padding(18.dp), verticalAlignment = Alignment.CenterVertically) {
                Box(Modifier.size(58.dp).clip(CircleShape).background(SoftViolet), contentAlignment = Alignment.Center) {
                    Icon(Icons.Rounded.Person, null, tint = Violet, modifier = Modifier.size(30.dp))
                }
                Spacer(Modifier.width(14.dp))
                Column(Modifier.weight(1f)) {
                    Text("登录 AniMate", color = Ink, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Text("登录后同步你的兴趣与关系", color = Muted, fontSize = 11.sp)
                }
                Icon(Icons.Rounded.ChevronRight, null, tint = Muted)
            }
        }
        listOf("我的订单", "我的收藏", "创作者中心", "商家入驻", "账号与安全", "设置").forEach { label ->
            Surface(color = Color.White, shape = RoundedCornerShape(15.dp), onClick = {}) {
                Row(Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 15.dp), verticalAlignment = Alignment.CenterVertically) {
                    Text(label, color = Ink, fontSize = 13.sp, modifier = Modifier.weight(1f))
                    Icon(Icons.Rounded.ChevronRight, null, tint = Muted, modifier = Modifier.size(18.dp))
                }
            }
        }
    }
}
