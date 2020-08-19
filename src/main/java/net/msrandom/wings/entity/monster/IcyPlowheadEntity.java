package net.msrandom.wings.entity.monster;

import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.AnimalMateGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.ai.pathing.SwimNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.tag.Tag;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RayTraceContext;
import net.minecraft.world.World;
import net.msrandom.wings.WingsSounds;
import net.msrandom.wings.entity.TameableDragonEntity;
import net.msrandom.wings.entity.WingsEntities;
import net.msrandom.wings.entity.item.PlowheadEggEntity;
import net.msrandom.wings.item.WingsItems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IcyPlowheadEntity extends TameableDragonEntity {
    //private static final Ingredient TEMPTATIONS = Ingredient.fromItems(WingsItems.GLISTENING_GLACIAL_SHRIMP);
    private static final EntityDimensions SLEEPING_SIZE = EntityDimensions.changing(1.2f, 0.5f);
    private final Map<Tag<Item>, ItemStack> tools = new HashMap<>();
    private ItemStack horn = ItemStack.EMPTY;
    private BlockPos iceBlock;
    public float pitch;
    private int alarmedTimer;
    private boolean attacking;
    private Vec3d oldPos;
    private int ramTime;
    private BlockPos target;
    private BlockPos sleepTarget;
    private int startedCharging;

	public IcyPlowheadEntity(EntityType<? extends IcyPlowheadEntity> type, World world) {
		super(type, world);
		this.moveControl = new MoveHelperController(this);
		this.setPathfindingPenalty(PathNodeType.WATER, 0.0F);
	}

	@Override
	protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(4, new AnimalMateGoal(this, 1.0D));
        this.goalSelector.add(1, new WanderAroundGoal(this, 1, 40) {
            @Override
            public boolean canStart() {
                return super.canStart() && getState() == WanderState.WANDER && getTarget() == null;
            }
        });
        this.goalSelector.add(9, new LookAroundGoal(this));
    }

    @Override
    public void tick() {
        this.setAir(300);
        super.tick();
    }

    protected EntityNavigation createNavigation(World world) {
        return new SwimNavigation(this, world);
    }

    public static DefaultAttributeContainer.Builder registerPlowheadAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2).add(EntityAttributes.GENERIC_MAX_HEALTH, 30).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3);
    }

    @Override
    public EntityDimensions getDimensions(EntityPose poseIn) {
        return isSleeping() ? SLEEPING_SIZE : super.getDimensions(poseIn);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return isSleeping() ? null : WingsSounds.PLOWHEAD_AMBIENT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return WingsSounds.PLOWHEAD_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return WingsSounds.PLOWHEAD_DEATH;
	}

	@Override
	protected float getSoundVolume() {
		return 0.15f;
	}

	@Override
	public void setTamed(boolean tamed) {
        super.setTamed(tamed);
        this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(tamed ? 44 : 30);
        this.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).setBaseValue(6.0D);
    }

	@Override
	public boolean damage(DamageSource source, float amount) {
		if (source.getAttacker() instanceof LivingEntity && (!(source.getAttacker() instanceof PlayerEntity) || (!isOwner((LivingEntity) source.getAttacker()) && !((PlayerEntity) source.getAttacker()).abilities.creativeMode))) {
			LivingEntity attacker = (LivingEntity) source.getAttacker();
			if (!isBaby() && !isOwner(attacker))
				setTarget(attacker);
		}

		if (isSleeping()) {
			oldPos = getPos();
			alarmedTimer = 200;
		}
		return super.damage(source, amount);
	}

	@Override
	public ActionResult interactMob(PlayerEntity player, Hand hand) {
		ItemStack stack = player.getStackInHand(hand);
		if (!world.isClient && !this.isTamed() && stack.getItem() == WingsItems.GLISTENING_GLACIAL_SHRIMP) {
			if (!player.abilities.creativeMode) stack.decrement(1);
			if (this.random.nextInt(3) == 0) {
                this.setOwner(player);
                this.setTarget(null);
                this.world.sendEntityStatus(this, (byte) 7);
            } else {
				this.world.sendEntityStatus(this, (byte) 6);
			}
		}

		if (stack.getItem() instanceof SpawnEggItem && ((SpawnEggItem) stack.getItem()).isOfSameEntityType(stack.getTag(), this.getType())) {
			if (!this.world.isClient) {
				IcyPlowheadEntity plowhead = WingsEntities.ICY_PLOWHEAD.create(world);
				if (plowhead != null) {
                    plowhead.setBreedingAge(-24000);
                    plowhead.refreshPositionAndAngles(this.getX(), this.getY(), this.getZ(), 0.0F, 0.0F);
                    plowhead.initialize(world, world.getLocalDifficulty(plowhead.getBlockPos()), SpawnReason.SPAWN_EGG, null, null);
                    this.world.spawnEntity(plowhead);
                    if (stack.hasCustomName()) {
                        plowhead.setCustomName(stack.getName());
                    }
                    if (!player.abilities.creativeMode) {
                        stack.decrement(1);
                    }
                }
			}

			return ActionResult.SUCCESS;
		}
		return super.interactMob(player, hand);
	}

	@Override
	public boolean isBreedingItem(ItemStack stack) {
		return stack.getItem() == WingsItems.GLACIAL_SHRIMP;
	}

	@Override
	public void mobTick() {
		if (oldPos != null) {
			setPos(oldPos.x, oldPos.y, oldPos.z);
			oldPos = null;
		}
		if (!isSleeping()) {
            if (this.submergedInWater) {
                this.pitch = (float) MathHelper.clampedLerp(this.pitch, -(this.getVelocity().getY() * 180), MathHelper.sin(age) * 2);
            } else {
                this.pitch = 0;
            }

            if (!world.isClient) {
                if (isTamed()) {
                    if (getState() == WanderState.FOLLOW) {
                        LivingEntity owner = getOwner();
                        if (owner != null) {
							getNavigation().startMovingTo(owner, 0.2);
							if (onGround) {
                                double x = owner.getX() - getX();
                                double z = owner.getZ() - getZ();
                                setVelocity(MathHelper.clamp(x, -0.2, 0.2), 0, MathHelper.clamp(z, -0.2, 0.2));

                                yaw = (float) Math.toDegrees(Math.atan2(z, x) - Math.PI / 2);
                                bodyYaw = yaw;
                            }
						}
					}
				} else {
					LivingEntity attackTarget = getTarget();

					if (attackTarget == null) {
						PlayerEntity player = world.getClosestPlayer(this, 16);
						if (player != null && !player.abilities.creativeMode) {
							setTarget(player);
							attacking = true;
						}
					}

					if (attackTarget != null && attackTarget.isAlive()) {
						getNavigation().startMovingTo(attackTarget, 0.4);
						if (squaredDistanceTo(attackTarget) <= 4) {
							tryAttack(attackTarget);
						}
					} else if (attacking) {
						getNavigation().stop();
						attacking = false;
						setTarget(null);
					}
				}

				if (target != null) {
					if (startedCharging == 0) {
						playSound(WingsSounds.PLOWHEAD_ANGRY, getSoundVolume(), getSoundPitch());
						startedCharging = 120;
                    }
                    getNavigation().startMovingTo(target.getX(), target.getY(), target.getZ(), 0.4);

                    double speed = getVelocity().x * getVelocity().x + getVelocity().y * getVelocity().y + getVelocity().z + getVelocity().z;
                    if (speed > 0.05) {
                        for (Entity entity : world.getEntities(this, getBoundingBox().expand(1), entity -> entity instanceof LivingEntity)) {
                            entity.damage(DamageSource.mob(this), (float) getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).getValue());
                        }
                    }

                    if (horizontalCollision) {
                        breakBlock(new BlockPos(getPos().add(getVelocity())), false);
                        target = null;
                    } else if (squaredDistanceTo(target.getX(), target.getY(), target.getZ()) <= 4) {
                        breakBlock(target, true);
                        startedCharging = 0;
                        target = null;
                    }
                } else {
					if (iceBlock != null) {
						if (startedCharging == 0) {
							playSound(WingsSounds.PLOWHEAD_ANGRY, getSoundVolume(), getSoundPitch());
							startedCharging = 120;
						} else if (startedCharging == 1) {
							iceBlock = null;
							return;
						} else --startedCharging;
						getNavigation().startMovingTo(iceBlock.getX(), iceBlock.getY(), iceBlock.getZ(), 0.4);

						double speed = getVelocity().x * getVelocity().x + getVelocity().y * getVelocity().y + getVelocity().z + getVelocity().z;
						if (speed > 0.05) {
							for (Entity entity : world.getEntities(this, getBoundingBox().expand(1), entity -> entity instanceof LivingEntity)) {
								entity.damage(DamageSource.mob(this), (float) getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).getValue());
							}
						}
						if (iceBlock.getSquaredDistance(getX(), getY(), getZ(), true) <= 4) {
							breakBlock(iceBlock, false);
							iceBlock = null;
							ramTime = random.nextInt(1200) + 1200;
							startedCharging = 0;
						}
					}
				}

				if (alarmedTimer-- <= 0) alarmedTimer = 0;
				if ((ramTime <= 0 || --ramTime == 0) && iceBlock == null && age % 20 == 0) {
					List<BlockPos> possible = new ArrayList<>();
					BlockPos start = getBlockPos();
					Vec3d vec3d = getPos();
					BlockPos.Mutable mutable = new BlockPos.Mutable(start.getX(), start.getY(), start.getZ());
					BlockPos.iterate(start.add(-16, -16, -16), start.add(16, 16, 16)).forEach(pos -> {
						Material material = world.getBlockState(pos).getMaterial();
						if (material == Material.ICE || material == Material.DENSE_ICE) {
                            BlockHitResult rayTrace = this.world.rayTrace(new RayTraceContext(vec3d, new Vec3d(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5), RayTraceContext.ShapeType.COLLIDER, RayTraceContext.FluidHandling.NONE, this));
                            if (rayTrace.getType() != HitResult.Type.MISS && rayTrace.getBlockPos().equals(pos)) {
                                BlockPos.Mutable p = mutable.set(pos);
                                boolean flag = world.getFluidState(p.move(Direction.DOWN)).getFluid() == Fluids.WATER;
                                for (int i = 2; i < Direction.values().length; ++i) {
                                    flag |= world.getFluidState(p.move(Direction.values()[i])).getFluid() == Fluids.WATER;
                                    if (flag) {
                                        possible.add(pos.toImmutable());
                                        break;
                                    }
                                }
                            }
                        }
                    });
                    if (possible.size() > 0)
                        iceBlock = possible.get(random.nextInt(possible.size()));
                }
            }
            super.mobTick();
        } else this.travel(new Vec3d(this.sidewaysSpeed, this.upwardSpeed, this.forwardSpeed));
	}

	@Override
	public boolean isSleeping() {
		if (world.getTimeOfDay() > 13000 && world.getTimeOfDay() < 23000) {
			if (world.getBlockState(new BlockPos(getX(), getY() - 1, getZ())).getBlock() == Blocks.WATER) {
				if (sleepTarget == null) {
					BlockPos p = getBlockPos().add(random.nextInt(64) - 32, -1, random.nextInt(64) - 32);
					while (world.getBlockState(p).getBlock() == Blocks.WATER) {
						p = p.down();
					}
					sleepTarget = p;
				}
				getNavigation().startMovingTo(sleepTarget.getX(), sleepTarget.getY(), sleepTarget.getZ(), 0.2);

				return false;
			}
			return alarmedTimer == 0;
		} else if (sleepTarget != null) {
			sleepTarget = null;
			setVelocity(getVelocity().add(0, 0.2, 0));
		}
		return false;
	}

	private void breakBlock(BlockPos pos, boolean selected) {
        if (submergedInWater) {
            BlockState state = world.getBlockState(pos);
            world.syncWorldEvent(2001, pos, Block.getRawIdFromState(state));
            Material material = state.getMaterial();
            if (material == Material.ICE || material == Material.DENSE_ICE) {
                if (!selected || random.nextBoolean())
                    dropStack(new ItemStack(WingsItems.GLACIAL_SHRIMP), (float) (pos.getY() - getY()));
            } else if (state.isOpaque()) {
                Tag<Item> type = /*state.getHarvestTool()*/ null;
                if (type == null) type = FabricToolTags.PICKAXES;
                ItemStack stack = tools.computeIfAbsent(type, k -> {
                    if (k == FabricToolTags.AXES) return new ItemStack(Items.IRON_AXE);
                    if (k == FabricToolTags.PICKAXES) return new ItemStack(Items.IRON_PICKAXE);
                    if (k == FabricToolTags.SHOVELS) return new ItemStack(Items.IRON_SHOVEL);
                    return ItemStack.EMPTY;
                });
                setupTool(stack);
                if (selected) {
                    for (Map.Entry<Enchantment, Integer> entry : EnchantmentHelper.get(stack).entrySet()) {
                        if (entry.getKey() == Enchantments.EFFICIENCY) {
							List<BlockPos> positions = BlockPos.stream(pos.add(-1, -1, -1), pos.add(1, 1, 1)).map(BlockPos::toImmutable).collect(Collectors.toList());
							int k = 0;
							for (int i = 0; i < entry.getValue(); i++) {
								for (int i1 = k; i1 < positions.size(); i1++) {
									BlockPos p = positions.get(i1);
									if (world.getBlockState(p).isOpaque()) {
										breakBlock(p, false);
										k = i1;
										break;
									}
								}
							}
							break;
						}
					}
				}

				for (ItemStack drop : state.getDroppedStacks(new LootContext.Builder((ServerWorld) world).random(random).parameter(LootContextParameters.POSITION, pos).parameter(LootContextParameters.TOOL, stack))) {
					dropStack(drop, (float) (pos.getY() - getY()));
				}
			}
			world.removeBlock(pos, false);
		}
	}

	private void setupTool(ItemStack stack) {
		if (!horn.isEmpty()) {
			for (Map.Entry<Enchantment, Integer> entry : EnchantmentHelper.get(horn).entrySet())
				stack.addEnchantment(entry.getKey(), entry.getValue());
			horn = ItemStack.EMPTY;
		}
	}

    @Override
    public void createEgg() {
        world.spawnEntity(new PlowheadEggEntity(world, this));
    }

    @Override
    public ItemStack getEgg() {
        return new ItemStack(WingsItems.ICY_PLOWHEAD_EGG);
    }

    public void setHitTarget(HitResult target) {
        if (target.getType() == HitResult.Type.ENTITY) {
            Entity entity = ((EntityHitResult) target).getEntity();
            if (entity instanceof LivingEntity) setTarget((LivingEntity) entity);
        } else if (target.getType() == HitResult.Type.BLOCK) this.target = ((BlockHitResult) target).getBlockPos();
    }

    public void travel(Vec3d p_213352_1_) {
        if (this.canMoveVoluntarily() && this.isSubmergedInWater()) {
            this.updateVelocity(0.1F, p_213352_1_);
            this.move(MovementType.SELF, this.getVelocity());
            this.setVelocity(this.getVelocity().multiply(0.9D));
            if (this.horizontalCollision) {
                this.setVelocity(this.getVelocity().x, 0.1F, this.getVelocity().z);
            }
            if (this.getTarget() == null) {
                this.setVelocity(this.getVelocity().add(0.0D, -0.005D, 0.0D));
            }
        } else {
            super.travel(p_213352_1_);
		}
	}

	public void setHorn(ItemStack horn) {
		this.horn = horn;
	}

	private static class MoveHelperController extends MoveControl {
		private final IcyPlowheadEntity plowhead;

		MoveHelperController(IcyPlowheadEntity plowhead) {
			super(plowhead);
			this.plowhead = plowhead;
		}

		public void tick() {
			this.plowhead.setVelocity(this.plowhead.getVelocity().add(0.0D, 0.005D, 0.0D));
			if (this.state == State.MOVE_TO && !this.plowhead.getNavigation().isIdle()) {
                double d0 = this.targetX - this.plowhead.getX();
                double d1 = this.targetY - this.plowhead.getY();
                double d2 = this.targetZ - this.plowhead.getZ();
                double d3 = MathHelper.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
                d1 = d1 / d3;
                float f = (float) (MathHelper.atan2(d2, d0) * (double) (180F / (float) Math.PI)) - 90.0F;
                this.plowhead.yaw = this.changeAngle(this.plowhead.yaw, f, 90.0F);
                this.plowhead.bodyYaw = this.plowhead.yaw;
                float f1 = (float) (this.speed * this.plowhead.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).getValue());
                this.plowhead.setMovementSpeed(MathHelper.lerp(0.125F, this.plowhead.getMovementSpeed(), f1));
                this.plowhead.setVelocity(this.plowhead.getVelocity().add(MathHelper.clamp(d0, speed / -10, speed / 10), this.plowhead.getMovementSpeed() * d1 * 0.1D, MathHelper.clamp(d2, speed / -10, speed / 10)));
            } else {
                this.plowhead.setMovementSpeed(0.0F);
            }
		}
	}
}
