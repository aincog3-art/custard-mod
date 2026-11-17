//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package asdf.custard.mixin;

import java.util.Set;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({BlockEntityType.class})
public interface BlockEntityTypeAccessor {
    @Accessor("validBlocks")
    @Mutable
    void setValidBlocks(Set<Block> var1);

    @Accessor("validBlocks")
    Set<Block> getValidBlocks();
}
