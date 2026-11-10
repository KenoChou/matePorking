package com.kenochou.mateporking.ui.stardoor

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kenochou.mateporking.ui.preview.ContentDetailScreen
import com.kenochou.mateporking.ui.preview.ContentPublishScreen
import com.kenochou.mateporking.ui.preview.ConversationListScreen
import com.kenochou.mateporking.ui.preview.MarketHomeScreen
import com.kenochou.mateporking.ui.preview.ProfileHomeScreen
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalTime
import java.time.format.DateTimeFormatter

private val Ink = Color(0xFF292431)
private val Muted = Color(0xFF898391)
private val Purple = Color(0xFF8D70B1)
private val Canvas = Color(0xFFF8F5FA)
private val Night = Color(0xFF211C2B)

data class LoginUiState(
    val phone: String = "", val code: String = "", val password: String = "",
    val passwordMode: Boolean = false, val agreed: Boolean = false,
    val seconds: Int = 0, val privacy: Boolean = false, val error: String? = null, val previewEntered: Boolean = false
)

class StarDoorViewModel : ViewModel() {
    private val _state = MutableStateFlow(LoginUiState())
    val state: StateFlow<LoginUiState> = _state.asStateFlow()
    fun phone(v: String) = _state.update { it.copy(phone = v.filter(Char::isDigit).take(11), error = null) }
    fun code(v: String) = _state.update { it.copy(code = v.filter(Char::isDigit).take(6), error = null) }
    fun password(v: String) = _state.update { it.copy(password = v, error = null) }
    fun mode(v: Boolean) = _state.update { it.copy(passwordMode = v, error = null) }
    fun agree(v: Boolean) = _state.update { it.copy(agreed = v, error = null) }
    fun privacy(v: Boolean) = _state.update { it.copy(privacy = v) }
    fun enterPreview() = _state.update { it.copy(previewEntered = true) }

    fun requestCode() {
        if (!_state.value.phone.matches(Regex("1[3-9]\\d{9}"))) {
            _state.update { it.copy(error = "请输入正确的 11 位手机号") }; return
        }
        if (_state.value.seconds > 0) return
        // UI prototype only. Connect AuthApi.sendSms before production use.
        viewModelScope.launch {
            _state.update { it.copy(seconds = 60, error = null) }
            while (_state.value.seconds > 0) {
                delay(1_000)
                _state.update { it.copy(seconds = (it.seconds - 1).coerceAtLeast(0)) }
            }
        }
    }

    fun login() {
        val s = _state.value
        val validPhone = s.phone.matches(Regex("1[3-9]\\d{9}"))
        val message = when {
            !validPhone -> "请先填写正确的手机号"
            !s.agreed -> "请先阅读并同意用户协议与隐私政策"
            s.passwordMode && s.password.isBlank() -> "请输入账号密码"
            !s.passwordMode && s.code.length != 6 -> "请输入 6 位验证码"
            else -> "当前为 UI 演示，尚未连接真实认证服务"
        }
        _state.update { it.copy(error = message) }
    }
}

@Composable
fun StarDoorApp(viewModel: StarDoorViewModel = viewModel()) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    MaterialTheme(colorScheme = lightColorScheme(primary = Purple, secondary = Color(0xFFE9A9C2), background = Canvas, surface = Color.White)) {
        if (state.previewEntered) StarDoorMainShell() else StarDoorLoginScreen(state, viewModel)
    }
}

