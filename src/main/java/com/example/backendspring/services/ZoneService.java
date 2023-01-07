package com.example.backendspring.services;

import com.example.backendspring.beans.Zone;
import com.example.backendspring.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
@Service
public class ZoneService {

    @Autowired
    ZoneRepository zoneRepo;




    public List<Zone> getZonesByVille(int id) {
        List<Zone> invoices=zoneRepo.findAll();
        List<Zone> invoicescat= new ArrayList<>();

        Zone invoice = null;

        for(Zone con:invoices){
            if(con.getVille().getId()==id) {
                invoice = con;
                invoicescat.add(invoice);
            }
        }
        return invoicescat;
    }





}
