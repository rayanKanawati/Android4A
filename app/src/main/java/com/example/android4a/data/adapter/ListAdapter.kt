package com.example.android4a.data.adapter

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android4a.R
import com.example.android4a.data.adapter.ListAdapter.ViewHolder
import com.example.android4a.domain.model.Pokemon


class ListAdapter(val items: MutableList<Pokemon>?, val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    var values: MutableList<Pokemon>? = items

    class ViewHolder(var layout: View) : RecyclerView.ViewHolder(layout) {
        // each data item is just a string in this case
        var txtHeader: TextView
        var txtFooter: TextView

        init {
            txtHeader = layout.findViewById<View>(R.id.firstLine) as TextView
            txtFooter = layout.findViewById<View>(R.id.secondLine) as TextView
        }
    }

    fun add(position: Int, item: Pokemon?) {
        values?.add(position, item!!)
        notifyItemInserted(position)
    }

    fun remove(position: Int) {
        values?.removeAt(position)
        notifyItemRemoved(position)
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    fun ListAdapter(myDataset: MutableList<Pokemon>?) {
        values = myDataset!!
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        // create a new view
        val inflater = LayoutInflater.from(
            parent.context
        )
        val v: View = inflater.inflate(R.layout.row_layout, parent, false)
        // set the view's size, margins, paddings and layout parameters
        return ViewHolder(v)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        val name: Pokemon = values!!.get(position)
        holder.txtHeader.text = name.getName()
        holder.txtFooter.text = name.getName()
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return values!!.size
    }
}

