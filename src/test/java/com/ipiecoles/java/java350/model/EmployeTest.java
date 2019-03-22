package com.ipiecoles.java.java350.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

public class EmployeTest {

    @Test
    public void testGetNombreAnneeAncienneteDateEmbaucheNull(){

        //Given = Initialisation des données d'entrée
        Employe e = new Employe();
        e.setDateEmbauche(null);

        //When = Exécution de la méthode à tester
        Integer nbAnneeAnciennete = e.getNombreAnneeAnciennete();


        //Then = Vérifications de ce qu'a fait la méthode
        Assertions.assertEquals(0, (int)nbAnneeAnciennete);

        }

    //Date d'embauche posterieur
    @Test
    public void getNombreAnneeAncienneteNmonus2(){

    //Given
        Employe e = new Employe();
        e.setDateEmbauche(LocalDate.now().minusYears(2));

    //When
        Integer anneeAnciennete = e.getNombreAnneeAnciennete();
    //Then
        Assertions.assertEquals(2, anneeAnciennete.intValue());
    }


    @Test
    public void testNombreAnneesAncienneteDateEmbaucheAfterNow() {

        Employe e = new Employe();
        e.setDateEmbauche(LocalDate.now().plusYears(1));

        Integer nbAnneeAnciennete = e.getNombreAnneeAnciennete();

        Assertions.assertEquals(0, (int)nbAnneeAnciennete);
    }

    @ParameterizedTest(name = "pour employé marticule {1}, perf {0}, ancienneté {2}, temps partiel {3} : prime annuelle {4}")
    @CsvSource({
            "1, 'T12345', 0, 1.0, 1000.0"
            // ici les valeurs données doivent être calculées à la main et non pas par la code, sinon évidemment ça va être evalidé.
    })

    void testGetPrimeAnnuelle(Integer performance, String matricule, Long nbYearsAnciennete, Double tempsPartiel, Double primeAnnuelle ){

        // Given
        Employe e = new Employe("Doe", "John", matricule, LocalDate.now().minusYears(nbYearsAnciennete), Entreprise.SALAIRE_BASE, performance, tempsPartiel);

        // When
        Double primeATester = e.getPrimeAnnuelle();

        // Then
        Assertions.assertEquals(primeAnnuelle, primeATester);

    }
}


