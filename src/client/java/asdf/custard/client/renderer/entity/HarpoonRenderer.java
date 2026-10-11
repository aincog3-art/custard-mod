package asdf.custard.client.renderer.entity;

import asdf.custard.entity.projectile.Harpoon;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.ArrowRenderState;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.entity.state.SkeletonRenderState;
import net.minecraft.resources.Identifier;

public class HarpoonRenderer extends ArrowRenderer {
    private static final Identifier HARPOON_LOCATION = Identifier.fromNamespaceAndPath("minecraft", "textures/entity/arrow.png");

    public HarpoonRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public Identifier getTextureLocation(ArrowRenderState state) {
        return HARPOON_LOCATION;
    }

    @Override
    public ArrowRenderState createRenderState() {
        return new ArrowRenderState();
    }
}