package com.example.lab4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.lab4.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val item = intent.getSerializableExtra("item") as Stikers
        binding.apply {
            textView8.text = item.title_stiker
            textView9.text = item.opisanie_stiker

            button5.setOnClickListener{

                var stikerList = CustmAdapter().stikerList
                stikerList.removeAll{textView8.text == item.title_stiker}



                finish()

            }


        }
    }

    //val stikerList = ArrayList<Stikers>()
//
//    var myLists = mutableListOf(1,2,3,4,5,6,7,8,9)
//    myLists.removeAll{ it % 2 == 0 }

    private fun initButtons() = with(binding){
        button5.setOnClickListener{
            val namestk = findViewById<EditText>(R.id.name).text.toString()
            val deckstk = findViewById<EditText>(R.id.name2).text.toString()
            val stikers = Stikers(namestk,deckstk )
            val editIntent = Intent().apply {
                putExtra("plant", stikers)
            }
            setResult(RESULT_OK, editIntent)
            finish()
        }
    }




    fun goOnPlus (view: View){
        finish()
    }
}