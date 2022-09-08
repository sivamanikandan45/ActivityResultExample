package com.example.activityresultexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private lateinit var image:ImageView
    private lateinit var btn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        image=findViewById(R.id.imageview)
        btn=findViewById(R.id.button)
        btn.setOnClickListener {
            //println(it)
            resultLauncher.launch("image/*")
        }
    }

    val resultLauncher=registerForActivityResult(ActivityResultContracts.GetContent()){
        println(it)
        /*intent= Intent()
        intent.type="image/*"
        intent.action=Intent.ACTION_GET_CONTENT*/
         */
        image.setImageURI(it)
    }
}