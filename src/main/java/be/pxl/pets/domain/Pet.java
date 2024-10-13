package be.pxl.pets.domain;

public class Pet {
    private Long id;
    private final String name;
    private final String type;
    private int energy;
    private Hunger hunger;
    private boolean happy;
    // TODO create a collection to save a pet's allergies. Make sure duplicates are not allowed in the collection.

    public Pet(String name, String type) {
        this.name = name;
        this.type = type;
        this.energy = 50;
        this.hunger = Hunger.SATISFIED;
        happy = true;
    }

    private void setHunger(Hunger hunger) {
        this.hunger = hunger;
    }

    private void increaseHunger() {
        setHunger(Hunger.values()[Math.min(Hunger.values().length - 1, hunger.ordinal() + 1)]);
    }

    private void decreaseHunger() {
        setHunger(Hunger.values()[Math.max(0, hunger.ordinal() - 1)]);
    }

    public void play() {
        int energyCost = this.type.equals("cat") ? 30 : 20;
        // TODO throw a PetTooTiredException if the pet hasn't enough energy to play
        // TODO throw a PetTooHungry exception if the pet is too hungry too play (VERY_HUNGRY)
        happy = true;
        this.energy -= energyCost;
        increaseHunger();
    }

    public void feed(String foodType) {
        // TODO throw a WrongFoodException if the pet is allergic to the given foodType
        decreaseHunger();
        this.energy += 10;
    }

    public int getEnergy() {
        return energy;
    }

    public String getName() {
        return name;
    }

    public Hunger getHunger() {
        return hunger;
    }

    public boolean isHappy() {
        return happy;
    }

    // TODO add method to add an allergy
    // TODO add getter for allergies

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
