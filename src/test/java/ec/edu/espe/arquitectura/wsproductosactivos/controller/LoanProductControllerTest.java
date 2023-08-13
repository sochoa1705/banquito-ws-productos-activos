package ec.edu.espe.arquitectura.wsproductosactivos.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ec.edu.espe.arquitectura.wsproductosactivos.controller.dto.LoanProductTypeRS;
import ec.edu.espe.arquitectura.wsproductosactivos.service.LoanProductService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = LoanProductController.class)
@AutoConfigureMockMvc(addFilters = false)
@RunWith(MockitoJUnitRunner.class)
public class LoanProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LoanProductService loanProductService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void LoanProductController_ObtainLoanProductTypes() throws Exception {
        List<LoanProductTypeRS> loanProductTypeRS = new ArrayList<>();
        loanProductTypeRS.add(LoanProductTypeRS.builder()
                .name("Préstamo estudiantil")
                .customerType("NAT")
                .superType("IFR")
                .temporaryInterest("MON")
                .allowBranchTransactions(true)
                .allowBranchTranches(true)
                .allowRedraw(true)
                .build());
        when(loanProductService.obtainAllLoanProductTypes()).thenReturn(loanProductTypeRS);
        ResultActions response = mockMvc.perform(get("/api/v1/loan-product/types")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loanProductTypeRS)));

        response.andExpect(status().isOk());


    }

}
