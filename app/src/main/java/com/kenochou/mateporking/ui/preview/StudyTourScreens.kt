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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val StudyInk = Color(0xFF34413D)
private val StudyMuted = Color(0xFF89938D)
private val StudyBg = Color(0xFFF7F8F3)
private val StudyGreen = Color(0xFF648C78)
private val StudyMint = Color(0xFFE5F0E8)
private val StudyPeach = Color(0xFFFFE9D9)
private val StudyLine = Color(0xFFE9EDE7)

@Composable
fun StudyTourScreen(name: String) {
    when (name) {
        "研学发现首页" -> StudyTourHome()
        "研学线路详情" -> StudyTourDetail()
        "研学报名信息" -> StudyTourBooking()
        "研学行程安排" -> StudyTourItinerary()
    }
}

@Composable
private fun StudyTourHome() {
    var category by remember { mutableStateOf("全部") }
    val trips = listOf(
        Triple("杭州 · 西湖自然课堂", "3天2晚 · 适合 10–15 岁", "¥1,680"),
        Triple("敦煌 · 丝路考古营", "5天4晚 · 适合 12–16 岁", "¥3,980"),
        Triple("景德镇 · 陶艺创造营", "2天1晚 · 适合 8–14 岁", "¥1,280")
    )
    LazyColumn(
        modifier = Modifier.fillMaxSize().background(StudyBg),
        contentPadding = PaddingValues(start = 18.dp, end = 18.dp, top = 8.dp, bottom = 28.dp),
        verticalArrangement = Arrangement.spacedBy(17.dp)
    ) {
        item {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(Modifier.weight(1f)) {
                    StudyEyebrow("LEARN OUTSIDE THE CLASSROOM")
                    Text("把世界，变成课堂。", color = StudyInk, fontSize = 25.sp, fontWeight = FontWeight.Black)
                    Text("在旅途中探索，在体验中成长", color = StudyMuted, fontSize = 11.sp)
                }
                Surface(color = Color.White, shape = CircleShape) {
                    Icon(Icons.Rounded.NotificationsNone, null, tint = StudyInk, modifier = Modifier.padding(11.dp).size(20.dp))
                }
            }
        }
        item {
            Box(
                Modifier.fillMaxWidth().height(206.dp).clip(RoundedCornerShape(26.dp))
                    .background(Brush.linearGradient(listOf(Color(0xFFD9E9D9), Color(0xFFF7E7D6), Color(0xFFE5EEE8))))
            ) {
                Box(Modifier.size(150.dp).align(Alignment.CenterEnd).offset(x = 22.dp, y = 20.dp).clip(CircleShape).background(Color(0xFFB6D0BC).copy(alpha = .75f)))
                Box(Modifier.size(92.dp).align(Alignment.TopEnd).offset(x = (-70).dp, y = 24.dp).clip(CircleShape).background(Color(0xFFFFD5A9).copy(alpha = .8f)))
                Column(Modifier.align(Alignment.CenterStart).padding(20.dp), verticalArrangement = Arrangement.spacedBy(9.dp)) {
                    Surface(color = Color.White.copy(alpha = .75f), shape = RoundedCornerShape(50)) {
                        Text("本季主题 · 自然探索", color = StudyGreen, fontSize = 9.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp))
                    }
                    Text("去山野间，\n发现新的自己。", color = StudyInk, fontSize = 23.sp, lineHeight = 30.sp, fontWeight = FontWeight.Black)
                    Text("观察 · 提问 · 记录 · 创造", color = StudyGreen, fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
                }
                Text("✳", color = Color.White, fontSize = 34.sp, modifier = Modifier.align(Alignment.BottomEnd).padding(23.dp))
            }
        }
        item {
            Row(horizontalArrangement = Arrangement.spacedBy(9.dp)) {
                StudyQuickEntry(Icons.Rounded.Explore, "主题研学", "按兴趣探索", Modifier.weight(1f))
                StudyQuickEntry(Icons.Rounded.CalendarMonth, "周末营", "短途轻研学", Modifier.weight(1f))
                StudyQuickEntry(Icons.Rounded.Groups, "成长营", "同伴共成长", Modifier.weight(1f))
            }
        }
        item {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                StudySectionTitle("探索目的地", "DESTINATIONS")
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    listOf("全部", "自然生态", "历史人文", "艺术创造").forEach {
                        FilterChip(
                            selected = category == it, onClick = { category = it },
                            label = { Text(it, fontSize = 10.sp) },
                            colors = FilterChipDefaults.filterChipColors(selectedContainerColor = StudyGreen, selectedLabelColor = Color.White, containerColor = Color.White, labelColor = StudyMuted),
                            border = null, shape = RoundedCornerShape(12.dp)
                        )
                    }
                }
            }
        }
        items(trips.size) { index ->
            val trip = trips[index]
            Surface(color = Color.White, shape = RoundedCornerShape(21.dp), modifier = Modifier.fillMaxWidth().clickable { }) {
                Column {
                    Box(Modifier.fillMaxWidth().height(128.dp).background(
                        when (index) {
                            0 -> Brush.linearGradient(listOf(Color(0xFFC8DED0), Color(0xFFE8E9D8)))
                            1 -> Brush.linearGradient(listOf(Color(0xFFE9CDAF), Color(0xFFF3E5D2)))
                            else -> Brush.linearGradient(listOf(Color(0xFFE9D5C8), Color(0xFFD8E7DE)))
                        }
                    )) {
                        Text(listOf("湖畔自然观察", "丝路文明探秘", "泥土里的艺术")[index], color = StudyInk, fontSize = 19.sp, fontWeight = FontWeight.Black, modifier = Modifier.align(Alignment.BottomStart).padding(16.dp))
                        Surface(color = Color.White.copy(alpha = .88f), shape = RoundedCornerShape(8.dp), modifier = Modifier.align(Alignment.TopStart).padding(12.dp)) {
                            Text(listOf("自然生态", "历史人文", "艺术创造")[index], color = StudyGreen, fontSize = 9.sp, modifier = Modifier.padding(horizontal = 9.dp, vertical = 6.dp))
                        }
                    }
                    Column(Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(7.dp)) {
                        Text(trip.first, color = StudyInk, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Rounded.Schedule, null, tint = StudyMuted, modifier = Modifier.size(13.dp))
                            Text("  ${trip.second}", color = StudyMuted, fontSize = 10.sp, modifier = Modifier.weight(1f))
                            Text(trip.third, color = StudyGreen, fontSize = 15.sp, fontWeight = FontWeight.ExtraBold)
                        }
                    }
                }
            }
        }
        item {
            Surface(color = StudyMint, shape = RoundedCornerShape(18.dp)) {
                Row(Modifier.fillMaxWidth().padding(15.dp), verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Rounded.VerifiedUser, null, tint = StudyGreen, modifier = Modifier.size(24.dp))
                    Spacer(Modifier.width(10.dp))
                    Column(Modifier.weight(1f)) {
                        Text("让每一次出发，都安心有保障", color = StudyInk, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        Text("导师带队 · 行前说明 · 全程安全管理", color = StudyMuted, fontSize = 9.sp)
                    }
                    Icon(Icons.Rounded.ChevronRight, null, tint = StudyGreen)
                }
            }
        }
    }
}

