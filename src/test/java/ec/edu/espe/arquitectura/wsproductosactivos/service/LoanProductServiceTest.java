package ec.edu.espe.arquitectura.wsproductosactivos.service;

import ec.edu.espe.arquitectura.wsproductosactivos.controller.dto.LoanProductRS;
import ec.edu.espe.arquitectura.wsproductosactivos.controller.dto.LoanProductTypeRS;
import ec.edu.espe.arquitectura.wsproductosactivos.model.Amortization;
import ec.edu.espe.arquitectura.wsproductosactivos.model.LoanProduct;
import ec.edu.espe.arquitectura.wsproductosactivos.model.LoanProductType;
import ec.edu.espe.arquitectura.wsproductosactivos.repository.LoanProductRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoanProductServiceTest {
    @Mock
    private LoanProductRepository loanProductRepository;

    @InjectMocks
    private LoanProductService loanProductService;

    private LoanProduct mockLoanProduct;
    private LoanProductType mockLoanProductType;
    private Amortization mockAmortization;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void LoanProductServicesObtainLoanProductByUniqueKey_Success() {
        LoanProductType mockLoanProductType = LoanProductType.builder()
                .name("Préstamo estudiantil")
                .customerType("NAT")
                .superType("IFR")
                .temporaryInterest("MON")
                .allowBranchTransactions(true)
                .allowBranchTranches(true)
                .allowRedraw(true)
                .build();
        Amortization mockAmortization = Amortization
                .builder()
                .type("FR")
                .term(12)
                .quote(new BigDecimal("250.50"))
                .capital(new BigDecimal("1500.00"))
                .tax(new BigDecimal("0.05"))
                .pendingBalance(new BigDecimal("45.00"))
                .periodUnit("weekly")
                .build();

        LoanProduct mockLoanProduct = LoanProduct.builder()
                .id(null)
                .uniqueKey("bd8a3a089f2")
                .name("Préstamo Estudiantil EduFin")
                .currency("USD")
                .state("INA")
                .description("Vivamus vestibulum sagittis sapien")
                .aplicability("CUS")
                .tranches(40)
                .gracePeriod(273)
                .gracePeriodType("pay_interest_only")
                .fee(new BigDecimal("0.0"))
                .redrawBalance(new BigDecimal("100.0"))
                .minInterest(new BigDecimal("0.0"))
                .maxInterest(new BigDecimal("0.0"))
                .penaltyRate(new BigDecimal("0.0"))
                .minPenaltyValue(new BigDecimal("0.0"))
                .maxPenaltyValue(new BigDecimal("0.0"))
                .creationDate(new Date())
                .lastModifiedDate(new Date())
                .closedDate(new Date())
                .loanProductType(mockLoanProductType)
                .amortization(mockAmortization)
                .build();

        when(loanProductRepository.findByUniqueKey(anyString())).thenReturn(mockLoanProduct);
        LoanProductRS result = loanProductService.obtainLoanProductByUniqueKey("someUniqueKey");
        assertNotNull(result);
    }

    @Test
    public void LoanProductServices_ObtainLoanProductByUniqueKey_Failure() {
        LoanProductType mockLoanProductType = LoanProductType.builder()
                .name("Préstamo estudiantil")
                .customerType("NAT")
                .superType("IFR")
                .temporaryInterest("MON")
                .allowBranchTransactions(true)
                .allowBranchTranches(true)
                .allowRedraw(true)
                .build();
        Amortization mockAmortization = Amortization
                .builder()
                .type("FR")
                .term(12)
                .quote(new BigDecimal("250.50"))
                .capital(new BigDecimal("1500.00"))
                .tax(new BigDecimal("0.05"))
                .pendingBalance(new BigDecimal("45.00"))
                .periodUnit("weekly")
                .build();

        LoanProduct mockLoanProduct = LoanProduct.builder()
                .id(null)
                .uniqueKey("bd8a3a089f2")
                .name("Préstamo Estudiantil EduFin")
                .currency("USD")
                .state("INA")
                .description("Vivamus vestibulum sagittis sapien")
                .aplicability("CUS")
                .tranches(40)
                .gracePeriod(273)
                .gracePeriodType("pay_interest_only")
                .fee(new BigDecimal("0.0"))
                .redrawBalance(new BigDecimal("100.0"))
                .minInterest(new BigDecimal("0.0"))
                .maxInterest(new BigDecimal("0.0"))
                .penaltyRate(new BigDecimal("0.0"))
                .minPenaltyValue(new BigDecimal("0.0"))
                .maxPenaltyValue(new BigDecimal("0.0"))
                .creationDate(new Date())
                .lastModifiedDate(new Date())
                .closedDate(new Date())
                .loanProductType(mockLoanProductType)
                .amortization(mockAmortization)
                .build();
        when(loanProductRepository.findByUniqueKey(anyString())).thenThrow(new RuntimeException("Simulated error"));
        assertThrows(RuntimeException.class, () -> loanProductService.obtainLoanProductByUniqueKey("someUniqueKey"));
    }

    @Test
    public void LoanProductService_ObtainProductTypes_Success() {
        LoanProductType mockLoanProductType = LoanProductType.builder()
                .name("Préstamo estudiantil")
                .customerType("NAT")
                .superType("IFR")
                .temporaryInterest("MON")
                .allowBranchTransactions(true)
                .allowBranchTranches(true)
                .allowRedraw(true)
                .build();
        Amortization mockAmortization = Amortization
                .builder()
                .type("FR")
                .term(12)
                .quote(new BigDecimal("250.50"))
                .capital(new BigDecimal("1500.00"))
                .tax(new BigDecimal("0.05"))
                .pendingBalance(new BigDecimal("45.00"))
                .periodUnit("weekly")
                .build();

        LoanProduct mockLoanProduct = LoanProduct.builder()
                .id(null)
                .uniqueKey("bd8a3a089f2")
                .name("Préstamo Estudiantil EduFin")
                .currency("USD")
                .state("INA")
                .description("Vivamus vestibulum sagittis sapien")
                .aplicability("CUS")
                .tranches(40)
                .gracePeriod(273)
                .gracePeriodType("pay_interest_only")
                .fee(new BigDecimal("0.0"))
                .redrawBalance(new BigDecimal("100.0"))
                .minInterest(new BigDecimal("0.0"))
                .maxInterest(new BigDecimal("0.0"))
                .penaltyRate(new BigDecimal("0.0"))
                .minPenaltyValue(new BigDecimal("0.0"))
                .maxPenaltyValue(new BigDecimal("0.0"))
                .creationDate(new Date())
                .lastModifiedDate(new Date())
                .closedDate(new Date())
                .loanProductType(mockLoanProductType)
                .amortization(mockAmortization)
                .build();
        List<LoanProduct> mockLoanProducts = new ArrayList<>();
        mockLoanProducts.add(mockLoanProduct);
        when(loanProductRepository.findLoanProductsByLoanProductType()).thenReturn(mockLoanProducts);
        List<LoanProductTypeRS> result = loanProductService.obtainAllLoanProductTypes();
        assertNotNull(result);
        assertEquals(mockLoanProducts.size(), result.size());
    }

    @Test
    public void LoanProductService_ObtainProductTypes_Failure() {
        when(loanProductRepository.findLoanProductsByLoanProductType()).thenThrow(new RuntimeException("Simulated error"));
        assertThrows(RuntimeException.class, () -> loanProductService.obtainAllLoanProductTypes());
    }


}
