package net.msrandom.wings.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.msrandom.wings.entity.passive.HatchetBeakEntity;

public abstract class HatchetBeakModel extends SegmentedModel<HatchetBeakEntity> {
    public ModelRenderer body;
    public ModelRenderer neck1;
    public ModelRenderer thighLeft;
    public ModelRenderer thighRight;
    public ModelRenderer hips;
    public ModelRenderer wingRightBone1;
    public ModelRenderer wingLeftBone1;
    public ModelRenderer neck2;
    public ModelRenderer head;
    public ModelRenderer mouth;
    public ModelRenderer jaw;
    public ModelRenderer beakTop;
    public ModelRenderer beakBottom;
    public ModelRenderer legLeft;
    public ModelRenderer legRight;
    public ModelRenderer tail1;
    public ModelRenderer tail2;
    public ModelRenderer tailLeft;
    public ModelRenderer tailRight;
    public ModelRenderer tailTip;
    public ModelRenderer wingRightBone2;
    public ModelRenderer wingRightSkin1;
    public ModelRenderer wingRightSkin1_1;
    public ModelRenderer wingLeftBone2;
    public ModelRenderer wingLeftSkin1;
    public ModelRenderer wingLeftSkin2;

    public ModelRenderer bodyBaby;
    public ModelRenderer neck1Baby;
    public ModelRenderer thighLeftBaby;
    public ModelRenderer thighRightBaby;
    public ModelRenderer hipsBaby;
    public ModelRenderer wingRightBone1Baby;
    public ModelRenderer wingLeftBone1Baby;
    public ModelRenderer neck2Baby;
    public ModelRenderer headBaby;
    public ModelRenderer mouthBaby;
    public ModelRenderer jawBaby;
    public ModelRenderer beakTopBaby;
    public ModelRenderer beakBottomBaby;
    public ModelRenderer legLeftBaby;
    public ModelRenderer legRightBaby;
    public ModelRenderer tail1Baby;
    public ModelRenderer tail2Baby;
    public ModelRenderer tailLeftBaby;
    public ModelRenderer tailRightBaby;
    public ModelRenderer tailTipBaby;
    public ModelRenderer wingRightBone2Baby;
    public ModelRenderer wingRightSkin1Baby;
    public ModelRenderer wingRightSkin1_1Baby;
    public ModelRenderer wingLeftBone2Baby;
    public ModelRenderer wingLeftSkin1Baby;
    public ModelRenderer wingLeftSkin2Baby;

    @Override
    public Iterable<ModelRenderer> getParts() {
        if(!this.isChild) {
            return ImmutableList.of(body);
        } else {
            return ImmutableList.of(bodyBaby);
        }
    }

