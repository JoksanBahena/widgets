package mx.edu.widgets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.edu.widgets.databinding.ActivityDatePickerBinding
import mx.edu.widgets.databinding.ActivityTimePickerBinding

class timePicker : AppCompatActivity() {

    lateinit var binding: ActivityTimePickerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTimePickerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.edtTime.setOnClickListener { showTimePickerDialog() }

        binding.btnSiguiente3.setOnClickListener {
            val intent = Intent(this@timePicker, calendarView::class.java)
            startActivity(intent)
        }
    }

    private fun showTimePickerDialog() {
        val timePicker = TimePickerFragment{onTimeSelected(it)}
        timePicker.show(supportFragmentManager, "time")
    }

    private fun onTimeSelected(time: String) {
        binding.edtTime.setText("Has seleccionado: $time")
    }
}