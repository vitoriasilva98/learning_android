package br.com.sptech.c2vitoriasilva

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.sptech.c2vitoriasilva.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var total: Double = 0.0
    private var descricaoProdutoComprado: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.totalCarrinho.text = "Total: R$ %.2f".format(total)

        binding.fig01.setOnClickListener {
            detalheFigurinha(1)
        }

        binding.fig02.setOnClickListener {
            detalheFigurinha(2)
        }

        binding.fig03.setOnClickListener {
            detalheFigurinha(3)
        }

        binding.fig01Comprar.setOnClickListener {
            comprarFigurinha("fig01")
        }

        binding.fig02Comprar.setOnClickListener {
            comprarFigurinha("fig02")
        }

        binding.fig03Comprar.setOnClickListener {
            comprarFigurinha("fig03")
        }

        binding.notaFiscal.setOnClickListener{
            notaFiscal()
        }
    }

    fun detalheFigurinha(figurinha: Int) {

        val telaDetalheFigurinha = Intent(this, DescricaoFigurinha::class.java)
        when (figurinha) {
            1 -> {
                telaDetalheFigurinha.putExtra("nome","Vinícius Jr")
                telaDetalheFigurinha.putExtra("data_nascimento", "12/07/2000")
                telaDetalheFigurinha.putExtra("pais", "Brasil")
                telaDetalheFigurinha.putExtra("img", "1")
            }
            2 -> {
                telaDetalheFigurinha.putExtra("nome","Cristiano Ronaldo")
                telaDetalheFigurinha.putExtra("data_nascimento", "05/02/1985")
                telaDetalheFigurinha.putExtra("pais", "Portugal")
                telaDetalheFigurinha.putExtra("img", "2")
            }
            3 -> {
                telaDetalheFigurinha.putExtra("nome","Kylian Mbappé")
                telaDetalheFigurinha.putExtra("data_nascimento", "20/12/1998")
                telaDetalheFigurinha.putExtra("pais", "França")
                telaDetalheFigurinha.putExtra("img", "3")
            }
        }
        startActivity(telaDetalheFigurinha)
    }

    fun comprarFigurinha(figurinha: String) {

        when {
            figurinha.equals("fig01") -> {
                val valorFigurinha: Double = 7.50
                total += valorFigurinha
                this.descricaoProdutoComprado += "1x Vinícius Jr - R$ 7,50\n"
            }
            figurinha.equals("fig02") -> {
                val valorFigurinha: Double = 10.50
                total += valorFigurinha
                this.descricaoProdutoComprado += "1x Cristiano Ronaldo - R$ 10,50\n"
            }
            figurinha.equals("fig03") -> {
                val valorFigurinha: Double = 11.50
                total += valorFigurinha
                this.descricaoProdutoComprado += "1x Kilian Mbappé - R$ 11,50\n"
            }
        }

        binding.totalCarrinho.text = "Total: R$ %.2f".format(total)
    }

    fun notaFiscal() {
        val telaNotaFiscal = Intent(this, NotaFiscal::class.java)
        telaNotaFiscal.putExtra("descricao_produtos", descricaoProdutoComprado)
        telaNotaFiscal.putExtra("total_calculado", "Total: R$ %.2f".format(total))

        startActivity(telaNotaFiscal)
    }
}