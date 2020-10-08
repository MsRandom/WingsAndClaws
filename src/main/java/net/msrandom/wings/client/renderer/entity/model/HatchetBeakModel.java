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
    Iterable<ModelRenderer> parts;

    @Override
    public Iterable<ModelRenderer> getParts() {
        return parts;
    }

    @Override
    public void setRotationAngles(HatchetBeakEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entityIn.isFlying()) {
            this.body.rotationPointY = MathHelper.cos(limbSwing * 0.4F + (float) Math.PI) * limbSwingAmount * 0.05F;
            this.body.rotateAngleX = 0.2f;
            this.head.rotateAngleX = 0.1f;
            this.neck1.rotationPointY = MathHelper.cos(limbSwing * 0.4F + (float) Math.PI) * limbSwingAmount * 0.05F;
            this.neck2.rotationPointY = MathHelper.cos(limbSwing * 0.4F + (float) Math.PI) * limbSwingAmount * 0.05F;
            this.head.rotationPointY = MathHelper.cos(limbSwing * 0.4F + (float) Math.PI) * limbSwingAmount * 0.05F;
            this.hips.rotationPointY = MathHelper.cos(limbSwing * 0.4F + (float) Math.PI) * limbSwingAmount * 0.05F;
            this.tail1.rotationPointY = MathHelper.cos(limbSwing * 0.4F + (float) Math.PI) * limbSwingAmount * 0.05F;
            this.tail2.rotationPointY = MathHelper.cos(limbSwing * 0.4F + (float) Math.PI) * limbSwingAmount * 0.05F;
            this.tail1.rotateAngleY = MathHelper.cos(limbSwing * 0.2f) * limbSwingAmount * 0.08f;
            this.tail2.rotateAngleY = MathHelper.cos(limbSwing * 0.3f) * limbSwingAmount * 0.2f;
            this.tail1.rotateAngleX = MathHelper.cos(limbSwing * 0.1f + 0.1f) * limbSwingAmount * 0.05f;
            this.tail2.rotateAngleX = MathHelper.cos(limbSwing * 0.2f + 0.1f) * limbSwingAmount * 0.1f;
            this.tailLeft.rotateAngleZ = -0.8F;
            this.tailRight.rotateAngleZ = 0.8F;
            this.thighLeft.rotationPointY = MathHelper.cos(limbSwing * 0.4F + (float) Math.PI) * limbSwingAmount * -0.1F;
            this.thighRight.rotationPointY = MathHelper.cos(limbSwing * 0.4F + (float) Math.PI) * limbSwingAmount * -0.1F;
            this.thighLeft.rotateAngleX = 0.8F;
            this.thighRight.rotateAngleX = 0.8F;
            float angle = (float) (entityIn.getMotion().getY() * 2f);
            angle = MathHelper.clamp(angle * 1.1f, -0.8f, 0.8f) - 0.1f;
            float offset = MathHelper.clamp(-angle, 0, 0.2f);
            this.wingRightBone1.rotateAngleZ = MathHelper.cos(limbSwing * 0.4F + (float) Math.PI) * angle * 0.45F + offset;
            this.wingRightBone2.rotateAngleZ = MathHelper.cos(limbSwing * 0.4F + (float) Math.PI) * angle * 0.6F + offset * 2;
            this.wingLeftBone1.rotateAngleZ = MathHelper.cos(limbSwing * 0.4F + (float) Math.PI) * angle * -0.45F - offset;
            this.wingLeftBone2.rotateAngleZ = MathHelper.cos(limbSwing * 0.4F + (float) Math.PI) * angle * -0.6F + offset * -2;
            this.wingLeftBone1.rotateAngleX = -0.1f;
            this.wingRightBone1.rotateAngleX = -0.1f;
        } else {
            this.wingRightBone1.rotateAngleZ = -0.65F;
            this.wingRightBone2.rotateAngleZ = 1.7F;
            this.wingLeftBone1.rotateAngleZ = 0.65F;
            this.wingLeftBone2.rotateAngleZ = -1.7F;
            this.thighLeft.rotateAngleX = MathHelper.cos((limbSwing * 0.4F) + (float) Math.PI) * (1.2F) * limbSwingAmount * 0.5F;
            this.thighRight.rotateAngleX = MathHelper.cos((limbSwing * 0.4F) + (float) Math.PI) * (-1.2F) * limbSwingAmount * 0.5F;
            this.tail1.rotateAngleX = MathHelper.cos((limbSwing * 0.4F) + (float) Math.PI) * (0.15F) * limbSwingAmount * 0.5F + 0.2F;
            this.hips.rotateAngleX = MathHelper.cos((limbSwing * 0.4F) + (float) Math.PI) * limbSwingAmount * 0.5F + -0.35F;
            this.tail2.rotateAngleX = MathHelper.cos((limbSwing * 0.4F) + (float) Math.PI) * (0.2F) * limbSwingAmount * 0.5F + 0.2F;
            this.wingRightBone1.rotateAngleY = MathHelper.cos((limbSwing * 0.4F) + (float) Math.PI) * (0.4F) * limbSwingAmount * 0.5F;
            this.wingLeftBone1.rotateAngleY = MathHelper.cos((limbSwing * 0.4F) + (float) Math.PI) * (0.4F) * limbSwingAmount * 0.5F;
            this.body.rotationPointY = MathHelper.cos((limbSwing * 0.4F) + (float) Math.PI) * (0.2F) * limbSwingAmount * 0.5F;
            this.wingLeftBone1.rotationPointY = MathHelper.cos((limbSwing * 0.4F) + (float) Math.PI) * (-0.2F) * limbSwingAmount * 0.5F;
            this.wingRightBone1.rotationPointY = MathHelper.cos((limbSwing * 0.4F) + (float) Math.PI) * (-0.2F) * limbSwingAmount * 0.5F;
            this.thighLeft.rotationPointY = MathHelper.cos((limbSwing * 0.4F) + (float) Math.PI) * (-0.2F) * limbSwingAmount * 0.5F;
            this.thighRight.rotationPointY = MathHelper.cos((limbSwing * 0.4F) + (float) Math.PI) * (-0.2F) * limbSwingAmount * 0.5F;
            this.neck1.rotateAngleX = MathHelper.cos((limbSwing * 0.4F) + (float) Math.PI) * (0.2F) * limbSwingAmount * 0.5F + -0.4F;
            this.neck2.rotateAngleX = MathHelper.cos((limbSwing * 0.4F) + (float) Math.PI) * (0.2F) * limbSwingAmount * 0.5F + 0.1F;
            this.head.rotateAngleX = MathHelper.cos((limbSwing * 0.4F) + (float) Math.PI) * (0.2F) * limbSwingAmount * 0.5F + 0.5F;
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
            this.parts = ImmutableList.of(body);
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
            this.thighRight = new ModelRenderer(this, 60, 0);
            this.thighRight.setRotationPoint(-0.5F, 2.0F, 3.0F);
            this.thighRight.addBox(-5.0F, -1.0F, -3.5F, 5.0F, 8.0F, 7.0F, 0.0F, 0.0F, 0.0F);
            this.wingLeftBone1 = new ModelRenderer(this, 0, 32);
            this.wingLeftBone1.setRotationPoint(3.0F, -2.0F, -5.0F);
            this.wingLeftBone1.addBox(0.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, 0.0F, 0.0F, 0.0F);
            this.tailRight = new ModelRenderer(this, 64, 41);
            this.tailRight.setRotationPoint(-1.0F, 0.0F, 25.0F);
            this.tailRight.addBox(-6.0F, 0.0F, -5.0F, 6.0F, 1.0F, 10.0F, 0.0F, 0.0F, 0.0F);
            this.jaw = new ModelRenderer(this, 89, 37);
            this.jaw.setRotationPoint(0.0F, 0.4F, -8.0F);
            this.jaw.addBox(-1.5F, 0.0F, -6.5F, 3.0F, 2.0F, 7.0F, 0.0F, 0.0F, 0.0F);
            this.wingLeftSkin1 = new ModelRenderer(this, -20, 70);
            this.wingLeftSkin1.setRotationPoint(0.0F, 0.0F, 0.0F);
            this.wingLeftSkin1.addBox(0.0F, 0.0F, 2.0F, 24.0F, 0.0F, 24.0F, 0.0F, 0.0F, 0.0F);
            this.wingRightBone1 = new ModelRenderer(this, 0, 32);
            this.wingRightBone1.setRotationPoint(-3.0F, -2.0F, -5.0F);
            this.wingRightBone1.addBox(-24.0F, -2.0F, -2.0F, 24.0F, 4.0F, 4.0F, 0.0F, 0.0F, 0.0F);
            this.wingLeftSkin2 = new ModelRenderer(this, -20, 100);
            this.wingLeftSkin2.setRotationPoint(0.0F, 0.0F, -1.0F);
            this.wingLeftSkin2.addBox(0.0F, 0.0F, 2.0F, 24.0F, 0.0F, 24.0F, 0.0F, 0.0F, 0.0F);
            this.wingRightSkin1_1 = new ModelRenderer(this, -20, 100);
            this.wingRightSkin1_1.mirror = true;
            this.wingRightSkin1_1.setRotationPoint(0.0F, 0.0F, -1.0F);
            this.wingRightSkin1_1.addBox(-24.0F, 0.0F, 2.0F, 24.0F, 0.0F, 24.0F, 0.0F, 0.0F, 0.0F);
            this.mouth = new ModelRenderer(this, 74, 32);
            this.mouth.setRotationPoint(0.0F, 0.5F, -8.0F);
            this.mouth.addBox(-2.0F, -2.0F, -7.0F, 4.0F, 2.0F, 7.0F, 0.0F, 0.0F, 0.0F);
            this.wingLeftBone2 = new ModelRenderer(this, 48, 57);
            this.wingLeftBone2.setRotationPoint(24.0F, 0.0F, 0.0F);
            this.wingLeftBone2.addBox(0.0F, -1.5F, -1.5F, 24.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
            this.tail1 = new ModelRenderer(this, 0, 40);
            this.tail1.setRotationPoint(0.0F, 0.0F, 18.0F);
            this.tail1.addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 18.0F, 0.0F, 0.0F, 0.0F);
            this.legLeft = new ModelRenderer(this, 111, 32);
            this.legLeft.mirror = true;
            this.legLeft.setRotationPoint(2.5F, 8.0F, 1.0F);
            this.legLeft.addBox(-1.5F, -1.0F, -2.5F, 3.0F, 10.0F, 5.0F, 0.0F, 0.0F, 0.0F);
            this.neck1 = new ModelRenderer(this, 32, 0);
            this.neck1.setRotationPoint(0.0F, -1.0F, -8.0F);
            this.neck1.addBox(-3.0F, -3.5F, -8.0F, 6.0F, 7.0F, 8.0F, 0.0F, 0.0F, 0.0F);
            this.wingRightBone2 = new ModelRenderer(this, 48, 57);
            this.wingRightBone2.setRotationPoint(-24.0F, 0.0F, 0.0F);
            this.wingRightBone2.addBox(-24.0F, -1.5F, -1.5F, 24.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
            this.thighLeft = new ModelRenderer(this, 60, 0);
            this.thighLeft.mirror = true;
            this.thighLeft.setRotationPoint(0.5F, 2.0F, 3.0F);
            this.thighLeft.addBox(0.0F, -1.0F, -3.5F, 5.0F, 8.0F, 7.0F, 0.0F, 0.0F, 0.0F);
            this.tailTip = new ModelRenderer(this, 52, 0);
            this.tailTip.setRotationPoint(0.0F, -1.0F, 26.0F);
            this.tailTip.addBox(-0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 4.0F, 0.0F, 0.0F, 0.0F);
            this.setRotateAngle(tailTip, -0.3490658503988659F, 0.0F, 0.0F);
            this.head = new ModelRenderer(this, 48, 32);
            this.head.setRotationPoint(0.0F, -0.1F, -8.0F);
            this.head.addBox(-2.5F, -2.5F, -8.0F, 5.0F, 5.0F, 8.0F, 0.0F, 0.0F, 0.0F);
            this.beakTop = new ModelRenderer(this, 0, 0);
            this.beakTop.setRotationPoint(0.0F, -2.0F, -7.0F);
            this.beakTop.addBox(-0.5F, -4.0F, 0.0F, 1.0F, 4.0F, 6.0F, 0.0F, 0.0F, 0.0F);
            this.setRotateAngle(beakTop, -0.17453292519943295F, 0.0F, 0.0F);
            this.legRight = new ModelRenderer(this, 111, 32);
            this.legRight.setRotationPoint(-2.5F, 8.0F, 1.0F);
            this.legRight.addBox(-1.5F, -1.0F, -2.5F, 3.0F, 10.0F, 5.0F, 0.0F, 0.0F, 0.0F);
            this.tailLeft = new ModelRenderer(this, 64, 41);
            this.tailLeft.mirror = true;
            this.tailLeft.setRotationPoint(1.0F, 0.0F, 25.0F);
            this.tailLeft.addBox(0.0F, 0.0F, -5.0F, 6.0F, 1.0F, 10.0F, 0.0F, 0.0F, 0.0F);
            this.tail2 = new ModelRenderer(this, 18, 40);
            this.tail2.setRotationPoint(0.0F, -0.5F, 18.0F);
            this.tail2.addBox(-1.0F, -1.5F, 0.0F, 2.0F, 3.0F, 26.0F, 0.0F, 0.0F, 0.0F);
            this.body = new ModelRenderer(this, 0, 0);
            this.body.setRotationPoint(0.0F, 5.0F, 1.0F);
            this.body.addBox(-4.0F, -5.0F, -8.0F, 8.0F, 10.0F, 16.0F, 0.0F, 0.0F, 0.0F);
            this.neck2 = new ModelRenderer(this, 92, 24);
            this.neck2.setRotationPoint(0.0F, -1.0F, -8.0F);
            this.neck2.addBox(-2.0F, -2.5F, -8.0F, 4.0F, 5.0F, 8.0F, 0.0F, 0.0F, 0.0F);
            this.hips = new ModelRenderer(this, 66, 0);
            this.hips.setRotationPoint(0.0F, -1.5F, 8.0F);
            this.hips.addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 18.0F, 0.0F, 0.0F, 0.0F);
            this.beakBottom = new ModelRenderer(this, 115, 12);
            this.beakBottom.setRotationPoint(0.0F, 2.0F, -6.5F);
            this.beakBottom.addBox(-0.5F, 0.0F, 0.0F, 1.0F, 3.0F, 5.0F, 0.0F, 0.0F, 0.0F);
            this.setRotateAngle(beakBottom, 0.17453292519943295F, 0.0F, 0.0F);
            this.wingRightSkin1 = new ModelRenderer(this, -20, 70);
            this.wingRightSkin1.mirror = true;
            this.wingRightSkin1.setRotationPoint(0.0F, 0.0F, 0.0F);
            this.wingRightSkin1.addBox(-24.0F, 0.0F, 2.0F, 24.0F, 0.0F, 24.0F, 0.0F, 0.0F, 0.0F);
            this.parts = ImmutableList.of(body);
            this.body.addChild(this.thighRight);
            this.body.addChild(this.wingLeftBone1);
            this.tail2.addChild(this.tailRight);
            this.head.addChild(this.jaw);
            this.wingLeftBone1.addChild(this.wingLeftSkin1);
            this.body.addChild(this.wingRightBone1);
            this.wingLeftBone2.addChild(this.wingLeftSkin2);
            this.wingRightBone2.addChild(this.wingRightSkin1_1);
            this.head.addChild(this.mouth);
            this.wingLeftBone1.addChild(this.wingLeftBone2);
            this.hips.addChild(this.tail1);
            this.thighLeft.addChild(this.legLeft);
            this.body.addChild(this.neck1);
            this.wingRightBone1.addChild(this.wingRightBone2);
            this.body.addChild(this.thighLeft);
            this.tail2.addChild(this.tailTip);
            this.neck2.addChild(this.head);
            this.mouth.addChild(this.beakTop);
            this.thighRight.addChild(this.legRight);
            this.tail2.addChild(this.tailLeft);
            this.tail1.addChild(this.tail2);
            this.neck1.addChild(this.neck2);
            this.body.addChild(this.hips);
            this.jaw.addChild(this.beakBottom);
            this.wingRightBone1.addChild(this.wingRightSkin1);
        }
    }
}