@Composable
private fun StudyTourDetail() {
    LazyColumn(Modifier.fillMaxSize().background(StudyBg), contentPadding = PaddingValues(18.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
        item {
            Box(Modifier.fillMaxWidth().height(220.dp).clip(RoundedCornerShape(25.dp)).background(Brush.linearGradient(listOf(Color(0xFFC6DCCB), Color(0xFFE9E6D5), Color(0xFFF2DCC7))))) {
                Text("NATURE · DISCOVERY", color = StudyGreen, fontSize = 9.sp, fontWeight = FontWeight.Bold, letterSpacing = 1.5.sp, modifier = Modifier.align(Alignment.TopStart).padding(18.dp))
                Text("西湖自然\n观察计划", color = StudyInk, fontSize = 27.sp, lineHeight = 34.sp, fontWeight = FontWeight.Black, modifier = Modifier.align(Alignment.BottomStart).padding(20.dp))
                Surface(color = Color.White.copy(alpha = .9f), shape = CircleShape, modifier = Modifier.align(Alignment.TopEnd).padding(14.dp)) {
                    Icon(Icons.Rounded.FavoriteBorder, null, tint = StudyGreen, modifier = Modifier.padding(10.dp).size(18.dp))
                }
            }
        }
        item {
            Text("在湖岸、湿地与林间完成一场自然观察。孩子将学习记录植物、辨识鸟类，用自己的方式理解生态与城市。", color = StudyMuted, fontSize = 12.sp, lineHeight = 20.sp)
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                StudyTag("3天2晚"); StudyTag("10–15岁"); StudyTag("小班 16 人")
            }
        }
        item {
            StudySectionTitle("这趟旅程会收获什么", "LEARNING GOALS")
            Column(verticalArrangement = Arrangement.spacedBy(9.dp)) {
                StudyInfoRow(Icons.Rounded.Eco, "自然观察力", "用观察卡记录植物与鸟类")
                StudyInfoRow(Icons.Rounded.MenuBook, "科学表达力", "完成一份自己的自然手账")
                StudyInfoRow(Icons.Rounded.Groups, "团队协作力", "和伙伴共同完成探索任务")
            }
        }
        item {
            StudySectionTitle("带队导师", "OUR MENTORS")
            Surface(color = Color.White, shape = RoundedCornerShape(18.dp)) {
                Row(Modifier.padding(14.dp), verticalAlignment = Alignment.CenterVertically) {
                    Box(Modifier.size(48.dp).clip(CircleShape).background(StudyPeach), contentAlignment = Alignment.Center) {
                        Icon(Icons.Rounded.Person, null, tint = StudyGreen, modifier = Modifier.size(26.dp))
                    }
                    Spacer(Modifier.width(11.dp))
                    Column(Modifier.weight(1f)) {
                        Text("林老师 · 自然教育导师", color = StudyInk, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                        Text("自然教育 6 年经验 · 急救培训认证", color = StudyMuted, fontSize = 9.sp)
                    }
                    Icon(Icons.Rounded.Verified, null, tint = StudyGreen)
                }
            }
        }
        item {
            StudySectionTitle("费用包含", "WHAT'S INCLUDED")
            Text("导师课程、活动材料、营地住宿、团队交通、活动保险及每日餐食。", color = StudyMuted, fontSize = 11.sp, lineHeight = 18.sp)
        }
        item {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(Modifier.weight(1f)) {
                    Text("¥1,680", color = StudyGreen, fontSize = 23.sp, fontWeight = FontWeight.Black)
                    Text("每位学员 · 参考价", color = StudyMuted, fontSize = 9.sp)
                }
                Button(onClick = {}, colors = ButtonDefaults.buttonColors(containerColor = StudyGreen), shape = RoundedCornerShape(14.dp)) {
                    Text("立即报名", modifier = Modifier.padding(horizontal = 20.dp, vertical = 5.dp))
                }
            }
        }
    }
}

