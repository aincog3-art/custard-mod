//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package asdf.custard;

import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.SkullBlock.Type;

public class ModSkullType {
    public static final SkullBlock.Type VILLAGER = new SkullBlock.Type() {
        public String getSerializedName() {
            return "villager";
        }
    };

    public static final SkullBlock.Type ZOMBIE_VILLAGER = new SkullBlock.Type() {
        public String getSerializedName() {
            return "zombie_villager";
        }
    };

    public static final SkullBlock.Type ILLAGER = new SkullBlock.Type() {
        public String getSerializedName() {
            return "illager";
        }
    };

    public ModSkullType() {
    }

    public static void init() {

        Type.TYPES.put(VILLAGER.getSerializedName(), VILLAGER);
        Type.TYPES.put(ZOMBIE_VILLAGER.getSerializedName(), ZOMBIE_VILLAGER);
        Type.TYPES.put(ILLAGER.getSerializedName(), ILLAGER);
    }
}
