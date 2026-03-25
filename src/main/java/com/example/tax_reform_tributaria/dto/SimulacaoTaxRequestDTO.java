package com.example.tax_reform_tributaria.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record SimulacaoTaxRequestDTO(
        @NotBlank(message = "O produto nao pode ser vazio")
        @Schema(description = "Nome do produto ou servico", example = "Licenca de Software")
         String produto,

        @Positive(message = "O preço deve ser maior que zero")
        @Schema(description = "Valor total da venda em reais", example = "5000.00")
         Double preco,

        @NotBlank(message = "O estado de origem é obrigatório")
        @Schema(description = "Sigla do Estado (UF)", example = "SP")
         String estado,
        @NotNull(message = "O tipo de empresa é obrigatório")
        @Schema(description = "Regime de tributação da empresa", example = "LUCRO_PRESUMIDO")
         TipoEmpresa tipoEmpresa,
        @NotBlank(message = "A categoria é obrigatória")
        @Schema(description = "Categoria do produto (ex: Tecnologia, Alimentação, Saúde)", example = "Tecnologia")
         String categoria,
        @Min(value = 2024, message = "O ano de simulação deve ser igual ou superior a 2024")
        @Schema(description = "Ano base para a simulação da regra tributária", example = "2027")
         Integer anoSimulacao)
{
}
