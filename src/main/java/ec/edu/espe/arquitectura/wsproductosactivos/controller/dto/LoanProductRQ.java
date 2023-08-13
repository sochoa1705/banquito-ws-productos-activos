package ec.edu.espe.arquitectura.wsproductosactivos.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanProductRQ {
    private String name;
    private String currency;
    private String state;
    private String description;
    private String applicability;
    private Integer gracePeriod;
    private String gracePeriodType;
    private BigDecimal fee;
    private Date creationDate;
}
