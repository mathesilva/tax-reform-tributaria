package com.example.tax_reform_tributaria.service;

import com.example.tax_reform_tributaria.dto.ModeloAtualDTO;
import com.example.tax_reform_tributaria.dto.NovoModeloDTO;
import com.example.tax_reform_tributaria.dto.SimulacaoTaxRequestDTO;
import com.example.tax_reform_tributaria.dto.SimulacaoTaxResponseDTO;
import com.example.tax_reform_tributaria.strategy.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class SimulacaoTaxService {

    //estrategias do Modelo Atual
    private final IcmsStrategy icmsStrategy;
    private final PisStrategy pisStrategy;
    private final CofinsStrategy cofinsStrategy;


    //estrategias Novo Modelo
    private final IbsStrategy ibsStrategy;
    private final CbsStrategy cbsStrategy;


    public SimulacaoTaxResponseDTO simulacao(SimulacaoTaxRequestDTO request){
        //calcular modelo atual
        BigDecimal valorIcms = icmsStrategy.calculadora(request);
        BigDecimal valorPis = pisStrategy.calculadora(request);
        BigDecimal valorCofins = cofinsStrategy.calculadora(request);

        BigDecimal totalAtual = valorIcms.add(valorPis).add(valorCofins);

        ModeloAtualDTO modeloAtual = new ModeloAtualDTO(valorIcms, valorPis, valorCofins, totalAtual);

        // calcular modelo da reforma(novo)

        BigDecimal valorIbs = ibsStrategy.calculadora(request);
        BigDecimal valorCbs = cbsStrategy.calculadora(request);

        BigDecimal totalNovo = valorIbs.add(valorCbs);

        NovoModeloDTO novoModelo = new NovoModeloDTO(valorCbs, valorIbs, totalNovo);

        BigDecimal diferenca = totalNovo.subtract(totalAtual);

        return new SimulacaoTaxResponseDTO(modeloAtual, novoModelo, diferenca);
    }


}
