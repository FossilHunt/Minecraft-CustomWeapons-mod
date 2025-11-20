package net.teunis.customweaponsmod.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.teunis.customweaponsmod.CustomWeaponsMod;
import net.teunis.customweaponsmod.entity.custom.RevenantEntity;

import javax.swing.text.html.parser.Entity;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CustomWeaponsMod.MOD_ID);

    public static final RegistryObject<EntityType<RevenantEntity>> REVENANT =
            ENTITY_TYPES.register("revenant", () -> EntityType.Builder.of(RevenantEntity::new, MobCategory.CREATURE)
                    .sized(1.0f, 2.5f).build("revenant"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
