package be.pxl.pets.api;

import be.pxl.pets.api.request.PetCreateRequest;
import be.pxl.pets.domain.Pet;
import be.pxl.pets.service.PetService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    // TODO implement a REST endpoint to create a new pet. You receive a requestbody of type PetCreateRequest.
    //  The name of the new pet should have at least 2 characters. The type is mandatory.

    @PostMapping
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
    public void playWithPet(@PathVariable Long id) {
        petService.playWithPet(id);
    }

    // TODO Create the endpoint
    //  POST /pets/{petId}/feed?foodType={foodType}
    //  to feed the given foodType to the pet with the given id.
    //  the foodType is required


    // TODO Create the endpoint
    //  PUT /pets/{petId}/allergies/{foodType}
    //  to add an allergy to a pet. Return accepted if the allergy is added correctly.

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
