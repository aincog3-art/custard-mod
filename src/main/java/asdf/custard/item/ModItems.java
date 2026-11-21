package asdf.custard.item;

import asdf.custard.block.ModBlockIds;
import asdf.custard.block.ModBlockItemIds;
import asdf.custard.block.ModBlocks;
import asdf.custard.entity.ModEntities;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.waypoints.Waypoint;

import java.util.function.Function;

public class ModItems {
    public static final Item HARPOON = register(ModItemIds.HARPOON, HarpoonItem::new, new Item.Properties());
    public static final Item SKELETON_VILLAGER_SPAWN_EGG = register(
            ModItemIds.SKELETON_VILLAGER_SPAWN_EGG,
            SpawnEggItem::new,
            new Item.Properties().spawnEgg(ModEntities.SKELETON_VILLAGER)
    );
    public static final Item SUNKEN_SPAWN_EGG = register(
            ModItemIds.SUNKEN_SPAWN_EGG,
            SpawnEggItem::new,
            new Item.Properties().spawnEgg(ModEntities.SUNKEN)
    );

    public static final Item GOLDEN_DOOR = register(
            ModBlockItemIds.GOLDEN_DOOR.item(),
            p -> new BlockItem(
                    ModBlocks.GOLDEN_DOOR,
                    p
            ),
            new Item.Properties()
    );

    public static final Item GOLDEN_TRAPDOOR = register(
            ModBlockItemIds.GOLDEN_TRAPDOOR.item(),
            p -> new BlockItem(
                    ModBlocks.GOLDEN_TRAPDOOR,
                    p
            ),
            new Item.Properties()
    );

    public static final Item GOLDEN_BARS = register(
            ModBlockItemIds.GOLDEN_BARS.item(),
            p -> new BlockItem(
                    ModBlocks.GOLDEN_BARS,
                    p
            ),
            new Item.Properties()
    );


    public static final Item ILLAGER_HEAD = register(
            ModBlockItemIds.ILLAGER_HEAD.item(),
            p -> new StandingAndWallBlockItem(
                    ModBlocks.ILLAGER_HEAD,
                    ModBlocks.ILLAGER_WALL_HEAD,
                    Direction.DOWN,
                    Waypoint.addHideAttribute(p)
            ),
            (new Item.Properties()).rarity(Rarity.UNCOMMON).equippableUnswappable(EquipmentSlot.HEAD)
    );

    public static final Item VILLAGER_HEAD = register(
            ModBlockItemIds.VILLAGER_HEAD.item(),
            p -> new StandingAndWallBlockItem(
                    ModBlocks.VILLAGER_HEAD,
                    ModBlocks.VILLAGER_WALL_HEAD,
                    Direction.DOWN,
                    Waypoint.addHideAttribute(p)
            ),
            (new Item.Properties()).rarity(Rarity.UNCOMMON).equippableUnswappable(EquipmentSlot.HEAD)
    );

    public static final Item ZOMBIE_VILLAGER_HEAD = register(
            ModBlockItemIds.ZOMBIE_VILLAGER_HEAD.item(),
            p -> new StandingAndWallBlockItem(
                    ModBlocks.ZOMBIE_VILLAGER_HEAD,
                    ModBlocks.ZOMBIE_VILLAGER_WALL_HEAD,
                    Direction.DOWN,
                    Waypoint.addHideAttribute(p)
            ),
            (new Item.Properties()).rarity(Rarity.UNCOMMON).equippableUnswappable(EquipmentSlot.HEAD)
    );


    public static Item register(ResourceKey<Item> itemKey, Function<Item.Properties, Item> itemFactory, Item.Properties settings) {
        Item item = itemFactory.apply(settings.setId(itemKey));

        Registry.register(BuiltInRegistries.ITEM, itemKey, item);
        return item;
    }
    public static void initialize() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.SPAWN_EGGS).register(creativeTab -> {
            creativeTab.accept(ModItems.SKELETON_VILLAGER_SPAWN_EGG);
        });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.SPAWN_EGGS).register(creativeTab -> {
            creativeTab.accept(ModItems.SUNKEN_SPAWN_EGG);
        });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(creativeTab -> {
            creativeTab.accept(ModItems.ILLAGER_HEAD);
        });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(creativeTab -> {
            creativeTab.accept(ModItems.VILLAGER_HEAD);
        });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(creativeTab -> {
            creativeTab.accept(ModItems.ZOMBIE_VILLAGER_HEAD);
        });
    }
}