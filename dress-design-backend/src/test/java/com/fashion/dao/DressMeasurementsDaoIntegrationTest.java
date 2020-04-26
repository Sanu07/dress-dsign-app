package com.fashion.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.fashion.model.DressMeasurements;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DressMeasurementsDaoIntegrationTest {

	@Autowired
	private TestEntityManager testEntityManager;

	@Autowired
	private DressMeasurementsDao measurementsDao;

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

	@Test
	public void whenSaveDressMeasurements_thenReturnSavedDressMeasurementsValue() {
		// given
		DressMeasurements persistedData = (DressMeasurements) testEntityManager.persist(dressMeasurements.get(0));

		// then
		assertThat(persistedData.getNeck()).isEqualTo(dressMeasurements.get(0).getNeck());
	}

	@Test
	public void whenSaveTwoDressMeasurements_thenReturnCount_two() {
		measurementsDao.save(dressMeasurements.get(0));
		measurementsDao.save(dressMeasurements.get(1));
		List<DressMeasurements> resultList = (List<DressMeasurements>) measurementsDao.findAll();
		assertThat(resultList.size()).isEqualTo(dressMeasurements.size());
	}
}
