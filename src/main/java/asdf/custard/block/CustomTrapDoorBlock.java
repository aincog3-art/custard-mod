//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package asdf.custard.block;

import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class CustomTrapDoorBlock extends TrapDoorBlock {

    public CustomTrapDoorBlock(final BlockSetType type, final Properties properties) {
        super(type, properties.sound(type.soundType()));
    }
}
