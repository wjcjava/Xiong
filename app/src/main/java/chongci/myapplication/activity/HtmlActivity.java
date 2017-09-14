package chongci.myapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import chongci.myapplication.R;

public class HtmlActivity extends AppCompatActivity {

    private WebView webview;
    private String html;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html);
        html=getIntent().getStringExtra("hrml");
        initView();
    }

    private void initView() {
        webview = (WebView) findViewById(R.id.webview);
        webview.loadUrl(html);

    }
}
