package com.kenochou.mateporking.ui.preview

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val PInk = Color(0xFF17151F)
private val PMuted = Color(0xFF777383)
private val PBg = Color(0xFFF4F2EE)
private val PAccent = Color(0xFF6847FF)
private val PPale = Color(0xFFE7FF68)
private val PCoral = Color(0xFFFF5578)
private val PLine = Color(0xFFE6E2DC)

private data class FeedPost(
    val author: String,
    val initial: String,
    val time: String,
    val title: String,
    val tag: String,
    val likes: Int,
    val comments: Int,
    val symbol: String,
    val featured: Boolean = false
)

private val samplePosts = listOf(
    FeedPost("原创插画交流社", "绘", "2 小时前", "最近完成了一组关于「夏日与星光」的练习，想听听大家对色彩和构图的建议。", "作品分享", 128, 26, "✧", true),
    FeedPost("纸上星河", "星", "35 分钟前", "把最近收集的配色灵感整理成了小卡片，蓝紫色真的很适合夜晚。", "灵感记录", 86, 12, "✦"),
    FeedPost("模型收藏研究所", "模", "1 小时前", "今天终于把展示柜布置好了，给每个喜欢的角色都留了一个位置。", "收藏日常", 54, 8, "❀"),
    FeedPost("周末漫游计划", "漫", "昨天", "周末准备去逛展，有没有同城同好想一起交流？", "线下活动", 36, 8, "♡")
)

@Composable
fun CommunityFeedScreen() {
    var selectedTab by remember { mutableStateOf("推荐") }
    var likedPosts by remember { mutableStateOf(setOf<Int>()) }
    var searchVisible by remember { mutableStateOf(false) }
    var query by remember { mutableStateOf("") }
    val tabs = listOf("推荐", "关注", "最新", "圈子动态")
    val visiblePosts = samplePosts.withIndex().filter { (_, post) ->
        (query.isBlank() || post.title.contains(query, true) || post.author.contains(query, true)) &&
            (selectedTab != "关注" || post.author == "纸上星河") &&
            (selectedTab != "圈子动态" || post.author.contains("社") || post.author.contains("研究所"))
    }

    Column(Modifier.fillMaxSize().background(PBg)) {
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(start = 18.dp, top = 18.dp, end = 18.dp, bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            item {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(3.dp)) {
                        Eyebrow("COMMUNITY · YOUR PEOPLE")
                        Text("找到你的同频", color = PInk, fontSize = 30.sp, fontWeight = FontWeight.Black)
                        Text("兴趣不设限，表达不设限", color = PMuted, fontSize = 11.sp)
                    }
                    IconButton(onClick = { searchVisible = !searchVisible }) {
                        Icon(if (searchVisible) Icons.Rounded.Close else Icons.Rounded.Search, "搜索", tint = PInk)
                    }
                    FilledIconButton(
                        onClick = {},
                        colors = IconButtonDefaults.filledIconButtonColors(containerColor = PAccent)
                    ) { Icon(Icons.Rounded.Edit, "发布动态", tint = Color.White) }
                }
            }
            if (searchVisible) {
                item {
                    OutlinedTextField(
                        value = query,
                        onValueChange = { query = it },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text("搜索帖子或创作者", fontSize = 12.sp) },
                        leadingIcon = { Icon(Icons.Rounded.Search, null, tint = PMuted) },
                        trailingIcon = {
                            if (query.isNotEmpty()) IconButton(onClick = { query = "" }) {
                                Icon(Icons.Rounded.Close, "清空", tint = PMuted)
                            }
                        },
                        singleLine = true,
                        shape = RoundedCornerShape(16.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedContainerColor = Color.White,
                            focusedContainerColor = Color.White,
                            unfocusedBorderColor = Color.Transparent,
                            focusedBorderColor = PAccent
                        )
                    )
                }
            }
            item {
                Surface(color = Color.White, shape = RoundedCornerShape(20.dp)) {
                    Row(
                        Modifier.fillMaxWidth().padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(Modifier.size(38.dp).clip(RoundedCornerShape(12.dp)).background(PPale), contentAlignment = Alignment.Center) {
                            Icon(Icons.Rounded.AutoAwesome, null, tint = PAccent)
                        }
                        Spacer(Modifier.width(11.dp))
                        Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(3.dp)) {
                            Text("找到你的兴趣同频", color = PInk, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                            Text("探索 24 个正在活跃的兴趣圈子", color = PMuted, fontSize = 10.sp)
                        }
                        Icon(Icons.Rounded.ChevronRight, null, tint = PMuted)
                    }
                }
            }
            item {
                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(tabs) { tab ->
                        FilterChip(
                            selected = selectedTab == tab,
                            onClick = { selectedTab = tab },
                            label = { Text(tab, fontSize = 11.sp) },
                            shape = RoundedCornerShape(13.dp),
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = PAccent,
                                selectedLabelColor = Color.White,
                                containerColor = Color.White,
                                labelColor = PMuted
                            ),
                            border = null
                        )
                    }
                }
            }
            item {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("为你精选", color = PInk, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Spacer(Modifier.width(7.dp))
                    Surface(color = PPale, shape = CircleShape) {
                        Text("TODAY", color = PAccent, fontSize = 8.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 7.dp, vertical = 4.dp))
                    }
                    Spacer(Modifier.weight(1f))
                    Text("示例内容", color = PMuted, fontSize = 9.sp)
                }
            }
            items(visiblePosts, key = { it.index }) { indexed ->
                val post = indexed.value
                CommunityPostCard(
                    post = post,
                    liked = likedPosts.contains(indexed.index),
                    onLike = {
                        likedPosts = if (likedPosts.contains(indexed.index)) likedPosts - indexed.index
                        else likedPosts + indexed.index
                    }
                )
            }
            if (visiblePosts.isEmpty()) {
                item {
                    EmptyHint("没有找到相关动态", "换个关键词，看看其他同好在分享什么")
                }
            }
        }
        PrimaryBottomBar("Community")
    }
}

