package com.flxkbr.kartham;

public class Player {

	private int health, maxhealth;
	private int sanity, maxsanity;
	private int currentPower, power;
	private String name;
	private Weapon weapon;
	
	public Player() {
		name = "Jim Morrington";
		maxhealth = health = 10;
		maxsanity = sanity = 10;
		power = currentPower = 4;
		weapon = new Weapon("Pistol", "ranged", "slow", 3);
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMaxhealth() {
		return maxhealth;
	}

	public void setMaxhealth(int maxhealth) {
		this.maxhealth = maxhealth;
	}

	public int getSanity() {
		return sanity;
	}

	public void setSanity(int sanity) {
		this.sanity = sanity;
	}

	public int getMaxsanity() {
		return maxsanity;
	}

	public void setMaxsanity(int maxsanity) {
		this.maxsanity = maxsanity;
	}

	public int getCurrentPower() {
		return currentPower;
	}

	public void setCurrentPower(int currentPower) {
		this.currentPower = currentPower;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
}
