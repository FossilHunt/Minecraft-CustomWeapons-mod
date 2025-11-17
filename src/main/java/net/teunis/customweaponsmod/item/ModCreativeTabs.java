package net.teunis.customweaponsmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.teunis.customweaponsmod.CustomWeaponsMod;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CustomWeaponsMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> WEAPONS_TAB = CREATIVE_MODE_TABS.register("weapons_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.DRAGONSLAYER.get()))
                    .title(Component.translatable("creativetab.weapons_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.DRAGONSLAYER.get());
                        pOutput.accept(ModItems.KUBIK.get());
                        pOutput.accept(Items.NETHERITE_INGOT);
                    })
                    .build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
