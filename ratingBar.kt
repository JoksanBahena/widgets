package mx.edu.widgets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.edu.widgets.databinding.ActivityRatingBarBinding

class ratingBar : AppCompatActivity() {

    lateinit var binding: ActivityRatingBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRatingBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rtRating.setOnRatingBarChangeListener { ratingBar, fl, b ->
            binding.txtRating.text = fl.toString()
        }

        binding.btnSiguiente6.setOnClickListener {
            val intent = Intent(this@ratingBar, videoView::class.java)
            startActivity(intent)
        }
    }
}