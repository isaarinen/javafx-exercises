package controller;

import model.Pet;

public class PetController {
    private Pet pet;

    public PetController(Pet pet) {
        this.pet = pet;
    }

    public void movePetTowards(double targetX, double targetY, double speed) {
        double dx = targetX - pet.getX();
        double dy = targetY - pet.getY();
        double distance = Math.sqrt(dx * dx + dy * dy);

        if (distance < speed) {
            pet.setPosition(targetX, targetY);
        } else if (distance > 0) {
            double nx = pet.getX() + speed * dx / distance;
            double ny = pet.getY() + speed * dy / distance;
            pet.setPosition(nx, ny);
        }
    }
}