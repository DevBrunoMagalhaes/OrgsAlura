package com.devbrunomagalhaes.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.devbrunomagalhaes.orgs.R
import com.devbrunomagalhaes.orgs.dao.ProdutosDao
import com.devbrunomagalhaes.orgs.databinding.ActivityFormularioProdutoBinding
import com.devbrunomagalhaes.orgs.model.Produto
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFormularioProdutoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configuraBotaoSalvar()
    }

    private fun configuraBotaoSalvar() {
        val botaoSalvar = binding.btnSalvar
        val dao = ProdutosDao()
        botaoSalvar.setOnClickListener {
            val produtoNovo = criaProduto()
            dao.adiciona(produtoNovo)
            finish()
        }
    }

    private fun criaProduto(): Produto {
        val campoTitulo = binding.editTitulo
        val titulo = campoTitulo.text.toString()
        val campoDescricao = binding.editDescricao
        val descricao = campoDescricao.text.toString()
        val campoPreco = binding.editPreco
        val precoEmTexto = campoPreco.text.toString()
        val preco = if (precoEmTexto.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(precoEmTexto)
        }

        return Produto(
            titulo,
            descricao,
            preco
        )
    }
}