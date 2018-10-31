package com.lucasnobile.myapp.presentation.feature.showLaptopList.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.lucasnobile.myapp.R
import com.lucasnobile.myapp.presentation.ext.loadFromUrl
import com.lucasnobile.myapp.presentation.feature.showLaptopList.view.ShowLaptopListFragment
import com.lucasnobile.myapp.presentation.model.LaptopUI

/**
 * Adapter for laptop data.
 *
 * @author lucas.nobile
 */
class LaptopAdapter(private var laptopUIList: List<LaptopUI>, private val listener: ShowLaptopListFragment.OnLaptopUISelectedListener?)
    : RecyclerView.Adapter<LaptopAdapter.LaptopViewHolder>() {

    // Single-line function
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = LaptopViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.laptop_item, parent, false))

    // Single-line function
    override fun onBindViewHolder(holder: LaptopViewHolder, position: Int) = holder.bind(laptopUIList[position])

    // Single-line function
    override fun getItemCount() = laptopUIList.size

    fun addLaptopUIList(laptopUIList: List<LaptopUI>) {
        this.laptopUIList = laptopUIList
        notifyDataSetChanged()
    }

    inner class LaptopViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var laptopUI: LaptopUI

        init {
            itemView.setOnClickListener { listener?.onLaptopUISelected(laptopUI) }
        }

        fun bind(laptopUI: LaptopUI) {
            val imgLaptop: ImageView = itemView.findViewById(R.id.imgLaptop)
            val txtTitle: TextView = itemView.findViewById(R.id.txtTitle)
            val txtDescription: TextView = itemView.findViewById(R.id.txtDescription)

            this.laptopUI = laptopUI

            imgLaptop.loadFromUrl(laptopUI.imageUrl)
            txtTitle.text = laptopUI.title
            txtDescription.text = laptopUI.description
        }
    }
}