package coda.wingsandclaws.client.model;

import coda.wingsandclaws.entity.IcyPlowheadEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public abstract class IcyPlowheadModel extends SegmentedModel<IcyPlowheadEntity> {
    public ModelRenderer body;
    public ModelRenderer armLeft;
    public ModelRenderer legLeft;
    public ModelRenderer armRight;
    public ModelRenderer legRight;
    public ModelRenderer tail1;
    public ModelRenderer head;
    public ModelRenderer tail2;
    public ModelRenderer tail3;
    public ModelRenderer headLeft;
    public ModelRenderer headRight;
    protected Iterable<ModelRenderer> parts;

    @Override
    public Iterable<ModelRenderer> parts() {
        return parts == null ? parts = ImmutableList.of(body) : parts;
    }

    @Override
    public void setupAnim(IcyPlowheadEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        if (limbSwingAmount < 0.1) {
            this.armLeft.zRot = MathHelper.cos(entityIn.tickCount * 0.03f) * 0.05f;
            this.armRight.zRot = MathHelper.cos(entityIn.tickCount * 0.03f) * -0.05f;
            this.legLeft.zRot = MathHelper.cos(entityIn.tickCount * 0.05f) * -0.05f;
            this.legRight.zRot = MathHelper.cos(entityIn.tickCount * 0.05f) * 0.05f;

            this.armLeft.yRot = MathHelper.cos(entityIn.tickCount * 0.03f) * 0.05f;
            this.armRight.yRot = MathHelper.cos(entityIn.tickCount * 0.03f) * -0.05f;
            this.legLeft.yRot = MathHelper.cos(entityIn.tickCount * 0.03f) * 0.05f;
            this.legRight.yRot = MathHelper.cos(entityIn.tickCount * 0.03f) * -0.05f;

            this.body.yRot = MathHelper.cos(entityIn.tickCount * 0.05f) * 0.03f;
            this.head.yRot = MathHelper.cos(entityIn.tickCount * 0.03f + 0.3f) * 0.04f;
            this.tail1.yRot = MathHelper.cos(entityIn.tickCount * 0.1f + 0.2f) * -0.03f;
            this.tail2.yRot = MathHelper.cos(entityIn.tickCount * 0.05f) * 0.05f;
            this.tail3.yRot = MathHelper.cos(entityIn.tickCount * 0.03f) * -0.06f;
        } else {
            this.body.yRot = MathHelper.cos(limbSwing * 0.4f + (float) Math.PI) * limbSwingAmount * 0.1F;
            this.tail1.yRot = MathHelper.cos(limbSwing * 0.4f + (float) Math.PI) * limbSwingAmount * 0.25F;
            this.tail2.yRot = MathHelper.cos(limbSwing * 0.4f + (float) Math.PI) * limbSwingAmount * 0.35F;
            this.tail3.yRot = MathHelper.cos(limbSwing * 0.4f + (float) Math.PI) * limbSwingAmount * 0.45F;
            this.armLeft.zRot = MathHelper.cos(limbSwing * 0.4f + (float) Math.PI) * limbSwingAmount * 0.75F;
            this.armLeft.yRot = MathHelper.cos(1.0F + limbSwing * 0.4f + (float) Math.PI) * limbSwingAmount;
            this.armRight.zRot = MathHelper.cos(limbSwing * 0.4f + (float) Math.PI) * limbSwingAmount * -0.75F;
            this.armRight.yRot = MathHelper.cos(1.0F + limbSwing * 0.4f + (float) Math.PI) * -limbSwingAmount;
            this.legRight.zRot = MathHelper.cos(limbSwing * 0.4f + (float) Math.PI) * limbSwingAmount * 0.75F;
            this.legRight.yRot = MathHelper.cos(1.0F + limbSwing * 0.4f + (float) Math.PI) * limbSwingAmount + 0.3F;
            this.legLeft.zRot = MathHelper.cos(limbSwing * 0.4f + (float) Math.PI) * limbSwingAmount * -0.75F;
            this.legLeft.yRot = MathHelper.cos(1.0F + limbSwing * 0.4f + (float) Math.PI) * -limbSwingAmount + -0.3F;
            this.head.yRot = MathHelper.cos(limbSwing * 0.4f + (float) Math.PI) * limbSwingAmount * -0.1F;
        }
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }

    public static class Adult extends IcyPlowheadModel {
        public Adult() {
            this.texWidth = 128;
            this.texHeight = 128;
            this.tail1 = new ModelRenderer(this, 0, 83);
            this.tail1.setPos(0.0F, -1.0F, 18.0F);
            this.tail1.addBox(-3.0F, -5.0F, 0.0F, 6, 10, 22, 0.0F);
            this.legRight = new ModelRenderer(this, 50, 0);
            this.legRight.mirror = true;
            this.legRight.setPos(-7.0F, 6.0F, 12.0F);
            this.legRight.addBox(-10.0F, -1.0F, -3.0F, 10, 2, 6, 0.0F);
            this.body = new ModelRenderer(this, 25, 31);
            this.body.setPos(0.0F, 17.0F, 0.0F);
            this.body.addBox(-7.0F, -7.0F, -18.0F, 14, 14, 36, 0.0F);
            this.tail3 = new ModelRenderer(this, 48, -9);
            this.tail3.setPos(0.0F, 0.0F, 22.0F);
            this.tail3.addBox(0.0F, -6.0F, 0.0F, 0, 12, 22, 0.0F);
            this.legLeft = new ModelRenderer(this, 50, 0);
            this.legLeft.setPos(7.0F, 6.0F, 12.0F);
            this.legLeft.addBox(0.0F, -1.0F, -3.0F, 10, 2, 6, 0.0F);
            this.tail2 = new ModelRenderer(this, 58, 87);
            this.tail2.setPos(0.0F, -1.0F, 22.0F);
            this.tail2.addBox(-2.0F, -3.0F, 0.0F, 4, 6, 22, 0.0F);
            this.armRight = new ModelRenderer(this, 0, 53);
            this.armRight.mirror = true;
            this.armRight.setPos(-7.0F, 6.0F, -9.0F);
            this.armRight.addBox(-12.0F, -1.0F, -4.0F, 12, 2, 8, 0.0F);
            this.headLeft = new ModelRenderer(this, 0, 24);
            this.headLeft.mirror = true;
            this.headLeft.setPos(5.0F, -1.5F, -6.0F);
            this.headLeft.addBox(-2.0F, -6.0F, -10.0F, 4, 8, 20, 0.0F);
            this.setRotateAngle(headLeft, 0.2617993877991494F, 0.3490658503988659F, 0.0F);
            this.headRight = new ModelRenderer(this, 0, 24);
            this.headRight.setPos(-5.0F, -1.5F, -6.0F);
            this.headRight.addBox(-2.0F, -6.0F, -10.0F, 4, 8, 20, 0.0F);
            this.setRotateAngle(headRight, 0.2617993877991494F, -0.3490658503988659F, 0.0F);
            this.head = new ModelRenderer(this, 0, 0);
            this.head.setPos(0.0F, 2.0F, -18.0F);
            this.head.addBox(-4.0F, -5.0F, -14.0F, 8, 10, 14, 0.0F);
            this.armLeft = new ModelRenderer(this, 0, 53);
            this.armLeft.setPos(7.0F, 6.0F, -9.0F);
            this.armLeft.addBox(0.0F, -1.0F, -4.0F, 12, 2, 8, 0.0F);
            this.body.addChild(this.tail1);
            this.body.addChild(this.legRight);
            this.tail2.addChild(this.tail3);
            this.body.addChild(this.legLeft);
            this.tail1.addChild(this.tail2);
            this.body.addChild(this.armRight);
            this.head.addChild(this.headLeft);
            this.head.addChild(this.headRight);
            this.body.addChild(this.head);
            this.body.addChild(this.armLeft);
        }
    }

    public static class Child extends IcyPlowheadModel {
        public Child() {
            this.texWidth = 128;
            this.texHeight = 128;
            this.body = new ModelRenderer(this, 0, 0);
            this.body.setPos(0.0F, 19.5F, 0.0F);
            this.body.addBox(-4.5F, -4.5F, -10.0F, 9, 9, 20, 0.0F);
            this.armRight = new ModelRenderer(this, 38, 0);
            this.armRight.mirror = true;
            this.armRight.setPos(-4.5F, 3.5F, -5.0F);
            this.armRight.addBox(-9.0F, -1.0F, -3.0F, 9, 2, 6, 0.0F);
            this.armLeft = new ModelRenderer(this, 38, 0);
            this.armLeft.setPos(4.5F, 3.5F, -5.0F);
            this.armLeft.addBox(0.0F, -1.0F, -3.0F, 9, 2, 6, 0.0F);
            this.headRight = new ModelRenderer(this, 0, 29);
            this.headRight.setPos(-4.5F, -2.5F, -2.0F);
            this.headRight.addBox(-2.0F, -4.0F, -10.0F, 4, 6, 14, 0.0F);
            this.setRotateAngle(headRight, 0.2617993877991494F, -0.3490658503988659F, 0.0F);
            this.head = new ModelRenderer(this, 48, 19);
            this.head.setPos(0.0F, 0.5F, -10.0F);
            this.head.addBox(-3.0F, -4.0F, -10.0F, 6, 8, 10, 0.0F);
            this.legLeft = new ModelRenderer(this, 100, 0);
            this.legLeft.setPos(4.5F, 3.5F, 5.5F);
            this.legLeft.addBox(0.0F, -1.0F, -2.5F, 7, 2, 5, 0.0F);
            this.tail3 = new ModelRenderer(this, 3, 42);
            this.tail3.setPos(0.0F, 0.0F, 16.0F);
            this.tail3.addBox(0.0F, -4.0F, 0.0F, 0, 8, 9, 0.0F);
            this.tail2 = new ModelRenderer(this, 64, 28);
            this.tail2.setPos(0.0F, 0.0F, 16.0F);
            this.tail2.addBox(-1.0F, -2.0F, 0.0F, 2, 4, 16, 0.0F);
            this.headLeft = new ModelRenderer(this, 0, 29);
            this.headLeft.setPos(4.5F, -2.5F, -2.0F);
            this.headLeft.addBox(-2.0F, -4.0F, -10.0F, 4, 6, 14, 0.0F);
            this.setRotateAngle(headLeft, 0.2617993877991494F, 0.3490658503988659F, 0.0F);
            this.legRight = new ModelRenderer(this, 100, 0);
            this.legRight.mirror = true;
            this.legRight.setPos(-4.5F, 3.5F, 5.5F);
            this.legRight.addBox(-7.0F, -1.0F, -2.5F, 7, 2, 5, 0.0F);
            this.tail1 = new ModelRenderer(this, 76, 0);
            this.tail1.setPos(0.0F, -0.5F, 10.0F);
            this.tail1.addBox(-2.0F, -3.0F, 0.0F, 4, 6, 16, 0.0F);
            this.body.addChild(this.armRight);
            this.body.addChild(this.armLeft);
            this.head.addChild(this.headRight);
            this.body.addChild(this.head);
            this.body.addChild(this.legLeft);
            this.tail2.addChild(this.tail3);
            this.tail1.addChild(this.tail2);
            this.head.addChild(this.headLeft);
            this.body.addChild(this.legRight);
            this.body.addChild(this.tail1);
        }
    }
}
