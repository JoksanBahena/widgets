package mx.edu.widgets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import android.widget.TextView
import mx.edu.widgets.databinding.ActivityCalendarViewBinding
import mx.edu.widgets.databinding.ActivityTimePickerBinding

class calendarView : AppCompatActivity() {

    lateinit var binding: ActivityCalendarViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalendarViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calendarView.setOnDateChangeListener(CalendarView.OnDateChangeListener { view, year, month, dayOfMonth ->
            val Date = (dayOfMonth.toString() + "-"
                    + (month + 1) + "-" + year)

            // set this date in TextView for Display
            binding.idTVDate.setText(Date)
        })

        binding.btnSiguiente4.setOnClickListener {
            val intent = Intent(this@calendarView, webView::class.java)
            startActivity(intent)
        }
    }
}