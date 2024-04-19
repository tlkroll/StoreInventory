package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(partRepository.count() == 0 && productRepository.count() == 0){
            OutsourcedPart barrel= new OutsourcedPart();
            barrel.setCompanyName("Krieger");
            barrel.setName("Barrel");
            barrel.setInv(20);
            barrel.setPrice(700.0);
            barrel.setId(100L);
            outsourcedPartRepository.save(barrel);

            OutsourcedPart stock= new OutsourcedPart();
            stock.setCompanyName("McMillan");
            stock.setName("Stock");
            stock.setInv(10);
            stock.setPrice(1000.0);
            stock.setId(200L);
            outsourcedPartRepository.save(stock);

            OutsourcedPart trigger= new OutsourcedPart();
            trigger.setCompanyName("Timney");
            trigger.setName("Trigger");
            trigger.setInv(50);
            trigger.setPrice(150.0);
            trigger.setId(300L);
            outsourcedPartRepository.save(trigger);

            OutsourcedPart sight= new OutsourcedPart();
            sight.setCompanyName("Trijicon");
            sight.setName("Sight");
            sight.setInv(100);
            sight.setPrice(200.0);
            sight.setId(400L);
            outsourcedPartRepository.save(sight);

            OutsourcedPart scope= new OutsourcedPart();
            trigger.setCompanyName("Zeiss");
            trigger.setName("Scope");
            trigger.setInv(20);
            trigger.setPrice(1200.0);
            trigger.setId(500L);
            outsourcedPartRepository.save(trigger);

            OutsourcedPart thePart=null;
            List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for(OutsourcedPart part:outsourcedParts){
                if(part.getName().equals("Barrel"))thePart=part;
                if(part.getName().equals("Stock"))thePart=part;
                if(part.getName().equals("Trigger"))thePart=part;
                if(part.getName().equals("Sight"))thePart=part;
                if(part.getName().equals("Scope"))thePart=part;
                System.out.println(thePart.getCompanyName());
            }
            Product boltRifle= new Product("Bolt-action rifle",1000.0,20);
            Product semiRifle = new Product("Semi-automatic rifle",1500.0,15);
            Product pumpShot = new Product("Pump-action shotgun",500.0,50);
            Product semiShot = new Product("Semi-automatic shotgun",1200.0,10);
            Product doubleShot = new Product("Double barrel shotgun",2000.0,5);
            productRepository.save(boltRifle);
            productRepository.save(semiRifle);
            productRepository.save(pumpShot);
            productRepository.save(semiShot);
            productRepository.save(doubleShot);
        }

        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
