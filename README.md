# QBindingQuery

一个极简的 Android 应用：内置 WebView 加载本地页面，用于查询 QQ 号关联的绑定信息，并支持一键复制整理后的结果。

## 功能

- 输入 5-12 位 QQ 号发起查询（HTTPS 请求，页面不保存记录）
- 结果按字段分类展示（名称、昵称、手机号、邮箱等）
- 「复制整理后的结果」通过 JS 桥接写入系统剪贴板

## 技术栈

- 原生 Android（Java），无第三方依赖
- WebView + `loadDataWithBaseURL`，前端页面位于 `app/src/main/assets/index.html`
- `ClipboardBridge` 提供 `window.AndroidClipboard` JS 接口

## 构建

需要 JDK 17+ 与 Android SDK（compileSdk 37）。

```powershell
# Debug
.\gradlew.bat assembleDebug

# Release（需要 keystore.properties 与 app/keystore/release.jks，已 gitignore）
.\gradlew.bat assembleRelease
```

签名配置从 `keystore.properties` 读取（`storeFile` / `storePassword` / `keyAlias` / `keyPassword`）。

## 项目结构

```
app/src/main/
├── AndroidManifest.xml
├── assets/index.html        # 前端页面
├── java/com/local/qqbinding/
│   ├── MainActivity.java    # WebView 宿主
│   └── ClipboardBridge.java # JS 剪贴板桥
└── res/values/styles.xml
```
