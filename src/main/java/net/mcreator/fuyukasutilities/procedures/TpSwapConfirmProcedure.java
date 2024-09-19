package net.mcreator.fuyukasutilities.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.fuyukasutilities.network.FuyukasUtilitiesModVariables;
import net.mcreator.fuyukasutilities.FuyukasUtilitiesMod;

import java.util.List;
import java.util.ArrayList;

public class TpSwapConfirmProcedure {
	public static void execute(LevelAccessor world) {
		double numIterator = 0;
		double numIterator2 = 0;
		List<Object> tempCordsArray = new ArrayList<>();
		Entity entityBuffer1 = null;
		Entity entityBuffer2 = null;
		CleanNullEntitiesFromTargetArraysProcedure.execute();
		if (FuyukasUtilitiesModVariables.TpSwap_TeamMode) {
			if (FuyukasUtilitiesModVariables.TpSwapTargets1.size() >= 1 && FuyukasUtilitiesModVariables.TpSwapTargets2.size() >= 1) {
				if (FuyukasUtilitiesModVariables.TpSwapTargets1.size() == FuyukasUtilitiesModVariables.TpSwapTargets2.size()) {
					numIterator = 0;
					while (numIterator < FuyukasUtilitiesModVariables.TpSwapTargets1.size()) {
						if ((FuyukasUtilitiesModVariables.TpSwapTargets1.get((int) numIterator) instanceof Entity _e ? _e : null) instanceof LivingEntity
								&& (FuyukasUtilitiesModVariables.TpSwapTargets2.get((int) numIterator) instanceof Entity _e ? _e : null) instanceof LivingEntity) {
							entityBuffer1 = FuyukasUtilitiesModVariables.TpSwapTargets1.get((int) numIterator) instanceof Entity _e ? _e : null;
							entityBuffer2 = FuyukasUtilitiesModVariables.TpSwapTargets2.get((int) numIterator) instanceof Entity _e ? _e : null;
							tempCordsArray.clear();
							tempCordsArray.add((entityBuffer1.getX()));
							tempCordsArray.add((entityBuffer1.getY()));
							tempCordsArray.add((entityBuffer1.getZ()));
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3((entityBuffer2.getX()), (entityBuffer2.getY()), (entityBuffer2.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
												.withSuppressedOutput(),
										("tp " + entityBuffer1.getStringUUID() + " ~ ~ ~"));
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands()
										.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL,
												new Vec3((tempCordsArray.get(0) instanceof Double _d ? _d : 0), (tempCordsArray.get(1) instanceof Double _d ? _d : 0), (tempCordsArray.get(2) instanceof Double _d ? _d : 0)), Vec2.ZERO, _level, 4, "",
												Component.literal(""), _level.getServer(), null).withSuppressedOutput(), ("tp " + entityBuffer2.getStringUUID() + " ~ ~ ~"));
						} else {
							FuyukasUtilitiesMod.LOGGER.info("UNEXPECTED CASE [tpswapconfirm-while1]");
						}
						numIterator = numIterator + 1;
					}
				} else if (FuyukasUtilitiesModVariables.TpSwapTargets1.size() > FuyukasUtilitiesModVariables.TpSwapTargets2.size()) {
					numIterator = 0;
					numIterator2 = 0;
					while (numIterator < FuyukasUtilitiesModVariables.TpSwapTargets1.size()) {
						if ((FuyukasUtilitiesModVariables.TpSwapTargets1.get((int) numIterator) instanceof Entity _e ? _e : null) instanceof LivingEntity
								&& (FuyukasUtilitiesModVariables.TpSwapTargets2.get((int) numIterator2) instanceof Entity _e ? _e : null) instanceof LivingEntity) {
							entityBuffer1 = FuyukasUtilitiesModVariables.TpSwapTargets1.get((int) numIterator) instanceof Entity _e ? _e : null;
							entityBuffer2 = FuyukasUtilitiesModVariables.TpSwapTargets2.get((int) numIterator2) instanceof Entity _e ? _e : null;
							tempCordsArray.clear();
							tempCordsArray.add((entityBuffer2.getX()));
							tempCordsArray.add((entityBuffer2.getY()));
							tempCordsArray.add((entityBuffer2.getZ()));
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3((entityBuffer2.getX()), (entityBuffer2.getY()), (entityBuffer2.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
												.withSuppressedOutput(),
										("tp " + entityBuffer1.getStringUUID() + " ~ ~ ~"));
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands()
										.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL,
												new Vec3((tempCordsArray.get(0) instanceof Double _d ? _d : 0), (tempCordsArray.get(1) instanceof Double _d ? _d : 0), (tempCordsArray.get(2) instanceof Double _d ? _d : 0)), Vec2.ZERO, _level, 4, "",
												Component.literal(""), _level.getServer(), null).withSuppressedOutput(), ("tp " + entityBuffer2.getStringUUID() + " ~ ~ ~"));
							if (numIterator2 + 1 == FuyukasUtilitiesModVariables.TpSwapTargets2.size()) {
								numIterator2 = 0;
							} else {
								numIterator2 = numIterator2 + 1;
							}
							numIterator = numIterator + 1;
						} else {
							FuyukasUtilitiesMod.LOGGER.info("UNEXPECTED CASE [tpswapconfirm-while2]");
						}
					}
				} else if (FuyukasUtilitiesModVariables.TpSwapTargets1.size() < FuyukasUtilitiesModVariables.TpSwapTargets2.size()) {
					numIterator = 0;
					numIterator2 = 0;
					while (numIterator2 < FuyukasUtilitiesModVariables.TpSwapTargets1.size()) {
						if ((FuyukasUtilitiesModVariables.TpSwapTargets1.get((int) numIterator) instanceof Entity _e ? _e : null) instanceof LivingEntity
								&& (FuyukasUtilitiesModVariables.TpSwapTargets2.get((int) numIterator2) instanceof Entity _e ? _e : null) instanceof LivingEntity) {
							entityBuffer1 = FuyukasUtilitiesModVariables.TpSwapTargets1.get((int) numIterator) instanceof Entity _e ? _e : null;
							entityBuffer2 = FuyukasUtilitiesModVariables.TpSwapTargets2.get((int) numIterator2) instanceof Entity _e ? _e : null;
							tempCordsArray.clear();
							tempCordsArray.add((entityBuffer1.getX()));
							tempCordsArray.add((entityBuffer1.getY()));
							tempCordsArray.add((entityBuffer1.getZ()));
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3((entityBuffer2.getX()), (entityBuffer2.getY()), (entityBuffer2.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
												.withSuppressedOutput(),
										("tp " + entityBuffer1.getStringUUID() + " ~ ~ ~"));
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands()
										.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL,
												new Vec3((tempCordsArray.get(0) instanceof Double _d ? _d : 0), (tempCordsArray.get(1) instanceof Double _d ? _d : 0), (tempCordsArray.get(2) instanceof Double _d ? _d : 0)), Vec2.ZERO, _level, 4, "",
												Component.literal(""), _level.getServer(), null).withSuppressedOutput(), ("tp " + entityBuffer2.getStringUUID() + " ~ ~ ~"));
							if (numIterator + 1 == FuyukasUtilitiesModVariables.TpSwapTargets1.size()) {
								numIterator = 0;
							} else {
								numIterator = numIterator2 + 1;
							}
							numIterator2 = numIterator + 1;
						} else {
							FuyukasUtilitiesMod.LOGGER.info("UNEXPECTED CASE [tpswapconfirm-while2]");
						}
					}
				}
			} else {
				FuyukasUtilitiesMod.LOGGER.info("Not enought targets on one or both TargetArrays");
			}
		} else {
			if (FuyukasUtilitiesModVariables.TpSwapTargets1.size() == 2) {
				if ((FuyukasUtilitiesModVariables.TpSwapTargets1.get(0) instanceof Entity _e ? _e : null) instanceof LivingEntity && (FuyukasUtilitiesModVariables.TpSwapTargets1.get(1) instanceof Entity _e ? _e : null) instanceof LivingEntity) {
					entityBuffer1 = FuyukasUtilitiesModVariables.TpSwapTargets1.get(0) instanceof Entity _e ? _e : null;
					entityBuffer2 = FuyukasUtilitiesModVariables.TpSwapTargets1.get(1) instanceof Entity _e ? _e : null;
					tempCordsArray.clear();
					tempCordsArray.add((entityBuffer1.getX()));
					tempCordsArray.add((entityBuffer1.getY()));
					tempCordsArray.add((entityBuffer1.getZ()));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3((entityBuffer2.getX()), (entityBuffer2.getY()), (entityBuffer2.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
										.withSuppressedOutput(),
								("tp " + entityBuffer1.getStringUUID() + " ~ ~ ~"));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL,
										new Vec3((tempCordsArray.get(0) instanceof Double _d ? _d : 0), (tempCordsArray.get(1) instanceof Double _d ? _d : 0), (tempCordsArray.get(2) instanceof Double _d ? _d : 0)), Vec2.ZERO, _level, 4, "",
										Component.literal(""), _level.getServer(), null).withSuppressedOutput(), ("tp " + entityBuffer2.getStringUUID() + " ~ ~ ~"));
				} else {
					FuyukasUtilitiesMod.LOGGER.info("UNEXPECTED CASE [tpswapconfirm-notteammode]");
				}
			} else {
				FuyukasUtilitiesMod.LOGGER.info("Not enought targets");
			}
		}
	}
}
