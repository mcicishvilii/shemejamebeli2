package com.example.anagram


import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.anagram.databinding.ActivityMainBinding


open class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button.setOnClickListener {
            addEditText()
        }
    }

    private fun addEditText(){
        val edittext = EditText(this)

        if (binding.checkbox.isChecked.not()) {
            edittext.setTextColor(Color.RED)
            edittext.hint = "unchecked"
            binding.mainView.removeView(edittext)
            binding.mainView.addView(edittext,binding.mainView.childCount  - 1)
            edittext.textSize = 20f
        }
        else if(binding.checkbox.isChecked)
            edittext.setTextColor(Color.BLUE)
            edittext.hint = "checked"
            binding.mainView.removeView(edittext)
            binding.mainView.addView(edittext,binding.mainView.childCount  - 1)
            edittext.textSize = 20f
    }

}



