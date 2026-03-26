package com.example.tax_reform_tributaria.strategy;

import com.example.tax_reform_tributaria.dto.SimulacaoTaxRequestDTO;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class CofinsStrategy implements TaxStrategy{

    //7.6%
    private static final BigDecimal ALIQUOTA_COFINS = new BigDecimal("0.076");

    @Override
    public BigDecimal calculadora(SimulacaoTaxRequestDTO request){
        BigDecimal preco = BigDecimal.valueOf(request.preco());

        return preco.multiply(ALIQUOTA_COFINS).setScale(2, RoundingMode.HALF_UP);

    }
}
