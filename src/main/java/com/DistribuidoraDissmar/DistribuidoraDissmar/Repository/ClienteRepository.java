package com.DistribuidoraDissmar.DistribuidoraDissmar.Repository;
import org.springframework.stereotype.Repository;
import com.DistribuidoraDissmar.DistribuidoraDissmar.Models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;




@Repository 
public interface ClienteRepository  extends JpaRepository<Cliente, Integer> {

}
