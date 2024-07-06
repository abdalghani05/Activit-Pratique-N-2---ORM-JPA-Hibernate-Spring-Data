package org.enset.students;

import org.enset.students.entities.Student;
import org.enset.students.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class StudentsApplication implements CommandLineRunner {
    @Autowired
    private StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(StudentsApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        // Ajouter des etudiants
                studentRepository.save(new Student(null,"NAIRI ABDELGHANI",new Date("1998/02/16"), false,18 ));
                studentRepository.save(new Student(null,"SOUMIA EL BRINI",new Date("1999/03/10"), false,16 ));
                studentRepository.save(new Student(null,"FATIMA NAIRI",new Date("1992/11/05"), false,12 ));

        // Consulter tous les etudiants
        List<Student> studentList = studentRepository.findAll();
        studentList.forEach(p->{
            System.out.println(p.toString());
        });

        // Consulter un etudiant
        Student student=studentRepository.findById(Long.valueOf(1)).get();
        System.out.println("---------------------------------");
        System.out.println(student.getId());
        System.out.println(student.getName());
        System.out.println(student.getDateNaissance());
        System.out.println(student.getScore());
        System.out.println("---------------------------------");

        // Chercher des etudiant
        List<Student> studentsSearch = studentRepository.search("%Abdelkader%");

        // Modifier un etudiant
        studentRepository.updateStudent(Long.valueOf(1), "NAIRI ABDELGHANI",new Date("1998/02/16"), false, 19);

        // Supprimer un etudiant
        studentRepository.deleteStudentById(Long.valueOf(2));
    }


}
