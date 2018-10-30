package com.lucasnobile.myapp.presentation.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.lucasnobile.myapp.R
import com.lucasnobile.myapp.data.model.Laptop
import com.lucasnobile.myapp.presentation.view.ShowLaptopListFragment
import com.squareup.picasso.Picasso

/**
 * Adapter for laptop data.
 *
 * @author lucas.nobile
 */
class LaptopAdapter(private var laptopList: List<Laptop>, private val listener: ShowLaptopListFragment.OnLaptopSelectedListener?)
    : RecyclerView.Adapter<LaptopAdapter.LaptopViewHolder>() {

    // Single-line function
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = LaptopViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.laptop_item, parent, false))

    // Single-line function
    override fun onBindViewHolder(holder: LaptopViewHolder, position: Int) = holder.bind(laptopList[position])

    // Single-line function
    override fun getItemCount() = laptopList.size

    fun addLaptopList(laptopList: List<Laptop>) {
        this.laptopList = laptopList
        notifyDataSetChanged()
    }

    inner class LaptopViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var laptop: Laptop

        init {
            itemView.setOnClickListener { listener?.onLaptopSelected(laptop) }
        }

        fun bind(laptop: Laptop) {
            val imgLaptop: ImageView = itemView.findViewById(R.id.imgLaptop)
            val txtTitle: TextView = itemView.findViewById(R.id.txtTitle)
            val txtDescription: TextView = itemView.findViewById(R.id.txtDescription)

            this.laptop = laptop

            txtTitle.text = laptop.title
            txtDescription.text = laptop.description

            Picasso.get()
                    .load(laptop.imageUrl)
                    .placeholder(R.mipmap.ic_launcher_round)// optional
                    // TODO .error(R.drawable.sync)
                    .into(imgLaptop)
        }
    }
}