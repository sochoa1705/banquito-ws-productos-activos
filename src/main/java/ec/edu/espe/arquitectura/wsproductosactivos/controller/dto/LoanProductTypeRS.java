package ec.edu.espe.arquitectura.wsproductosactivos.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoanProductTypeRS {
    private String name;
    private String customerType;
    private String supertype;
    private String temporaryInterest;
    private Boolean allowBranchTransaction;
    private Boolean allowTranches;
    private Boolean allowRedraw;
}
