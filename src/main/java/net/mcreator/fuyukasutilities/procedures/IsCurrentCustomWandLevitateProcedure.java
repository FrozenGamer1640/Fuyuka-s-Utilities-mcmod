package net.mcreator.fuyukasutilities.procedures;

import net.minecraft.world.item.ItemStack;

public class IsCurrentCustomWandLevitateProcedure {
	public static double execute(ItemStack itemstack) {
		if ((itemstack.getOrCreateTag().getString("command")).contains("effect give") && (itemstack.getOrCreateTag().getString("command")).contains("levitation")) {
			return 1;
		}
		return 0;
	}
}
