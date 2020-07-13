package net.msrandom.wings.entity.goal;

import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.EntityPredicates;
import net.msrandom.wings.entity.passive.MimangoEntity;

import java.util.function.Predicate;

public class MimangoHangGoal extends Goal {
    private MimangoEntity entity;
    private double playerDistance;
    private EntityPredicate builtPredicate;

    public MimangoHangGoal(MimangoEntity entity, double playerDistance) {
        this.entity = entity;

        this.playerDistance = playerDistance;
        Predicate<LivingEntity> entityPredicate = EntityPredicates.CAN_AI_TARGET::test;
        this.builtPredicate = (new EntityPredicate()).setDistance(playerDistance).setCustomPredicate(entityPredicate.and((entity1) -> {
            return true;
        }));
    }

    @Override
    public boolean shouldExecute() {
        return isPlayerNear() && this.entity.world.getBlockState(this.entity.getPosition().up()).isIn(BlockTags.LEAVES);
    }

    @Override
    public boolean shouldContinueExecuting() {
        return isPlayerNear() && this.entity.world.getBlockState(this.entity.getPosition().up()).isIn(BlockTags.LEAVES);
    }

    @Override
    public void startExecuting() {
        this.entity.setHanging(true);
    }

    @Override
    public void resetTask() {
        this.entity.setHanging(false);
    }

    @Override
    public void tick() {
        this.entity.getNavigator().clearPath();
    }

    private boolean isPlayerNear() {
        return this.entity.world.func_225318_b(PlayerEntity.class, builtPredicate, this.entity, this.entity.getPosX(), this.entity.getPosY(), this.entity.getPosZ(), this.entity.getBoundingBox().grow((double)this.playerDistance, 3.0D, (double)this.playerDistance)) == null;
    }
}