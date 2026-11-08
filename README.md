# matePorking — AniMate Android UI Prototype

Native Android UI prototype for the AniMate product, built with Kotlin and Jetpack Compose.

## Current scope

This repository is currently focused on **UI design and page-level previews only**.

- No backend API requests are required to browse the prototype.
- Screen content is local presentation data and must not be treated as production data.
- No real login, checkout, payment, messaging, creator operations, or merchant operations are performed.
- The `animate` backend is the product-domain reference for information architecture; backend integration is explicitly out of scope for this UI phase.

## Run the prototype

1. Open the repository in Android Studio.
2. Allow Gradle sync to finish.
3. Select the `app` run configuration.
4. Run on an emulator or Android device.

The app launches directly into the in-app **Preview Gallery**.

## Browse page previews

The gallery groups screens by product domain. Select a category, then tap a page to open its dedicated Compose layout.

The project includes **34 individual page-level Compose previews** in:

- `ui/preview/HighFidelityPreviews.kt` — actual page layouts used by the gallery
- `ui/preview/PreviewGallery.kt` — searchable gallery entry point
- `ui/preview/ScreenPreviews.kt` — design exploration references

In Android Studio, open `HighFidelityPreviews.kt` and switch to Design or Split view. Each page has its own named `@Preview` at a 393 × 852 dp phone viewport. You can inspect a single page without launching the app.

## UI modules

- Authentication: welcome, phone login, verification
- Discover: feed, trends, search, content detail
- Community: circle discovery, circle detail, member list
- Market: storefront, categories, product detail, cart
- Orders: order list, order detail, payment result
- Messages: conversation list, chat detail, notifications
- Profile: profile home, edit profile, favorites, settings
- Creator: creator dashboard, works, analytics
- Merchant: merchant dashboard, product management, shop settings
- Events: event list, event detail, registration, tickets

## Design language

- Material 3 with native Compose components
- Warm white surfaces, soft lavender accents, restrained coral highlights
- Rounded cards, clear hierarchy, content-first layouts
- Local static presentation data, visibly treated as illustrative samples

## Build verification

Run the following from the repository root:

```bash
./gradlew :app:assembleDebug
```

A successful source commit does not imply that Gradle compilation has passed. Record build verification separately after running the command in an Android SDK-enabled environment.
