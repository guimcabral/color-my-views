package com.example.colormyviews

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setListeners()
    }

    private fun setListeners() {
        val clickableViews: List<View> = listOf(
            binding.boxOneText,
            binding.boxTwoText,
            binding.boxThreeText,
            binding.boxFourText,
            binding.boxFiveText,
            binding.root,
            binding.redButton,
            binding.greenButton,
            binding.yellowButton
        )

        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }

    private fun makeColored(view: View) {
        binding.apply {
            when (view) {

                // Boxes using Color class colors for background
                boxOneText -> view.setBackgroundColor(Color.DKGRAY)
                boxTwoText -> view.setBackgroundColor(Color.GRAY)

                // Boxes using Android color resources for background
                boxThreeText -> view.setBackgroundResource(android.R.color.holo_green_light)
                boxFourText -> view.setBackgroundResource(android.R.color.holo_green_dark)
                boxFiveText -> view.setBackgroundResource(android.R.color.holo_green_light)

                //Boxes using custom colors for background
                redButton -> boxThreeText.setBackgroundResource(R.color.my_red)
                yellowButton -> boxFourText.setBackgroundResource(R.color.my_green)
                greenButton -> boxFiveText.setBackgroundResource(R.color.my_yellow)

                else -> view.setBackgroundColor(Color.LTGRAY)
            }
        }
    }

}