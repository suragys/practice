package com.redBadger;

import java.util.concurrent.atomic.AtomicInteger;

public class Robot {

    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id;
    private Position position;
    private String instruction;
    private boolean isLost;

    public Robot(int x, int y, char orientation, String instructions) {
        this.id = count.incrementAndGet();
        this.position = new Position(x, y, orientation);
        this.instruction = instructions;
        this.isLost = false;
    }

    public Robot(Position p, String instructions) {
        this.id = count.incrementAndGet();
        this.position = p;
        this.instruction = instructions;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public boolean isLost() {
        return isLost;
    }

    public void setLost(boolean lost) {
        isLost = lost;
    }

    public int getId() {
        return id;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "id=" + id +
                ", position=" + position +
                ", instruction='" + instruction + '\'' +
                ", isLost=" + isLost +
                '}';
    }
}
