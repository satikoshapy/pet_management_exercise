package be.pxl.pets.service;

import be.pxl.pets.domain.Hunger;
import be.pxl.pets.domain.Pet;
import be.pxl.pets.exceptions.PetNotFoundException;
import be.pxl.pets.exceptions.PetTooHungryException;
import be.pxl.pets.exceptions.PetTooTiredException;
import be.pxl.pets.exceptions.WrongFoodException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public void playWithPet(Long petId) throws PetNotFoundException, PetTooTiredException, PetTooHungryException {
        Pet pet = findPet(petId);
        if (pet == null) {
            throw new PetNotFoundException();
        }
        pet.play();

    }

    public void feedPet(Long petId, String foodType) throws PetNotFoundException, WrongFoodException {
        Pet pet = findPet(petId);
        if (pet == null) {
            throw new PetNotFoundException();
        }
        pet.feed(foodType);

    }

    public List<Pet> getEnergeticPets() {

        return pets.entrySet().stream()
                .peek(entry -> entry.getValue().setId(entry.getKey())) .map(Map.Entry::getValue)
                .filter(pet -> pet.getEnergy() >= 50).collect(Collectors.toList());
    }

    public List<String> getHungryPets() {

        return pets.values().stream().filter(pet -> pet.getHunger() != Hunger.SATISFIED)
                .map(Pet::getName).collect(Collectors.toList());
    }

    public void addAllergy(Long petId, String allergy) {
        Pet pet = findPet(petId);
        if (pet == null) {
            throw new PetNotFoundException();
        }
        pet.getFoodAllergies().add(allergy);

    }

    public List<Pet> findAllPets() {

        return pets.entrySet().stream()
                .peek(entry -> entry.getValue().setId(entry.getKey()))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public void reset() {
        pets = new HashMap<>();
        currentId = 1L;
    }


}
