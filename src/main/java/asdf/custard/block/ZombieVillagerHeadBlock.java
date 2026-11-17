//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package asdf.custard.block;

import asdf.custard.ModSkullType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import asdf.custard.block.VillagerHeadBlock;

public class ZombieVillagerHeadBlock extends SkullBlock {

    public ZombieVillagerHeadBlock(final Properties properties) {

        super(ModSkullType.ZOMBIE_VILLAGER, properties);
    }

    protected VoxelShape getCollisionShape(final BlockState state, final BlockGetter level, final BlockPos pos, final CollisionContext context) {
        return VillagerHeadBlock.SHAPE_VILLAGER;
    }
}
