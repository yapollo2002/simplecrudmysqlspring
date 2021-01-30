package com.yapollo.restsecuredmysql.controller;


import com.yapollo.restsecuredmysql.DAO.InvoicesRepository;
import com.yapollo.restsecuredmysql.model.RepairInvoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;
import java.util.List;
import java.util.Optional;


@RestController
public class Controller {

    @Autowired
    InvoicesRepository repository;


           @GetMapping(path="/all")
    List< RepairInvoice > findAll(){
               return (List)repository.findAll();
           }

           @GetMapping(path="/findByID/{id}")
           Optional<RepairInvoice> findById(@PathVariable("id") int id){
               return repository.findById(id);
           }
           @PutMapping(path="/save")
    RepairInvoice save(@RequestBody RepairInvoice invoice){
               return repository.save(invoice);
           }
           @DeleteMapping(path="/delete/{id}")
           void delete(@PathVariable("id") int id) {
        repository.deleteById(id);
    }
           @PostMapping(path="/update")
               RepairInvoice update(@RequestBody RepairInvoice invoice ){
                RepairInvoice tmpinvoice = repository.findById(invoice.getTelNumber()).get();

               tmpinvoice.setModel(invoice.getModel());
               tmpinvoice.setDefect(invoice.getDefect());
               tmpinvoice.setNotes(invoice.getNotes());
               return repository.save(tmpinvoice);

           }

}
