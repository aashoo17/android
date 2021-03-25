package com.aashoo17.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/*
RecyclerView:
[RecyclerView how in theory it works](https://developer.android.com/guide/topics/ui/layout/recyclerview)
layout(mostly ConstraintLayout)
put RecyclerView inside layout and postion it give its size etc
in java/kotlin code
after setContentView() i.e. after layout xml is inflated
find the RecyclerView and these 2 things at minimum is required to be done
adapter - this will tell how new view is created and data is loaded, size of RecyclerView
layout manager - this will tell how RecyclerView will display its content say in linear way, in grid etc..
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        //find the recycler view using id
        findViewById<RecyclerView>(R.id.recycler).apply {
            //set the adapter
            adapter = MyAdapter()
            //set its layout manager
            layoutManager = LinearLayoutManager(context)
        }
    }
}

/*
Adapter:
follows the RecyclerView.Adapter<T> pattern
where T is somebody who follows RecyclerView.ViewHolder
onCreateViewHolder() - when new RecyclerView.ViewHolder is required for new data call this function
onBindViewHolder() - call this when data is to be bind to the RecyclerView.ViewHolder
getItemCount() - tells the size of data set
 */
class MyAdapter: RecyclerView.Adapter<Holder>(){
    val list = MutableList(50){it*100}

    //function called when new
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        //inflate android.R.layout.simple_list_item_1 xml file
        //TODO: explain the inflation here
        val view = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1,parent,false)
        //TODO: why RecyclerView.ViewHolder is returned here
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        //change the text of TextView inside RecyclerView.ViewHolder
        holder.textView.text = list[position].toString()
    }

    override fun getItemCount(): Int {
        //return the data size
        return list.size
    }

}

/*
RecyclerView.ViewHolder:
TODO: why a View class is passed in RecyclerView.ViewHolder

 */
class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
    //take the view passed from outside and find the TextView with id text1 in it
    val textView: TextView = itemView.findViewById(android.R.id.text1)
}

