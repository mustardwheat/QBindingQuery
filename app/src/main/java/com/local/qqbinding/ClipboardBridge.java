package com.local.qqbinding;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.webkit.JavascriptInterface;

public class ClipboardBridge {

    private final Context context;

    public ClipboardBridge(Context context) {
        this.context = context;
    }

    @JavascriptInterface
    public void copy(String text) {
        ClipboardManager clipboard =
                (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        clipboard.setPrimaryClip(ClipData.newPlainText("QQ绑定查询结果", text));
    }
}
