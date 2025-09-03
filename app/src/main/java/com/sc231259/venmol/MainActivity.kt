package com.sc231259.venmol

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textProductos: TextView = findViewById(R.id.textProductos)

        // Leer productos desde Firestore
        db.collection("productos")
            .get()
            .addOnSuccessListener { result ->
                val builder = StringBuilder()
                for (document in result) {
                    val nombre = document.getString("nombre") ?: "Sin nombre"
                    val marca = document.getString("marca") ?: "Sin marca"
                    builder.append("• $nombre - $marca\n")
                }
                textProductos.text = builder.toString()
            }
            .addOnFailureListener { e ->
                textProductos.text = "Error al obtener productos: ${e.message}"
            }
    }

    override fun onStart() {
        super.onStart()
        val user = FirebaseAuth.getInstance().currentUser
        if (user == null) {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }


}