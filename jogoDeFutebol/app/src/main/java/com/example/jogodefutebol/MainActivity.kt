package com.example.jogodefutebol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jogodefutebol.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val lista : ArrayList<Time> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        configurarRecyclerView()

        binding.buttonCadastrar.setOnClickListener{
            cadastrar()
        }
    }

    fun cadastrar(){
        val time: Time = Time(binding.editNomeCampo.text.toString())
        lista.add(time)
        println(lista)
    }

    private fun configurarRecyclerView() {

        val recyclerContainer = binding.recyclerContainer
        recyclerContainer.layoutManager = LinearLayoutManager(baseContext)
        recyclerContainer.adapter = TimeAdapter(lista) {
                mensagem ->  Toast.makeText(baseContext, mensagem, Toast.LENGTH_LONG).show()
        }
    }

    class TimeAdapter(private val Time: List<Time>, private val onClick: (mensagem: String) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val layoutDoCard = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.res_card_item, parent, false)
            return TimeHolder(layoutDoCard, onClick)
        }

        inner class TimeHolder(private val layoutDoCard: View, private val onclick: (mensagem : String) -> Unit) : RecyclerView.ViewHolder(layoutDoCard) {
            fun vincular(time: Time) {
                val tvTitulo = layoutDoCard.findViewById<TextView>(R.id.id_nome_time)
                tvTitulo.text = time.nome
            }
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            (holder as TimeHolder).vincular(Time[position])
        }

        override fun getItemCount(): Int {
            return Time.size
        }
    }

    data class Time(
        val nome: String,
    )

}