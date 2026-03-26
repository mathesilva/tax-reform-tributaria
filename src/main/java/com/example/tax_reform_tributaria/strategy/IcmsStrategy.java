package com.example.tax_reform_tributaria.strategy;

import com.example.tax_reform_tributaria.dto.SimulacaoTaxRequestDTO;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class IcmsStrategy implements TaxStrategy{

    //18%
    private static final BigDecimal ALIQUOTA_ICMS = new BigDecimal("0.18");

    @Override
    public BigDecimal calculadora(SimulacaoTaxRequestDTO request){
        BigDecimal preco = BigDecimal.valueOf(request.preco());
        return preco.multiply(ALIQUOTA_ICMS).setScale(2, RoundingMode.HALF_UP);
    }
}
