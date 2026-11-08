# matePorking — AniMate Android Client

Native Android client for the AniMate platform.

## UI direction

- Native Kotlin + Jetpack Compose + Material 3.
- Bottom navigation: Discover, Community, Market, Messages, Profile.
- Authenticated API calls use `Authorization: Bearer <accessToken>`.
- API responses follow the backend `Result<T>` envelope: `code`, `message`, `data`.
- Paginated lists follow `PageResult<T>`: `page`, `size`, `total`, `records`.

## Backend integration status

The backend API contract currently confirms the authentication routes under `/api/v1/auth`. The User and Order modules still contain example/test behavior, Payment supports basic payment record creation and lookup, and most Discover, Community, Market, Creator, Events, and Message routes in `docs/api-contract.md` are proposals rather than implemented endpoints.

The Android UI must therefore distinguish live API-backed features from planned modules. Do not present planned endpoints as working production features.

## Main navigation

1. Discover — feed and trending content.
2. Community — circles and social interactions.
3. Market — product discovery and shopping.
4. Messages — conversations and notifications.
5. Profile — account, creator/merchant entry points, orders and settings.

## Build

Open this repository in Android Studio and run the `app` configuration. Configure the backend Gateway base URL for the target environment before API integration.
