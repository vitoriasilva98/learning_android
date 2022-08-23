package br.com.vsep.floriculturanovavida

import android.app.Activity
import android.os.Bundle
import android.widget.Toast

class CatalogoActivity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(this, "Bem vindo a Floricultura Nova Vida", Toast.LENGTH_LONG).show()
        setContentView(R.layout.activity_catalogo)
    }
}