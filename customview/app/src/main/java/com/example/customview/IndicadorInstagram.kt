package com.example.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.customview.databinding.IndicadorInstagramBinding

class IndicadorInstagram(
    context: Context,
    attrs: AttributeSet
) :
    LinearLayout(context, attrs) {

    private val binding =
        IndicadorInstagramBinding.inflate(
            LayoutInflater.from(context), this, true
        )

    init {
        val atributos = context.obtainStyledAttributes(
            attrs,
            R.styleable.IndicadorInstagram
        )
        setTitulo(
            atributos.getString(
                R.styleable.IndicadorInstagram_titulo
            ) ?: "Falta Título"
        )

        setSubtitulo(
            atributos.getString(
                R.styleable.IndicadorInstagram_subtitulo
            ) ?: "Falta subtitulo"
        )
    }

    fun setTitulo(titulo: String) {
        binding.titlo.text = titulo
    }

    fun setSubtitulo(subtitulo: String) {
        binding.subtitulo.text = subtitulo
    }
}