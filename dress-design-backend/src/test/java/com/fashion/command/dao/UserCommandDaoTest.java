package com.fashion.command.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

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

import com.fashion.entity.User;

@DataJpaTest
@TestMethodOrder(OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
@TestPropertySource(properties = {
		"spring.jpa.properties.hibernate.format-sql=true"
		
})
public class UserCommandDaoTest {

	@Autowired
	UserCommandDao userDao;

	private User dbUser;

	@Test
	@Rollback(false)
	@Order(1)
	void testSave() {
		User user = User.builder().fullName("David Warner").email("david@test.com").phone("1234567890")
				.password("mypassword").loginId("DW1234567890").build();
		dbUser = userDao.save(user);
		assertThat(dbUser.getId()).isNotNull();
		assertThat(dbUser.getLoginId()).isEqualTo(user.getLoginId());
		assertThat(dbUser.getStatus()).isTrue();
	}

	@Test
	@Order(2)
	void testFindById() {
		User user = userDao.findById(dbUser.getId()).get();
		assertThat(user).isNotNull();
		assertThat(user.getPhone()).isEqualTo(dbUser.getPhone());
	}

	@Test
	@Order(3)
	void testFindByLoginId() {
		User user = userDao.findByLoginId(dbUser.getLoginId());
		assertThat(user).isNotNull();
		assertThat(user.getEmail()).isEqualTo(dbUser.getEmail());
	}

	@Test
	@Rollback(false)
	@Order(4)
	void testUpdate() {
		Optional<User> user = userDao.findById(dbUser.getId());
		user.ifPresent(u -> {
			u.setPhone("9876543210");
			User updatedUser = userDao.save(u);
			assertThat(updatedUser).isNotNull();
			assertThat(updatedUser.getPhone()).isEqualTo("9876543210");
		});
	}

	@Test
	@Rollback(false)
	@Order(5)
	void testDeleteById() {
		userDao.deleteById(dbUser.getId());
		Optional<User> user = userDao.findById(dbUser.getId());
		assertThat(user.isPresent()).isFalse();
	}

}
