package fr.ensai.demo.model;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import fr.ensai.demo.DemoApplication;
import fr.ensai.demo.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class EmployeeControllerTest {
    
}
