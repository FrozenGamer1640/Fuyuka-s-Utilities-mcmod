package net.mcreator.fuyukasutilities.procedures;

import net.minecraft.world.item.ItemStack;

public class IsCurrentCustomWandRepeatActiveProcedure {
	public static double execute(ItemStack itemstack) {
		if (itemstack.getOrCreateTag().getBoolean("isRepeatActive")) {
			return 1;
		}
		return 0;
	}
}
