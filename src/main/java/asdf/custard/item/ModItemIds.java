package asdf.custard.item;

import asdf.custard.Custard;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class ModItemIds {
    public static final ResourceKey<Item> HARPOON = create("harpoon");
    public static final ResourceKey<Item> SKELETON_VILLAGER_SPAWN_EGG = create("skeleton_villager_spawn_egg");
    public static final ResourceKey<Item> SUNKEN_SPAWN_EGG = create("sunken_spawn_egg");
    public static ResourceKey<Item> create(String name) {
        return ResourceKey.create(Registries.ITEM, Custard.id(name));
    }
}