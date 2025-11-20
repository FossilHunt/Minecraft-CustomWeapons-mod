package net.teunis.customweaponsmod.entity.custom;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.world.BossEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.teunis.customweaponsmod.entity.ai.SlowMeleeAttackGoal;
import net.minecraft.network.chat.Component;

public class RevenantEntity extends Monster {

    private final ServerBossEvent bossEvent;

    public RevenantEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);

        this.bossEvent = new ServerBossEvent(
                this.getDisplayName(),              // Display name for the boss bar
                BossEvent.BossBarColor.RED,         // Color of the bar
                BossEvent.BossBarOverlay.PROGRESS   // Bar style
        );

    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new SlowMeleeAttackGoal(this, 0.8D, false,
                30, 9.0D));

        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.8D));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    @Override
    public void customServerAiStep() {
        super.customServerAiStep();
        // Update boss bar health
        this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
    }

    @Override
    // Show boss bar when player sees the mob
    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        this.bossEvent.addPlayer(player);
    }

    @Override
    // Remove boss bar when player moves away
    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        this.bossEvent.removePlayer(player);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 250D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.ARMOR_TOUGHNESS, 0.5F)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
                .add(Attributes.ATTACK_KNOCKBACK, 1.5F)
                .add(Attributes.ATTACK_DAMAGE, 40)
                .add(Attributes.FOLLOW_RANGE, 25.0D);
    }
}
