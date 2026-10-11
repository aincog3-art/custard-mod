//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package asdf.custard.client.renderer.entity.state;

import asdf.custard.entity.monster.Sunken;
import asdf.custard.entity.monster.SunkenArmPose;
import net.minecraft.client.renderer.entity.state.SkeletonRenderState;

public class SunkenRenderState extends SkeletonRenderState {
    public Sunken.Variant variant;
    public float maxCrossbowChargeDuration;
    public SunkenArmPose armPose;
    public float ticksUsingItem;

    public SunkenRenderState() {
        this.variant = Sunken.Variant.DEFAULT;
        this.armPose = SunkenArmPose.DEFAULT;
    }
}
