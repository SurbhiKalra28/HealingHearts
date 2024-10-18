package com.surbhikalra.healinghearts.repository;

import com.surbhikalra.healinghearts.model.Appointment;
import com.surbhikalra.healinghearts.model.User;
import com.surbhikalra.healinghearts.repository.UserRepository;
import com.surbhikalra.healinghearts.repository.AppointmentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class RepositoryTest {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("Test findByUsername in UserRepository")
    public void testFindByUsername() {
        System.out.println("Testing find by username");

        // Setup data for testing
        User user = new User();
        user.setUsername("john_doe");
        user.setPassword("password");
        user.setEmail("john@example.com");
        userRepository.save(user);

        // Test the query method
        User foundUser = userRepository.findByUsername("john_doe");

        // Assertions
        assertNotNull(foundUser);
        assertEquals("john_doe", foundUser.getUsername());
    }

    @Test
    @DisplayName("Test findByEmail in UserRepository")
    public void testFindByEmail() {
        System.out.println("Testing find by email");
        // Setup data for testing
        User user = new User();
        user.setUsername("jane_doe");
        user.setPassword("password");
        user.setEmail("jane@example.com");
        userRepository.save(user);

        // Test the query method
        Optional<User> foundUser = userRepository.findByEmail("jane@example.com");

        // Assertions
        assertTrue(foundUser.isPresent());
        assertEquals("jane@example.com", foundUser.get().getEmail());
    }

}
