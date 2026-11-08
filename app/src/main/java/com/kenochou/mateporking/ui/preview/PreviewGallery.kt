package com.kenochou.mateporking.ui.preview

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val GalleryInk = Color(0xFF242332)
private val GalleryMuted = Color(0xFF888696)
private val GalleryBg = Color(0xFFF8F7FB)
private val GalleryViolet = Color(0xFF7866D8)
private val GalleryPale = Color(0xFFEDE9FF)

private data class PreviewRoute(val group: String, val name: String, val description: String)

private val previewRoutes = listOf(
    PreviewRoute("认证", "欢迎页", "品牌介绍与开始使用"),
    PreviewRoute("认证", "手机号登录", "手机号与验证码入口"),
    PreviewRoute("认证", "验证码验证", "短信验证码输入"),
    PreviewRoute("发现", "Discover 首页", "推荐内容与兴趣入口"),
    PreviewRoute("发现", "趋势发现", "热门内容与趋势"),
    PreviewRoute("发现", "搜索", "搜索作品、用户与商品"),
    PreviewRoute("发现", "内容详情", "作品、作者与评论"),
    PreviewRoute("社区", "圈子发现", "兴趣圈子推荐"),
    PreviewRoute("社区", "圈子详情", "圈子介绍与动态"),
    PreviewRoute("社区", "圈子成员", "成员与身份列表"),
    PreviewRoute("商城", "商城首页", "商品推荐与精选"),
    PreviewRoute("商城", "商品分类", "分类导航"),
    PreviewRoute("商城", "商品详情", "商品图、规格与购买"),
    PreviewRoute("商城", "购物车", "商品清单与结算"),
    PreviewRoute("订单", "订单列表", "订单状态分类"),
    PreviewRoute("订单", "订单详情", "物流与支付信息"),
    PreviewRoute("订单", "支付结果", "支付状态反馈"),
    PreviewRoute("消息", "会话列表", "最近联系人与消息"),
    PreviewRoute("消息", "聊天详情", "消息气泡与输入栏"),
    PreviewRoute("消息", "互动通知", "关注、评论与系统通知"),
    PreviewRoute("个人", "个人主页", "资料与个人入口"),
    PreviewRoute("个人", "编辑资料", "昵称、头像与简介"),
    PreviewRoute("个人", "我的收藏", "收藏内容与商品"),
    PreviewRoute("个人", "设置", "账号、安全与隐私"),
    PreviewRoute("创作者", "创作者中心", "创作工作台"),
    PreviewRoute("创作者", "作品管理", "发布内容与草稿"),
    PreviewRoute("创作者", "创作数据", "浏览、互动与粉丝"),
    PreviewRoute("商家", "商家中心", "店铺经营入口"),
    PreviewRoute("商家", "商品管理", "商品上架与库存"),
    PreviewRoute("商家", "店铺管理", "店铺资料与售后"),
    PreviewRoute("活动", "活动列表", "展会与兴趣活动"),
    PreviewRoute("活动", "活动详情", "活动介绍与日程"),
    PreviewRoute("活动", "活动报名", "报名资料与场次"),
    PreviewRoute("活动", "我的电子票", "门票与核验状态")
)

