// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.web.client.TestRestTemplate;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.test.context.junit4.SpringRunner;
// import org.springframework.test.web.servlet.MockMvc;
// import static org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder.*;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// import fr.ensai.demo.DemoApplication;
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import org.apache.tomcat.util.http.parser.MediaType;



// @RunWith(SpringRunner.class)
// @SpringBootTest(
// webEnvironment = SpringBootTest.WebEnvironment.MOCK,
// classes = DemoApplication.class)
// @AutoConfigureMockMvc
// class UsersControllerTest {

//     @Autowired
//     private MockMvc mvc;

//     @Autowired
//     private EmployeeRepository usersRepository;


//     @Test
//     void testCountEmployees() {
//     mvc.perform(get("/employees/count")
//     .contentType(MediaType.APPLICATION_JSON))
//     .andExpect(status().isOk())
//     .andExpect(content().string("3"));
// }

//     // @Test
//     // void addUserEndpoint() throws Exception {
//     //     UsersPojo usersPojo=new UsersPojo("bidMore","Bid","More","admin");
//     //     ObjectMapper mapper = new ObjectMapper();
//     //     mockMvc.perform(post("/api/v1/addUser")
//     //                     .contentType(MediaType.APPLICATION_JSON)
//     //                     .content(mapper.writeValueAsString(usersPojo))
//     //                     .accept(MediaType.APPLICATION_JSON))
//     //             .andExpect(status().isCreated())
//     //             .andExpect(content()
//     //                     .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//     //             .andExpect(jsonPath("statusCode" , is(201)))
//     //             .andExpect(jsonPath("message.usersId", is(5)));

//     // }

// }