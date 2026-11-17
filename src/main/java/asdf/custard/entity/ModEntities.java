package asdf.custard.entity;
import asdf.custard.Custard;
import asdf.custard.entity.monster.Ghost;
import asdf.custard.entity.monster.SkeletonVillager;
import asdf.custard.entity.monster.Sunken;
import asdf.custard.entity.projectile.Harpoon;
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
    public static final EntityType<Sunken> SUNKEN = register(
            ModEntityTypeIds.SUNKEN,
            EntityType.Builder.of(Sunken::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.99f)
    );

    public static final EntityType<Ghost> GHOST = register(
            ModEntityTypeIds.GHOST,
            EntityType.Builder.of(Ghost::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.95f)
    );

    public static final EntityType<Harpoon> HARPOON = register(
            ModEntityTypeIds.HARPOON,
            EntityType.Builder.<Harpoon>of(Harpoon::new, MobCategory.MISC)
                    .sized(0.5f, 1f)
    );

    private static <T extends Entity> EntityType<T> register(ResourceKey<EntityType<?>> key, EntityType.Builder<T> builder) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, key, builder.build(key));
    }

    public static void registerModEntityTypes() {
        Custard.LOGGER.info("Registering EntityTypes for " + Custard.MOD_ID);
    }

    public static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(SKELETON_VILLAGER, SkeletonVillager.createAttributes());
        FabricDefaultAttributeRegistry.register(SUNKEN, Sunken.createAttributes());
        FabricDefaultAttributeRegistry.register(GHOST, Ghost.createAttributes());
    }
}