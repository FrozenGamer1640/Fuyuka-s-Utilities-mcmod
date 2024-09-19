
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.fuyukasutilities.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.fuyukasutilities.entity.RayCastCustomMobEntity;
import net.mcreator.fuyukasutilities.FuyukasUtilitiesMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FuyukasUtilitiesModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, FuyukasUtilitiesMod.MODID);
	public static final RegistryObject<EntityType<RayCastCustomMobEntity>> RAY_CAST_CUSTOM_MOB = register("ray_cast_custom_mob", EntityType.Builder.<RayCastCustomMobEntity>of(RayCastCustomMobEntity::new, MobCategory.MISC)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(RayCastCustomMobEntity::new).fireImmune().sized(0.5f, 0.3f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			RayCastCustomMobEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(RAY_CAST_CUSTOM_MOB.get(), RayCastCustomMobEntity.createAttributes().build());
	}
}
