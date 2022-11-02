package com.sal.vendingmachine.dao;

import com.sal.vendingmachine.service.VendingMachinePersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 *
 * @author Elizabeth Yim
 *
 */
@Component
public class AuditDaoImpl implements AuditDao{
    public final String AUDIT_FILE;
    public AuditDaoImpl(){
        AUDIT_FILE="audit.txt";
    }
    public AuditDaoImpl(String auditTextFile){
        AUDIT_FILE=auditTextFile;
    }

    @Override
    public void writeAuditEntry(String entry) throws VendingMachineException, VendingMachinePersistenceException {
        PrintWriter out;
        try{
            out=new PrintWriter(new FileWriter(AUDIT_FILE,true));
        } catch (IOException e){
            throw new VendingMachinePersistenceException("Error: Could not persist audit information");
        }
        LocalDateTime timeStamp = LocalDateTime.now();
        out.println(timeStamp.toString()+" : "+ entry);
        out.flush();
    }

}