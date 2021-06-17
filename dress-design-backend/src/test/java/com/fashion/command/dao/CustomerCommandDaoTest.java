package com.fashion.command.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.fashion.entity.Customer;

@DataJpaTest
@TestMethodOrder(OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
@TestPropertySource(properties = { "spring.jpa.properties.hibernate.format-sql=true"

})
public class CustomerCommandDaoTest {

	@Autowired
	CustomerCommandDao customerDao;

	private Customer dbCustomer;

	@Test
	@Rollback(false)
	@Order(1)
	void testSave() {
		Customer customer = Customer.customerBuilder().customerName("John Walker").customerId("JK1234567890")
				.address("12/13 Street").email("john@test.com").createdByUserId("DW1234567890").phone("1234567890")
				.build();
		dbCustomer = customerDao.saveAndFlush(customer);
		assertThat(dbCustomer.getId()).isNotNull();
		assertThat(dbCustomer.getCustomerName()).isEqualTo(customer.getCustomerName());
		assertThat(dbCustomer.getStatus()).isTrue();
		assertThat(dbCustomer.getCreatedAt().isBefore(LocalDateTime.now())).isTrue();
		assertThat(dbCustomer.getVersion()).isEqualTo(0);
	}

	@Test
	@Order(2)
	void testFindById() {
		Customer customer = customerDao.findById(dbCustomer.getId()).get();
		assertThat(customer).isNotNull();
		assertThat(customer.getPhone()).isEqualTo(dbCustomer.getPhone());
	}

	@Test
	@Rollback(false)
	@Order(3)
	void testUpdate() {
		Optional<Customer> customer = customerDao.findById(dbCustomer.getId());
		customer.ifPresent(u -> {
			u.setPhone("9876543210");
			Customer updatedCustomer = customerDao.saveAndFlush(u);
			assertThat(updatedCustomer).isNotNull();
			assertThat(updatedCustomer.getPhone()).isNotEqualTo(dbCustomer.getPhone()).isEqualTo("9876543210");
		});
	}

	@Test
	@Rollback(false)
	@Order(4)
	void testDeleteById() {
		customerDao.deleteById(dbCustomer.getId());
		Optional<Customer> customer = customerDao.findById(dbCustomer.getId());
		assertThat(customer.isPresent()).isFalse();
	}

	@Test
	@Order(5)
	void testConstraintViolationException() {
		Customer customerException = Customer.customerBuilder().customerName("John Walker").customerId("JK1234567890")
				.address("12/13 Street").email("john@test.com").createdByUserId("DW1234567890").build();
		assertThrows(ConstraintViolationException.class, () -> {
			customerDao.saveAndFlush(customerException);
		});
	}

}
