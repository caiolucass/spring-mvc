package com.projeto.mvc.controller;

import com.projeto.mvc.model.Invoice;
import com.projeto.mvc.repository.InvoiceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class InvoiceControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    InvoiceRepository invoiceRepository;

    @Test
    public void showHomePageTest() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void showRegistrationTest() throws Exception {
        this.mockMvc.perform(get("/register"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void saveInvoiceTest() throws Exception {
        Invoice invoice = new Invoice(1L, "Caio Lucas", "Belo Horizonte", 23.0);
        given(invoiceRepository.save(invoice));
        mockMvc.perform(post("/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(invoice.toString()))
                .andExpect(status().isCreated());
    }
}
