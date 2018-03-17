package com.a101nechasim.tomer.model.entity;

/**
 * Created by Adir on 2/20/2018.
 */

public class Buyer extends Customer {


    protected int minRooms=1,maxRooms=10;
    protected int currentFloor=1;
    protected int minAreaMeters;
    protected long id;
    protected long minValue=5000000,maxValue=3000000;
    protected boolean elevatorNecessary;
    protected boolean garden;
    protected boolean sukaGarden;
    protected boolean privateHouseNecessary;

    public Buyer(Buyer other) {
        this.minRooms = other.minRooms;
        this.maxRooms = other.maxRooms;
        this.minAreaMeters = other.minAreaMeters;
        this.minValue = other.minValue;
        this.maxValue = other.maxValue;
        this.elevatorNecessary = other.elevatorNecessary;
        this.garden = other.garden;
        this.sukaGarden = other.sukaGarden;
        this.privateHouseNecessary = other.privateHouseNecessary;
    }

    public Buyer(String name, String cellphone, String email, int minRooms, int maxRooms, int minAreaMeters, long minValue, long maxValue, boolean elevatorNecessary, boolean garden, boolean sukaGarden, boolean privateHouseNecessary) {
        super(name, cellphone, email);
        this.minRooms = minRooms;
        this.maxRooms = maxRooms;
        this.minAreaMeters = minAreaMeters;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.elevatorNecessary = elevatorNecessary;
        this.garden = garden;
        this.sukaGarden = sukaGarden;

        this.privateHouseNecessary = privateHouseNecessary;
    }

    public Buyer() {
    }

    public int getMinRooms() {
        return minRooms;
    }
    public void setMinRooms(int minRooms) {
        this.minRooms = minRooms;
    }

    public int getMaxRooms() {
        return maxRooms;
    }
    public void setMaxRooms(int maxRooms) {
        this.maxRooms = maxRooms;
    }

    public int getMinAreaMeters() {
        return minAreaMeters;
    }
    public void setMinAreaMeters(int minAreaMeters) {
        this.minAreaMeters = minAreaMeters;
    }

    public long getMinValue() {
        return minValue;
    }
    public void setMinValue(long minValue) {
        this.minValue = minValue;
    }

    public long getMaxValue() {
        return maxValue;
    }
    public void setMaxValue(long maxValue) {
        this.maxValue = maxValue;
    }

    public boolean isElevatorNecessary() {
        return elevatorNecessary;
    }
    public void setElevatorNecessary(boolean elevatorNecessary) {
        this.elevatorNecessary = elevatorNecessary;
    }

    public boolean isGarden() {
        return garden;
    }
    public void setGarden(boolean garden) {
        this.garden = garden;
    }

    public boolean isSukaGarden() {
        return sukaGarden;
    }
    public void setSukaGarden(boolean sukaGarden) {
        this.sukaGarden = sukaGarden;
    }

    public boolean isPrivateHouseNecessary() {
        return privateHouseNecessary;
    }
    public void setPrivateHouseNecessary(boolean privateHouseNecessary) {
        this.privateHouseNecessary = privateHouseNecessary;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }
    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

}
