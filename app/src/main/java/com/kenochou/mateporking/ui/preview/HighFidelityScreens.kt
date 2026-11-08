package com.kenochou.mateporking.ui.preview

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val HInk = Color(0xFF302D35)
private val HMuted = Color(0xFF918B94)
private val HBg = Color(0xFFFAF8F5)
private val HPrimary = Color(0xFF8A789D)
private val HPale = Color(0xFFF0E9EE)
private val HCoral = Color(0xFFD9A6A5)

@Composable
fun HighFidelityScreen(name: String) {
    when (name) {
        "欢迎页" -> WelcomeScreen()
        "手机号登录" -> PhoneLoginScreen()
        "验证码验证" -> VerificationScreen()
        "圈子首页" -> CommunityFeedScreen()
        "商城首页" -> MarketHomeScreen()
        "会话列表" -> ConversationListScreen()
        "商品详情" -> ProductDetailScreen()
        "购物车" -> CartScreen()
        "订单详情" -> OrderDetailScreen()
        "聊天详情" -> ChatScreen()
        "个人主页" -> ProfileHomeScreen()
        "创作者中心" -> CreatorDashboardScreen()
        "商家中心" -> MerchantDashboardScreen()
        "活动详情" -> EventDetailScreen()
        "圈子详情" -> CircleDetailScreen()
        "Discover 首页" -> DiscoverHomeScreen()
        else -> SecondaryPreviewScreen(name)
    }
}


@Composable
private fun WelcomeScreen() {
    var showLogin by androidx.compose.runtime.remember { androidx.compose.runtime.mutableStateOf(false) }
    if (showLogin) {
        PhoneLoginScreen(onBack = { showLogin = false })
        return
    }
    Column(
        Modifier.fillMaxSize().background(HBg).padding(horizontal = 24.dp, vertical = 22.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(7.dp)) {
            Text("A N I M A T E", color = HPrimary, fontSize = 11.sp, fontWeight = FontWeight.Bold)
            Text("INTEREST, IN FULL COLOR.", color = HInk, fontSize = 10.sp, letterSpacing = 2.sp)
        }
        Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
            Box(
                Modifier.fillMaxWidth().height(310.dp).clip(RoundedCornerShape(30.dp))
                    .background(Color(0xFFF0E8E4))
            ) {
                Box(Modifier.fillMaxWidth(0.62f).height(210.dp).align(Alignment.TopEnd).padding(top = 18.dp, end = 14.dp)
                    .clip(RoundedCornerShape(topStart = 90.dp, topEnd = 24.dp, bottomEnd = 90.dp, bottomStart = 24.dp))
                    .background(Color(0xFFAFC7D8)))
                Box(Modifier.size(112.dp).align(Alignment.CenterEnd).offset(x = (-28).dp, y = 5.dp)
                    .clip(CircleShape).background(Color(0xFFF4D875)))
                Box(Modifier.size(72.dp).align(Alignment.TopStart).offset(x = 22.dp, y = 82.dp)
                    .clip(CircleShape).background(Color(0xFFE9AEBB)))
                Text("好きなもの\nぜんぶ！", color = Color(0xFF4C4650), fontSize = 31.sp, lineHeight = 37.sp,
                    fontWeight = FontWeight.Black, modifier = Modifier.align(Alignment.TopStart).padding(start = 24.dp, top = 24.dp))
                Text("♡", color = Color(0xFFFBF7F0), fontSize = 54.sp, modifier = Modifier.align(Alignment.CenterEnd).padding(end = 54.dp))
                Text("FAN CULTURE CLUB", color = Color(0xFF4C4650), fontSize = 9.sp, letterSpacing = 2.sp,
                    fontWeight = FontWeight.Bold, modifier = Modifier.align(Alignment.BottomStart).padding(start = 22.dp, bottom = 62.dp))
                Text("ANIME  /  ART  /  GOODS  /  FRIENDS", color = Color(0xFF716A70), fontSize = 8.sp, letterSpacing = 1.sp,
                    modifier = Modifier.align(Alignment.BottomStart).padding(start = 22.dp, bottom = 25.dp))
                Box(Modifier.align(Alignment.TopEnd).padding(top = 18.dp, end = 18.dp)
                    .clip(RoundedCornerShape(50)).background(Color(0xFFFAF8F5)).padding(horizontal = 12.dp, vertical = 7.dp)) {
                    Text("VOL. 01  ✳", color = HInk, fontSize = 9.sp, fontWeight = FontWeight.Bold)
                }
            }
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text("喜欢的东西，\n当然要大声安利。", color = HInk, fontSize = 28.sp, lineHeight = 38.sp, fontWeight = FontWeight.Black)
                Text("把收藏夹里的热爱，变成一起玩的人。", color = HMuted, fontSize = 12.sp, lineHeight = 19.sp)
            }
        }
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Button(
                onClick = { showLogin = true },
                modifier = Modifier.fillMaxWidth().height(54.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF514653))
            ) {
                Text("开始探索", color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                Spacer(Modifier.width(8.dp))
                Text("→", color = Color.White, fontSize = 16.sp)
            }
            Text("加入 AniMate，遇见与你同频的人。", color = HMuted, fontSize = 10.sp, modifier = Modifier.align(Alignment.CenterHorizontally))
        }
    }
}

