package com.a101nechasim.tomer.model.entity;

/**
 * Created by Adir on 2/19/2018.
 */

public class House {
    protected long id ;
    protected int rooms=1;
    protected int floors=0;
    protected int currentFloor=1;
    protected int areaMeters;
    protected boolean elevator;
    protected boolean garden;
    protected boolean sucaGarden;
    protected boolean privateHouse;
    protected String address;




    public House(House other) {
        this.id = other.id;
        this.rooms = other.rooms;
        this.floors = other.floors;
        this.currentFloor = other.currentFloor;
        this.areaMeters = other.areaMeters;
        this.elevator = other.elevator;
        this.garden = other.garden;
        this.sucaGarden = other.sucaGarden;
        this.privateHouse = other.privateHouse;
        this.address = other.address;
    }

    public House(int rooms, int floors, int currentFloor, int areaMeters, boolean elevator, boolean garden, boolean sucaGarden, boolean privateHouse, String address) {
        this.rooms = rooms;
        this.floors = floors;
        this.currentFloor = currentFloor;
        this.areaMeters = areaMeters;
        this.elevator = elevator;
        this.garden = garden;
        this.sucaGarden = sucaGarden;
        this.privateHouse = privateHouse;
        this.address = address;
    }

    public House() {

    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getAreaMeters() {
        return areaMeters;
    }

    public void setAreaMeters(int areaMeters) {
        this.areaMeters = areaMeters;
    }

    public boolean containsElevator() {
        return elevator;
    }

    public void setElevator(boolean elevator) {
        this.elevator = elevator;
    }

    public boolean containsGarden() {
        return garden;
    }

    public void setGarden(boolean garden) {
        this.garden = garden;
    }

    public boolean containsSucaGarden() {
        return sucaGarden;
    }

    public void setSucaGarden(boolean sucaGarden) {
        this.sucaGarden = sucaGarden;
    }

    public boolean isPrivateHouse() {
        return privateHouse;
    }

    public void setPrivateHouse(boolean privateHouse) {
        this.privateHouse = privateHouse;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }
}
