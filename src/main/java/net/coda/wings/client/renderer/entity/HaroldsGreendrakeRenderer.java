package net.coda.wings.client.renderer.entity;

import net.coda.wings.client.renderer.entity.layer.HaroldsGreendrakeItemLayer;
import net.coda.wings.client.renderer.entity.model.HaroldsGreendrakeModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.coda.wings.WingsAndClaws;
import net.coda.wings.entity.passive.HaroldsGreendrakeEntity;

public class HaroldsGreendrakeRenderer extends MobRenderer<HaroldsGreendrakeEntity, HaroldsGreendrakeModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(WingsAndClaws.MOD_ID, "textures/entity/harolds_greendrake.png");

    public HaroldsGreendrakeRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new HaroldsGreendrakeModel(), 0.7F);
        addLayer(new HaroldsGreendrakeItemLayer(this));
    }

    public ResourceLocation getEntityTexture(HaroldsGreendrakeEntity entity) {
        return TEXTURE;
    }
}