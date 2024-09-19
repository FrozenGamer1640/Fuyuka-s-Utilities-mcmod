package net.mcreator.fuyukasutilities.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.fuyukasutilities.network.FuyukasUtilitiesModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class OverridePlayerPermsPProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if (new Object() {
			int getPermissionLevel(Entity ent) {
				int lvl = 0;
				for (int Level = 0; Level < 4; Level++) {
					if (ent.hasPermissions(Level + 1)) {
						lvl = Level + 1;
					} else {
						break;
					}
				}
				return lvl;
			}
		}.getPermissionLevel(entity) >= 4) {
			FuyukasUtilitiesModVariables.MapVariables.get(world).OverridePlayerPerms = BoolArgumentType.getBool(arguments, "overridePerms");
			FuyukasUtilitiesModVariables.MapVariables.get(world).syncData(world);
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands()
							.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
									_ent.getDisplayName(), _ent.level().getServer(), _ent),
									("tellraw @s {\"text\":\" [Fuyutils] OverridePlayerPerms have been set to: " + "" + BoolArgumentType.getBool(arguments, "overridePerms") + "\",\"color\":\"#7B6DC7\"}"));
				}
			}
		} else {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tellraw @s {\"text\":\" [Fuyutils] You need higher permission level to change this\",\"color\":\"#F53148\"}");
				}
			}
		}
	}
}
