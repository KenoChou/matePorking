package com.kenochou.mateporking.ui.preview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val XInk = Color(0xFF242332)
private val XMuted = Color(0xFF898795)
private val XBg = Color(0xFFF8F7FB)
private val XAccent = Color(0xFF7866D8)
private val XPale = Color(0xFFEDE9FF)

@Composable
fun SecondaryPreviewScreen(name: String) {
    when (name) {
        "趋势发现" -> SecondaryPage(name, "兴趣正在发生。", listOf("原创插画挑战", "模型收藏分享", "动漫角色再创作", "周末兴趣市集"))
        "搜索" -> SecondaryPage(name, "搜索作品、用户、圈子与商品", listOf("热门搜索：原创插画", "动漫周边", "手办收藏", "兴趣市集"))
        "内容详情" -> SecondaryPage(name, "把喜欢的角色，画成自己的故事。", listOf("作者：纸上星河", "作品介绍", "评论：配色真的好温柔！", "评论：期待下一组作品"))
        "圈子发现" -> SecondaryPage(name, "兴趣相同的人，终会相遇。", listOf("原创插画交流社", "模型收藏研究所", "动漫同好会", "独立游戏玩家"))
        "圈子成员" -> SecondaryPage(name, "认识与你拥有相同兴趣的人。", listOf("圈主 · 星河", "管理员 · 小满", "成员 · 纸上风景", "成员 · 蓝色星期天"))
        "商城首页" -> SecondaryPage(name, "把喜欢，带回家。", listOf("星月系列原创摆件 · ¥128", "原创插画收藏卡 · ¥36", "艺术周边礼盒 · ¥88"))
        "商品分类" -> SecondaryPage(name, "按兴趣探索精选商品。", listOf("手办模型", "服饰配件", "原创插画", "文创周边", "收藏卡牌"))
        "订单列表" -> SecondaryPage(name, "查看每一笔交易的进度。", listOf("待付款 · 星月系列摆件", "待发货 · 原创收藏卡", "已完成 · 艺术周边礼盒"))
        "支付结果" -> SecondaryPage(name, "支付成功 · ¥128.00", listOf("订单编号 · AM202600001", "支付方式 · 在线支付", "查看订单"))
        "会话列表" -> SecondaryPage(name, "与你关注的人保持联系。", listOf("纸上星河 · 这组作品配色很特别", "原创插画交流社 · 新的圈子动态", "AniMate 官方通知 · 欢迎加入"))
        "互动通知" -> SecondaryPage(name, "关注、评论、点赞与系统消息。", listOf("收到新的点赞", "作品收到评论", "新增关注", "圈子活动提醒"))
        "编辑资料" -> SecondaryPage(name, "完善你的个人资料。", listOf("头像 · 更换头像", "昵称 · AniMate 用户", "个人简介 · 让热爱连接彼此", "兴趣标签 · 动漫、插画、收藏"))
        "我的收藏" -> SecondaryPage(name, "收藏喜欢的内容与商品。", listOf("作品 · 星河之间", "商品 · 星月系列原创摆件", "圈子 · 原创插画交流社"))
        "设置" -> SecondaryPage(name, "管理账号、安全、通知与偏好。", listOf("账号与安全", "个人隐私", "消息通知", "通用设置", "用户协议"))
        "作品管理" -> SecondaryPage(name, "管理已发布与草稿作品。", listOf("星月之间 · 已发布", "日常灵感记录 · 已发布", "角色练习稿 · 草稿", "发布新作品"))
        "创作数据" -> SecondaryPage(name, "创作表现 · 近 7 天", listOf("作品浏览量 · 12,860", "点赞互动 · 860", "评论互动 · 126", "新增粉丝 · 94"))
        "商品管理" -> SecondaryPage(name, "维护商品信息、库存与上下架状态。", listOf("星月系列摆件 · 库存 32 · ¥128", "原创收藏卡 · 库存 25 · ¥36", "艺术周边礼盒 · 库存 18 · ¥88"))
        "店铺管理" -> SecondaryPage(name, "管理店铺展示、配送与售后设置。", listOf("AniMate 原创商店", "店铺基础资料", "店铺首页装修", "配送与运费", "退换货政策"))
        "活动列表" -> SecondaryPage(name, "让兴趣从线上，走进真实生活。", listOf("AniMate 兴趣创作交流日 · 11 月 28 日", "原创艺术周末市集 · 12 月 06 日", "模型收藏主题聚会 · 12 月 12 日"))
        "活动报名" -> SecondaryPage(name, "确认参与人信息与报名场次。", listOf("参与人姓名 · 请输入姓名", "联系电话 · 请输入手机号", "报名场次 · 下午场", "参与人数 · 1 人"))
        "我的电子票" -> SecondaryPage(name, "集中查看活动门票与核验状态。", listOf("创作交流日 · 待使用 · AM-TICKET-001", "原创艺术市集 · 已核验 · AM-TICKET-002"))
        else -> SecondaryPage(name, "本地静态 UI 展示，不请求后端接口。", listOf("主要内容", "详细信息", "相关操作"))
    }
}

