package br.com.sptech.c2vitoriasilva

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.sptech.c2vitoriasilva.databinding.ActivityDescricaoFigurinhaBinding
import br.com.sptech.c2vitoriasilva.databinding.ActivityNotaFiscalBinding

class DescricaoFigurinha : AppCompatActivity() {
    private lateinit var binding: ActivityDescricaoFigurinhaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDescricaoFigurinhaBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.descricaoNome.text = intent.getStringExtra("nome")
        binding.descricaoAnoNasci.text = intent.getStringExtra("data_nascimento")
        binding.descricaoPais.text = intent.getStringExtra("pais")
        val img = when (intent.getStringExtra("img")) {
            "1" -> R.drawable.fig_01
            "2" -> R.drawable.fig_03
            else -> R.drawable.fig_04
        }
        binding.descricaoFigurinha.setImageResource(img)

        binding.botaoVoltar.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}