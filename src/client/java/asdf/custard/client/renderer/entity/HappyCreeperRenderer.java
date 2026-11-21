//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package asdf.custard.client.renderer.entity;

import asdf.custard.client.model.animal.HappyCreeperModel;
import asdf.custard.client.model.geom.ModModelLayers;
import asdf.custard.entity.animal.HappyCreeper;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.monster.creeper.CreeperModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CreeperPowerLayer;
import net.minecraft.client.renderer.entity.state.CreeperRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.monster.Creeper;

public class HappyCreeperRenderer extends MobRenderer<HappyCreeper, CreeperRenderState, HappyCreeperModel> {
    private static final Identifier HAPPY_CREEPER_LOCATION = Identifier.fromNamespaceAndPath("custard","textures/entity/creeper/happy_creeper.png");

    public HappyCreeperRenderer(final EntityRendererProvider.Context context) {
        super(context, new HappyCreeperModel(context.bakeLayer(ModModelLayers.HAPPY_CREEPER)), 0.5F);
    }

    protected void scale(final CreeperRenderState state, final PoseStack poseStack) {
        float g = state.swelling;
        float wobble = 1.0F + Mth.sin((double)(g * 100.0F)) * g * 0.01F;
        g = Mth.clamp(g, 0.0F, 1.0F);
        g *= g;
        g *= g;
        float s = (1.0F + g * 0.4F) * wobble;
        float hs = (1.0F + g * 0.1F) / wobble;
        poseStack.scale(s, hs, s);
    }

    protected float getWhiteOverlayProgress(final CreeperRenderState state) {
        float step = state.swelling;
        return (int)(step * 10.0F) % 2 == 0 ? 0.0F : Mth.clamp(step, 0.5F, 1.0F);
    }

    public Identifier getTextureLocation(final CreeperRenderState state) {
        return HAPPY_CREEPER_LOCATION;
    }

    public CreeperRenderState createRenderState() {
        return new CreeperRenderState();
    }
}
