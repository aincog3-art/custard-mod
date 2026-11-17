package asdf.custard.block;

import asdf.custard.Custard;
import asdf.custard.item.ModItems;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.waypoints.Waypoint;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ModBlocks {
    public static final BlockSetTypeBuilder METAL_DOOR;
    public static final BlockSetTypeBuilder WOODEN_DOOR;
    static {
        METAL_DOOR = new BlockSetTypeBuilder();
        WOODEN_DOOR = new BlockSetTypeBuilder();
    }

    private static Block register(BlockItemId id, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
        Block block = register(id.block(), blockFactory, properties);
        BlockItem blockItem = new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix().setId(id.item()));
        Registry.register(BuiltInRegistries.ITEM, id.item(), blockItem);

        return block;
    }

    public static BlockSetType registerDoorBlockSet(BlockBehaviour.BlockStateBase block, Boolean isMetal) {
        if (isMetal) {
            METAL_DOOR.openableByHand(false).openableByWindCharge(false).soundType(block.getSoundType()).doorCloseSound(SoundEvents.IRON_DOOR_CLOSE).doorOpenSound(SoundEvents.IRON_DOOR_OPEN).trapdoorCloseSound(SoundEvents.IRON_TRAPDOOR_CLOSE).trapdoorOpenSound(SoundEvents.IRON_TRAPDOOR_OPEN);
            return METAL_DOOR.register(Identifier.fromNamespaceAndPath("custard", "blockset_metal"));
        } else {
            WOODEN_DOOR.openableByHand(true).openableByWindCharge(true).soundType(block.getSoundType()).doorCloseSound(SoundEvents.WOODEN_DOOR_CLOSE).doorOpenSound(SoundEvents.WOODEN_DOOR_OPEN).trapdoorCloseSound(SoundEvents.WOODEN_TRAPDOOR_CLOSE).trapdoorOpenSound(SoundEvents.WOODEN_TRAPDOOR_OPEN);
            return WOODEN_DOOR.register(Identifier.fromNamespaceAndPath("custard", "blockset_woood"));
        }
    }
    private static Block register(ResourceKey<Block> id, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
        Block block = blockFactory.apply(properties.setId(id));

        return Registry.register(BuiltInRegistries.BLOCK, id, block);
    }

    private static ResourceKey<Block> create(String name) {
        Identifier id = Custard.id(name);
        return ResourceKey.create(Registries.BLOCK, id);
    }
    public static void initialize() {
    }

    public static final Block GOLDEN_DOOR = register(
            ModBlockItemIds.GOLDEN_DOOR.block(),
            properties -> new CustomDoorBlock(
                    registerDoorBlockSet(Blocks.GOLD_BLOCK.defaultBlockState(), true),
                    BlockBehaviour.Properties
                                        .ofFullCopy(Blocks.GOLD_BLOCK)
                                        .setId(ModBlockItemIds.GOLDEN_DOOR.block())),
            BlockBehaviour.Properties.of()
    );

    public static final Block GOLDEN_TRAPDOOR = register(
            ModBlockIds.GOLDEN_TRAPDOOR,
            properties -> new CustomTrapDoorBlock(
                    registerDoorBlockSet(Blocks.GOLD_BLOCK.defaultBlockState(), true),
                    BlockBehaviour.Properties
                            .ofFullCopy(Blocks.GOLD_BLOCK)
                            .setId(ModBlockIds.GOLDEN_TRAPDOOR)),
            BlockBehaviour.Properties.of()
    );

    public static final Block VILLAGER_HEAD = register(
            ModBlockItemIds.VILLAGER_HEAD.block(),
            VillagerHeadBlock::new,
            BlockBehaviour.Properties.of()
    );

    public static final Block VILLAGER_WALL_HEAD = register(
            ModBlockIds.VILLAGER_WALL_HEAD,
            VillagerWallHeadBlock::new,
            BlockBehaviour.Properties.of()
    );

    public static final Block ZOMBIE_VILLAGER_HEAD = register(
            ModBlockItemIds.ZOMBIE_VILLAGER_HEAD.block(),
            ZombieVillagerHeadBlock::new,
            BlockBehaviour.Properties.of()
    );

    public static final Block ZOMBIE_VILLAGER_WALL_HEAD = register(
            ModBlockIds.ZOMBIE_VILLAGER_WALL_HEAD,
            ZombieVillagerWallHeadBlock::new,
            BlockBehaviour.Properties.of()
    );

    public static final Block ILLAGER_HEAD = register(
            ModBlockItemIds.ILLAGER_HEAD.block(),
            IllagerHeadBlock::new,
            BlockBehaviour.Properties.of()
    );

    public static final Block ILLAGER_WALL_HEAD = register(
            ModBlockIds.ILLAGER_WALL_HEAD,
            IllagerWallHeadBlock::new,
            BlockBehaviour.Properties.of()
    );
}
