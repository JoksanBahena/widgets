package mx.edu.widgets

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import mx.edu.widgets.databinding.ActivityVideoViewBinding

class videoView : AppCompatActivity() {

    lateinit var binding: ActivityVideoViewBinding

    var videoView: VideoView? = null

    var mediaController: MediaController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        videoView = findViewById<View>(R.id.vwVideo) as VideoView?

        if (mediaController == null) {
            mediaController = MediaController(this)
            mediaController!!.setAnchorView(this.videoView)
        }

        videoView!!.setMediaController(mediaController)

        videoView!!.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.r6))

        videoView!!.requestFocus()

        videoView!!.start()

        videoView!!.setOnCompletionListener { 
            Toast.makeText(applicationContext, "Video End", Toast.LENGTH_LONG).show()
        }
        
        videoView!!.setOnErrorListener { mediaPlayer, i, i2 ->
            Toast.makeText(applicationContext, "Error", Toast.LENGTH_LONG).show()
            false
        }
    }
}