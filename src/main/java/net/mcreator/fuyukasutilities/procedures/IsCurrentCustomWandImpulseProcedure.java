package net.mcreator.fuyukasutilities.procedures;

import net.minecraft.world.item.ItemStack;

public class IsCurrentCustomWandImpulseProcedure {
	public static double execute(ItemStack itemstack) {
		if (!(itemstack.getOrCreateTag().getString("command")).contains("minecraft:levitation")) {
			if ((itemstack.getOrCreateTag().getString("mode")).equals("impulse")) {
				return 1;
			}
		}
		return 0;
	}
}
