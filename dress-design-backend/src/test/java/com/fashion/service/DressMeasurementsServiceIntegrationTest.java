package com.fashion.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringRunner;

import com.fashion.dao.DressMeasurementsDao;
import com.fashion.model.DressMeasurements;
import com.fashion.service.impl.DressMeasurementsServiceImpl;
import com.fashion.service.impl.JWTDBUserDetailsServiceImpl;

@RunWith(SpringRunner.class)
public class DressMeasurementsServiceIntegrationTest {

	static List<DressMeasurements> dressMeasurements = new ArrayList<>();
	static {
		DressMeasurements countOne = new DressMeasurements();
		countOne.setNeck("Neck-1");
		countOne.setArmLength("10");
		DressMeasurements countTwo = new DressMeasurements();
		countTwo.setNeck("Neck-2");
		countTwo.setArmLength("20");
		dressMeasurements.add(countOne);
		dressMeasurements.add(countTwo);
	}
	
	@TestConfiguration
	static class DressMeasurementsServiceImplTestContextConfiguration {

		@Bean
		public DressMeasurementsService dressMeasurementsService() {
			return new DressMeasurementsServiceImpl();
		}
	}

	@Autowired
	private DressMeasurementsService measurementsService;

	@MockBean
	private DressMeasurementsDao measurementsDao;

	@Before
	public void setUp() {
		Mockito.when(measurementsDao.saveAll(dressMeasurements)).thenReturn(dressMeasurements);  
		Mockito.when(measurementsDao.findById(1L)).thenReturn(Optional.of(dressMeasurements.get(0)));
	}
	
	@Test
	public void whenValidId_dressMeasurementsForThatIdShouldBeFound() {
	    DressMeasurements measurements = measurementsService.getDressMeasurement(1L);
	  
	     assertThat(measurements.getNeck())
	      .isEqualTo(dressMeasurements.get(0).getNeck());
	 }
}
