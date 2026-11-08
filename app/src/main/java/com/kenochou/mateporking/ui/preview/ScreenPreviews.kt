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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Ink = Color(0xFF242332)
private val Muted = Color(0xFF888696)
private val Canvas = Color(0xFFF8F7FB)
private val Violet = Color(0xFF7866D8)
private val Pale = Color(0xFFEDE9FF)
private val Line = Color(0xFFF0EEF4)

@Composable
private fun PreviewPage(
    title: String,
    eyebrow: String = "ANIMATE",
    description: String,
    rows: List<String> = listOf("为你推荐", "最近更新", "热门内容"),
    action: String = "查看全部",
    showBottom: Boolean = false
) {
    Scaffold(
        containerColor = Canvas,
        topBar = {
            Row(
                Modifier.fillMaxWidth().background(Color.White).padding(horizontal = 20.dp, vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(Modifier.weight(1f)) {
                    Text(eyebrow, color = Violet, fontSize = 9.sp, fontWeight = FontWeight.Bold, letterSpacing = 1.4.sp)
                    Text(title, color = Ink, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                }
                IconButton(onClick = {}) { Icon(Icons.Rounded.Search, contentDescription = "搜索", tint = Ink) }
                IconButton(onClick = {}) { Icon(Icons.Rounded.MoreHoriz, contentDescription = "更多", tint = Ink) }
            }
        },
        bottomBar = {
            if (showBottom) {
                NavigationBar(containerColor = Color.White) {
                    listOf("发现", "圈子", "商城", "消息", "我的").forEachIndexed { index, label ->
                        val icons = listOf(Icons.Rounded.Explore, Icons.Rounded.Groups, Icons.Rounded.ShoppingBag, Icons.Rounded.ChatBubbleOutline, Icons.Rounded.PersonOutline)
                        NavigationBarItem(
                            selected = index == 0,
                            onClick = {},
                            icon = { Icon(icons[index], contentDescription = label) },
                            label = { Text(label, fontSize = 9.sp) }
                        )
                    }
                }
            }
        }
    ) { padding ->
        LazyColumn(
            Modifier.fillMaxSize().padding(padding),
            contentPadding = PaddingValues(20.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            item {
                Surface(color = Pale, shape = RoundedCornerShape(22.dp), modifier = Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Text("YOUR INTEREST, YOUR WORLD", color = Violet, fontSize = 9.sp, fontWeight = FontWeight.Bold, letterSpacing = 1.sp)
                        Text(description, color = Ink, fontSize = 20.sp, fontWeight = FontWeight.Bold, lineHeight = 27.sp)
                        Surface(color = Violet, shape = RoundedCornerShape(30.dp)) {
                            Text(action, color = Color.White, fontSize = 11.sp, modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp))
                        }
                    }
                }
            }
            item {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("精选内容", color = Ink, fontSize = 17.sp, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
                    Text("更多", color = Violet, fontSize = 11.sp)
                }
            }
            items(rows) { row ->
                Surface(color = Color.White, shape = RoundedCornerShape(18.dp), modifier = Modifier.fillMaxWidth()) {
                    Row(Modifier.padding(14.dp), verticalAlignment = Alignment.CenterVertically) {
                        Box(Modifier.size(58.dp).clip(RoundedCornerShape(14.dp)).background(Pale), contentAlignment = Alignment.Center) {
                            Icon(Icons.Rounded.AutoAwesome, null, tint = Violet, modifier = Modifier.size(24.dp))
                        }
                        Spacer(Modifier.width(12.dp))
                        Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(5.dp)) {
                            Text(row, color = Ink, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                            Text("探索热爱，发现更多有趣的人和作品", color = Muted, fontSize = 10.sp, maxLines = 2, overflow = TextOverflow.Ellipsis)
                        }
                        Icon(Icons.Rounded.ChevronRight, null, tint = Muted)
                    }
                }
            }
        }
    }
}

@Composable
private fun FormPreview(title: String, description: String, primary: String = "继续") {
    Column(
        Modifier.fillMaxSize().background(Color.White).padding(horizontal = 26.dp, vertical = 36.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("AniMate", color = Violet, fontSize = 14.sp, fontWeight = FontWeight.ExtraBold)
        Spacer(Modifier.height(38.dp))
        Text(title, color = Ink, fontSize = 29.sp, fontWeight = FontWeight.Bold)
        Text(description, color = Muted, fontSize = 13.sp)
        OutlinedTextField(value = "", onValueChange = {}, modifier = Modifier.fillMaxWidth(), label = { Text("手机号 / 验证码") }, shape = RoundedCornerShape(14.dp), singleLine = true)
        Button(onClick = {}, modifier = Modifier.fillMaxWidth().height(52.dp), shape = RoundedCornerShape(15.dp)) { Text(primary) }
        Text("继续即表示你同意用户协议与隐私政策", color = Muted, fontSize = 10.sp)
    }
}

@Preview(name = "01 Welcome", showBackground = true, widthDp = 393, heightDp = 852)
@Composable fun WelcomePreview() { FormPreview("让热爱连接彼此", "发现兴趣、分享创作，和同好一起构建属于你的兴趣宇宙。", "开启 AniMate") }

@Preview(name = "02 Phone Login", showBackground = true, widthDp = 393, heightDp = 852)
@Composable fun PhoneLoginPreview() { FormPreview("欢迎回来", "输入手机号，使用验证码安全登录。", "获取验证码") }

@Preview(name = "03 SMS Code", showBackground = true, widthDp = 393, heightDp = 852)
@Composable fun SmsCodePreview() { FormPreview("输入验证码", "验证码已发送至你填写的手机号，请查收。", "验证并登录") }

@Preview(name = "04 Discover", showBackground = true, widthDp = 393, heightDp = 852)
@Composable fun DiscoverPreview() { PreviewPage("发现", description = "每一种热爱，都值得被看见。", showBottom = true) }

@Preview(name = "05 Trending", showBackground = true, widthDp = 393, heightDp = 852)
@Composable fun TrendingPreview() { PreviewPage("趋势发现", "TRENDING", "看看此刻大家正在热爱什么。", listOf("本周热门作品", "人气兴趣话题", "创作者精选")) }

@Preview(name = "06 Search", showBackground = true, widthDp = 393, heightDp = 852)
@Composable fun SearchPreview() { PreviewPage("搜索", "EXPLORE", "搜索作品、用户、圈子与商品。", listOf("热门搜索：动漫周边", "热门搜索：原创插画", "热门搜索：手办收藏")) }

@Preview(name = "07 Content Detail", showBackground = true, widthDp = 393, heightDp = 852)
@Composable fun ContentDetailPreview() { PreviewPage("作品详情", "CONTENT", "一份创作，一次关于热爱的表达。", listOf("作品介绍", "评论与讨论", "相关推荐"), "发表评论") }

@Preview(name = "08 Community", showBackground = true, widthDp = 393, heightDp = 852)
@Composable fun CommunityPreview() { PreviewPage("兴趣圈子", "COMMUNITY", "找到同好，让兴趣不再孤单。", listOf("热门圈子", "新晋圈子", "为你推荐"), showBottom = true) }

@Preview(name = "09 Circle Detail", showBackground = true, widthDp = 393, heightDp = 852)
@Composable fun CircleDetailPreview() { PreviewPage("圈子详情", "CIRCLE", "在这里分享作品、交流想法、认识同好。", listOf("圈子动态", "精华帖子", "圈子公告"), "加入圈子") }

@Preview(name = "10 Circle Members", showBackground = true, widthDp = 393, heightDp = 852)
@Composable fun CircleMembersPreview() { PreviewPage("圈子成员", "MEMBERS", "认识与你拥有相同兴趣的人。", listOf("圈主 · 用户 01", "管理员 · 用户 02", "成员 · 用户 03")) }

@Preview(name = "11 Market", showBackground = true, widthDp = 393, heightDp = 852)
@Composable fun MarketPreview() { PreviewPage("兴趣商城", "MARKET", "把喜欢带回家。", listOf("人气周边", "创作者原创", "新品上架"), showBottom = true) }

@Preview(name = "12 Categories", showBackground = true, widthDp = 393, heightDp = 852)
@Composable fun CategoriesPreview() { PreviewPage("商品分类", "CATEGORIES", "按兴趣探索精选商品。", listOf("手办模型", "服饰配件", "艺术画作", "文创周边")) }

@Preview(name = "13 Product Detail", showBackground = true, widthDp = 393, heightDp = 852)
@Composable fun ProductDetailPreview() { PreviewPage("商品详情", "PRODUCT", "精选作品与周边，让热爱触手可及。", listOf("商品规格", "创作者与店铺", "评价与售后"), "加入购物车") }

@Preview(name = "14 Cart", showBackground = true, widthDp = 393, heightDp = 852)
@Composable fun CartPreview() { PreviewPage("购物车", "CART", "确认心仪商品，准备下单。", listOf("商品与规格", "配送方式", "价格明细"), "去结算") }

@Preview(name = "15 Orders", showBackground = true, widthDp = 393, heightDp = 852)
@Composable fun OrdersPreview() { PreviewPage("我的订单", "ORDERS", "查看每一笔交易的进度。", listOf("待付款订单", "待发货订单", "已完成订单")) }

@Preview(name = "16 Order Detail", showBackground = true, widthDp = 393, heightDp = 852)
@Composable fun OrderDetailPreview() { PreviewPage("订单详情", "ORDER", "订单状态与商品信息一目了然。", listOf("订单状态", "商品信息", "收货信息", "支付信息")) }

@Preview(name = "17 Payment Result", showBackground = true, widthDp = 393, heightDp = 852)
@Composable fun PaymentResultPreview() { PreviewPage("支付结果", "PAYMENT", "支付完成后展示订单处理状态。", listOf("支付金额", "订单编号", "查看订单"), "返回订单") }

@Preview(name = "18 Conversations", showBackground = true, widthDp = 393, heightDp = 852)
@Composable fun ConversationsPreview() { PreviewPage("消息", "MESSAGES", "与你关注的人保持联系。", listOf("会话 · 创作交流", "会话 · 兴趣同好", "会话 · 圈子通知"), showBottom = true) }

@Preview(name = "19 Chat Detail", showBackground = true, widthDp = 393, heightDp = 852)
@Composable fun ChatDetailPreview() { PreviewPage("聊天详情", "CHAT", "分享作品、图片与日常。", listOf("对方：最近发现一位很棒的创作者", "我：可以分享给我看看吗？", "对方：当然可以")) }

@Preview(name = "20 Notifications", showBackground = true, widthDp = 393, heightDp = 852)
@Composable fun NotificationsPreview() { PreviewPage("互动通知", "NOTIFICATIONS", "关注、评论、点赞与系统消息。", listOf("有人关注了你", "你的作品收到新评论", "圈子有新的活动")) }

@Preview(name = "21 Profile", showBackground = true, widthDp = 393, heightDp = 852)
@Composable fun ProfilePreview() { PreviewPage("个人主页", "PROFILE", "管理个人资料，展示你的兴趣与收藏。", listOf("我的作品", "我的收藏", "我的订单", "账号与设置"), showBottom = true) }

@Preview(name = "22 Edit Profile", showBackground = true, widthDp = 393, heightDp = 852)
@Composable fun EditProfilePreview() { FormPreview("编辑资料", "完善昵称、头像、个人简介与兴趣标签。", "保存资料") }

@Preview(name = "23 Favorites", showBackground = true, widthDp = 393, heightDp = 852)
@Composable fun FavoritesPreview() { PreviewPage("我的收藏", "FAVORITES", "收藏喜欢的内容与商品。", listOf("收藏的作品", "收藏的商品", "收藏的圈子")) }

@Preview(name = "24 Settings", showBackground = true, widthDp = 393, heightDp = 852)
@Composable fun SettingsPreview() { PreviewPage("设置", "SETTINGS", "管理账号、安全、通知与应用偏好。", listOf("账号与安全", "消息通知", "隐私设置", "关于 AniMate")) }

@Preview(name = "25 Creator Home", showBackground = true, widthDp = 393, heightDp = 852)
@Composable fun CreatorHomePreview() { PreviewPage("创作者中心", "CREATOR", "管理作品，了解创作表现。", listOf("创作者资料", "作品管理", "数据概览"), "管理作品") }

@Preview(name = "26 Creator Works", showBackground = true, widthDp = 393, heightDp = 852)
@Composable fun CreatorWorksPreview() { PreviewPage("作品管理", "CREATOR STUDIO", "管理已发布与草稿作品。", listOf("已发布作品", "草稿箱", "内容审核状态")) }

@Preview(name = "27 Creator Analytics", showBackground = true, widthDp = 393, heightDp = 852)
@Composable fun CreatorAnalyticsPreview() { PreviewPage("创作数据", "ANALYTICS", "关注作品浏览、互动与粉丝变化。", listOf("作品浏览趋势", "互动数据", "粉丝增长")) }

@Preview(name = "28 Merchant Home", showBackground = true, widthDp = 393, heightDp = 852)
@Composable fun MerchantHomePreview() { PreviewPage("商家中心", "MERCHANT", "管理店铺、商品与经营订单。", listOf("店铺资料", "商品管理", "经营订单")) }

@Preview(name = "29 Product Management", showBackground = true, widthDp = 393, heightDp = 852)
@Composable fun ProductManagementPreview() { PreviewPage("商品管理", "MERCHANT", "维护商品信息、库存与上下架状态。", listOf("在售商品", "仓库商品", "新增商品"), "新增商品") }

@Preview(name = "30 Shop Management", showBackground = true, widthDp = 393, heightDp = 852)
@Composable fun ShopManagementPreview() { PreviewPage("店铺管理", "SHOP", "管理店铺展示、配送与售后设置。", listOf("店铺主页", "配送设置", "售后政策")) }

@Preview(name = "31 Events", showBackground = true, widthDp = 393, heightDp = 852)
@Composable fun EventsPreview() { PreviewPage("兴趣活动", "EVENTS", "发现展会、线下聚会与兴趣活动。", listOf("近期活动", "热门展会", "线上活动")) }

@Preview(name = "32 Event Detail", showBackground = true, widthDp = 393, heightDp = 852)
@Composable fun EventDetailPreview() { PreviewPage("活动详情", "EVENT", "查看活动介绍、时间、地点与日程。", listOf("活动介绍", "活动日程", "举办地点"), "立即报名") }

@Preview(name = "33 Registration", showBackground = true, widthDp = 393, heightDp = 852)
@Composable fun RegistrationPreview() { FormPreview("活动报名", "确认参与人信息与报名场次。", "提交报名") }

@Preview(name = "34 My Tickets", showBackground = true, widthDp = 393, heightDp = 852)
@Composable fun MyTicketsPreview() { PreviewPage("我的电子票", "TICKETS", "集中查看活动门票与核验状态。", listOf("待使用门票", "已核验门票", "历史活动")) }
