package net.teunis.customweaponsmod.entity.client;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.teunis.customweaponsmod.CustomWeaponsMod;
import net.teunis.customweaponsmod.entity.custom.RevenantEntity;

public class RevenantRenderer extends MobRenderer<RevenantEntity, RevenantModel<RevenantEntity>> {
    public RevenantRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new RevenantModel<>(pContext.bakeLayer(ModModelLayers.REVENANT_LAYER)), 2f);
    }

    @Override
    public ResourceLocation getTextureLocation(RevenantEntity pEntity) {
        return new ResourceLocation(CustomWeaponsMod.MOD_ID, "textures/entity/revenant.png");
    }
}
