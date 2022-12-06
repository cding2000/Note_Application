package com.example.note_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var noteAdapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        noteAdapter = NoteAdapter(mutableListOf())

        rvNoteItems.adapter = noteAdapter
        rvNoteItems.layoutManager = LinearLayoutManager(this)

        btnAddNote.setOnClickListener {
            val noteTitle = etNoteTitle.text.toString()
            if(noteTitle.isNotEmpty()) {
                val note = Note(noteTitle)
                noteAdapter.addNote(note)
                etNoteTitle.text.clear()
            }
        }
        btnDeleteDoneNotes.setOnClickListener {
            noteAdapter.deleteDoneNotes()
        }
    }
}