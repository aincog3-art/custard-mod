package asdf.custard.client;

import asdf.custard.client.renderer.entity.HarpoonRenderer;
import asdf.custard.client.renderer.entity.SkeletonVillagerRenderer;
import asdf.custard.client.renderer.entity.SunkenRenderer;
import asdf.custard.entity.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import asdf.custard.client.model.geom.ModModelLayers;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;

public class CustardClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ModModelLayers.registerModelLayers();
		EntityRenderers.register(ModEntities.SKELETON_VILLAGER, SkeletonVillagerRenderer::new);
		EntityRenderers.register(ModEntities.SUNKEN, SunkenRenderer::new);
		EntityRenderers.register(ModEntities.HARPOON, HarpoonRenderer::new);
	}
}