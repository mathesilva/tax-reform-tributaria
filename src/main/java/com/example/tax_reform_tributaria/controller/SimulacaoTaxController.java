package com.example.tax_reform_tributaria.controller;

import com.example.tax_reform_tributaria.dto.SimulacaoTaxRequestDTO;
import com.example.tax_reform_tributaria.dto.SimulacaoTaxResponseDTO;
import com.example.tax_reform_tributaria.service.SimulacaoTaxService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/taxas")
@RequiredArgsConstructor
@Tag(name = "Simulação de Impostos", description = "Endpoints para calcular o impacto da Reforma Tributária")
public class SimulacaoTaxController {


    private final SimulacaoTaxService taxService;


    @PostMapping("/api/v1/taxas/simulacao")
    @Operation(summary = "Calcula e compara os impostos", description = "Recebe os dados de uma venda, calcula no modelo atual e no novo modelo (IBS/CBS) e retorna a diferença.")
    public ResponseEntity<SimulacaoTaxResponseDTO>simulacao(@RequestBody @Valid SimulacaoTaxRequestDTO request){
        SimulacaoTaxResponseDTO response = taxService.simulacao(request);

        return ResponseEntity.ok(response);
    }
}
