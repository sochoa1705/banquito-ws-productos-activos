package ec.edu.espe.arquitectura.wsproductosactivos.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@Document(collection = "loanProduct")
public class LoanProduct {
    @Id
    private String id;
    @Indexed(unique = true)
    private String uniqueKey;
    private String name;
    private String currency;
    private String state;
    private String description;
    private String applicability;
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
    private Amortization amortization;
    private LoanProductType loanProductType;


}
