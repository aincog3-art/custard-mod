package asdf.custard.client.model.geom;

import asdf.custard.client.model.monster.HarpoonModel;
import asdf.custard.client.model.monster.SkeletonVillagerModel;
import asdf.custard.client.model.monster.SunkenModel;
import com.google.common.collect.Sets;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.entity.ArmorModelSet;
import net.minecraft.resources.Identifier;

import java.util.Set;
import java.util.stream.Stream;

import static net.minecraft.client.model.HumanoidModel.createArmorMeshSet;

public class ModModelLayers {
    private static final String DEFAULT_LAYER = "main";
    private static final Set<ModelLayerLocation> ALL_MODELS = Sets.newHashSet();
    public static final ModelLayerLocation HARPOON = register("harpoon");
    public static final ModelLayerLocation SKELETON_VILLAGER = register("skeleton_villager");
    public static final ArmorModelSet<ModelLayerLocation> SKELETON_VILLAGER_ARMOR = registerArmorSet("skeleton_villager");
    public static final ModelLayerLocation SUNKEN = register("sunken");
    public static final ArmorModelSet<ModelLayerLocation> SUNKEN_ARMOR = registerArmorSet("sunken");

    private static ModelLayerLocation register(final String model) {
        return register(model, "main");
    }

    private static ModelLayerLocation register(final String model, final String layer) {
        ModelLayerLocation result = createLocation(model, layer);
        if (!ALL_MODELS.add(result)) {
            throw new IllegalStateException("Duplicate registration for " + String.valueOf(result));
        } else {
            return result;
        }
    }

    private static ModelLayerLocation createLocation(final String model, final String layer) {
        return new ModelLayerLocation(Identifier.fromNamespaceAndPath("custard", model), layer);
    }

    private static ArmorModelSet<ModelLayerLocation> registerArmorSet(final String modelId) {
        return new ArmorModelSet(register(modelId, "helmet"), register(modelId, "chestplate"), register(modelId, "leggings"), register(modelId, "boots"));
    }

    public static Stream<ModelLayerLocation> getKnownLocations() {
        return ALL_MODELS.stream();
    }

    public static ArmorModelSet<LayerDefinition> createArmorLayer() {
        return createArmorMeshSet(new CubeDeformation(0.5F), new CubeDeformation(1.0F))
                .map(mesh -> LayerDefinition.create(mesh, 64, 32));
    }

    public static void registerModelLayers() {
        ModelLayerRegistry.registerModelLayer(HARPOON, HarpoonModel::createBodyLayer);
        ModelLayerRegistry.registerModelLayer(SKELETON_VILLAGER,SkeletonVillagerModel::createBodyLayer);
        ModelLayerRegistry.registerArmorModelLayers(SKELETON_VILLAGER_ARMOR, ModModelLayers::createArmorLayer);
        ModelLayerRegistry.registerModelLayer(SUNKEN, SunkenModel::createBodyLayer);
        ModelLayerRegistry.registerArmorModelLayers(SUNKEN_ARMOR, ModModelLayers::createArmorLayer);
    }
}