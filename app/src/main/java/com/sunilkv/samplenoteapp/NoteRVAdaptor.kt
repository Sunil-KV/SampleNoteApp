package com.sunilkv.samplenoteapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView

class NoteRVAdaptor(
    val context: Context,
    val noteClickDeleteInterface: NoteClickDeleteInterface,
    val noteClickInterface: NoteClickInterface
) : RecyclerView.Adapter<NoteRVAdaptor.ViewHolder>() {

    var allNotes = ArrayList<Note>()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val noteTV = itemView.findViewById<TextView>(R.id.idTVNote)
        val dateTV = itemView.findViewById<TextView>(R.id.idTVDate)
        val deleteIV = itemView.findViewById<ImageView>(R.id.idIVDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.note_rv_item,
            parent, false
        )
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // on below line we are setting data to item of recycler view.
        holder.noteTV.setText(allNotes.get(position).noteTitle)
        holder.dateTV.setText("Last Updated : " + allNotes.get(position).timeStamp)
        // on below line we are adding click listener to our delete image view icon.
        holder.deleteIV.setOnClickListener {
            // on below line we are calling a note click
            // interface and we are passing a position to it.
            noteClickDeleteInterface.onDeleteIconClick(allNotes.get(position))
        }

        holder.itemView.setOnClickListener {
            // on below line we are calling a note click interface
            // and we are passing a position to it.
            noteClickInterface.onNoteClick(allNotes.get(position))
        }
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    // below method is use to update our list of notes.
    fun updateList(newList: List<Note>) {
        // on below line we are clearing
        // our notes array list
        allNotes.clear()
        // on below line we are adding a
        // new list to our all notes list.
        allNotes.addAll(newList)
        // on below line we are calling notify data
        // change method to notify our adapter.
        notifyDataSetChanged()
    }
}

interface NoteClickDeleteInterface {
    // creating a method for click
    // action on delete image view.
    fun onDeleteIconClick(note: Note)
}

interface NoteClickInterface {
    // creating a method for click action
    // on recycler view item for updating it.
    fun onNoteClick(note: Note)
}