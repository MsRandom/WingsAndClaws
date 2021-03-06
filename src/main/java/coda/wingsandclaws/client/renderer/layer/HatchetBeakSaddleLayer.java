package coda.wingsandclaws.client.renderer.layer;

import coda.wingsandclaws.client.model.HatchetBeakModel;
import coda.wingsandclaws.entity.HatchetBeakEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import coda.wingsandclaws.WingsAndClaws;

public class HatchetBeakSaddleLayer extends LayerRenderer<HatchetBeakEntity, HatchetBeakModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(WingsAndClaws.MOD_ID, "textures/entity/hatchet_beak/saddle.png");

    public HatchetBeakSaddleLayer(IEntityRenderer<HatchetBeakEntity, HatchetBeakModel> entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, HatchetBeakEntity entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entitylivingbaseIn.hasSaddle()) {
            this.getParentModel().renderToBuffer(matrixStackIn, bufferIn.getBuffer(this.getParentModel().renderType(TEXTURE)), packedLightIn, OverlayTexture.pack(OverlayTexture.u(0), OverlayTexture.v(entitylivingbaseIn.hurtTime > 0 || entitylivingbaseIn.deathTime > 0)), 1, 1, 1, 1);
        }
    }
}
