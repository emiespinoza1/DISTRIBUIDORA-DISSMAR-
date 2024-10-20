package com.DistribuidoraDissmar.DistribuidoraDissmar.Repository;
import org.springframework.stereotype.Repository;
import com.DistribuidoraDissmar.DistribuidoraDissmar.Models.Abono;
import org.springframework.data.jpa.repository.JpaRepository;




@Repository 
public interface AbonoRepository  extends JpaRepository<Abono, Integer> {

}
