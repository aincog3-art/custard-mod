package asdf.custard.block;

import asdf.custard.Custard;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Block;

public class ModBlockItemIds {
    public static BlockItemId GOLDEN_BARS = create("golden_bars");
    public static BlockItemId GOLDEN_DOOR = create("golden_door");
    public static BlockItemId GOLDEN_TRAPDOOR = create("golden_trapdoor");
    public static BlockItemId ILLAGER_HEAD = create("illager_head");
    public static BlockItemId VILLAGER_HEAD = create("villager_head");
    public static BlockItemId ZOMBIE_VILLAGER_HEAD = create("zombie_villager_head");
    private static BlockItemId create(String name) {
        Identifier id = Custard.id(name);
        return BlockItemId.create(id, id);
    }
}