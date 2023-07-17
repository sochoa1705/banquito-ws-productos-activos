package ec.edu.espe.arquitectura.wsproductosactivos.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.wsproductosactivos.controller.dto.LoanProductRQ;
import ec.edu.espe.arquitectura.wsproductosactivos.controller.dto.LoanProductRS;
import ec.edu.espe.arquitectura.wsproductosactivos.model.LoanProduct;
import ec.edu.espe.arquitectura.wsproductosactivos.repository.LoanProductRepository;

@Service
public class LoanProductService {
    
    private final LoanProductRepository loanProductRepository;


    public LoanProductService(LoanProductRepository loanProductRepository) {
        this.loanProductRepository = loanProductRepository;
    }


    public LoanProduct transformLoanProductRQ(LoanProductRQ rq){
        LoanProduct loanProduct = LoanProduct
                .builder()
                .name(rq.getName())
                .currency(rq.getCurrency())
                .state(rq.getState())
                .description(rq.getDescription())
                .applicability(rq.getApplicability())
                .gracePeriod(rq.getGracePeriod())
                .fee(rq.getFee())
                .creationDate(rq.getCreationDate())
                .build();
        return loanProduct;
    }

    public LoanProductRS responseLoanProduct(LoanProduct rq){
        LoanProductRS loanProductRs = LoanProductRS
                .builder()
                .name(rq.getName())
                .currency(rq.getCurrency())
                .state(rq.getState())
                .description(rq.getDescription())
                .applicability(rq.getApplicability())
                .gracePeriod(rq.getGracePeriod())
                .fee(rq.getFee())
                .creationDate(rq.getCreationDate())
                .build();
        return loanProductRs;
    }

    public LoanProduct obtainByUniqueKey(String uniqueKey){
        try{
            return this.loanProductRepository.findByUniqueKey(uniqueKey);
        }catch(RuntimeException rte) {
            throw new RuntimeException("Error al obtener el producto con uniqueKey: " + uniqueKey, rte);
        }
    }

    public LoanProduct obtainByUniqueKeyAndState(String uniqueKey, String state){
        return this.loanProductRepository.findByUniqueKeyAndState(uniqueKey,state);
    }

    public LoanProduct obtainByUniqueKeyAndStateBetween(String uniqueKey, String state, BigDecimal minInterest, BigDecimal maxInterest){
        return this.loanProductRepository.findByUniqueKeyAndStateBetween(uniqueKey, state, minInterest, maxInterest);
    }

    public LoanProduct obtainAmortizationById(String id){
        return this.loanProductRepository.findAmortizationById(id);
    }
}
