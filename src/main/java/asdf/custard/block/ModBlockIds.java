package asdf.custard.block;

import asdf.custard.Custard;
import net.minecraft.core.registries.Registries;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;

public class ModBlockIds {
    public static ResourceKey<Block> GOLDEN_TRAPDOOR = create("golden_trapdoor");
    public static ResourceKey<Block> ILLAGER_WALL_HEAD = create("illager_wall_head");
    public static ResourceKey<Block> VILLAGER_WALL_HEAD = create("villager_wall_head");
    public static ResourceKey<Block> ZOMBIE_VILLAGER_WALL_HEAD = create("zombie_villager_wall_head");
    private static ResourceKey<Block> create(String name) {
        Identifier id = Custard.id(name);
        return ResourceKey.create(Registries.BLOCK, id);
    }
}
