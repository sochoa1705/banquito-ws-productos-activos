package ec.edu.espe.arquitectura.wsproductosactivos.controller.dto;

import ec.edu.espe.arquitectura.wsproductosactivos.model.Amortization;
import ec.edu.espe.arquitectura.wsproductosactivos.model.LoanProductType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class LoanProductRS {
    private String name;
    private String currency;
    private String state;
    private String description;
    private String aplicability;
    private Integer tranches;
    private Integer gracePeriod;
    private String gracePeriodType;
    private BigDecimal fee;
    private BigDecimal redrawBalance;
    private BigDecimal minInterest;
    private BigDecimal maxInterest;
    private BigDecimal penaltyRate;
    private BigDecimal minPenaltyValue;
    private BigDecimal maxPenaltyValue;
    private Date creationDate;
    private Date lastModifiedDate;
    private Date closedDate;
    private LoanProductType loanProductType;
    private Amortization amortization;

}
