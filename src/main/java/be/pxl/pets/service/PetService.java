package be.pxl.pets.service;

import be.pxl.pets.domain.Pet;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PetService {

    private Map<Long, Pet> pets = new HashMap<>();
    private Long currentId = 1L;

    // Create a new pet
    public Pet createPet(String name, String type) {
        Pet pet = new Pet(name, type);
        pet.setId(currentId++);
        pets.put(pet.getId(), pet);
        return pet;
    }

    public Pet findPet(Long id) {
        return pets.get(id);
    }

    public void playWithPet(Long petId)  {
        Pet pet = findPet(petId);
        // TODO throw PetNotFoundException if pet not found
        //  call pet.play
    }

    public void feedPet(Long petId, String foodType) {
        Pet pet = findPet(petId);
        // TODO throw PetNotFoundException if pet not found
        //  call pet.feed
    }

    public List<Pet> getEnergeticPets() {
        // TODO return all the pets having energy 50 or more. Use the Java streaming API and lambda expressions.
        return null;
    }

    public List<String> getHungryPets() {
        // TODO return a list with the names of the hungry pets (BIT_HUNGRY AND VERY_HUNGRY)
        return null;
    }

    public void addAllergy(Long petId, String allergy) {
        Pet pet = findPet(petId);
        // TODO throw PetNotFoundException if pet not found
        //  add the allergy to the pet's allergies
    }

    public List<Pet> findAllPets() {
        // TODO return all the pets
        return null;
    }

    public void reset() {
        pets = new HashMap<>();
        currentId = 1L;
    }
}