@Composable
private fun SecondaryPage(title: String, headline: String, rows: List<String>) {
    Column(Modifier.fillMaxSize().background(XBg).padding(18.dp), verticalArrangement = Arrangement.spacedBy(13.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.weight(1f)) {
                Text("ANIMATE", color = XAccent, fontSize = 9.sp, fontWeight = FontWeight.Bold, letterSpacing = 1.2.sp)
                Text(title, color = XInk, fontSize = 23.sp, fontWeight = FontWeight.Bold)
            }
            IconButton(onClick = {}) { Icon(Icons.Rounded.MoreHoriz, contentDescription = "更多", tint = XInk) }
        }
        Surface(color = XPale, shape = RoundedCornerShape(20.dp), modifier = Modifier.fillMaxWidth()) {
            Column(Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(7.dp)) {
                Text(title.uppercase(), color = XAccent, fontSize = 9.sp, fontWeight = FontWeight.Bold)
                Text(headline, color = XInk, fontSize = 19.sp, fontWeight = FontWeight.Bold)
                Text("AniMate · 兴趣社区与创作者生态", color = XMuted, fontSize = 10.sp)
            }
        }
        rows.forEachIndexed { position, item ->
            Surface(color = Color.White, shape = RoundedCornerShape(16.dp), modifier = Modifier.fillMaxWidth()) {
                Row(Modifier.padding(14.dp), verticalAlignment = Alignment.CenterVertically) {
                    Box(Modifier.size(42.dp).background(XPale, RoundedCornerShape(13.dp)), contentAlignment = Alignment.Center) {
                        Icon(
                            when {
                                title.contains("消息") || title.contains("会话") -> Icons.Rounded.ChatBubbleOutline
                                title.contains("活动") || title.contains("电子票") -> Icons.Rounded.Event
                                title.contains("订单") || title.contains("支付") -> Icons.Rounded.Receipt
                                title.contains("圈子") || title.contains("成员") -> Icons.Rounded.Groups
                                title.contains("商品") || title.contains("商城") -> Icons.Rounded.ShoppingBag
                                title.contains("设置") -> Icons.Rounded.Settings
                                else -> Icons.Rounded.AutoAwesome
                            },
                            contentDescription = null,
                            tint = XAccent
                        )
                    }
                    Spacer(Modifier.width(12.dp))
                    Text(item, color = XInk, fontSize = 12.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.weight(1f))
                    Icon(Icons.Rounded.ChevronRight, contentDescription = null, tint = XMuted)
                }
            }
        }
        if (title == "编辑资料" || title == "活动报名" || title == "作品管理" || title == "商品管理") {
            Spacer(Modifier.weight(1f))
            Button(onClick = {}, modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(14.dp)) {
                Text(when (title) {
                    "编辑资料" -> "保存资料"
                    "活动报名" -> "确认报名"
                    "作品管理" -> "发布新作品"
                    else -> "新增商品"
                })
            }
        }
    }
}