@Composable
private fun CommunityPostCard(post: FeedPost, liked: Boolean, onLike: () -> Unit) {
    Surface(color = Color.White, shape = RoundedCornerShape(25.dp)) {
        Column(Modifier.padding(15.dp), verticalArrangement = Arrangement.spacedBy(11.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                AvatarMark(post.initial, if (post.featured) PPale else Color(0xFFFFE9E5), 42)
                Spacer(Modifier.width(10.dp))
                Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(3.dp)) {
                    Text(post.author, color = PInk, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    Text("${post.time} · ${post.tag}", color = PMuted, fontSize = 9.sp)
                }
                if (post.featured) {
                    Surface(color = PPale, shape = CircleShape) {
                        Text("精选", color = PAccent, fontSize = 9.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(horizontal = 9.dp, vertical = 5.dp))
                    }
                } else {
                    Icon(Icons.Rounded.MoreHoriz, "更多", tint = PMuted)
                }
            }
            Text(post.title, color = PInk, fontSize = 13.sp, lineHeight = 21.sp)
            ArtTile(post.symbol, if (post.featured) 172 else 126)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("兴趣分享", color = PAccent, fontSize = 9.sp, modifier = Modifier.weight(1f))
                TextButton(onClick = onLike, contentPadding = PaddingValues(horizontal = 8.dp)) {
                    Icon(if (liked) Icons.Rounded.Favorite else Icons.Rounded.FavoriteBorder, null, tint = if (liked) PCoral else PMuted, modifier = Modifier.size(16.dp))
                    Spacer(Modifier.width(4.dp))
                    Text("${post.likes + if (liked) 1 else 0}", color = if (liked) PCoral else PMuted, fontSize = 10.sp)
                }
                TextButton(onClick = {}, contentPadding = PaddingValues(horizontal = 8.dp)) {
                    Icon(Icons.Rounded.ChatBubbleOutline, null, tint = PMuted, modifier = Modifier.size(15.dp))
                    Spacer(Modifier.width(4.dp))
                    Text("${post.comments}", color = PMuted, fontSize = 10.sp)
                }
                IconButton(onClick = {}, modifier = Modifier.size(34.dp)) {
                    Icon(Icons.Rounded.Share, "分享", tint = PMuted, modifier = Modifier.size(16.dp))
                }
            }
        }
    }
}

