package com.danka.airbnb;

import com.danka.airbnb.repositories.UsersRepository;
import com.danka.airbnb.repositories.ListingsRepository;
import com.danka.airbnb.models.Users;
import com.danka.airbnb.models.Listings;
import com.danka.airbnb.models.SpecialPrices;
import com.danka.airbnb.repositories.SpecialPricesRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AirbnbApplication {

    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    
    public static void main(String[] args) {
        SpringApplication.run(AirbnbApplication.class, args);
    }

    @Bean
    CommandLineRunner init(ListingsRepository listingRepository, UsersRepository userRepository, SpecialPricesRepository specialPricesRepository) {
        return args -> {
            userRepository.save(new Users("DanKa", "a@a.com", "aa"));
            userRepository.save(new Users("DanKa1", "a1@a.com", "aa1"));
            userRepository.findAll().forEach(System.out::println);
            
            userRepository.findAll().forEach((user) -> {
                listingRepository.save(new Listings(user.getId(), "Casa "+user.getId().toString().substring(3), "casa-user-"+user.getName(), "Casa del usuario "+user.getName(), 
                        2, 3, true, 100D, 10D, "assets/imagen1.png", 0.60D, 0.74D));   
                listingRepository.save(new Listings(user.getId(), "Casa "+user.getId().toString().substring(3), "casa-user-"+user.getName(), "Casa del usuario "+user.getName(), 
                        3, 4, true, 110D, 12D, "assets/imagen1.png", 0.50D, 0.64D)); 
                listingRepository.save(new Listings(user.getId(), "Casa "+user.getId().toString().substring(3), "casa-user-"+user.getName(), "Casa del usuario "+user.getName(), 
                        4, 5, true, 90D, 11D, "assets/imagen1.png", 0.70D, 0.84D));                 
            });
            listingRepository.findAll().forEach(System.out::println);
            
            listingRepository.findAll().forEach((list)->{
                try {
                    specialPricesRepository.save(new SpecialPrices(list.getId(), DATE_FORMAT.parse("2021-03-11"), 60D));
                    specialPricesRepository.save(new SpecialPrices(list.getId(), DATE_FORMAT.parse("2021-03-12"), 60D));
                    specialPricesRepository.save(new SpecialPrices(list.getId(), DATE_FORMAT.parse("2021-03-18"), 60D));
                    specialPricesRepository.save(new SpecialPrices(list.getId(), DATE_FORMAT.parse("2021-03-19"), 60D));
                    specialPricesRepository.save(new SpecialPrices(list.getId(), DATE_FORMAT.parse("2021-03-25"), 60D));
                    specialPricesRepository.save(new SpecialPrices(list.getId(), DATE_FORMAT.parse("2021-03-26"), 60D));
                } catch (ParseException ex) {
                    Logger.getLogger(AirbnbApplication.class.getName()).log(Level.SEVERE, null, ex);
                }                
            });
            
            
        };
    }

}
