package org.enset.hospitalenset.service;

import org.enset.hospitalenset.entities.Consultation;
import org.enset.hospitalenset.entities.Medcin;
import org.enset.hospitalenset.entities.Patient;
import org.enset.hospitalenset.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medcin saveMedecin(Medcin Medcin);

    RendezVous saveRendezVous(RendezVous rendezVous);

    Consultation saveConsultation(Consultation consultation);
}
