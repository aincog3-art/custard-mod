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
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.SkullBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.Nullable;

public class VillagerHeadBlock extends SkullBlock {
    protected static final VoxelShape SHAPE_VILLAGER;

    public VillagerHeadBlock(final BlockBehaviour.Properties properties) {
        super(ModSkullType.VILLAGER, properties);
    }

    protected VoxelShape getCollisionShape(final BlockState state, final BlockGetter level, final BlockPos pos, final CollisionContext context) {
        return SHAPE_VILLAGER;
    }

    static {
        SHAPE_VILLAGER = Block.column((double)8.0F, (double)0.0F, (double)10.0F);
    }
}
