package com.projeto.mvc.service;

import com.projeto.mvc.exception.InvoiceNotFoundException;
import com.projeto.mvc.model.Invoice;
import com.projeto.mvc.repository.InvoiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class InvoiceServiceImpl implements IInvoiceService{

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public Invoice saveInvoice(Invoice invoice) {
        log.info("Salvando novo Invoice {} no banco de dados.", invoice.getName());
        return invoiceRepository.save(invoice);
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice getInvoiceById(Long id) {
        Optional<Invoice> opt = invoiceRepository.findById(id);
        if(opt.isPresent()){
            return opt.get();
        }
        else{
            throw new InvoiceNotFoundException("Invoice com o id:" +id+ " nao encontrado!");
        }
    }

    @Override
    public void deleteInvoiceById(Long id) {
        log.info("Invoice excluido {} do banco de dados.", id);
        invoiceRepository.deleteById(id);
    }

    @Override
    public void updateInvoice(Invoice invoice) {
        log.info("Invoice atualizado novo {} no banco de dados.", invoice.getName());
        invoiceRepository.save(invoice);
    }
}
