package com.example.tax_reform_tributaria.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "Resposta final contendo a comparação completa dos impostos")
public record SimulacaoTaxResponseDTO(

         ModeloAtualDTO modeloAtual,
         NovoModeloDTO novoModelo,

         @Schema(description = "Diferença financeira (Novo Modelo - Modelo Atual). Valores negativos indicam economia.", example = "-12.50")
         BigDecimal diferenca)
{
}
