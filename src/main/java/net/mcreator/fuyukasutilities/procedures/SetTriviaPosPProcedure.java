package net.mcreator.fuyukasutilities.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.fuyukasutilities.network.FuyukasUtilitiesModVariables;

public class SetTriviaPosPProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		FuyukasUtilitiesModVariables.MapVariables.get(world).triviaDim = entity.level().dimension().location().toString();
		FuyukasUtilitiesModVariables.MapVariables.get(world).syncData(world);
		FuyukasUtilitiesModVariables.MapVariables.get(world).triviaPos = entity.getX() + " " + entity.getY() + " " + entity.getZ();
		FuyukasUtilitiesModVariables.MapVariables.get(world).syncData(world);
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands()
						.performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level().getServer(), _ent),
								("tellraw @s {\"text\":\" [Fuyutils] The trivia position have been changed to: " + "" + (entity.getX() + " " + entity.getY() + " " + entity.getZ()) + "\",\"color\":\"#7B6DC7\"}"));
			}
		}
	}
}
