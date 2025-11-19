package net.teunis.customweaponsmod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.teunis.customweaponsmod.CustomWeaponsMod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CustomWeaponsMod.MOD_ID);

    public static final RegistryObject<Item> DRAGONSLAYER = ITEMS.register("dragonslayer",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> KUBIK = ITEMS.register("kubik",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DENSEIRON = ITEMS.register("denseiron",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
