package org.enset.students.repository;

import jakarta.transaction.Transactional;
import org.enset.students.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByNameContaining(String name);
    @Query("select s from Student s where s.name like :x")
    List<Student> search(@Param("x") String mc);

    @Modifying
    @Transactional
    @Query("update Student s set s.name = :name, s.dateNaissance = :dateNaissance, s.malade = :malade, s.score = :score where s.id = :id")
    void updateStudent(@Param("id") Long id, @Param("name") String name, @Param("dateNaissance") Date dateNaissance, @Param("malade") Boolean malade, @Param("score") int score);


    @Modifying
    @Transactional
    @Query("delete from Student s where s.id = :id")
    void deleteStudentById(@Param("id") Long id);

}
