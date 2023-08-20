package com.devskiller.notepadplus.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devskiller.notepadplus.databinding.ViewNoteListItemBinding
import com.devskiller.notepadplus.domain.Note

class NoteAdapter(private val mNotes: List<Note>) : RecyclerView.Adapter<NoteAdapter.NoteHolder>() {

    inner class NoteHolder(
        val mViewBinding: ViewNoteListItemBinding
    ) : RecyclerView.ViewHolder(mViewBinding.root), View.OnClickListener {

        private var mNote: Note? = null

        fun setNote(note: Note) {
            mNote = note
            mViewBinding.tvNoteTitle.text = note.title
        }

        override fun onClick(view: View) {
            // START YOUR CHANGE
            mNote?.let {
                view.context.startActivity(ChangeNoteActivity.newIntent(view.context, it.id))
            }

            // END YOUR CHANGE
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NoteHolder = NoteHolder(ViewNoteListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(
        holder: NoteHolder,
        position: Int
    ) {
        // START YOUR CHANGE
        val note = mNotes[position]
        holder.setNote(note)
        holder.itemView.setOnClickListener(holder)
        return
        // END YOUR CHANGE
    }

    override fun getItemCount(): Int {
        // START REFACTOR OF THIS METHOD
        // END REFACTOR OF THIS METHOD
        return mNotes.size
    }
}
