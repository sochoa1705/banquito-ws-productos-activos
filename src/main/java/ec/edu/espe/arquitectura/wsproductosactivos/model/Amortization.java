package ec.edu.espe.arquitectura.wsproductosactivos.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
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


