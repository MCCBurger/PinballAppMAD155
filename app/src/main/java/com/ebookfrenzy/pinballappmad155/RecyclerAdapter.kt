package com.ebookfrenzy.pinballappmad155
import android.content.Intent
import android.net.Uri
import  android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar


class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
    private val titles = arrayOf("TMNT","Hot Wheels","Rick and Morty","Willy Wonka","Jurassic Park","Indiana Jones")
    private val details = arrayOf("Stern Pinball: Released 2020", "American Pinball: Released 2020", "Spooky Pinball: Released 2020","Jersey Jack Pinball: Released 2019" ,"Stern Pinball: Released: 2019", "Williams Pinball: Released 1993")
    private val images = intArrayOf(R.drawable.tmntb,R.drawable.hotwheels,R.drawable.rick,R.drawable.willy,R.drawable.jurassic,R.drawable.jones)

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detail)

            itemView.setOnClickListener { v: View ->

                var position: Int = adapterPosition
                var website = ""
                if (position != null) {

                    when (position) {
                        0 -> website = "https://sternpinball.com/"
                        1 -> website = "https://www.american-pinball.com/"
                        2 -> website = "https://www.spookypinball.com/"
                        3 -> website = "https://www.jerseyjackpinball.com/"
                        4 -> website = "https://sternpinball.com/"
                        5 -> website = "https://en.wikipedia.org/wiki/WMS_Industries"
                        else -> {
                            website = "www.google.com"
                        }

                    }
                 val open = Intent(Intent.ACTION_VIEW)
                    open.data = Uri.parse(website)
                    v.context.startActivity(open)
                }
            }

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