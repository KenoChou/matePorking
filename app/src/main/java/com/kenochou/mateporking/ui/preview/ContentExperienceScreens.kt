package com.kenochou.mateporking.ui.preview

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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

private val CInk = Color(0xFF302D35)
private val CMuted = Color(0xFF918B94)
private val CAccent = Color(0xFF8A789D)
private val CPale = Color(0xFFF0E9EE)
private val CCoral = Color(0xFFD9A6A5)

@Composable
fun ContentDetailScreen() {
    var liked by remember { mutableStateOf(false) }
    var following by remember { mutableStateOf(false) }
    var comment by remember { mutableStateOf("") }
    var sent by remember { mutableStateOf(false) }

    Column(Modifier.fillMaxSize().background(Color.White)) {
        Row(
            Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {}) { Icon(Icons.Rounded.ArrowBack, "返回", tint = CInk) }
            Text("作品详情", color = CInk, fontSize = 15.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.weight(1f))
            IconButton(onClick = {}) { Icon(Icons.Rounded.Share, "分享", tint = CMuted) }
            IconButton(onClick = {}) { Icon(Icons.Rounded.MoreHoriz, "更多", tint = CMuted) }
        }
        LazyColumn(
            Modifier.weight(1f),
            contentPadding = PaddingValues(bottom = 20.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            item {
                Box(
                    Modifier.fillMaxWidth().height(390.dp).background(
                        Brush.linearGradient(listOf(Color(0xFFE9DDF0), Color(0xFFF5DCD8), Color(0xFFDCE9E6)))
                    ),
                    contentAlignment = Alignment.Center
                ) {
                    Text("✧", color = Color(0xFF9B83A8), fontSize = 100.sp, fontWeight = FontWeight.Light)
                    Text("ORIGINAL ART  /  001", color = Color(0xFF746579), fontSize = 9.sp,
                        fontWeight = FontWeight.Bold, letterSpacing = 1.6.sp,
                        modifier = Modifier.align(Alignment.BottomStart).padding(18.dp))
                }
            }
            item {
                Column(Modifier.padding(horizontal = 18.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(Modifier.size(43.dp).clip(CircleShape).background(CPale), contentAlignment = Alignment.Center) {
                            Text("星", color = CAccent, fontWeight = FontWeight.Bold)
                        }
                        Spacer(Modifier.width(10.dp))
                        Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(3.dp)) {
                            Text("纸上星河", color = CInk, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                            Text("独立插画师 · 2 小时前", color = CMuted, fontSize = 10.sp)
                        }
                        OutlinedButton(
                            onClick = { following = !following },
                            shape = RoundedCornerShape(20.dp),
                            contentPadding = PaddingValues(horizontal = 14.dp, vertical = 5.dp),
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = CAccent)
                        ) { Text(if (following) "已关注" else "关注", fontSize = 10.sp) }
                    }
                    Text("把夏天收进一颗星星里 ✦", color = CInk, fontSize = 21.sp, fontWeight = FontWeight.Bold, lineHeight = 29.sp)
                    Text(
                        "最近在练习更轻一点的配色。把傍晚的粉紫色、玻璃汽水的蓝，还有一点点星光放在一起，想做成一组关于夏日记忆的小插画。希望你也能从里面找到一点灵感。",
                        color = Color(0xFF625D65), fontSize = 12.sp, lineHeight = 21.sp
                    )
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        listOf("#原创插画", "#色彩练习", "#夏日灵感").forEach { tag ->
                            Surface(color = CPale, shape = RoundedCornerShape(8.dp)) {
                                Text(tag, color = CAccent, fontSize = 10.sp, modifier = Modifier.padding(horizontal = 10.dp, vertical = 7.dp))
                            }
                        }
                    }
                    HorizontalDivider(color = Color(0xFFF0ECE9))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("评论  26", color = CInk, fontSize = 14.sp, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
                        Text("按时间排序", color = CMuted, fontSize = 10.sp)
                    }
                }
            }
            item {
                Column(Modifier.padding(horizontal = 18.dp), verticalArrangement = Arrangement.spacedBy(15.dp)) {
                    CommentLine("小满", "这个配色好舒服！有种夏日傍晚的感觉。", "刚刚", "♡ 12")
                    CommentLine("Mio", "想问一下紫色部分是怎么调出来的？", "18 分钟前", "♡ 8")
                    CommentLine("阿澄", "收藏了，下一张也期待！", "42 分钟前", "♡ 5")
                    if (sent) Text("评论已添加到本地预览。", color = CAccent, fontSize = 10.sp)
                }
            }
        }
        Surface(color = Color.White, shadowElevation = 8.dp) {
            Row(
                Modifier.fillMaxWidth().navigationBarsPadding().padding(horizontal = 13.dp, vertical = 9.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                OutlinedTextField(
                    value = comment,
                    onValueChange = { comment = it },
                    modifier = Modifier.weight(1f),
                    placeholder = { Text("说点喜欢的话…", fontSize = 11.sp) },
                    singleLine = true,
                    shape = RoundedCornerShape(22.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedContainerColor = Color(0xFFFAF8F5),
                        focusedContainerColor = Color(0xFFFAF8F5),
                        unfocusedBorderColor = Color.Transparent,
                        focusedBorderColor = CAccent
                    )
                )
                IconButton(onClick = { liked = !liked }) {
                    Icon(if (liked) Icons.Rounded.Favorite else Icons.Rounded.FavoriteBorder, "喜欢",
                        tint = if (liked) CCoral else CMuted)
                }
                TextButton(onClick = { if (comment.isNotBlank()) { sent = true; comment = "" } }) {
                    Text("发送", color = CAccent, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
private fun CommentLine(author: String, body: String, time: String, likes: String) {
    Row(verticalAlignment = Alignment.Top) {
        Box(Modifier.size(34.dp).clip(CircleShape).background(Color(0xFFF4EEF2)), contentAlignment = Alignment.Center) {
            Text(author.take(1), color = CAccent, fontSize = 11.sp, fontWeight = FontWeight.Bold)
        }
        Spacer(Modifier.width(9.dp))
        Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(5.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(author, color = CInk, fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
                Spacer(Modifier.width(8.dp))
                Text(time, color = CMuted, fontSize = 9.sp)
                Spacer(Modifier.weight(1f))
                Text(likes, color = CMuted, fontSize = 9.sp)
            }
            Text(body, color = Color(0xFF625D65), fontSize = 11.sp, lineHeight = 17.sp)
        }
    }
}

@Composable
fun ContentPublishScreen() {
    var body by remember { mutableStateOf("") }
    var title by remember { mutableStateOf("") }
    var selectedTags by remember { mutableStateOf(setOf("原创插画")) }
    var visibility by remember { mutableStateOf("所有人可见") }
    var imageAdded by remember { mutableStateOf(false) }
    var published by remember { mutableStateOf(false) }
    val tags = listOf("原创插画", "动漫分享", "手办模型", "日常记录", "同好交流", "灵感记录")

    Column(Modifier.fillMaxSize().background(Color.White)) {
        Row(
            Modifier.fillMaxWidth().padding(start = 10.dp, end = 16.dp, top = 7.dp, bottom = 7.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {}) { Icon(Icons.Rounded.Close, "关闭", tint = CInk) }
            Text("发布作品", color = CInk, fontSize = 16.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.weight(1f))
            TextButton(onClick = { published = false }) { Text("存草稿", color = CMuted, fontSize = 11.sp) }
            Button(
                onClick = { if (body.isNotBlank() || title.isNotBlank()) published = true },
                enabled = body.isNotBlank() || title.isNotBlank(),
                shape = RoundedCornerShape(20.dp),
                contentPadding = PaddingValues(horizontal = 18.dp, vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = CInk, disabledContainerColor = Color(0xFFD8D3D7))
            ) { Text("发布", fontSize = 11.sp) }
        }
        HorizontalDivider(color = Color(0xFFF0ECE9))
        LazyColumn(
            Modifier.weight(1f),
            contentPadding = PaddingValues(horizontal = 19.dp, vertical = 17.dp),
            verticalArrangement = Arrangement.spacedBy(19.dp)
        ) {
            item {
                Column(verticalArrangement = Arrangement.spacedBy(9.dp)) {
                    Text("分享此刻的灵感", color = CInk, fontSize = 23.sp, fontWeight = FontWeight.Bold)
                    Text("让喜欢被看见，也让同好找到你。", color = CMuted, fontSize = 11.sp)
                }
            }
            item {
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    if (imageAdded) {
                        Box(
                            Modifier.size(112.dp).clip(RoundedCornerShape(13.dp))
                                .background(Brush.linearGradient(listOf(Color(0xFFE9DDF0), Color(0xFFF5DCD8), Color(0xFFDCE9E6)))),
                            contentAlignment = Alignment.Center
                        ) { Text("✧", color = CAccent, fontSize = 35.sp) }
                    }
                    Box(
                        Modifier.size(112.dp).clip(RoundedCornerShape(13.dp))
                            .background(Color(0xFFFAF8F5)).clickable { imageAdded = !imageAdded },
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            Icon(Icons.Rounded.AddPhotoAlternate, null, tint = CAccent, modifier = Modifier.size(25.dp))
                            Text(if (imageAdded) "再添加" else "添加图片", color = CMuted, fontSize = 10.sp)
                        }
                    }
                }
            }
            item {
                Column(verticalArrangement = Arrangement.spacedBy(7.dp)) {
                    Text("标题", color = CInk, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                    OutlinedTextField(
                        value = title,
                        onValueChange = { title = it },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text("给这份灵感一个名字", fontSize = 12.sp) },
                        singleLine = true,
                        shape = RoundedCornerShape(13.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedContainerColor = Color(0xFFFAF8F5),
                            focusedContainerColor = Color(0xFFFAF8F5),
                            unfocusedBorderColor = Color.Transparent,
                            focusedBorderColor = CAccent
                        )
                    )
                }
            }
            item {
                Column(verticalArrangement = Arrangement.spacedBy(7.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("正文", color = CInk, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                        Spacer(Modifier.weight(1f))
                        Text("${body.length} / 2000", color = CMuted, fontSize = 9.sp)
                    }
                    OutlinedTextField(
                        value = body,
                        onValueChange = { body = it.take(2000) },
                        modifier = Modifier.fillMaxWidth().heightIn(min = 145.dp),
                        placeholder = { Text("记录创作过程、分享收藏，或向同好发起一个话题…", fontSize = 11.sp, lineHeight = 18.sp) },
                        shape = RoundedCornerShape(13.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedContainerColor = Color(0xFFFAF8F5),
                            focusedContainerColor = Color(0xFFFAF8F5),
                            unfocusedBorderColor = Color.Transparent,
                            focusedBorderColor = CAccent
                        )
                    )
                }
            }
            item {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text("添加话题", color = CInk, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                    Text("选择合适的话题，让更多同好发现你", color = CMuted, fontSize = 10.sp)
                    FlowTagGrid(tags, selectedTags) { tag ->
                        selectedTags = if (tag in selectedTags) selectedTags - tag else selectedTags + tag
                    }
                }
            }
            item {
                Column(verticalArrangement = Arrangement.spacedBy(9.dp)) {
                    Text("谁可以看", color = CInk, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        listOf("所有人可见", "仅关注者", "仅自己").forEach { option ->
                            FilterChip(
                                selected = visibility == option,
                                onClick = { visibility = option },
                                label = { Text(option, fontSize = 10.sp) },
                                shape = RoundedCornerShape(11.dp),
                                colors = FilterChipDefaults.filterChipColors(
                                    selectedContainerColor = CPale,
                                    selectedLabelColor = CAccent,
                                    containerColor = Color(0xFFFAF8F5),
                                    labelColor = CMuted
                                ),
                                border = null
                            )
                        }
                    }
                }
            }
            item {
                if (published) {
                    Surface(color = Color(0xFFEAF4EF), shape = RoundedCornerShape(12.dp)) {
                        Row(Modifier.fillMaxWidth().padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Rounded.CheckCircle, null, tint = Color(0xFF5B9C7B))
                            Spacer(Modifier.width(8.dp))
                            Text("已完成本地发布预览；当前不会提交到服务器。", color = Color(0xFF477B62), fontSize = 10.sp)
                        }
                    }
                }
                Text("发布前请确认内容符合社区规范。", color = CMuted, fontSize = 9.sp)
            }
        }
    }
}

@Composable
private fun FlowTagGrid(tags: List<String>, selected: Set<String>, onToggle: (String) -> Unit) {
    Column(verticalArrangement = Arrangement.spacedBy(7.dp)) {
        tags.chunked(3).forEach { rowTags ->
            Row(horizontalArrangement = Arrangement.spacedBy(7.dp)) {
                rowTags.forEach { tag ->
                    FilterChip(
                        selected = tag in selected,
                        onClick = { onToggle(tag) },
                        label = { Text("#$tag", fontSize = 10.sp) },
                        shape = RoundedCornerShape(10.dp),
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = CPale,
                            selectedLabelColor = CAccent,
                            containerColor = Color(0xFFFAF8F5),
                            labelColor = CMuted
                        ),
                        border = null
                    )
                }
            }
        }
    }
}
