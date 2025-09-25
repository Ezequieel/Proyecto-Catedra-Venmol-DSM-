package com.sc231259.venmol

import android.os.Bundle
import android.widget.TextView

class ClientesActivity : BaseActivity() {

    override fun getLayoutResourceId(): Int = R.layout.activity_clientes
    override fun getCurrentMenuItemId(): Int = R.id.nav_clientes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val textContent = findViewById<TextView>(R.id.textContent)
        textContent.text = "GESTIÓN DE CLIENTES\n\n" +
                "Funcionalidades disponibles:\n" +
                "• Registrar nuevos clientes\n" +
                "• Ver información de contacto\n" +
                "• y más xd"
    }
}