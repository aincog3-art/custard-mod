//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package asdf.custard.client.renderer.entity;

import asdf.custard.client.model.geom.ModModelLayers;
import asdf.custard.entity.monster.SkeletonVillager;
import asdf.custard.entity.monster.Sunken;
import com.google.common.collect.Maps;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.PrimitiveCodec;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.model.animal.axolotl.AdultAxolotlModel;
import net.minecraft.client.model.animal.axolotl.BabyAxolotlModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.AbstractSkeletonRenderer;
import net.minecraft.client.renderer.entity.AxolotlRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.AxolotlRenderState;
import net.minecraft.client.renderer.entity.state.PiglinRenderState;
import net.minecraft.client.renderer.entity.state.SkeletonRenderState;
import asdf.custard.client.renderer.entity.state.SunkenRenderState;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.util.Util;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.animal.axolotl.Axolotl;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;
import net.minecraft.world.item.CrossbowItem;

import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.function.IntFunction;

public class SunkenRenderer extends AbstractSkeletonRenderer<Sunken, SunkenRenderState> {
    private static final Map<Sunken.Variant, Identifier> TEXTURE_BY_TYPE = Util.make(Maps.newHashMap(), (map) -> {
        for (Sunken.Variant variant : Sunken.Variant.values()) {
            map.put(variant, Identifier.fromNamespaceAndPath("custard", String.format(Locale.ROOT, "textures/entity/skeleton/sunken/sunken_%s.png", variant.getName())));
        }
    });

    @Override
    public Identifier getTextureLocation(final SunkenRenderState state) {
        return TEXTURE_BY_TYPE.getOrDefault(state.variant, TEXTURE_BY_TYPE.get(Sunken.Variant.DEFAULT));
    }
    public SunkenRenderer(final EntityRendererProvider.Context context) {
        super(context, ModModelLayers.SUNKEN, ModModelLayers.SUNKEN_ARMOR);
    }

    public void extractRenderState(final Sunken entity, final SunkenRenderState state, final float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.armPose = entity.getArmPose();
        state.ticksUsingItem = entity.getTicksUsingItem();
        state.maxCrossbowChargeDuration = (float) CrossbowItem.getChargeDuration(entity.getUseItem(), entity);
    }

    @Override
    public SunkenRenderState createRenderState() {
        return new SunkenRenderState();
    }
}