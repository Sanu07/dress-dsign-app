package com.fashion.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fashion.auth.JWTTokenAuthorizationOncePerRequestFilter;
import com.fashion.auth.JWTUnAuthorizedResponseAuthenticationEntryPoint;
import com.fashion.model.DressMeasurements;
import com.fashion.service.DressMeasurementsService;
import com.fashion.service.impl.JWTDBUserDetailsServiceImpl;
import com.fashion.util.JWTTokenUtil;

@RunWith(SpringRunner.class)
@WebMvcTest(DressMeasurementsController.class)
public class DressMeasurementsControllerIntegrationTest {

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

	@Autowired
	MockMvc mvc;

	@MockBean
	private DressMeasurementsService measurementsService;

	@TestConfiguration
	static class DressMeasurementsControllerTestContextConfiguration {

		@Bean
		public JWTTokenUtil token() {
			return Mockito.mock(JWTTokenUtil.class);
		}
		
		@Bean
		public UserDetailsService userDetailsService() {
			return Mockito.mock(UserDetailsService.class);
		}
		
		@Bean
		public JWTUnAuthorizedResponseAuthenticationEntryPoint entryPoint() {
			return Mockito.mock(JWTUnAuthorizedResponseAuthenticationEntryPoint.class);
		}
	}

	@Test
	public void givenMeasurements_whenGetAllMeasurements_thenReturnAllMeasurements() throws Exception {
		List<DressMeasurements> dressMeasurements = new ArrayList<>();
		DressMeasurements countOne = new DressMeasurements();
		countOne.setNeck("Neck-1");
		countOne.setArmLength("10");
		DressMeasurements countTwo = new DressMeasurements();
		countTwo.setNeck("Neck-2");
		countTwo.setArmLength("20");
		dressMeasurements.add(countOne);
		dressMeasurements.add(countTwo);
		given(measurementsService.getAllDressMeasurements()).willReturn(dressMeasurements);

		mvc.perform(get("/measurements").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].neck", is(dressMeasurements.get(0).getNeck())));
	}
}
