package asdf.custard.client.model.monster;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.object.projectile.ArrowModel;
import net.minecraft.client.renderer.entity.state.ArrowRenderState;
public class HarpoonModel<S extends ArrowRenderState> extends ArrowModel {
    public HarpoonModel(final ModelPart root) {
        super(root);
    }
}

