package com.ipiecoles.java.java350.repository;

import com.ipiecoles.java.java350.model.Employe;
import com.ipiecoles.java.java350.model.Entreprise;
import com.ipiecoles.java.java350.repository.EmployeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
@DataJpaTest
//@SpringBootTest

public class EmployeRepositoryTest {



@Autowired
     private EmployeRepository employeRepository;

/* PAS BESOIN DE CETTE ANNOTATION EN UTILISANT DataJpaTest
@BeforeEach
@AfterEach
public void setup(){
    employeRepository.deleteAll();
}
*/

    // test si pas d'employé dans la base
    @Test
    public void testFindLastMatriculeNull(){
        //given

        //when
        String lastMatricule = employeRepository.findLastMatricule();
        //then
        assertNull(lastMatricule);
    }

    // test si un seul employé
    @Test
    public void testFindLastMatriculeSingle(){
        //given
        Employe e = new Employe("Doe", "John", "T12345",
                LocalDate.now(), Entreprise.SALAIRE_BASE, 1, 1.0);
        employeRepository.save(e); // là on écrit sur la base de donnée virtuelle créée, pas dans notre BDD réelle
        // la base de donnée est réinitialisée entre chaque run de test,
        // mais pas entre chaque tests contenus dans ce fichier
        //when
        String lastMatricule = employeRepository.findLastMatricule();
        //then
        assertEquals("12345", lastMatricule);
    }

@Test
public void testFindLastMatriculeMultiple(){

         Employe e = new Employe("Doe", "John", "T12345", LocalDate.now(), Entreprise.SALAIRE_BASE, 1, 1.0);
         Employe e1 = new Employe("Doe", "Jane", "M40325", LocalDate.now(), Entreprise.SALAIRE_BASE, 1, 1.0);
         Employe e2 = new Employe("Doe", "Toto", "C12345", LocalDate.now(), Entreprise.SALAIRE_BASE, 1, 1.0);
    employeRepository.save(e);
    employeRepository.save(e1);
    employeRepository.save(e2);
         //When
    String lastMatricule = employeRepository.findLastMatricule();

        //Then
    Assertions.assertEquals("40325", lastMatricule);
}






 }



