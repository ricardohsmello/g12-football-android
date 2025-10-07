package br.com.g12.ui.charts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import br.com.g12.databinding.FragmentChartsBinding

class ChartsFragment : Fragment() {

    private var _binding: FragmentChartsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val chartsViewModel = ViewModelProvider(this)[ChartsViewModel::class.java]
        _binding = FragmentChartsBinding.inflate(inflater, container, false)

        val root: View = binding.root
        setupWebView(binding.webViewCharts)
        return root
    }

    private fun setupWebView(webView: WebView) {
        webView.webViewClient = WebViewClient() // abre dentro do app
        val settings: WebSettings = webView.settings
        settings.javaScriptEnabled = true
        settings.domStorageEnabled = true
        settings.loadWithOverviewMode = true
        settings.useWideViewPort = true

        val chartUrl =
            "https://charts.mongodb.com/charts-g12-jngvndg/embed/charts?id=a0f95b62-58dd-40bb-ad8c-77bc9c3b8181&maxDataAge=14400&theme=light&autoRefresh=true"
        webView.loadUrl(chartUrl)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
