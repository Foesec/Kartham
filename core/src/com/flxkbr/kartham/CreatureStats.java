package com.flxkbr.kartham;

public class CreatureStats {
	
	public enum DamageType { PHYSICAL, UNNATURAL };
	
	private int health, damage;
	private float dread;
	private DamageType damageType;
	
	public CreatureStats(int health, float dread, int damage, DamageType damageType) {
		this.health = health; this.dread = dread; this.damage = damage;
		this.damageType = damageType;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public float getDread() {
		return dread;
	}

	public void setDread(float dread) {
		this.dread = dread;
	}

	public DamageType getDamageType() {
		return damageType;
	}

	public void setDamageType(DamageType damageType) {
		this.damageType = damageType;
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

}
