package ec.edu.espe.arquitectura.wsproductosactivos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.wsproductosactivos.controller.dto.LoanProductRQ;
import ec.edu.espe.arquitectura.wsproductosactivos.controller.dto.LoanProductRS;
import ec.edu.espe.arquitectura.wsproductosactivos.controller.dto.LoanProductTypeRS;
import ec.edu.espe.arquitectura.wsproductosactivos.model.LoanProduct;
import ec.edu.espe.arquitectura.wsproductosactivos.model.LoanProductType;
import ec.edu.espe.arquitectura.wsproductosactivos.repository.LoanProductRepository;

@Service
public class LoanProductService {
    
    private final LoanProductRepository loanProductRepository;


    public LoanProductService(LoanProductRepository loanProductRepository) {
        this.loanProductRepository = loanProductRepository;
    }

    public List<LoanProductRS> getAllLoanProduct(){
        List<LoanProduct> products = this.loanProductRepository.findAll();
        List<LoanProductRS> productList = new ArrayList<>();
        for(LoanProduct product : products){
            productList.add(this.responseLoanProduct(product));
        }
        return productList;
    }


    public LoanProductRS obtainLoanProductByUniqueKey(String uniqueKey) {
        try {
            LoanProduct loanProduct = this.loanProductRepository.findByUniqueKey(uniqueKey);
            LoanProductRS response = responseLoanProduct(loanProduct);
            return response;
        } catch (RuntimeException rte) {
            throw new RuntimeException("Error al obtener loan product", rte);
        }
    }

    public LoanProductRS responseLoanProduct(LoanProduct rq){
        LoanProductRS response = LoanProductRS
                .builder()
                .name(rq.getName())
                .currency(rq.getCurrency())
                .state(rq.getState())
                .description(rq.getDescription())
                .aplicability(rq.getAplicability())
                .tranches(rq.getTranches())
                .gracePeriod(rq.getGracePeriod())
                .gracePeriodType(rq.getGracePeriodType())
                .fee(rq.getFee())
                .redrawBalance(rq.getRedrawBalance())
                .minInterest(rq.getMinInterest())
                .maxInterest(rq.getMaxInterest())
                .penaltyRate(rq.getPenaltyRate())
                .minPenaltyValue(rq.getMinPenaltyValue())
                .maxPenaltyValue(rq.getMaxPenaltyValue())
                .creationDate(rq.getCreationDate())
                .lastModifiedDate(rq.getLastModifiedDate())
                .closedDate(rq.getClosedDate())
                .loanProductType(rq.getLoanProductType())
                .amortization(rq.getAmortization())
                .build();
        return response;
    }

    public LoanProductRS obtainLoanProductByUniqueKeyAndState(String uniqueKey,String state) {
        try {
            LoanProduct loanProduct = this.loanProductRepository.findByUniqueKeyAndState(uniqueKey,state);
            LoanProductRS response = responseLoanProduct(loanProduct);
            return response;
        } catch (RuntimeException rte) {
            throw new RuntimeException("Error al obtener loan product", rte);
        }
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

    public List<LoanProductTypeRS> obtainAllLoanProductTypes(){
        try{
            List<LoanProduct> loanProductTypes = this.loanProductRepository.findLoanProductsByLoanProductType();
            List<LoanProductTypeRS> loanProductTypeRSList = new ArrayList<>();
            for(LoanProduct productType : loanProductTypes){
                loanProductTypeRSList.add(this.responseLoanProductType(productType.getLoanProductType()));
            }
            return loanProductTypeRSList;
        }catch (RuntimeException rte){
            throw new RuntimeException("Error al obtener los tipos de productos",rte);
        }

    }

    public LoanProductTypeRS responseLoanProductType(LoanProductType loanProductType){
        LoanProductTypeRS loanProductTypeRs = LoanProductTypeRS
                .builder()
                .name(loanProductType.getName())
                .customerType(loanProductType.getCustomerType())
                .superType(loanProductType.getSuperType())
                .temporaryInterest(loanProductType.getTemporaryInterest())
                .allowBranchTransactions(loanProductType.getAllowBranchTransactions())
                .allowBranchTranches(loanProductType.getAllowBranchTranches())
                .allowRedraw(loanProductType.getAllowRedraw())
                .build();
        return loanProductTypeRs;
    }
}
