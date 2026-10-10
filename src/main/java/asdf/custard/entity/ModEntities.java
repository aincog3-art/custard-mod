package asdf.custard.entity;
import asdf.custard.Custard;
import asdf.custard.entity.monster.SkeletonVillager;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.MobCategory;

public class ModEntities {
    public static final EntityType<SkeletonVillager> SKELETON_VILLAGER = register(
            ModEntityTypeIds.SKELETON_VILLAGER,
            EntityType.Builder.of(SkeletonVillager::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.95f)
    );

    private static <T extends Entity> EntityType<T> register(ResourceKey<EntityType<?>> key, EntityType.Builder<T> builder) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, key, builder.build(key));
    }

    public static void registerModEntityTypes() {
        Custard.LOGGER.info("Registering EntityTypes for " + Custard.MOD_ID);
    }

    public static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(SKELETON_VILLAGER, SkeletonVillager.createMobAttributes());
    }
}