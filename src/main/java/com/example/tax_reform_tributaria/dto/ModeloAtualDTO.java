package com.example.tax_reform_tributaria.dto;


import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "Detalhamento dos impostos no modelo atual")
public record ModeloAtualDTO(

        @Schema(description = "Valor calculado do ICMS", example = "900.00")
        BigDecimal icms,
        @Schema(description = "Valor calculado do PIS", example = "82.50")
        BigDecimal pis,
        @Schema(description = "Valor calculado do COFINS", example = "380.00")
        BigDecimal cofins,
        @Schema(description = "Soma total dos impostos atuais", example = "1362.50")
        BigDecimal totalImpostos
) {
}
