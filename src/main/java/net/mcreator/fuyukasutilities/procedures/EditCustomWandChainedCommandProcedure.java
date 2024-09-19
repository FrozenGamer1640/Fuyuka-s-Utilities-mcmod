package net.mcreator.fuyukasutilities.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.fuyukasutilities.init.FuyukasUtilitiesModItems;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class EditCustomWandChainedCommandProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		double numIterator = 0;
		String commandBuffer = "";
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == FuyukasUtilitiesModItems.CUSTOM_WAND.get()) {
			if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("mode")).equals("chained")) {
				if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("command")).isEmpty()) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tellraw @s {\"text\":\" [Fuyutils] This wand does not have anything to edit!\",\"color\":\"#F53148\"}");
						}
					}
				} else {
					numIterator = 0;
					{
						String[] _array = ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("command")).split(",,");
						if (_array.length != 0) {
							for (String stringiterator : _array) {
								if (numIterator != DoubleArgumentType.getDouble(arguments, "index")) {
									commandBuffer = (commandBuffer).isEmpty() ? stringiterator : commandBuffer + ",," + stringiterator;
								} else {
									commandBuffer = commandBuffer + ",," + StringArgumentType.getString(arguments, "command");
								}
								numIterator = numIterator + 1;
							}
						} else {
							String stringiterator = ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("command"));
							for (int _yourmother = 0; _yourmother < 1; _yourmother++) {
								if (numIterator != DoubleArgumentType.getDouble(arguments, "index")) {
									commandBuffer = (commandBuffer).isEmpty() ? stringiterator : commandBuffer + ",," + stringiterator;
								} else {
									commandBuffer = commandBuffer + ",," + StringArgumentType.getString(arguments, "command");
								}
								numIterator = numIterator + 1;
							}
						}
					}
					if (numIterator <= DoubleArgumentType.getDouble(arguments, "index")) {
						(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putString("command", commandBuffer);
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tellraw @s {\"text\":\" [Fuyutils] The selected command have been edited\",\"color\":\"#7B6DC7\"}");
							}
						}
					} else {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tellraw @s {\"text\":\" [Fuyutils] The especified index is out of bounds\",\"color\":\"#F53148\"}");
							}
						}
					}
				}
			} else {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tellraw @s {\"text\":\" [Fuyutils] you need a Chained Custom Wand to edit its content\",\"color\":\"#F53148\"}");
					}
				}
			}
		} else {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tellraw @s {\"text\":\" [Fuyutils] in set mode you need to have a custom wand in your main hand\",\"color\":\"#F53148\"}");
				}
			}
		}
	}
}
