package be.pxl.pets;

import be.pxl.pets.domain.Pet;
import be.pxl.pets.service.PetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
class PetmanagementApplicationTests {

	@MockBean
	@Autowired
	private PetService petService;

	@Test
	void petServiceBeanShouldLoad() {
		assertNotNull(petService);
	}

	@Test
	void shouldFetchPets() {
		when(petService.findAllPets()).thenReturn(List.of(new Pet("Luna", "Dog")));
		List<Pet> pets = petService.findAllPets();
		assertEquals(1, pets.size());
	}

	@Test
	void contextLoads() {
	}

}
