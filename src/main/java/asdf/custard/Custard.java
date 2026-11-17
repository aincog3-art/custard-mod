package asdf.custard;

import asdf.custard.block.ModBlocks;
import asdf.custard.entity.ModEntities;
import asdf.custard.item.ModItems;
import asdf.custard.mixin.BlockEntityTypeAccessor;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.entity.BlockEntityType;


import net.minecraft.world.level.block.entity.BlockEntityTypeIds;
import net.minecraft.world.level.block.entity.BlockEntityTypes;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class Custard implements ModInitializer {
	public static final String MOD_ID = "custard";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModEntities.registerModEntityTypes();

		ModEntities.registerAttributes();
		ModItems.initialize();
		ModBlocks.initialize();
		((BlockEntityTypeAccessor)BlockEntityTypes.SKULL).getValidBlocks().addAll(
				Set.of(
						ModBlocks.VILLAGER_HEAD,
						ModBlocks.VILLAGER_WALL_HEAD,
						ModBlocks.ZOMBIE_VILLAGER_HEAD,
						ModBlocks.ZOMBIE_VILLAGER_WALL_HEAD,
						ModBlocks.ILLAGER_HEAD,
						ModBlocks.ILLAGER_WALL_HEAD
				)
		);
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
