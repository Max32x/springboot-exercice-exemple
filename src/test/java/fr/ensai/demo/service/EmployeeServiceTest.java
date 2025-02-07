package fr.ensai.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit4.SpringRunner;

import fr.ensai.demo.model.Employee;
import fr.ensai.demo.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)

class EmployeeServiceTest {
    Logger LOG = LoggerFactory.getLogger(EmployeeServiceTest.class);

    @Autowired
    EmployeeService employeeService;

    @Test
    void testGeneratePasswordLength() {
        // Longueur attendue du mot de passe
        int expectedLength = 12; // Exemple, à ajuster selon votre implémentation

        // Appel de la méthode generatePassword
        String generatedPassword = employeeService.generatePassword(expectedLength);

        LOG.info("Mot de passe généré : {}", generatedPassword);

        // Vérification de la longueur du mot de passe
        assertEquals(expectedLength, generatedPassword.length(),
            "La longueur du mot de passe généré n'est pas correcte");
    }



    @Test
    void given_allowedChars_when_generatePassword_then_PasswordAllowed() {

        // Appel de la méthode generatePassword
        String generatedPassword = employeeService.generatePassword(12);
        LOG.info("Mot de passe généré : {}", generatedPassword);

        // Vérification que chaque caractère appartient à allowedCharString
        boolean allCharactersValid = generatedPassword.chars()
                .mapToObj(c -> (char) c)
                .allMatch(c -> EmployeeService.allowedCharString.indexOf(c) >= 0);

        assertTrue(allCharactersValid, 
            "Le mot de passe contient des caractères non autorisés");
    }



    @Test
    void given_length_when_generatetooLongPassword_then_error() {
        // Longueur attendue du mot de passe
        int expectedLength = 12; // Exemple : la longueur prévue dans generatePassword
    
        // Tester sur plusieurs itérations pour s'assurer de la cohérence
        for (int i = 0; i < 100; i++) { // Tester sur 100 mots de passe générés
            String generatedPassword = employeeService.generatePassword(expectedLength+1);
            LOG.info("Mot de passe généré : ", generatedPassword);
    
            // Vérification que la longueur est correcte
            assertEquals(expectedLength, generatedPassword.length(),
                "La longueur du mot de passe généré est incorrecte");
        }
    }
//     @Test
//     void given_length_when_generatetooLongPassword_then_error2() {
//         // Longueur attendue du mot de passe
//         int expectedLength = 12; // Exemple : la longueur prévue dans generatePassword
    
//         // Tester sur plusieurs itérations pour s'assurer de la cohérence
//         for (int i = 0; i < 100; i++) { // Tester sur 100 mots de passe générés
//             String generatedPassword = employeeService.generatePassword(expectedLength+1);
//             LOG.info("Mot de passe généré : ", generatedPassword);
    
//             // Vérification que la longueur est correcte
//             assertEquals(expectedLength, generatedPassword.length(),
//                 "La longueur du mot de passe généré est incorrecte");
//         }
//     }
    

//     @MockitoBean
//     private EmployeeRepository employeeRepository;


//     @Test
//     void testSearchEmployeesCaseSensitive() {
//         // Arrange
//         String term = "John";
//         boolean caseSensitive = true;

//         Employee emp1 = new Employee((long) 1, "John", "Doe", "johndoe@gamil.com","motdepasse");
//         Employee emp2 = new Employee((long) 2, "Jane", "Smith", "janesmith@gamil.com","motdepasse");
//         Employee emp3 = new Employee((long) 1, "John", "McCree", "johndoe@gamil.com","motdepasse");


//         when(employeeRepository.findByFirstName("John")).thenReturn(Collections.singletonList(emp1));
//         when(employeeRepository.findByLastName("Doe")).thenReturn(Collections.singletonList(emp1));
//         when(employeeRepository.findByFirstName("Jane")).thenReturn(Collections.singletonList(emp2));
//         when(employeeRepository.findByLastName("Smith")).thenReturn(Collections.singletonList(emp2));
//         when(employeeRepository.findByFirstName("John")).thenReturn(Collections.singletonList(emp3));
//         when(employeeRepository.findByLastName("McCree")).thenReturn(Collections.singletonList(emp3));
//         // Act
//         Iterable<Employee> result = employeeService.searchEmployees("John", caseSensitive);

//         // Assert
//         List<Employee> resultList = (List<Employee>) result;

//         assertEquals(2, resultList.size());
//         assertTrue(resultList.contains(emp1));
//         assertTrue(resultList.contains(emp3));

        

//         verify(employeeRepository).findByFirstName(term);
//         verify(employeeRepository).findByLastName(term);
//     }


    
}