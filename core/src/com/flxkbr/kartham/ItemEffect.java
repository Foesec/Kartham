package com.flxkbr.kartham;

import com.flxkbr.kartham.Item.ItemDuration;

public class ItemEffect implements IEffect {
	
	private int health, sanity, cpower, mhealth, msanity, power;
	private ItemDuration duration = ItemDuration.ONCE;
	
	public ItemEffect(int health, int sanity, int cpower, int mhealth, int msanity, int power, ItemDuration duration) {
		this.health = health;
		this.sanity = sanity;
		this.cpower = cpower;
		this.mhealth = mhealth;
		this.msanity = msanity;
		this.power = power;
		this.duration = duration;
	}
	
	public ItemDuration getItemDuration() {
		return duration;
	}

	@Override
	public void affectPlayer(Player player) {
		player.setHealth(player.getHealth()+health);
		player.setSanity(player.getSanity()+sanity);
		player.setCurrentPower(player.getCurrentPower() + cpower);
		player.setMaxhealth (player.getMaxhealth() + mhealth);
		player.setMaxsanity (player.getMaxsanity() + msanity);
		player.setPower 	(player.getPower() +power);
		
	}

	@Override
	public void unaffectPlayer(Player player) {
		player.setHealth(player.getHealth()-health);
		player.setSanity(player.getSanity()-sanity);
		player.setCurrentPower(player.getCurrentPower() - cpower);
		player.setMaxhealth (player.getMaxhealth() - mhealth);
		player.setMaxsanity (player.getMaxsanity() - msanity);
		player.setPower 	(player.getPower() - power);
		
	}
	
	public String toString() {
		return "" + health + " " + sanity + " " + power;
	}
	
	

}
