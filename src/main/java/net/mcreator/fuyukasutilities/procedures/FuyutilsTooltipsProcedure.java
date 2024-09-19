package net.mcreator.fuyukasutilities.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.Screen;

import net.mcreator.fuyukasutilities.network.FuyukasUtilitiesModVariables;
import net.mcreator.fuyukasutilities.init.FuyukasUtilitiesModItems;

import javax.annotation.Nullable;

import java.util.List;

@Mod.EventBusSubscriber
public class FuyutilsTooltipsProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onItemTooltip(ItemTooltipEvent event) {
		execute(event, event.getItemStack(), event.getToolTip());
	}

	public static void execute(ItemStack itemstack, List<Component> tooltip) {
		execute(null, itemstack, tooltip);
	}

	private static void execute(@Nullable Event event, ItemStack itemstack, List<Component> tooltip) {
		if (tooltip == null)
			return;
		String TargetsNames = "";
		double WhileBuffer = 0;
		if (itemstack.getItem() == FuyukasUtilitiesModItems.TP_SWAP_WAND.get()) {
			if (Screen.hasControlDown()) {
				tooltip.add(Component.literal("\u00A79/fuyutils wands tpswap {true/false} \u00A77Sets TeamMode"));
				tooltip.add(Component.literal("\u00A73alt + RightClick \u00A77Toggles PlayersArrays"));
				tooltip.add(Component.literal("\u00A73shift + RightClick \u00A77Confirms the tpswap"));
				tooltip.add(Component.literal("\u00A73RightClick \u00A77Selects an entity"));
			} else if (FuyukasUtilitiesModVariables.TpSwap_TeamMode) {
				tooltip.add(Component.literal("\u00A75Team Mode \u00A7denabled"));
				if (Screen.hasShiftDown()) {
					if (FuyukasUtilitiesModVariables.TpSwapTargets1.size() > 0) {
						if ((FuyukasUtilitiesModVariables.TpSwapTargets1.get(0) instanceof Entity _e ? _e : null) instanceof LivingEntity) {
							TargetsNames = (FuyukasUtilitiesModVariables.TpSwapTargets1.get(0) instanceof Entity _e ? _e : null).getDisplayName().getString();
						} else {
							TargetsNames = "[null entity]";
						}
						WhileBuffer = 1;
						while (WhileBuffer < FuyukasUtilitiesModVariables.TpSwapTargets1.size()) {
							if ((FuyukasUtilitiesModVariables.TpSwapTargets1.get((int) WhileBuffer) instanceof Entity _e ? _e : null) instanceof LivingEntity) {
								TargetsNames = TargetsNames + ", " + ((FuyukasUtilitiesModVariables.TpSwapTargets1.get((int) WhileBuffer) instanceof Entity _e ? _e : null).getDisplayName().getString());
							} else {
								TargetsNames = TargetsNames + ", [null entity]";
							}
							WhileBuffer = WhileBuffer + 1;
						}
						tooltip.add(Component.literal(((itemstack.getOrCreateTag().getBoolean("TpSwap_UseSecondArray") ? "\u00A77" : "\u00A7f") + "Targets : \u00A79" + TargetsNames)));
					} else {
						tooltip.add(Component.literal("Targets : \u00A78No targets"));
					}
					if (FuyukasUtilitiesModVariables.TpSwapTargets2.size() > 0) {
						if ((FuyukasUtilitiesModVariables.TpSwapTargets2.get(0) instanceof Entity _e ? _e : null) instanceof LivingEntity) {
							TargetsNames = (FuyukasUtilitiesModVariables.TpSwapTargets2.get(0) instanceof Entity _e ? _e : null).getDisplayName().getString();
						} else {
							TargetsNames = "[null entity]";
						}
						WhileBuffer = 1;
						while (WhileBuffer < FuyukasUtilitiesModVariables.TpSwapTargets2.size()) {
							if ((FuyukasUtilitiesModVariables.TpSwapTargets2.get((int) WhileBuffer) instanceof Entity _e ? _e : null) instanceof LivingEntity) {
								TargetsNames = TargetsNames + ", " + ((FuyukasUtilitiesModVariables.TpSwapTargets2.get((int) WhileBuffer) instanceof Entity _e ? _e : null).getDisplayName().getString());
							} else {
								TargetsNames = TargetsNames + ", [null entity]";
							}
							WhileBuffer = WhileBuffer + 1;
						}
						tooltip.add(Component.literal(((itemstack.getOrCreateTag().getBoolean("TpSwap_UseSecondArray") ? "\u00A7f" : "\u00A77") + "2\u00B0 Targets : \u00A79" + TargetsNames)));
					} else {
						tooltip.add(Component.literal("2\u00B0 Targets : \u00A78No targets"));
					}
				} else {
					tooltip.add(Component.literal(((itemstack.getOrCreateTag().getBoolean("TpSwap_UseSecondArray") ? "\u00A77" : "\u00A7f") + "Targets : "
							+ (FuyukasUtilitiesModVariables.TpSwapTargets1.size() > 0 ? "\u00A79" + new java.text.DecimalFormat("##").format(FuyukasUtilitiesModVariables.TpSwapTargets1.size()) : "\u00A78No targets"))));
					tooltip.add(Component.literal(((itemstack.getOrCreateTag().getBoolean("TpSwap_UseSecondArray") ? "\u00A7f" : "\u00A77") + "2\u00B0 Targets : "
							+ (FuyukasUtilitiesModVariables.TpSwapTargets2.size() > 0 ? "\u00A79" + new java.text.DecimalFormat("##").format(FuyukasUtilitiesModVariables.TpSwapTargets2.size()) : "\u00A78No targets"))));
				}
			} else {
				if (Screen.hasShiftDown()) {
					if (FuyukasUtilitiesModVariables.TpSwapTargets1.size() > 0) {
						TargetsNames = (FuyukasUtilitiesModVariables.TpSwapTargets1.get(0) instanceof Entity _e ? _e : null).getDisplayName().getString();
						WhileBuffer = 1;
						while (WhileBuffer < FuyukasUtilitiesModVariables.TpSwapTargets1.size()) {
							if ((FuyukasUtilitiesModVariables.TpSwapTargets1.get((int) WhileBuffer) instanceof Entity _e ? _e : null) instanceof LivingEntity) {
								TargetsNames = TargetsNames + ", " + ((FuyukasUtilitiesModVariables.TpSwapTargets1.get((int) WhileBuffer) instanceof Entity _e ? _e : null).getDisplayName().getString());
							} else {
								TargetsNames = TargetsNames + ", [null entity]";
							}
							WhileBuffer = WhileBuffer + 1;
						}
						tooltip.add(Component.literal(("Targets : \u00A79" + TargetsNames)));
					} else {
						tooltip.add(Component.literal("Targets : \u00A78No targets"));
					}
				} else {
					tooltip.add(Component
							.literal(("Targets : " + (FuyukasUtilitiesModVariables.TpSwapTargets1.size() > 0 ? "\u00A79" + new java.text.DecimalFormat("##").format(FuyukasUtilitiesModVariables.TpSwapTargets1.size()) : "\u00A78No targets"))));
				}
			}
			if (!Screen.hasControlDown()) {
				if (!Screen.hasShiftDown()) {
					if (FuyukasUtilitiesModVariables.TpSwap_TeamMode && FuyukasUtilitiesModVariables.TpSwapTargets1.size() > 0 && FuyukasUtilitiesModVariables.TpSwapTargets2.size() > 0) {
						tooltip.add(Component.literal("\u00A78 (hold shift to show names)"));
					} else if (!FuyukasUtilitiesModVariables.TpSwap_TeamMode && FuyukasUtilitiesModVariables.TpSwapTargets1.size() > 0) {
						tooltip.add(Component.literal("\u00A78 (hold shift to show names)"));
					}
				}
				tooltip.add(Component.literal("\u00A78 [ hold ctrl to see the controls ]"));
			}
		}
		if (itemstack.getItem() == FuyukasUtilitiesModItems.CUSTOM_WAND.get()) {
			if (Screen.hasControlDown()) {
				tooltip.add(Component.literal("\u00A75Note: \u00A7dThis does not check if the commands are valid"));
				tooltip.add(Component.literal("\u00A79/fuyutils wands impulse `command` \u00A77sets/gives a custom wand on Impulse mode with the specified command"));
				tooltip.add(Component.literal("\u00A79/fuyutils wands repeat `command` \u00A7fsets/give a custom wand on repeat mode with the specified command"));
				tooltip.add(Component.literal("\u00A71[Chained only] \u00A79/fuyutils wands chained add `command` \u00A77adds the specified command to an empty/chained custom wand"));
				tooltip.add(Component.literal("\u00A71[Chained only] \u00A79/fuyutils wands chained edit {index} `command` \u00A7freplaces the command at the specified index with the specified command \u00A78(starts from 0)"));
				tooltip.add(Component.literal("\u00A71[Chained only] \u00A79/fuyutils wands chained remove {index} \u00A77removes the command at the specified index \u00A78(starts from 0)"));
				tooltip.add(Component.literal("\u00A73RightClick\u00A79(Impulse) \u00A77executes the stored command once"));
				tooltip.add(Component.literal("\u00A73RightClick\u00A79(repeat) \u00A77executes the stored command repeatedly until another RightClick"));
				tooltip.add(Component.literal("\u00A73RightClick\u00A79(chained) \u00A77executes all the stored commands \u00A78(without an specific order)"));
			} else if ((itemstack.getOrCreateTag().getString("mode")).equals("chained")) {
				tooltip.add(Component.literal("\u00A77Mode : \u00A7bChained \u00A79"));
				{
					String[] _array = (itemstack.getOrCreateTag().getString("command")).split(",,");
					if (_array.length != 0) {
						for (String stringiterator : _array) {
							tooltip.add(Component.literal(("\u00A79/" + stringiterator)));
						}
					} else {
						String stringiterator = (itemstack.getOrCreateTag().getString("command"));
						for (int _yourmother = 0; _yourmother < 1; _yourmother++) {
							tooltip.add(Component.literal(("\u00A79/" + stringiterator)));
						}
					}
				}
			} else if ((itemstack.getOrCreateTag().getString("mode")).equals("impulse")) {
				if ((itemstack.getOrCreateTag().getString("command")).contains("effect give") && (itemstack.getOrCreateTag().getString("command")).contains("levitation")) {
					tooltip.add(Component.literal("\u00A77Mode : \u00A76Impulse \u00A78(levitation) \u00A79"));
				} else {
					tooltip.add(Component.literal("\u00A77Mode : \u00A76Impulse \u00A79"));
				}
				tooltip.add(Component.literal(("\u00A79/" + itemstack.getOrCreateTag().getString("command"))));
			} else if ((itemstack.getOrCreateTag().getString("mode")).equals("repeat")) {
				tooltip.add(Component.literal("\u00A77Mode : \u00A7dRepeat"));
				tooltip.add(Component.literal(("\u00A79/" + itemstack.getOrCreateTag().getString("command"))));
			}
			if (!Screen.hasControlDown()) {
				tooltip.add(Component.literal("\u00A78 [ hold ctrl to see the controls ]"));
			}
		}
		if (itemstack.getItem() == FuyukasUtilitiesModItems.TRIVIA_WAND.get()) {
			if (Screen.hasControlDown()) {
				tooltip.add(Component.literal("\u00A79/fuyutils wands trivia setpos \u00A77Sets trivia position to your X-Y-Z cords"));
				tooltip.add(Component.literal("\u00A73shift + RightClick \u00A77Forces Trivia Start"));
				tooltip.add(Component.literal("\u00A73shift + alt + RightClick \u00A77Forces Trivia End"));
				tooltip.add(Component.literal("\u00A73RightClick \u00A77Toggles Trivia"));
			} else {
				tooltip.add(Component.literal("\u00A78 [ hold ctrl to see the controls ]"));
			}
		}
	}
}
