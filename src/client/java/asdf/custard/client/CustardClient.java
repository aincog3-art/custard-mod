package asdf.custard.client;

import asdf.custard.ModSkullType;
import asdf.custard.client.mixin.SkullBlockRendererAccessor;
import asdf.custard.client.renderer.entity.HarpoonRenderer;
import asdf.custard.client.renderer.entity.SkeletonVillagerRenderer;
import asdf.custard.client.renderer.entity.SunkenRenderer;
import asdf.custard.entity.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import asdf.custard.client.model.geom.ModModelLayers;
import net.fabricmc.fabric.mixin.lookup.BlockEntityTypeAccessor;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SkullBlockRenderer;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.GhostRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.entity.BlockEntityTypes;

import java.util.Set;

public class CustardClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ModModelLayers.registerModelLayers();
		EntityRenderers.register(ModEntities.SKELETON_VILLAGER, SkeletonVillagerRenderer::new);
		EntityRenderers.register(ModEntities.SUNKEN, SunkenRenderer::new);
		EntityRenderers.register(ModEntities.GHOST, GhostRenderer::new);
		EntityRenderers.register(ModEntities.HARPOON, HarpoonRenderer::new);
		ModSkullType.init();
		SkullBlockRendererAccessor.getSkinByType().put(
				ModSkullType.ILLAGER,
				Identifier.withDefaultNamespace("textures/entity/illager/vindicator.png")
		);
		SkullBlockRendererAccessor.getSkinByType().put(
				ModSkullType.VILLAGER,
				Identifier.withDefaultNamespace("textures/entity/villager/villager.png")
		);
		SkullBlockRendererAccessor.getSkinByType().put(
				ModSkullType.ZOMBIE_VILLAGER,
				Identifier.withDefaultNamespace("textures/entity/zombie_villager/zombie_villager.png")
		);
	}
}