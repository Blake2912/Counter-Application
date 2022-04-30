package com.test.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var counterTextView: TextView

    private var counter:Int = 0
    private val timer = MyCounter(100000,1000)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counterTextView = findViewById<TextView>(R.id.counter_val_tv)
        val startBtn: Button = findViewById<Button>(R.id.startBtn)
        val stopBtn: Button = findViewById<Button>(R.id.stopBtn)
        val resetBtn: Button = findViewById<Button>(R.id.resetBtn)

        counterTextView.visibility = View.GONE

        startBtn.setOnClickListener(View.OnClickListener {
            counterTextView.visibility = View.VISIBLE
            timer.start()
        })

        stopBtn.setOnClickListener(View.OnClickListener {
            timer.cancel()
        })

        resetBtn.setOnClickListener(View.OnClickListener {
            counterTextView.text = "0"
            counter = 0
        })

    }
    inner class MyCounter(millisInFuture: Long, countDownInterval: Long) : CountDownTimer (millisInFuture, countDownInterval) {
        override fun onFinish() {

        }

        override fun onTick(millisUntilFinished: Long) {
            counter++
            counterTextView.text = counter.toString()
        }
    }
}