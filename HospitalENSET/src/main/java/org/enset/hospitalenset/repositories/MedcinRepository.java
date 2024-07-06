package org.enset.hospitalenset.repositories;

import org.enset.hospitalenset.entities.Medcin;
import org.enset.hospitalenset.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedcinRepository extends JpaRepository<Medcin,Long> {
    Medcin findByNom(String nom);
}
