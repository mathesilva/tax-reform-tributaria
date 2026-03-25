package com.example.tax_reform_tributaria.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "Detalhamento dos impostos no novo modelo (Reforma)")
public record NovoModeloDTO(
        @Schema(description = "Valor calculado da CBS", example = "450.00")
        BigDecimal cbs,
        @Schema(description = "Valor calculado do IBS", example = "900.00")
        BigDecimal ibs,
        @Schema(description = "Soma total dos novos impostos", example = "1350.00")
        BigDecimal totalImpostos

) {
}
