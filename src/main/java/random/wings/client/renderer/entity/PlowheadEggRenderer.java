package random.wings.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import random.wings.WingsAndClaws;
import random.wings.client.renderer.entity.model.PlowheadEggModel;
import random.wings.entity.item.PlowheadEggEntity;

public class PlowheadEggRenderer extends EntityRenderer<PlowheadEggEntity> implements IEntityRenderer<PlowheadEggEntity, PlowheadEggModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(WingsAndClaws.MOD_ID, "textures/items/icy_plowhead_egg.png");
    private final PlowheadEggModel model = new PlowheadEggModel();

    public PlowheadEggRenderer(EntityRendererManager renderManager) {
        super(renderManager);
    }

    @Override
    public void render(PlowheadEggEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.push();
        getEntityModel().render(matrixStackIn, bufferIn.getBuffer(getEntityModel().getRenderType(getEntityTexture(entityIn))), packedLightIn, OverlayTexture.getPackedUV(OverlayTexture.getU(0), OverlayTexture.getV(false)), 1, 1, 1, 1);
        matrixStackIn.pop();
    }

    @Override
    public ResourceLocation getEntityTexture(PlowheadEggEntity entity) {
        return TEXTURE;
    }

    @Override
    public PlowheadEggModel getEntityModel() {
        return model;
    }
}
