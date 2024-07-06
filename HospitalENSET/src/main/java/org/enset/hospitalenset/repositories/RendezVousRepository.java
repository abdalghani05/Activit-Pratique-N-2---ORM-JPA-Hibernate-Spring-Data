package org.enset.hospitalenset.repositories;

import org.enset.hospitalenset.entities.Patient;
import org.enset.hospitalenset.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous,String> {

}
