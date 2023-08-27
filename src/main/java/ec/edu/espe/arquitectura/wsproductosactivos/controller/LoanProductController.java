package ec.edu.espe.arquitectura.wsproductosactivos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ec.edu.espe.arquitectura.wsproductosactivos.controller.dto.LoanProductRS;
import ec.edu.espe.arquitectura.wsproductosactivos.controller.dto.LoanProductTypeRS;
import ec.edu.espe.arquitectura.wsproductosactivos.service.LoanProductService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/loan-product")
public class LoanProductController {

    private final LoanProductService service;

    public LoanProductController(LoanProductService service) {
        this.service = service;
    }

    @GetMapping("/name/{uniqueKey}")
    public ResponseEntity<String> obtainProductNameByUniqueKey(@PathVariable("uniqueKey") String uniqueKey) {
        String name = this.service.obtainProductNameByUniqueKey(uniqueKey);
        return ResponseEntity.ok(name);
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
