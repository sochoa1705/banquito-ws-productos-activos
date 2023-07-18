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
        List<LoanProduct> loanProducts = this.loanProductRepository.findAll();
        List<LoanProductRS> loanProductList = new ArrayList<>();
        for(LoanProduct loanProduct : loanProducts){
            loanProductList.add(this.responseLoanProduct(loanProduct));
        }
        return loanProductList;
    }

    public LoanProduct transformLoanProductRQ(LoanProductRQ rq){
        LoanProduct loanProduct = LoanProduct
                .builder()
                .name(rq.getName())
                .currency(rq.getCurrency())
                .state(rq.getState())
                .description(rq.getDescription())
                .aplicability(rq.getApplicability())
                .gracePeriod(rq.getGracePeriod())
                .fee(rq.getFee())
                .creationDate(rq.getCreationDate())
                .build();
        return loanProduct;
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

    public LoanProductRS responseLoanProduct(LoanProduct loanProduct){
        LoanProductRS loanProductRs = LoanProductRS
                .builder()
                .name(loanProduct.getName())
                .currency(loanProduct.getCurrency())
                .state(loanProduct.getState())
                .description(loanProduct.getDescription())
                .aplicability(loanProduct.getAplicability())
                .tranches(loanProduct.getTranches())
                .gracePeriod(loanProduct.getGracePeriod())
                .gracePeriodType(loanProduct.getGracePeriodType())
                .fee(loanProduct.getFee())
                .redrawBalance(loanProduct.getRedrawBalance())
                .minInterest(loanProduct.getMinInterest())
                .maxInterest(loanProduct.getMaxInterest())
                .penaltyRate(loanProduct.getPenaltyRate())
                .minPenaltyValue(loanProduct.getMinPenaltyValue())
                .maxPenaltyValue(loanProduct.getMaxPenaltyValue())
                .creationDate(loanProduct.getCreationDate())
                .lastModifiedDate(loanProduct.getLastModifiedDate())
                .closedDate(loanProduct.getClosedDate())
                .amortization(loanProduct.getAmortization())
                .loanProductType(loanProduct.getLoanProductType())
                .build();
        return loanProductRs;
    }

    public LoanProductRS obtainLoanProductByUniqueKeyAndState(String uniqueKey,String state) {
        try {
            LoanProduct loanProduct = this.loanProductRepository.findByUniqueKeyAndState(uniqueKey,state);
            LoanProductRS response = responseLoanProduct(loanProduct);
            return response;
        } catch (RuntimeException rte) {
            throw new RuntimeException("Error al obtener loan product", rte);

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
            List<LoanProduct> loanProductTypes = this.loanProductRepository.findAllLoanProductTypes();
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
                .supertype(loanProductType.getSupertype())
                .temporaryInterest(loanProductType.getTemporaryInterest())
                .allowBranchTransaction(loanProductType.getAllowBranchTransaction())
                .allowTranches(loanProductType.getAllowTranches())
                .allowRedraw(loanProductType.getAllowRedraw())
                .build();
        return loanProductTypeRs;
    }
}
