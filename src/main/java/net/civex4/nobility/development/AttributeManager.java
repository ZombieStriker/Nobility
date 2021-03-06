package net.civex4.nobility.development;

import net.civex4.nobility.estate.Estate;
import net.md_5.bungee.api.ChatColor;

public class AttributeManager {
	
	public static String getAttributeText(DevAttribute attr, Integer amt) {
		return ChatColor.BLUE + attr.name + ": " + ChatColor.WHITE + amt;
	}
	
	public static int getCityLimit(Estate e) {
		int ret = 0;
		for(Development d : e.getBuiltDevelopments()) {
			if(d.isActive) {
				if(d.attributes != null)
				if(d.attributes.containsKey(DevAttribute.CITY_RADIUS)) {
					int radius = d.attributes.get(DevAttribute.CITY_RADIUS);
					if(radius > ret) {
						ret = radius;
					}
				}
			}
		}
		return ret;
	}
	
	public static int getCannonLimit(Estate e) {
		int ret = 0;
		for(Development d : e.getBuiltDevelopments()) {
			if(d.isActive) {
				if(d.attributes != null)
				if(d.attributes.containsKey(DevAttribute.CANNON_LIMIT)) {
					int amt = d.attributes.get(DevAttribute.CANNON_LIMIT);
					if(amt > ret) {
						ret = amt;
					}
				}
			}
		}
		return ret;
	}
	
	public static int getCannons(Estate e) {
		int ret = 0;
		for(Development d : e.getBuiltDevelopments()) {
			if(d.isActive) {
				if(d.attributes != null)
				if(d.attributes.containsKey(DevAttribute.CANNON_STORED)) {
					int amt = d.attributes.get(DevAttribute.CANNON_STORED);
					if(amt > ret) {
						ret += amt;
					}
				}
			}
		}
		return ret;
	}
	
	public static void spendCannon(Estate e) {
		for(Development d : e.getBuiltDevelopments()) {
			if(d.isActive) {
				if(d.attributes != null)
				if(d.attributes.containsKey(DevAttribute.CANNON_STORED)) {
					int amt = d.attributes.get(DevAttribute.CANNON_STORED);
					if(amt > 0) {
						d.attributes.put(DevAttribute.CANNON_STORED, amt-1);
						return;
					}
				}
			}
		}
	}

	public static int getMaxHealth(Estate e) {
		int ret = 0;
		for(Development d : e.getBuiltDevelopments()) {
			if(d.isActive) {
				if(d.attributes != null)
				if(d.attributes.containsKey(DevAttribute.CITY_HEALTH)) {
					int amt = d.attributes.get(DevAttribute.CITY_HEALTH);
					if(amt > ret) {
						ret = amt;
					}
				}
			}
		}
		
		for(Development d : e.getBuiltDevelopments()) {
			if(d.isActive) {
				if(d.attributes != null)
				if(d.attributes.containsKey(DevAttribute.ADD_CITY_HEALTH)) {
					int amt = d.attributes.get(DevAttribute.ADD_CITY_HEALTH);
						ret += amt;
				}
			}
		}
		
		
		return ret;
	}

	public static void addCannon(Estate e) {
		for(Development d : e.getBuiltDevelopments()) {
			if(d.isActive) {
				if(d.attributes != null)
				if(d.attributes.containsKey(DevAttribute.CANNON_STORED)) {
					int amt = d.attributes.get(DevAttribute.CANNON_STORED);
					if(d.attributes.containsKey(DevAttribute.CANNON_LIMIT)) {
						if(d.attributes.get(DevAttribute.CANNON_LIMIT) > amt) {
							d.attributes.put(DevAttribute.CANNON_STORED, amt+1);
						}
					}

				}
			}
		}		
	}
	
	

}
