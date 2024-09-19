
package net.mcreator.fuyukasutilities.item;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

import net.mcreator.fuyukasutilities.procedures.CustomWandRightclickedProcedure;
import net.mcreator.fuyukasutilities.procedures.CustomWandItemInInventoryTickProcedure;
import net.mcreator.fuyukasutilities.procedures.CustomWandHasItemGlowingEffectProcedure;

public class CustomWandItem extends Item {
	public CustomWandItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return CustomWandHasItemGlowingEffectProcedure.execute(itemstack);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		CustomWandRightclickedProcedure.execute(world, entity, ar.getObject());
		return ar;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		CustomWandItemInInventoryTickProcedure.execute(world, entity, itemstack);
	}
}
