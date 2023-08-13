package ec.edu.espe.arquitectura.wsproductosactivos.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanProductTypeRS {
    private String name;
    private String customerType;
    private String superType;
    private String temporaryInterest;
    private Boolean allowBranchTransactions;
    private Boolean allowBranchTranches;
    private Boolean allowRedraw;
}
