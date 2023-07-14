package ec.edu.espe.arquitectura.wsproductosactivos.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoanProductType {
    private String name;
    private String customerType;
    private String supertype;
    private String temporaryInterest;
    private Boolean allowBranchTransaction;
    private Boolean allowTranches;
    private Boolean allowRedraw;
}
