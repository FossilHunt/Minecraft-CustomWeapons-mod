package net.teunis.customweaponsmod.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.teunis.customweaponsmod.CustomWeaponsMod;
import net.teunis.customweaponsmod.entity.ModEntities;
import net.teunis.customweaponsmod.entity.custom.RevenantEntity;

@Mod.EventBusSubscriber(modid = CustomWeaponsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.REVENANT.get(), RevenantEntity.createAttributes().build());
    }
}
