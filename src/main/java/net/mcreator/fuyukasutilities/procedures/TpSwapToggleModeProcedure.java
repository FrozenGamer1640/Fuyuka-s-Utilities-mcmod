package net.mcreator.fuyukasutilities.procedures;

import net.minecraft.commands.CommandSourceStack;

import net.mcreator.fuyukasutilities.network.FuyukasUtilitiesModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class TpSwapToggleModeProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		FuyukasUtilitiesModVariables.TpSwapTargets1.clear();
		FuyukasUtilitiesModVariables.TpSwapTargets2.clear();
		if (BoolArgumentType.getBool(arguments, "teamMode")) {
			FuyukasUtilitiesModVariables.TpSwap_TeamMode = true;
		} else {
			FuyukasUtilitiesModVariables.TpSwap_TeamMode = false;
		}
	}
}
