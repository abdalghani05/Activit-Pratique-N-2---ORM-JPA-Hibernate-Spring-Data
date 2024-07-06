package org.enset.hospitalenset;

import org.enset.hospitalenset.entities.*;
import org.enset.hospitalenset.repositories.ConsultationRepository;
import org.enset.hospitalenset.repositories.MedcinRepository;
import org.enset.hospitalenset.repositories.PatientRepository;
import org.enset.hospitalenset.repositories.RendezVousRepository;
import org.enset.hospitalenset.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalEnsetApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalEnsetApplication.class, args);
    }

    @Bean
    CommandLineRunner start(IHospitalService iHospitalService,PatientRepository patientRepository,MedcinRepository medcinRepository,RendezVousRepository rendezVousRepository){
        return args -> {
            Stream.of("soufiane","kamal","oussama","abdelghani").forEach(
                    name->{
                        Patient patient=new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        iHospitalService.savePatient(patient);
                    }
            );
            Stream.of("abdeltife","kamal","othmane").forEach(
                    name->{
                        Medcin medcin=new Medcin();
                        medcin.setNom(name);
                        medcin.setEmail(name+"@mail.com");
                        medcin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                        iHospitalService.saveMedecin(medcin);
                    }
            );

            Patient patient=patientRepository.findById(1L).orElse(null);
            Patient patient2=patientRepository.findByNom("abdelghani");

            Medcin medcin=medcinRepository.findByNom("soufiane");

            RendezVous rendezVous1=new RendezVous();
            rendezVous1.setDate(new Date());
            rendezVous1.setStatus(StatusRDV.PENDING);
            rendezVous1.setMedecin(medcin);
            rendezVous1.setPatient(patient);
            RendezVous saveRV = iHospitalService.saveRendezVous(rendezVous1);
            System.out.println(saveRV.getId());




            Consultation consultation=new Consultation();
            consultation.setDateConsultation(rendezVous1.getDate());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de la consultation");
            iHospitalService.saveConsultation(consultation);

        };
    }
}
