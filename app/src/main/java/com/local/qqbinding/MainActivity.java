package com.local.qqbinding;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.webkit.WebView;

import java.io.InputStream;
import java.util.Scanner;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WebView webView = new WebView(this);
        setContentView(webView);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.addJavascriptInterface(new ClipboardBridge(this), "AndroidClipboard");

        String html = readAsset(getAssets(), "index.html");
        webView.loadDataWithBaseURL("https://library.aiuys.com/", html, "text/html", "UTF-8", null);
    }

    /** Reads an asset file fully into a UTF-8 String. Returns "" on any failure. */
    private static String readAsset(AssetManager assets, String name) {
        try {
            InputStream in = assets.open(name);
            Scanner scanner = new Scanner(in, "UTF-8").useDelimiter("\\A");
            String text = scanner.hasNext() ? scanner.next() : "";
            scanner.close();
            in.close();
            return text;
        } catch (Exception e) {
            return "";
        }
    }
}
