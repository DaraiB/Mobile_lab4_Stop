package com.example.lab4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.core.content.ContextCompat.startActivity
import com.example.lab4.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)

        setContentView(binding.root)
        initButtons()

    }
    private fun initButtons() = with(binding){
        button4.setOnClickListener{
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


   fun goOnskreen (view: View){
       finish()
   }
}

//    lateinit var editTextnaz: EditText
//    lateinit var editText1dop: EditText
//
//    public val titles = mutableListOf("a", "b", "c")
//    public val detals = mutableListOf("1","2", "3")
//
//    fun submital(v: View) {
//        editTextnaz = findViewById<View>(R.id.name) as EditText
//        val name = editTextnaz.text.toString()
//        var titles = MainActivity2().titles
//        titles.add(name)
//        print("fhfhfh")
//        Log.d("titles", "titles"+ titles +"aboba")
//
//        editText1dop = findViewById<View>(R.id.name2) as EditText
//        val dop = editTextnaz.text.toString()
//        var detals = MainActivity2().titles
//        detals.add(dop)
//        print(detals)
//        print("mjkjkuk")
//        Log.d("titles", "titles"+ detals +"aboba")
//
//    }
