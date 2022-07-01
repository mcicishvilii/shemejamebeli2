package com.example.anagram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.anagram.databinding.ActivityMainBinding
import java.util.*

val mapOfWords = mutableMapOf<String,String>()

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnSave.setOnClickListener {
            var annagram = binding.etEnterAnagram.text.toString()
            sortArrayAndDisplayCount(annagram)
        }

        binding.btnUpdate.setOnClickListener {

            val userInput = binding.etEnterAnagram.text.toString() // შეუცვლელი
            var str = userInput
            str = str.split("").sorted().joinToString("") // სორტირებული

            if (mapOfWords.containsValue(str)){
                binding.tvAnagramCount.text = "$userInput უკვე არსებობს"
            }
        }
    }

    fun sortArrayAndDisplayCount (annagram:String){
        var str = annagram
        str = str.split("").sorted().joinToString("")
        mapOfWords[annagram] = str
        binding.tvAnagramCount.text = mapOfWords.size.toString()
    }
}