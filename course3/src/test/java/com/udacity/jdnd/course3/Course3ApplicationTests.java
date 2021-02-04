package com.udacity.jdnd.course3;

import com.udacity.jdnd.course3.Entity.Delivery;
import com.udacity.jdnd.course3.Entity.Plant;
import com.udacity.jdnd.course3.Repository.PlantRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@DataJpaTest
class Course3ApplicationTests {

	@Autowired
	PlantRepository plantRepository;

	@Autowired
	TestEntityManager testEntityManager;

//	@Test
//	void contextLoads() {
//	}

	@Test
	void testPriceLessThan(){
		Plant plant1 = testEntityManager.persist(new Plant("Plant A", BigDecimal.valueOf(10)));
		Plant plant2 = testEntityManager.persist(new Plant("Plant B", BigDecimal.valueOf(20)));

		List<Plant> plantLessThan15Bucks = plantRepository.findByPriceLessThan(BigDecimal.valueOf(15));
		Assertions.assertEquals(1, plantLessThan15Bucks.size(), "Size");
		Assertions.assertEquals(plant1.getId(), plantLessThan15Bucks.get(0).getId(), "Plant Less Than 15 bucks");
	}

	@Test
	void testDeliveryCompleted(){
		Plant plant1 = testEntityManager.persist(
				new Plant("Plant A", BigDecimal.valueOf(10))
		);
		Delivery delivery1 = testEntityManager.persist(
				new Delivery("Delivery A", "Address A", LocalDate.now())
		);

		delivery1.setPlants(Lists.newArrayList(plant1));
		plant1.setDelivery(delivery1);

		Assertions.assertEquals(false, plantRepository.deliveryCompleted(plant1.getId()));
		delivery1.setCompleted(true);
		Assertions.assertEquals(true, plantRepository.deliveryCompleted(plant1.getId()));
	}

}