@Composable
private fun StudyTourBooking() {
    var student by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var guardian by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("2026年11月21日") }
    LazyColumn(Modifier.fillMaxSize().background(StudyBg), contentPadding = PaddingValues(18.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
        item {
            StudyEyebrow("LET'S GET READY")
            Text("填写报名信息", color = StudyInk, fontSize = 25.sp, fontWeight = FontWeight.Black)
            Text("为了更好地照顾每位小小探索者，请填写真实信息。", color = StudyMuted, fontSize = 11.sp)
        }
        item {
            Surface(color = Color.White, shape = RoundedCornerShape(18.dp)) {
                Column(Modifier.padding(15.dp), verticalArrangement = Arrangement.spacedBy(9.dp)) {
                    Text("西湖自然观察计划", color = StudyInk, fontSize = 13.sp, fontWeight = FontWeight.Bold)
                    Text("3天2晚 · 11月21日出发 · ¥1,680 / 人", color = StudyMuted, fontSize = 10.sp)
                }
            }
        }
        item {
            StudyFormLabel("学员信息")
            OutlinedTextField(student, { student = it }, modifier = Modifier.fillMaxWidth(), label = { Text("学生姓名") }, singleLine = true, shape = RoundedCornerShape(13.dp), colors = studyFieldColors())
            OutlinedTextField(age, { age = it }, modifier = Modifier.fillMaxWidth(), label = { Text("年龄 / 年级") }, singleLine = true, shape = RoundedCornerShape(13.dp), colors = studyFieldColors())
        }
        item {
            StudyFormLabel("监护人联系方式")
            OutlinedTextField(guardian, { guardian = it }, modifier = Modifier.fillMaxWidth(), label = { Text("监护人姓名") }, singleLine = true, shape = RoundedCornerShape(13.dp), colors = studyFieldColors())
            OutlinedTextField(phone, { phone = it }, modifier = Modifier.fillMaxWidth(), label = { Text("联系电话") }, singleLine = true, shape = RoundedCornerShape(13.dp), colors = studyFieldColors())
        }
        item {
            StudyFormLabel("选择出发日期")
            Surface(color = Color.White, shape = RoundedCornerShape(13.dp), modifier = Modifier.fillMaxWidth().clickable { date = if (date.contains("21")) "2026年11月28日" else "2026年11月21日" }) {
                Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Rounded.CalendarMonth, null, tint = StudyGreen)
                    Text(date, color = StudyInk, fontSize = 12.sp, modifier = Modifier.weight(1f).padding(start = 10.dp))
                    Text("更换", color = StudyGreen, fontSize = 10.sp)
                }
            }
        }
        item {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Rounded.Shield, null, tint = StudyGreen)
                Spacer(Modifier.width(8.dp))
                Text("学员信息仅用于本次活动组织与安全保障。", color = StudyMuted, fontSize = 9.sp)
            }
            Button(onClick = {}, modifier = Modifier.fillMaxWidth().padding(top = 8.dp).height(50.dp), colors = ButtonDefaults.buttonColors(containerColor = StudyGreen), shape = RoundedCornerShape(14.dp)) {
                Text("确认报名信息")
            }
        }
    }
}