    @Override
    public void setRotationAngles(HatchetBeakEntity entityIn, float f, float f1, float ageInTicks, float netHeadYaw, float headPitch) {
        float speed = 1.0f;
        float degree = 1.0f;
        if(!entityIn.isChild()) {
            if (entityIn.isFlying()) {
                this.body.rotationPointY = MathHelper.cos((f * speed * 0.4F) + (float) Math.PI) * (degree * 0.1F) * f1 * 0.5F;
                this.neck1.rotationPointY = MathHelper.cos((f * speed * 0.4F) + (float) Math.PI) * (degree * 0.1F) * f1 * 0.5F;
                this.neck2.rotationPointY = MathHelper.cos((f * speed * 0.4F) + (float) Math.PI) * (degree * 0.1F) * f1 * 0.5F;
                this.head.rotationPointY = MathHelper.cos((f * speed * 0.4F) + (float) Math.PI) * (degree * 0.1F) * f1 * 0.5F;
                this.hips.rotationPointY = MathHelper.cos((f * speed * 0.4F) + (float) Math.PI) * (degree * 0.1F) * f1 * 0.5F;
                this.tail1.rotationPointY = MathHelper.cos((f * speed * 0.4F) + (float) Math.PI) * (degree * 0.1F) * f1 * 0.5F;
                this.tail2.rotationPointY = MathHelper.cos((f * speed * 0.4F) + (float) Math.PI) * (degree * 0.1F) * f1 * 0.5F;
                this.tailLeft.rotateAngleZ = MathHelper.cos((f * speed * 0.0F) + (float) Math.PI) * (degree * 0.0F) * f1 * 0.5F + 0.2F;
                this.tailRight.rotateAngleZ = MathHelper.cos((f * speed * 0.0F) + (float) Math.PI) * (degree * 0.0F) * f1 * 0.5F + -0.2F;
                this.thighLeft.rotateAngleX = MathHelper.cos((f * speed * 0.0F) + (float) Math.PI) * (degree * 0.0F) * f1 * 0.5F + 1.2F;
                this.thighLeft.rotationPointY = MathHelper.cos((f * speed * 0.4F) + (float) Math.PI) * (degree * 0.1F) * f1 * 0.5F + 0.15F;
                this.thighRight.rotationPointY = MathHelper.cos((f * speed * 0.4F) + (float) Math.PI) * (degree * 0.1F) * f1 * 0.5F + 0.15F;
                this.thighRight.rotateAngleX = MathHelper.cos((f * speed * 0.0F) + (float) Math.PI) * (degree * 0.0F) * f1 * 0.5F + 1.2F;
                this.wingRightBone1.rotateAngleZ = MathHelper.cos((f * speed * 0.4F) + (float) Math.PI) * (degree * 0.9F) * f1 * 0.5F;
                this.wingRightBone2.rotateAngleZ = MathHelper.cos((f * speed * 0.4F) + (float) Math.PI) * (degree * 1.2F) * f1 * 0.5F;
                this.wingLeftBone1.rotateAngleZ = MathHelper.cos((f * speed * 0.4F) + (float) Math.PI) * (degree * -0.9F) * f1 * 0.5F;
                this.wingLeftBone2.rotateAngleZ = MathHelper.cos((f * speed * 0.4F) + (float) Math.PI) * (degree * -1.2F) * f1 * 0.5F;
            } else {
                this.wingRightBone1.rotateAngleZ = MathHelper.cos((f * speed * 0.0F) + (float) Math.PI) * (degree * 0.0F) * f1 * 0.5F + -0.85F;
                this.wingRightBone2.rotateAngleZ = MathHelper.cos((f * speed * 0.0F) + (float) Math.PI) * (degree * 0.0F) * f1 * 0.5F + 1.7F;
                this.wingLeftBone1.rotateAngleZ = MathHelper.cos((f * speed * 0.0F) + (float) Math.PI) * (degree * 0.0F) * f1 * 0.5F + 0.85F;
                this.wingLeftBone2.rotateAngleZ = MathHelper.cos((f * speed * 0.0F) + (float) Math.PI) * (degree * 0.0F) * f1 * 0.5F + -1.7F;
                this.thighLeft.rotateAngleX = MathHelper.cos((f * speed * 0.4F) + (float) Math.PI) * (degree * 1.2F) * f1 * 0.5F;
                this.thighRight.rotateAngleX = MathHelper.cos((f * speed * 0.4F) + (float) Math.PI) * (degree * -1.2F) * f1 * 0.5F;
                this.tail1.rotateAngleX = MathHelper.cos((f * speed * 0.4F) + (float) Math.PI) * (degree * 0.15F) * f1 * 0.5F + 0.2F;
                this.hips.rotateAngleX = MathHelper.cos((f * speed * 0.4F) + (float) Math.PI) * (degree * 0.1F) * f1 * 0.5F + -0.35F;
                this.tail2.rotateAngleX = MathHelper.cos((f * speed * 0.4F) + (float) Math.PI) * (degree * 0.2F) * f1 * 0.5F + 0.2F;
                this.wingRightBone1.rotateAngleY = MathHelper.cos((f * speed * 0.4F) + (float) Math.PI) * (degree * 0.4F) * f1 * 0.5F;
                this.wingLeftBone1.rotateAngleY = MathHelper.cos((f * speed * 0.4F) + (float) Math.PI) * (degree * 0.4F) * f1 * 0.5F;
                this.body.rotationPointY = MathHelper.cos((f * speed * 0.4F) + (float) Math.PI) * (degree * 0.2F) * f1 * 0.5F;
                this.wingLeftBone1.rotationPointY = MathHelper.cos((f * speed * 0.4F) + (float) Math.PI) * (degree * -0.2F) * f1 * 0.5F;
                this.wingRightBone1.rotationPointY = MathHelper.cos((f * speed * 0.4F) + (float) Math.PI) * (degree * -0.2F) * f1 * 0.5F;
                this.thighLeft.rotationPointY = MathHelper.cos((f * speed * 0.4F) + (float) Math.PI) * (degree * -0.2F) * f1 * 0.5F;
                this.thighRight.rotationPointY = MathHelper.cos((f * speed * 0.4F) + (float) Math.PI) * (degree * -0.2F) * f1 * 0.5F;
                this.neck1.rotateAngleX = MathHelper.cos((f * speed * 0.4F) + (float) Math.PI) * (degree * 0.2F) * f1 * 0.5F + -0.4F;
                this.neck2.rotateAngleX = MathHelper.cos((f * speed * 0.4F) + (float) Math.PI) * (degree * 0.2F) * f1 * 0.5F + 0.1F;
                this.head.rotateAngleX = MathHelper.cos((f * speed * 0.4F) + (float) Math.PI) * (degree * 0.2F) * f1 * 0.5F + 0.5F;
            }
        } else {

        }
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    public static class Adult extends HatchetBeakModel {
        public Adult() {
            this.textureWidth = 256;
            this.textureHeight = 256;
            this.tail1 = new ModelRenderer(this, 102, 52);
            this.tail1.setRotationPoint(0.0F, -0.5F, 26.0F);
            this.tail1.addBox(-4.0F, -5.0F, 0.0F, 8.0F, 10.0F, 26.0F, 0.0F, 0.0F, 0.0F);
            this.wingRightSkin1_1 = new ModelRenderer(this, 0, 150);
            this.wingRightSkin1_1.mirror = true;
            this.wingRightSkin1_1.setRotationPoint(0.0F, 0.0F, 0.0F);
            this.wingRightSkin1_1.addBox(-44.0F, 0.0F, 2.0F, 44.0F, 0.0F, 44.0F, 0.0F, 0.0F, 0.0F);
            this.mouth = new ModelRenderer(this, 184, 40);
            this.mouth.setRotationPoint(0.0F, 1.0F, -11.0F);
            this.mouth.addBox(-2.5F, -4.0F, -12.0F, 5.0F, 4.0F, 12.0F, 0.0F, 0.0F, 0.0F);
            this.tailLeft = new ModelRenderer(this, 0, 66);
            this.tailLeft.mirror = true;
            this.tailLeft.setRotationPoint(2.0F, 0.0F, 25.0F);
            this.tailLeft.addBox(0.0F, 0.0F, -8.0F, 10.0F, 1.0F, 16.0F, 0.0F, 0.0F, 0.0F);
            this.wingRightSkin1 = new ModelRenderer(this, 0, 100);
            this.wingRightSkin1.mirror = true;
            this.wingRightSkin1.setRotationPoint(0.0F, 0.0F, 1.0F);
            this.wingRightSkin1.addBox(-44.0F, 0.0F, 2.0F, 44.0F, 0.0F, 44.0F, 0.0F, 0.0F, 0.0F);
            this.neck2 = new ModelRenderer(this, 196, 0);
            this.neck2.setRotationPoint(0.0F, -1.0F, -13.0F);
            this.neck2.addBox(-4.0F, -4.0F, -13.0F, 8.0F, 8.0F, 13.0F, 0.0F, 0.0F, 0.0F);
            this.jaw = new ModelRenderer(this, 0, 0);
            this.jaw.setRotationPoint(0.0F, 1.0F, -11.0F);
            this.jaw.addBox(-1.5F, 0.0F, -11.0F, 3.0F, 3.0F, 11.0F, 0.0F, 0.0F, 0.0F);
            this.wingLeftSkin2 = new ModelRenderer(this, 0, 150);
            this.wingLeftSkin2.setRotationPoint(0.0F, 0.0F, 0.0F);
            this.wingLeftSkin2.addBox(0.0F, 0.0F, 2.0F, 44.0F, 0.0F, 44.0F, 0.0F, 0.0F, 0.0F);
            this.legLeft = new ModelRenderer(this, 222, 46);
            this.legLeft.mirror = true;
            this.legLeft.setRotationPoint(3.5F, 14.0F, 0.5F);
            this.legLeft.addBox(-2.5F, -1.0F, -3.5F, 5.0F, 16.0F, 9.0F, 0.0F, 0.0F, 0.0F);
            this.legRight = new ModelRenderer(this, 222, 46);
            this.legRight.setRotationPoint(-3.5F, 14.0F, 0.5F);
            this.legRight.addBox(-2.5F, -1.0F, -3.5F, 5.0F, 16.0F, 9.0F, 0.0F, 0.0F, 0.0F);
            this.tailRight = new ModelRenderer(this, 0, 66);
            this.tailRight.setRotationPoint(-2.0F, 0.0F, 25.0F);
            this.tailRight.addBox(-10.0F, 0.0F, -8.0F, 10.0F, 1.0F, 16.0F, 0.0F, 0.0F, 0.0F);
            this.wingLeftBone2 = new ModelRenderer(this, 0, 83);
            this.wingLeftBone2.setRotationPoint(44.0F, 0.0F, 0.0F);
            this.wingLeftBone2.addBox(0.0F, -2.0F, -3.0F, 44.0F, 4.0F, 6.0F, 0.0F, 0.0F, 0.0F);
            this.body = new ModelRenderer(this, 0, 0);
            this.body.setRotationPoint(0.0F, -4.0F, -7.0F);
            this.body.addBox(-7.0F, -9.0F, -13.0F, 14.0F, 16.0F, 32.0F, 0.0F, 0.0F, 0.0F);
            this.wingRightBone2 = new ModelRenderer(this, 0, 83);
            this.wingRightBone2.setRotationPoint(-44.0F, 0.0F, 0.0F);
            this.wingRightBone2.addBox(-44.0F, -2.0F, -3.0F, 44.0F, 4.0F, 6.0F, 0.0F, 0.0F, 0.0F);
            this.tailTip = new ModelRenderer(this, 10, 19);
            this.tailTip.setRotationPoint(0.0F, -1.0F, 26.0F);
            this.tailTip.addBox(-1.5F, 0.0F, 0.0F, 3.0F, 4.0F, 8.0F, 0.0F, 0.0F, 0.0F);
            this.setRotateAngle(tailTip, -0.3490658503988659F, 0.0F, 0.0F);
            this.head = new ModelRenderer(this, 211, 27);
            this.head.setRotationPoint(0.0F, -0.1F, -12.0F);
            this.head.addBox(-4.5F, -4.0F, -11.0F, 9.0F, 8.0F, 11.0F, 0.0F, 0.0F, 0.0F);
            this.wingLeftBone1 = new ModelRenderer(this, 0, 52);
            this.wingLeftBone1.setRotationPoint(5.0F, -5.0F, -8.0F);
            this.wingLeftBone1.addBox(0.0F, -3.0F, -4.0F, 44.0F, 6.0F, 8.0F, 0.0F, 0.0F, 0.0F);
            this.tail2 = new ModelRenderer(this, 170, 57);
            this.tail2.setRotationPoint(0.0F, -0.5F, 26.0F);
            this.tail2.addBox(-3.0F, -4.0F, 0.0F, 6.0F, 8.0F, 26.0F, 0.0F, 0.0F, 0.0F);
            this.beakTop = new ModelRenderer(this, 228, 11);
            this.beakTop.setRotationPoint(0.0F, -4.0F, -12.0F);
            this.beakTop.addBox(-0.5F, -6.0F, 0.0F, 1.0F, 6.0F, 10.0F, 0.0F, 0.0F, 0.0F);
            this.setRotateAngle(beakTop, -0.17453292519943295F, 0.0F, 0.0F);
            this.beakBottom = new ModelRenderer(this, 0, 14);
            this.beakBottom.setRotationPoint(0.0F, 3.0F, -11.0F);
            this.beakBottom.addBox(-0.5F, 0.0F, 0.0F, 1.0F, 5.0F, 8.0F, 0.0F, 0.0F, 0.0F);
            this.setRotateAngle(beakBottom, 0.17453292519943295F, 0.0F, 0.0F);
            this.hips = new ModelRenderer(this, 150, 0);
            this.hips.setRotationPoint(0.0F, -2.5F, 19.0F);
            this.hips.addBox(-5.0F, -6.0F, 0.0F, 10.0F, 12.0F, 26.0F, 0.0F, 0.0F, 0.0F);
            this.wingLeftSkin1 = new ModelRenderer(this, 0, 100);
            this.wingLeftSkin1.setRotationPoint(0.0F, 0.0F, 1.0F);
            this.wingLeftSkin1.addBox(0.0F, 0.0F, 2.0F, 44.0F, 0.0F, 44.0F, 0.0F, 0.0F, 0.0F);
            this.neck1 = new ModelRenderer(this, 60, 0);
            this.neck1.setRotationPoint(0.0F, -2.0F, -12.0F);
            this.neck1.addBox(-5.0F, -6.0F, -14.0F, 10.0F, 12.0F, 14.0F, 0.0F, 0.0F, 0.0F);
            this.thighLeft = new ModelRenderer(this, 108, 0);
            this.thighLeft.mirror = true;
            this.thighLeft.setRotationPoint(1.0F, -1.0F, 12.0F);
            this.thighLeft.addBox(0.0F, -1.0F, -6.0F, 7.0F, 14.0F, 12.0F, 0.0F, 0.0F, 0.0F);
            this.thighRight = new ModelRenderer(this, 108, 0);
            this.thighRight.setRotationPoint(-1.0F, -1.0F, 12.0F);
            this.thighRight.addBox(-7.0F, -1.0F, -6.0F, 7.0F, 14.0F, 12.0F, 0.0F, 0.0F, 0.0F);
            this.wingRightBone1 = new ModelRenderer(this, 0, 52);
            this.wingRightBone1.mirror = true;
            this.wingRightBone1.setRotationPoint(-5.0F, -5.0F, -8.0F);
            this.wingRightBone1.addBox(-44.0F, -3.0F, -4.0F, 44.0F, 6.0F, 8.0F, 0.0F, 0.0F, 0.0F);
            this.hips.addChild(this.tail1);
            this.wingRightBone2.addChild(this.wingRightSkin1_1);
            this.head.addChild(this.mouth);
            this.tail2.addChild(this.tailLeft);
            this.wingRightBone1.addChild(this.wingRightSkin1);
            this.neck1.addChild(this.neck2);
            this.head.addChild(this.jaw);
            this.wingLeftBone2.addChild(this.wingLeftSkin2);
            this.thighLeft.addChild(this.legLeft);
            this.thighRight.addChild(this.legRight);
            this.tail2.addChild(this.tailRight);
            this.wingLeftBone1.addChild(this.wingLeftBone2);
            this.wingRightBone1.addChild(this.wingRightBone2);
            this.tail2.addChild(this.tailTip);
            this.neck2.addChild(this.head);
            this.body.addChild(this.wingLeftBone1);
            this.tail1.addChild(this.tail2);
            this.mouth.addChild(this.beakTop);
            this.jaw.addChild(this.beakBottom);
            this.body.addChild(this.hips);
            this.wingLeftBone1.addChild(this.wingLeftSkin1);
            this.body.addChild(this.neck1);
            this.body.addChild(this.thighLeft);
            this.body.addChild(this.thighRight);
            this.body.addChild(this.wingRightBone1);
        }
    }

    public static class Child extends HatchetBeakModel {
        public Child() {
            this.textureWidth = 128;
            this.textureHeight = 128;
            this.thighRightBaby = new ModelRenderer(this, 60, 0);
            this.thighRightBaby.setRotationPoint(-0.5F, 2.0F, 3.0F);
            this.thighRightBaby.addBox(-5.0F, -1.0F, -3.5F, 5.0F, 8.0F, 7.0F, 0.0F, 0.0F, 0.0F);
            this.wingLeftBone1Baby = new ModelRenderer(this, 0, 32);
            this.wingLeftBone1Baby.setRotationPoint(3.0F, -2.0F, -5.0F);
            this.wingLeftBone1Baby.addBox(0.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, 0.0F, 0.0F, 0.0F);
            this.tailRightBaby = new ModelRenderer(this, 64, 41);
            this.tailRightBaby.setRotationPoint(-1.0F, 0.0F, 25.0F);
            this.tailRightBaby.addBox(-6.0F, 0.0F, -5.0F, 6.0F, 1.0F, 10.0F, 0.0F, 0.0F, 0.0F);
            this.jawBaby = new ModelRenderer(this, 89, 37);
            this.jawBaby.setRotationPoint(0.0F, 0.4F, -8.0F);
            this.jawBaby.addBox(-1.5F, 0.0F, -6.5F, 3.0F, 2.0F, 7.0F, 0.0F, 0.0F, 0.0F);
            this.wingLeftSkin1Baby = new ModelRenderer(this, -20, 70);
            this.wingLeftSkin1Baby.setRotationPoint(0.0F, 0.0F, 0.0F);
            this.wingLeftSkin1Baby.addBox(0.0F, 0.0F, 2.0F, 24.0F, 0.0F, 24.0F, 0.0F, 0.0F, 0.0F);
            this.wingRightBone1Baby = new ModelRenderer(this, 0, 32);
            this.wingRightBone1Baby.setRotationPoint(-3.0F, -2.0F, -5.0F);
            this.wingRightBone1Baby.addBox(-24.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, 0.0F, 0.0F, 0.0F);
            this.wingLeftSkin2Baby = new ModelRenderer(this, -20, 100);
            this.wingLeftSkin2Baby.setRotationPoint(0.0F, 0.0F, -1.0F);
            this.wingLeftSkin2Baby.addBox(0.0F, 0.0F, 2.0F, 24.0F, 0.0F, 24.0F, 0.0F, 0.0F, 0.0F);
            this.wingRightSkin1_1Baby = new ModelRenderer(this, -20, 100);
            this.wingRightSkin1_1Baby.mirror = true;
            this.wingRightSkin1_1Baby.setRotationPoint(0.0F, 0.0F, -1.0F);
            this.wingRightSkin1_1Baby.addBox(-24.0F, 0.0F, 2.0F, 24.0F, 0.0F, 24.0F, 0.0F, 0.0F, 0.0F);
            this.mouthBaby = new ModelRenderer(this, 74, 32);
            this.mouthBaby.setRotationPoint(0.0F, 0.5F, -8.0F);
            this.mouthBaby.addBox(-2.0F, -2.0F, -7.0F, 4.0F, 2.0F, 7.0F, 0.0F, 0.0F, 0.0F);
            this.wingLeftBone2Baby = new ModelRenderer(this, 48, 57);
            this.wingLeftBone2Baby.setRotationPoint(24.0F, 0.0F, 0.0F);
            this.wingLeftBone2Baby.addBox(0.0F, -1.5F, -1.5F, 24.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
            this.tail1Baby = new ModelRenderer(this, 0, 40);
            this.tail1Baby.setRotationPoint(0.0F, 0.0F, 18.0F);
            this.tail1Baby.addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 18.0F, 0.0F, 0.0F, 0.0F);
            this.legLeftBaby = new ModelRenderer(this, 111, 32);
            this.legLeftBaby.mirror = true;
            this.legLeftBaby.setRotationPoint(2.5F, 8.0F, 1.0F);
            this.legLeftBaby.addBox(-1.5F, -1.0F, -2.5F, 3.0F, 10.0F, 5.0F, 0.0F, 0.0F, 0.0F);
            this.neck1Baby = new ModelRenderer(this, 32, 0);
            this.neck1Baby.setRotationPoint(0.0F, -1.0F, -8.0F);
            this.neck1Baby.addBox(-3.0F, -3.5F, -8.0F, 6.0F, 7.0F, 8.0F, 0.0F, 0.0F, 0.0F);
            this.wingRightBone2Baby = new ModelRenderer(this, 48, 57);
            this.wingRightBone2Baby.setRotationPoint(-24.0F, 0.0F, 0.0F);
            this.wingRightBone2Baby.addBox(-24.0F, -1.5F, -1.5F, 24.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
            this.thighLeftBaby = new ModelRenderer(this, 60, 0);
            this.thighLeftBaby.mirror = true;
            this.thighLeftBaby.setRotationPoint(0.5F, 2.0F, 3.0F);
            this.thighLeftBaby.addBox(0.0F, -1.0F, -3.5F, 5.0F, 8.0F, 7.0F, 0.0F, 0.0F, 0.0F);
            this.tailTipBaby = new ModelRenderer(this, 52, 0);
            this.tailTipBaby.setRotationPoint(0.0F, -1.0F, 26.0F);
            this.tailTipBaby.addBox(-0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 4.0F, 0.0F, 0.0F, 0.0F);
            this.setRotateAngle(tailTipBaby, -0.3490658503988659F, 0.0F, 0.0F);
            this.headBaby = new ModelRenderer(this, 48, 32);
            this.headBaby.setRotationPoint(0.0F, -0.1F, -8.0F);
            this.headBaby.addBox(-2.5F, -2.5F, -8.0F, 5.0F, 5.0F, 8.0F, 0.0F, 0.0F, 0.0F);
            this.beakTopBaby = new ModelRenderer(this, 0, 0);
            this.beakTopBaby.setRotationPoint(0.0F, -2.0F, -7.0F);
            this.beakTopBaby.addBox(-0.5F, -4.0F, 0.0F, 1.0F, 4.0F, 6.0F, 0.0F, 0.0F, 0.0F);
            this.setRotateAngle(beakTopBaby, -0.17453292519943295F, 0.0F, 0.0F);
            this.legRightBaby = new ModelRenderer(this, 111, 32);
            this.legRightBaby.setRotationPoint(-2.5F, 8.0F, 1.0F);
            this.legRightBaby.addBox(-1.5F, -1.0F, -2.5F, 3.0F, 10.0F, 5.0F, 0.0F, 0.0F, 0.0F);
            this.tailLeftBaby = new ModelRenderer(this, 64, 41);
            this.tailLeftBaby.mirror = true;
            this.tailLeftBaby.setRotationPoint(1.0F, 0.0F, 25.0F);
            this.tailLeftBaby.addBox(0.0F, 0.0F, -5.0F, 6.0F, 1.0F, 10.0F, 0.0F, 0.0F, 0.0F);
            this.tail2Baby = new ModelRenderer(this, 18, 40);
            this.tail2Baby.setRotationPoint(0.0F, -0.5F, 18.0F);
            this.tail2Baby.addBox(-1.0F, -1.5F, 0.0F, 2.0F, 3.0F, 26.0F, 0.0F, 0.0F, 0.0F);
            this.bodyBaby = new ModelRenderer(this, 0, 0);
            this.bodyBaby.setRotationPoint(0.0F, 5.0F, 1.0F);
            this.bodyBaby.addBox(-4.0F, -5.0F, -8.0F, 8.0F, 10.0F, 16.0F, 0.0F, 0.0F, 0.0F);
            this.neck2Baby = new ModelRenderer(this, 92, 24);
            this.neck2Baby.setRotationPoint(0.0F, -1.0F, -8.0F);
            this.neck2Baby.addBox(-2.0F, -2.5F, -8.0F, 4.0F, 5.0F, 8.0F, 0.0F, 0.0F, 0.0F);
            this.hipsBaby = new ModelRenderer(this, 66, 0);
            this.hipsBaby.setRotationPoint(0.0F, -1.5F, 8.0F);
            this.hipsBaby.addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 18.0F, 0.0F, 0.0F, 0.0F);
            this.beakBottomBaby = new ModelRenderer(this, 115, 12);
            this.beakBottomBaby.setRotationPoint(0.0F, 2.0F, -6.5F);
            this.beakBottomBaby.addBox(-0.5F, 0.0F, 0.0F, 1.0F, 3.0F, 5.0F, 0.0F, 0.0F, 0.0F);
            this.setRotateAngle(beakBottomBaby, 0.17453292519943295F, 0.0F, 0.0F);
            this.wingRightSkin1Baby = new ModelRenderer(this, -20, 70);
            this.wingRightSkin1Baby.mirror = true;
            this.wingRightSkin1Baby.setRotationPoint(0.0F, 0.0F, 0.0F);
            this.wingRightSkin1Baby.addBox(-24.0F, 0.0F, 2.0F, 24.0F, 0.0F, 24.0F, 0.0F, 0.0F, 0.0F);
            this.bodyBaby.addChild(this.thighRightBaby);
            this.bodyBaby.addChild(this.wingLeftBone1Baby);
            this.tail2Baby.addChild(this.tailRightBaby);
            this.headBaby.addChild(this.jawBaby);
            this.wingLeftBone1Baby.addChild(this.wingLeftSkin1Baby);
            this.bodyBaby.addChild(this.wingRightBone1Baby);
            this.wingLeftBone2Baby.addChild(this.wingLeftSkin2Baby);
            this.wingRightBone2Baby.addChild(this.wingRightSkin1_1Baby);
            this.headBaby.addChild(this.mouthBaby);
            this.wingLeftBone1Baby.addChild(this.wingLeftBone2Baby);
            this.hipsBaby.addChild(this.tail1Baby);
            this.thighLeftBaby.addChild(this.legLeftBaby);
            this.bodyBaby.addChild(this.neck1Baby);
            this.wingRightBone1Baby.addChild(this.wingRightBone2Baby);
            this.bodyBaby.addChild(this.thighLeftBaby);
            this.tail2Baby.addChild(this.tailTipBaby);
            this.neck2Baby.addChild(this.headBaby);
            this.mouthBaby.addChild(this.beakTopBaby);
            this.thighRightBaby.addChild(this.legRightBaby);
            this.tail2Baby.addChild(this.tailLeftBaby);
            this.tail1Baby.addChild(this.tail2Baby);
            this.neck1Baby.addChild(this.neck2Baby);
            this.bodyBaby.addChild(this.hipsBaby);
            this.jawBaby.addChild(this.beakBottomBaby);
            this.wingRightBone1Baby.addChild(this.wingRightSkin1Baby);
        }
    }
}
