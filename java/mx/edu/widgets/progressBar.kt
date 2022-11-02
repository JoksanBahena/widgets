package mx.edu.widgets

import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import mx.edu.widgets.databinding.ActivityMainBinding

class progressBar : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.progressBar.max = 1000

        val currentProgress = 600

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)

        ObjectAnimator.ofInt(progressBar, "progress", currentProgress)
            .setDuration(2000)
            .start()

        binding.btnSiguiente.setOnClickListener {
            val intent = Intent(this@progressBar, seekBar::class.java)
            startActivity(intent)
        }
    }
}