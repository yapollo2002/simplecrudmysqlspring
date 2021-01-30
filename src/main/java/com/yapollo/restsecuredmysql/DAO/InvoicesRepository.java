package com.yapollo.restsecuredmysql.DAO;

import com.yapollo.restsecuredmysql.model.RepairInvoice;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

 public interface InvoicesRepository extends CrudRepository<RepairInvoice, Integer> {



}
