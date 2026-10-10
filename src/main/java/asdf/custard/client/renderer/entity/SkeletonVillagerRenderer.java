//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package asdf.custard.client.renderer.entity;

import asdf.custard.entity.monster.SkeletonVillager;
import net.minecraft.client.renderer.entity.AbstractSkeletonRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.SkeletonRenderState;
import net.minecraft.resources.Identifier;
import asdf.custard.client.model.geom.ModModelLayers;

public class SkeletonVillagerRenderer extends AbstractSkeletonRenderer<SkeletonVillager, SkeletonRenderState> {
    private static final Identifier SKELETON_VILLAGER_LOCATION = Identifier.fromNamespaceAndPath("custard", "textures/entity/skeleton_villager.png");

    public SkeletonVillagerRenderer(final EntityRendererProvider.Context context) {
        super(context, ModModelLayers.SKELETON_VILLAGER, ModModelLayers.SKELETON_VILLAGER_ARMOR);
    }

    public Identifier getTextureLocation(final SkeletonRenderState state) {
        return SKELETON_VILLAGER_LOCATION;
    }

    public SkeletonRenderState createRenderState() {
        return new SkeletonRenderState();
    }
}
