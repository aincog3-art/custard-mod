//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package asdf.custard.entity.monster;

import asdf.custard.item.ModItems;
import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.util.Util;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.AmphibiousPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.CrossbowAttackMob;
import net.minecraft.world.entity.monster.illager.AbstractIllager;
import net.minecraft.world.entity.monster.piglin.PiglinArmPose;
import net.minecraft.world.entity.monster.skeleton.AbstractSkeleton;
import net.minecraft.world.entity.monster.zombie.Drowned;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jspecify.annotations.Nullable;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.IntFunction;

public class Sunken extends AbstractSkeleton implements CrossbowAttackMob {
    private static final EntityDataAccessor<Integer> DATA_VARIANT;
    private static final EntityDataAccessor<Boolean> IS_CHARGING_CROSSBOW;
    public Sunken(final EntityType<? extends Sunken> type, final Level level) {
        super(type, level);
        this.setPathfindingMalus(PathType.WATER, 0.0F);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.getAvailableGoals().removeIf(wrappedGoal ->
                wrappedGoal.getGoal() instanceof RangedBowAttackGoal
        );
        this.goalSelector.addGoal(3, new RangedCrossbowAttackGoal<>(this, 1.0F, 8.0F));
    }

    protected boolean canSpawnInLiquids() {
        return true;
    }

    protected void populateDefaultEquipmentSlots(final RandomSource random, final DifficultyInstance difficulty) {
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.CROSSBOW));
    }

    @Override
    public ItemStack getProjectile(ItemStack weaponStack) {
        if (weaponStack.getItem() instanceof net.minecraft.world.item.CrossbowItem) {
            return new ItemStack(ModItems.HARPOON);
        }
        return super.getProjectile(weaponStack);
    }



    public boolean canUseNonMeleeWeapon(final ItemStack item) {
        return item.getItem() == Items.CROSSBOW;
    }

    public boolean isChargingCrossbow() {
        return (Boolean)this.entityData.get(IS_CHARGING_CROSSBOW);
    }

    public void setChargingCrossbow(final boolean isCharging) {
        this.entityData.set(IS_CHARGING_CROSSBOW, isCharging);
    }

    public void onCrossbowAttackPerformed() {
        this.noActionTime = 0;
    }

    public SunkenArmPose getArmPose() {
        if (this.isChargingCrossbow()) {
            return SunkenArmPose.CROSSBOW_CHARGE;
        } else {
            return this.isHolding(Items.CROSSBOW) && CrossbowItem.isCharged(this.getWeaponItem()) ? SunkenArmPose.CROSSBOW_HOLD : SunkenArmPose.DEFAULT;
        }
    }

    protected PathNavigation createNavigation(final Level level) {
        return new AmphibiousPathNavigation(this, level);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.SKELETON_AMBIENT;
    }

    protected SoundEvent getHurtSound(final DamageSource source) {
        return SoundEvents.SKELETON_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.SKELETON_DEATH;
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.SKELETON_STEP;
    }

    public Sunken.Variant getVariant() {
        return Sunken.Variant.byId((Integer)this.entityData.get(DATA_VARIANT));
    }

    private void setVariant(final Sunken.Variant variant) {
        this.entityData.set(DATA_VARIANT, variant.getId());
    }

    protected void defineSynchedData(final SynchedEntityData.Builder entityData) {
        super.defineSynchedData(entityData);
        entityData.define(DATA_VARIANT, 0);
        entityData.define(IS_CHARGING_CROSSBOW,false);
    }

    protected void addAdditionalSaveData(final ValueOutput output) {
        super.addAdditionalSaveData(output);
        output.store("Variant", Sunken.Variant.LEGACY_CODEC, this.getVariant());
    }

    protected void readAdditionalSaveData(final ValueInput input) {
        super.readAdditionalSaveData(input);
        this.setVariant((Sunken.Variant)input.read("Variant", Sunken.Variant.LEGACY_CODEC).orElse(Sunken.Variant.DEFAULT));
    }

    @Override
    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, EntitySpawnReason spawnReason, @Nullable SpawnGroupData groupData) {
        groupData = super.finalizeSpawn(level, difficulty, spawnReason, groupData);
        this.setVariant(Variant.getCommonSpawnVariant(this.random));
        return groupData;
    }

    public void performRangedAttack(final LivingEntity target, final float power) {
        this.performCrossbowAttack(this, 1.6F);
    }

    static {
        DATA_VARIANT = SynchedEntityData.defineId(Sunken.class, EntityDataSerializers.INT);
        IS_CHARGING_CROSSBOW = SynchedEntityData.defineId(Sunken.class, EntityDataSerializers.BOOLEAN);
    }

    public static enum Variant implements StringRepresentable {
        BUBBLE(0, "bubble", true),
        FIRE(1, "fire", true),
        HORN(2, "horn", true);

        public static final Sunken.Variant DEFAULT = BUBBLE;
        private static final IntFunction<Sunken.Variant> BY_ID = ByIdMap.continuous(Sunken.Variant::getId, values(), ByIdMap.OutOfBoundsStrategy.ZERO);
        public static final StreamCodec<ByteBuf, Sunken.Variant> STREAM_CODEC = ByteBufCodecs.idMapper(BY_ID, Sunken.Variant::getId);
        public static final Codec<Sunken.Variant> CODEC = StringRepresentable.fromEnum(Sunken.Variant::values);
        /** @deprecated */
        @Deprecated
        public static final Codec<Sunken.Variant> LEGACY_CODEC;
        private final int id;
        private final String name;
        private final boolean common;

        private Variant(final int id, final String name, final boolean common) {
            this.id = id;
            this.name = name;
            this.common = common;
        }

        public int getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public String getSerializedName() {
            return this.name;
        }

        public static Sunken.Variant byId(final int id) {
            return (Sunken.Variant)BY_ID.apply(id);
        }

        public static Sunken.Variant getCommonSpawnVariant(final RandomSource random) {
            return getSpawnVariant(random, true);
        }

        public static Sunken.Variant getRareSpawnVariant(final RandomSource random) {
            return getSpawnVariant(random, false);
        }

        private static Sunken.Variant getSpawnVariant(final RandomSource random, final boolean common) {
            Sunken.Variant[] validVariants = (Sunken.Variant[]) Arrays.stream(values()).filter((v) -> v.common == common).toArray((x$0) -> new Sunken.Variant[x$0]);
            return (Sunken.Variant) Util.getRandom(validVariants, random);
        }

        static {
            IntFunction<Sunken.Variant> intFunction = BY_ID;
            Objects.requireNonNull(intFunction);
            LEGACY_CODEC = Codec.INT.xmap(intFunction::apply, Sunken.Variant::getId);
        }
    }
}
