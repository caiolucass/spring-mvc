package com.projeto.mvc.controller;

import com.projeto.mvc.exception.InvoiceNotFoundException;
import com.projeto.mvc.model.Invoice;
import com.projeto.mvc.service.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    private IInvoiceService service;

    @GetMapping("/")
    public String showHomePage(){
        return "homePage";
    }

    @GetMapping("/register")
    public String showRegistration(){
        return "registerInvoicePage";
    }

    @PostMapping("/save")
    public String saveInvoice( @ModelAttribute Invoice invoice, Model model){
        service.saveInvoice(invoice);
        Long id = service.saveInvoice(invoice).getId();
        String message = "Invoice com o id : '"+id+"' salvo com sucesso!";
        model.addAttribute("message", message);
        return "registerInvoicePage";
    }

    @GetMapping("/getAllInvoices")
    public String getAllInvoices(@RequestParam(value = "message", required = false) String message, Model model){
        List<Invoice> invoices = service.getAllInvoices();
        model.addAttribute(invoices);
        model.addAttribute("message", message);
        return "allInvoicesPage";
    }

    @GetMapping("/edit")
    public String getEditPage(Model model, RedirectAttributes attributes, @RequestParam Long id){
        String page = null;
        try{
            Invoice invoice = service.getInvoiceBtId(id);
            model.addAttribute("invoice", invoice);
            page="editInvoicePage";
        }catch (InvoiceNotFoundException e){
            e.printStackTrace();
            attributes.addAttribute("message", e.getMessage());
            page="redirect:getAllInvoices";
        }
        return page;
    }

    @PostMapping("/update")
    public String updateInvoice(@ModelAttribute Invoice invoice, RedirectAttributes attributes){
        service.updateInvoice(invoice);
        Long id = invoice.getId();
        attributes.addAttribute("message", "Invoice com o id: '"+id+"' foi atualizado com sucesseo !");
        return "redirect:getAllInvoices";
    }

    @GetMapping("/delete")
    public String deleteInvoice(@RequestParam Long id, RedirectAttributes attributes){
         try {
             service.deleteInvoiceById(id);
             attributes.addAttribute("message", "Invoice com Id : '"+id+"' foi exluido com sucesso!");
         }catch (InvoiceNotFoundException e){
             e.printStackTrace();
             attributes.addAttribute("message", e.getMessage());
         }
         return "redirect:getAllInvoices";
    }
}
