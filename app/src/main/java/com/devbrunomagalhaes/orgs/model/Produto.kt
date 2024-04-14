package com.devbrunomagalhaes.orgs.model

import java.math.BigDecimal

data class Produto(
    val titulo: String,
    val descricao: String,
    val preco: BigDecimal
)
