package com.devbrunomagalhaes.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.devbrunomagalhaes.orgs.dao.ProdutosDao
import com.devbrunomagalhaes.orgs.databinding.ActivityListaProdutosBinding
import com.devbrunomagalhaes.orgs.ui.recylerview.adapter.ListaProdutosAdapter

class ListaProdutosActivity: AppCompatActivity() {

    private val dao = ProdutosDao()
    private val adapter = ListaProdutosAdapter(this, dao.buscaTodos())

    private val binding by lazy {
        ActivityListaProdutosBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        ConfiguraRecyclerView()
        ConfiguraFab()
    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.buscaTodos())
    }

    private fun ConfiguraFab() {
        val fab = binding.floatingActionButton
        fab.setOnClickListener {
            VaiParaFormularioProduto()
        }
    }

    private fun VaiParaFormularioProduto() {
        val intent = Intent(this, FormularioProdutoActivity::class.java)
        startActivity(intent)
    }

    private fun ConfiguraRecyclerView() {
        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}