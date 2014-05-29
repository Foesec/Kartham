package com.flxkbr.kartham;

public class Weapon {

	enum WeaponType { MELEE, RANGED; }
	enum WeaponSpeed { FAST, SLOW; }
	
	private String name;
	private int power;
	private WeaponType type;
	private WeaponSpeed speed;
	
	public Weapon(String name, String type, String speed, int power) {
		this.name = name;
		this.power = power;
		this.type = (type.equalsIgnoreCase("melee")) ? WeaponType.MELEE : WeaponType.RANGED;
		this.speed = (speed.equalsIgnoreCase("fast")) ? WeaponSpeed.FAST : WeaponSpeed.SLOW;
	}
	
	public Weapon(String name, int power) {
		this(name, "melee", "slow", power);
	}
}
