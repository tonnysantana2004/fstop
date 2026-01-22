package fstop;

import fstop.ticket.category.infrastructure.TicketCategoryEntity;
import fstop.ticket.category.infrastructure.TicketCategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static org.springframework.boot.SpringApplication.*;

/**
 * @author Tonny Santana
 * @date 18/01/2026 22:24
 * @since 1.0.0
 */

@SpringBootApplication
public class FstopApplication {
    
    public static void main(String[] args) {
        run(FstopApplication.class, args);
    }
    
    @Bean
    CommandLineRunner innitData(TicketCategoryRepository ticketCategoryRepository) {
        
        return args -> {
            if (ticketCategoryRepository.count() == 0) {
                ticketCategoryRepository.save(new TicketCategoryEntity("Suporte Técnico"));
                ticketCategoryRepository.save(new TicketCategoryEntity("Finanças"));
                ticketCategoryRepository.save(new TicketCategoryEntity("Recursos Humanos"));
                ticketCategoryRepository.save(new TicketCategoryEntity("Comercial / Vendas"));
                ticketCategoryRepository.save(new TicketCategoryEntity("Infraestrutura / TI"));
                ticketCategoryRepository.save(new TicketCategoryEntity("Jurídico / Contratos"));
                ticketCategoryRepository.save(new TicketCategoryEntity("Sugestões / Feedback"));
            }
        };
        
    }
}
