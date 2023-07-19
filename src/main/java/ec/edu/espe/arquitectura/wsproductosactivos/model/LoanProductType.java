package ec.edu.espe.arquitectura.wsproductosactivos.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoanProductType {
    private String name;
    private String customerType;
    private String superType;
    private String temporaryInterest;
    private Boolean allowBranchTransactions;
    private Boolean allowBranchTranches;
    private Boolean allowRedraw;
}