@Composable
private fun PhoneLoginScreen(onBack: () -> Unit = {}) {
    var phone by androidx.compose.runtime.remember { androidx.compose.runtime.mutableStateOf("") }
    var agreed by androidx.compose.runtime.remember { androidx.compose.runtime.mutableStateOf(false) }
    var codeSent by androidx.compose.runtime.remember { androidx.compose.runtime.mutableStateOf(false) }
    if (codeSent) {
        VerificationScreen(phone = phone, onBack = { codeSent = false })
        return
    }
    Column(
        Modifier.fillMaxSize().background(HBg).padding(horizontal = 24.dp, vertical = 22.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(9.dp)) {
            TextButton(onClick = onBack, contentPadding = PaddingValues(horizontal = 0.dp, vertical = 4.dp)) {
                Text("← 返回", color = HMuted, fontSize = 11.sp)
            }
            Text("ANIMATE / JOIN THE CLUB", color = HPrimary, fontSize = 9.sp, fontWeight = FontWeight.Bold, letterSpacing = 1.3.sp)
            Text("嗨，欢迎回来。", color = HInk, fontSize = 28.sp, fontWeight = FontWeight.SemiBold)
            Text("用手机号登录，继续你的兴趣漫游。", color = HMuted, fontSize = 12.sp)
        }
        Column(verticalArrangement = Arrangement.spacedBy(18.dp)) {
            Box(
                Modifier.fillMaxWidth().height(142.dp).clip(RoundedCornerShape(24.dp))
                    .background(Color(0xFFE8EEF0))
            ) {
                Box(Modifier.size(116.dp).align(Alignment.CenterEnd).offset(x = (-22).dp)
                    .clip(CircleShape).background(Color(0xFFF3D36F)))
                Box(Modifier.size(72.dp).align(Alignment.TopEnd).offset(x = (-76).dp, y = 13.dp)
                    .clip(CircleShape).background(Color(0xFFE7A9B8)))
                Text("HEY,\nYOU'RE BACK!", color = HInk, fontSize = 23.sp, lineHeight = 27.sp,
                    fontWeight = FontWeight.Black, modifier = Modifier.align(Alignment.CenterStart).padding(start = 20.dp))
                Text("✳", color = Color(0xFFFAF8F5), fontSize = 42.sp, modifier = Modifier.align(Alignment.CenterEnd).padding(end = 48.dp))
                Text("GOOD TO SEE YOU AGAIN", color = HMuted, fontSize = 8.sp, letterSpacing = 1.1.sp,
                    modifier = Modifier.align(Alignment.BottomStart).padding(start = 21.dp, bottom = 12.dp))
            }
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text("手机号码", color = HInk, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                OutlinedTextField(
                    value = phone,
                    onValueChange = { newValue: String -> phone = newValue.filter(Char::isDigit).take(11) },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("请输入 11 位手机号", color = HMuted) },
                    leadingIcon = {
                        Text("+86", color = HInk, fontSize = 13.sp, fontWeight = FontWeight.Medium)
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    singleLine = true,
                    shape = RoundedCornerShape(14.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = HPrimary,
                        unfocusedBorderColor = Color(0xFFE8E1E5),
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    )
                )
                Text("我们将向该号码发送短信验证码", color = HMuted, fontSize = 10.sp)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = agreed, onCheckedChange = { agreed = it }, colors = CheckboxDefaults.colors(checkedColor = HPrimary))
                Text("我已阅读并同意", color = HMuted, fontSize = 10.sp)
                Text("用户协议", color = HPrimary, fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
                Text("与", color = HMuted, fontSize = 10.sp)
                Text("隐私政策", color = HPrimary, fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
            }
        }
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Button(
                onClick = { codeSent = true },
                enabled = phone.length == 11 && phone.firstOrNull() == '1' && agreed,
                modifier = Modifier.fillMaxWidth().height(54.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = HInk, disabledContainerColor = Color(0xFFD8D3D7))
            ) {
                Text("获取验证码", color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                Spacer(Modifier.width(8.dp))
                Text("→", color = Color.White)
            }
            Text("登录即代表你已年满适用年龄，并接受平台规则。", color = HMuted, fontSize = 9.sp, modifier = Modifier.align(Alignment.CenterHorizontally))
        }
    }
}

@Composable
private fun VerificationScreen(phone: String = "13800008888", onBack: () -> Unit = {}) {
    var code by androidx.compose.runtime.remember { androidx.compose.runtime.mutableStateOf("") }
    var verified by androidx.compose.runtime.remember { androidx.compose.runtime.mutableStateOf(false) }
    var resendHint by androidx.compose.runtime.remember { androidx.compose.runtime.mutableStateOf(false) }
    val maskedPhone = if (phone.length == 11) phone.take(3) + "****" + phone.takeLast(4) else phone
    val accent = Color(0xFF5A65D8)
    val ink = Color(0xFF29283A)
    Column(
        Modifier.fillMaxSize().background(Color(0xFFFFF9F3)).padding(horizontal = 23.dp, vertical = 18.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(0.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                TextButton(onClick = onBack, contentPadding = PaddingValues(0.dp)) {
                    Text("‹  返回", color = Color(0xFF777487), fontSize = 12.sp)
                }
                Spacer(Modifier.weight(1f))
                Text("02", color = accent, fontSize = 12.sp, fontWeight = FontWeight.Black)
                Text(" / 02", color = Color(0xFFB8B4C0), fontSize = 11.sp)
            }
            Spacer(Modifier.height(28.dp))
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(7.dp)) {
                Box(Modifier.size(8.dp).clip(CircleShape).background(Color(0xFFFF9878)))
                Text("ANIMATE CLUB  ·  MEMBER ENTRY", color = accent, fontSize = 9.sp, fontWeight = FontWeight.Black, letterSpacing = 1.1.sp)
            }
            Spacer(Modifier.height(13.dp))
            Text("差一点，", color = ink, fontSize = 35.sp, lineHeight = 41.sp, fontWeight = FontWeight.Black)
            Row(verticalAlignment = Alignment.Bottom) {
                Text("就开聊！", color = accent, fontSize = 35.sp, lineHeight = 41.sp, fontWeight = FontWeight.Black)
                Spacer(Modifier.width(9.dp))
                Text("✳", color = Color(0xFFFF9878), fontSize = 27.sp)
            }
            Spacer(Modifier.height(13.dp))
            Text("输入手机收到的 6 位数字，\n把你的兴趣现场接回来。", color = Color(0xFF858092), fontSize = 13.sp, lineHeight = 21.sp)
            Spacer(Modifier.height(23.dp))
            Surface(color = Color(0xFFF0EDFF), shape = RoundedCornerShape(18.dp), modifier = Modifier.fillMaxWidth()) {
                Row(Modifier.padding(horizontal = 15.dp, vertical = 13.dp), verticalAlignment = Alignment.CenterVertically) {
                    Box(Modifier.size(34.dp).clip(RoundedCornerShape(11.dp)).background(Color.White), contentAlignment = Alignment.Center) {
                        Icon(Icons.Rounded.Sms, null, tint = accent, modifier = Modifier.size(19.dp))
                    }
                    Spacer(Modifier.width(11.dp))
                    Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(2.dp)) {
                        Text("验证码已准备好", color = ink, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        Text("+86  " + maskedPhone.ifBlank { "你的手机号" }, color = Color(0xFF777487), fontSize = 11.sp)
                    }
                    Text("EDIT", color = accent, fontSize = 9.sp, fontWeight = FontWeight.Black)
                }
            }
        }
        Column(verticalArrangement = Arrangement.spacedBy(18.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("YOUR CODE", color = ink, fontSize = 11.sp, fontWeight = FontWeight.Black, letterSpacing = 1.5.sp)
                Spacer(Modifier.weight(1f))
                Text(code.length.toString() + " / 6", color = accent, fontSize = 11.sp, fontWeight = FontWeight.Bold)
            }
            BasicTextField(
                value = code,
                onValueChange = { newValue: String -> code = newValue.filter(Char::isDigit).take(6); verified = false },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                textStyle = androidx.compose.ui.text.TextStyle(color = Color.Transparent),
                cursorBrush = androidx.compose.ui.graphics.SolidColor(Color.Transparent),
                decorationBox = { innerTextField ->
                    Box {
                        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            repeat(6) { index ->
                                val digit = code.getOrNull(index)?.toString().orEmpty()
                                val active = index == code.length && code.length < 6
                                val filled = digit.isNotEmpty()
                                Box(
                                    Modifier.weight(1f).height(58.dp)
                                        .clip(RoundedCornerShape(15.dp))
                                        .background(if (filled) Color(0xFFE9E8FF) else if (active) Color.White else Color(0xFFF3EFEA))
                                        .border(if (active) 1.5.dp else 1.dp, if (active) accent else Color(0xFFE8E2E0), RoundedCornerShape(15.dp)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    if (filled) Text(digit, color = ink, fontSize = 24.sp, fontWeight = FontWeight.ExtraBold)
                                    else if (active) Box(Modifier.width(2.dp).height(23.dp).clip(CircleShape).background(Color(0xFFFF9878)))
                                    else Box(Modifier.size(5.dp).clip(CircleShape).background(Color(0xFFD5D0D1)))
                                }
                            }
                        }
                        Box(Modifier.matchParentSize()) { innerTextField() }
                    }
                }
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("没收到？", color = Color(0xFF858092), fontSize = 11.sp)
                TextButton(onClick = { code = ""; verified = false; resendHint = true }, contentPadding = PaddingValues(horizontal = 5.dp, vertical = 0.dp)) {
                    Text("重新获取", color = accent, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                }
                Spacer(Modifier.weight(1f))
                Text("稍等片刻 · 00:59", color = Color(0xFFAAA5B0), fontSize = 10.sp)
            }
            if (resendHint) Text("输入已清空，可以重新填写。", color = Color(0xFF858092), fontSize = 10.sp)
            if (verified) Text("这是登录流程的界面预览，不会进行真实身份验证。", color = accent, fontSize = 10.sp)
            Button(
                onClick = { verified = true },
                enabled = code.length == 6,
                modifier = Modifier.fillMaxWidth().height(55.dp),
                shape = RoundedCornerShape(17.dp),
                colors = ButtonDefaults.buttonColors(containerColor = accent, disabledContainerColor = Color(0xFFD8D4E2))
            ) {
                Text("进入兴趣现场", color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                Spacer(Modifier.width(9.dp))
                Text("↗", color = Color.White, fontSize = 16.sp)
            }
            Text("MAKE YOUR FANDOM FEEL AT HOME.", color = Color(0xFFAAA5B0), fontSize = 8.sp, letterSpacing = 1.3.sp, modifier = Modifier.align(Alignment.CenterHorizontally))
        }
    }
}
@Composable
private fun PageHeader(title: String, trailing: String = "") {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Column(Modifier.weight(1f)) {
            Text("ANIMATE / EDITION 01", color = HPrimary, fontSize = 8.sp, fontWeight = FontWeight.Black, letterSpacing = 1.6.sp)
            Text(title, color = HInk, fontSize = 27.sp, fontWeight = FontWeight.Black)
        }
        if (trailing.isNotBlank()) Text(trailing, color = HPrimary, fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
private fun SectionTitle(title: String, more: String = "") {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(title, color = HInk, fontSize = 16.sp, fontWeight = FontWeight.Bold, modifier = Modifier.weight(1f))
        if (more.isNotBlank()) Text(more, color = HPrimary, fontSize = 10.sp)
    }
}

@Composable
private fun MockImage(height: Int = 150, symbol: String = "✦") {
    Box(
        Modifier.fillMaxWidth().height(height.dp).clip(RoundedCornerShape(5.dp)).background(
            androidx.compose.ui.graphics.Brush.linearGradient(listOf(Color(0xFFFFB8CF), Color(0xFFB9A7FF), Color(0xFFE7FF68)))
        ),
        contentAlignment = Alignment.Center
    ) {
        Text(symbol, color = Color(0xFF6847FF), fontSize = 54.sp, fontWeight = FontWeight.Black)
    }
}

@Composable
private fun InfoRow(label: String, value: String) {
    Row(Modifier.fillMaxWidth().padding(vertical = 9.dp), verticalAlignment = Alignment.CenterVertically) {
        Text(label, color = HMuted, fontSize = 11.sp, modifier = Modifier.weight(1f))
        Text(value, color = HInk, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
private fun ActionButton(label: String, modifier: Modifier = Modifier, secondary: Boolean = false) {
    Button(
        onClick = {},
        modifier = modifier.height(48.dp),
        shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (secondary) HPale else HPrimary,
            contentColor = if (secondary) HPrimary else Color.White
        )
    ) { Text(label, fontWeight = FontWeight.SemiBold, fontSize = 12.sp) }
}

@Composable
private fun ProductDetailScreen() {
    Column(Modifier.fillMaxSize().background(Color.White)) {
        LazyColumn(Modifier.weight(1f), contentPadding = PaddingValues(18.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
            item { PageHeader("商品详情", "♡ 收藏") }
            item { MockImage(260, "✧") }
            item {
                Text("原创艺术收藏摆件 · 星月系列", color = HInk, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text("创作者原创设计 / 限量发行", color = HMuted, fontSize = 11.sp)
                Spacer(Modifier.height(8.dp))
                Text("¥ 128.00", color = HCoral, fontSize = 23.sp, fontWeight = FontWeight.ExtraBold)
            }
            item {
                Surface(color = HBg, shape = RoundedCornerShape(16.dp)) {
                    Column(Modifier.padding(14.dp)) {
                        InfoRow("配送", "现货 · 预计 48 小时内发货")
                        HorizontalDivider(color = Color.White)
                        InfoRow("服务", "正品保障 · 售后支持")
                        HorizontalDivider(color = Color.White)
                        InfoRow("规格", "标准款 · 紫色")
                    }
                }
            }
            item { SectionTitle("创作者介绍", "进入主页") }
            item { Text("以原创设计记录兴趣灵感，让每件作品都有自己的故事。", color = HMuted, fontSize = 12.sp) }
            item { SectionTitle("商品评价", "查看全部") }
            item { Text("暂无真实评价数据 · 当前为 UI 展示样例", color = HMuted, fontSize = 11.sp) }
        }
        Row(Modifier.fillMaxWidth().background(Color.White).padding(14.dp), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            ActionButton("加入购物车", Modifier.weight(1f), true)
            ActionButton("立即购买", Modifier.weight(1f))
        }
    }
}

@Composable
private fun CartScreen() {
    Column(Modifier.fillMaxSize().background(HBg).padding(18.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        PageHeader("购物车", "管理")
        repeat(2) { index ->
            Surface(color = Color.White, shape = RoundedCornerShape(18.dp)) {
                Row(Modifier.padding(13.dp), verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(checked = index == 0, onCheckedChange = {}, colors = CheckboxDefaults.colors(checkedColor = HPrimary))
                    Box(Modifier.size(76.dp).clip(RoundedCornerShape(13.dp)).background(HPale), contentAlignment = Alignment.Center) {
                        Icon(Icons.Rounded.AutoAwesome, null, tint = HPrimary, modifier = Modifier.size(28.dp))
                    }
                    Spacer(Modifier.width(11.dp))
                    Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Text(if (index == 0) "星月系列原创摆件" else "原创插画收藏卡", color = HInk, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                        Text("标准款 · 紫色", color = HMuted, fontSize = 10.sp)
                        Text(if (index == 0) "¥128.00" else "¥36.00", color = HCoral, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    }
                    Text("−   1   +", color = HInk, fontSize = 11.sp)
                }
            }
        }
        Surface(color = Color.White, shape = RoundedCornerShape(18.dp)) {
            Column(Modifier.padding(16.dp)) {
                InfoRow("商品金额", "¥ 164.00")
                InfoRow("配送费用", "¥ 0.00")
                HorizontalDivider(color = HBg)
                InfoRow("合计", "¥ 164.00")
            }
        }
        Spacer(Modifier.weight(1f))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = true, onCheckedChange = {})
            Text("全选", color = HMuted, fontSize = 11.sp, modifier = Modifier.weight(1f))
            Text("合计 ¥164.00", color = HInk, fontSize = 14.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.width(10.dp))
            ActionButton("去结算")
        }
    }
}

@Composable
private fun OrderDetailScreen() {
    Column(Modifier.fillMaxSize().background(HBg).padding(18.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
        PageHeader("订单详情")
        Surface(color = HPrimary, shape = RoundedCornerShape(20.dp), modifier = Modifier.fillMaxWidth()) {
            Column(Modifier.padding(18.dp)) {
                Text("等待发货", color = Color.White, fontSize = 21.sp, fontWeight = FontWeight.Bold)
                Text("商家正在准备你的商品", color = Color(0xFFE7E1FF), fontSize = 11.sp)
                Spacer(Modifier.height(16.dp))
                Text("订单进度", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
                Text("已下单     已付款     待发货     待收货", color = Color.White, fontSize = 10.sp)
            }
        }
        Surface(color = Color.White, shape = RoundedCornerShape(17.dp)) {
            Column(Modifier.padding(15.dp)) {
                Text("收货信息", color = HInk, fontSize = 13.sp, fontWeight = FontWeight.Bold)
                InfoRow("收货人", "用户展示名称")
                InfoRow("联系电话", "138****0000")
                InfoRow("收货地址", "此处展示收货地址")
            }
        }
        Surface(color = Color.White, shape = RoundedCornerShape(17.dp)) {
            Column(Modifier.padding(15.dp)) {
                Text("商品信息", color = HInk, fontSize = 13.sp, fontWeight = FontWeight.Bold)
                InfoRow("星月系列原创摆件 × 1", "¥128.00")
                InfoRow("商品总额", "¥128.00")
                InfoRow("实付款", "¥128.00")
            }
        }
        Surface(color = Color.White, shape = RoundedCornerShape(17.dp)) {
            Column(Modifier.padding(15.dp)) {
                InfoRow("订单编号", "AM202600001")
                InfoRow("创建时间", "2026-11-08 14:30")
                InfoRow("支付方式", "在线支付")
            }
        }
        ActionButton("联系商家", Modifier.fillMaxWidth(), true)
    }
}

@Composable
private fun ChatScreen() {
    Column(Modifier.fillMaxSize().background(Color.White)) {
        PageHeader("创作交流", "在线")
        Column(Modifier.weight(1f).fillMaxWidth().background(HBg).padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Text("今天 14:32", color = HMuted, fontSize = 10.sp, modifier = Modifier.align(Alignment.CenterHorizontally))
            ChatBubble("最近发现一位很棒的创作者，分享给你看看。", false)
            ChatBubble("好呀！我也在找新的灵感。", true)
            ChatBubble("这组作品的配色真的很特别。", false)
            ChatBubble("喜欢这种温柔的色彩风格 ✨", true)
        }
        Row(Modifier.fillMaxWidth().padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = {}) { Icon(Icons.Rounded.AddCircleOutline, null, tint = HMuted) }
            Surface(color = HBg, shape = CircleShape, modifier = Modifier.weight(1f)) {
                Text("发送消息…", color = HMuted, fontSize = 12.sp, modifier = Modifier.padding(horizontal = 15.dp, vertical = 13.dp))
            }
            IconButton(onClick = {}) { Icon(Icons.Rounded.Mood, null, tint = HMuted) }
            IconButton(onClick = {}) { Icon(Icons.Rounded.Send, null, tint = HPrimary) }
        }
    }
}

@Composable
private fun ChatBubble(text: String, mine: Boolean) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = if (mine) Arrangement.End else Arrangement.Start) {
        Surface(color = if (mine) HPale else Color.White, shape = RoundedCornerShape(16.dp), modifier = Modifier.widthIn(max = 270.dp)) {
            Text(text, color = HInk, fontSize = 12.sp, modifier = Modifier.padding(13.dp))
        }
    }
}

@Composable
fun ProfileHomeScreen() {
    Column(Modifier.fillMaxSize().background(HBg)) {
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(start = 18.dp, top = 18.dp, end = 18.dp, bottom = 26.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            item { PageHeader("我的主页", "设置") }
            item {
                Surface(color = Color.White, shape = RoundedCornerShape(23.dp), modifier = Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(Modifier.size(68.dp).clip(CircleShape).background(HPale), contentAlignment = Alignment.Center) {
                                Icon(Icons.Rounded.Person, null, tint = HPrimary, modifier = Modifier.size(36.dp))
                            }
                            Spacer(Modifier.width(13.dp))
                            Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                                Text("AniMate 用户", color = HInk, fontSize = 17.sp, fontWeight = FontWeight.Bold)
                                Text("ID: animate_2026", color = HMuted, fontSize = 9.sp)
                                Text("让热爱连接彼此 · 动漫 / 插画 / 收藏", color = HMuted, fontSize = 10.sp)
                            }
                            Surface(color = HPale, shape = RoundedCornerShape(12.dp)) {
                                Text("编辑资料", color = HPrimary, fontSize = 10.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(horizontal = 11.dp, vertical = 8.dp))
                            }
                        }
                        HorizontalDivider(color = HBg)
                        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                            StatItem("作品", "12")
                            StatItem("关注", "128")
                            StatItem("粉丝", "2.4k")
                            StatItem("获赞", "8.6k")
                        }
                    }
                }
            }
            item {
                Row(horizontalArrangement = Arrangement.spacedBy(9.dp)) {
                    listOf("我的作品" to Icons.Rounded.GridView, "我的收藏" to Icons.Rounded.FavoriteBorder, "浏览历史" to Icons.Rounded.History).forEach { item ->
                        Surface(color = Color.White, shape = RoundedCornerShape(16.dp), modifier = Modifier.weight(1f)) {
                            Column(Modifier.padding(vertical = 14.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(7.dp)) {
                                Icon(item.second, null, tint = HPrimary, modifier = Modifier.size(22.dp))
                                Text(item.first, color = HInk, fontSize = 10.sp, fontWeight = FontWeight.Medium)
                            }
                        }
                    }
                }
            }
            item {
                Surface(color = HPale, shape = RoundedCornerShape(20.dp), modifier = Modifier.fillMaxWidth()) {
                    Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                        Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(5.dp)) {
                            Text("创作者空间", color = HPrimary, fontSize = 9.sp, fontWeight = FontWeight.Bold, letterSpacing = 1.sp)
                            Text("记录灵感，让作品被更多人看见", color = HInk, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                            Text("作品管理 · 创作数据 · 创作者服务", color = HMuted, fontSize = 9.sp)
                        }
                        Icon(Icons.Rounded.AutoAwesome, null, tint = HPrimary, modifier = Modifier.size(30.dp))
                    }
                }
            }
            item { SectionTitle("我的服务") }
            items(listOf("我的订单" to Icons.Rounded.ReceiptLong, "我的活动与门票" to Icons.Rounded.ConfirmationNumber, "我的圈子" to Icons.Rounded.Groups, "商家中心" to Icons.Rounded.Storefront, "账号与安全" to Icons.Rounded.Security, "设置与隐私" to Icons.Rounded.Settings)) { item ->
                Surface(color = Color.White, shape = RoundedCornerShape(15.dp)) {
                    Row(Modifier.fillMaxWidth().padding(horizontal = 15.dp, vertical = 14.dp), verticalAlignment = Alignment.CenterVertically) {
                        Icon(item.second, null, tint = HPrimary, modifier = Modifier.size(19.dp))
                        Spacer(Modifier.width(12.dp))
                        Text(item.first, color = HInk, fontSize = 11.sp, modifier = Modifier.weight(1f))
                        Icon(Icons.Rounded.ChevronRight, null, tint = HMuted, modifier = Modifier.size(18.dp))
                    }
                }
            }
        }
    }
}
@Composable
private fun StatItem(label: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(value, color = HInk, fontSize = 17.sp, fontWeight = FontWeight.Bold)
        Text(label, color = HMuted, fontSize = 10.sp)
    }
}

@Composable
private fun CreatorDashboardScreen() {
    Column(Modifier.fillMaxSize().background(HBg)) {
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(start = 18.dp, top = 18.dp, end = 18.dp, bottom = 26.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            item { PageHeader("创作者中心", "工作台") }
            item {
                Surface(color = HPrimary, shape = RoundedCornerShape(22.dp), modifier = Modifier.fillMaxWidth()) {
                    Column(Modifier.background(androidx.compose.ui.graphics.Brush.linearGradient(listOf(Color(0xFF7866D8), Color(0xFF9A87E8)))).padding(18.dp), verticalArrangement = Arrangement.spacedBy(11.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Column(Modifier.weight(1f)) {
                                Text("CREATOR STUDIO / 001", color = Color(0xFFE7FF68), fontSize = 9.sp, fontWeight = FontWeight.Bold, letterSpacing = 1.3.sp)
                                Text("创作表现", color = Color.White, fontSize = 19.sp, fontWeight = FontWeight.Bold)
                            }
                            Icon(Icons.Rounded.AutoAwesome, null, tint = Color.White, modifier = Modifier.size(27.dp))
                        }
                        Text("本地 UI 样例数据 · 非真实运营数据", color = Color(0xFFE7E0FF), fontSize = 9.sp)
                        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            StatItem("作品浏览", "12.8k")
                            StatItem("互动次数", "860")
                            StatItem("新增粉丝", "126")
                        }
                    }
                }
            }
            item {
                Surface(color = Color.White, shape = RoundedCornerShape(19.dp), modifier = Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        SectionTitle("近 7 天内容趋势", "查看数据")
                        Row(Modifier.fillMaxWidth().height(104.dp), horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.Bottom) {
                            listOf(42, 58, 48, 76, 64, 90, 72).forEachIndexed { index, value ->
                                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(6.dp)) {
                                    Box(Modifier.width(19.dp).height(value.dp).clip(RoundedCornerShape(topStart = 6.dp, topEnd = 6.dp)).background(if (index == 5) HPrimary else HPale))
                                    Text(listOf("一", "二", "三", "四", "五", "六", "日")[index], color = HMuted, fontSize = 8.sp)
                                }
                            }
                        }
                    }
                }
            }
            item {
                SectionTitle("内容管理", "管理全部")
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    listOf("发布作品" to Icons.Rounded.AddPhotoAlternate, "作品管理" to Icons.Rounded.Collections, "草稿箱" to Icons.Rounded.EditNote).forEach { item ->
                        Surface(color = Color.White, shape = RoundedCornerShape(16.dp), modifier = Modifier.weight(1f)) {
                            Column(Modifier.padding(vertical = 15.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                Icon(item.second, null, tint = HPrimary, modifier = Modifier.size(23.dp))
                                Text(item.first, color = HInk, fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
                            }
                        }
                    }
                }
            }
            item { SectionTitle("创作者服务") }
            items(listOf("创作者资料", "内容审核记录", "收益与结算说明", "平台创作规范")) { label -> DashboardRow(label) }
        }
    }
}
@Composable
private fun MerchantDashboardScreen() {
    Column(Modifier.fillMaxSize().background(HBg).padding(18.dp), verticalArrangement = Arrangement.spacedBy(15.dp)) {
        PageHeader("商家中心", "店铺管理")
        Surface(color = Color.White, shape = RoundedCornerShape(20.dp), modifier = Modifier.fillMaxWidth()) {
            Column(Modifier.padding(18.dp)) {
                Text("我的兴趣商店", color = HInk, fontSize = 17.sp, fontWeight = FontWeight.Bold)
                Text("店铺经营数据展示样例", color = HMuted, fontSize = 10.sp)
                Spacer(Modifier.height(14.dp))
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    StatItem("商品", "18")
                    StatItem("待发货", "06")
                    StatItem("售后", "02")
                }
            }
        }
        SectionTitle("商品经营")
        listOf("全部商品", "新增商品", "库存管理", "商品分类").forEach { DashboardRow(it) }
        SectionTitle("订单与服务")
        listOf("店铺订单", "售后管理", "配送设置").forEach { DashboardRow(it) }
    }
}

