package mx.edu.widgets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.edu.widgets.databinding.ActivityDatePickerBinding
import mx.edu.widgets.databinding.ActivitySeekBarBinding

class datePicker : AppCompatActivity() {

    lateinit var binding: ActivityDatePickerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDatePickerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etDate.setOnClickListener { showDatePickerDialog( ) }

        binding.btnSiguiente2.setOnClickListener {
            val intent = Intent(this@datePicker, timePicker::class.java)
            startActivity(intent)
        }
    }

    private fun showDatePickerDialog() {
        val datePicker = DatePickerFragment {day, month, year -> onDateSelected(day, month, year)}
        datePicker.show(supportFragmentManager, "datePicker")

    }

    fun onDateSelected(day: Int, month: Int, year: Int) {
        binding.etDate.setText("Has seleccionado: $day / $month / $year")
    }
}