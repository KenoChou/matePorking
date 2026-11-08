package com.kenochou.mateporking.ui.preview

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

private val PagePreviewPrimary = androidx.compose.ui.graphics.Color(0xFF7866D8)

@Composable
private fun ActualPagePreview(pageName: String) {
    MaterialTheme(colorScheme = lightColorScheme(primary = PagePreviewPrimary)) {
        HighFidelityScreen(pageName)
    }
}

@Preview(name = "01 欢迎页", showBackground = true, widthDp = 393, heightDp = 852)
@Composable
fun WelcomePreview() = ActualPagePreview("欢迎页")

@Preview(name = "02 手机号登录", showBackground = true, widthDp = 393, heightDp = 852)
@Composable
fun PhoneLoginPreview() = ActualPagePreview("手机号登录")

@Preview(name = "03 验证码验证", showBackground = true, widthDp = 393, heightDp = 852)
@Composable
fun VerificationCodePreview() = ActualPagePreview("验证码验证")

@Preview(name = "04 Discover 首页", showBackground = true, widthDp = 393, heightDp = 852)
@Composable
fun DiscoverHomePreview() = ActualPagePreview("Discover 首页")

@Preview(name = "05 趋势发现", showBackground = true, widthDp = 393, heightDp = 852)
@Composable
fun TrendingPreview() = ActualPagePreview("趋势发现")

@Preview(name = "06 搜索", showBackground = true, widthDp = 393, heightDp = 852)
@Composable
fun SearchPreview() = ActualPagePreview("搜索")

@Preview(name = "07 内容详情", showBackground = true, widthDp = 393, heightDp = 852)
@Composable
fun ContentDetailPreview() = ActualPagePreview("内容详情")

@Preview(name = "08 圈子发现", showBackground = true, widthDp = 393, heightDp = 852)
@Composable
fun CircleDiscoveryPreview() = ActualPagePreview("圈子发现")

@Preview(name = "09 圈子详情", showBackground = true, widthDp = 393, heightDp = 852)
@Composable
fun CircleDetailPreview() = ActualPagePreview("圈子详情")

@Preview(name = "10 圈子成员", showBackground = true, widthDp = 393, heightDp = 852)
@Composable
fun CircleMembersPreview() = ActualPagePreview("圈子成员")

@Preview(name = "11 商城首页", showBackground = true, widthDp = 393, heightDp = 852)
@Composable
fun ShopHomePreview() = ActualPagePreview("商城首页")

@Preview(name = "12 商品分类", showBackground = true, widthDp = 393, heightDp = 852)
@Composable
fun ProductCategoriesPreview() = ActualPagePreview("商品分类")

@Preview(name = "13 商品详情", showBackground = true, widthDp = 393, heightDp = 852)
@Composable
fun ProductDetailPreview() = ActualPagePreview("商品详情")

@Preview(name = "14 购物车", showBackground = true, widthDp = 393, heightDp = 852)
@Composable
fun ShoppingCartPreview() = ActualPagePreview("购物车")

@Preview(name = "15 订单列表", showBackground = true, widthDp = 393, heightDp = 852)
@Composable
fun OrderListPreview() = ActualPagePreview("订单列表")

@Preview(name = "16 订单详情", showBackground = true, widthDp = 393, heightDp = 852)
@Composable
fun OrderDetailPreview() = ActualPagePreview("订单详情")

@Preview(name = "17 支付结果", showBackground = true, widthDp = 393, heightDp = 852)
@Composable
fun PaymentResultPreview() = ActualPagePreview("支付结果")

@Preview(name = "18 会话列表", showBackground = true, widthDp = 393, heightDp = 852)
@Composable
fun ConversationListPreview() = ActualPagePreview("会话列表")

@Preview(name = "19 聊天详情", showBackground = true, widthDp = 393, heightDp = 852)
@Composable
fun ChatDetailPreview() = ActualPagePreview("聊天详情")

@Preview(name = "20 互动通知", showBackground = true, widthDp = 393, heightDp = 852)
@Composable
fun ActivityNotificationsPreview() = ActualPagePreview("互动通知")

@Preview(name = "21 个人主页", showBackground = true, widthDp = 393, heightDp = 852)
@Composable
fun ProfilePreview() = ActualPagePreview("个人主页")

@Preview(name = "22 编辑资料", showBackground = true, widthDp = 393, heightDp = 852)
@Composable
fun EditProfilePreview() = ActualPagePreview("编辑资料")

@Preview(name = "23 我的收藏", showBackground = true, widthDp = 393, heightDp = 852)
@Composable
fun FavoritesPreview() = ActualPagePreview("我的收藏")

@Preview(name = "24 设置", showBackground = true, widthDp = 393, heightDp = 852)
@Composable
fun SettingsPreview() = ActualPagePreview("设置")

@Preview(name = "25 创作者中心", showBackground = true, widthDp = 393, heightDp = 852)
@Composable
fun CreatorCenterPreview() = ActualPagePreview("创作者中心")

@Preview(name = "26 作品管理", showBackground = true, widthDp = 393, heightDp = 852)
@Composable
fun WorkManagementPreview() = ActualPagePreview("作品管理")

@Preview(name = "27 创作数据", showBackground = true, widthDp = 393, heightDp = 852)
@Composable
fun CreatorAnalyticsPreview() = ActualPagePreview("创作数据")

@Preview(name = "28 商家中心", showBackground = true, widthDp = 393, heightDp = 852)
@Composable
fun MerchantCenterPreview() = ActualPagePreview("商家中心")

@Preview(name = "29 商品管理", showBackground = true, widthDp = 393, heightDp = 852)
@Composable
fun ProductManagementPreview() = ActualPagePreview("商品管理")

@Preview(name = "30 店铺管理", showBackground = true, widthDp = 393, heightDp = 852)
@Composable
fun StoreManagementPreview() = ActualPagePreview("店铺管理")

@Preview(name = "31 活动列表", showBackground = true, widthDp = 393, heightDp = 852)
@Composable
fun EventListPreview() = ActualPagePreview("活动列表")

@Preview(name = "32 活动详情", showBackground = true, widthDp = 393, heightDp = 852)
@Composable
fun EventDetailPreview() = ActualPagePreview("活动详情")

@Preview(name = "33 活动报名", showBackground = true, widthDp = 393, heightDp = 852)
@Composable
fun EventRegistrationPreview() = ActualPagePreview("活动报名")

@Preview(name = "34 我的电子票", showBackground = true, widthDp = 393, heightDp = 852)
@Composable
fun MyTicketsPreview() = ActualPagePreview("我的电子票")

