package ec.edu.espe.arquitectura.wsproductosactivos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.wsproductosactivos.controller.dto.LoanProductRS;
import ec.edu.espe.arquitectura.wsproductosactivos.controller.dto.LoanProductTypeRS;
import ec.edu.espe.arquitectura.wsproductosactivos.service.LoanProductService;

@RestController
@RequestMapping("/api/v1/loan-product")
public class LoanProductController {

    private final LoanProductService service;

    public LoanProductController(LoanProductService service) {
        this.service = service;
    }


    @GetMapping("/{uniqueKey}/{state}")
    public ResponseEntity<LoanProductRS> obtainByUnqueKeyAndState(@PathVariable("uniqueKey") String uniqueKey,
            @PathVariable("state") String state) {
        if (state.equals("ACT")) {
            LoanProductRS loanProductRS = this.service.obtainLoanProductByUniqueKeyAndState(uniqueKey, state);
            return ResponseEntity.ok(loanProductRS);
        }else return ResponseEntity.notFound().build();

    }

    @GetMapping("/{uniqueKey}")
    public ResponseEntity<LoanProductRS> obtainByUniqueKey(@PathVariable ("uniqueKey") String uniqueKey) {
        LoanProductRS loanProductRS = this.service.obtainLoanProductByUniqueKey(uniqueKey);
        return ResponseEntity.ok().body(loanProductRS);
    }

    @GetMapping("/all")
    public ResponseEntity<List<LoanProductRS>> getAll(){
        List<LoanProductRS> products = this.service.getAllLoanProduct();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/types")
    public ResponseEntity<List<LoanProductTypeRS>> obtainLoanProductTypes(){
        List<LoanProductTypeRS> productTypes = this.service.obtainAllLoanProductTypes();
        return ResponseEntity.ok(productTypes);
    }
}
