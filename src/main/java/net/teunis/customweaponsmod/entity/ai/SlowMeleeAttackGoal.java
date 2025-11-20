package net.teunis.customweaponsmod.entity.ai;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.InteractionHand;

public class SlowMeleeAttackGoal extends Goal {

    private final Monster mob;
    private final double speedModifier;
    private final boolean useLongMemory;
    private final int attackCooldown; // ticks between attacks
    private final double attackReach; // custom attack range
    private int ticksUntilNextAttack = 0;

    public SlowMeleeAttackGoal(Monster mob, double speedModifier, boolean useLongMemory, int attackCooldown, double attackReach) {
        this.mob = mob;
        this.speedModifier = speedModifier;
        this.useLongMemory = useLongMemory;
        this.attackCooldown = attackCooldown;
        this.attackReach = attackReach;
    }

    @Override
    public boolean canUse() {
        return mob.getTarget() != null;
    }

    @Override
    public void tick() {
        LivingEntity target = mob.getTarget();
        if (target == null) return;

        // Make the mob look at the target
        mob.getLookControl().setLookAt(target, 30.0F, 30.0F);

        double distance = mob.distanceToSqr(target);

        // Move towards the target if not in attack range
        if (distance > attackReach) {
            mob.getNavigation().moveTo(target, speedModifier);
        } else {
            mob.getNavigation().stop();
        }

        // Attack if cooldown passed
        if (ticksUntilNextAttack <= 0 && distance <= attackReach) {
            mob.swing(InteractionHand.MAIN_HAND);
            mob.doHurtTarget(target);
            ticksUntilNextAttack = attackCooldown;
        }

        if (ticksUntilNextAttack > 0) {
            ticksUntilNextAttack--;
        }
    }
}