@Composable
fun MarketHomeScreen() {
    var selectedCategory by remember { mutableStateOf("全部") }
    var favorites by remember { mutableStateOf(setOf("星月系列收藏摆件")) }
    var cartCount by remember { mutableIntStateOf(0) }
    val products = listOf(
        Triple("星月系列收藏摆件", "¥128", "✧"),
        Triple("原创插画收藏卡", "¥36", "❀"),
        Triple("艺术周边礼盒", "¥88", "✦"),
        Triple("限定主题徽章", "¥25", "♡"),
        Triple("手作主题挂件", "¥49", "☾"),
        Triple("插画灵感手账", "¥32", "✿")
    )
    val categories = listOf("全部", "手办模型", "原创插画", "服饰配件", "文创周边")

    Column(Modifier.fillMaxSize().background(PBg)) {
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(start = 18.dp, top = 18.dp, end = 18.dp, bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(3.dp)) {
                        Eyebrow("ANIMATE MARKET · CURATED")
                        Text("灵感补给站", color = PInk, fontSize = 30.sp, fontWeight = FontWeight.Black)
                        Text("让每一份喜欢，都值得被收藏", color = PMuted, fontSize = 11.sp)
                    }
                    IconButton(onClick = {}) { Icon(Icons.Rounded.Search, "搜索商品", tint = PInk) }
                    BadgedBox(badge = { if (cartCount > 0) Badge { Text(cartCount.toString()) } }) {
                        IconButton(onClick = {}) { Icon(Icons.Rounded.ShoppingBag, "购物袋", tint = PInk) }
                    }
                }
            }
            item {
                Box(
                    Modifier.fillMaxWidth().clip(RoundedCornerShape(25.dp))
                        .background(Brush.linearGradient(listOf(Color(0xFF6847FF), Color(0xFF9B70FF), Color(0xFFFF6D91))))
                        .padding(20.dp)
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(9.dp)) {
                        Text("THE CREATOR CLUB ✳", color = Color(0xFFE7FF68), fontSize = 10.sp, fontWeight = FontWeight.Bold, letterSpacing = 1.5.sp)
                        Text("喜欢的东西，\n就要大声收藏。", color = Color.White, fontSize = 25.sp, lineHeight = 29.sp, fontWeight = FontWeight.Bold)
                        Text("原创设计 · 限量周边 · 兴趣好物", color = Color.White.copy(alpha = .9f), fontSize = 10.sp)
                        Surface(color = Color.White.copy(alpha = .96f), shape = CircleShape) {
                            Row(Modifier.padding(horizontal = 13.dp, vertical = 8.dp), verticalAlignment = Alignment.CenterVertically) {
                                Text("探索创作者精选", color = PAccent, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                                Spacer(Modifier.width(5.dp))
                                Icon(Icons.Rounded.ArrowForward, null, tint = PAccent, modifier = Modifier.size(13.dp))
                            }
                        }
                    }
                    Text("✧", color = Color.White.copy(alpha = .22f), fontSize = 94.sp, modifier = Modifier.align(Alignment.BottomEnd))
                }
            }
            item {
                SectionHeading("发现分类", "全部分类")
                Spacer(Modifier.height(10.dp))
                LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    items(listOf(
                        Triple("手办模型", Icons.Rounded.Toys, PPale),
                        Triple("原创插画", Icons.Rounded.Brush, Color(0xFFFFE9E5)),
                        Triple("服饰配件", Icons.Rounded.Checkroom, Color(0xFFE5F1EF)),
                        Triple("文创周边", Icons.Rounded.CardGiftcard, Color(0xFFFFF0D9))
                    )) { category ->
                        Column(
                            Modifier.width(69.dp).clickable { selectedCategory = category.first },
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(7.dp)
                        ) {
                            Surface(color = category.third, shape = RoundedCornerShape(20.dp)) {
                                Box(Modifier.size(58.dp), contentAlignment = Alignment.Center) {
                                    Icon(category.second, null, tint = PAccent, modifier = Modifier.size(25.dp))
                                }
                            }
                            Text(category.first, color = PInk, fontSize = 9.sp, maxLines = 1)
                        }
                    }
                }
            }
            item {
                LazyRow(horizontalArrangement = Arrangement.spacedBy(7.dp)) {
                    items(categories) { category ->
                        FilterChip(
                            selected = selectedCategory == category,
                            onClick = { selectedCategory = category },
                            label = { Text(category, fontSize = 10.sp) },
                            shape = RoundedCornerShape(12.dp),
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = PAccent,
                                selectedLabelColor = Color.White,
                                containerColor = Color.White,
                                labelColor = PMuted
                            ),
                            border = null
                        )
                    }
                }
            }
            item { SectionHeading("创作者精选", "发现更多") }
            item {
                Column(verticalArrangement = Arrangement.spacedBy(11.dp)) {
                    products.chunked(2).forEach { rowProducts ->
                        Row(horizontalArrangement = Arrangement.spacedBy(11.dp)) {
                            rowProducts.forEach { product ->
                                ProductTile(
                                    title = product.first,
                                    price = product.second,
                                    symbol = product.third,
                                    modifier = Modifier.weight(1f),
                                    favorite = favorites.contains(product.first),
                                    onFavorite = {
                                        favorites = if (favorites.contains(product.first)) favorites - product.first else favorites + product.first
                                    },
                                    onAdd = { cartCount += 1 }
                                )
                            }
                            if (rowProducts.size == 1) Spacer(Modifier.weight(1f))
                        }
                    }
                }
            }
            item {
                Surface(color = Color.White, shape = RoundedCornerShape(17.dp)) {
                    Row(Modifier.fillMaxWidth().padding(14.dp), verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Rounded.Verified, null, tint = PAccent)
                        Spacer(Modifier.width(9.dp))
                        Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(3.dp)) {
                            Text("支持原创创作者", color = PInk, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                            Text("发现独立设计与兴趣社群的灵感好物", color = PMuted, fontSize = 9.sp)
                        }
                        Icon(Icons.Rounded.ChevronRight, null, tint = PMuted)
                    }
                }
            }
        }
        PrimaryBottomBar("Market")
    }
}

