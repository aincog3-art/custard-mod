package asdf.custard.entity;

import asdf.custard.Custard;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;

public class ModEntityTypeIds {
    public static ResourceKey<EntityType<?>> SKELETON_VILLAGER = create("skeleton_villager");
    public static ResourceKey<EntityType<?>> SUNKEN = create("sunken");
    public static ResourceKey<EntityType<?>> HARPOON = create("harpoon");

    private static ResourceKey<EntityType<?>> create(String name) {
        return ResourceKey.create(Registries.ENTITY_TYPE, Custard.id(name));
    }
}