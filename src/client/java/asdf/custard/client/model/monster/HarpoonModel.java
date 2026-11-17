package asdf.custard.client.model.monster;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.object.projectile.ArrowModel;
import net.minecraft.client.renderer.entity.state.ArrowRenderState;
import net.minecraft.world.entity.Entity;
// Made with Blockbench 5.2.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class HarpoonModel<T extends Entity> extends EntityModel<ArrowRenderState> {
    private final ModelPart back;
    private final ModelPart cross_1;
    private final ModelPart bb_main;

    public HarpoonModel(ModelPart root) {
        super(root);
        this.back = root.getChild("back");
        this.cross_1 = root.getChild("cross_1");
        this.bb_main = root.getChild("bb_main");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();

        PartDefinition back = root.addOrReplaceChild("back", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -2.0F, -2.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 20.5F, 7.0F, -2.3562F, 1.5708F, 0.0F));

        PartDefinition cross_1 = root.addOrReplaceChild("cross_1", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -2.5F, 0.0F, 16.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 20.5F, -4.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition bb_main = root.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 5).addBox(-1.0F, -4.5F, 3.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
        return LayerDefinition.create(mesh, 32, 32);
    }

    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        back.render(poseStack, vertexConsumer, packedLight, packedOverlay);
        cross_1.render(poseStack, vertexConsumer, packedLight, packedOverlay);
        bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay);
    }
}
