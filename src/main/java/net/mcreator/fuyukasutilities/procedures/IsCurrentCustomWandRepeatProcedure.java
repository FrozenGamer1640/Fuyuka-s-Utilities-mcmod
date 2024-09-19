package net.mcreator.fuyukasutilities.procedures;

import net.minecraft.world.item.ItemStack;

public class IsCurrentCustomWandRepeatProcedure {
	public static double execute(ItemStack itemstack) {
		if ((itemstack.getOrCreateTag().getString("mode")).equals("repeat")) {
			if (!itemstack.getOrCreateTag().getBoolean("isRepeatActive")) {
				return 1;
			}
		}
		return 0;
	}
}
