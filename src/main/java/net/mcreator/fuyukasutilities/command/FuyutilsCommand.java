
package net.mcreator.fuyukasutilities.command;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.Commands;

import net.mcreator.fuyukasutilities.procedures.TpSwapToggleModeProcedure;
import net.mcreator.fuyukasutilities.procedures.SetTriviaPosPProcedure;
import net.mcreator.fuyukasutilities.procedures.SetCustomWandRepeatCommandProcedure;
import net.mcreator.fuyukasutilities.procedures.SetCustomWandImpulseCommandProcedure;
import net.mcreator.fuyukasutilities.procedures.SetCustomWandChainedCommandProcedure;
import net.mcreator.fuyukasutilities.procedures.RemoveCustomWandChainedCommandProcedure;
import net.mcreator.fuyukasutilities.procedures.OverridePlayerPermsPProcedure;
import net.mcreator.fuyukasutilities.procedures.EditCustomWandChainedCommandProcedure;
import net.mcreator.fuyukasutilities.procedures.CloneItemPProcedure;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;

@Mod.EventBusSubscriber
public class FuyutilsCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("fuyutils").requires(s -> s.hasPermission(1)).then(Commands.literal("wands").then(Commands.literal("tpswap").then(Commands.argument("teamMode", BoolArgumentType.bool()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			TpSwapToggleModeProcedure.execute(arguments);
			return 0;
		}))).then(Commands.literal("trivia").then(Commands.literal("setPos").executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			SetTriviaPosPProcedure.execute(world, entity);
			return 0;
		}))).then(Commands.literal("impulse").then(Commands.argument("command", StringArgumentType.string()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			SetCustomWandImpulseCommandProcedure.execute(arguments, entity);
			return 0;
		}))).then(Commands.literal("repeat").then(Commands.argument("command", StringArgumentType.string()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			SetCustomWandRepeatCommandProcedure.execute(arguments, entity);
			return 0;
		}))).then(Commands.literal("chained").then(Commands.literal("add").then(Commands.argument("command", StringArgumentType.string()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			SetCustomWandChainedCommandProcedure.execute(arguments, entity);
			return 0;
		}))).then(Commands.literal("edit").then(Commands.argument("index", DoubleArgumentType.doubleArg(0)).then(Commands.argument("command", StringArgumentType.string()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			EditCustomWandChainedCommandProcedure.execute(arguments, entity);
			return 0;
		})))).then(Commands.literal("remove").then(Commands.argument("index", DoubleArgumentType.doubleArg(0)).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			RemoveCustomWandChainedCommandProcedure.execute(arguments, entity);
			return 0;
		}))))).then(Commands.literal("cloneItem").then(Commands.argument("cloneTargets", EntityArgument.players()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			CloneItemPProcedure.execute(arguments, entity);
			return 0;
		}))).then(Commands.literal("settings").then(Commands.literal("overridePlayerPerms").then(Commands.argument("overridePerms", BoolArgumentType.bool()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			OverridePlayerPermsPProcedure.execute(world, arguments, entity);
			return 0;
		})))));
	}
}
