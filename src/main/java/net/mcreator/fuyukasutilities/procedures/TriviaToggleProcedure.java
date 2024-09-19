package net.mcreator.fuyukasutilities.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.gui.screens.Screen;

import net.mcreator.fuyukasutilities.network.FuyukasUtilitiesModVariables;
import net.mcreator.fuyukasutilities.FuyukasUtilitiesMod;

public class TriviaToggleProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!(FuyukasUtilitiesModVariables.MapVariables.get(world).triviaPos).equals("null")) {
			if (Screen.hasAltDown() && Screen.hasShiftDown()) {
				if (world instanceof ServerLevel _server) {
					for (Entity entityiterator : _server.getAllEntities()) {
						if (entityiterator instanceof Player && entityiterator.getPersistentData().getBoolean("isInTrivia")) {
							{
								Entity _ent = entityiterator;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
													_ent.getDisplayName(), _ent.level().getServer(), _ent),
											("execute in " + entityiterator.getPersistentData().getString("triviaPrevDim") + " run tp @s " + entityiterator.getPersistentData().getString("triviaPrevPos")));
								}
							}
							entityiterator.getPersistentData().putBoolean("isInTrivia", false);
						}
					}
				}
				FuyukasUtilitiesMod.LOGGER.info(("Forced Trivia End issued by" + entity.getDisplayName().getString()));
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tellraw @s {\"text\":\"[Trivia Wand] Forced trivia end\",\"color\":\"#7B6DC7\"}");
					}
				}
			} else if (Screen.hasShiftDown()) {
				if (world instanceof ServerLevel _server) {
					for (Entity entityiterator : _server.getAllEntities()) {
						if (entityiterator instanceof Player && !entityiterator.getPersistentData().getBoolean("isInTrivia")) {
							entityiterator.getPersistentData().putString("triviaPrevPos", (entityiterator.getX() + " " + entityiterator.getY() + " " + entityiterator.getZ()));
							entityiterator.getPersistentData().putString("triviaPrevDim", entityiterator.level().dimension().location().toString());
							{
								Entity _ent = entityiterator;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
													_ent.getDisplayName(), _ent.level().getServer(), _ent),
											("execute in " + FuyukasUtilitiesModVariables.MapVariables.get(world).triviaDim + " run tp @s " + FuyukasUtilitiesModVariables.MapVariables.get(world).triviaPos));
								}
							}
							entityiterator.getPersistentData().putBoolean("isInTrivia", true);
						}
					}
				}
				FuyukasUtilitiesMod.LOGGER.info(("Forced Trivia Start issued by" + entity.getDisplayName().getString()));
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tellraw @s {\"text\":\"[Trivia Wand] Forced trivia start\",\"color\":\"#7B6DC7\"}");
					}
				}
			} else {
				if (FuyukasUtilitiesModVariables.MapVariables.get(world).isTriviaActive == false) {
					if (world instanceof ServerLevel _server) {
						for (Entity entityiterator : _server.getAllEntities()) {
							if (entityiterator instanceof Player && !entityiterator.getPersistentData().getBoolean("isInTrivia")) {
								entityiterator.getPersistentData().putString("triviaPrevPos", (entityiterator.getX() + " " + entityiterator.getY() + " " + entityiterator.getZ()));
								entityiterator.getPersistentData().putString("triviaPrevDim", entityiterator.level().dimension().location().toString());
								{
									Entity _ent = entityiterator;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
														_ent.getDisplayName(), _ent.level().getServer(), _ent),
												("execute in " + FuyukasUtilitiesModVariables.MapVariables.get(world).triviaDim + " run tp @s " + FuyukasUtilitiesModVariables.MapVariables.get(world).triviaPos));
									}
								}
								entityiterator.getPersistentData().putBoolean("isInTrivia", true);
							}
						}
					}
					FuyukasUtilitiesModVariables.MapVariables.get(world).isTriviaActive = true;
					FuyukasUtilitiesModVariables.MapVariables.get(world).syncData(world);
					FuyukasUtilitiesMod.LOGGER.info(("The trivia have been started by " + entity.getDisplayName().getString()));
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tellraw @s {\"text\":\"[Trivia Wand] Trivia started\",\"color\":\"#7B6DC7\"}");
						}
					}
				} else {
					if (world instanceof ServerLevel _server) {
						for (Entity entityiterator : _server.getAllEntities()) {
							if (entityiterator instanceof Player && entityiterator.getPersistentData().getBoolean("isInTrivia")) {
								{
									Entity _ent = entityiterator;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
														_ent.getDisplayName(), _ent.level().getServer(), _ent),
												("execute in " + entityiterator.getPersistentData().getString("triviaPrevDim") + " run tp @s " + entityiterator.getPersistentData().getString("triviaPrevPos")));
									}
								}
								entityiterator.getPersistentData().putBoolean("isInTrivia", false);
							}
						}
					}
					FuyukasUtilitiesModVariables.MapVariables.get(world).isTriviaActive = false;
					FuyukasUtilitiesModVariables.MapVariables.get(world).syncData(world);
					FuyukasUtilitiesMod.LOGGER.info(("The trivia have been ended by " + entity.getDisplayName().getString()));
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tellraw @s {\"text\":\"[Trivia Wand] Trivia ended\",\"color\":\"#7B6DC7\"}");
						}
					}
				}
			}
		}
	}
}
