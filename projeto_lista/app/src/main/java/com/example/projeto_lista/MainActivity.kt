package com.example.projeto_lista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projeto_lista.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configurarRecyclerView()
    }

    private fun configurarRecyclerView() {
        val turismo = listOf(
            Turismo("As piramidês de Gizé", R.drawable.egito1),
            Turismo("A tumba do Faraó", R.drawable.egito2),
            Turismo("O Faraó Tutancâmon", R.drawable.egito4),
            Turismo("As piramidês de Gizé", R.drawable.egito1),
            Turismo("A tumba do Faraó", R.drawable.egito2),
            Turismo("O Faraó Tutancâmon", R.drawable.egito4)
        )
        val recyclerContainer = binding.recyclerContainer
        recyclerContainer.layoutManager = LinearLayoutManager(baseContext)
        recyclerContainer.adapter = TurismoAdapter(turismo) {
            mensagem ->  Toast.makeText(baseContext, mensagem, Toast.LENGTH_LONG).show()
        }


    }

    class TurismoAdapter(
        private val Turismo: List<Turismo>,
        private val onClick: (mensagem: String) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val layoutDoCard = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.res_card_item, parent, false)
            return TurismoHolder(layoutDoCard, onClick)
        }

        inner class TurismoHolder(
            private val layoutDoCard: View,
            private val onclick: (mensagem : String) -> Unit) : RecyclerView.ViewHolder(layoutDoCard) {
            fun vincular(turismo: Turismo) {
                val tvTitulo = layoutDoCard.findViewById<TextView>(R.id.id_titulo)
                val ivImagem = layoutDoCard.findViewById<ImageView>(R.id.id_img)

                tvTitulo.text = turismo.destino
                ivImagem.setImageResource(turismo.imagem)

                ivImagem.setOnClickListener{
                    onclick("Clicou em um card")
                }

            }
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            (holder as TurismoHolder).vincular(Turismo[position])
        }

        override fun getItemCount(): Int {
            return Turismo.size
        }

    }

    data class Turismo(
        val destino: String,
        val imagem: Int
    )
}