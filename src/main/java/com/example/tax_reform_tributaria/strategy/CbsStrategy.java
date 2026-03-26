package com.example.tax_reform_tributaria.strategy;

import com.example.tax_reform_tributaria.dto.SimulacaoTaxRequestDTO;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class CbsStrategy implements TaxStrategy{
    //9%
    private static final BigDecimal ALIQUOTA_CBS = new BigDecimal("0.09");

    public BigDecimal calculadora(SimulacaoTaxRequestDTO request){
        BigDecimal preco = BigDecimal.valueOf(request.preco());
        return preco.multiply(ALIQUOTA_CBS).setScale(2, RoundingMode.HALF_UP);
    }
}
