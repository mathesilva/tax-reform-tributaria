package com.example.tax_reform_tributaria.strategy;

import com.example.tax_reform_tributaria.dto.SimulacaoTaxRequestDTO;

import java.math.BigDecimal;

/**
 * Contrato principal para o cálculo de impostos utilizando o Design Pattern Strategy.
 * Cada imposto específico (ex: ICMS, IBS, CBS) deve implementar esta interface
 * e fornecer a sua própria regra matemática.
 */

public interface TaxStrategy {
    /**
     * Calcula o valor do imposto com base nos dados da requisição.
     *
     * @param request Dados da venda (produto, preço, estado, etc.)
     * @return O valor calculado do imposto
     */
    BigDecimal calculadora(SimulacaoTaxRequestDTO request);
}
