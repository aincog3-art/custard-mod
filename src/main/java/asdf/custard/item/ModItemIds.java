package asdf.custard.item;

import asdf.custard.Custard;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class ModItemIds {
    public static final ResourceKey<Item> HARPOON = create("harpoon");
    public static ResourceKey<Item> create(String name) {
        return ResourceKey.create(Registries.ITEM, Custard.id(name));
    }
}