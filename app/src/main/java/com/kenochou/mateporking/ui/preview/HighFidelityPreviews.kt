package com.kenochou.mateporking.ui.preview

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

private val PagePreviewColors = lightColorScheme(
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
private fun ActualPagePreview(pageName: String) {
    MaterialTheme(colorScheme = PagePreviewColors) {
        HighFidelityScreen(pageName)
    }
}

@Preview(name = "01 欢迎页", showBackground = true, showSystemUi = true, widthDp = 393, heightDp = 852)
@Composable
fun HighFidelityWelcomePreview() = ActualPagePreview("欢迎页")

@Preview(name = "02 手机号登录", showBackground = true, showSystemUi = true, widthDp = 393, heightDp = 852)
@Composable
fun HighFidelityPhoneLoginPreview() = ActualPagePreview("手机号登录")

@Preview(name = "03 验证码验证", showBackground = true, showSystemUi = true, widthDp = 393, heightDp = 852)
@Composable
fun HighFidelityVerificationCodePreview() = ActualPagePreview("验证码验证")

@Preview(name = "04 Discover 首页", showBackground = true, showSystemUi = true, widthDp = 393, heightDp = 852)
@Composable
fun HighFidelityDiscoverHomePreview() = ActualPagePreview("Discover 首页")

@Preview(name = "05 趋势发现", showBackground = true, showSystemUi = true, widthDp = 393, heightDp = 852)
@Composable
fun HighFidelityTrendingPreview() = ActualPagePreview("趋势发现")

@Preview(name = "06 搜索", showBackground = true, showSystemUi = true, widthDp = 393, heightDp = 852)
@Composable
fun HighFidelitySearchPreview() = ActualPagePreview("搜索")

@Preview(name = "07 内容详情", showBackground = true, showSystemUi = true, widthDp = 393, heightDp = 852)
@Composable
fun HighFidelityContentDetailPreview() = ActualPagePreview("内容详情")

@Preview(name = "08 圈子发现", showBackground = true, showSystemUi = true, widthDp = 393, heightDp = 852)
@Composable
fun HighFidelityCircleDiscoveryPreview() = ActualPagePreview("圈子发现")

@Preview(name = "09 圈子详情", showBackground = true, showSystemUi = true, widthDp = 393, heightDp = 852)
@Composable
fun HighFidelityCircleDetailPreview() = ActualPagePreview("圈子详情")

@Preview(name = "10 圈子成员", showBackground = true, showSystemUi = true, widthDp = 393, heightDp = 852)
@Composable
fun HighFidelityCircleMembersPreview() = ActualPagePreview("圈子成员")

@Preview(name = "11 商城首页", showBackground = true, showSystemUi = true, widthDp = 393, heightDp = 852)
@Composable
fun HighFidelityShopHomePreview() = ActualPagePreview("商城首页")

@Preview(name = "12 商品分类", showBackground = true, showSystemUi = true, widthDp = 393, heightDp = 852)
@Composable
fun HighFidelityProductCategoriesPreview() = ActualPagePreview("商品分类")

@Preview(name = "13 商品详情", showBackground = true, showSystemUi = true, widthDp = 393, heightDp = 852)
@Composable
fun HighFidelityProductDetailPreview() = ActualPagePreview("商品详情")

@Preview(name = "14 购物车", showBackground = true, showSystemUi = true, widthDp = 393, heightDp = 852)
@Composable
fun HighFidelityShoppingCartPreview() = ActualPagePreview("购物车")

@Preview(name = "15 订单列表", showBackground = true, showSystemUi = true, widthDp = 393, heightDp = 852)
@Composable
fun HighFidelityOrderListPreview() = ActualPagePreview("订单列表")

@Preview(name = "16 订单详情", showBackground = true, showSystemUi = true, widthDp = 393, heightDp = 852)
@Composable
fun HighFidelityOrderDetailPreview() = ActualPagePreview("订单详情")

@Preview(name = "17 支付结果", showBackground = true, showSystemUi = true, widthDp = 393, heightDp = 852)
@Composable
fun HighFidelityPaymentResultPreview() = ActualPagePreview("支付结果")

@Preview(name = "18 会话列表", showBackground = true, showSystemUi = true, widthDp = 393, heightDp = 852)
@Composable
fun HighFidelityConversationListPreview() = ActualPagePreview("会话列表")

@Preview(name = "19 聊天详情", showBackground = true, showSystemUi = true, widthDp = 393, heightDp = 852)
@Composable
fun HighFidelityChatDetailPreview() = ActualPagePreview("聊天详情")

@Preview(name = "20 互动通知", showBackground = true, showSystemUi = true, widthDp = 393, heightDp = 852)
@Composable
fun HighFidelityActivityNotificationsPreview() = ActualPagePreview("互动通知")

@Preview(name = "21 个人主页", showBackground = true, showSystemUi = true, widthDp = 393, heightDp = 852)
@Composable
fun HighFidelityProfilePreview() = ActualPagePreview("个人主页")

@Preview(name = "22 编辑资料", showBackground = true, showSystemUi = true, widthDp = 393, heightDp = 852)
@Composable
fun HighFidelityEditProfilePreview() = ActualPagePreview("编辑资料")

@Preview(name = "23 我的收藏", showBackground = true, showSystemUi = true, widthDp = 393, heightDp = 852)
@Composable
fun HighFidelityFavoritesPreview() = ActualPagePreview("我的收藏")

@Preview(name = "24 设置", showBackground = true, showSystemUi = true, widthDp = 393, heightDp = 852)
@Composable
fun HighFidelitySettingsPreview() = ActualPagePreview("设置")

@Preview(name = "25 创作者中心", showBackground = true, showSystemUi = true, widthDp = 393, heightDp = 852)
@Composable
fun HighFidelityCreatorCenterPreview() = ActualPagePreview("创作者中心")

@Preview(name = "26 作品管理", showBackground = true, showSystemUi = true, widthDp = 393, heightDp = 852)
@Composable
fun HighFidelityWorkManagementPreview() = ActualPagePreview("作品管理")

@Preview(name = "27 创作数据", showBackground = true, showSystemUi = true, widthDp = 393, heightDp = 852)
@Composable
fun HighFidelityCreatorAnalyticsPreview() = ActualPagePreview("创作数据")

@Preview(name = "28 商家中心", showBackground = true, showSystemUi = true, widthDp = 393, heightDp = 852)
@Composable
fun HighFidelityMerchantCenterPreview() = ActualPagePreview("商家中心")

@Preview(name = "29 商品管理", showBackground = true, showSystemUi = true, widthDp = 393, heightDp = 852)
@Composable
fun HighFidelityProductManagementPreview() = ActualPagePreview("商品管理")

@Preview(name = "30 店铺管理", showBackground = true, showSystemUi = true, widthDp = 393, heightDp = 852)
@Composable
fun HighFidelityStoreManagementPreview() = ActualPagePreview("店铺管理")

@Preview(name = "31 活动列表", showBackground = true, showSystemUi = true, widthDp = 393, heightDp = 852)
@Composable
fun HighFidelityEventListPreview() = ActualPagePreview("活动列表")

@Preview(name = "32 活动详情", showBackground = true, showSystemUi = true, widthDp = 393, heightDp = 852)
@Composable
fun HighFidelityEventDetailPreview() = ActualPagePreview("活动详情")

@Preview(name = "33 活动报名", showBackground = true, showSystemUi = true, widthDp = 393, heightDp = 852)
@Composable
fun HighFidelityEventRegistrationPreview() = ActualPagePreview("活动报名")

@Preview(name = "34 我的电子票", showBackground = true, showSystemUi = true, widthDp = 393, heightDp = 852)
@Composable
fun HighFidelityMyTicketsPreview() = ActualPagePreview("我的电子票")

