
package net.mcreator.fuyukasutilities.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.CodModel;

import net.mcreator.fuyukasutilities.entity.RayCastCustomMobEntity;

public class RayCastCustomMobRenderer extends MobRenderer<RayCastCustomMobEntity, CodModel<RayCastCustomMobEntity>> {
	public RayCastCustomMobRenderer(EntityRendererProvider.Context context) {
		super(context, new CodModel(context.bakeLayer(ModelLayers.COD)), 0.1f);
	}

	@Override
	public ResourceLocation getTextureLocation(RayCastCustomMobEntity entity) {
		return new ResourceLocation("fuyukas_utilities:textures/entities/raycast.png");
	}

	@Override
	protected boolean isBodyVisible(RayCastCustomMobEntity entity) {
		return false;
	}
}
