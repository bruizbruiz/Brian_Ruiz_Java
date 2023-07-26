package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
@Import(CustomerController.class)
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerRepository customerRepository;

    private ObjectMapper mapper = new ObjectMapper();

    private List<Customer> customerList;

    @BeforeEach
    public void setUp() {

    }

    // Testing POST "/customer"
    @Test
    public void shouldCreateCustomer() throws Exception{
        Customer customer = new Customer();

        customer.setFirstName("Bob");
        customer.setLastName("Ruiz");
        customer.setAddress1("225 CAE St");
        customer.setCity("NWR");
        customer.setState("CA");
        customer.setCountry("United States");
        customer.setPostalCode("53532");
        customer.setCompany("Pepsi");
        customer.setEmail("bobruiz@pepsi.co");
        customer.setPhone("111-223-7584");

        String inputJson = mapper.writeValueAsString(customer);

        mockMvc.perform(post("/customer")
            .content(inputJson)
            .contentType(MediaType.APPLICATION_JSON)
            )
                .andDo(print())
                .andExpect(status().isCreated());
    }

    // Testing PUT "/customer"
    @Test
    public void shouldUpdateCustomer() throws Exception {
        Customer customer = new Customer();

        customer.setFirstName("Bob");
        customer.setLastName("Ruiz");
        customer.setAddress1("225 CAE St");
        customer.setCity("NWR");

        String inputJson = mapper.writeValueAsString(customer);

        mockMvc.perform(put("/customer")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
            )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    // Testing Delete "/customer/{id}"
    @Test
    public void shouldDeleteCustomerById() throws Exception {
        mockMvc.perform(delete("/customer/2"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldGetCustomerById() throws Exception {
        Customer customer = new Customer();

        customer.setFirstName("Bob");
        customer.setLastName("Ruiz");
        customer.setEmail("bobruiz@pepsi.co");
        customer.setPhone("111-223-7584");
        customer.setId(21);

        String outputJson = mapper.writeValueAsString(customer);

        mockMvc.perform(get("/customer/21"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetCustomerByState() throws Exception {


        mockMvc.perform(get("/customer/state/NJ"))
                .andDo(print())
                .andExpect(status().isOk());

    }

}