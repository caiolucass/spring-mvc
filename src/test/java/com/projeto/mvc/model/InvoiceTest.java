package com.projeto.mvc.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InvoiceTest {

    @Test
    public void InvoiceTest(){
        Invoice invoice = new Invoice(1L,"name", "Belo Horizonte", 23.5);
        assertEquals(1L, invoice.getId());
        assertEquals("name", invoice.getName());
        assertEquals("Belo Horizonte", invoice.getLocation());
        assertEquals(23.5, invoice.getAmount());

        Invoice invoice1 = new Invoice();
        invoice1.setId(2L);
        assertEquals(2L, invoice1.getId());
    }
}