@Composable
private fun DashboardRow(label: String) {
    Surface(color = Color.White, shape = RoundedCornerShape(14.dp)) {
        Row(Modifier.fillMaxWidth().padding(15.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Rounded.AutoAwesome, null, tint = HPrimary, modifier = Modifier.size(18.dp))
            Spacer(Modifier.width(11.dp))
            Text(label, color = HInk, fontSize = 12.sp, modifier = Modifier.weight(1f))
            Icon(Icons.Rounded.ChevronRight, null, tint = HMuted)
        }
    }
}

@Composable
private fun EventDetailScreen() {
    Column(Modifier.fillMaxSize().background(Color.White)) {
        LazyColumn(Modifier.weight(1f), contentPadding = PaddingValues(18.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
            item { PageHeader("活动详情", "分享") }
            item { MockImage(210, "✧") }
            item { Text("AniMate 兴趣创作交流日", color = HInk, fontSize = 20.sp, fontWeight = FontWeight.Bold) }
            item { Text("连接创作者与兴趣社群，分享灵感与作品。", color = HMuted, fontSize = 12.sp) }
            item {
                Surface(color = HBg, shape = RoundedCornerShape(16.dp)) {
                    Column(Modifier.padding(15.dp)) {
                        InfoRow("活动时间", "11 月 28 日 · 13:00")
                        InfoRow("活动地点", "城市创意空间")
                        InfoRow("报名状态", "开放报名")
                    }
                }
            }
            item { SectionTitle("活动日程") }
            item { InfoRow("13:00", "签到与自由交流") }
            item { InfoRow("14:00", "创作者主题分享") }
            item { InfoRow("16:00", "作品展示与互动") }
        }
        ActionButton("立即报名", Modifier.fillMaxWidth().padding(14.dp))
    }
}

@Composable
private fun CircleDetailScreen() {
    Column(Modifier.fillMaxSize().background(HBg).padding(18.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
        PageHeader("圈子详情", "分享")
        Surface(color = HPale, shape = RoundedCornerShape(22.dp), modifier = Modifier.fillMaxWidth()) {
            Column(Modifier.padding(20.dp)) {
                Box(Modifier.size(58.dp).clip(RoundedCornerShape(18.dp)).background(Color.White), contentAlignment = Alignment.Center) {
                    Icon(Icons.Rounded.Groups, null, tint = HPrimary, modifier = Modifier.size(30.dp))
                }
                Spacer(Modifier.height(12.dp))
                Text("原创插画交流社", color = HInk, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text("分享灵感、交流技法、认识同好。", color = HMuted, fontSize = 11.sp)
                Spacer(Modifier.height(12.dp))
                Text("2.4k 成员   ·   128 篇帖子", color = HPrimary, fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
                Spacer(Modifier.height(12.dp))
                ActionButton("加入圈子", Modifier.fillMaxWidth())
            }
        }
        SectionTitle("圈子动态", "发布")
        repeat(3) { index ->
            Surface(color = Color.White, shape = RoundedCornerShape(17.dp)) {
                Column(Modifier.padding(15.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(listOf("今日配色练习分享", "最近完成的一组原创作品", "大家最喜欢哪种创作风格？")[index], color = HInk, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                    Text("兴趣交流 · 帖子内容展示样例", color = HMuted, fontSize = 10.sp)
                    Text("♡  28       ◯  12", color = HMuted, fontSize = 10.sp)
                }
            }
        }
    }
}

@Composable
private fun DiscoverHomeScreen() {
    Column(Modifier.fillMaxSize().background(HBg)) {
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(start = 16.dp, top = 12.dp, end = 16.dp, bottom = 28.dp),
            verticalArrangement = Arrangement.spacedBy(19.dp)
        ) {
            item {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(2.dp)) {
                        Text("ANIMATE / TOKYO CULTURE CLUB", color = HMuted, fontSize = 8.sp, fontWeight = FontWeight.Black, letterSpacing = 1.2.sp)
                        Text("好き、集合。", color = HInk, fontSize = 28.sp, fontWeight = FontWeight.Bold)
                    }
                    Surface(color = Color(0xFF514B54), shape = CircleShape) {
                        Row(Modifier.padding(horizontal = 12.dp, vertical = 9.dp), verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Rounded.Search, null, tint = Color.White, modifier = Modifier.size(17.dp))
                            Spacer(Modifier.width(6.dp))
                            Text("探索", color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                    Spacer(Modifier.width(7.dp))
                    IconButton(onClick = {}) { Icon(Icons.Rounded.NotificationsNone, "通知", tint = HInk) }
                }
            }
            item {
                Box(
                    Modifier.fillMaxWidth().height(244.dp).clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFF9A8BAA))
                ) {
                    Box(Modifier.fillMaxWidth().height(244.dp).background(
                        androidx.compose.ui.graphics.Brush.linearGradient(
                            listOf(Color(0xFF9A8BAA), Color(0xFFB7A9BD), Color(0xFFE2C5C2))
                        )
                    ))
                    Text("VOL. 01", color = Color(0xFFE9E1D8), fontSize = 10.sp, fontWeight = FontWeight.Black, letterSpacing = 2.sp, modifier = Modifier.align(Alignment.TopStart).padding(17.dp))
                    Text("好きなものに、\n夢中でいい。", color = Color.White, fontSize = 27.sp, lineHeight = 36.sp, fontWeight = FontWeight.Bold, modifier = Modifier.align(Alignment.CenterStart).padding(start = 18.dp, top = 16.dp))
                    Text("YOUR INTEREST. YOUR SCENE.", color = Color.White.copy(alpha = .86f), fontSize = 8.sp, fontWeight = FontWeight.Bold, letterSpacing = 1.3.sp, modifier = Modifier.align(Alignment.BottomStart).padding(18.dp))
                    Surface(color = Color(0xFFE9E1D8), shape = RoundedCornerShape(4.dp), modifier = Modifier.align(Alignment.BottomEnd).padding(16.dp)) {
                        Text("DISCOVER →", color = Color(0xFF514B54), fontSize = 9.sp, fontWeight = FontWeight.Black, modifier = Modifier.padding(horizontal = 11.dp, vertical = 8.dp))
                    }
                    Text("✳", color = Color(0xFFE9E1D8), fontSize = 105.sp, modifier = Modifier.align(Alignment.TopEnd).padding(end = 12.dp, top = 27.dp))
                    Text("ANIME / ART / FIGURE / GAME", color = Color.White.copy(alpha = .8f), fontSize = 8.sp, fontWeight = FontWeight.Bold, modifier = Modifier.align(Alignment.CenterEnd).padding(end = 16.dp))
                }
            }
            item {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("PICK YOUR SIDE", color = HInk, fontSize = 11.sp, fontWeight = FontWeight.Black, letterSpacing = 1.3.sp, modifier = Modifier.weight(1f))
                    Text("兴趣频道 ↗", color = HPrimary, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                }
                Spacer(Modifier.height(10.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    listOf(
                        Triple("ANIME", "动漫", Color(0xFFE9E1D8)),
                        Triple("ILLUST", "插画", Color(0xFFEBD9D8)),
                        Triple("FIGURE", "手办", Color(0xFFDCD4E4)),
                        Triple("GAME", "游戏", Color(0xFFD8E4DE))
                    ).forEach { channel ->
                        Surface(color = channel.third, shape = RoundedCornerShape(12.dp), modifier = Modifier.weight(1f)) {
                            Column(Modifier.padding(vertical = 12.dp, horizontal = 7.dp), verticalArrangement = Arrangement.spacedBy(5.dp)) {
                                Text(channel.first, color = HInk, fontSize = 7.sp, fontWeight = FontWeight.Black, letterSpacing = .4.sp)
                                Text(channel.second, color = HInk, fontSize = 13.sp, fontWeight = FontWeight.Black)
                            }
                        }
                    }
                }
            }
            item {
                Row(verticalAlignment = Alignment.Bottom) {
                    Column(Modifier.weight(1f)) {
                        Text("TRENDING NOW", color = HPrimary, fontSize = 8.sp, fontWeight = FontWeight.Black, letterSpacing = 1.1.sp)
                        Text("现在大家在玩什么", color = HInk, fontSize = 19.sp, fontWeight = FontWeight.Black)
                    }
                    Text("#本周话题", color = HMuted, fontSize = 9.sp)
                }
                Spacer(Modifier.height(10.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(9.dp)) {
                    listOf("痛包改造", "原创角色", "谷子交换").forEachIndexed { index, tag ->
                        Surface(color = if (index == 0) Color(0xFF514B54) else Color.White, shape = RoundedCornerShape(4.dp)) {
                            Text("# $tag", color = if (index == 0) Color(0xFFE9E1D8) else HInk, fontSize = 10.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 11.dp, vertical = 9.dp))
                        }
                    }
                }
            }
            item {
                Row(verticalAlignment = Alignment.Bottom) {
                    Column(Modifier.weight(1f)) {
                        Text("THE CREATOR FILE", color = HPrimary, fontSize = 8.sp, fontWeight = FontWeight.Black, letterSpacing = 1.5.sp)
                        Text("本期编辑推荐", color = HInk, fontSize = 19.sp, fontWeight = FontWeight.Black)
                    }
                    Text("VIEW ALL ↗", color = HMuted, fontSize = 8.sp, fontWeight = FontWeight.Black)
                }
                Spacer(Modifier.height(10.dp))
                Surface(color = Color.White, shape = RoundedCornerShape(7.dp), modifier = Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(10.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Box(Modifier.fillMaxWidth().height(188.dp).clip(RoundedCornerShape(4.dp)).background(
                            androidx.compose.ui.graphics.Brush.linearGradient(listOf(Color(0xFFEBD9D8), Color(0xFFDCD4E4), Color(0xFFD8E4DE)))
                        )) {
                            Text("ART\nIS\nEVERYWHERE", color = Color(0xFF514B54), fontSize = 29.sp, lineHeight = 28.sp, fontWeight = FontWeight.Black, modifier = Modifier.align(Alignment.CenterStart).padding(start = 18.dp))
                            Text("✷", color = Color.White, fontSize = 92.sp, modifier = Modifier.align(Alignment.CenterEnd).padding(end = 20.dp))
                            Text("CREATOR SPOTLIGHT / 001", color = Color(0xFF514B54), fontSize = 8.sp, fontWeight = FontWeight.Black, modifier = Modifier.align(Alignment.BottomStart).padding(12.dp))
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(3.dp)) {
                                Text("纸上星河", color = HInk, fontSize = 13.sp, fontWeight = FontWeight.Black)
                                Text("独立插画师 · ORIGINAL CHARACTER", color = HMuted, fontSize = 8.sp, fontWeight = FontWeight.Bold)
                            }
                            Surface(color = Color(0xFFE9E1D8), shape = RoundedCornerShape(4.dp)) {
                                Text("FOLLOW +", color = HInk, fontSize = 9.sp, fontWeight = FontWeight.Black, modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp))
                            }
                        }
                        Text("把脑海里的角色，变成自己的宇宙。", color = HInk, fontSize = 14.sp, fontWeight = FontWeight.Black)
                        Text("原创角色设定、色彩实验与日常灵感记录。", color = HMuted, fontSize = 10.sp)
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("♡ 1.2K", color = HMuted, fontSize = 9.sp, modifier = Modifier.weight(1f))
                            Text("◯ 86 COMMENTS", color = HMuted, fontSize = 9.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
            item {
                Row(verticalAlignment = Alignment.Bottom) {
                    Column(Modifier.weight(1f)) {
                        Text("COMMUNITY SNAP", color = HPrimary, fontSize = 8.sp, fontWeight = FontWeight.Black, letterSpacing = 1.4.sp)
                        Text("来自同好的现场", color = HInk, fontSize = 19.sp, fontWeight = FontWeight.Black)
                    }
                    Text("更多动态 ↗", color = HMuted, fontSize = 9.sp)
                }
                Spacer(Modifier.height(9.dp))
                Surface(color = Color(0xFFE9E1D8), shape = RoundedCornerShape(7.dp), modifier = Modifier.fillMaxWidth()) {
                    Row(Modifier.padding(14.dp), verticalAlignment = Alignment.CenterVertically) {
                        Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(5.dp)) {
                            Text("WEEKEND LOG", color = HInk, fontSize = 8.sp, fontWeight = FontWeight.Black, letterSpacing = 1.2.sp)
                            Text("痛包、立牌和一点点快乐。", color = HInk, fontSize = 15.sp, fontWeight = FontWeight.Black)
                            Text("模型收藏研究所 · 86 likes", color = HMuted, fontSize = 9.sp)
                        }
                        Text("✦", color = HPrimary, fontSize = 45.sp)
                    }
                }
            }
        }
    }
}
@Composable
private fun GenericDetailScreen(name: String) {
    Column(Modifier.fillMaxSize().background(HBg).padding(18.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
        PageHeader(name)
        Surface(color = HPale, shape = RoundedCornerShape(20.dp), modifier = Modifier.fillMaxWidth()) {
            Column(Modifier.padding(18.dp)) {
                Text(name, color = HInk, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text("此页面采用独立业务布局方向，内容为本地静态 UI 样例。", color = HMuted, fontSize = 11.sp)
            }
        }
        repeat(4) { index -> DashboardRow(listOf("主要内容", "详细信息", "相关记录", "更多操作")[index]) }
    }
}
