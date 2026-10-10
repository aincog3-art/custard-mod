package asdf.custard.client.model.geom;

import com.google.common.collect.Sets;
import java.util.Set;
import java.util.stream.Stream;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.ArmorModelSet;
import net.minecraft.resources.Identifier;

public class ModModelLayers {
    private static final String DEFAULT_LAYER = "main";
    private static final Set<ModelLayerLocation> ALL_MODELS = Sets.newHashSet();
    public static final ModelLayerLocation SKELETON_VILLAGER = register("skeleton_villager");
    public static final ArmorModelSet<ModelLayerLocation> SKELETON_VILLAGER_ARMOR = registerArmorSet("skeleton_villager");
    public ModModelLayers() {
    }

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
        return new ModelLayerLocation(Identifier.withDefaultNamespace(model), layer);
    }

    private static ArmorModelSet<ModelLayerLocation> registerArmorSet(final String modelId) {
        return new ArmorModelSet(register(modelId, "helmet"), register(modelId, "chestplate"), register(modelId, "leggings"), register(modelId, "boots"));
    }

    public static Stream<ModelLayerLocation> getKnownLocations() {
        return ALL_MODELS.stream();
    }
}