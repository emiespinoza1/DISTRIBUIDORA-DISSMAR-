package com.DistribuidoraDissmar.DistribuidoraDissmar.Repository;
import org.springframework.stereotype.Repository;
import com.DistribuidoraDissmar.DistribuidoraDissmar.Models.Credito;
import org.springframework.data.jpa.repository.JpaRepository; 

@Repository
public interface CreditoRepository extends JpaRepository<Credito, Integer> {

}
