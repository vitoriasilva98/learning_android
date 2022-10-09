package br.com.sptech.c2vitoriasilva

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.sptech.c2vitoriasilva.databinding.ActivityMainBinding
import br.com.sptech.c2vitoriasilva.databinding.ActivityNotaFiscalBinding

class NotaFiscal : AppCompatActivity() {
    private lateinit var binding: ActivityNotaFiscalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotaFiscalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.descricaoFiscal.text = intent.getStringExtra("descricao_produtos")
        binding.totalNotaFiscal.text = "R$ " + intent.getStringExtra("total_calculado")
    }
}