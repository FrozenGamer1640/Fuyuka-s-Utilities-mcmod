package net.mcreator.fuyukasutilities.procedures;

import net.minecraft.world.item.ItemStack;

public class IsCurrentCustomWandChainedProcedure {
	public static double execute(ItemStack itemstack) {
		if ((itemstack.getOrCreateTag().getString("mode")).equals("chained")) {
			return 1;
		}
		return 0;
	}
}
