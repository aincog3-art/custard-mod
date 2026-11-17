//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.minecraft.client.renderer.entity;

import asdf.custard.client.renderer.entity.state.GhostRenderState;
import asdf.custard.client.renderer.entity.state.SunkenRenderState;
import asdf.custard.entity.monster.Ghost;
import asdf.custard.entity.monster.Sunken;
import net.minecraft.client.model.HumanoidModel;
import asdf.custard.client.model.geom.ModModelLayers;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.state.ArrowRenderState;
import net.minecraft.client.renderer.entity.state.ZombieRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.monster.zombie.Zombie;

public class GhostRenderer extends HumanoidMobRenderer<Ghost, GhostRenderState, HumanoidModel<GhostRenderState>> {
    private static final Identifier GHOST_LOCATION = Identifier.fromNamespaceAndPath("custard","textures/entity/ghost.png");

    public GhostRenderer(final EntityRendererProvider.Context context) {
        super(context, new HumanoidModel<>(context.bakeLayer(ModModelLayers.GHOST)), 0.5F);
    }

    @Override
    public Identifier getTextureLocation(GhostRenderState state) {
        return GHOST_LOCATION;
    }

    public void extractRenderState(final Ghost entity, final GhostRenderState state, final float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.isAggressive = entity.isAggressive();
    }

    @Override
    public GhostRenderState createRenderState() {
        return new GhostRenderState();
    }
}
