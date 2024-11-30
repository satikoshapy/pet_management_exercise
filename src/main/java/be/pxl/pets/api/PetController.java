package be.pxl.pets.api;

import be.pxl.pets.api.request.PetCreateRequest;
import be.pxl.pets.domain.Pet;
import be.pxl.pets.exceptions.PetNotFoundException;
import be.pxl.pets.exceptions.PetTooHungryException;
import be.pxl.pets.exceptions.PetTooTiredException;
import be.pxl.pets.exceptions.WrongFoodException;
import be.pxl.pets.service.PetService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;


    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pet createPet(@Valid @RequestBody PetCreateRequest pet) {
        return petService.createPet(pet.getName(), pet.getType());
    }

    @GetMapping
    public List<Pet> findAllPets() {
        return petService.findAllPets();
    }

    @GetMapping("/{id}")
    public Pet getPet(@PathVariable Long id) {
        return petService.findPet(id);
    }

    @PostMapping("/{id}/play")
    public Pet playWithPet(@PathVariable Long id) throws PetNotFoundException, PetTooHungryException, PetTooTiredException {
        petService.playWithPet(id);
        return petService.findPet(id);
    }


    @PostMapping("/{id}/feed")
    public Pet feedPet(
            @PathVariable Long id,
            @RequestParam String foodType) throws WrongFoodException, PetNotFoundException {
        petService.feedPet(id, foodType);
        return petService.findPet(id);
    }


    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/{petId}/allergies/{foodType}")
    public void addAllergyToPet(
            @PathVariable Long petId,
            @PathVariable String foodType) {

        petService.addAllergy(petId, foodType);

    }

    @GetMapping("/energetic")
    public List<Pet> getEnergeticPets() {
        return petService.getEnergeticPets();
    }

    @GetMapping("/hungry")
    public List<String> getHungryPets() {
        return petService.getHungryPets();
    }

    @PatchMapping("/reset")
    public void reset() {
        petService.reset();
    }
}
