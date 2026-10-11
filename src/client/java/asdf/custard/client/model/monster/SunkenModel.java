package asdf.custard.client.model.monster;

import asdf.custard.client.renderer.entity.state.SunkenRenderState;
import asdf.custard.entity.monster.SunkenArmPose;
import net.minecraft.client.model.AnimationUtils;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.model.monster.skeleton.SkeletonModel;
import net.minecraft.client.renderer.entity.state.PiglinRenderState;
import net.minecraft.client.renderer.entity.state.SkeletonRenderState;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.monster.piglin.PiglinArmPose;

public class SunkenModel extends SkeletonModel<SunkenRenderState> {
    public SunkenModel(final ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
        PartDefinition root = mesh.getRoot();
        SkeletonModel.createDefaultSkeletonMesh(root);
        PartDefinition head = root.getChild("head");
        head.clearChild("hat");
        PartDefinition corals_1 = head.addOrReplaceChild("corals_1", CubeListBuilder.create().texOffs(22, 0).addBox(-1.0F, -3.0F, 2.0F, 6.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(32, 1).addBox(-1.0F, -15.0F, -4.0F, 9.0F, 7.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(37, 8).addBox(4.0F, -8.0F, -4.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        PartDefinition corals_2 = root.getChild("body").addOrReplaceChild("corals_2", CubeListBuilder.create() .texOffs(19, 24).addBox(-5.0F, 4.0F, -2.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        PartDefinition corals_3 = root.getChild("right_leg").addOrReplaceChild("corals_3", CubeListBuilder.create()  .texOffs(24, 4).addBox(-2.0F, 5.0F, -2.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        return LayerDefinition.create(mesh, 64, 32);
    }

    @Override
    public void setupAnim(final SunkenRenderState state) {
        super.setupAnim(state);
        SunkenArmPose pose = state.armPose;
        if (pose == SunkenArmPose.CROSSBOW_HOLD) {
            AnimationUtils.animateCrossbowHold(this.rightArm, this.leftArm, this.head, state.mainArm == HumanoidArm.RIGHT);
        } else if (pose == SunkenArmPose.CROSSBOW_CHARGE) {
            AnimationUtils.animateCrossbowCharge(this.rightArm, this.leftArm, state.maxCrossbowChargeDuration, state.ticksUsingItem, state.mainArm == HumanoidArm.RIGHT);
        }
    }
}