@Composable
fun PreviewGallery() {
    var selectedGroup by remember { mutableStateOf("全部") }
    var selectedPage by remember { mutableStateOf<PreviewRoute?>(null) }
    var searchQuery by remember { mutableStateOf("") }
    val groups = listOf("全部") + previewRoutes.map { it.group }.distinct()
    val visible = previewRoutes.filter { page ->
        (selectedGroup == "全部" || page.group == selectedGroup) &&
            (searchQuery.isBlank() || page.name.contains(searchQuery.trim(), ignoreCase = true) ||
                page.group.contains(searchQuery.trim(), ignoreCase = true) ||
                page.description.contains(searchQuery.trim(), ignoreCase = true))
    }

    Column(Modifier.fillMaxSize().background(GalleryBg)) {
        Row(
            Modifier.fillMaxWidth().background(Color.White).padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(Modifier.weight(1f)) {
                Text("ANIMATE DESIGN SYSTEM", color = GalleryViolet, fontSize = 9.sp, fontWeight = FontWeight.Bold, letterSpacing = 1.3.sp)
                Text("页面预览中心", color = GalleryInk, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Text("${previewRoutes.size} 个页面 · ${groups.size - 1} 个业务模块", color = GalleryMuted, fontSize = 11.sp)
            }
            Surface(color = GalleryPale, shape = CircleShape) {
                Text("UI ONLY", color = GalleryViolet, fontSize = 10.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp))
            }
        }

        if (selectedPage == null) {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
                placeholder = { Text("搜索页面、模块或功能") },
                leadingIcon = { Icon(Icons.Rounded.Search, contentDescription = null) },
                trailingIcon = {
                    if (searchQuery.isNotEmpty()) {
                        IconButton(onClick = { searchQuery = "" }) {
                            Icon(Icons.Rounded.Close, contentDescription = "清空搜索")
                        }
                    }
                },
                singleLine = true,
                shape = RoundedCornerShape(16.dp)
            )
            androidx.compose.foundation.lazy.LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 14.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(groups) { group ->
                    FilterChip(
                        selected = selectedGroup == group,
                        onClick = { selectedGroup = group },
                        label = { Text(group) }
                    )
                }
            }
            Row(
                Modifier.fillMaxWidth().padding(horizontal = 18.dp, vertical = 2.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("页面目录", color = GalleryInk, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                Spacer(Modifier.weight(1f))
                Text("显示 ${visible.size} / ${previewRoutes.size}", color = GalleryMuted, fontSize = 10.sp)
            }
            if (visible.isEmpty()) {
                Column(
                    Modifier.fillMaxWidth().weight(1f).padding(30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(Icons.Rounded.SearchOff, contentDescription = null, tint = GalleryMuted, modifier = Modifier.size(38.dp))
                    Spacer(Modifier.height(10.dp))
                    Text("没有找到匹配页面", color = GalleryInk, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                    Text("试试其他关键词或切换业务模块", color = GalleryMuted, fontSize = 11.sp)
                }
            } else {
                LazyColumn(
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 4.dp, bottom = 28.dp),
                    verticalArrangement = Arrangement.spacedBy(9.dp)
                ) {
                    items(visible) { page ->
                    Surface(
                        color = Color.White,
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier.fillMaxWidth().clickable { selectedPage = page }
                    ) {
                        Row(Modifier.padding(14.dp), verticalAlignment = Alignment.CenterVertically) {
                            Box(Modifier.size(42.dp).clip(RoundedCornerShape(13.dp)).background(GalleryPale), contentAlignment = Alignment.Center) {
                                Icon(Icons.Rounded.PhoneAndroid, null, tint = GalleryViolet)
                            }
                            Spacer(Modifier.width(12.dp))
                            Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(3.dp)) {
                                Text(page.name, color = GalleryInk, fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
                                Text("${page.group} · ${page.description}", color = GalleryMuted, fontSize = 10.sp)
                            }
                            Icon(Icons.Rounded.ChevronRight, null, tint = GalleryMuted)
                        }
                    }
                }
                }
            }
        } else {
            Row(
                Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { selectedPage = null }) { Icon(Icons.Rounded.ArrowBack, "返回") }
                Column {
                    Text(selectedPage!!.name, color = GalleryInk, fontWeight = FontWeight.Bold)
                    Text(selectedPage!!.description, color = GalleryMuted, fontSize = 10.sp)
                }
            }
            HighFidelityScreen(selectedPage!!.name)
        }
    }
}

@Composable
private fun ScreenMockup(route: PreviewRoute) {
    Column(
        Modifier.fillMaxSize().padding(horizontal = 18.dp, vertical = 8.dp)
            .clip(RoundedCornerShape(28.dp)).background(Color.White).padding(18.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Text("AniMate", color = GalleryViolet, fontSize = 10.sp, fontWeight = FontWeight.Bold)
        Text(route.name, color = GalleryInk, fontSize = 23.sp, fontWeight = FontWeight.Bold)
        Surface(color = GalleryPale, shape = RoundedCornerShape(20.dp), modifier = Modifier.fillMaxWidth()) {
            Column(Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(route.group.uppercase(), color = GalleryViolet, fontSize = 9.sp, fontWeight = FontWeight.Bold)
                Text(route.description, color = GalleryInk, fontSize = 17.sp, fontWeight = FontWeight.SemiBold)
                Text("这是 ${route.name} 的独立页面预览入口。", color = GalleryMuted, fontSize = 11.sp)
            }
        }
        repeat(3) { index ->
            Surface(color = GalleryBg, shape = RoundedCornerShape(16.dp), modifier = Modifier.fillMaxWidth()) {
                Row(Modifier.padding(14.dp), verticalAlignment = Alignment.CenterVertically) {
                    Box(Modifier.size(44.dp).clip(RoundedCornerShape(12.dp)).background(GalleryPale), contentAlignment = Alignment.Center) {
                        Icon(Icons.Rounded.AutoAwesome, null, tint = GalleryViolet)
                    }
                    Spacer(Modifier.width(12.dp))
                    Column(Modifier.weight(1f)) {
                        Text(listOf("页面内容区域", "信息与操作区域", "辅助信息区域")[index], color = GalleryInk, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                        Text("使用本地 UI 展示数据，不请求后端接口", color = GalleryMuted, fontSize = 10.sp)
                    }
                    Icon(Icons.Rounded.ChevronRight, null, tint = GalleryMuted)
                }
            }
        }
        Spacer(Modifier.weight(1f))
        Button(onClick = {}, modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(14.dp)) {
            Text("页面操作预览")
        }
    }
}

@Preview(name = "Preview Gallery", showBackground = true, widthDp = 393, heightDp = 852)
@Composable
fun PreviewGalleryPreview() {
    MaterialTheme(colorScheme = lightColorScheme(primary = GalleryViolet, background = GalleryBg)) {
        PreviewGallery()
    }
}