@Composable
private fun StudyTourItinerary() {
    val schedule = listOf(
        Triple("09:00", "集合出发 · 认识伙伴", "破冰任务与行前安全说明"),
        Triple("10:30", "湖畔自然观察", "学习使用观察卡，记录植物特征"),
        Triple("14:00", "湿地生态探索", "寻找鸟类踪迹，认识栖息环境"),
        Triple("16:00", "自然手账工作坊", "整理素材，完成今日观察记录")
    )
    LazyColumn(Modifier.fillMaxSize().background(StudyBg), contentPadding = PaddingValues(18.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
        item {
            StudyEyebrow("FIELD NOTES · DAY 01")
            Text("今天，去自然里寻找答案。", color = StudyInk, fontSize = 23.sp, fontWeight = FontWeight.Black, lineHeight = 31.sp)
            Text("西湖自然观察计划 · 第一天", color = StudyMuted, fontSize = 11.sp)
        }
        item {
            Surface(color = StudyMint, shape = RoundedCornerShape(18.dp)) {
                Row(Modifier.fillMaxWidth().padding(15.dp), verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Rounded.WbSunny, null, tint = StudyGreen, modifier = Modifier.size(25.dp))
                    Spacer(Modifier.width(10.dp))
                    Column {
                        Text("杭州 · 多云转晴 21°C", color = StudyInk, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        Text("建议穿着舒适运动鞋，携带水壶与遮阳帽", color = StudyMuted, fontSize = 9.sp)
                    }
                }
            }
        }
        item {
            StudySectionTitle("每日探索路线", "DAILY TIMELINE")
            Column {
                schedule.forEachIndexed { index, item ->
                    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.Top) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.width(48.dp)) {
                            Box(Modifier.size(12.dp).clip(CircleShape).background(StudyGreen))
                            if (index != schedule.lastIndex) Box(Modifier.width(1.dp).height(76.dp).background(StudyLine))
                        }
                        Column(Modifier.weight(1f).padding(bottom = 17.dp)) {
                            Text(item.first, color = StudyGreen, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                            Text(item.second, color = StudyInk, fontSize = 13.sp, fontWeight = FontWeight.Bold)
                            Text(item.third, color = StudyMuted, fontSize = 10.sp, lineHeight = 16.sp)
                        }
                    }
                }
            }
        }
        item {
            StudySectionTitle("今日研学任务", "FIELD CHALLENGE")
            Surface(color = Color.White, shape = RoundedCornerShape(17.dp)) {
                Column(Modifier.padding(15.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("完成 3 条自然观察记录", color = StudyInk, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    Text("选择一种植物，记录叶片形状、颜色和生长环境。", color = StudyMuted, fontSize = 10.sp)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Rounded.EditNote, null, tint = StudyGreen)
                        Text("打开研学手账", color = StudyGreen, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
        item {
            StudySectionTitle("安全小贴士", "STAY SAFE")
            Text("活动期间请跟随导师，不独自离队；如有身体不适或特殊需求，请及时告知带队老师。", color = StudyMuted, fontSize = 10.sp, lineHeight = 17.sp)
        }
    }
}

@Composable
private fun StudyEyebrow(text: String) {
    Text(text, color = StudyGreen, fontSize = 8.sp, fontWeight = FontWeight.Bold, letterSpacing = 1.4.sp)
}

@Composable
private fun StudySectionTitle(title: String, eyebrow: String) {
    Column(verticalArrangement = Arrangement.spacedBy(3.dp)) {
        StudyEyebrow(eyebrow)
        Text(title, color = StudyInk, fontSize = 16.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun StudyQuickEntry(icon: androidx.compose.ui.graphics.vector.ImageVector, title: String, subtitle: String, modifier: Modifier = Modifier) {
    Surface(color = Color.White, shape = RoundedCornerShape(16.dp), modifier = modifier) {
        Column(Modifier.padding(vertical = 13.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(5.dp)) {
            Icon(icon, null, tint = StudyGreen, modifier = Modifier.size(21.dp))
            Text(title, color = StudyInk, fontSize = 10.sp, fontWeight = FontWeight.Bold)
            Text(subtitle, color = StudyMuted, fontSize = 8.sp)
        }
    }
}

@Composable
private fun StudyTag(text: String) {
    Surface(color = StudyMint, shape = RoundedCornerShape(8.dp)) {
        Text(text, color = StudyGreen, fontSize = 9.sp, modifier = Modifier.padding(horizontal = 9.dp, vertical = 6.dp))
    }
}

@Composable
private fun StudyInfoRow(icon: androidx.compose.ui.graphics.vector.ImageVector, title: String, detail: String) {
    Surface(color = Color.White, shape = RoundedCornerShape(15.dp)) {
        Row(Modifier.fillMaxWidth().padding(13.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, null, tint = StudyGreen, modifier = Modifier.size(21.dp))
            Spacer(Modifier.width(11.dp))
            Column {
                Text(title, color = StudyInk, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                Text(detail, color = StudyMuted, fontSize = 9.sp)
            }
        }
    }
}

@Composable
private fun StudyFormLabel(text: String) {
    Text(text, color = StudyInk, fontSize = 13.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 8.dp))
}

@Composable
private fun studyFieldColors() = OutlinedTextFieldDefaults.colors(
    unfocusedContainerColor = Color.White, focusedContainerColor = Color.White,
    unfocusedBorderColor = StudyLine, focusedBorderColor = StudyGreen
)


@Preview(name = "研学 01 · 发现首页", showBackground = true, widthDp = 393, heightDp = 852)
@Composable
private fun StudyTourHomePreview() {
    MaterialTheme(colorScheme = lightColorScheme(primary = StudyGreen, background = StudyBg)) {
        StudyTourHome()
    }
}

@Preview(name = "研学 02 · 线路详情", showBackground = true, widthDp = 393, heightDp = 852)
@Composable
private fun StudyTourDetailPreview() {
    MaterialTheme(colorScheme = lightColorScheme(primary = StudyGreen, background = StudyBg)) {
        StudyTourDetail()
    }
}

@Preview(name = "研学 03 · 报名信息", showBackground = true, widthDp = 393, heightDp = 852)
@Composable
private fun StudyTourBookingPreview() {
    MaterialTheme(colorScheme = lightColorScheme(primary = StudyGreen, background = StudyBg)) {
        StudyTourBooking()
    }
}

@Preview(name = "研学 04 · 行程安排", showBackground = true, widthDp = 393, heightDp = 852)
@Composable
private fun StudyTourItineraryPreview() {
    MaterialTheme(colorScheme = lightColorScheme(primary = StudyGreen, background = StudyBg)) {
        StudyTourItinerary()
    }
}
