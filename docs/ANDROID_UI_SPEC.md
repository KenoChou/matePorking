# Android UI 与后端接口映射

## 1. 客户端信息架构

底部主导航固定为五个一级入口：

| Tab | 页面 | 主要功能 | 后端领域 |
| --- | --- | --- | --- |
| Discover | 发现 | 推荐流、趋势、内容详情、搜索 | Discover / Content |
| Community | 圈子 | 圈子发现、圈子详情、成员、帖子 | Social / Community |
| Market | 商城 | 商品列表、商品详情、购物车、订单 | Product / Cart / Order |
| Messages | 消息 | 会话列表、私聊、群聊、通知 | Message / Notification |
| Profile | 我的 | 用户资料、收藏、订单、创作者、商家、设置 | User / Creator / Merchant / Auth |

## 2. 当前已确认接口

依据后端 `docs/api-contract.md`：

| 页面能力 | 方法 | 路径 | 当前状态 |
| --- | --- | --- | --- |
| 发送短信验证码 | POST | `/api/v1/auth/sms/send` | 后端文档标记为当前已有 |
| 短信验证码登录 | POST | `/api/v1/auth/sms/login` | 后端文档标记为当前已有 |
| 刷新 Token | POST | `/api/v1/auth/refresh` | 后端文档标记为当前已有 |
| 登出 | POST | `/api/v1/auth/logout` | 后端文档标记为当前已有 |
| 当前认证主体 | GET | `/api/v1/auth/me` | 后端文档标记为当前已有 |
| 当前用户资料 | GET | `/api/v1/users/me` | 规划接口，需核对实现 |
| 推荐内容流 | GET | `/api/v1/discover/feed` | 规划接口 |
| 商品列表 | GET | `/api/v1/products` | 规划接口 |
| 购物车 | GET | `/api/v1/cart` | 规划接口 |
| 用户订单 | GET | `/api/v1/orders` | 规划接口 |
| IM 会话列表 | GET | `/api/v1/conversations` | 规划接口 |

后端文档明确指出 User、Order 当前仍包含示例/测试性质实现；Payment 仅有基础支付单创建与查询，不能把规划 API 当成已上线能力。

## 3. UI 设计原则

- 原生 Kotlin + Jetpack Compose + Material 3。
- 视觉方向：轻量、年轻、温暖；以浅紫、暖白和珊瑚色作为品牌基调。
- 内容优先：发现页使用大标题、兴趣入口、内容卡片；避免管理后台式表格。
- 页面状态必须覆盖 Loading、Empty、Error、Unauthenticated。
- 未接入 API 的模块展示明确的接入状态，不伪造用户、订单、商品或消息数据。
- 所有需要登录的写操作由服务端授权；客户端仅保存必要的会话凭证。

## 4. 统一 API 约定

成功响应使用 `Result<T>`：

```json
{
  "code": 0,
  "message": "success",
  "data": {}
}
```

分页响应使用 `page`、`size`、`total`、`records`。认证请求使用 `Authorization: Bearer <accessToken>`。

## 5. 下一步接入顺序

1. 配置真实 Gateway Base URL，完成短信发送、登录、Token 生命周期与登出。
2. 核对 User Service 当前真实接口，完成个人资料与账号状态。
3. 建立 Discover / Content API 后接入真实内容流、详情、点赞、评论和收藏。
4. 建立 Product / Cart / Order 的真实接口后接入商城交易。
5. 对接腾讯云 IM SDK，并通过服务端签名接口完成身份映射。
6. 最后接入 Creator、Merchant、Events 等扩展领域。

## 6. 当前工程边界

本仓库当前已建立 Android Gradle 工程骨架、Compose 五 Tab 导航、页面视觉基础和 Retrofit Auth API 契约。Discover 卡片目前是 UI 占位内容，不是后端真实推荐数据；Community、Market、Messages 也尚未接入真实 API。尚未完成 Android Studio 构建验证。
