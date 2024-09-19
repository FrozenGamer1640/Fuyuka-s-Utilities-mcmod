package net.mcreator.fuyukasutilities.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.gui.screens.Screen;

import net.mcreator.fuyukasutilities.network.FuyukasUtilitiesModVariables;
import net.mcreator.fuyukasutilities.entity.RayCastCustomMobEntity;
import net.mcreator.fuyukasutilities.FuyukasUtilitiesMod;

import java.util.List;
import java.util.Comparator;

import com.mojang.util.UUIDTypeAdapter;

public class TpSwapWandRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double numIterator = 0;
		Entity raycastTarget = null;
		if (Screen.hasAltDown()) {
			if (itemstack.getOrCreateTag().getBoolean("TpSwap_UseSecondArray")) {
				itemstack.getOrCreateTag().putBoolean("TpSwap_UseSecondArray", false);
			} else {
				itemstack.getOrCreateTag().putBoolean("TpSwap_UseSecondArray", true);
			}
		} else if (Screen.hasShiftDown()) {
			TpSwapConfirmProcedure.execute(world);
		} else {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "kill @e[type=fuyukas_utilities:ray_cast_custom_mob]");
				}
			}
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "summon fuyukas_utilities:ray_cast_custom_mob ~ ~ ~");
				}
			}
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s at @s anchored eyes run tp @e[type=fuyukas_utilities:ray_cast_custom_mob,limit=1,sort=nearest] ^ ^2 ^");
				}
			}
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands()
							.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
									_ent.getDisplayName(), _ent.level().getServer(), _ent),
									("execute as @s at @s anchored eyes run tp @e[type=fuyukas_utilities:ray_cast_custom_mob,limit=1,sort=nearest] ^ ^ ^1.6 " + entity.getYRot() + " " + entity.getXRot()));
				}
			}
			if (!world.getEntitiesOfClass(RayCastCustomMobEntity.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).isEmpty()) {
				{
					String _setval = ((Entity) world.getEntitiesOfClass(RayCastCustomMobEntity.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).getStringUUID();
					entity.getCapability(FuyukasUtilitiesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.RaycastUUID = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (new Object() {
					Entity getEntity(String uuid) {
						Entity _uuidentity = null;
						if (world instanceof ServerLevel _server) {
							try {
								_uuidentity = _server.getEntity(UUIDTypeAdapter.fromString(uuid));
							} catch (IllegalArgumentException e) {
							}
						}
						return _uuidentity;
					}
				}.getEntity(((entity.getCapability(FuyukasUtilitiesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FuyukasUtilitiesModVariables.PlayerVariables())).RaycastUUID)) instanceof RayCastCustomMobEntity) {
					numIterator = 32;
					while (numIterator > 0) {
						{
							Entity _ent = new Object() {
								Entity getEntity(String uuid) {
									Entity _uuidentity = null;
									if (world instanceof ServerLevel _server) {
										try {
											_uuidentity = _server.getEntity(UUIDTypeAdapter.fromString(uuid));
										} catch (IllegalArgumentException e) {
										}
									}
									return _uuidentity;
								}
							}.getEntity(((entity.getCapability(FuyukasUtilitiesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FuyukasUtilitiesModVariables.PlayerVariables())).RaycastUUID));
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tp @s ^ ^ ^0.5");
							}
						}
						{
							Entity _ent = new Object() {
								Entity getEntity(String uuid) {
									Entity _uuidentity = null;
									if (world instanceof ServerLevel _server) {
										try {
											_uuidentity = _server.getEntity(UUIDTypeAdapter.fromString(uuid));
										} catch (IllegalArgumentException e) {
										}
									}
									return _uuidentity;
								}
							}.getEntity(((entity.getCapability(FuyukasUtilitiesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FuyukasUtilitiesModVariables.PlayerVariables())).RaycastUUID));
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "particle flame ~ ~ ~ 0 0 0 0 1 force");
							}
						}
						{
							final Vec3 _center = new Vec3((new Object() {
								Entity getEntity(String uuid) {
									Entity _uuidentity = null;
									if (world instanceof ServerLevel _server) {
										try {
											_uuidentity = _server.getEntity(UUIDTypeAdapter.fromString(uuid));
										} catch (IllegalArgumentException e) {
										}
									}
									return _uuidentity;
								}
							}.getEntity(((entity.getCapability(FuyukasUtilitiesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FuyukasUtilitiesModVariables.PlayerVariables())).RaycastUUID)).getX()), (new Object() {
								Entity getEntity(String uuid) {
									Entity _uuidentity = null;
									if (world instanceof ServerLevel _server) {
										try {
											_uuidentity = _server.getEntity(UUIDTypeAdapter.fromString(uuid));
										} catch (IllegalArgumentException e) {
										}
									}
									return _uuidentity;
								}
							}.getEntity(((entity.getCapability(FuyukasUtilitiesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FuyukasUtilitiesModVariables.PlayerVariables())).RaycastUUID)).getY()), (new Object() {
								Entity getEntity(String uuid) {
									Entity _uuidentity = null;
									if (world instanceof ServerLevel _server) {
										try {
											_uuidentity = _server.getEntity(UUIDTypeAdapter.fromString(uuid));
										} catch (IllegalArgumentException e) {
										}
									}
									return _uuidentity;
								}
							}.getEntity(((entity.getCapability(FuyukasUtilitiesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FuyukasUtilitiesModVariables.PlayerVariables())).RaycastUUID)).getZ()));
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(0.15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (!(entityiterator instanceof RayCastCustomMobEntity) && entityiterator instanceof LivingEntity) {
									if (new Object() {
										Entity getEntity(String uuid) {
											Entity _uuidentity = null;
											if (world instanceof ServerLevel _server) {
												try {
													_uuidentity = _server.getEntity(UUIDTypeAdapter.fromString(uuid));
												} catch (IllegalArgumentException e) {
												}
											}
											return _uuidentity;
										}
									}.getEntity(((entity.getCapability(FuyukasUtilitiesModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new FuyukasUtilitiesModVariables.PlayerVariables())).RaycastUUID)) instanceof RayCastCustomMobEntity _datEntSetL)
										_datEntSetL.getEntityData().set(RayCastCustomMobEntity.DATA_hit, true);
									numIterator = 0;
								}
								numIterator = numIterator - 1;
							}
						}
					}
					if ((new Object() {
						Entity getEntity(String uuid) {
							Entity _uuidentity = null;
							if (world instanceof ServerLevel _server) {
								try {
									_uuidentity = _server.getEntity(UUIDTypeAdapter.fromString(uuid));
								} catch (IllegalArgumentException e) {
								}
							}
							return _uuidentity;
						}
					}.getEntity(((entity.getCapability(FuyukasUtilitiesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FuyukasUtilitiesModVariables.PlayerVariables())).RaycastUUID)) instanceof RayCastCustomMobEntity _datEntL35
							&& _datEntL35.getEntityData().get(RayCastCustomMobEntity.DATA_hit)) == true) {
						{
							final Vec3 _center = new Vec3((new Object() {
								Entity getEntity(String uuid) {
									Entity _uuidentity = null;
									if (world instanceof ServerLevel _server) {
										try {
											_uuidentity = _server.getEntity(UUIDTypeAdapter.fromString(uuid));
										} catch (IllegalArgumentException e) {
										}
									}
									return _uuidentity;
								}
							}.getEntity(((entity.getCapability(FuyukasUtilitiesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FuyukasUtilitiesModVariables.PlayerVariables())).RaycastUUID)).getX()), (new Object() {
								Entity getEntity(String uuid) {
									Entity _uuidentity = null;
									if (world instanceof ServerLevel _server) {
										try {
											_uuidentity = _server.getEntity(UUIDTypeAdapter.fromString(uuid));
										} catch (IllegalArgumentException e) {
										}
									}
									return _uuidentity;
								}
							}.getEntity(((entity.getCapability(FuyukasUtilitiesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FuyukasUtilitiesModVariables.PlayerVariables())).RaycastUUID)).getY()), (new Object() {
								Entity getEntity(String uuid) {
									Entity _uuidentity = null;
									if (world instanceof ServerLevel _server) {
										try {
											_uuidentity = _server.getEntity(UUIDTypeAdapter.fromString(uuid));
										} catch (IllegalArgumentException e) {
										}
									}
									return _uuidentity;
								}
							}.getEntity(((entity.getCapability(FuyukasUtilitiesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FuyukasUtilitiesModVariables.PlayerVariables())).RaycastUUID)).getZ()));
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(0.1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (!(entityiterator instanceof RayCastCustomMobEntity) && entityiterator instanceof LivingEntity) {
									raycastTarget = entityiterator;
								}
							}
						}
						if (FuyukasUtilitiesModVariables.TpSwap_TeamMode) {
							if (!(FuyukasUtilitiesModVariables.TpSwapTargets1.contains(raycastTarget) || FuyukasUtilitiesModVariables.TpSwapTargets2.contains(raycastTarget))) {
								if (itemstack.getOrCreateTag().getBoolean("TpSwap_UseSecondArray")) {
									FuyukasUtilitiesModVariables.TpSwapTargets2.add(raycastTarget);
								} else {
									FuyukasUtilitiesModVariables.TpSwapTargets1.add(raycastTarget);
								}
							} else if (FuyukasUtilitiesModVariables.TpSwapTargets1.contains(raycastTarget)) {
								numIterator = FuyukasUtilitiesModVariables.TpSwapTargets1.size();
								while (numIterator > 0) {
									if (raycastTarget == (FuyukasUtilitiesModVariables.TpSwapTargets1.get((int) (numIterator - 1)) instanceof Entity _e ? _e : null)) {
										FuyukasUtilitiesModVariables.TpSwapTargets1.remove((int) (numIterator - 1));
									}
									numIterator = numIterator - 1;
								}
							} else {
								numIterator = FuyukasUtilitiesModVariables.TpSwapTargets2.size();
								while (numIterator > 0) {
									if (raycastTarget == (FuyukasUtilitiesModVariables.TpSwapTargets2.get((int) (numIterator - 1)) instanceof Entity _e ? _e : null)) {
										FuyukasUtilitiesModVariables.TpSwapTargets2.remove((int) (numIterator - 1));
									}
									numIterator = numIterator - 1;
								}
							}
						} else {
							if (!FuyukasUtilitiesModVariables.TpSwapTargets1.contains(raycastTarget)) {
								if (FuyukasUtilitiesModVariables.TpSwapTargets1.size() <= 1) {
									FuyukasUtilitiesModVariables.TpSwapTargets1.add(raycastTarget);
								} else {
									FuyukasUtilitiesModVariables.TpSwapTargets1.clear();
									FuyukasUtilitiesModVariables.TpSwapTargets1.add(raycastTarget);
								}
								if (raycastTarget instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.forceAddEffect(new MobEffectInstance(MobEffects.GLOWING, (int) (2 * 20), 0, true, false), raycastTarget);
							}
						}
					}
					{
						Entity _ent = new Object() {
							Entity getEntity(String uuid) {
								Entity _uuidentity = null;
								if (world instanceof ServerLevel _server) {
									try {
										_uuidentity = _server.getEntity(UUIDTypeAdapter.fromString(uuid));
									} catch (IllegalArgumentException e) {
									}
								}
								return _uuidentity;
							}
						}.getEntity(((entity.getCapability(FuyukasUtilitiesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FuyukasUtilitiesModVariables.PlayerVariables())).RaycastUUID));
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "tp @s ~ -300 ~");
						}
					}
					FuyukasUtilitiesMod.queueServerWork(10, () -> {
						{
							Entity _ent = new Object() {
								Entity getEntity(String uuid) {
									Entity _uuidentity = null;
									if (world instanceof ServerLevel _server) {
										try {
											_uuidentity = _server.getEntity(UUIDTypeAdapter.fromString(uuid));
										} catch (IllegalArgumentException e) {
										}
									}
									return _uuidentity;
								}
							}.getEntity(((entity.getCapability(FuyukasUtilitiesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new FuyukasUtilitiesModVariables.PlayerVariables())).RaycastUUID));
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "kill @s");
							}
						}
					});
				}
			}
		}
	}
}
