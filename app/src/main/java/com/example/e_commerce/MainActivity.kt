package com.example.e_commerce

import android.app.AlertDialog
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var firstDatePickerDialog: DatePickerDialog
    private lateinit var secondDatePickerDialog: DatePickerDialog
    private lateinit var firstDateButton: Button
    private lateinit var secondDateButton: Button
    private lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firstInitDatePicker()
        secondInitDatePicker()
        firstDateButton = findViewById(R.id.first_date_button)
        secondDateButton = findViewById(R.id.second_date_button)
        result = findViewById(R.id.result)

        secondDateButton.setOnClickListener {

        }
    }


     private fun firstInitDatePicker() {
        val dateSetListener: DatePickerDialog.OnDateSetListener =
            DatePickerDialog.OnDateSetListener { _, year, month, day ->
                val firstDate: String = makeDatesString(day, month + 1, year)
                firstDateButton.text = firstDate
            }

        val calendar: Calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val style = AlertDialog.BUTTON_POSITIVE
        firstDatePickerDialog = DatePickerDialog(this, style, dateSetListener, year, month, day)
    }

    private fun secondInitDatePicker() {
        val dateSetListener: DatePickerDialog.OnDateSetListener =
            DatePickerDialog.OnDateSetListener { _, year, month, day ->
                val firstDate: String = makeDatesString(day, month + 1, year)
                secondDateButton.text = firstDate
            }

        val calendar: Calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val style = AlertDialog.BUTTON_POSITIVE
        secondDatePickerDialog = DatePickerDialog(this, style, dateSetListener, year, month, day)
    }


    private fun makeDatesString(day: Int, month: Int, year: Int): String {
        return " " + day + " " + getMonthFormat(month) + " " + year
    }

    private fun getMonthFormat(month: Int): String {
        if (month == 1) {
            return "Января"
        }
        if (month == 2) {
            return "Февраля"
        }
        if (month == 3) {
            return "Марта"
        }
        if (month == 4) {
            return "Апреля"
        }
        if (month == 5) {
            return "Мая"
        }
        if (month == 6) {
            return "Июня"
        }
        if (month == 7) {
            return "Июля"
        }
        if (month == 8) {
            return "Августа"
        }
        if (month == 9) {
            return "Сентября"
        }
        if (month == 10) {
            return "Октября"
        }
        if (month == 11) {
            return "Ноября"
        }
        if (month == 12) {
            return "Декабря"
        }
        return " "
    }


    fun openFirstDatePicker(view: View) {
        firstDatePickerDialog.show()
    }

    fun secondFirstDatePicker(view: View) {
        secondDatePickerDialog.show()
    }
}