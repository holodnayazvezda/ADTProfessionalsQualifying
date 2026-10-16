# ADTProfessionalsQualifying

Учебный интерфейс приложения для медитации, сна и музыки на Kotlin и Jetpack Compose. Включает приветственный экран, главный раздел и тематические экраны с нижней навигацией.

## Сборка и запуск

Откройте корень проекта в Android Studio, установите Android SDK 36 и выполните синхронизацию Gradle. Используйте JDK, совместимый с версией Android Gradle Plugin проекта; настройки Java указаны в `app/build.gradle.kts`. Минимальная версия устройства — Android API 27.

Для сборки отладочного APK:

```sh
sh gradlew :app:assembleDebug
```

В Windows: `gradlew.bat :app:assembleDebug`. APK появится в `app/build/outputs/apk/debug/`. Для запуска выберите модуль `app` и устройство или эмулятор в Android Studio.

## Устройство проекта

Экраны и компоненты находятся в `app/src/main/java/com/example/adtprofessionalsqualifying/ui/`, маршруты — в `navigation/`. Проект демонстрирует интерфейс; наличие экранов музыки не означает интеграцию с музыкальным сервисом.
