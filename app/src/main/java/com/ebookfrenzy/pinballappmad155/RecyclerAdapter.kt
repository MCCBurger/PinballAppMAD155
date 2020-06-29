package com.ebookfrenzy.pinballappmad155
import  android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
    private val titles = arrayOf("TMNT","Hot Wheels","Willy Wonka")
    private val details = arrayOf("Stern Pinball", "American Pinball", "Jersey Jack Pinball")
    private val images = intArrayOf(R.drawable.tmnt,R.drawable.hotwheels,R.drawable.willy)

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var itemImage:ImageView
        var itemTitle:TextView
        var itemDetail:TextView

        init{
            itemImage =itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detail)

        }

    }

    override fun onCreateViewHolder(viewGroup:ViewGroup,i:Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.directory,viewGroup,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder:ViewHolder,i:Int) {
        viewHolder.itemTitle.text = titles[i]
        viewHolder.itemDetail.text = details[i]
        viewHolder.itemImage.setImageResource(images[i])
    }

    override fun getItemCount(): Int {
        return titles.size
    }
}