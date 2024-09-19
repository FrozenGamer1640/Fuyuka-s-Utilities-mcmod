
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.fuyukasutilities.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.item.ItemProperties;

import net.mcreator.fuyukasutilities.procedures.TpSwap__TeamModeCursor2Procedure;
import net.mcreator.fuyukasutilities.procedures.TpSwap__TeamModeCursor1Procedure;
import net.mcreator.fuyukasutilities.procedures.IsCurrentCustomWandRepeatProcedure;
import net.mcreator.fuyukasutilities.procedures.IsCurrentCustomWandRepeatActiveProcedure;
import net.mcreator.fuyukasutilities.procedures.IsCurrentCustomWandLevitateProcedure;
import net.mcreator.fuyukasutilities.procedures.IsCurrentCustomWandImpulseProcedure;
import net.mcreator.fuyukasutilities.procedures.IsCurrentCustomWandChainedProcedure;
import net.mcreator.fuyukasutilities.item.TriviaWandItem;
import net.mcreator.fuyukasutilities.item.TpSwapWandItem;
import net.mcreator.fuyukasutilities.item.CustomWandItem;
import net.mcreator.fuyukasutilities.FuyukasUtilitiesMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class FuyukasUtilitiesModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, FuyukasUtilitiesMod.MODID);
	public static final RegistryObject<Item> TRIVIA_WAND = REGISTRY.register("trivia_wand", () -> new TriviaWandItem());
	public static final RegistryObject<Item> CUSTOM_WAND = REGISTRY.register("custom_wand", () -> new CustomWandItem());
	public static final RegistryObject<Item> TP_SWAP_WAND = REGISTRY.register("tp_swap_wand", () -> new TpSwapWandItem());

	// Start of user code block custom items
	// End of user code block custom items
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			ItemProperties.register(CUSTOM_WAND.get(), new ResourceLocation("fuyukas_utilities:custom_wand_isimpulse"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) IsCurrentCustomWandImpulseProcedure.execute(itemStackToRender));
			ItemProperties.register(CUSTOM_WAND.get(), new ResourceLocation("fuyukas_utilities:custom_wand_isrepeat"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) IsCurrentCustomWandRepeatProcedure.execute(itemStackToRender));
			ItemProperties.register(CUSTOM_WAND.get(), new ResourceLocation("fuyukas_utilities:custom_wand_ischained"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) IsCurrentCustomWandChainedProcedure.execute(itemStackToRender));
			ItemProperties.register(CUSTOM_WAND.get(), new ResourceLocation("fuyukas_utilities:custom_wand_islevitate"),
					(itemStackToRender, clientWorld, entity, itemEntityId) -> (float) IsCurrentCustomWandLevitateProcedure.execute(itemStackToRender));
			ItemProperties.register(CUSTOM_WAND.get(), new ResourceLocation("fuyukas_utilities:custom_wand_isrepeatactive"),
					(itemStackToRender, clientWorld, entity, itemEntityId) -> (float) IsCurrentCustomWandRepeatActiveProcedure.execute(itemStackToRender));
			ItemProperties.register(TP_SWAP_WAND.get(), new ResourceLocation("fuyukas_utilities:tp_swap_wand_teammodecursor1"),
					(itemStackToRender, clientWorld, entity, itemEntityId) -> (float) TpSwap__TeamModeCursor1Procedure.execute(itemStackToRender));
			ItemProperties.register(TP_SWAP_WAND.get(), new ResourceLocation("fuyukas_utilities:tp_swap_wand_teammodecursor2"),
					(itemStackToRender, clientWorld, entity, itemEntityId) -> (float) TpSwap__TeamModeCursor2Procedure.execute(itemStackToRender));
		});
	}
}
