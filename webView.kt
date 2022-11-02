package mx.edu.widgets

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import mx.edu.widgets.databinding.ActivityCalendarViewBinding
import mx.edu.widgets.databinding.ActivityWebViewBinding

class webView : AppCompatActivity() {

    lateinit var binding: ActivityWebViewBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        webViewSetup()

        binding.btnSiguiente5.setOnClickListener {
            val intent = Intent(this@webView, ratingBar::class.java)
            startActivity(intent)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetJavaScriptEnabled")
    private fun webViewSetup() {
        binding.wbWebView.webViewClient = WebViewClient()

        binding.wbWebView.apply {
            loadUrl("https://www.google.com/")
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
        }
    }

    override fun onBackPressed() {
        if (binding.wbWebView.canGoBack()) binding.wbWebView.goBack() else super.onBackPressed()
    }
}