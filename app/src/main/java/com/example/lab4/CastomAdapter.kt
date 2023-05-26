package com.example.lab4

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.lab4.databinding.StikerItemBinding

 public class CustmAdapter(val listener: Listener) : RecyclerView.Adapter<CustmAdapter.StikHolder>() {
    public val stikerList = ArrayList<Stikers>()
    class StikHolder(item: View):RecyclerView.ViewHolder(item)  {
        val bindind = StikerItemBinding.bind(item)

        fun bind(stikers: Stikers, listener: Listener) = with(bindind){
            tvTitle.text = stikers.title_stiker
            tvOpisan.text = stikers.opisanie_stiker
            itemView.setOnClickListener {
                listener.onClick(stikers)
            }
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StikHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.stiker_item,parent, false)
        return StikHolder(view)
    }

    override fun onBindViewHolder(holder: StikHolder, position: Int) {
        holder.bind(stikerList[position], listener)
    }

    override fun getItemCount(): Int {
        return stikerList.size
    }

    fun addStiker(stikers: Stikers){
        stikerList.add(stikers)
        notifyDataSetChanged()
    }



    interface Listener{
        fun onClick(stikers: Stikers)
    }
}

//class CustmAdapter : RecyclerView.Adapter<CustmAdapter.ViewHolder>() {
//
//
//
////    public val titles = arrayOf("a", "b", "c")
////    public val detals = arrayOf("1","2", "3")
//    var titles = MainActivity2().titles
//    var detals = MainActivity2().titles
//
//
//    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int):ViewHolder{
//        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.recycleview_model,viewGroup, false)
//        return ViewHolder(v)
//    }
//
//    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
//        viewHolder.textTitle.text = titles [i]
//        viewHolder.textDopInf.text = detals [i]
//
////        holder.itemView.setOnClickListener {v = View ->}
//    }
//
//    override fun getItemCount(): Int {
//        return titles.size
//    }
//
////    private val itemTitles = arrayOf("text1", "text2")
////    private val itemDetails = arrayOf("text1Des", "text2Des")
//
//    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
//
//        var textTitle : TextView
//        var textDopInf : TextView
//
//        init {
//            textTitle = itemView.findViewById(R.id.namedelo)
//            textDopInf =itemView.findViewById(R.id.nameopis)
//        }
//        val binding = StikersItemBinding.dind()
//        fun dind(stikers: Stikers) {
//
//        }
//    }
//}



