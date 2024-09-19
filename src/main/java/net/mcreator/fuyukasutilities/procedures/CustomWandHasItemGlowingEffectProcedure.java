package net.mcreator.fuyukasutilities.procedures;

import net.minecraft.world.item.ItemStack;

public class CustomWandHasItemGlowingEffectProcedure {
	public static boolean execute(ItemStack itemstack) {
		if ((itemstack.getOrCreateTag().getString("mode")).equals("impulse") || (itemstack.getOrCreateTag().getString("mode")).equals("repeat") || (itemstack.getOrCreateTag().getString("mode")).equals("chained")) {
			return true;
		}
		return false;
	}
}
