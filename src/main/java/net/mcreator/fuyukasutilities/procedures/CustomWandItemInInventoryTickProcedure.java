package net.mcreator.fuyukasutilities.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.fuyukasutilities.network.FuyukasUtilitiesModVariables;

public class CustomWandItemInInventoryTickProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrCreateTag().getBoolean("isRepeatActive")) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
							(int) (FuyukasUtilitiesModVariables.MapVariables.get(world).OverridePlayerPerms ? 4 : new Object() {
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
							}.getPermissionLevel(entity)), _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), (itemstack.getOrCreateTag().getString("command")));
				}
			}
		}
	}
}
