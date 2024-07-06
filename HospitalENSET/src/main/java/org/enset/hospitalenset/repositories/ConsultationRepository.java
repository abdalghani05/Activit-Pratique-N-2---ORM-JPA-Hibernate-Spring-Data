package org.enset.hospitalenset.repositories;

import org.enset.hospitalenset.entities.Consultation;
import org.enset.hospitalenset.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {

}
