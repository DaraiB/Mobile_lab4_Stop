package com.example.lab4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CustmAdapter.Listener {
    lateinit var binding: ActivityMainBinding
    private val adapter = CustmAdapter(this)
    private var editLauncher: ActivityResultLauncher<Intent>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == RESULT_OK){
                adapter.addStiker(it.data?.getSerializableExtra("plant") as Stikers)
            }
        }






//        var titles = MainActivity2().titles
//
//        fun display (titles: String, ) {
//            val textView = findViewById<View>(R.id.textView7) as TextView
//            textView.text = ""+titles
      }

    private fun init(){
        binding.apply {
            recyclerView1.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView1.adapter = adapter
            button.setOnClickListener {
                editLauncher?.launch(Intent(this@MainActivity, MainActivity2::class.java))
            }
        }
    }

    override fun onClick(stikers: Stikers) {
        startActivity(Intent(this,MainActivity3::class.java). apply {
            putExtra("item", stikers)
        })
    }
//
//        this.supportActionBar?. hide()
//
//        val reculerView1 = findViewById<RecyclerView>(R.id.recyclerView1)
//        val adapter = CustmAdapter()
//
//        reculerView1.layoutManager = LinearLayoutManager(this)
//        reculerView1.adapter = adapter
//    }
//
//    fun goOnPlus (view: View){
//        val smt = Intent(this, MainActivity2:: class.java)
//        startActivity(smt)
//    }
//
//    fun goOnDetals (view: View){
//        val smt = Intent(this, MainActivity3:: class.java)
//        startActivity(smt)
//    }
}