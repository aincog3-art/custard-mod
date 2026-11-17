package asdf.custard.entity.projectile;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
import asdf.custard.entity.ModEntities;
import asdf.custard.entity.ModEntityTypeIds;
import asdf.custard.item.ModItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.entity.projectile.arrow.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.Nullable;

public class Harpoon extends AbstractArrow {
    public Harpoon(final EntityType<? extends Harpoon> type, final Level level) {
        super(type, level);
    }
    public Harpoon(final Level level, final LivingEntity owner, final ItemStack pickupItemStack, final @Nullable ItemStack firedFromWeapon) {
        super(ModEntities.HARPOON, owner, level, pickupItemStack, firedFromWeapon);
    }

    public Harpoon(final Level level, final double x, final double y, final double z, final ItemStack pickupItemStack, final @Nullable ItemStack firedFromWeapon) {
        super(ModEntities.HARPOON, x, y, z, level, pickupItemStack, firedFromWeapon);
    }

    @Override
    public boolean isInWaterOrRain() {
        return false;
    }

    @Override
    public boolean isInWater() {
        return false;
    }

    @Override
    protected float getWaterInertia() {
        return this.getAirDrag();
    }
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(ModItems.HARPOON);
    }
}