@Composable
private fun StarDoorLoginScreen(s: LoginUiState, vm: StarDoorViewModel) {
    var time by remember { mutableStateOf(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"))) }
    LaunchedEffect(Unit) {
        while (true) { time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")); delay(30_000) }
    }
    Box(Modifier.fillMaxSize().background(Brush.verticalGradient(listOf(Night, Color(0xFF3B2B4D), Canvas)))) {
        Column(Modifier.fillMaxSize().statusBarsPadding().padding(horizontal = 22.dp)) {
            Row(Modifier.padding(top = 10.dp, bottom = 20.dp), verticalAlignment = Alignment.CenterVertically) {
                Text(time, color = Color.White, fontSize = 13.sp)
                Spacer(Modifier.weight(1f))
                Text("STAR DOOR  ✦", color = Color.White.copy(alpha = .8f), fontSize = 10.sp, letterSpacing = 2.sp)
            }
            Icon(Icons.Rounded.ArrowBack, "返回", tint = Color.White)
            Spacer(Modifier.height(18.dp))
            Text("STAR DOOR", color = Color(0xFFE8D9FA), fontSize = 11.sp, fontWeight = FontWeight.Bold, letterSpacing = 3.sp)
            Text("星门", color = Color.White, fontSize = 38.sp, fontWeight = FontWeight.Black)
            Text("亚文化综合平台 · 让热爱找到同频", color = Color.White.copy(alpha = .75f), fontSize = 12.sp)
            Spacer(Modifier.height(24.dp))
            Surface(Modifier.fillMaxSize(), shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp), color = Canvas) {
                Column(Modifier.fillMaxSize().padding(22.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
                    Text("欢迎来到星门", color = Ink, fontSize = 23.sp, fontWeight = FontWeight.Bold)
                    Text("登录后继续探索作品、展会与兴趣社群", color = Muted, fontSize = 12.sp)
                    Row(Modifier.fillMaxWidth().background(Color(0xFFEDE8F1), RoundedCornerShape(12.dp)).padding(4.dp)) {
                        ModeChip("验证码登录", !s.passwordMode, Modifier.weight(1f)) { vm.mode(false) }
                        ModeChip("密码登录", s.passwordMode, Modifier.weight(1f)) { vm.mode(true) }
                    }
                    OutlinedTextField(
                        value = s.phone, onValueChange = vm::phone, modifier = Modifier.fillMaxWidth(),
                        leadingIcon = { Text("+86", color = Ink, fontWeight = FontWeight.SemiBold) },
                        placeholder = { Text("请输入手机号码", fontSize = 13.sp) }, singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                        shape = RoundedCornerShape(14.dp), colors = fieldColors()
                    )
                    if (s.passwordMode) {
                        OutlinedTextField(
                            value = s.password, onValueChange = vm::password, modifier = Modifier.fillMaxWidth(),
                            placeholder = { Text("请输入账号密码", fontSize = 13.sp) },
                            visualTransformation = PasswordVisualTransformation(), singleLine = true,
                            shape = RoundedCornerShape(14.dp), colors = fieldColors()
                        )
                    } else {
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
                            OutlinedTextField(
                                value = s.code, onValueChange = vm::code, modifier = Modifier.weight(1f),
                                placeholder = { Text("请输入验证码", fontSize = 13.sp) }, singleLine = true,
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                shape = RoundedCornerShape(14.dp), colors = fieldColors()
                            )
                            OutlinedButton(onClick = vm::requestCode, enabled = s.seconds == 0, modifier = Modifier.height(56.dp)) {
                                Text(if (s.seconds > 0) "重新发送验证码 (" + s.seconds + "s)" else "获取验证码", fontSize = 10.sp)
                            }
                        }
                    }
                    if (s.error != null) Text(s.error, color = Color(0xFFB65E72), fontSize = 11.sp)
                    Button(onClick = vm::login, modifier = Modifier.fillMaxWidth().height(52.dp), shape = RoundedCornerShape(15.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Night)) {
                        Text("验证登录 / 登陆", color = Color.White, fontWeight = FontWeight.SemiBold)
                    }
                    Row(verticalAlignment = Alignment.Top) {
                        Checkbox(checked = s.agreed, onCheckedChange = vm::agree, modifier = Modifier.size(22.dp))
                        Column(Modifier.weight(1f)) {
                            Text("我已阅读并同意《用户协议》、《隐私政策》，未注册绑定的手机号验证成功后将自动注册", color = Muted, fontSize = 10.sp, lineHeight = 16.sp)
                            TextButton(onClick = { vm.privacy(true) }, contentPadding = PaddingValues(0.dp)) {
                                Text("查看个人信息保护提示", color = Purple, fontSize = 10.sp)
                            }
                        }
                    }
                    OutlinedButton(onClick = vm::enterPreview, modifier = Modifier.fillMaxWidth()) { Text("直接进入界面预览（不登录）") }
                    Spacer(Modifier.weight(1f))
                    Text("未满 18 周岁的用户请在监护人指导下使用。", color = Muted, fontSize = 9.sp)
                }
            }
        }
    }
    if (s.privacy) AlertDialog(
        onDismissRequest = { vm.privacy(false) },
        title = { Text("个人信息保护提示", fontWeight = FontWeight.Bold) },
        text = { Column(verticalArrangement = Arrangement.spacedBy(9.dp)) {
            Text("为提供账号安全及基础服务，我们仅在必要范围内处理相关信息。", fontSize = 12.sp)
            Text("• 设备与网络信息：包括 IP 地址、设备标识及必要的网络诊断信息。", fontSize = 11.sp)
            Text("• MAC 地址：仅在操作系统权限及适用法律允许且确有必要时处理，不作为默认采集项。", fontSize = 11.sp)
            Text("• 未成年人保护：未满 18 周岁的用户应在监护人指导下使用，并遵循适用的未成年人保护规则。", fontSize = 11.sp)
        } },
        confirmButton = { TextButton(onClick = { vm.privacy(false) }) { Text("我知道了") } }
    )
}

@Composable
private fun ModeChip(label: String, selected: Boolean, modifier: Modifier, onClick: () -> Unit) {
    Surface(modifier.clickable(onClick = onClick), color = if (selected) Color.White else Color.Transparent, shape = RoundedCornerShape(9.dp)) {
        Text(label, Modifier.padding(vertical = 10.dp), color = if (selected) Ink else Muted, fontSize = 11.sp, textAlign = androidx.compose.ui.text.style.TextAlign.Center)
    }
}

@Composable
private fun fieldColors() = OutlinedTextFieldDefaults.colors(
    unfocusedContainerColor = Color.White, focusedContainerColor = Color.White,
    unfocusedBorderColor = Color(0xFFE7E1EB), focusedBorderColor = Purple
)

private enum class Tab(val title: String, val icon: androidx.compose.ui.graphics.vector.ImageVector) {
    CREATE("创作", Icons.Rounded.AddBox), EVENTS("展聚", Icons.Rounded.Event),
    IM("IM", Icons.Rounded.ChatBubbleOutline), STORE("电商", Icons.Rounded.ShoppingBag),
    PROFILE("我的", Icons.Rounded.PersonOutline)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun StarDoorMainShell() {
    var selected by remember { mutableStateOf(Tab.CREATE) }
    var detail by remember { mutableStateOf(false) }
    var gift by remember { mutableStateOf(false) }
    Scaffold(containerColor = Canvas, bottomBar = {
        NavigationBar(containerColor = Color.White) {
            Tab.entries.forEach { tab ->
                NavigationBarItem(selected == tab, { selected = tab; detail = false },
                    icon = { Icon(tab.icon, tab.title) }, label = { Text(tab.title, fontSize = 10.sp) })
            }
        }
    }) { padding ->
        Box(Modifier.fillMaxSize().padding(padding)) {
            if (detail) ContentDetailScreen() else when (selected) {
                Tab.CREATE -> Column {
                    Row(Modifier.fillMaxWidth().background(Color.White).padding(horizontal = 16.dp, vertical = 8.dp), verticalAlignment = Alignment.CenterVertically) {
                        Column(Modifier.weight(1f)) {
                            Text("STAR DOOR  ✦", color = Purple, fontSize = 9.sp, fontWeight = FontWeight.Bold)
                            Text("创作中心", color = Ink, fontSize = 19.sp, fontWeight = FontWeight.Bold)
                        }
                        TextButton(onClick = { gift = true }) { Text("礼物任务") }
                    }
                    ContentPublishScreen()
                }
                Tab.EVENTS -> ExhibitionsScreen { detail = true }
                Tab.IM -> ConversationListScreen()
                Tab.STORE -> MarketHomeScreen()
                Tab.PROFILE -> ProfileHomeScreen()
            }
        }
    }
    if (gift) ModalBottomSheet(onDismissRequest = { gift = false }, containerColor = Color.White) {
        Column(Modifier.fillMaxWidth().padding(22.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
            Text("创作者礼物计划", color = Ink, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text("看广告解锁礼物打赏 · 30 秒后领取礼物", color = Muted, fontSize = 12.sp)
            Text("当前为交互原型，尚未接入广告平台，不会发放真实礼物。", color = Muted, fontSize = 10.sp)
            Button(onClick = { gift = false }, modifier = Modifier.fillMaxWidth()) { Text("知道了") }
        }
    }
}

@Composable
private fun ExhibitionsScreen(onOpenWork: () -> Unit) {
    val events = listOf(
        listOf("星门同人创作展", "上海 · 周六 10:00", "原创插画 / 同人作品 / 创作者交流"),
        listOf("次元收藏交换集", "杭州 · 11 月 22 日", "模型手办 / 徽章 / 收藏卡交换"),
        listOf("独立游戏试玩会", "线上 · 预约开放", "独立游戏 / 桌游 / 开发者分享")
    )
    LazyColumn(Modifier.fillMaxSize().background(Canvas), contentPadding = PaddingValues(18.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
        item {
            Text("STAR DOOR / EVENTS", color = Purple, fontSize = 9.sp, fontWeight = FontWeight.Bold)
            Text("展会与同好聚会", color = Ink, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text("把线上热爱，带到线下相遇。", color = Muted, fontSize = 12.sp)
        }
        items(events) { event ->
            Surface(color = Color.White, shape = RoundedCornerShape(20.dp), modifier = Modifier.fillMaxWidth().clickable(onClick = onOpenWork)) {
                Column {
                    Box(Modifier.fillMaxWidth().height(110.dp).background(Brush.linearGradient(listOf(Color(0xFFE6DDF0), Color(0xFFF3DDE4), Color(0xFFDCE8E8)))), contentAlignment = Alignment.Center) {
                        Text("✧  STARD00R MEETUP", color = Color(0xFF6D5C7D), fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    }
                    Column(Modifier.padding(15.dp), verticalArrangement = Arrangement.spacedBy(5.dp)) {
                        Text(event[0], color = Ink, fontSize = 15.sp, fontWeight = FontWeight.Bold)
                        Text(event[1], color = Purple, fontSize = 10.sp)
                        Text(event[2], color = Muted, fontSize = 11.sp)
                    }
                }
            }
        }
    }
}
