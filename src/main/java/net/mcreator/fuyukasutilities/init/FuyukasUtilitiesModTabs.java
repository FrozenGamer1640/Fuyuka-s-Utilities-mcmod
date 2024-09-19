
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.fuyukasutilities.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.fuyukasutilities.FuyukasUtilitiesMod;

public class FuyukasUtilitiesModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FuyukasUtilitiesMod.MODID);
	public static final RegistryObject<CreativeModeTab> XTRA_TOOLS = REGISTRY.register("xtra_tools",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.fuyukas_utilities.xtra_tools")).icon(() -> new ItemStack(Items.BLAZE_ROD)).displayItems((parameters, tabData) -> {
				tabData.accept(FuyukasUtilitiesModItems.TRIVIA_WAND.get());
				tabData.accept(FuyukasUtilitiesModItems.CUSTOM_WAND.get());
				tabData.accept(FuyukasUtilitiesModItems.TP_SWAP_WAND.get());
			})

					.build());
}
