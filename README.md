# AURA (Autonomous Universal Robotic Agent)

> **"God Mode" for your Android device.**

AURA is an open-source, on-device AI agent that uses Android's **Accessibility Service** to autonomously interact with applications. It can observe the screen, plan actions, and execute clicks/scrolls/inputs to automate complex workflows.

## 🚀 Features
- **God Mode Control**: Programmatic control of the device UI via Accessibility.
- **NodeFinder**: Intelligent UI element detection (by Text, ID, Description).
- **Floating Overlay**: Always-on-top control panel for the agent.
- **Privacy First**: All processing happens locally on the device.

## 🛠️ Tech Stack
- **Language**: Kotlin 1.9
- **UI**: Jetpack Compose (Material 3)
- **Architecture**: Clean Architecture + MVVM
- **Dependency Injection**: Hilt
- **Local Data**: Room Database
- **Core API**: `AccessibilityService`

## 📦 Setup & Installation
1.  Clone the repository.
2.  Open in **Android Studio Iguana** (or newer).
3.  Sync Gradle project.
4.  Run on an Android Emulator or Physical Device (Android 8.0+).

## ⚠️ Permissions
To function, AURA requires two sensitive permissions:
1.  **Accessibility Service**: To read screen content and inject gestures.
2.  **Display Over Other Apps**: To show the floating control overlay.

*The app will prompt you to enable these on first launch.*

## 🤝 Contributing
We welcome contributions! Please follow the `GEMINI.MD` guidelines for coding standards.

**License**: MIT
