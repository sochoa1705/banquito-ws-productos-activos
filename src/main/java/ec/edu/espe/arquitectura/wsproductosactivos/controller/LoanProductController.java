package ec.edu.espe.arquitectura.wsproductosactivos.controller;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.wsproductosactivos.model.LoanProduct;
import ec.edu.espe.arquitectura.wsproductosactivos.service.LoanProductService;

@RestController
@RequestMapping("/api/v1/loan-product")

public class LoanProductController {

    private final LoanProductService service;

    public LoanProductController(LoanProductService service) {
        this.service = service;
    }

    @GetMapping("/{uniqueKey}")
    public ResponseEntity<LoanProduct> findByUniqueKey(@PathVariable("uniqueKey") String uniqueKey) {
        LoanProduct rs = this.service.obtainByUniqueKey(uniqueKey);
        return ResponseEntity.ok(rs);
    }

    @GetMapping("/{uniqueKey}/{state}")
    public ResponseEntity<LoanProduct> findByUniqueKeyAndState(@PathVariable("uniqueKey") String uniqueKey,
            @PathVariable("state") String state) {
        if (state.equals("ACT")) {
            LoanProduct rs = this.service.obtainByUniqueKeyAndState(uniqueKey, state);
            return ResponseEntity.ok(rs);
        }else return ResponseEntity.notFound().build();

    }

    @GetMapping("/{uniqueKey}/{state}/{minInterest}/{maxInterest}")
    public ResponseEntity<LoanProduct> findByUniqueKeyAndStateBetween(@PathVariable("uniqueKey") String uniqueKey,
            @PathVariable("state") String state, @PathVariable("minInterest") BigDecimal minInterest,
            @PathVariable("maxInterest") BigDecimal maxInterest) {
                if (state.equals("ACT")) {
        LoanProduct rs = this.service.obtainByUniqueKeyAndStateBetween(uniqueKey, state, minInterest, maxInterest);
        return ResponseEntity.ok(rs);
        }else return ResponseEntity.notFound().build();
    }

    @GetMapping("/amortization/{id}")
    public ResponseEntity<LoanProduct> findAmortizationById(@PathVariable("id") String id) {
        LoanProduct rs = this.service.obtainAmortizationById(id);
        return ResponseEntity.ok(rs);
    }
}
