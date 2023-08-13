package ec.edu.espe.arquitectura.wsproductosactivos.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
