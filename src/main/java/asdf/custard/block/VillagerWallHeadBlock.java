//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package asdf.custard.block;
import asdf.custard.ModSkullType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.WallSkullBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Map;

public class VillagerWallHeadBlock extends WallSkullBlock {
    protected static final Map<Direction, VoxelShape> SHAPE_WALL_VILLAGER;

    public VillagerWallHeadBlock(final Properties properties) {
        super(ModSkullType.VILLAGER, properties);
    }

    protected VoxelShape getShape(final BlockState state, final BlockGetter level, final BlockPos pos, final CollisionContext context) {
        return (VoxelShape)SHAPE_WALL_VILLAGER.get(state.getValue(FACING));
    }
    static {
        SHAPE_WALL_VILLAGER = Shapes.rotateHorizontal(Block.boxZ((double)8.0F, (double)4.0F, (double)14.0F, (double)8.0F, (double)16.0F));
    }
}
