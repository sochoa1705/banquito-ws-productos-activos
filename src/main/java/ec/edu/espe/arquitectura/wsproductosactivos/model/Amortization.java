package ec.edu.espe.arquitectura.wsproductosactivos.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Amortization {
    private String type;
    private Integer term;
    private BigDecimal quote;
    private BigDecimal capital;
    private BigDecimal tax;
    private BigDecimal pendingBalance;
    private String periodUnit;
}


