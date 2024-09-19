package net.mcreator.fuyukasutilities.procedures;

import net.minecraft.world.item.ItemStack;

import net.mcreator.fuyukasutilities.network.FuyukasUtilitiesModVariables;

public class TpSwap__TeamModeCursor1Procedure {
	public static double execute(ItemStack itemstack) {
		if (FuyukasUtilitiesModVariables.TpSwap_TeamMode) {
			if (!itemstack.getOrCreateTag().getBoolean("TpSwap_UseSecondArray")) {
				return 1;
			}
			return 0;
		}
		return 0;
	}
}
