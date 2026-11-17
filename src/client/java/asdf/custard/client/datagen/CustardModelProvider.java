package asdf.custard.client.datagen;

import asdf.custard.ModSkullType;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.resources.Identifier;
import asdf.custard.block.ModBlocks;

public class CustardModelProvider extends FabricModelProvider {
    public CustardModelProvider(FabricPackOutput output) {
        super(output);
    }

    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        Identifier defaultHeadItemBase = ModelLocationUtils.decorateItemModelLocation("template_skull");
        blockModelGenerators.createDoor(ModBlocks.GOLDEN_DOOR);
        blockModelGenerators.createTrapdoor(ModBlocks.GOLDEN_TRAPDOOR);
        blockModelGenerators.createHead(ModBlocks.VILLAGER_HEAD, ModBlocks.VILLAGER_WALL_HEAD, ModSkullType.VILLAGER, defaultHeadItemBase);
    }

    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
    }

    public String getName() {
        return "CustardModelProvider";
    }
}
