package asdf.custard.entity;
import asdf.custard.entity.monster.SkeletonVillager;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.MobCategory;

public class ModEntities {
    public static final EntityType<SkeletonVillager> SKELETON_VILLAGER = Registry.register(
            BuiltInRegistries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath("custard", "skeleton_villager"),
            EntityType.Builder.of(SkeletonVillager::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.95f)
                    .build(ResourceKey.create(
                            Registries.ENTITY_TYPE,
                            Identifier.fromNamespaceAndPath("custard", "skeleton_villager")
                    ))
    );

    public static void registerModEntities() {
    }
}