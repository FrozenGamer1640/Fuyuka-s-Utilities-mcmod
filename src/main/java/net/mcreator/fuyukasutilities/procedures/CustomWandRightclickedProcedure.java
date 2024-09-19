package net.mcreator.fuyukasutilities.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.fuyukasutilities.network.FuyukasUtilitiesModVariables;

public class CustomWandRightclickedProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double UserPermsLevel = 0;
		UserPermsLevel = FuyukasUtilitiesModVariables.MapVariables.get(world).OverridePlayerPerms ? 4 : new Object() {
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
		}.getPermissionLevel(entity);
		if ((itemstack.getOrCreateTag().getString("mode")).equals("impulse")) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
							(int) UserPermsLevel, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), (itemstack.getOrCreateTag().getString("command")));
				}
			}
		} else if ((itemstack.getOrCreateTag().getString("mode")).equals("repeat")) {
			if (!itemstack.getOrCreateTag().getBoolean("isRepeatActive")) {
				itemstack.getOrCreateTag().putBoolean("isRepeatActive", true);
			} else {
				itemstack.getOrCreateTag().putBoolean("isRepeatActive", false);
			}
		} else if ((itemstack.getOrCreateTag().getString("mode")).equals("chained")) {
			{
				String[] _array = (itemstack.getOrCreateTag().getString("command")).split(",,");
				if (_array.length != 0) {
					for (String stringiterator : _array) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
										(int) UserPermsLevel, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), stringiterator);
							}
						}
					}
				} else {
					String stringiterator = (itemstack.getOrCreateTag().getString("command"));
					for (int _yourmother = 0; _yourmother < 1; _yourmother++) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
										(int) UserPermsLevel, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), stringiterator);
							}
						}
					}
				}
			}
		}
	}
}