@Composable
fun ConversationListScreen() {
    var query by remember { mutableStateOf("") }
    var selectedFilter by remember { mutableStateOf("全部") }
    val conversations = listOf(
        Triple("纸上星河", "这组作品的色彩搭配太棒了！", "14:32"),
        Triple("原创插画交流社", "小满：周末准备组织一次线上分享", "13:08"),
        Triple("模型收藏研究所", "发布了新的圈子公告", "昨天"),
        Triple("AniMate 官方", "欢迎来到 AniMate 兴趣社区", "周一")
    )
    val visible = conversations.filter {
        (query.isBlank() || it.first.contains(query, true) || it.second.contains(query, true)) &&
            (selectedFilter == "全部" || (selectedFilter == "未读" && it.first == "纸上星河"))
    }

    Column(Modifier.fillMaxSize().background(PBg)) {
        Column(Modifier.padding(start = 18.dp, top = 18.dp, end = 18.dp, bottom = 8.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(3.dp)) {
                    Eyebrow("MESSAGES · STAY CONNECTED")
                    Text("消息", color = PInk, fontSize = 30.sp, fontWeight = FontWeight.Black)
                    Text("别让有趣的对话停在这里", color = PMuted, fontSize = 11.sp)
                }
                IconButton(onClick = {}) { Icon(Icons.Rounded.EditNote, "新消息", tint = PInk) }
            }
            Spacer(Modifier.height(15.dp))
            OutlinedTextField(
                value = query,
                onValueChange = { query = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("搜索会话与消息", fontSize = 12.sp) },
                leadingIcon = { Icon(Icons.Rounded.Search, null, tint = PMuted) },
                trailingIcon = {
                    if (query.isNotEmpty()) IconButton(onClick = { query = "" }) {
                        Icon(Icons.Rounded.Close, "清空", tint = PMuted)
                    }
                },
                singleLine = true,
                shape = RoundedCornerShape(15.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = PAccent
                )
            )
            Spacer(Modifier.height(14.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(9.dp)) {
                listOf(
                    Triple("互动通知", Icons.Rounded.FavoriteBorder, "12"),
                    Triple("评论与回复", Icons.Rounded.ChatBubbleOutline, "3"),
                    Triple("圈子消息", Icons.Rounded.Groups, "")
                ).forEach { item ->
                    Surface(
                        color = Color.White,
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier.weight(1f).clickable { selectedFilter = "全部" }
                    ) {
                        Column(Modifier.padding(vertical = 12.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            Box {
                                Icon(item.second, null, tint = PAccent, modifier = Modifier.size(21.dp))
                                if (item.third.isNotEmpty()) Badge(Modifier.align(Alignment.TopEnd).offset(x = 7.dp, y = (-5).dp)) { Text(item.third) }
                            }
                            Text(item.first, color = PInk, fontSize = 9.sp, fontWeight = FontWeight.Medium)
                        }
                    }
                }
            }
            Spacer(Modifier.height(15.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("最近会话", color = PInk, fontSize = 15.sp, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
                Text("示例消息", color = PMuted, fontSize = 9.sp)
            }
            Spacer(Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(7.dp)) {
                listOf("全部", "未读").forEach { filter ->
                    FilterChip(
                        selected = selectedFilter == filter,
                        onClick = { selectedFilter = filter },
                        label = { Text(filter, fontSize = 10.sp) },
                        shape = RoundedCornerShape(11.dp),
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = PPale,
                            selectedLabelColor = PAccent,
                            containerColor = Color.White,
                            labelColor = PMuted
                        ),
                        border = null
                    )
                }
            }
        }
        LazyColumn(
            Modifier.weight(1f),
            contentPadding = PaddingValues(horizontal = 18.dp, vertical = 5.dp)
        ) {
            items(visible) { item ->
                Row(
                    Modifier.fillMaxWidth().clickable { }.padding(vertical = 13.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box {
                        AvatarMark(item.first.take(1), if (item.first == "AniMate 官方") PPale else Color(0xFFFFE9E5), 50)
                        if (item.first == "纸上星河") {
                            Box(Modifier.size(11.dp).align(Alignment.BottomEnd).clip(CircleShape).background(Color(0xFF65B99B)))
                        }
                    }
                    Spacer(Modifier.width(12.dp))
                    Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(5.dp)) {
                        Text(item.first, color = PInk, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                        Text(item.second, color = PMuted, fontSize = 10.sp, maxLines = 1)
                    }
                    Column(horizontalAlignment = Alignment.End, verticalArrangement = Arrangement.spacedBy(7.dp)) {
                        Text(item.third, color = PMuted, fontSize = 9.sp)
                        if (item.first == "纸上星河") {
                            Surface(color = PCoral, shape = CircleShape) {
                                Text("2", color = Color.White, fontSize = 8.sp, modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp))
                            }
                        }
                    }
                }
                HorizontalDivider(color = PLine, thickness = .8.dp)
            }
            if (visible.isEmpty()) {
                item { EmptyHint("没有匹配的会话", "试试其他联系人或消息关键词") }
            }
        }
        PrimaryBottomBar("Message")
    }
}

@Composable
private fun PrimaryBottomBar(selected: String) {
    Surface(color = Color.White, shadowElevation = 8.dp) {
        Row(
            Modifier.fillMaxWidth().navigationBarsPadding().padding(horizontal = 8.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            val tabs = listOf(
                Triple("Discover", "发现", Icons.Rounded.Explore),
                Triple("Community", "圈子", Icons.Rounded.Groups),
                Triple("Market", "商城", Icons.Rounded.Storefront),
                Triple("Message", "消息", Icons.Rounded.ChatBubbleOutline),
                Triple("Profile", "我的", Icons.Rounded.PersonOutline)
            )
            tabs.forEach { tab ->
                val active = tab.first == selected
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier.width(58.dp).clip(RoundedCornerShape(13.dp)).clickable { }.padding(vertical = 3.dp)
                ) {
                    Box(
                        Modifier.width(42.dp).clip(RoundedCornerShape(13.dp))
                            .background(if (active) PPale else Color.Transparent)
                            .padding(vertical = 5.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(tab.third, contentDescription = tab.second, tint = if (active) PAccent else PMuted, modifier = Modifier.size(20.dp))
                    }
                    Text(tab.second, color = if (active) PAccent else PMuted, fontSize = 9.sp, fontWeight = if (active) FontWeight.Bold else FontWeight.Normal)
                }
            }
        }
    }
}

@Composable
private fun Eyebrow(text: String) {
    Text(text, color = PAccent, fontSize = 8.sp, fontWeight = FontWeight.Bold, letterSpacing = 1.3.sp)
}

@Composable
private fun AvatarMark(label: String, tint: Color, size: Int = 38) {
    Box(Modifier.size(size.dp).clip(CircleShape).background(tint), contentAlignment = Alignment.Center) {
        Text(label, color = PAccent, fontSize = 13.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun ArtTile(symbol: String, height: Int, modifier: Modifier = Modifier) {
    Box(
        modifier.fillMaxWidth().height(height.dp).clip(RoundedCornerShape(17.dp)).background(
            Brush.linearGradient(listOf(Color(0xFFE8E1FF), Color(0xFFFFE5E1), Color(0xFFE8F0F0)))
        ),
        contentAlignment = Alignment.Center
    ) {
        Text(symbol, color = Color(0xFF9A88D8), fontSize = 43.sp, fontWeight = FontWeight.Light)
    }
}

@Composable
private fun ProductTile(
    title: String,
    price: String,
    symbol: String,
    modifier: Modifier = Modifier,
    favorite: Boolean = false,
    onFavorite: () -> Unit = {},
    onAdd: () -> Unit = {}
) {
    Surface(color = Color.White, shape = RoundedCornerShape(23.dp), modifier = modifier) {
        Column(Modifier.padding(9.dp), verticalArrangement = Arrangement.spacedBy(7.dp)) {
            Box {
                ArtTile(symbol, 118)
                IconButton(
                    onClick = onFavorite,
                    modifier = Modifier.align(Alignment.TopEnd).padding(5.dp).size(29.dp)
                        .clip(CircleShape).background(Color.White.copy(alpha = .92f))
                ) {
                    Icon(if (favorite) Icons.Rounded.Favorite else Icons.Rounded.FavoriteBorder, "收藏", tint = if (favorite) PCoral else PMuted, modifier = Modifier.size(15.dp))
                }
            }
            Text(title, color = PInk, fontSize = 11.sp, fontWeight = FontWeight.SemiBold, maxLines = 1)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(price, color = PCoral, fontSize = 14.sp, fontWeight = FontWeight.ExtraBold, modifier = Modifier.weight(1f))
                IconButton(onClick = onAdd, modifier = Modifier.size(29.dp).clip(CircleShape).background(PPale)) {
                    Icon(Icons.Rounded.Add, "加入购物袋", tint = PAccent, modifier = Modifier.size(17.dp))
                }
            }
        }
    }
}

@Composable
private fun SectionHeading(title: String, more: String) {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(title, color = PInk, fontSize = 16.sp, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
        Text(more, color = PAccent, fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
private fun EmptyHint(title: String, description: String) {
    Column(
        Modifier.fillMaxWidth().padding(vertical = 38.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(7.dp)
    ) {
        Icon(Icons.Rounded.SearchOff, null, tint = PMuted, modifier = Modifier.size(30.dp))
        Text(title, color = PInk, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
        Text(description, color = PMuted, fontSize = 10.sp)
    }
}
